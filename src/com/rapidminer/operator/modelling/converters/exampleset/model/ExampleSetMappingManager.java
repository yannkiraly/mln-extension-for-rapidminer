package com.rapidminer.operator.modelling.converters.exampleset.model;

import java.util.HashMap;

import com.rapidminer.example.table.BinominalMapping;
import com.rapidminer.example.table.PolynominalMapping;

public class ExampleSetMappingManager {
	private PolynominalMapping functionMapping, predicateMapping, argumentMapping,
	typeMapping, formulaMapping, probabilityMapping, groundFormulaMapping, returnValueMapping,
	closedWorldMapping;
	private BinominalMapping booleanMapping;
	
	public ExampleSetMappingManager() {
		initializeMappings();
	}
	
	private void initializeMappings() {
		functionMapping = new PolynominalMapping(new HashMap<Integer, String>());
		predicateMapping = new PolynominalMapping(new HashMap<Integer, String>());
		typeMapping = new PolynominalMapping(new HashMap<Integer, String>());
		formulaMapping = new PolynominalMapping(new HashMap<Integer, String>());
		booleanMapping = new BinominalMapping();
		argumentMapping = new PolynominalMapping(new HashMap<Integer, String>());
		functionMapping = new PolynominalMapping(new HashMap<Integer, String>());
		predicateMapping = new PolynominalMapping(new HashMap<Integer, String>());
		typeMapping = new PolynominalMapping(new HashMap<Integer, String>());
		booleanMapping = new BinominalMapping();
		argumentMapping = new PolynominalMapping(new HashMap<Integer, String>());
		probabilityMapping = new PolynominalMapping(new HashMap<Integer, String>());
		groundFormulaMapping = new PolynominalMapping(new HashMap<Integer, String>());
		returnValueMapping = new PolynominalMapping(new HashMap<Integer, String>());
		closedWorldMapping = new PolynominalMapping(new HashMap<Integer, String>());
	}

	public PolynominalMapping getFunctionMapping() {
		return functionMapping;
	}

	public PolynominalMapping getPredicateMapping() {
		return predicateMapping;
	}

	public PolynominalMapping getArgumentMapping() {
		return argumentMapping;
	}

	public PolynominalMapping getTypeMapping() {
		return typeMapping;
	}

	public PolynominalMapping getFormulaMapping() {
		return formulaMapping;
	}

	public BinominalMapping getBooleanMapping() {
		return booleanMapping;
	}
	
	public PolynominalMapping getProbabilityMapping() {
		return probabilityMapping;
	}

	public PolynominalMapping getGroundFormulaMapping() {
		return groundFormulaMapping;
	}

	public void setGroundFormulaMapping(PolynominalMapping groundFormulaMapping) {
		this.groundFormulaMapping = groundFormulaMapping;
	}

	public PolynominalMapping getReturnValueMapping() {
		return returnValueMapping;
	}

	public void setReturnValueMapping(PolynominalMapping returnValueMapping) {
		this.returnValueMapping = returnValueMapping;
	}

	protected PolynominalMapping getClosedWorldMapping() {
		return closedWorldMapping;
	}

	protected void setClosedWorldMapping(PolynominalMapping closedWorldMapping) {
		this.closedWorldMapping = closedWorldMapping;
	}

}
