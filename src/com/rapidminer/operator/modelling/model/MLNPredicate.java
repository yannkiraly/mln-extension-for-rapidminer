package com.rapidminer.operator.modelling.model;

import java.util.List;

import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduce;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduceException;
import com.rapidminer.operator.modelling.model.types.MLNTypeArgument;

public class MLNPredicate extends MLNNamedObject{
	
	public MLNPredicate() {
		
	}
	
	public MLNPredicate(String name, List<MLNTypeArgument> arguments) {
		super(name);
		this.arguments = arguments;
		closedWorldType = MLNClosedWorldType.Undefined;
	}
	
	public MLNPredicate(String name, List<MLNTypeArgument> arguments, MLNClosedWorldType type) {
		super(name);
		this.arguments = arguments;
		this.closedWorldType = type;
	}
	
	private MLNClosedWorldType closedWorldType;
	
	private List<MLNTypeArgument> arguments;
	
	
	public List<MLNTypeArgument> getArguments() {
		return arguments;
	}

	public void setArguments(List<MLNTypeArgument> arguments) {
		this.arguments = arguments;
	}
	
	@Override
	public boolean isUnspecified() {
		if ((arguments == null) || (arguments.size()==0)) {
			return true;
		} else {
			return false;
		}
	}

	public MLNClosedWorldType getClosedWorldType() {
		return closedWorldType;
	}

	public void setClosedWorldType(MLNClosedWorldType closedWorldType) {
		this.closedWorldType = closedWorldType;
	}
	
	@Override
	public boolean internalContentEquals(Object obj, boolean strict) {
		if (obj instanceof MLNPredicate) {
			if (!strict)
				return true;
			else {
				MLNPredicate function = (MLNPredicate) obj;
				final List<MLNTypeArgument> argumentList = function.getArguments();
				try {
					return MapReduce.reduce(argumentList, 
							new MLNListCompare<MLNTypeArgument>(getArguments().iterator(), strict));
				} catch (MapReduceException e) {
					return false;
				}
			}
		} else {
			return false;
		}
	}

}
