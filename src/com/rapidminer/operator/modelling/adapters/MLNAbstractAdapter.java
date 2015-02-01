package com.rapidminer.operator.modelling.adapters;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.List;

import com.rapidminer.operator.OperatorException;
import com.rapidminer.operator.modelling.configuration.MLNOptionalParameter;
import com.rapidminer.operator.modelling.configuration.fixed.MLNError;
import com.rapidminer.operator.modelling.configuration.fixed.MLNException;
import com.rapidminer.operator.modelling.converters.utilities.ConverterUtilities;

/**
 * Provides the general structure of an MLN adapter as well as common functionality.
 * 
 * @author Yann Kiraly
 *
 */
public abstract class MLNAbstractAdapter {

	protected List<String> commandList;
	protected StringBuffer outputData;
	protected StringBuffer errorData;
	
	
	/**
	 * Sets the evidence file name to be passed to the MLN tool.
	 * 
	 * @param filename: Evidence filename
	 * @throws OperatorException
	 */
	public abstract void addEvidenceFile(String filename);
	
	/**
	 * Sets the input (rule) file name to be passed to the MLN tool.
	 * 
	 * @param filename: Input (rule) filename
	 * @throws OperatorException
	 */
	public abstract void setInputFile(String filename);
	
	/**
	 * Sets the output file name to be passed to the MLN tool.
	 * 
	 * @param filename: Output filename
	 * @throws OperatorException
	 */
	public abstract void setOutputFile(String filename);
	
	private File workingDirectory;
	
	/**
	 * Sets the working directory of the process.
	 * 
	 * @param workingDirectory: Directory the process is to be executed in.
	 */
	public void setWorkingDirectory(File workingDirectory) {
		this.workingDirectory = workingDirectory;
	}
	
	/**
	 * Returns the working directory of the process.
	 *  
	 * @return File: Directory the process is executed in.
	 */
	public File getWorkingDirectory() {
		return workingDirectory;
	}
	
	private static final int LINE_LIMIT_OUTPUT = 100;
	private static final int LINE_LIMIT_ERRORS = 100;
	
	
	/**
	 * Instantiates and initializes an abstract adapter.
	 */
	public MLNAbstractAdapter() {
		commandList = new ArrayList<String>();
		outputData = new StringBuffer();
		errorData = new StringBuffer();
	}
	
	protected void record(InputStream stream, StringBuffer storage, int lineLimit) throws MLNException {
		String line;
		int lineCounter = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(stream));
		try {
			while ( (line = br.readLine()) != null && lineCounter<lineLimit) {
				storage.append(line+"\n");
				lineLimit++;
			}
		} catch (IOException e) {
			MLNError.FILE_NOT_FOUND.exception();
		}
	}
	
	protected void addSVToCommandList(String switchS, String filename) {
		commandList.add(switchS);
		commandList.add(filename);
	}
	
	protected void addToCommandList(String commandElement) {
		commandList.add(commandElement);
	}
	
	/**
	 * Adds an optional parameter to be sent to the MLN tool.
	 * <p>
	 * 
	 * 
	 * @param parameter: Optional parameter definition based on an entry in OptionalParameterSpecifications.xml.
	 * @param arguments: Arguments of the optional parameter in String form.
	 */
	public void addOptionalParameter(MLNOptionalParameter parameter, List<String>
		arguments) throws MLNException {
		addToCommandList(parameter.getFlag());
		if (!arguments.isEmpty()) {
			for (String argument: arguments) {
				addToCommandList(argument);
			}
		}
	}
	
	protected void clearCommandString() {
		commandList = new ArrayList<String>();
	}
	
	private void printCommandList() {
		StringBuffer commandString = new StringBuffer();
		String s = " ";
		for (String e : commandList) {
			commandString.append(s+e+s);
		}
	}
	
	/**
	 * Sends the commands specified to an MLN tool.
	 * <p>
	 * Starts a process of an MLN tool and sends the command string specified by the implementing concrete class to it.
	 * Collects the output of the process and dumps it to the console.
	 * 
	 * @throws OperatorException
	 */
	public void perform() throws MLNException {
		printCommandList();
		ProcessBuilder pb = new ProcessBuilder(commandList);
		//pb.directory(getWorkingDirectory());
		System.out.println(ConverterUtilities.listToString(commandList, " "));
		Process p;
		try {
			p = pb.start();
			p.waitFor();
			record(p.getInputStream(), outputData, LINE_LIMIT_OUTPUT);
			record(p.getErrorStream(), errorData, LINE_LIMIT_ERRORS);
			System.out.println("MLN Software Output:\n "+outputData);
			System.out.println("MLN Software Errors:\n "+errorData);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} catch (IOException e1) {
			MLNError.FILE_NOT_FOUND.exception();
		}
	}

	protected List<String> getCommandList() {
		return commandList;
	}

}
