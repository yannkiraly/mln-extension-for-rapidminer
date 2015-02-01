package com.rapidminer.operator.modelling.converters;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import com.rapidminer.operator.modelling.configuration.fixed.MLNError;
import com.rapidminer.operator.modelling.configuration.fixed.MLNException;
import com.rapidminer.operator.modelling.configuration.fixed.MLNFileRole;
import com.rapidminer.operator.modelling.model.MLNGroundAtom;
import com.rapidminer.operator.modelling.model.MLNModel;
import com.rapidminer.operator.modelling.model.MLNPredicateApplication;
import com.rapidminer.operator.modelling.model.types.MLNTypeArgument;
import com.rapidminer.operator.modelling.model.types.MLNTypeContainer;

public abstract class MLNFileConverter extends MLNConverter {
	protected InputStream inputStream;
	protected OutputStream outputStream;
	
	protected MLNModel model;
	
	public MLNFileConverter(InputStream inputStream, OutputStream outputStream) {
		this.inputStream = inputStream;
		this.outputStream = outputStream;
	}

	public abstract MLNModel internalBuildModel(MLNFileRole role) throws MLNException;

	public abstract void internalConvertModel(MLNModel model, MLNFileRole role) 
			throws MLNException;
	
	@Override
	public MLNModel buildModel(MLNFileRole role) throws MLNException {
		if (inputStream != null) {
			return internalBuildModel(role);
		} else {
			MLNError.INPUT_ERROR.exception();
			return null;
		}
	}
	
	public void updateFloatType(MLNModel model, String newTypeName,  boolean intOnly,
			Double lowerBound, Double upperBound) {
		boolean excl;
		MLNTypeContainer cont = model.buildMLNTypeContainer(newTypeName, false, lowerBound, upperBound);
		for (MLNPredicateApplication appl: model.getAll(MLNPredicateApplication.class)) {
			for (int counter = 0; counter < appl.getArguments().size(); counter++) {
				if (appl.getArguments().get(counter).getNumber()!=null) {
					if (appl.getPredicate()!=null && !appl.getPredicate().isUnspecified()) {
						if (appl.getPredicate().getArguments()!=null) {
							excl = appl.getPredicate().getArguments().get(counter).isExcl();
						} else {
							excl = false;
						}
						appl.getPredicate().getArguments().set(counter, new MLNTypeArgument(cont, 
								excl));
					}
				}
			}
		}
		for (MLNGroundAtom appl: model.getAll(MLNGroundAtom.class)) {
			for (int counter = 0; counter < appl.getArguments().size(); counter++) {
				if (appl.getArguments().get(counter).getNumber()!=null) {
					if (appl.getPredicate()!=null && !appl.getPredicate().isUnspecified()) {
						if (appl.getPredicate().getArguments()!=null) {
							excl = appl.getPredicate().getArguments().get(counter).isExcl();
						} else {
							excl = false;
						}
						appl.getPredicate().getArguments().set(counter,  new MLNTypeArgument(cont,
								excl));
					}
				}
			}
		}
		//TODO: Add predicate declaration search.
	}
	
	@Override
	public void convertModel(MLNModel model, MLNFileRole role) throws MLNException {
		if (outputStream != null) {
			try {
				(new OutputStreamWriter(outputStream)).write(" ");
			} catch (IOException e) {
				MLNError.FILE_NOT_FOUND.exception();
			}
			internalConvertModel(model, role);
		} else {
			MLNError.OUTPUT_ERROR.exception();
		}
	}
	
	@Override
	public MLNModel buildModel(MLNFileRole role, MLNModel modelToExtend)
			throws MLNException {
		this.model = modelToExtend;
		return buildModel(role);
	}
}
