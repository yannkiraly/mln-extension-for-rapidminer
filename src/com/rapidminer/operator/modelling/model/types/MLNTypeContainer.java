package com.rapidminer.operator.modelling.model.types;

import java.util.List;

import com.rapidminer.operator.modelling.model.MLNConstant;
import com.rapidminer.operator.modelling.model.MLNNamedObject;


public class MLNTypeContainer extends MLNNamedObject {
	
	private MLNConstantType constantType;
	private MLNRangeNumericalType rangeNumericalType;
	private MLNSpecifiedNumericalType specifiedNumericalType;
	
	public MLNTypeContainer() {
		
	}
	
	private MLNTypeContainer(String name) {
		super(name);
	}
	
	public MLNTypeContainer(String name, List<MLNConstant> constants) {
		this(name);
		this.constantType = new MLNConstantType(constants);
	}
	
	public MLNTypeContainer(String name, boolean intOnly, List<Double> numbers) {
		super(name);
		this.specifiedNumericalType = new MLNSpecifiedNumericalType(intOnly, numbers);
	}
	
	public MLNTypeContainer(String name, boolean intOnly, Double lowerBound, Double upperBound) {
		super(name);
		this.rangeNumericalType = new MLNRangeNumericalType(intOnly, lowerBound, upperBound);
	}

	public MLNConstantType getConstantType() {
		return constantType;
	}

	public MLNRangeNumericalType getRangeNumericalType() {
		return rangeNumericalType;
	}

	public MLNSpecifiedNumericalType getSpecifiedNumericalType() {
		return specifiedNumericalType;
	}
	
	@Override
	public boolean isUnspecified() {
		if (((constantType == null) ||
				(constantType.getConstants()==null) ||
					constantType.getConstants().isEmpty()) 
			&& ((rangeNumericalType == null) ||
					(rangeNumericalType.getLowerBound()==null) ||
							(rangeNumericalType.getUpperBound()==null)) 
			&& ((specifiedNumericalType == null) ||
					(specifiedNumericalType.getNumbers()!=null) ||
							(specifiedNumericalType.getNumbers().isEmpty()))) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean internalContentEquals(Object obj, boolean strict) {
		MLNTypeContainer castObj;
		if (obj instanceof MLNTypeContainer) {
			castObj = (MLNTypeContainer) obj;
			return applyContentEquals(castObj.getConstantType(), 
				getConstantType(), strict) &&
				applyContentEquals(castObj.getRangeNumericalType(),
						getRangeNumericalType(), strict) &&
				applyContentEquals(castObj.getSpecifiedNumericalType(),
						getSpecifiedNumericalType(), strict);
		} else {
			return false;
		}
	}
	
}
