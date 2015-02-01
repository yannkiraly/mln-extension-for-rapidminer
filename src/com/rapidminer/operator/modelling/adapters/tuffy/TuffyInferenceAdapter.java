package com.rapidminer.operator.modelling.adapters.tuffy;

import java.io.File;
import java.util.List;

import com.rapidminer.operator.modelling.adapters.MLNInferenceAdapter;
import com.rapidminer.operator.modelling.configuration.MLNGeneralParameter;
import com.rapidminer.operator.modelling.configuration.MLNOptionalParameter;
import com.rapidminer.operator.modelling.configuration.fixed.MLNException;
import com.rapidminer.operator.modelling.configuration.fixed.MLNInferenceType;

/**
 * Defines an implementation of an inference adapter for Tuffy.
 * 
 * @author Yann Kiraly
 *
 */
public class TuffyInferenceAdapter extends MLNInferenceAdapter {
	public static final String TUFFY_PATH_KEY = "Tuffy JAR Folder";
	public static final String TUFFY_JAR_KEY = "Tuffy JAR";
	public static final String TUFFY_CONF_KEY = "Tuffy Configuration File";
	private static final String MAX_MEMORY_KEY = "Maximum memory use";
	
	MLNInferenceType inferenceType = null;
	
	@Override
	public File getWorkingDirectory() {
		return new File(MLNGeneralParameter.fromKey(TUFFY_PATH_KEY).getValue());
	}
	
	/**
	 * Instantiates a new TuffyInferenceAdapter and adds the Tuffy binary path, inference executable
	 * and configuration file path extracted from GeneralParameters.xml to the command string.
	 */
	public TuffyInferenceAdapter() {
		addToCommandList("java");
		addSVToCommandList("-jar",MLNGeneralParameter.fromKey(TUFFY_PATH_KEY).getValue()
				+MLNGeneralParameter.fromKey(TUFFY_JAR_KEY).getValue());
		addSVToCommandList("-conf", MLNGeneralParameter.fromKey(TUFFY_CONF_KEY).getValue());
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
	public void setQueryFile(String filename) {
		addSVToCommandList("-queryFile", filename);
	}

	@Override
	public void setInferenceType(MLNInferenceType type)
			throws MLNException {
		if (type.equals(MLNInferenceType.MARGINAL)) { 
			addToCommandList("-marginal");
		}
	}

	@Override
	public void setInputFile(String filename) {
		addSVToCommandList("-i", filename);
	}

	@Override
	public void setOutputFile(String filename) {
		addSVToCommandList("-o", filename);
	}
	
	@Override
	public void setQueryAtoms(List<String> queryAtoms) {
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
