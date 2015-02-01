package com.rapidminer.operator.modelling.configuration.fixed;

public enum MLNLearningType {
	
	GENERATIVE("Generative"), DISCRIMINATIVE("Discriminative");
	
	private String key;
	
	private MLNLearningType(String key) {
		this.key = key;
	}
	
	public String getKey() {
		return key;
	}
	
	public static MLNLearningType fromKey(String key) {
		if (key.equals(GENERATIVE.getKey())) {
			return GENERATIVE;
		} else if (key.equals(DISCRIMINATIVE.getKey())) {
			return DISCRIMINATIVE;
		} else {
			return null;
		}
	}

}
