package com.rapidminer.operator.modelling.model;

public class MLNGroundArgument extends MLNObject implements Comparable {
	
	public MLNGroundArgument(
			MLNGroundFunctionApplication groundFunctionApplication) {
		super();
		this.groundFunctionApplication = groundFunctionApplication;
	}

	public MLNGroundArgument(MLNGroundAtom groundAtom) {
		super();
		this.groundAtom = groundAtom;
	}

	private MLNGroundAtom groundAtom;
	private MLNGroundFunctionApplication groundFunctionApplication;
	private MLNConstant constant;
	private Double number;
	
	public MLNGroundArgument(MLNConstant constant) {
		this.constant = constant;
	}
	
	public MLNGroundArgument(Double number) {
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

	public MLNGroundAtom getGroundAtom() {
		return groundAtom;
	}

	public void setGroundAtom(MLNGroundAtom groundAtom) {
		this.groundAtom = groundAtom;
	}

	public MLNGroundFunctionApplication getGroundFunctionApplication() {
		return groundFunctionApplication;
	}

	public void setGroundFunctionApplication(
			MLNGroundFunctionApplication groundFunctionApplication) {
		this.groundFunctionApplication = groundFunctionApplication;
	}
	
	@Override
	public boolean contentEquals(Object obj, boolean strict) {
		MLNGroundArgument castObj;
		if (obj instanceof MLNGroundArgument) {
			castObj = (MLNGroundArgument) obj;
			return applyContentEquals(castObj.getGroundAtom(), 
				getGroundAtom(), strict) &&
				applyContentEquals(castObj.getGroundFunctionApplication(),
						getGroundFunctionApplication(), strict) &&
				applyContentEquals(castObj.getConstant(),
						getConstant(), strict) &&
						(((castObj.getNumber() == null) && (getNumber() == null))||
						(((castObj.getNumber()!=null)&&(getNumber()!=null))?castObj.getNumber().equals(getNumber()):false));
		} else {
			return false;
		}
	}

	@Override
	public boolean contentEquals(Object obj, boolean strict,
			boolean allowGroundings) {
		return contentEquals(obj, strict);
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof MLNGroundArgument) {
			if (((MLNGroundArgument) o).getConstant()!=null && this.getConstant()!=null) {
				return ((MLNGroundArgument) o).getConstant().getName().compareTo(this.getConstant().getName());
			} else if (((MLNGroundArgument) o).getNumber()!=null && this.getNumber()!=null) {
				return ((MLNGroundArgument) o).getNumber().compareTo(this.getNumber());
			} else {
				throw new RuntimeException();
			}
		} else {
			throw new RuntimeException();
		}
	}

}
