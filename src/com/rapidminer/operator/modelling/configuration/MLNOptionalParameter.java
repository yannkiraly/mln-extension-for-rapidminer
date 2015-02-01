package com.rapidminer.operator.modelling.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rapidminer.condition.mln.InListParameterCondition;
import com.rapidminer.operator.Operator;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.operator.modelling.MLNLearnInferOperator;
import com.rapidminer.operator.modelling.configuration.fixed.MLNParameterType;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduce;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduceException;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.Mappable;
import com.rapidminer.parameter.ParameterType;
import com.rapidminer.parameter.ParameterTypeBoolean;
import com.rapidminer.parameter.ParameterTypeCategory;
import com.rapidminer.parameter.ParameterTypeInt;
import com.rapidminer.parameter.ParameterTypeList;
import com.rapidminer.parameter.ParameterTypeString;
import com.rapidminer.parameter.conditions.ParameterCondition;

public class MLNOptionalParameter {
	
	private static Map<String, MLNOptionalParameter> instances;
	
	
	private static final String NE_PREDICATE_KEY_TYPE = "List Key";
	private static final int MIN_LIST_KEY = 0;
	private static final int MAX_LIST_KEY = 100;
	private static final String NE_PREDICATE_VALUE_TYPE = "List Value";

	private String key;
	private String description;
	private String flag;
	private Integer numberOfArguments;
	private List<String> engineStrings;
	private List<MLNEngine> engines;
	private boolean inferenceArgument;
	private boolean learnArgument;
	private boolean expert;
	private MLNParameterType parameterType;
	private List<String> categories;
	private Integer minInt;
	private Integer maxInt;
	private Integer defaultCategoryIndex;
	private List<ParameterCondition> parameterConditions;
	private Integer defaultInt;
	private Boolean defaultBoolean;
	
	/**
	 *  Instantiates a new MLNGeneralParameter. For use by {@linkConfigurationLoader}.
	 * 
	 * @param key
	 * @param description
	 * @param flag
	 * @param numberOfArguments
	 * @param engines
	 * @param inferenceArgument
	 * @param learnArgument
	 * @param expert
	 * @param parameterType
	 * @param categories
	 * @param minInt
	 * @param maxInt
	 * @param defaultCategoryIndex
	 * @param parameterConditions
	 * @param defaultInt
	 */
	public MLNOptionalParameter(String key, String description, String flag,
			int numberOfArguments, List<String> engines,
			boolean inferenceArgument, boolean learnArgument, boolean expert,
			MLNParameterType parameterType, List<String> categories,
			Integer minInt, Integer maxInt, Integer defaultCategoryIndex,
			List<ParameterCondition> parameterConditions, Integer defaultInt,
			Boolean defaultBoolean) {
		this.key = key;
		this.description = description;
		this.flag = flag;
		this.numberOfArguments = numberOfArguments;
		this.engineStrings = engines;
		this.inferenceArgument = inferenceArgument;
		this.learnArgument = learnArgument;
		this.expert = expert;
		this.parameterType = parameterType;
		this.categories = categories;
		this.minInt = minInt;
		this.maxInt = maxInt;
		this.defaultCategoryIndex = defaultCategoryIndex;
		this.parameterConditions = parameterConditions;
		if (defaultInt != null)
			this.defaultInt = defaultInt;
		else
			this.defaultInt = 0;
		if (defaultBoolean != null)
			this.defaultBoolean = defaultBoolean;
		else
			this.defaultBoolean = false;
		addInstance(this);
	}
	
	public MLNOptionalParameter(String key, String description, String flag,
			List<MLNEngine> engines, int numberOfArguments, 
			boolean inferenceArgument, boolean learnArgument, boolean expert,
			MLNParameterType parameterType, List<String> categories,
			Integer minInt, Integer maxInt, Integer defaultCategoryIndex,
			List<ParameterCondition> parameterConditions, Integer defaultInt, Boolean defaultBoolean) {
		this.key = key;
		this.description = description;
		this.flag = flag;
		this.numberOfArguments = numberOfArguments;
		this.engines = engines;
		this.inferenceArgument = inferenceArgument;
		this.learnArgument = learnArgument;
		this.expert = expert;
		this.parameterType = parameterType;
		this.categories = categories;
		this.minInt = minInt;
		this.maxInt = maxInt;
		this.defaultCategoryIndex = defaultCategoryIndex;
		this.parameterConditions = parameterConditions;
		if (defaultInt != null)
			this.defaultInt = defaultInt;
		else
			this.defaultInt = 0;
		if (defaultBoolean != null)
			this.defaultBoolean = defaultBoolean;
		else
			this.defaultBoolean = false;
		addInstance(this);
	}


	static {
		instances = new HashMap<String, MLNOptionalParameter>();
	}
	
	/**
	 * Returns all MLN optional parameters extracted from OptionalParameterSpecifications.xml.
	 * 
	 * @return MLNOptionalParameter[]: MLN optional parameters extracted from OptionalParameterSpecifications.xml.
	 */
	public static MLNOptionalParameter[] values() {
		return instances.values().toArray(new MLNOptionalParameter[instances.size()]);
	}
	
	/**
	 * Clears all instances.
	 * 
	 */
	public static void clearValues() {
		instances = new HashMap<String, MLNOptionalParameter>();
	}
	
	/**
	 * Returns an MLN optional parameter for the provided key if it has been defined.
	 * 
	 * @param key: String representing the MLN general parameter to be returned.
	 * @return MLNGeneralparameter: General parameter associated with the key.
	 */
	public static MLNOptionalParameter fromKey(String key) {
		return instances.get(key);
	}
	
	private static void addInstance(MLNOptionalParameter parameter) {
		instances.put(parameter.getKey(), parameter);
	}
	
	public static ParameterType buildParameterType(Operator operator, MLNOptionalParameter parameter) 
			throws MapReduceException, OperatorException {
		ParameterType type = null;
		List<String> strings;
		if (parameter.getParameterType().equals(MLNParameterType.INT)) {
			type = new ParameterTypeInt(parameter.getKey(), parameter.getDescription(),
					parameter.getMinInt(), parameter.getMaxInt(), parameter.getDefaultInt(), true);
		} else if (parameter.getParameterType().equals(MLNParameterType.STRING)) {
			type = new ParameterTypeString(parameter.getKey(), parameter.getDescription(),
					true);
		} else if (parameter.getParameterType().equals(MLNParameterType.CATEGORY)) {
			strings = parameter.getCategories();
			type = new ParameterTypeCategory(parameter.getKey(), parameter.getDescription(), 
					strings.toArray(new String[strings.size()]), parameter.getDefaultCategoryIndex());
		} else if (parameter.getParameterType().equals(MLNParameterType.LIST)) {
			type = new ParameterTypeList(parameter.getKey(), parameter.getDescription(),
					new ParameterTypeInt(NE_PREDICATE_KEY_TYPE, "Key", 
							MIN_LIST_KEY, MAX_LIST_KEY), 
					new ParameterTypeString(NE_PREDICATE_VALUE_TYPE, "Value"));
		} else if (parameter.getParameterType().equals(MLNParameterType.BOOLEAN)) {
			type = new ParameterTypeBoolean(parameter.getKey(), parameter.getDescription(),
					parameter.getDefaultBoolean());
		}
		if (type != null) {
			type.setExpert(parameter.isExpert());
			type.setOptional(true);
			type.registerDependencyCondition(new InListParameterCondition(operator, MLNLearnInferOperator.ENGINE,
					MapReduce.map(parameter.getEngines(), new Mappable<MLNEngine, String>() {
				@Override
				public String apply(MLNEngine object) {
					return object.getKey();
				}
			})));
			if (parameter.getParameterConditions()!=null) {
				for (ParameterCondition condition: parameter.getParameterConditions()) {
					type.registerDependencyCondition(condition);
				}
			}			
		}
		return type;
	}
	
	public String getFlag() {
		return flag;
	}

	public int getNumberOfArguments() {
		return numberOfArguments;
	}

	public String getDescription() {
		return description;
	}

	public boolean isExpert() {
		return expert;
	}
	
	public String getKey() {
		return key;
	}

	public MLNParameterType getParameterType() {
		return parameterType;
	}
	
	public List<String> getCategories() {
		return categories;
	}
	
	public List<MLNEngine> getEngines() {
		return engines;
	}

	public Integer getMinInt() {
		return minInt;
	}

	public Integer getMaxInt() {
		return maxInt;
	}

	public Integer getDefaultCategoryIndex() {
		return defaultCategoryIndex;
	}
	
	public List<ParameterCondition> getParameterConditions() {
		return parameterConditions;
	}
	
	public boolean isInferenceArgument() {
		return inferenceArgument;
	}
	
	public boolean isLearnArgument() {
		return learnArgument;
	}
	
	public Integer getDefaultInt() {
		return defaultInt;
	}
	
	public void inject() {
		engines = new ArrayList<MLNEngine>();
		for (String engineString: engineStrings) {
			engines.add(MLNEngine.fromKey(engineString));
		}
	}
	
	public static void injectAll() {
		for (MLNOptionalParameter parameter: values()) {
			parameter.inject();
		}
	}

	public Boolean getDefaultBoolean() {
		return defaultBoolean;
	}
}
