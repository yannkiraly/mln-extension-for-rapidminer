package com.rapidminer.operator.modelling.converters.utilities.mapreduce;

public interface Filter<T> {
	
	public boolean test(T object) throws MapReduceException;

}
