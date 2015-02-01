package com.rapidminer.operator.modelling;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.rapidminer.example.ExampleSet;
import com.rapidminer.example.ExampleSetFactory;
import com.rapidminer.operator.IOObject;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.operator.modelling.configuration.fixed.MLNException;
import com.rapidminer.operator.modelling.configuration.fixed.MLNFileRole;
import com.rapidminer.operator.modelling.converters.MLNConverter;
import com.rapidminer.operator.modelling.converters.exampleset.model.ExampleSetModel;
import com.rapidminer.operator.modelling.converters.exampleset.model.ExampleSetType;
import com.rapidminer.operator.modelling.converters.utilities.ConverterUtilities;
import com.rapidminer.operator.modelling.model.MLNModel;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.InputPortExtender;
import com.rapidminer.operator.ports.OutputPort;

public class MLNReinsertVariableWeightsOperator extends MLNOperator {
	
	private LinkedHashMap<ExampleSetType, InputPort> inputPortMap;
	protected LinkedHashMap<ExampleSetType, OutputPort> outputPortMap;
	private InputPortExtender varFormulaPort, replacementFormulaPort;


	public MLNReinsertVariableWeightsOperator(OperatorDescription description)
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
	}
	
	protected void initializeInputPorts() throws OperatorException {
		InputPort port;
		inputPortMap = new LinkedHashMap<ExampleSetType, InputPort>();
		for (ExampleSetType type : MLNFileRole.RULES.getExampleSetTypes()) {
			port = getInputPorts().createPort(type.getTitle(), ExampleSet.class);
			inputPortMap.put(type, port);
			setRolePreconditions(MLNFileRole.RULES, ExampleSet.class, false, port);
		}
		varFormulaPort = new InputPortExtender("Variable Weight Formulas", getInputPorts());
		varFormulaPort.ensureMinimumNumberOfPorts(1);
		varFormulaPort.start();
		replacementFormulaPort = new InputPortExtender("Weighted Formulas", getInputPorts());
		replacementFormulaPort.ensureMinimumNumberOfPorts(1);
		replacementFormulaPort.start();
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
		LinkedHashMap<ExampleSetType, ExampleSet> exampleSetMap = new LinkedHashMap<ExampleSetType, ExampleSet>();
		MLNConverter esConverter;
		Map<ExampleSetType, ExampleSet> varFormulaMap = new HashMap<ExampleSetType, ExampleSet>(),
				replacementFormulaMap = new HashMap<ExampleSetType, ExampleSet>();
		MLNModel sourceModel, varFormulas, replacementFormulas;
		List<ExampleSet> varFormulaSets = varFormulaPort.getData(ExampleSet.class, false),
				replacementSets = replacementFormulaPort.getData(ExampleSet.class, false);
		sourceModel = buildMLNModel(getInputData(), MLNFileRole.RULES.getKey());
		Double id = sourceModel.getId();
		for (int counter = 0; counter < varFormulaSets.size(); counter++) {
			for (ExampleSetType type: MLNFileRole.RULES.getExampleSetTypes()) {
				if (type.equals(ExampleSetType.Formula)) {
					varFormulaMap.put(type, varFormulaSets.get(counter));
					if (counter < replacementSets.size())
						replacementFormulaMap.put(type, replacementSets.get(counter));
					else
						throw new RuntimeException();
				} else {
					varFormulaMap.put(type, ExampleSetModel.getEmptyExampleSet());
					replacementFormulaMap.put(type, ExampleSetModel.getEmptyExampleSet());
				}
			}
			varFormulas = buildMLNModel(varFormulaMap, MLNFileRole.RULES.getKey());
			replacementFormulas = buildMLNModel(replacementFormulaMap, MLNFileRole.RULES.getKey());
			MLNLearnInferOperator.reinstertVariableWeights(sourceModel, varFormulas, replacementFormulas);
			varFormulaMap = new HashMap<ExampleSetType, ExampleSet>();
			replacementFormulaMap = new HashMap<ExampleSetType, ExampleSet>();
		}
		esConverter = MLNConverter.getConverterForExampleSets(null, exampleSetMap);
		sourceModel.setId(id);
		try {
			esConverter.convertModel(sourceModel, MLNFileRole.RULES);
		} catch (MLNException e) {
			throw new OperatorException(e.getMessage());
		}
		deliverOutput(exampleSetMap, MLNFileRole.RULES);
	}
	
	private Map<ExampleSetType, ExampleSet> getInputData() throws OperatorException {
		Map<ExampleSetType, ExampleSet> map = new HashMap<ExampleSetType, ExampleSet>();
		for (Map.Entry<ExampleSetType, InputPort> entry: inputPortMap.entrySet()) {
			map.put(entry.getKey(), entry.getValue().getData(ExampleSet.class));
		}
		return map;
	}

}
