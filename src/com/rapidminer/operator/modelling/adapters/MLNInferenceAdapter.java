package com.rapidminer.operator.modelling.adapters;

import java.util.List;

import com.rapidminer.operator.OperatorException;
import com.rapidminer.operator.modelling.configuration.MLNEngine;
import com.rapidminer.operator.modelling.configuration.fixed.MLNException;
import com.rapidminer.operator.modelling.configuration.fixed.MLNInferenceType;

/**
 * Defines abstract methods for an MLN inference adapter and provides an inference adapter for an engine.
 * 
 * @author Yann Kiraly
 *
 */
public abstract class MLNInferenceAdapter extends MLNAbstractAdapter {
	
	public abstract void setQueryAtoms(List<String> queryAtoms) throws MLNException;
	public abstract void setQueryFile(String filename) throws MLNException;
	public abstract void setInferenceType(MLNInferenceType type) throws MLNException;
	
	/**
	 * Returns an inference adapter for an MLNEngine based on the MLNEngine specification in MLNEngineSpecification.xml.
	 * 
	 * @param engine: MLNEngine that an adapter is required for.
	 * @return MLNInferenceAdapter: Inference adapter for the specified engine.
	 * @throws OperatorException
	 */
	public static MLNInferenceAdapter getAdapterForEngine(MLNEngine engine) {
		try {
			return engine.getInferenceAdapter().newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}
