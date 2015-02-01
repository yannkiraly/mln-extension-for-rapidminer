package com.rapidminer.operator.modelling.adapters.alchemy;

import java.io.File;
import java.util.List;

import com.rapidminer.operator.modelling.adapters.MLNLearningAdapter;
import com.rapidminer.operator.modelling.configuration.MLNGeneralParameter;
import com.rapidminer.operator.modelling.configuration.fixed.MLNLearningType;

/**
 * Defines an implementation of a learning adapter for Alchemy.
 * 
 * @author Yann Kiraly
 *
 */
public class AlchemyLearningAdapter extends MLNLearningAdapter {
	private static final String ALCHEMY_BIN_PATH_KEY = "Alchemy Executable Folder";
	private static final String LEARN_BIN_KEY = "Alchemy Weight Learning Executable";
	
	@Override
	public File getWorkingDirectory() {
		return new File(MLNGeneralParameter.fromKey(ALCHEMY_BIN_PATH_KEY).getValue());
	}
	
	/**
	 * Instantiates a new AlchemyLearningAdapter and adds the Alchemy binary path and inference executable
	 * extracted from GeneralParameters.xml to the command string.
	 */
	public AlchemyLearningAdapter() {
		addToCommandList(MLNGeneralParameter.fromKey(ALCHEMY_BIN_PATH_KEY).getValue()+
				MLNGeneralParameter.fromKey(LEARN_BIN_KEY).getValue());
	}
	
	@Override
	public void setInputFile(String filename) {
		addSVToCommandList("-i",filename);
	}
	
	@Override
	public void setOutputFile(String filename) {
		addSVToCommandList("-o",filename);
	}
	
	@Override
	public void addEvidenceFile(String filename) {
		if (filename != null) {
			List<String> commandList = getCommandList();
			if (commandList.contains("-t")) {
				commandList.set(commandList.indexOf("-t")+1, filename+","+commandList.get(commandList.indexOf("-t")+1));
			} else
				addSVToCommandList("-t",filename);
		}
	}
	
	@Override
	public void setLearningType(MLNLearningType type) {
		if (type == MLNLearningType.DISCRIMINATIVE) {
			addToCommandList("-d");
		} else if (type == MLNLearningType.GENERATIVE) {
			addToCommandList("-g");
		}
	}
	
	@Override
	public void setNonEvidencePredicates(List<String> nonEvidencePredicates) {
		addToCommandList("-ne");
		StringBuffer addition = new StringBuffer();
		String comma = "";
		boolean first = true;
		for (String predicate : nonEvidencePredicates) {
			addition.append(comma+predicate);
			if (first) {
				comma = ",";
				first = false;
			}
		}
		addToCommandList(addition.toString());
	}

	@Override
	public void setNonEvidenceFile(String filename) {
	}
}
