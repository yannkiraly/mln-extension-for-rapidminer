package com.rapidminer.operator.modelling.converters.utilities.mapreduce;

public interface ContentComparable {
	
	public boolean contentEquals(Object obj, boolean strict);
	public boolean contentEquals(Object obj, boolean strict, boolean allowGroundings);

}
