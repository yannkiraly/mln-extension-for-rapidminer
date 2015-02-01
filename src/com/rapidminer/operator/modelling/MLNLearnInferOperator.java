package com.rapidminer.operator.modelling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.rapidminer.condition.mln.InListParameterCondition;
import com.rapidminer.example.ExampleSet;
import com.rapidminer.example.ExampleSetFactory;
import com.rapidminer.operator.IOObject;
import com.rapidminer.operator.Operator;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.operator.modelling.adapters.MLNAbstractAdapter;
import com.rapidminer.operator.modelling.configuration.MLNEngine;
import com.rapidminer.operator.modelling.configuration.MLNFileType;
import com.rapidminer.operator.modelling.configuration.MLNGeneralParameter;
import com.rapidminer.operator.modelling.configuration.MLNOptionalParameter;
import com.rapidminer.operator.modelling.configuration.fixed.MLNError;
import com.rapidminer.operator.modelling.configuration.fixed.MLNException;
import com.rapidminer.operator.modelling.configuration.fixed.MLNFileRole;
import com.rapidminer.operator.modelling.configuration.fixed.MLNParameterType;
import com.rapidminer.operator.modelling.converters.MLNConverter;
import com.rapidminer.operator.modelling.converters.MLNFileConverter;
import com.rapidminer.operator.modelling.converters.exampleset.model.ExampleSetType;
import com.rapidminer.operator.modelling.converters.utilities.ConverterUtilities;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.ArrayIterator;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.Filter;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduce;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduceException;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.Mappable;
import com.rapidminer.operator.modelling.converters.utilities.varweights.MLNVariableWeightsRemover;
import com.rapidminer.operator.modelling.model.MLNClosedWorldType;
import com.rapidminer.operator.modelling.model.MLNModel;
import com.rapidminer.operator.modelling.model.MLNPredicate;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.InputPortExtender;
import com.rapidminer.operator.ports.metadata.MetaData;
import com.rapidminer.parameter.ParameterType;
import com.rapidminer.parameter.ParameterTypeBoolean;

/**
 * Provides common functionality for learning and inference parameters.
 * 
 * @author Yann Kiraly
 *
 */
public abstract class MLNLearnInferOperator extends MLNOperator  {
	protected static final int MIN_STEPS_TO_RUN = 0;
	protected static final int MAX_STEPS_TO_RUN = 100000;
	protected static final String MAX_STEPS = "Maximum Steps To Perform";
	protected static boolean NOT_MANDATORY = false, MANDATORY = true;
	public static final String ENGINE = "Engine";
	protected static final String TEMP_FILE_FOLDER_KEY = "Temporary File Folder";
	protected static final String MULTIPLE_FILES_NOT_SUPPORTED = "Multiple evidence files not supported by engine.";
	protected static final String CONVERT_EXCL_CONST = "Convert exclusivity (!) constraints.";
	
	private static Integer tempFileCounter;
	
	static {
		tempFileCounter = -1;
	}
	
	
	protected abstract MLNFileType getRequiredFileType() throws OperatorException;
	protected abstract MLNEngine getRequiredEngine() throws OperatorException;
	
	protected static final String OUTPUT_FILE_EXTENSION = "_MLNOutput";
	protected static final String EVIDENCE_FILE_EXTENSION = "_Evidence";
	protected static final String RULE_FILE_EXTENSION = "_Rules";
	protected static final String QUERY_FILE_EXTENSION = "_Queries";
	protected static final String  RULE_FILE_ENDING = "mln";
	protected static final String EVIDENCE_FILE_ENDING = "db";
	protected static final String OUT_FILE_ENDING = "mln";
	protected static final String QUERY_FILE_ENDING = "db";
	
	protected static final String REMOVE_VARIABLE_WEIGHTS = "Remove variable weights";
	
	protected static final String ACCEPT_QUERY_ATOMS = "Keep query atoms.";
	
	protected static final String CONVERT_LE_CONSTRAINTS = "Convert <= constraints";
	
	protected static final String REMOVE_UNSUP_CONST = "Remove unsupported constraints";
	
	private String ruleFilePath, queryFilePath, outputFilePath;
	
	private List<String> evidenceFilePaths;
	
	protected InputPortExtender evidencePorts;
	
	private LinkedHashMap<ExampleSetType, InputPort> inputPortMap;

	protected LinkedHashMap<ExampleSetType, InputPort> initializeAdditionalInputPorts() 
		throws OperatorException {
			return new LinkedHashMap<ExampleSetType, InputPort>();
	}
	
	protected void clearEvidenceFilePaths() {
		if (evidenceFilePaths != null)
			evidenceFilePaths.clear();
	}
	
	protected MLNLearnInferOperator(OperatorDescription description) throws OperatorException{
		super(description);
	//	File dir = new File(MLNGeneralParameter.fromKey(TEMP_FILE_FOLDER_KEY).getValue());
	//	for(File file: dir.listFiles()) file.delete();
		initializeInputPorts();
		evidenceFilePaths = new ArrayList<String>();
	}
	
	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> types = super.getParameterTypes();
		List<String> convertLEengines, removeUnsupEngines, convertExclEngines;
		try {
			convertLEengines = getConvertLEengines();
			removeUnsupEngines = getRemoveUnsupEngines();
			convertExclEngines = getConvertExclEngines();
		} catch (OperatorException e) {
			throw new RuntimeException(e.getMessage());
		}
		ParameterTypeBoolean acceptQueryAtomsParameter = new ParameterTypeBoolean(ACCEPT_QUERY_ATOMS, "Keep query atoms from rule file", 
				false, false);
		ParameterTypeBoolean convertLEconstraints = new ParameterTypeBoolean(CONVERT_LE_CONSTRAINTS, 
				"Convert <= constraints to implications. May influence Gibbs convergence.", false, false);
		ParameterTypeBoolean removeUnsupConstraints = new ParameterTypeBoolean(REMOVE_UNSUP_CONST,
				"Remove unsupported constraints and quantifications.", false, false);
		ParameterTypeBoolean convertExclConstraints = new ParameterTypeBoolean(CONVERT_EXCL_CONST,
				"Convert exclusivity constraints.", false, false);
		try {
			convertLEconstraints.registerDependencyCondition(new InListParameterCondition(this, ENGINE,
					convertLEengines));
			removeUnsupConstraints.registerDependencyCondition(new InListParameterCondition(this,
					ENGINE, removeUnsupEngines));
			convertExclConstraints.registerDependencyCondition(new InListParameterCondition(this, ENGINE,
					convertExclEngines));
		} catch (OperatorException e) {
			throw new RuntimeException(e.getMessage());
		}
		types.add(acceptQueryAtomsParameter);
		types.add(convertLEconstraints);
		types.add(removeUnsupConstraints);
		types.add(convertExclConstraints);
		return types;
	}
	
	private List<String> getConvertLEengines() throws OperatorException {
		try {
			return MapReduce.map(
			MapReduce.filter(new ArrayIterator<MLNEngine>(MLNEngine.values()), 
					new Filter<MLNEngine>() {
						@Override
						public boolean test(MLNEngine object) throws MapReduceException {
							if (object.getFileType().supportsLEConstraintConversion()) {
								return true;
							} else
								return false;
						}
			}),
			new Mappable<MLNEngine, String>() {

				@Override
				public String apply(MLNEngine object) throws MapReduceException {
					return object.getKey();
				}
				
			});
		} catch (MapReduceException e) {
			throw new OperatorException(e.getMessage());
		}
	}
	
	private List<String> getConvertExclEngines() throws OperatorException {
		try {
			return MapReduce.map(
			MapReduce.filter(new ArrayIterator<MLNEngine>(MLNEngine.values()), 
					new Filter<MLNEngine>() {
						@Override
						public boolean test(MLNEngine object) throws MapReduceException {
							return object.supportsExclConstraintConversion();
						}
			}),
			new Mappable<MLNEngine, String>() {

				@Override
				public String apply(MLNEngine object) throws MapReduceException {
					return object.getKey();
				}
				
			});
		} catch (MapReduceException e) {
			throw new OperatorException(e.getMessage());
		}
	}
	
	
	private List<String> getRemoveUnsupEngines() throws OperatorException {
		try {
			return MapReduce.map(
			MapReduce.filter(new ArrayIterator<MLNEngine>(MLNEngine.values()), 
					new Filter<MLNEngine>() {
						@Override
						public boolean test(MLNEngine object) throws MapReduceException {
							return object.getFileType().supportsUnsupportedConstraintRemoval();
						}
			}),
			new Mappable<MLNEngine, String>() {

				@Override
				public String apply(MLNEngine object) throws MapReduceException {
					return object.getKey();
				}
				
			});
		} catch (MapReduceException e) {
			throw new OperatorException(e.getMessage());
		}
	}
	
	protected static void removeVariableWeights(MLNModel model, MLNModel variableWeightFormulas,
			MLNModel replacementFormulas) throws OperatorException {
		MLNVariableWeightsRemover remover = new MLNVariableWeightsRemover(model);
		try {
			remover.removeVariableProbabilityWeights(variableWeightFormulas, replacementFormulas);
		} catch (MLNException e) {
			throw new OperatorException(e.getMessage());
		}
	}
	
	protected static void reinstertVariableWeights(MLNModel model, MLNModel variableWeightFormulas,
			MLNModel replacementFormulas) throws OperatorException {
		MLNVariableWeightsRemover remover = new MLNVariableWeightsRemover(model);
		try {
			remover.reinsertVariableProbabilityWeightFormulas(variableWeightFormulas, replacementFormulas);
		} catch (Exception e) {
			throw new OperatorException(e.getMessage(), e.getCause());
		}
	}
	
	protected void initializeInputPorts() throws OperatorException {
		InputPort port;
		inputPortMap = new LinkedHashMap<ExampleSetType, InputPort>();
		inputPortMap.putAll(initializeAdditionalInputPorts());
		for (ExampleSetType type : MLNFileRole.RULES.getExampleSetTypes()) {
			port = getInputPorts().createPort(type.getTitle(), ExampleSet.class);
			inputPortMap.put(type,  port);
			setRolePreconditions(MLNFileRole.RULES, ExampleSet.class, NOT_MANDATORY, port);
		}
		evidencePorts = new InputPortExtender("Ground input", getInputPorts());
		evidencePorts.ensureMinimumNumberOfPorts(1);
		evidencePorts.start();
	}
	
	protected int getMaximumSteps() throws OperatorException {
		return getParameterAsInt(MAX_STEPS);
	}
	
	protected List<ExampleSet> getEvidenceInputData() throws OperatorException {
		return evidencePorts.getData(ExampleSet.class, false);
	}
	
	protected LinkedHashMap<ExampleSetType, ExampleSet> getInputDataForRole(MLNFileRole role) throws OperatorException {
		return getInputDataForRole(inputPortMap, role);
	}
	
	protected static LinkedHashMap<ExampleSetType, ExampleSet> getInputDataForRole(Map<ExampleSetType, InputPort>
			inputPortMap, MLNFileRole role) throws OperatorException {
		LinkedHashMap<ExampleSetType, ExampleSet> newMap = new LinkedHashMap<ExampleSetType, 
				ExampleSet>();
		InputPort port;
		for (ExampleSetType type : role.getExampleSetTypes()) {
			port = inputPortMap.get(type);
			if (port.isConnected())
				newMap.put(type, 
						port.getData(ExampleSet.class));
		}
		return newMap;
	}
	
	
	
	protected static String insertExtension(String path, String extension) {
		int index = path.indexOf('.');
		if (index >=0) {
			String ext = path.substring(index);
			path = path.substring(0, path.length()-ext.length()+1);
			path = path+extension+ext;
		} else {
			path = path+extension;
		}
		return path;
	}
	
	protected List<MLNModel> buildEvidenceMLNModels() throws OperatorException {
		return buildEvidenceMLNModels(evidencePorts.getData(ExampleSet.class, false));
	}
	
	protected static List<MLNModel> buildEvidenceMLNModels(List<ExampleSet> sets) throws OperatorException {
		List<MLNModel> models = new ArrayList<MLNModel>();
		Map<ExampleSetType, ExampleSet> map;
		for (ExampleSet set: sets) {
			map = new HashMap<ExampleSetType, ExampleSet>();
			map.put(ExampleSetType.GroundFormula, set);
			models.add(buildMLNModel(map, MLNFileRole.EVIDENCE));
		}
		return models;
	}
	
	protected MLNModel buildRuleMLNModel() throws OperatorException {
		return buildMLNModel(getInputDataForRole(MLNFileRole.RULES), MLNFileRole.RULES);
	}
	
	protected static MLNFileRole getFileRoleForExampleSetType(ExampleSetType type) {
		for (MLNFileRole role : MLNFileRole.values()) {
			if (role.getExampleSetTypes().contains(type))
				return role;
		}
		return null;
	}
	
	protected static MLNModel buildMLNModel(Map<ExampleSetType, ExampleSet> inputData, MLNFileRole role) 
			throws OperatorException {
		MLNModel mlnModel = null;
		ExampleSet set;
		String roleAnnotation;
		MLNFileRole setRole;
		for (Map.Entry<ExampleSetType, ExampleSet> entry: inputData.entrySet()) {
				set = entry.getValue();
				roleAnnotation = set.getAnnotations().get(FILE_ROLE_KEY);
				if (roleAnnotation == null) {
					setRole = getFileRoleForExampleSetType(entry.getKey());
					if (setRole == null)
						throw new OperatorException(MLNError.FILE_ROLE.getMessage());
				} else {
					setRole = MLNFileRole.valueOf(roleAnnotation);
				}
				if (role.getKey().equals(setRole.getKey())) {
					if (mlnModel == null) {
						mlnModel = convertToModel(set, entry.getKey(), role);
					} else {
						mlnModel = convertToModel(set, entry.getKey(), role, mlnModel);
					}
				}
		}
		if (mlnModel == null)
			try {
				mlnModel = new MLNModel();
			} catch (Exception e) {
				throw new OperatorException(e.getMessage());
			}
		return mlnModel;
	}
	
	protected List<String> processQueryAtoms(boolean keepClosedWorldState, List<String> queryAtomStrings, MLNModel sourceModel, 
			MLNModel queryModel) throws OperatorException {
		List<String> outputStrings = new ArrayList<String>();
		boolean inQuery = false;
		MLNPredicate qP;
		if (!keepClosedWorldState) {
			sourceModel.unifyPredicateState(MLNClosedWorldType.Undefined);
		}
		for (MLNPredicate predicate: sourceModel.getAll(MLNPredicate.class)) {
			if ((inQuery = ((queryModel != null) && (queryModel.getForNameNoCreation(MLNPredicate.class, predicate.getName())!=null)))
				|| ((queryAtomStrings != null) && queryAtomStrings.contains(predicate.getName())) || predicate.getClosedWorldType().name().equals(
						MLNClosedWorldType.Query.name()) ) {
				outputStrings.add(predicate.getName());
				predicate.setClosedWorldType(MLNClosedWorldType.Query);
				if ((queryModel != null) && (!inQuery)) {
					qP = queryModel.getForName(MLNPredicate.class, predicate.getName());
					try {
						BeanUtils.copyProperties(qP, predicate);
						qP.setClosedWorldType(MLNClosedWorldType.Query);
					} catch (Exception e) {
						throw new OperatorException(e.getMessage());
					}
				}
			}
		}
		return outputStrings;
	}
	
	protected static MLNModel convertToModel(ExampleSet set, ExampleSetType type, MLNFileRole role) 
			throws OperatorException {
		MLNConverter converter = MLNConverter.getConverterForExampleSets(ConverterUtilities.compose(set), 
				null, ConverterUtilities.compose(type));
		try {
			
			return converter.buildModel(role);
		} catch (MLNException e) {
			throw new OperatorException(e.getMessage());
		}
	}
	
	protected static MLNModel convertToModel(ExampleSet set, ExampleSetType type, MLNFileRole role, MLNModel mlnModel) 
			throws OperatorException {
		MLNConverter converter = MLNConverter.getConverterForExampleSets(ConverterUtilities.compose(set), 
				null, ConverterUtilities.compose(type));
		try {
			return converter.buildModel(role, mlnModel);
		} catch (MLNException e) {
			throw new OperatorException(e.getMessage());
		}
	}
	
	protected String generateFile(String filename, MLNModel mlnModel, MLNFileType fileType,
			MLNFileRole role, boolean convertLEconstraints,
			boolean removeUnsupportedConstraints, boolean convertExclConstraints) throws OperatorException {
		try {
			MLNFileConverter fileConverter = MLNConverter.getConverterForFileType(fileType, 
					new FileOutputStream(new File(filename)));
			if (fileType.supportsLEConstraintConversion())
				fileConverter.setConvertLEConstraint(convertLEconstraints);
			if (fileType.supportsUnsupportedConstraintRemoval())
				fileConverter.setRemoveUnsupportedConstraints(removeUnsupportedConstraints);
			//Clean this up
			if (convertExclConstraints)
				fileConverter.setExclConstraintConversion(true);
			fileConverter.convertModel(mlnModel, role);
			return filename;
		} catch (FileNotFoundException e) {
			throw new OperatorException(e.getMessage());
		} catch (MLNException e) {
			throw new OperatorException(e.getMessage());
		}
	}
	
	protected List<String> generateFiles(List<String> filenames, List<MLNModel> models, MLNFileType fileType,
			MLNFileRole role, boolean convertLEconstraints, boolean removeUnsupportedConstraints,
			boolean convertExclConstraints) throws OperatorException {
		MLNFileConverter fileConverter;
		try {
			for (int counter = 0; counter < filenames.size(); counter++) {
				fileConverter = MLNConverter.getConverterForFileType(fileType, 
						new FileOutputStream(new File(filenames.get(counter))));
				if (fileType.supportsLEConstraintConversion())
					fileConverter.setConvertLEConstraint(convertLEconstraints);
				if (fileType.supportsUnsupportedConstraintRemoval())
					fileConverter.setRemoveUnsupportedConstraints(removeUnsupportedConstraints);
				//Clean this up
				if (convertExclConstraints)
					fileConverter.setExclConstraintConversion(true);
				fileConverter.convertModel(models.get(counter), role);
			}
		} catch (FileNotFoundException e) {
			throw new OperatorException(e.getMessage(), e);
		} catch (MLNException e) {
			throw new OperatorException(e.getMessage());
		}
		return filenames;
	}
	
	protected void setRolePreconditions(MLNFileRole role, Class<? extends IOObject> outputClass, boolean mandatory,
			InputPort... ports) 
	throws OperatorException {
		double[][] arr = new double[1][1];
		IOObject obj = null;
		if (outputClass.equals(ExampleSet.class)) {
			fillDummyArray(arr);
			obj = ExampleSetFactory.createExampleSet(arr);
		} else if (outputClass.equals(MLNModel.class)){
			try {
				obj = new MLNModel();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		for (InputPort port: ports) {
			addRolePrecondition(port, obj, role, mandatory);
		}
	}
	
	protected static void fillDummyArray(double[][] arr) {
		for (int oC = 0; oC < arr.length; oC++) {
			for (int iC = 0; iC < arr[0].length; iC++) {
				arr[oC][iC] = 0;
			}
		}
	}
	
	protected String insertText(String path, String insertion) throws OperatorException{
		int index = path.indexOf('.');
		String ext;
		if (index >= 0)
			ext = path.substring(index+1);
		else
			ext = "";
		String localPath;
		localPath = path.substring(0, path.length()-(ext.length()+1));
		localPath = localPath+insertion+'.'+ext;
		return localPath;
	}
	
	protected String setEnding(String path, String ending) throws OperatorException {
		String ext = path.substring(path.indexOf('.'));
		String localPath = path.substring(0, path.length()-ext.length());
		return localPath+'.'+ending;
	}
	
	protected String getOutputFilePath() {
		return outputFilePath;
	}
	
	protected void setOutputFilePath(String outputFilePath) {
		this.outputFilePath = outputFilePath;
	}
	
	protected void addEvidenceFilePath(String path) {
		evidenceFilePaths.add(path);
	}
	
	protected String getRuleFilePath() {
		return ruleFilePath;
	}
	
	protected void setRuleFilePath(String path) {
		this.ruleFilePath = path;
	}
	
	public static String generateTempFilename(Operator op) throws OperatorException {
		tempFileCounter++;
		return MLNGeneralParameter.fromKey(TEMP_FILE_FOLDER_KEY).getValue()+"MLN_File_ID_"+tempFileCounter+"_";
	}
	
	protected List<MetaData> getMetaData() throws OperatorException {
		try {
			return MapReduce.map(inputPortMap.values().iterator(), new Mappable<InputPort, MetaData>() {
				@Override
				public MetaData apply(InputPort object) throws MapReduceException {
					return object.getMetaData();
				}
			});
		} catch (MapReduceException e) {
			throw new OperatorException(e.getMessage(), e);
		}
	}

	protected String getQueryFilePath() {
		return queryFilePath;
	}

	protected void setQueryFilePath(String queryFilePath) {
		this.queryFilePath = queryFilePath;
	}
	
	protected void provideOptionalParameters(MLNAbstractAdapter adapter, boolean learn, boolean infer) throws OperatorException {
		List<String[]> pl;
		List<String> l;
		String s;
		int i;
		Boolean b;
		for (MLNOptionalParameter parameter: MLNOptionalParameter.values()) {
			if (parameter.getEngines().contains(getRequiredEngine()) && (
					(parameter.isLearnArgument() == learn)
					|| (parameter.isInferenceArgument() == infer))) {
				if (parameter.getParameterType().equals(MLNParameterType.STRING) ||
						parameter.getParameterType().equals(MLNParameterType.CATEGORY)) {
					s = getParameterAsString(parameter.getKey());
					if (s != null)
						try {
							adapter.addOptionalParameter(parameter, 
									ConverterUtilities.compose(s));
						} catch (MLNException e) {
							throw new OperatorException(e.getMessage());
						}
				} else if (parameter.getParameterType().equals(MLNParameterType.INT)) {
					i = getParameterAsInt(parameter.getKey());
					if (i != -1) {
						try {
							adapter.addOptionalParameter(parameter, ConverterUtilities.compose(i+""));
						} catch (MLNException e) {
							throw new OperatorException(e.getMessage());
						}
					}
				} else if (parameter.getParameterType().equals(MLNParameterType.LIST)) {
					pl = getParameterList(parameter.getKey());
					if (pl.size()>0) {
						l = buildListFromKeyValuePairs(pl,1);
					} else {
						l = null;
					}
					try {
						adapter.addOptionalParameter(parameter, l);
					} catch (MLNException e) {
						throw new OperatorException(e.getMessage());
					}
				} else if (parameter.getParameterType().equals(MLNParameterType.BOOLEAN)) {
					b = getParameterAsBoolean(parameter.getKey());
					if ((b != null) && (b)) {
						try {
							adapter.addOptionalParameter(parameter, new ArrayList<String>());
						} catch (MLNException e) {
							throw new OperatorException(e.getMessage());
						}
					}
				}
			}
		}
	}
	protected List<String> getEvidenceFilePaths() {
		return evidenceFilePaths;
	}

}
