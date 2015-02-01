package com.rapidminer.operator.modelling.model.types;

public abstract class MLNNumericalType extends MLNType {
	
	public MLNNumericalType(boolean intOnly) {
		this.intOnly = intOnly;
	}
	
	private boolean intOnly;

	public boolean isIntOnly() {
		return intOnly;
	}

	public void setIntOnly(boolean intOnly) {
		this.intOnly = intOnly;
	}
	
}
