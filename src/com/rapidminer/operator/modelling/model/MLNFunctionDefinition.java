package com.rapidminer.operator.modelling.model;

import java.util.List;

import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduce;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduceException;

public class MLNFunctionDefinition extends MLNObject {

	public MLNFunctionDefinition(MLNFunction function,
			MLNFunctionReturnValue returnValue,
			List<MLNGroundArgument> arguments) {
		super();
		this.function = function;
		this.returnValue = returnValue;
		this.arguments = arguments;
	}

	MLNFunction function;
	
	private MLNFunctionReturnValue returnValue;
	
	private List<MLNGroundArgument> arguments;

	public MLNFunction getFunction() {
		return function;
	}

	public void setFunction(MLNFunction function) {
		this.function = function;
	}

	public MLNFunctionReturnValue getReturnValue() {
		return returnValue;
	}

	public void setReturnValue(MLNFunctionReturnValue returnValue) {
		this.returnValue = returnValue;
	}

	public List<MLNGroundArgument> getArguments() {
		return arguments;
	}

	public void setArguments(List<MLNGroundArgument> arguments) {
		this.arguments = arguments;
	}
	
	@Override
	public boolean contentEquals(Object obj, boolean strict) {
		if (obj instanceof MLNFunction) {
			MLNFunctionDefinition functionDef = (MLNFunctionDefinition) obj;
			final List<MLNGroundArgument> argumentList = functionDef.getArguments();
			try {
				return applyContentEquals(functionDef.getReturnValue(), getReturnValue(), strict) &&
						applyContentEquals(functionDef.getFunction(), getFunction(), strict) &&
						MapReduce.reduce(argumentList.iterator(), 
								new MLNListCompare<MLNGroundArgument>(getArguments().iterator(), strict));
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
			if (obj instanceof MLNFunction) {
				MLNFunctionDefinition functionDef = (MLNFunctionDefinition) obj;
				final List<MLNGroundArgument> argumentList = functionDef.getArguments();
				try {
					return applyContentEquals(functionDef.getReturnValue(), getReturnValue(), strict,
							allowGroundings) &&
							applyContentEquals(functionDef.getFunction(), getFunction(), strict,
									allowGroundings) &&
							MapReduce.reduce(argumentList.iterator(), 
									new MLNListCompare<MLNGroundArgument>(getArguments().iterator(), strict,
											allowGroundings));
				} catch (MapReduceException e) {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return contentEquals(obj, strict);
		}
	}

}
