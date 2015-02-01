package com.rapidminer.operator.modelling.configuration.fixed;

public enum MLNInferenceType {
	
	MAP("MAP"), MARGINAL("Marginal");
	
	private String key;
	public static final String METADATA_KEY = "inference type";
	
	private MLNInferenceType(String key) {
		this.key = key;
	}
	
	public String getKey() {
		return key;
	}
	
	public static MLNInferenceType fromKey(String key) {
		if (key.equals(MAP.getKey())) {
			return MAP;
		} else if (key.equals(MARGINAL.getKey())) {
			return MARGINAL;
		} else {
			return null;
		}
	}
}
