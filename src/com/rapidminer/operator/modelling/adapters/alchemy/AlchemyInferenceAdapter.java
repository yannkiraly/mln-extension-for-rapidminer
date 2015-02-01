package com.rapidminer.operator.modelling.adapters.alchemy;

import java.io.File;
import java.util.List;

import com.rapidminer.operator.modelling.adapters.MLNInferenceAdapter;
import com.rapidminer.operator.modelling.configuration.MLNGeneralParameter;
import com.rapidminer.operator.modelling.configuration.MLNOptionalParameter;
import com.rapidminer.operator.modelling.configuration.fixed.MLNException;
import com.rapidminer.operator.modelling.configuration.fixed.MLNInferenceType;

/**
 * Defines an implementation of an inference adapter for Alchemy.
 * 
 * @author Yann Kiraly
 *
 */
public class AlchemyInferenceAdapter extends MLNInferenceAdapter {
	private static final String ALCHEMY_BIN_PATH_KEY = "Alchemy Executable Folder";
	private static final String INFER_BIN_KEY = "Alchemy Inference Executable";
	
	
	
	private String marginalKey = "";
	
	@Override
	public File getWorkingDirectory() {
		return new File(MLNGeneralParameter.fromKey(ALCHEMY_BIN_PATH_KEY).getValue());
	}
	
	/**
	 * Instantiates a new AlchemyInferenceAdapter and adds the Alchemy binary path and inference executable
	 * extracted from GeneralParameters.xml to the command string.
	 */
	public AlchemyInferenceAdapter() {
		addToCommandList(MLNGeneralParameter.fromKey(ALCHEMY_BIN_PATH_KEY).getValue()+
				MLNGeneralParameter.fromKey(INFER_BIN_KEY).getValue());
	}
	
	@Override
	public void addEvidenceFile(String filename) {
		if (filename != null) {
			List<String> commandList = getCommandList();
			if (commandList.contains("-e")) {
				commandList.set(commandList.indexOf("-e")+1, filename+","+commandList.get(commandList.indexOf("-e")+1));
			} else
				addSVToCommandList("-e",filename);
		}
	}

	@Override
	public void setQueryAtoms(List<String> queryAtoms) {
		addToCommandList("-q");
		StringBuffer addition = new StringBuffer();
		String comma = "";
		boolean first = true;
		for (String atom : queryAtoms) {
			addition.append(comma+atom);
			if (first) {
				comma = ",";
				first = false;
			}
		}
		addToCommandList(addition.toString());
	}

	@Override
	public void setInferenceType(MLNInferenceType type) {
		if (type.equals(MLNInferenceType.MAP)) {
			addToCommandList("-a");
		} else if (type.equals(MLNInferenceType.MARGINAL)){
			if (marginalKey.equals("") || (marginalKey.equals("-ms"))) {
				addToCommandList("-ms");
				marginalKey = "-ms";
			}
			else {
				addToCommandList("-p");
				marginalKey = "-p";
			}
		}
	}

	@Override
	public void setInputFile(String filename) {
		addSVToCommandList("-i",filename);
	}

	@Override
	public void setOutputFile(String filename) {
		addSVToCommandList("-r",filename);
	}

	@Override
	public void setQueryFile(String filename) {
	}
	
	@Override
	public void addOptionalParameter(MLNOptionalParameter parameter, List<String>
	arguments) throws MLNException {
	if (parameter.getKey().equals("Marginal Inference Type")) {
		if (marginalKey.equals("")) {
			marginalKey = arguments.get(0);
		} else {
			throw new RuntimeException();
		}
	} else {
		super.addOptionalParameter(parameter, arguments);
	}
}
	
}
