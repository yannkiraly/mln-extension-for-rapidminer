package com.rapidminer.operator.modelling.model;

import com.rapidminer.operator.modelling.converters.utilities.mapreduce.ContentComparable;



public abstract class MLNObject implements ContentComparable {
	
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	protected static boolean applyContentEquals(ContentComparable objA, ContentComparable objB, boolean strict) {
		if (((objA == null) && (objB == null)) || (objA!=null &&  objB!=null && objA.contentEquals(objB, strict))){
			return true;
		} else  {
			return false;
		}
	}
	
	protected static boolean applyContentEquals(ContentComparable objA, ContentComparable
			objB, boolean strict,
			boolean allowGroundings) {
		if (((objA == null) && (objB == null)) || objA.contentEquals(objB, strict, allowGroundings)){
			return true;
		} else  {
			return false;
		}
	}
	
}
