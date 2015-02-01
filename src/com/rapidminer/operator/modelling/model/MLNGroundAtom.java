package com.rapidminer.operator.modelling.model;

import java.util.List;

import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduce;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduceException;

public class MLNGroundAtom extends MLNObject {
	private MLNPredicate predicate;
	
	private List<MLNGroundArgument> arguments;
	
	private boolean negated;
	
	public MLNGroundAtom(MLNPredicate predicate, List<MLNGroundArgument> arguments, boolean negated) {
		this.predicate = predicate;
		this.arguments = arguments;
		this.negated = negated;
	}

	public MLNPredicate getPredicate() {
		return predicate;
	}

	public void setPredicate(MLNPredicate predicate) {
		this.predicate = predicate;
	}

	public List<MLNGroundArgument> getArguments() {
		return arguments;
	}

	public void setArguments(List<MLNGroundArgument> arguments) {
		this.arguments = arguments;
	}

	public boolean isNegated() {
		return negated;
	}

	public void setNegated(boolean negated) {
		this.negated = negated;
	}

	@Override
	public boolean contentEquals(Object obj, boolean strict) {
		if (obj instanceof MLNGroundAtom) {
			MLNGroundAtom atom = (MLNGroundAtom) obj;
			try {
				return applyContentEquals(atom.getPredicate(), getPredicate(), strict) &&
						MapReduce.reduce(atom.getArguments().iterator(), 
								new MLNListCompare<MLNGroundArgument>(getArguments().iterator(), strict)) &&
								atom.isNegated() == isNegated();
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
			if (obj instanceof MLNGroundAtom) {
				MLNGroundAtom atom = (MLNGroundAtom) obj;
				return applyContentEquals(atom.getPredicate(), getPredicate(), strict) &&
							atom.isNegated() == isNegated();
			} else {
				return false;
			}
		}
		else {
			return contentEquals(obj, strict);
		}
	}
}
