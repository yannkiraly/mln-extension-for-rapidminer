package com.rapidminer.condition.mln;

import com.rapidminer.parameter.ParameterHandler;
import com.rapidminer.parameter.conditions.ParameterCondition;

public abstract class MLNCondition extends ParameterCondition {

	public MLNCondition(ParameterHandler parameterHandler,
			boolean becomeMandatory) {
		super(parameterHandler, becomeMandatory);
	}
	
	public MLNCondition(ParameterHandler parameterHandler) {
		super(parameterHandler, false);
	}

}
