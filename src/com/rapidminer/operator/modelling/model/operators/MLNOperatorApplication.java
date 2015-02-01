package com.rapidminer.operator.modelling.model.operators;

import java.util.List;

import com.rapidminer.operator.modelling.converters.utilities.mapreduce.ContentComparable;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduce;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduceException;
import com.rapidminer.operator.modelling.model.MLNListCompare;
import com.rapidminer.operator.modelling.model.MLNObject;
import com.rapidminer.operator.modelling.model.MLNPlainFormula;

public class MLNOperatorApplication extends MLNObject implements ContentComparable {
	private MLNFormulaOperator operator;
	
	private List<MLNPlainFormula> arguments;
	
	public MLNOperatorApplication(MLNFormulaOperator operator, List<MLNPlainFormula> arguments) {
		this.operator = operator;
		this.arguments = arguments;
	}
	
	public MLNFormulaOperator getOperator() {
		return operator;
	}

	public void setOperator(MLNFormulaOperator operator) {
		this.operator = operator;
	}

	public List<MLNPlainFormula> getArguments() {
		return arguments;
	}

	public void setArguments(List<MLNPlainFormula> arguments) {
		this.arguments = arguments;
	}

	@Override
	public boolean contentEquals(Object obj, boolean strict) {
		if (obj instanceof MLNOperatorApplication) {
			MLNOperatorApplication appl = (MLNOperatorApplication) obj;
			try {
				return applyContentEquals(appl.getOperator(), getOperator(), strict) &&
						MapReduce.reduce(appl.getArguments().iterator(), 
								new MLNListCompare<MLNPlainFormula>(getArguments().iterator(), strict));
			} catch (MapReduceException e) {
				return false;
			}
		} else
			return false;
	}

	@Override
	public boolean contentEquals(Object obj, boolean strict,
			boolean allowGroundings) {
		if (obj instanceof MLNOperatorApplication) {
			MLNOperatorApplication appl = (MLNOperatorApplication) obj;
			try {
				return applyContentEquals(appl.getOperator(), getOperator(), strict) &&
						MapReduce.reduce(appl.getArguments().iterator(), 
								new MLNListCompare<MLNPlainFormula>(getArguments().iterator(), strict, allowGroundings));
			} catch (MapReduceException e) {
				return false;
			}
		} else
			return false;
	}

}
