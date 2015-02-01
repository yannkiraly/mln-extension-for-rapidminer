package com.rapidminer.operator.modelling.converters.utilities.cnf;

import com.rapidminer.operator.modelling.model.MLNPlainFormula;
import com.rapidminer.operator.modelling.model.operators.MLNOperatorApplication;

public interface OperatorApplicationConverter {
	
	public MLNPlainFormula convert(MLNOperatorApplication appl);
	
}
