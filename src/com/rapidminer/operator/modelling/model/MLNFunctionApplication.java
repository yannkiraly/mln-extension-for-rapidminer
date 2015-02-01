package com.rapidminer.operator.modelling.model;

import java.util.List;

import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduce;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduceException;

public class MLNFunctionApplication extends MLNObject {

	public MLNFunctionApplication(MLNFunction function,
			List<MLNVarArgument> arguments) {
		super();
		this.function = function;
		this.arguments = arguments;
	}

	private MLNFunction function;
	
	private List<MLNVarArgument> arguments;

	public MLNFunction getFunction() {
		return function;
	}

	public void setFunction(MLNFunction function) {
		this.function = function;
	}
	
	public List<MLNVarArgument> getArguments() {
		return arguments;
	}

	public void setArguments(List<MLNVarArgument> arguments) {
		this.arguments = arguments;
	}

	@Override
	public boolean contentEquals(Object obj, boolean strict) {
		if (obj instanceof MLNFunction) {
			MLNFunctionApplication functionAppl = (MLNFunctionApplication) obj;
			final List<MLNVarArgument> argumentList = functionAppl.getArguments();
			try {
				return applyContentEquals(functionAppl.getFunction(), getFunction(), strict) &&
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
			if (obj instanceof MLNFunctionApplication) {
				return applyContentEquals((MLNFunction) obj, getFunction(), strict);
			} else {
				return false;
			}
		} else
			return contentEquals(obj, strict);
	}

}
