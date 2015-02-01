package com.rapidminer.operator.modelling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import com.rapidminer.example.ExampleSet;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.operator.modelling.adapters.MLNInferenceAdapter;
import com.rapidminer.operator.modelling.configuration.MLNEngine;
import com.rapidminer.operator.modelling.configuration.MLNFileType;
import com.rapidminer.operator.modelling.configuration.MLNOptionalParameter;
import com.rapidminer.operator.modelling.configuration.fixed.MLNError;
import com.rapidminer.operator.modelling.configuration.fixed.MLNException;
import com.rapidminer.operator.modelling.configuration.fixed.MLNFileRole;
import com.rapidminer.operator.modelling.configuration.fixed.MLNInferenceType;
import com.rapidminer.operator.modelling.converters.MLNConverter;
import com.rapidminer.operator.modelling.converters.exampleset.model.ExampleSetType;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduceException;
import com.rapidminer.operator.modelling.converters.utilities.varweights.MLNVariableWeightsRemover;
import com.rapidminer.operator.modelling.model.MLNClosedWorldType;
import com.rapidminer.operator.modelling.model.MLNGroundAtom;
import com.rapidminer.operator.modelling.model.MLNGroundFormula;
import com.rapidminer.operator.modelling.model.MLNModel;
import com.rapidminer.operator.modelling.model.MLNPredicate;
import com.rapidminer.operator.modelling.model.MLNProbabilityStatement;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.parameter.ParameterType;
import com.rapidminer.parameter.ParameterTypeCategory;
import com.rapidminer.parameter.ParameterTypeInt;
import com.rapidminer.parameter.ParameterTypeList;
import com.rapidminer.parameter.ParameterTypeString;

/**
 * Defines a RapidMiner operator providing MLN inference functionality.
 * 
 * @author Yann Kiraly
 *
 */
public class MLNInferOperator extends MLNLearnInferOperator{
	public static final String QUERY_ATOMS = "Query Atoms";
	public static final String INFERENCE_TYPE = "Type of Inference";
	public static final String PARTIAL_QUERY_ATOM_KEY_TYPE = "partial query atom key";
	public static final String PARTIAL_QUERY_ATOM_VALUE_TYPE = "partial query atom value";
	public static final String FULL_QUERY_ATOM_KEY_TYPE = "partial query atom key";
	public static final String FULL_QUERY_ATOM_VALUE_TYPE = "partial query atom value";
	protected LinkedHashMap<ExampleSetType, OutputPort> outputPortMap;
	protected String evidenceFilePath;
	protected String ruleFilePath;
	
	private List<ParameterType> optionalParameters;
	
	/**
	 * Passes on an OperatorDescription to the Operator constructor.
	 * 
	 * @param description: OperatorDescription RapidMiner requires to be accepted by all operator classes.
	 * @throws OperatorException
	 */
	public MLNInferOperator(OperatorDescription description) throws OperatorException{
		super(description);
		initializeOutputPortMap();
	}
	
	private void initializeOutputPortMap() {
		OutputPort port;
		outputPortMap = new LinkedHashMap<ExampleSetType, OutputPort>();
		for (ExampleSetType type: MLNFileRole.INFERENCE_RESULT.getExampleSetTypes()) {
			port = getOutputPorts()
					.createPort(type.getTitle()+OUTPUT_PORT_EXTENSION);
			getOutputPortMap().put(type, port);
			getTransformer().addGenerationRule(port, ExampleSet.class);
		}
	}
	
	@Override
	protected LinkedHashMap<ExampleSetType, InputPort> initializeAdditionalInputPorts()
			throws OperatorException {
		InputPort port;
		LinkedHashMap<ExampleSetType, InputPort> inputPortMap = new LinkedHashMap<ExampleSetType, InputPort>();
		for (ExampleSetType type : MLNFileRole.QUERY.getExampleSetTypes()) {
			port = getInputPorts().createPort(MLNFileRole.QUERY.getKey()+" "+type.getTitle());
			inputPortMap.put(type,  port);
		}
		return inputPortMap;
	}
	
	/**
	 * Defines inference operator parameters.
	 * <p>
	 * Defines the following parameters:
	 * 		MLN engine parameter.
	 * 		Inference type parameter.
	 * 		Partial query atom parameter.
	 * 		Full query atom parameter.
	 * 	In addition, it creates optional inference parameters from OptionalParameterSpecifications.xml.
	 * These parameters are conditioned on the MLN engine parameter.
	 */
	@Override
	public List<ParameterType> getParameterTypes() {
		try {
			loadOptionalParameterConfiguration(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<ParameterType> types = new ArrayList<ParameterType>();
		String[] engineCategories = getInferenceEngineCategories();
		String[] inferenceCategories = getInferenceCategories();
		ParameterTypeCategory engine = new ParameterTypeCategory(ENGINE, 
				"This parameter indicates what inference engine is to be used.",engineCategories,0);
		engine.setOptional(false);
		ParameterTypeCategory inferenceType = new ParameterTypeCategory(INFERENCE_TYPE, 
				"This parameter indicates what type of inference is to be performed.", inferenceCategories, 0);
		inferenceType.setOptional(false);
		ParameterTypeList queryAtomsParameter = new ParameterTypeList(QUERY_ATOMS, 
				"This parameter contains partial query atoms.",
				new ParameterTypeInt(PARTIAL_QUERY_ATOM_KEY_TYPE, "Key", MLNOperator.MIN_LIST_KEY, MLNOperator.MAX_LIST_KEY), 
				new ParameterTypeString(PARTIAL_QUERY_ATOM_VALUE_TYPE, "Value"));
		queryAtomsParameter.setOptional(true);
		queryAtomsParameter.setExpert(false);
		types.add(engine);
		types.add(inferenceType);
		types.add(queryAtomsParameter);
		types.addAll(super.getParameterTypes());
		try {
			optionalParameters = buildOptionalParameters();
			types.addAll(optionalParameters);
		} catch (OperatorException e) {
		}
		return types;
	}
	
	private String[] getInferenceCategories() {
		MLNInferenceType[] values = MLNInferenceType.values();
		String[] keys = new String[values.length];
		for (int counter = 0; counter < values.length; counter++) {
			keys[counter] = values[counter].getKey();
		}
		return keys;
	}
	
	/**
	 * Performs inference on the MLN data provided through its input ports
	 * and produces example sets of the output.
	 * <p>
	 * Accepts rule file, evidence file and query file data in ExampleSet form on its input ports.
	 * Converts these into an MLN model. This model is then converted into an MLN file using an appropriate 
	 * MLN converter for the inference engine selected in the engine parameter.
	 * This file is then provided to an MLN inference adapter along with the parameters selected on the operator.
	 */
	@Override
	public void doWork() throws OperatorException {
		LinkedHashMap<ExampleSetType, ExampleSet> exampleSetMap = new LinkedHashMap<ExampleSetType, ExampleSet>();
		MLNConverter converter, esConverter;
		MLNModel targetModel, ruleModel, queryModel;
		List<MLNModel> evidenceModels;
		clearEvidenceFilePaths();
		MLNEngine engine = getRequiredEngine();
		if ((evidencePorts.getManagedPorts().size()==1) || (engine.getMultipleEvidenceFilesInference())) {
			ruleModel = buildMLNModel(getInputDataForRole(MLNFileRole.RULES), MLNFileRole.RULES);
			Double id = ruleModel.getId();
			queryModel = buildMLNModel(getInputDataForRole(MLNFileRole.QUERY), MLNFileRole.QUERY);
			evidenceModels = buildEvidenceMLNModels();
			List<String> queryAtomNames = getQueryAtoms();
			if (ruleModel.containsVariableWeights() && !(engine.getVariableWeights().equals("Inference")
					|| engine.getVariableWeights().equals("Both"))) {
				throw new OperatorException(MLNError.VAR_WEIGHTS_INF.getMessage());
			} else {
				if (!getRequiredEngine().supportsPlusNotation())
					(new MLNVariableWeightsRemover(ruleModel, evidenceModels)).expandPlusVariables();
				queryAtomNames = processQueryAtoms(getParameterAsBoolean(ACCEPT_QUERY_ATOMS), queryAtomNames, ruleModel, queryModel);
				generateInputFiles(ruleModel, queryModel, evidenceModels,
						getParameterAsBoolean(CONVERT_LE_CONSTRAINTS), getParameterAsBoolean(REMOVE_UNSUP_CONST),
						getParameterAsBoolean(CONVERT_EXCL_CONST));
				String outputPath = getOutputFilePath();
				try {
					MLNInferenceAdapter adapter = MLNInferenceAdapter.getAdapterForEngine(engine);
					MLNFileType fileType = (MLNEngine
							.fromKey(getParameterAsString(ENGINE))).getFileType();
					adapter.setInputFile(getRuleFilePath());
					for (String path: getEvidenceFilePaths()) {
						adapter.addEvidenceFile(path);
					}
					adapter.setOutputFile(outputPath);
					provideOptionalParameters(adapter, false, true);
					if (fileType.isQueryAtomFileType())
						adapter.setQueryFile(getQueryFilePath());
					adapter.setInferenceType(getRequiredInferenceType());
					adapter.setQueryAtoms(queryAtomNames);
					adapter.perform();
					converter = MLNConverter.getConverterForFileType(fileType, 
							new FileInputStream(outputPath));
					targetModel = converter.buildModel(MLNFileRole.INFERENCE_RESULT);
					if (getRequiredInferenceType().getKey().equals(MLNInferenceType.MAP.getKey()))
						harmonizeInferenceResults(ruleModel, evidenceModels, targetModel);
					esConverter = MLNConverter.getConverterForExampleSets(null, exampleSetMap);
					targetModel.setId(id);
					esConverter.convertModel(targetModel, MLNFileRole.INFERENCE_RESULT);
					deliverOutput(exampleSetMap, MLNFileRole.INFERENCE_RESULT);
				} catch (FileNotFoundException e) {
					throw new OperatorException(e.getMessage());
				} catch (MLNException e) {
					throw new OperatorException(e.getMessage());
				}
			}
		} else {
			throw new OperatorException(MULTIPLE_FILES_NOT_SUPPORTED);
		}
	}
	
	protected void generateInputFiles(MLNModel ruleModel, MLNModel queryModel, List<MLNModel> evidenceModels,
			boolean convertLEconstraints, boolean removeUnsupportedConstraints, boolean convertExclConstraints) 
			throws OperatorException {
		MLNFileType fileType = getRequiredFileType();
		generatePaths(evidenceModels.size());
		generateFiles(getEvidenceFilePaths(), evidenceModels, fileType, MLNFileRole.EVIDENCE, convertLEconstraints,
				removeUnsupportedConstraints, convertExclConstraints);
		generateFile(getRuleFilePath(), ruleModel, fileType, MLNFileRole.RULES, convertLEconstraints,
				removeUnsupportedConstraints, convertExclConstraints);
		if ((fileType.isQueryAtomFileType()) && queryModel != null)
			generateFile(getQueryFilePath(), queryModel, fileType, MLNFileRole.QUERY, convertLEconstraints,
					removeUnsupportedConstraints, convertExclConstraints);
	}
	
	private void generatePaths(int evidenceModelCount) throws OperatorException {
		String path = generateTempFilename(this);
		
		setRuleFilePath(setEnding(insertText(path, RULE_FILE_EXTENSION), RULE_FILE_ENDING));
		for (int counter = 0; counter < evidenceModelCount; counter++) {
			addEvidenceFilePath(setEnding(insertText(path, EVIDENCE_FILE_EXTENSION+"_"+counter+"_"),  EVIDENCE_FILE_ENDING));
		}
		setQueryFilePath(setEnding(insertText(path, QUERY_FILE_EXTENSION), QUERY_FILE_ENDING));
		setOutputFilePath(setEnding(insertText(path, OUTPUT_FILE_EXTENSION), OUT_FILE_ENDING));
	}
	
	private void harmonizeInferenceResults(MLNModel ruleModel, List<MLNModel> evidenceModels,
			MLNModel targetModel) throws OperatorException {
		List<MLNGroundAtom> atoms = new ArrayList<MLNGroundAtom>();
		List<MLNGroundFormula> groundFormulas = new ArrayList<MLNGroundFormula>();
		for (MLNModel model : evidenceModels) {
			groundFormulas.addAll(model.getAll(MLNGroundFormula.class));
		}
		List<MLNPredicate> queryPredicates = ruleModel.getPredicatesForClosedWorldType(
				MLNClosedWorldType.Query);
		List<MLNProbabilityStatement> statementsToRemove;
		Iterator<MLNGroundAtom> atomIterator;
		for (MLNGroundFormula formula: groundFormulas) {
			for (MLNPredicate queryPredicate : queryPredicates) {
				if ((formula.getGroundAtom()!=null) &&
						(formula.getGroundAtom().getPredicate().contentEquals(queryPredicate, false))) {
					atoms.add(formula.getGroundAtom());
				}
			}
		}
		
		statementsToRemove = new ArrayList<MLNProbabilityStatement>();
		for (MLNProbabilityStatement statement: targetModel.getAll(MLNProbabilityStatement.class)) {
			if (statement.getProbability() == null) {
				statement.setProbability(1.0);
			}
			atomIterator = atoms.iterator();
			while (atomIterator.hasNext()) {
				MLNGroundAtom nextAtom = atomIterator.next();
				if (statement.getGroundFormula().getGroundAtom().contentEquals(nextAtom, false)) {
					atomIterator.remove();
				}
			}
		}
		
		for (MLNProbabilityStatement statementToRemove: statementsToRemove) {
			targetModel.removeMlnObject(statementToRemove);
		}
		

//		for (MLNGroundAtom atom: atoms) {
//			targetModel.buildMLNProbabilityStatement(
//					targetModel.buildMLNGroundFormula(
//							targetModel.addMlnObject(atom)), 1.0);
//		}
		
	}
	
	private String[] getInferenceEngineCategories() {
		MLNEngine[] values = MLNEngine.values();
		List<String> categories = new ArrayList<String>();
		for (int engineCounter = 0; engineCounter<values.length; engineCounter++) {
			if (!values[engineCounter].getSupportedInferenceTypes().isEmpty()) {
				categories.add(values[engineCounter].getKey());
			}
		}
		return categories.toArray(new String[categories.size()]);
	}
	
	protected List<String> getQueryAtoms() throws OperatorException{
		List<String[]> pl = getParameterList(QUERY_ATOMS);
		List<String> l;
		if (pl.size()>0) {
			l = buildListFromKeyValuePairs(pl,1);
		} else {
			l = null;
		}
		return l;
	}
	
	protected MLNInferenceType getRequiredInferenceType() throws OperatorException {
		return MLNInferenceType.fromKey(getParameterAsString(INFERENCE_TYPE));
	}

	@Override
	protected MLNFileType getRequiredFileType() throws OperatorException {
		return getRequiredEngine().getFileType();
	}
	
	@Override
	protected MLNEngine getRequiredEngine() throws OperatorException {
		return MLNEngine.fromKey(getParameterAsString(ENGINE));
	}
	
	
	@Override
	protected String getRuleFilePath() {
		return ruleFilePath;
		
	}
	
	@Override
	protected void setRuleFilePath(String path) {
		ruleFilePath = path;
	}

	@Override
	protected LinkedHashMap<ExampleSetType, OutputPort> getOutputPortMap() {
		return outputPortMap;
	}
	
	private List<ParameterType> buildOptionalParameters() throws OperatorException {
		List<ParameterType> types = new ArrayList<ParameterType>();
		for (MLNOptionalParameter parameter: MLNOptionalParameter.values()) {
			if (parameter.isInferenceArgument()) {
				try {
					ParameterType type = MLNOptionalParameter.buildParameterType(this,parameter);
					types.add(type);
				} catch (MapReduceException e) {
					throw new OperatorException(e.getMessage());
				}
			}
		}
		return types;
	}
	
}
