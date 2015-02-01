package com.rapidminer.operator.modelling;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.rapidminer.example.ExampleSet;
import com.rapidminer.example.ExampleSetFactory;
import com.rapidminer.operator.IOObject;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.operator.modelling.configuration.fixed.MLNException;
import com.rapidminer.operator.modelling.configuration.fixed.MLNFileRole;
import com.rapidminer.operator.modelling.converters.MLNConverter;
import com.rapidminer.operator.modelling.converters.exampleset.model.ExampleSetType;
import com.rapidminer.operator.modelling.converters.utilities.ConverterUtilities;
import com.rapidminer.operator.modelling.model.MLNModel;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;

public class MLNRemoveVariableWeightsOperator extends MLNOperator {
	
	private LinkedHashMap<ExampleSetType, InputPort> inputPortMap;
	protected LinkedHashMap<ExampleSetType, OutputPort> outputPortMap;
	private OutputPort varFormulaPort, replacementFormulaPort;


	public MLNRemoveVariableWeightsOperator(OperatorDescription description)
			throws OperatorException {
		super(description);
		initializeInputPorts();
		initializeOutputPortMap();
	}
	
	private void initializeOutputPortMap() {
		OutputPort port;
		outputPortMap = new LinkedHashMap<ExampleSetType, OutputPort>();
		for (ExampleSetType type: MLNFileRole.RULES.getExampleSetTypes()) {
			port = getOutputPorts()
					.createPort(type.getTitle()+OUTPUT_PORT_EXTENSION);
			getOutputPortMap().put(type, port);
			getTransformer().addGenerationRule(port, ExampleSet.class);
		}
		for (ExampleSetType type: MLNFileRole.EVIDENCE.getExampleSetTypes()) {
			port = getOutputPorts()
					.createPort(type.getTitle()+OUTPUT_PORT_EXTENSION);
			getOutputPortMap().put(type, port);
			getTransformer().addGenerationRule(port, ExampleSet.class);
		}
		varFormulaPort = getOutputPorts().createPort("Variable Weighted Formulas");
		getTransformer().addGenerationRule(varFormulaPort, ExampleSet.class);
		replacementFormulaPort = getOutputPorts().createPort("Weighted Formulas");
		getTransformer().addGenerationRule(replacementFormulaPort, ExampleSet.class);
	}
	
	protected void initializeInputPorts() throws OperatorException {
		InputPort port;
		inputPortMap = new LinkedHashMap<ExampleSetType, InputPort>();
		for (ExampleSetType type : MLNFileRole.RULES.getExampleSetTypes()) {
			port = getInputPorts().createPort(type.getTitle(), ExampleSet.class);
			inputPortMap.put(type, port);
			setRolePreconditions(MLNFileRole.RULES, ExampleSet.class, false, port);
		}
		for (ExampleSetType type : MLNFileRole.EVIDENCE.getExampleSetTypes()) {
			port = getInputPorts().createPort(type.getTitle(), ExampleSet.class);
			inputPortMap.put(type, port);
			setRolePreconditions(MLNFileRole.EVIDENCE, ExampleSet.class, false, port);
		}
	}
	
	protected void setRolePreconditions(MLNFileRole role, Class<? extends IOObject> outputClass, boolean mandatory,
			InputPort... ports) 
	throws OperatorException {
		double[][] arr = new double[1][1];
		IOObject obj = null;
		if (outputClass.equals(ExampleSet.class)) {
			MLNLearnInferOperator.fillDummyArray(arr);
			obj = ExampleSetFactory.createExampleSet(arr);
		} else if (outputClass.equals(MLNModel.class)){
			try {
				obj = new MLNModel();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		for (InputPort port: ports) {
			addRolePrecondition(port, obj, role, mandatory);
		}
	}
	
	@Override
	protected LinkedHashMap<ExampleSetType, OutputPort> getOutputPortMap() {
		return outputPortMap;
	}
	
	protected static MLNModel buildMLNModel(Map<ExampleSetType, ExampleSet> inputData, String... roleKeys) 
			throws OperatorException {
		MLNModel mlnModel = null;
		ExampleSet set;
		String roleAnnotation;
		MLNFileRole setRole;
		for (Map.Entry<ExampleSetType, ExampleSet> entry: inputData.entrySet()) {
				set = entry.getValue();
				roleAnnotation = set.getAnnotations().get(FILE_ROLE_KEY);
				if (roleAnnotation == null) {
					setRole = MLNLearnInferOperator.getFileRoleForExampleSetType(entry.getKey());
					if (setRole == null)
						throw new OperatorException("File role could not be identified.");
				} else {
					setRole = MLNFileRole.valueOf(roleAnnotation);
				}
				if (ConverterUtilities.arrayContains(roleKeys, setRole.getKey())) {
					if (mlnModel == null) {
						mlnModel = MLNLearnInferOperator.convertToModel(set, entry.getKey(), setRole);
					} else {
						mlnModel = MLNLearnInferOperator.convertToModel(set, entry.getKey(), setRole, mlnModel);
					}
				}
		}
		if (mlnModel == null)
			try {
				mlnModel = new MLNModel();
			} catch (Exception e) {
				throw new OperatorException(e.getMessage());
			}
		return mlnModel;
	}
	
	public void doWork() throws OperatorException {
		Double id;
		LinkedHashMap<ExampleSetType, ExampleSet> exampleSetMap = new LinkedHashMap<ExampleSetType, ExampleSet>();
		MLNConverter esConverter;
		MLNModel sourceModel = buildMLNModel(getInputData(), MLNFileRole.RULES.getKey(), MLNFileRole.EVIDENCE.getKey());
		MLNModel varFormulas, replacementFormulas;
		id = sourceModel.getId();
		try {
			varFormulas = new MLNModel();
			replacementFormulas = new MLNModel();
		} catch (InstantiationException e1) {
			throw new OperatorException(e1.getMessage());
		} catch (IllegalAccessException e1) {
			throw new OperatorException(e1.getMessage());
		}
		MLNLearnInferOperator.removeVariableWeights(sourceModel, varFormulas, replacementFormulas);
		sourceModel.setId(id);
		varFormulas.setId(id);
		replacementFormulas.setId(id);
		esConverter = MLNConverter.getConverterForExampleSets(null, exampleSetMap);
		try {
			esConverter.convertModel(sourceModel, MLNFileRole.RULES);
		} catch (MLNException e) {
			throw new OperatorException(e.getMessage());
		}
		deliverOutput(exampleSetMap, MLNFileRole.RULES);
		exampleSetMap = new LinkedHashMap<ExampleSetType, ExampleSet>();
		esConverter = MLNConverter.getConverterForExampleSets(null, exampleSetMap);
		try {
			esConverter.convertModel(sourceModel, MLNFileRole.EVIDENCE);
		} catch (MLNException e) {
			throw new OperatorException(e.getMessage());
		}
		deliverOutput(exampleSetMap, MLNFileRole.EVIDENCE);
		exampleSetMap = new LinkedHashMap<ExampleSetType, ExampleSet>();
		esConverter = MLNConverter.getConverterForExampleSets(null, exampleSetMap);
		try {
			esConverter.convertModel(varFormulas, MLNFileRole.RULES);
		} catch (MLNException e) {
			throw new OperatorException(e.getMessage());
		}
		varFormulaPort.deliver(exampleSetMap.get(ExampleSetType.Formula));
		exampleSetMap = new LinkedHashMap<ExampleSetType, ExampleSet>();
		esConverter = MLNConverter.getConverterForExampleSets(null, exampleSetMap);
		try {
			esConverter.convertModel(replacementFormulas, MLNFileRole.RULES);
		} catch (MLNException e) {
			throw new OperatorException(e.getMessage());
		}
		replacementFormulaPort.deliver(exampleSetMap.get(ExampleSetType.Formula));
	}
	
	private Map<ExampleSetType, ExampleSet> getInputData() throws OperatorException {
		Map<ExampleSetType, ExampleSet> map = new HashMap<ExampleSetType, ExampleSet>();
		for (Map.Entry<ExampleSetType, InputPort> entry: inputPortMap.entrySet()) {
			map.put(entry.getKey(), entry.getValue().getData(ExampleSet.class));
		}
		return map;
	}

}
