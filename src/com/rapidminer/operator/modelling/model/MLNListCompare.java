package com.rapidminer.operator.modelling.model;

import java.util.Iterator;

import com.rapidminer.operator.modelling.converters.utilities.mapreduce.Reducer;

public class MLNListCompare<S extends MLNObject> implements Reducer<S, Boolean> {
	private Iterator<S> cIterator;
	private boolean strict, allowGroundings;
	
	public MLNListCompare(Iterator<S> cIterator, boolean strict) {
		this.cIterator = cIterator;
		this.strict = strict;
		this.allowGroundings = false;
	}
	
	public MLNListCompare(Iterator<S> cIterator, boolean strict, boolean allowGroundings) {
		this.cIterator = cIterator;
		this.strict = strict;
		this.allowGroundings = allowGroundings;
	}
	
	private int counter = -1;
	@Override
	public Boolean reduce(S obj) {
		counter++;
		return obj.contentEquals(cIterator.next(), strict, allowGroundings);
	}
	
	@Override
	public Boolean reduce(Boolean existingValue, S nextValue) {
		return existingValue && reduce(nextValue);
	}
}
