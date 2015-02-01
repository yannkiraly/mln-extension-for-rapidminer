package com.rapidminer.operator.modelling.model;

import java.util.List;

import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduce;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduceException;

public class MLNGroundFunctionApplication extends MLNObject {
	public MLNGroundFunctionApplication(MLNFunction function,
			List<MLNGroundArgument> arguments) {
		super();
		this.function = function;
		this.arguments = arguments;
	}

	private MLNFunction function;
	
	private List<MLNGroundArgument> arguments;
	

	public MLNFunction getFunction() {
		return function;
	}

	public void setFunction(MLNFunction function) {
		this.function = function;
	}

	public List<MLNGroundArgument> getArguments() {
		return arguments;
	}

	public void setArguments(List<MLNGroundArgument> arguments) {
		this.arguments = arguments;
	}

	@Override
	public boolean contentEquals(Object obj, boolean strict) {
		if (obj instanceof MLNGroundFormula) {
			MLNGroundFunctionApplication groundFunctionApplication = (MLNGroundFunctionApplication) obj;
			try {
				return applyContentEquals(groundFunctionApplication.getFunction(), getFunction(), strict)
						&&
						MapReduce.reduce(groundFunctionApplication.getArguments().iterator(), 
								new MLNListCompare<MLNGroundArgument>(getArguments().iterator(), strict));
			} catch (MapReduceException e) {
				return false;
			}
		} else
			return false;
	}

	@Override
	public boolean contentEquals(Object obj, boolean strict,
			boolean allowGroundings) {
		if (allowGroundings) {
			if (obj instanceof MLNGroundFormula) {
				MLNGroundFunctionApplication groundFunctionApplication = (MLNGroundFunctionApplication) obj;
				try {
					return applyContentEquals(groundFunctionApplication.getFunction(), getFunction(), strict,
							allowGroundings)
							&&
							MapReduce.reduce(groundFunctionApplication.getArguments().iterator(), 
									new MLNListCompare<MLNGroundArgument>(getArguments().iterator(), strict,
											allowGroundings));
				} catch (MapReduceException e) {
					return false;
				}
			} else
				return false;
		} else {
			return contentEquals(obj, strict, allowGroundings);
		}
	}

}
