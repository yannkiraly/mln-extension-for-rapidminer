package com.rapidminer.operator.modelling;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.rapidminer.example.ExampleSet;
import com.rapidminer.operator.Annotations;
import com.rapidminer.operator.IOObject;
import com.rapidminer.operator.Operator;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.operator.modelling.configuration.MLNEngine;
import com.rapidminer.operator.modelling.configuration.MLNOptionalParameter;
import com.rapidminer.operator.modelling.configuration.fixed.MLNFileRole;
import com.rapidminer.operator.modelling.configuration.xmlimportexport.ConfigurationReader;
import com.rapidminer.operator.modelling.converters.MLNConverter;
import com.rapidminer.operator.modelling.converters.exampleset.model.ExampleSetType;
import com.rapidminer.operator.modelling.model.MLNModel;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.ports.metadata.ExampleSetMetaData;
import com.rapidminer.operator.ports.metadata.MetaData;
import com.rapidminer.operator.ports.metadata.SimplePrecondition;

/**
 * Provides common MLN operator functionality.
 * 
 * @author Yann Kiraly
 *
 */
public abstract class MLNOperator extends Operator {
	protected static final int MIN_LIST_KEY = 0;
	protected static final int MAX_LIST_KEY = 100;
	protected static final String FILENAME_KEY ="file name";
	protected static final String MLNMODEL_KEY = "mlnmodel";
	protected static final String EXAMPLE_SET_TYPE_KEY = "example set type";
	protected static final String FILE_ROLE_KEY = "role";
	protected static final String OUTPUT_FILE_EXTENSION = "Output.mln";
	protected static final String OUTPUT_PORT_EXTENSION = " output port";
	protected static final String CONFIG_PARAM_KEY = "MLN Configuration";
	protected static final String CONFIG_PARAM_DESC = "Select or create an MLN configuration";
	protected static final String CONFIG_STRING = "mlnconfig";
	
	
	private static boolean configurationLoaded = false;
	
	protected abstract LinkedHashMap<ExampleSetType, OutputPort> getOutputPortMap();

	
	protected MLNOperator(OperatorDescription description) throws OperatorException {
		super(description);
		loadConfiguration();
	}
	
	protected static void loadOptionalParameterConfiguration(Operator operator) throws OperatorException {
		try {
			ConfigurationReader.loadOptionalParameters(operator);
			MLNOptionalParameter.injectAll();
		} catch (Exception e) {
			throw new OperatorException(e.getMessage(), e);
		}
	}
	
	//TODO: Make protected again.
	public static void loadConfiguration() throws OperatorException {
		if (!configurationLoaded) {
			try {
				ConfigurationReader.loadGeneralParameters();
				ConfigurationReader.loadMlnEngines();
				MLNEngine engine = MLNEngine.fromKey("Tuffy");
				ConfigurationReader.loadMlnFileTypes();
				MLNEngine.injectAll();
				MLNOptionalParameter.injectAll();
			} catch (Exception e) {
				throw new OperatorException(e.getMessage(), e);
			}
			configurationLoaded = true;
		}
	}
	
	protected MetaData buildExpectedMDRole(IOObject obj, MLNFileRole role) {
		MetaData md = MetaData.forIOObject(obj);
		Annotations annotations = new Annotations();
		annotations.put(MLNFileRole.METADATA_KEY, role.name());
		md.setAnnotations(annotations);
		return md;
	}

	protected List<String> buildListFromKeyValuePairs(List<String[]> pairs, int index) {
		List<String> list = new ArrayList<String>();
		for (String[] entry : pairs) {
			list.add(entry[index]);
		}
		return list;
	}
	
	protected void addRolePrecondition(InputPort port, IOObject obj, MLNFileRole role, boolean mandatory) {
		port.addPrecondition(new SimplePrecondition(port,
				buildExpectedMDRole(obj, role), mandatory));
	}
	
	protected String getFilenameFromMD(Annotations md) {
		return md.getAnnotation(FILENAME_KEY);
	}
	
	protected static String getFilename(String path) {
		String sep;
		if (System.lineSeparator().equals("\n")) {
			sep = "/";
		} else {
			sep = "\\";
		}
		return path.substring(findIndexAfterLast(path, sep));
	}
	
	private static int findIndexAfterLast(String strToSearch, String strToFind) {
		int lastIndex=0, newIndex=0;
		boolean first = true;
		while (newIndex != -1) {
			if (!first) {
				lastIndex = newIndex;
			} else {
				first = false;
			}
			newIndex = strToSearch.indexOf(strToFind, lastIndex+1);
		}
		return lastIndex+((lastIndex==0)?0:1);
	}
	
	protected static List<String[]> listToPairs(List<String> list, int startIndex) {
		List<String[]> pairs = new ArrayList<String[]>();
		String[] pair;
		int counter = startIndex;
		for (String str : list) {
			pair = new String[2];
			pair[0] = Integer.toString(counter);
			pair[1] = str;
			pairs.add(pair);
		}
		return pairs;
	}
	
	protected void deliverOutput(Map<ExampleSetType, ExampleSet> exampleSetOutputMap,
			MLNFileRole role) throws OperatorException {
		OutputPort port;
		ExampleSet set;
		for (ExampleSetType type: exampleSetOutputMap.keySet()) {
			port = getOutputPortMap().get(type);
			if (port == null)
				throw new OperatorException("Produced example sets and existing output ports are not compatible.");
			if (exampleSetOutputMap.containsKey(type)) {
				set = exampleSetOutputMap.get(type);
				set.setSource(type.getTitle());
				set.getAnnotations().setAnnotation(EXAMPLE_SET_TYPE_KEY, type.name());
				set.getAnnotations().setAnnotation(FILE_ROLE_KEY, role.name());
				ExampleSetMetaData emd = new ExampleSetMetaData(set, true);
				emd.setNumberOfExamples(exampleSetOutputMap.get(type).size());
				port.deliver(set);
				port.deliverMD(emd);
			} else {
				port.deliver(MLNConverter.getEmptyExampleSet());
			}
		}
	}
	
	protected void deliverOutput(Map<ExampleSetType, ExampleSet> exampleSetOutputMap,
			MLNFileRole role, MLNModel model) throws OperatorException {
		OutputPort port;
		ExampleSet set;
		for (ExampleSetType type: exampleSetOutputMap.keySet()) {
			port = getOutputPortMap().get(type);
			if (port == null)
				throw new OperatorException("Produced example sets and existing output ports are not compatible.");
			if (exampleSetOutputMap.containsKey(type)) {
				set = exampleSetOutputMap.get(type);
				set.setSource(type.getTitle());
				set.getAnnotations().setAnnotation(EXAMPLE_SET_TYPE_KEY, type.name());
				set.getAnnotations().setAnnotation(FILE_ROLE_KEY, role.name());
				ExampleSetMetaData emd = new ExampleSetMetaData(set, true);
				emd.setNumberOfExamples(exampleSetOutputMap.get(type).size());
				port.deliver(set);
				port.deliverMD(emd);
			} else {
				port.deliver(MLNConverter.getEmptyExampleSet());
			}
		}
	}
}
