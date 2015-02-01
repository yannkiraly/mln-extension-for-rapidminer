package com.rapidminer.operator.modelling.model.types;

import com.rapidminer.operator.modelling.converters.utilities.mapreduce.ContentComparable;


public abstract class MLNType implements ContentComparable{
	
	public abstract boolean isInstance(Object obj);

}
