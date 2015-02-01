package com.rapidminer.operator.modelling.model;

public class MLNFunctionReturnValue extends MLNObject{
	
	private MLNConstant constant;
	private Double number;
	
	public MLNFunctionReturnValue(MLNConstant constant) {
		this.constant = constant;
	}
	
	public MLNFunctionReturnValue(Double number) {
		this.number = number;
	}

	public MLNConstant getConstant() {
		return constant;
	}

	public void setConstant(MLNConstant constant) {
		this.constant = constant;
	}

	public Double getNumber() {
		return number;
	}

	public void setNumber(Double number) {
		this.number = number;
	}

	@Override
	public boolean contentEquals(Object obj, boolean strict) {
		if (obj instanceof MLNFunctionReturnValue) {
			MLNFunctionReturnValue retVal = (MLNFunctionReturnValue) obj;
			return (retVal.getNumber().equals(getNumber())) && 
					applyContentEquals(retVal.getConstant(), getConstant(), strict);
		} else {
			return false;
		}
	}

	@Override
	public boolean contentEquals(Object obj, boolean strict,
			boolean allowGroundings) {
		return contentEquals(obj, strict);
	}
	
}
