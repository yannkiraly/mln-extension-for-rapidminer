package com.rapidminer.condition.mln;

import java.util.List;

import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.ParameterHandler;
import com.rapidminer.parameter.UndefinedParameterError;
import com.rapidminer.parameter.conditions.ParameterCondition;

/**
 * Allows parameters to be conditioned on the value of one other parameter
 * compared to a list of string values.
 * <p>
 * RapidMiner can show operator parameters based on the outcome of calling
 * a ParameterCondition's {@link isConditionFullfilled} method. 
 * 
 * @author Yann Kiraly
 *
 */
public class InListParameterCondition extends ParameterCondition {
	private String conditionParameter;
	private List<String> equalsTo;
	
	
	/**
	 * Constructs an EqualsParameterCondition based on {@link conditionParameter} and {@link equalsTo}.
	 * 
	 * @param handler: Operator containing the parameter that is being conditioned on.
	 * @param conditionParameter: Key of the parameter that is being conditioned on.
	 * @param equalsTo: List of strings that the parameter's value is being compared to.
	 * @throws OperatorException 
	 */
	public InListParameterCondition(ParameterHandler handler,
			String conditionParameter, List<String> equalsTo) throws OperatorException {
		super(handler, false);
		this.conditionParameter = conditionParameter;
		this.equalsTo = equalsTo;
	}
	
	@Override
	/**
	 * Determined whether the value of the {@link conditionParameter} is equals to one element of {@link equalsTo}.
	 * <p>
	 * Retrieves the value of {@link conditionParameter} from the parameterHandler and compares it to the values in
	 * equalsTo.
	 * 
	 * @return boolean: True if the conditionParameter's value can be found in the equalsTo list.
	 */
	public boolean isConditionFullfilled() {
		boolean returnValue = false;
		String condition;
		try {
			condition = parameterHandler.getParameterAsString(conditionParameter);
		} catch (UndefinedParameterError e) {
			return false;
		}
		for (String value : equalsTo) {
			returnValue = value.equals(condition);
			if (returnValue)
				break;
		}
		return returnValue;
	}

}
