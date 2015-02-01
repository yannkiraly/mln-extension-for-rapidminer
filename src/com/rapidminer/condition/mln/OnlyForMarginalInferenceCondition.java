package com.rapidminer.condition.mln;

import com.rapidminer.operator.OperatorException;
import com.rapidminer.operator.modelling.MLNInferOperator;
import com.rapidminer.operator.modelling.configuration.fixed.MLNInferenceType;
import com.rapidminer.parameter.ParameterHandler;

public class OnlyForMarginalInferenceCondition extends MLNCondition {
	
	public OnlyForMarginalInferenceCondition(ParameterHandler handler) throws OperatorException {
		super(handler, false);
	}
	
	@Override
	public boolean isConditionFullfilled() {
		try {
			return parameterHandler.getParameterAsString(MLNInferOperator.INFERENCE_TYPE).equals(MLNInferenceType.MARGINAL.getKey());
		} catch (Exception e) {
			return false;
		}
	}

}
