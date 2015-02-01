package com.rapidminer.operator.modelling.adapters.rockit;

import java.io.File;
import java.util.List;

import com.rapidminer.operator.modelling.adapters.MLNLearningAdapter;
import com.rapidminer.operator.modelling.configuration.MLNGeneralParameter;
import com.rapidminer.operator.modelling.configuration.MLNOptionalParameter;
import com.rapidminer.operator.modelling.configuration.fixed.MLNError;
import com.rapidminer.operator.modelling.configuration.fixed.MLNException;
import com.rapidminer.operator.modelling.configuration.fixed.MLNLearningType;

/**
 * Defines an implementation of a learning adapter for Rockit. Rockit does not currently support learning, so
 * this adapter primarily serves as a place holder and to throw a learning type not supported error if learning
 * is attempted nonetheless.
 * 
 * @author Yann Kiraly
 *
 */
public class RockitLearningAdapter extends MLNLearningAdapter {
	private static final String MAX_MEMORY_KEY = "Maximum memory use";
	private static final String ROCKIT_PATH_KEY = "Rockit JAR Folder";
	private static final String ROCKIT_JAR_KEY = "Rockit JAR";
	private static final String ROCKIT_PROPERTIES_KEY = "Rockit Configuration File";
	
	public RockitLearningAdapter() {
		addToCommandList("java");
		addSVToCommandList("-jar",MLNGeneralParameter.fromKey(ROCKIT_PATH_KEY).getValue()+
				MLNGeneralParameter.fromKey(ROCKIT_JAR_KEY).getValue());
		addSVToCommandList("-para", MLNGeneralParameter.fromKey(ROCKIT_PATH_KEY).getValue()+
				MLNGeneralParameter.fromKey(ROCKIT_PROPERTIES_KEY).getValue());
		addToCommandList("-learn");
	}
	
	
	@Override
	public File getWorkingDirectory() {
		return new File(MLNGeneralParameter.fromKey(ROCKIT_PATH_KEY).getValue());
	}
	
	@Override
	public void addEvidenceFile(String filename) {
		if (filename != null) {
			List<String> commandList = getCommandList();
			if (commandList.contains("-data")) {
				commandList.set(commandList.indexOf("-data")+1, filename+","+commandList.get(commandList.indexOf("-data")+1));
			} else
				addSVToCommandList("-data",filename);
		}
	}

	@Override
	public void setLearningType(MLNLearningType type) throws MLNException {
		if (type.equals(MLNLearningType.GENERATIVE)) {
			MLNError.LEARNING_TYPE.exception();
		}
	}

	@Override
	public void setNonEvidencePredicates(List<String> nonEvidencePredicates) {
	}

	@Override
	public void setInputFile(String filename) {
		addSVToCommandList("-input", filename);
	}

	@Override
	public void setOutputFile(String filename) {
		addSVToCommandList("-output",filename);
		
	}

	@Override
	public void setNonEvidenceFile(String filename)  {
	}
	
	@Override
	public void addOptionalParameter(MLNOptionalParameter parameter, List<String> arguments) throws MLNException {
		if (parameter.getKey().equals(MAX_MEMORY_KEY)) {
			List<String> list = getCommandList();
			list.add(list.indexOf("-jar"), parameter.getFlag()+arguments.get(0)+"M");
		} else {
			super.addOptionalParameter(parameter, arguments);
		}
	}

}
