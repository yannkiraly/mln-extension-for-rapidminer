package com.rapidminer.operator.modelling.converters.utilities.mapreduce;

public class StringListReducer implements Reducer<String, String> {
	private String separator;
	
	public StringListReducer(String separator) {
		this.separator = separator;
	}
	
	@Override
	public String reduce(String existingCombination, String newElement) {
		StringBuilder sb = new StringBuilder();
		sb.append(existingCombination);
		sb.append(separator);
		sb.append(newElement);
		return sb.toString();
	}

	@Override
	public String reduce(String firstElement) {
		return firstElement;
	}

}
