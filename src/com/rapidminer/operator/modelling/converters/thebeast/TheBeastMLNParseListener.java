package com.rapidminer.operator.modelling.converters.thebeast;

import com.rapidminer.operator.modelling.configuration.fixed.MLNException;
import com.rapidminer.operator.modelling.converters.thebeast.parser.TheBeastMLNGrammarBaseListener;
import com.rapidminer.operator.modelling.model.MLNModel;
import com.rapidminer.operator.modelling.model.types.MLNTypeContainer;

public class TheBeastMLNParseListener extends TheBeastMLNGrammarBaseListener {
	private static final boolean INT_ONLY = true;
	private static final String INT_TYPE_NAME = "integerType";
	private static final int PROB_WEIGHT_INDEX = 0;
	private static final int UTIL_WEIGHT_INDEX = 1;
	
	private MLNModel mlnModel;
	
	private MLNTypeContainer integerType;
	
	public TheBeastMLNParseListener() throws MLNException {
		try {
			setMlnModel(new MLNModel());
		} catch (InstantiationException e) {
			throw new MLNException(e.getMessage(), e);
		} catch(IllegalAccessException e) {
			throw new MLNException(e.getMessage(), e);
		}
	}
	
	public MLNModel getMlnModel() {
		return mlnModel;
	}

	public void setMlnModel(MLNModel mlnModel) {
		this.mlnModel = mlnModel;
	}

}
