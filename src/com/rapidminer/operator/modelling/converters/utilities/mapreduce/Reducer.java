package com.rapidminer.operator.modelling.converters.utilities.mapreduce;


public interface Reducer<S,T> {
	public T reduce(T existingCombination, S newElement) throws MapReduceException ;
	
	public T reduce(S firstElement) throws MapReduceException ;
}
