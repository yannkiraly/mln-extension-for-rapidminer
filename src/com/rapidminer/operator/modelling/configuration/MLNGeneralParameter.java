package com.rapidminer.operator.modelling.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.rapidminer.tools.config.AbstractConfigurable;

public class MLNGeneralParameter extends AbstractConfigurable {
	
	static {
		instances = new HashMap<String, MLNGeneralParameter>();
	}
	
	/**
	 * Instantiates a new MLNGeneralParameter. For use by {@linkConfigurationLoader}.
	 * 
	 * @param key
	 * @param value
	 * @param topic
	 * @param description
	 */
	public MLNGeneralParameter(String key, String value, String topic, String description) {
		this.key = key;
		this.value = value;
		this.topic = topic;
		this.description = description;
		addInstance(this);
	}
	
	/**
	 * Returns all MLN general parameters extracted from GeneralParameters.xml.
	 * 
	 * @return MLNGeneralParameter[]: MLN general parameters extracted from GeneralParameters.xml.
	 */
	public static MLNGeneralParameter[] values() {
		return instances.values().toArray(new MLNGeneralParameter[instances.size()]);
	}
	
	public static void clearValues() {
		instances = new HashMap<String, MLNGeneralParameter>();
	}
	
	/**
	 * Returns an MLN general parameter for the provided key if it has been defined.
	 * 
	 * @param key: String representing the MLN general parameter to be returned.
	 * @return MLNGeneralparameter: General parameter associated with the key.
	 */
	public static MLNGeneralParameter fromKey(String key) {
		return instances.get(key);
	}
	
	/**
	 * Returns the MLN general parameters for the provided topic. For use in a graphical 
	 * configuration dialog.
	 * 
	 * @param topic: String representing the topic of the parameters to be returned.
	 * @return List<MLNGeneralparameter>: General parameters associated with the topic.
	 */
	public static List<MLNGeneralParameter> forTopic(String topic) {
		List<MLNGeneralParameter> parameters = new ArrayList<MLNGeneralParameter>();
		for (MLNGeneralParameter parameter: values()) {
			if (parameter.getTopic().equals(topic))
				parameters.add(parameter);
		}
		return parameters;
	}
	
	private static void addInstance(MLNGeneralParameter engine) {
		instances.put(engine.getKey(), engine);
	}
	
	private static Map<String, MLNGeneralParameter> instances;
	
	private String key;
	private String value;
	private String topic;
	private String description;
	
	public static String[] topics() {
		MLNGeneralParameter[] values = values();
		Set<String> topics = new LinkedHashSet<String>();
		for (MLNGeneralParameter value: values) {
			topics.add(value.getTopic());
		}
		return topics.toArray(new String[values.length]);
	}
	
	/**
	 * Returns the MLN general parameter's key.
	 * 
	 * @return String: Key of the MLN general parameter
	 */
	public String getKey() {
		return key;
	}
	
	/**
	 * Returns the parameter's value.
	 * 
	 * @return String: Parameter value
	 */
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * Returns the parameter's topic.
	 * 
	 * @return String: Topic of the parameter
	 */
	public String getTopic() {
		return topic;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String getTypeId() {
		return "MLNConfig";
	}

}
