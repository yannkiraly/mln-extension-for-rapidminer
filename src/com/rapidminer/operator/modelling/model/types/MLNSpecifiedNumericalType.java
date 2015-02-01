package com.rapidminer.operator.modelling.model.types;

import java.util.List;

import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduce;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduceException;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.Reducer;

public class MLNSpecifiedNumericalType extends MLNNumericalType {
	
	public MLNSpecifiedNumericalType(boolean intOnly, List<Double> numbers) {
		super(intOnly);
		this.numbers = numbers;
	}
	
	protected void copy(String name, List<Double> numbers) {
		this.numbers = numbers;
	}
	
	@Override
	public boolean isInstance(Object obj) {
		return ((obj instanceof Double) && (numbers.contains(obj)));
	}
	
	private List<Double> numbers;
	
	public List<Double> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<Double> numbers) {
		this.numbers = numbers;
	} 
	
	@Override
	public boolean contentEquals(Object obj, boolean strict) {
		if (obj instanceof MLNSpecifiedNumericalType) {
			final List<Double> numberList = ((MLNSpecifiedNumericalType) obj).getNumbers();
			try {
				return MapReduce.reduce(getNumbers(), new Reducer<Double, Boolean>() {
					private int counter = -1;
					@Override
					public Boolean reduce(Double number) {
						counter++;
						return number.equals(numberList.get(counter));
					}
					
					@Override
					public Boolean reduce(Boolean existingValue, Double nextConstant) {
						return existingValue && reduce(nextConstant);
					}
				});
			} catch (MapReduceException e) {
				return false;
			}
		} else
			return false;
	}

	@Override
	public boolean contentEquals(Object obj, boolean strict,
			boolean allowGroundings) {
		return contentEquals(obj, strict);
	}


}
