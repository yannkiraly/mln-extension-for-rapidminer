package com.rapidminer.operator.modelling.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rapidminer.operator.modelling.adapters.MLNInferenceAdapter;
import com.rapidminer.operator.modelling.adapters.MLNLearningAdapter;
import com.rapidminer.operator.modelling.configuration.fixed.MLNInferenceType;
import com.rapidminer.operator.modelling.configuration.fixed.MLNLearningType;

/**
 * Configuration class providing information on supported MLN engines.
 * 
 * @author Yann Kiraly
 *
 */
public class MLNEngine {
	
	static {
		instances = new HashMap<String, MLNEngine>();
	}
	
	/**
	 * Returns all MLN engines extracted from MLNEngineSpecifications.xml.
	 * 
	 * @return MLNEngine[]: MLN engines extracted from MLNEngineSpecifications.xml.
	 */
	public static MLNEngine[] values() {
		return instances.values().toArray(new MLNEngine[instances.size()]);
	}
	
	/**
	 * Clears all MLN engine values.
	 */
	public static void clearValues() {
		instances = new HashMap<String, MLNEngine>();
	}
	
	/**
	 * Returns an MLN engine for the provided key if it has been defined.
	 * 
	 * @param key: String representing the MLN engine to be returned.
	 * @return MLNEngine: Engine associated with the key.
	 */
	public static MLNEngine fromKey(String key) {
		return instances.get(key);
	}
	
	private static void addInstance(MLNEngine engine) {
		instances.put(engine.getKey(), engine);
	}
	
	private static Map<String, MLNEngine> instances;
	
	private String key;
	private Class<MLNInferenceAdapter> inferenceAdapter;
	private Class<MLNLearningAdapter> learningAdapter;
	private MLNFileType fileType;
	private String fileTypeString;
	private List<MLNLearningType> supportedLearningTypes;
	private List<MLNInferenceType> supportedInferenceTypes;
	private Boolean queryAtomsInRules;
	private Boolean multipleEvidenceFilesInference;
	private Boolean multipleEvidenceFilesLearning;
	private String variableWeights;
	private Boolean plusNotation;
	private Boolean exclConstraintConversion;
	
	/**
	 * Key used to save an MLN engine in meta data.
	 */
	public static final String METADATA_KEY = "engine key";
	
	/**
	 * Instantiates a new MLNEngine. To be used by {@link ConfigurationReader}.
	 * 
	 * @param key
	 * @param inferenceAdapter
	 * @param learningAdapter
	 * @param fileType
	 * @param supportedLearningTypes
	 * @param supportedInferenceTypes
	 */
	@SuppressWarnings("unchecked")
	public MLNEngine(String key, MLNInferenceAdapter inferenceAdapter,
			MLNLearningAdapter learningAdapter, String fileType, 
			List<MLNLearningType> supportedLearningTypes, 
			List<MLNInferenceType> supportedInferenceTypes,
			Boolean queryAtomsInRules, Boolean multipleEvidenceFilesInference,
			Boolean multipleEvidenceFilesLearning, 
			String variableWeights, Boolean plusNotation, Boolean exclConstraintConversion) {
		this.key = key;
		this.inferenceAdapter = (Class<MLNInferenceAdapter>) inferenceAdapter.getClass();
		this.learningAdapter = (Class<MLNLearningAdapter>) learningAdapter.getClass();
		this.fileTypeString = fileType;
		this.supportedLearningTypes = supportedLearningTypes;
		this.supportedInferenceTypes = supportedInferenceTypes;
		this.queryAtomsInRules = queryAtomsInRules;
		this.multipleEvidenceFilesInference = multipleEvidenceFilesInference;
		this.multipleEvidenceFilesLearning =  multipleEvidenceFilesLearning;
		this.variableWeights = variableWeights;
		this.plusNotation = plusNotation;
		this.exclConstraintConversion =exclConstraintConversion;
		addInstance(this);
	}
	
	public Boolean supportsPlusNotation() {
		return plusNotation;
	}
	
	/**
	 * Returns the MLN engine's key.
	 * 
	 * @return String: Key of the MLN engine
	 */
	public String getKey() {
		return key;
	}
	
	public boolean supportsExclConstraintConversion() {
		return exclConstraintConversion;
	}
	
	/**
	 * Returns the learning types supported by the MLN engine.
	 * 
	 * @return List<MLNLearningType>: Learning type supported by the engine.
	 */
	public List<MLNLearningType> getSupportedLearningTypes() {
		List<MLNLearningType> list = new ArrayList<MLNLearningType>();
		if (supportedLearningTypes != null)
			list.addAll(supportedLearningTypes);
		return list;
	}
	
	/**
	 * Returns the inference types supported by the MLN engine.
	 * 
	 * @return List<MLNInferenceType>: Inference type supported by the engine.
	 */
	public List<MLNInferenceType> getSupportedInferenceTypes() {
		List<MLNInferenceType> list = new ArrayList<MLNInferenceType>();
		list.addAll(supportedInferenceTypes);
		return list;
	}
	
	/**
	 * Returns the file type required and emitted by the MLN engine.
	 * 
	 * @return MLNFileType: File type supported by the MLN engine
	 */
	public MLNFileType getFileType() {
		return fileType;
	}

	/**
	 * Injects the file type for the file type key provided in the constructor.
	 * <p>
	 * Allows MLN engines to be instantiated before file types have been instantiated.
	 */
	public void inject() {
		this.fileType = MLNFileType.fromKey(fileTypeString);
	}

	/**
	 * Injects all registered MLNEngine instances.
	 */
	public static void injectAll() {
		for (MLNEngine engine: values()) {
			engine.inject();
		}
	}

	/**
	 * Returns the inference adapter specified for the engine.
	 * @return Class<MLNInferenceAdpater> Inference adapter specified for the engine.
	 */
	public Class<MLNInferenceAdapter> getInferenceAdapter() {
		return inferenceAdapter;
	}

	/**
	 * Returns the learning adapter specified for the engine.
	 * @return Class<MLNInferenceAdpater> Learning adapter specified for the engine.
	 */
	public Class<MLNLearningAdapter> getLearningAdapter() {
		return learningAdapter;
	}

	public boolean isQueryAtomsInRules() {
		return queryAtomsInRules;
	}
	
	public static List<String> getEnginesWithQueryAtomsInRules() {
		List<String> engines = new ArrayList<String>();
		for (MLNEngine engine: values()) {
			if (engine.isQueryAtomsInRules())
				engines.add(engine.getKey());
		}
		return engines;
	}

	public Boolean getMultipleEvidenceFilesInference() {
		return multipleEvidenceFilesInference;
	}

	public Boolean getMultipleEvidenceFilesLearning() {
		return multipleEvidenceFilesLearning;
	}

	public String getVariableWeights() {
		return variableWeights;
	}

}
