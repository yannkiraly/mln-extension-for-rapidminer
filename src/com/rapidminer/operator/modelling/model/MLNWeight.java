package com.rapidminer.operator.modelling.model;

import com.rapidminer.operator.modelling.converters.utilities.ConverterUtilities;

public class MLNWeight extends MLNObject {

	
	public MLNWeight(MLNVariable varWeight) {
		super();
		this.varWeight = varWeight;
	}
	public MLNWeight(Double specificWeight) {
		super();
		this.specificWeight = specificWeight;
	}
	
	private Double specificWeight;
	private MLNVariable varWeight;
	
	public Double getSpecificWeight() {
		return specificWeight;
	}
	public void setSpecificWeight(Double specificWeight) {
		this.specificWeight = specificWeight;
	}
	public MLNVariable getVarWeight() {
		return varWeight;
	}
	public void setVarWeight(MLNVariable varWeight) {
		this.varWeight = varWeight;
	}
	
	@Override
	public String toString() {
		if (specificWeight != null) {
			return ConverterUtilities.safeToString(specificWeight);
		} else if (varWeight != null) {
			return varWeight.getName();
		} else {
			return null;
		}
	}
	@Override
	public boolean contentEquals(Object obj, boolean strict) {
		MLNWeight weight;
		if (obj instanceof MLNWeight)
			weight = (MLNWeight) obj;
		else
			return false;
		return ((getSpecificWeight()!=null?getSpecificWeight().equals(weight.getSpecificWeight()):false) 
				|| (getVarWeight()!=null?getVarWeight().contentEquals(weight.getVarWeight(), strict):false));
	}
	@Override
	public boolean contentEquals(Object obj, boolean strict,
			boolean allowGroundings) {
		return contentEquals(obj, strict);
	}
}
