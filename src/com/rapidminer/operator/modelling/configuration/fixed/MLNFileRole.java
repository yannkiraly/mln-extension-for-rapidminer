package com.rapidminer.operator.modelling.configuration.fixed;

import java.util.ArrayList;
import java.util.List;

import com.rapidminer.operator.modelling.converters.exampleset.model.ExampleSetType;

public enum MLNFileRole {
	RULES("Rules", addExampleSetType(addExampleSetType(addExampleSetType(
			addExampleSetType(ExampleSetType.TypeDecl), 
			ExampleSetType.PredicateDecl), ExampleSetType.FunctionDecl), ExampleSetType.Formula)), 
	EVIDENCE("Evidence", addExampleSetType(ExampleSetType.GroundFormula)), 
	INFERENCE_RESULT("Result of Inference", addExampleSetType(ExampleSetType.ProbabilityStatement)),
	QUERY("Query Predicates", addExampleSetType(ExampleSetType.QueryPredicateDecl));
	
	private String key;
	public static final String METADATA_KEY = "file role";
	private List<ExampleSetType> exampleSetTypes;
	
	private MLNFileRole(String key, List<ExampleSetType> exampleSetTypes) {
		this.key = key;
		this.exampleSetTypes = exampleSetTypes;
	}
	
	public String getKey() {
		return key;
	}
	
	public String getPortName(String addition) {
		return name()+" "+addition;
	}
	
	public List<ExampleSetType> getExampleSetTypes() {
		return exampleSetTypes;
	}
	
	public static MLNFileRole fromKey(String key) {
		if (key.equals(RULES.getKey())) {
			return RULES;
		} else if (key.equals(EVIDENCE.getKey())) {
			return EVIDENCE;
		} else if (key.equals(INFERENCE_RESULT.getKey())) {
			return INFERENCE_RESULT;
		} else if (key.equals(QUERY.getKey())) {
			return QUERY;
		} else {
			return null;
		}
	}
	
	public static MLNFileRole fromPortName(String portName, String addition) {
		return valueOf(portName.substring(0,portName.length()-1-addition.length()));
	}
	
	public static final List<ExampleSetType> addExampleSetType(List<ExampleSetType> list,
			ExampleSetType type) {
		list.add(type);
		return list;
	}
	
	public static final List<ExampleSetType> addExampleSetType(ExampleSetType type) {
		List<ExampleSetType> list = new ArrayList<ExampleSetType>();
		list.add(type);
		return list;
	}
}
