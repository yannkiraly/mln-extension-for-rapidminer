package com.rapidminer.operator.modelling.adapters.rockit;

import java.io.File;
import java.util.List;

import com.rapidminer.operator.modelling.adapters.MLNInferenceAdapter;
import com.rapidminer.operator.modelling.configuration.MLNGeneralParameter;
import com.rapidminer.operator.modelling.configuration.MLNOptionalParameter;
import com.rapidminer.operator.modelling.configuration.fixed.MLNException;
import com.rapidminer.operator.modelling.configuration.fixed.MLNInferenceType;

/**
 * Defines an implementation of an inference adapter for Rockit.
 * 
 * @author Yann Kiraly
 *
 */
public class RockitInferenceAdapter extends MLNInferenceAdapter {
	private static final String ROCKIT_PATH_KEY = "Rockit JAR Folder";
	private static final String ROCKIT_JAR_KEY = "Rockit JAR";
	private static final String ROCKIT_PROPERTIES_KEY = "Rockit Configuration File";
	private static final String MAX_MEMORY_KEY = "Maximum memory use";

	@Override
	public File getWorkingDirectory() {
		return new File(MLNGeneralParameter.fromKey(ROCKIT_PATH_KEY).getValue());
	}
	
	/**
	 * Instantiates a new RockitInferenceAdapter and adds the Rockit binary path, inference executable and properties file path
	 * extracted from GeneralParameters.xml to the command string.
	 */
	public RockitInferenceAdapter() {
		addToCommandList("java");
		addSVToCommandList("-jar",MLNGeneralParameter.fromKey(ROCKIT_PATH_KEY).getValue()+
				MLNGeneralParameter.fromKey(ROCKIT_JAR_KEY).getValue());
		addSVToCommandList("-para", MLNGeneralParameter.fromKey(ROCKIT_PATH_KEY).getValue()+
				MLNGeneralParameter.fromKey(ROCKIT_PROPERTIES_KEY).getValue());
	}
	
	@Override
	public void addEvidenceFile(String filename) {
		if (filename != null) {
			addSVToCommandList("-data",filename);
		}
	}

	@Override
	public void setInferenceType(MLNInferenceType type) throws MLNException {
		if (type.equals(MLNInferenceType.MARGINAL)) {
			addToCommandList("-marginal");
		}
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
	public void setQueryFile(String filename) {
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
