package com.rapidminer.operator.modelling.adapters;

import java.util.List;

import com.rapidminer.operator.OperatorException;
import com.rapidminer.operator.modelling.configuration.MLNEngine;
import com.rapidminer.operator.modelling.configuration.fixed.MLNException;
import com.rapidminer.operator.modelling.configuration.fixed.MLNLearningType;

/**
 * Defines abstract methods for an MLN inference adapter and provides an inference adapter for an engine.
 * 
 * @author Yann Kiraly
 *
 */
public abstract class MLNLearningAdapter extends MLNAbstractAdapter {
	
	/** 
	 * 
	 * 
	 * @param type
	 * @throws OperatorException
	 */
	public abstract void setLearningType(MLNLearningType type) throws MLNException;
	
	public abstract void setNonEvidenceFile(String filename) throws MLNException;
	
	public abstract void setNonEvidencePredicates(List<String> nonEvidencePredicates) throws MLNException;
	
	/**
	 * Returns a learning adapter for an MLNEngine based on the MLNEngine specification in MLNEngineSpecification.xml.
	 * 
	 * @param engine: MLNEngine that an adapter is required for.
	 * @return MLNInferenceAdapter: Learning adapter for the specified engine.
	 * @throws OperatorException
	 */
	public static MLNLearningAdapter getAdapterForEngine(MLNEngine engine){
		try {
			return engine.getLearningAdapter().newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException();
		} catch (IllegalAccessException e) {
			throw new RuntimeException();
		}
	}
}
