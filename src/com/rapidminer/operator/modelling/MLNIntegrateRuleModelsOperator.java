package com.rapidminer.operator.modelling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.rapidminer.example.ExampleSet;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.operator.modelling.configuration.fixed.MLNException;
import com.rapidminer.operator.modelling.configuration.fixed.MLNFileRole;
import com.rapidminer.operator.modelling.converters.MLNConverter;
import com.rapidminer.operator.modelling.converters.exampleset.model.ExampleSetModel;
import com.rapidminer.operator.modelling.converters.exampleset.model.ExampleSetType;
import com.rapidminer.operator.modelling.converters.utilities.ConverterUtilities;
import com.rapidminer.operator.modelling.model.MLNModel;
import com.rapidminer.operator.ports.InputPortExtender;
import com.rapidminer.operator.ports.OutputPort;

public class MLNIntegrateRuleModelsOperator extends MLNOperator {
	
	private LinkedHashMap<ExampleSetType, InputPortExtender> inputPortMap;
	protected LinkedHashMap<ExampleSetType, OutputPort> outputPortMap;


	public MLNIntegrateRuleModelsOperator(OperatorDescription description)
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
		InputPortExtender port;
		inputPortMap = new LinkedHashMap<ExampleSetType, InputPortExtender>();
		for (ExampleSetType type : MLNFileRole.RULES.getExampleSetTypes()) {
			port = new InputPortExtender(type.getTitle(), getInputPorts());
			inputPortMap.put(type, port);
			port.start();
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
		MLNModel targetModel=null, sourceModel;
		for (Map<ExampleSetType, ExampleSet> inputData: getInputData()) {
			sourceModel = buildMLNModel(inputData, MLNFileRole.RULES.getKey());
			if (targetModel == null)
				targetModel = sourceModel;
			else
				targetModel.integrateModel(sourceModel);
		}
		esConverter = MLNConverter.getConverterForExampleSets(null, exampleSetMap);
		try {
			if (targetModel!=null)
				esConverter.convertModel(targetModel, MLNFileRole.RULES);
		} catch (MLNException e) {
			throw new OperatorException(e.getMessage());
		}
		deliverOutput(exampleSetMap, MLNFileRole.RULES);
	}
	
	private List<Map<ExampleSetType, ExampleSet>> getInputData() throws OperatorException {
		Map<ExampleSetType, ExampleSet> map;
		List<Map<ExampleSetType, ExampleSet>> list = new ArrayList<Map<ExampleSetType, ExampleSet>>();
		List<ExampleSet> formulaSets=inputPortMap.get(ExampleSetType.Formula).getData(ExampleSet.class, false), 
				typeSets=inputPortMap.get(ExampleSetType.TypeDecl).getData(ExampleSet.class, false), 
				predicateSets=inputPortMap.get(ExampleSetType.PredicateDecl).getData(ExampleSet.class, false), 
				functionSets=inputPortMap.get(ExampleSetType.FunctionDecl).getData(ExampleSet.class, false);
		for (int counter = 0; counter < formulaSets.size(); 
				counter++) {
			map = new HashMap<ExampleSetType, ExampleSet>();
			map.put(ExampleSetType.Formula, formulaSets.get(counter));
			if (predicateSets.size()>counter)
				map.put(ExampleSetType.PredicateDecl, predicateSets.get(counter));
			else
				map.put(ExampleSetType.PredicateDecl, ExampleSetModel.getEmptyExampleSet());
			if (functionSets.size()>counter)
				map.put(ExampleSetType.FunctionDecl, functionSets.get(counter));
			else
				map.put(ExampleSetType.FunctionDecl, ExampleSetModel.getEmptyExampleSet());
			if (typeSets.size()>counter)
				map.put(ExampleSetType.TypeDecl, typeSets.get(counter));
			else
				map.put(ExampleSetType.TypeDecl, ExampleSetModel.getEmptyExampleSet());
			list.add(map);
			
		}
		return list;
	}

}
