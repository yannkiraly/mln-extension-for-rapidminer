package com.rapidminer.operator.modelling.model;

public class MLNVarArgument extends MLNObject {
	
	private MLNPredicateApplication predicateApplication;
	private MLNFunctionApplication functionApplication;
	private MLNVariable variable;
	private MLNConstant constant;
	private Double number;
	private boolean plus;
	
	public MLNVarArgument(MLNFunctionApplication functionApplication,
			boolean plus) {
		super();
		this.functionApplication = functionApplication;
		this.plus = plus;
	}

	public MLNVarArgument(MLNPredicateApplication predicateApplication,
			boolean plus) {
		super();
		this.predicateApplication = predicateApplication;
		this.plus = plus;
	}
	
	public MLNVarArgument(MLNConstant constant, boolean plus) {
		this.constant = constant;
		this.plus = plus;
	}
	
	public MLNVarArgument(Double number, boolean plus) {
		this.number = number;
		this.plus = plus;
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
	
	public MLNVarArgument(MLNVariable variable, boolean plus) {
		this.variable = variable;
		this.plus = plus;
	}

	public MLNVariable getVariable() {
		return variable;
	}

	public void setVariable(MLNVariable variable) {
		this.variable = variable;
	}

	public boolean isPlus() {
		return plus;
	}

	public void setPlus(boolean plus) {
		this.plus = plus;
	}

	public MLNPredicateApplication getPredicateApplication() {
		return predicateApplication;
	}

	public void setPredicateApplication(MLNPredicateApplication predicateApplication) {
		this.predicateApplication = predicateApplication;
	}

	public MLNFunctionApplication getFunctionApplication() {
		return functionApplication;
	}

	public void setFunctionApplication(MLNFunctionApplication functionApplication) {
		this.functionApplication = functionApplication;
	}

	@Override
	public boolean contentEquals(Object obj, boolean strict) {
		MLNVarArgument castObj;
		if (obj instanceof MLNVarArgument) {
			castObj = (MLNVarArgument) obj;
			return applyContentEquals(castObj.getPredicateApplication(), 
				getPredicateApplication(), strict) &&
				applyContentEquals(castObj.getFunctionApplication(),
						getFunctionApplication(), strict) &&
				applyContentEquals(castObj.getConstant(),
						getConstant(), strict) &&
				applyContentEquals(castObj.getVariable(),
						getVariable(), strict) &&
						((castObj.getNumber() == null) && (getNumber() == null))||
						(castObj.getNumber()!=null && getNumber()!=null && castObj.getNumber().equals(getNumber())) &&
				(castObj.isPlus()==isPlus());
		} else {
			return false;
		}
	}

	@Override
	public boolean contentEquals(Object obj, boolean strict,
			boolean allowGroundings) {
		MLNVarArgument castObj;
		if (allowGroundings) {
			if (obj instanceof MLNVarArgument) {
				castObj = (MLNVarArgument) obj;
				return applyContentEquals(castObj.getPredicateApplication(), 
					getPredicateApplication(), strict, allowGroundings) &&
					applyContentEquals(castObj.getFunctionApplication(),
							getFunctionApplication(), strict, allowGroundings) &&
					applyContentEquals(castObj.getConstant(),
							getConstant(), strict, allowGroundings) &&
					applyContentEquals(castObj.getVariable(),
							getVariable(), strict, allowGroundings) &&
							((castObj.getNumber() == null) && (getNumber() == null))||
							(castObj.getNumber().equals(getNumber())) &&
					(castObj.isPlus()==isPlus());
			} else {
				return false;
			}
		} else {
			return contentEquals(obj, strict);
		}
	}

}
