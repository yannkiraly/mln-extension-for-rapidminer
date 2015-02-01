package com.rapidminer.operator.modelling.converters.utilities.mapreduce;

public class MapReduceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 829791863964443617L;
	
	public MapReduceException(String message) {
		super(message);
	}
	
	public MapReduceException(String message, Exception source) {
		super(message, source);
	}

}
