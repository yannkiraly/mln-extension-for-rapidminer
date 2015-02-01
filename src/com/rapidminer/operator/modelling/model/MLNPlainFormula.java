package com.rapidminer.operator.modelling.model;

import com.rapidminer.operator.modelling.converters.utilities.mapreduce.ContentComparable;
import com.rapidminer.operator.modelling.model.operators.MLNOperatorApplication;


public class MLNPlainFormula extends MLNObject implements ContentComparable {
	public MLNPlainFormula(MLNOperatorApplication operatorApplication,
			MLNFunctionApplication functionApplication,
			MLNPredicateApplication predicateApplication,
			MLNQuantification quantification) {
		super();
		this.operatorApplication = operatorApplication;
		this.functionApplication = functionApplication;
		this.predicateApplication = predicateApplication;
		this.quantification = quantification;
	}

	private MLNOperatorApplication operatorApplication;
	
	private MLNFunctionApplication functionApplication;
	
	private MLNPredicateApplication predicateApplication;
	
	private MLNQuantification quantification;

	public MLNOperatorApplication getOperatorApplication() {
		return operatorApplication;
	}

	public void setOperatorApplication(MLNOperatorApplication operatorApplication) {
		this.operatorApplication = operatorApplication;
	}

	public MLNFunctionApplication getFunctionApplication() {
		return functionApplication;
	}

	public void setFunctionApplication(MLNFunctionApplication functionApplication) {
		this.functionApplication = functionApplication;
	}

	public MLNPredicateApplication getPredicateApplication() {
		return predicateApplication;
	}

	public void setPredicateApplication(MLNPredicateApplication predicateApplication) {
		this.predicateApplication = predicateApplication;
	}

	public MLNQuantification getQuantification() {
		return quantification;
	}

	public void setQuantification(MLNQuantification quantification) {
		this.quantification = quantification;
	}

	@Override
	public boolean contentEquals(Object obj, boolean strict) {
		if (obj instanceof MLNPlainFormula) {
			MLNPlainFormula formula = (MLNPlainFormula) obj;
			if (formula.getFunctionApplication()!=null)
				return applyContentEquals(formula.getFunctionApplication(), getFunctionApplication(), strict);
			else if (formula.getPredicateApplication()!=null)
				return applyContentEquals(formula.getPredicateApplication(), getPredicateApplication(), strict);
			else if (formula.getQuantification()!=null)
				return applyContentEquals(formula.getQuantification(), getQuantification(), strict);
			else if (formula.getOperatorApplication()!=null)
				return applyContentEquals(formula.getOperatorApplication(), getOperatorApplication(), strict);
			else
				return !strict;
		} else
			return false;
	}
	
	public boolean contentEquals(Object obj, boolean strict, boolean allowGroundings) {
		if (obj instanceof MLNPlainFormula) {
			MLNPlainFormula formula = (MLNPlainFormula) obj;
			if (formula.getFunctionApplication()!=null)
				return applyContentEquals(formula.getFunctionApplication(), getFunctionApplication(), strict, 
						allowGroundings);
			else if (formula.getPredicateApplication()!=null)
				return applyContentEquals(formula.getPredicateApplication(), getPredicateApplication(), strict, 
						allowGroundings);
			else if (formula.getQuantification()!=null)
				return applyContentEquals(formula.getQuantification(), getQuantification(), strict, 
						allowGroundings);
			else if (formula.getOperatorApplication()!=null)
				return applyContentEquals(formula.getOperatorApplication(), getOperatorApplication(), strict, 
						allowGroundings);
			else
				return !strict;
		} else
			return false;
	}
	
}
