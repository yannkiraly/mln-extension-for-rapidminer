package com.rapidminer.operator.modelling;

import java.io.FileInputStream;
import java.util.LinkedHashMap;
import java.util.List;

import com.rapidminer.example.ExampleSet;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.operator.modelling.configuration.MLNFileType;
import com.rapidminer.operator.modelling.configuration.fixed.MLNFileRole;
import com.rapidminer.operator.modelling.converters.MLNConverter;
import com.rapidminer.operator.modelling.converters.exampleset.model.ExampleSetType;
import com.rapidminer.operator.modelling.model.MLNModel;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.parameter.ParameterType;
import com.rapidminer.parameter.ParameterTypeCategory;
import com.rapidminer.parameter.ParameterTypeFile;
import com.rapidminer.parameter.ParameterTypeInt;

/**
 * Specifies the overall structure of a MLN file reader operator and provides general functionality.
 * 
 * @author Yann Kiraly
 *
 */
public abstract class MLNAbstractFileReaderOperator extends MLNOperator {
	public static final String MLN_FILE = "MLN File";
	public static final String FILE_TYPE = "File Type";
	public static final String FILE_ROLE = "Role of File";
	public static final String ID_PARAM = "ID";
	
	protected abstract MLNFileRole getRole();

	private LinkedHashMap<ExampleSetType, OutputPort> outputPortMap;

	/**
	 * Creates an {@link MLNAbstractFileReaderOperator} instance and initializes its output ports.
	 * <p>
	 * Provides the required constructor passing on an OperatorDescription to the Operator constructor.
	 * Initializes the operator's output ports by creating one for every {@link ExampleSetType} required
	 * for the role specified by the implementing subclass. A generation rule is added for each port specifying
	 * that an ExampleSet is produced.
	 * 
	 * @param description: OperatorDescription RapidMiner requires to be accepted by all operator classes.
	 * @throws OperatorException
	 */
	public MLNAbstractFileReaderOperator(OperatorDescription description) throws OperatorException{
		super(description);
		initializeExampleSetOutputPorts();
	}
	
	private void initializeExampleSetOutputPorts() {
		OutputPort port;
		outputPortMap = new LinkedHashMap<ExampleSetType, OutputPort>();
		for (ExampleSetType type: getRole().getExampleSetTypes()) {
			port = getOutputPorts()
					.createPort(type.getTitle()+OUTPUT_PORT_EXTENSION);
			outputPortMap.put(type, port);
			getTransformer().addGenerationRule(port, ExampleSet.class);
		}
	}
	
	/**
	 * Imports an MLN file and converts it into an MLN model as well as a list of ExampleSets.
	 * 
	 */
	@Override
	public void doWork() throws OperatorException {
		LinkedHashMap<ExampleSetType, ExampleSet> exampleSetOutputMap = 
				new LinkedHashMap<ExampleSetType, ExampleSet>();
		MLNModel mlnModel;
		MLNFileType fileType = MLNFileType
				.fromKey(getParameterAsString(FILE_TYPE));
		try {
			MLNConverter converter = MLNConverter.getConverterForFileType(fileType,
					new FileInputStream(getParameterAsFile(MLN_FILE)
							.getAbsolutePath()));
			MLNConverter esConverter = MLNConverter.getConverterForExampleSets(null, exampleSetOutputMap);
			MLNFileRole role = getRole();
			mlnModel = converter.buildModel(role);
			if (getParameterAsInt(ID_PARAM)>-1) {
				mlnModel.setId((double) getParameterAsInt(ID_PARAM));
			}
			esConverter.convertModel(mlnModel, role);
			deliverOutput(exampleSetOutputMap, role);
		} catch (Exception e) {
			throw new OperatorException(e.getMessage(), e);
		}
	}

	
	/**
	 * Creates the file reader parameters.
	 * <p>
	 * This method creates two parameters for file readers. The first one indicates the type of the file to be 
	 * imported based on the file types specified in MLNFileTypeSpecification.xml. The second one contains the path of
	 * the MLN file.
	 * 
	 * @return List<ParameterType>: The parameters of the operator.
	 */
	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> types = super.getParameterTypes();
		String[] categoriesType = getTypeCategories();
		ParameterTypeCategory fileType = new ParameterTypeCategory(FILE_TYPE,
				"This parameter indicates the type of file to be imported.",
				categoriesType,0);
		fileType.setOptional(false);
		ParameterTypeInt idParam = new ParameterTypeInt(ID_PARAM, "Add this ID to the generated example sets. -1 indicates that no ID is to be added.",
				-1, Integer.MAX_VALUE, -1);
		idParam.setOptional(true);
		types.add(new ParameterTypeFile(MLN_FILE,"This parameter refers to a file containing first order logic rules.",
				null ,false, false));
		types.add(fileType);
		types.add(idParam);
		return types;
	}
	
	private String[] getTypeCategories() {
		MLNFileType[] values = MLNFileType.values();
		String [] categories = new String[values.length];
		for (int counter = 0; counter<values.length; counter++) {
			categories[counter] = values[counter].getKey();
		}
		return categories;
	}
	
	@Override
	protected LinkedHashMap<ExampleSetType, OutputPort> getOutputPortMap() {
		return this.outputPortMap;
	}
}
