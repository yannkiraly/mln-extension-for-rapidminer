package com.rapidminer.operator.modelling.model.types;



public class MLNRangeNumericalType extends MLNNumericalType {
	
	public MLNRangeNumericalType(boolean intOnly, Double lowerBound,
			Double upperBound) {
		super(intOnly);
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}
	
	@Override
	public boolean isInstance(Object obj) {
		Double num;
		if (obj instanceof Double) {
			num = (Double) obj;
			return ((num >= lowerBound) && (num <= upperBound));
		} else {
			return false;
		}
	}

	private Double lowerBound, upperBound;

	public Double getUpperBound() {
		return upperBound;
	}

	public void setUpperBound(Double upperBound) {
		this.upperBound = upperBound;
	}

	public Double getLowerBound() {
		return lowerBound;
	}

	public void setLowerBound(Double lowerBound) {
		this.lowerBound = lowerBound;
	}
	
	@Override
	public boolean contentEquals(Object obj, boolean strict) {
		MLNRangeNumericalType type;
		if (obj instanceof MLNRangeNumericalType) {
			type = (MLNRangeNumericalType) obj;
			return type.getUpperBound().equals(getUpperBound()) &&
					type.getUpperBound().equals(getUpperBound()) &&
					type.isIntOnly()==isIntOnly();
		}
		else
			return false;
	}

	@Override
	public boolean contentEquals(Object obj, boolean strict,
			boolean allowGroundings) {
		return contentEquals(obj, strict);
	}


}
