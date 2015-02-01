package com.rapidminer.operator.modelling.model;

import java.util.List;

import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduce;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduceException;
import com.rapidminer.operator.modelling.model.types.MLNTypeArgument;

public class MLNFunction extends MLNNamedObject {
	
	protected MLNFunction() {
		
	}
	
	public MLNFunction(String name, List<MLNTypeArgument> arguments, MLNTypeArgument returnType) {
		super(name);
		this.arguments = arguments;
		this.returnType = returnType;
	}
	
	private List<MLNTypeArgument> arguments;
	
	private MLNTypeArgument returnType;


	public MLNTypeArgument getReturnType() {
		return returnType;
	}

	public void setReturnType(MLNTypeArgument returnType) {
		this.returnType = returnType;
	}

	public List<MLNTypeArgument> getArguments() {
		return arguments;
	}

	public void setArguments(List<MLNTypeArgument> arguments) {
		this.arguments = arguments;
	}
	
	@Override
	public boolean isUnspecified() {
		if ((arguments == null) && (returnType == null)) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean internalContentEquals(Object obj, boolean strict) {
		if (obj instanceof MLNFunction) {
			MLNFunction function = (MLNFunction) obj;
			final List<MLNTypeArgument> argumentList = function.getArguments();
			try {
				return applyContentEquals(function.getReturnType(), getReturnType(), strict) &&
						MapReduce.reduce(argumentList, 
						new MLNListCompare<MLNTypeArgument>(getArguments().iterator(), strict));
			} catch (MapReduceException e) {
				return false;
			}
		} else {
			return false;
		}
	}
}
