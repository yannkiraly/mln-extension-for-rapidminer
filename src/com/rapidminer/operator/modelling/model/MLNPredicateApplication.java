package com.rapidminer.operator.modelling.model;

import java.util.List;

import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduce;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduceException;

public class MLNPredicateApplication extends MLNObject {
	public MLNPredicateApplication(MLNPredicate predicate,
			List<MLNVarArgument> arguments) {
		this.predicate = predicate;
		this.arguments = arguments;
	}

	private MLNPredicate predicate;
	
	private List<MLNVarArgument> arguments;

	public MLNPredicate getPredicate() {
		return predicate;
	}

	public void setPredicate(MLNPredicate predicate) {
		this.predicate = predicate;
	}
	
	public List<MLNVarArgument> getArguments() {
		return arguments;
	}

	public void setArguments(List<MLNVarArgument> arguments) {
		this.arguments = arguments;
	}
	
	@Override
	public boolean contentEquals(Object obj, boolean strict) {
		if (obj instanceof MLNPredicateApplication) {
			MLNPredicateApplication predicateAppl = (MLNPredicateApplication) obj;
			final List<MLNVarArgument> argumentList = predicateAppl.getArguments();
			try {
				return applyContentEquals(predicateAppl.getPredicate(), getPredicate(), strict) &&
						MapReduce.reduce(argumentList.iterator(), 
								new MLNListCompare<MLNVarArgument>(getArguments().iterator(), strict));
			} catch (MapReduceException e) {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public boolean contentEquals(Object obj, boolean strict,
			boolean allowGroundings) {
		if (allowGroundings) {
			if (obj instanceof MLNPredicateApplication) {
				return ((MLNPredicateApplication) obj).getPredicate().getName().equals(getPredicate().getName());
			} else {
				return false;
			}
		} else {
			return contentEquals(obj, strict);
		}
		
	}
	
}
