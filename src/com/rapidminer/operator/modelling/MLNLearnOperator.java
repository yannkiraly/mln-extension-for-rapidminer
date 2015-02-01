package com.rapidminer.operator.modelling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.rapidminer.example.ExampleSet;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.operator.modelling.adapters.MLNLearningAdapter;
import com.rapidminer.operator.modelling.configuration.MLNEngine;
import com.rapidminer.operator.modelling.configuration.MLNFileType;
import com.rapidminer.operator.modelling.configuration.MLNOptionalParameter;
import com.rapidminer.operator.modelling.configuration.fixed.MLNError;
import com.rapidminer.operator.modelling.configuration.fixed.MLNException;
import com.rapidminer.operator.modelling.configuration.fixed.MLNFileRole;
import com.rapidminer.operator.modelling.configuration.fixed.MLNLearningType;
import com.rapidminer.operator.modelling.converters.MLNConverter;
import com.rapidminer.operator.modelling.converters.exampleset.model.ExampleSetType;
import com.rapidminer.operator.modelling.converters.utilities.cnf.CNFConverter;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduceException;
import com.rapidminer.operator.modelling.converters.utilities.varweights.MLNVariableWeightsRemover;
import com.rapidminer.operator.modelling.model.MLNClosedWorldType;
import com.rapidminer.operator.modelling.model.MLNModel;
import com.rapidminer.operator.modelling.model.MLNPredicate;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.parameter.ParameterType;
import com.rapidminer.parameter.ParameterTypeBoolean;
import com.rapidminer.parameter.ParameterTypeCategory;
import com.rapidminer.parameter.ParameterTypeInt;
import com.rapidminer.parameter.ParameterTypeList;
import com.rapidminer.parameter.ParameterTypeString;

/**
 * Defines a RapidMiner operator providing MLN weight learning functionality.
 * 
 * @author Yann Kiraly
 *
 */
public class MLNLearnOperator extends MLNLearnInferOperator {
	protected static final String LEARNING_TYPE = "Learning Method";
	protected static final String NON_EVIDENCE_PREDICATES = "Non-evidence Predicates";
	protected static final String NE_PREDICATE_KEY_TYPE = "Non-evidence Predicate Key Type";
	protected static final String NE_PREDICATE_VALUE_TYPE = "Non-evidence Predicate Value Type";
	protected static final String NON_EVIDENCE = "Ne";
	protected static final String IGNORE_VAR_WEIGHTS = "Ignore variable weights";
	protected static final String RESTORE_CWS = "Restore closed-world state";
	protected static final String TRANSFER_WEIGHTS = "Transfer weights to original model";
	
	private LinkedHashMap<ExampleSetType, OutputPort> outputPortMap;
	
	public MLNLearnOperator(OperatorDescription description) throws OperatorException{
		super(description);
		initializeOutputPortMap();
	}
	
	private void initializeOutputPortMap() {
		OutputPort port;
		outputPortMap = new LinkedHashMap<ExampleSetType, OutputPort>();
		for (ExampleSetType type: MLNFileRole.RULES.getExampleSetTypes()) {
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
			port = getInputPorts().createPort(NON_EVIDENCE+" "+type.getTitle());
			inputPortMap.put(type,  port);
			//setRolePreconditions(MLNFileRole.QUERY, ExampleSet.class, NOT_MANDATORY, port);
		}
		return inputPortMap;
	}
	
	/**
	 * Defines learn operator parameters.
	 * <p>
	 * Defines the following parameters:
	 * 		MLN engine parameter.
	 * 		Learning type parameter.
	 * 		Non-evidence predicate parameter.
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
		String[] engineCategories = getLearningEngineCategories();
		String[] learningCategoriesBoth = {MLNLearningType.GENERATIVE.getKey(), 
				MLNLearningType.DISCRIMINATIVE.getKey()};
		ParameterTypeCategory engine = new ParameterTypeCategory(ENGINE,
				"This parameter indicates what learning engine is to be used.",engineCategories,0);
		engine.setOptional(false);
		ParameterTypeCategory learningType = new ParameterTypeCategory(LEARNING_TYPE, 
				"This parameter indicates what type of learning is to be performed.", learningCategoriesBoth, 0);
		learningType.setOptional(false);
		ParameterTypeList nonEvidencePredicates = new ParameterTypeList(NON_EVIDENCE_PREDICATES, 
				"This parameter contains the predicates which are to be treated as non-evidence.",
				new ParameterTypeInt(NE_PREDICATE_KEY_TYPE, "Key", MLNOperator.MIN_LIST_KEY, MLNOperator.MAX_LIST_KEY), 
				new ParameterTypeString(NE_PREDICATE_VALUE_TYPE, "Value"));
		nonEvidencePredicates.setOptional(true);
		nonEvidencePredicates.setExpert(false);
		ParameterTypeBoolean restoreClosedWorldState = new ParameterTypeBoolean(RESTORE_CWS,
				"Reset the closed-world state of the predicates to their pre-learning state.", false);
		restoreClosedWorldState.setOptional(true);
		restoreClosedWorldState.setExpert(false);
//		ParameterTypeBoolean ignoreVariableWeightFormulas = new ParameterTypeBoolean(IGNORE_VAR_WEIGHTS, 
//				"Ignore variable weight formulas while learning.", false, true);
		ParameterTypeBoolean transferWeights = new ParameterTypeBoolean(TRANSFER_WEIGHTS,
				"Transfer weights to previous model", false);
		transferWeights.setOptional(true);
		transferWeights.setExpert(true);
		types.add(engine);
		types.add(learningType);
		types.add(nonEvidencePredicates);
//		types.add(ignoreVariableWeightFormulas);
		types.add(restoreClosedWorldState);
		types.add(transferWeights);
		types.addAll(super.getParameterTypes());
		try {
			types.addAll(buildOptionalParameters());
		} catch (OperatorException e) {
		}
		return types;
	}
	
	/**
	 * Learn weights from the MLN data provided through its input ports
	 * and produces example sets of the output.
	 * <p>
	 * Accepts rule file, evidence file and non-evidence predicate file data in ExampleSet form on its input ports.
	 * Converts these into an MLN model. This model is then converted into an MLN file using an appropriate 
	 * MLN converter for the learning engine selected in the engine parameter.
	 * This file is then provided to an MLN learning adapter along with the parameters selected on the operator.
	 */
	@Override
	public void doWork() throws OperatorException{
		if ((evidencePorts.getManagedPorts().size()>1) || (getRequiredEngine().getMultipleEvidenceFilesLearning())) { 
			MLNModel ruleModel = buildRuleMLNModel(), 
					nonEvidenceModel = buildMLNModel(getInputDataForRole(MLNFileRole.QUERY),MLNFileRole.QUERY), targetModel;
			Double id = ruleModel.getId();
			if (ruleModel.containsVariableWeights() && !(getRequiredEngine().getVariableWeights().equals("Learning") ||
					getRequiredEngine().getVariableWeights().equals("Both"))) {
				throw new OperatorException(MLNError.VAR_WEIGHTS_LEARN.getMessage());
			} else {
				List<MLNModel> evidenceModels = buildEvidenceMLNModels();
				if (!getRequiredEngine().supportsPlusNotation())
					(new MLNVariableWeightsRemover(ruleModel, evidenceModels)).expandPlusVariables();
				clearEvidenceFilePaths();
				try {
					ruleModel.removeUnusedPredicates();
					MLNConverter converter, esConverter;
					LinkedHashMap<ExampleSetType, ExampleSet> exampleSetMap = new LinkedHashMap<ExampleSetType, ExampleSet>();
					List<String> nonEvidenceAtomNames = this.getNonEvidencePredicates();
					Map<String, MLNClosedWorldType> predicateState = recordPredicateState(ruleModel);
					nonEvidenceAtomNames = processQueryAtoms(getParameterAsBoolean(ACCEPT_QUERY_ATOMS), nonEvidenceAtomNames, ruleModel, nonEvidenceModel);
					generateInputFiles(ruleModel, nonEvidenceModel, evidenceModels,
							getParameterAsBoolean(CONVERT_LE_CONSTRAINTS), getParameterAsBoolean(REMOVE_UNSUP_CONST),
							getParameterAsBoolean(CONVERT_EXCL_CONST));
					MLNLearningAdapter adapter = getRequiredAdapter();
					adapter.setInputFile(getRuleFilePath());
					for (String path : getEvidenceFilePaths())
						adapter.addEvidenceFile(path);
					adapter.setOutputFile(getOutputFilePath());
					adapter.setLearningType(getRequiredLearningType());
					adapter.setNonEvidencePredicates(nonEvidenceAtomNames);
					if (getRequiredFileType().isNonEvidenceAtomFileType())
						adapter.setNonEvidenceFile(getQueryFilePath());
					provideOptionalParameters(adapter, true, false);
					adapter.perform();
					converter = MLNConverter.getConverterForFileType(getRequiredFileType(), 
							new FileInputStream(getOutputFilePath()), null);
					esConverter = MLNConverter.getConverterForExampleSets(null, exampleSetMap);
					targetModel = converter.buildModel(MLNFileRole.RULES);
					if (getParameterAsBoolean(TRANSFER_WEIGHTS)) {
						CNFConverter.convertModelToCNF(ruleModel);
						ruleModel.transferWeights(targetModel, !getParameterAsBoolean(CONVERT_LE_CONSTRAINTS));
					} else {
						ruleModel = targetModel;
					}
					if (getParameterAsBoolean(RESTORE_CWS))
						reapplyPredicateState(ruleModel, predicateState);
					ruleModel.setId(id);
					esConverter.convertModel(ruleModel, MLNFileRole.RULES);
					deliverOutput(exampleSetMap, MLNFileRole.RULES);
				} catch (MLNException e) {
					throw new OperatorException(e.getMessage(), e);
				} catch (FileNotFoundException e) {
					throw new OperatorException(e.getMessage(), e);
				} 
			}
		} else {
			throw new OperatorException(MULTIPLE_FILES_NOT_SUPPORTED);
		}
	}
	
	private Map<String, MLNClosedWorldType> recordPredicateState(MLNModel model) {
		Map<String, MLNClosedWorldType> map = new HashMap<String, MLNClosedWorldType>();
		for (MLNPredicate predicate: model.getAll(MLNPredicate.class)) {
			map.put(predicate.getName(), predicate.getClosedWorldType());
		}
		return map;
	}
	
	private void reapplyPredicateState(MLNModel model, Map<String, MLNClosedWorldType> map) {
		MLNPredicate pred;
		for (Map.Entry<String, MLNClosedWorldType> entry: map.entrySet()) {
			if ((pred = model.getForNameNoCreation(MLNPredicate.class, entry.getKey()))!=null) {
				pred.setClosedWorldType(entry.getValue());
			}
		}
	}
	
	protected void generateInputFiles(MLNModel ruleModel, MLNModel nonEvidenceModel,
			List<MLNModel> evidenceModels, boolean convertLEconstraints,
			boolean removeUnsupportedConstraints, boolean convertExclConstraints) throws OperatorException {
		MLNFileType fileType = getRequiredFileType();
		generatePaths(evidenceModels.size());
		generateFile(getRuleFilePath(),ruleModel, fileType, MLNFileRole.RULES, convertLEconstraints,
				removeUnsupportedConstraints, convertExclConstraints);
		generateFiles(getEvidenceFilePaths(), evidenceModels, fileType, MLNFileRole.EVIDENCE, convertLEconstraints,
				removeUnsupportedConstraints, convertExclConstraints);
		if (fileType.isNonEvidenceAtomFileType())
			generateFile(getQueryFilePath(), nonEvidenceModel, fileType, MLNFileRole.QUERY, convertLEconstraints,
					removeUnsupportedConstraints, convertExclConstraints);

	}
	
	private void generatePaths(int numberOfEvidenceFiles) throws OperatorException {
		String path = generateTempFilename(this);
		setRuleFilePath(setEnding(insertText(path, RULE_FILE_EXTENSION), RULE_FILE_ENDING));
		for (int counter = 0; counter < numberOfEvidenceFiles; counter++)
			addEvidenceFilePath(setEnding(insertText(path, EVIDENCE_FILE_EXTENSION+"_"+counter+"_"),  EVIDENCE_FILE_ENDING));
		setQueryFilePath(setEnding(insertText(path, QUERY_FILE_EXTENSION), QUERY_FILE_ENDING));
		setOutputFilePath(setEnding(insertText(path, OUTPUT_FILE_EXTENSION), OUT_FILE_ENDING));
	}
	
	private List<String> getNonEvidencePredicates() throws OperatorException {
		List<String[]> pl = getParameterList(NON_EVIDENCE_PREDICATES);
		List<String> l = buildListFromKeyValuePairs(pl,1);
		return l;
	}
	
	protected String getOutputFileExtension() {
		return OUTPUT_FILE_EXTENSION;
	}
	
	
	
	@Override
	protected MLNFileType getRequiredFileType() throws OperatorException{
		return getRequiredEngine().getFileType();
	}
	
	@Override
	protected MLNEngine getRequiredEngine() throws OperatorException {
		return MLNEngine.fromKey(getParameterAsString(ENGINE));
	}
	
	protected MLNLearningType getRequiredLearningType() throws OperatorException {
		return MLNLearningType.fromKey(getParameterAsString(LEARNING_TYPE));
	}
	
	protected MLNLearningAdapter getRequiredAdapter() throws OperatorException {
		return MLNLearningAdapter.getAdapterForEngine(getRequiredEngine());
	}
	
	private String[] getLearningEngineCategories() {
		MLNEngine[] values = MLNEngine.values();
		List<String> categories = new ArrayList<String>();
		for (int engineCounter = 0; engineCounter<values.length; engineCounter++) {
			if (!values[engineCounter].getSupportedLearningTypes().isEmpty()) {
				categories.add(values[engineCounter].getKey());
			}
		}
		return categories.toArray(new String[categories.size()]);
	}

	@Override
	protected LinkedHashMap<ExampleSetType, OutputPort> getOutputPortMap() {
		return outputPortMap;
	}
	
	private List<ParameterType> buildOptionalParameters() throws OperatorException {
		List<ParameterType> types = new ArrayList<ParameterType>();
		for (MLNOptionalParameter parameter: MLNOptionalParameter.values()) {
			if (parameter.isLearnArgument()) {
				try {
					types.add(MLNOptionalParameter.buildParameterType(this, parameter));
				} catch (MapReduceException e) {
					throw new OperatorException(e.getMessage());
				}
			}
		}
		return types;
	}
}
