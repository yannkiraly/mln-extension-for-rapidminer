package com.rapidminer.condition.mln;

import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.ParameterHandler;
import com.rapidminer.parameter.UndefinedParameterError;
import com.rapidminer.parameter.conditions.ParameterCondition;

/**
 * Allows parameters to be conditioned on the value of one other parameter
 * compared to one string value.
 * <p>
 * RapidMiner can show operator parameters based on the outcome of calling
 * a ParameterCondition's {@link isConditionFullfilled} method. 
 * 
 * @author Yann Kiraly
 * 
 */
public class EqualsParameterCondition extends ParameterCondition {
	
	private String conditionParameter;
	private String equalsTo;
	
	/**
	 * Constructs an EqualsParameterCondition based on {@link conditionParameter} and {@link equalsTo}.
	 * 
	 * @param handler: Operator containing the parameter that is being conditioned on.
	 * @param conditionParameter: Key of the parameter that is being conditioned on.
	 * @param equalsTo: String the parameter's value is to be compared to.
	 * @throws OperatorException
	 */
	public EqualsParameterCondition(ParameterHandler handler,
			String conditionParameter, String equalsTo) throws OperatorException {
		super(handler, false);
		this.conditionParameter = conditionParameter;
		this.equalsTo = equalsTo;
	}
	
	/**
	 * Determined whether the value of the {@link conditionParameter} is equals to {@link equalsTo}.
	 * <p>
	 * Retrieves the value of {@link conditionParameter} from the parameterHandler and compares it to
	 * equalsTo.
	 * 
	 * @return boolean: True if the value of the conditionParameter is equals to equalsTo.
	 */
	@Override
	public boolean isConditionFullfilled() {
		try {
			return parameterHandler.getParameterAsString(conditionParameter).equals(equalsTo);
		} catch (UndefinedParameterError e) {
			return false;
		}
	}

}
