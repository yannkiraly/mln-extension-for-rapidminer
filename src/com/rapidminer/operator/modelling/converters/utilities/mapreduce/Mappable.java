package com.rapidminer.operator.modelling.converters.utilities.mapreduce;


public interface Mappable<S, T> {
	public T apply(S object) throws MapReduceException ;
}
