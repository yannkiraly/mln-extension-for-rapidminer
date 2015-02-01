package com.rapidminer.operator.modelling.converters.exampleset.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rapidminer.example.Attribute;
import com.rapidminer.example.table.AttributeFactory;
import com.rapidminer.example.table.NominalMapping;
import com.rapidminer.tools.Ontology;

public class ExampleSetAttributeManager {
	
	private Map<ExampleSetType, List<Attribute>> attributeLists;
	private ExampleSetMappingManager mappingManager;
	
	public ExampleSetAttributeManager(List<ExampleSetType> types) {
		this(types, false);
	}
	
	public ExampleSetAttributeManager(List<ExampleSetType> types, boolean hasId) {
		attributeLists = new HashMap<ExampleSetType, List<Attribute>>();
		mappingManager = new ExampleSetMappingManager();
		initializeAttributes(types, hasId);
	}
	
	private void initializeAttributes(List<ExampleSetType> types, boolean hasId) {
		if (types.contains(ExampleSetType.TypeDecl)) {
			attributeLists.put(ExampleSetType.TypeDecl, createTypeDeclAttributes(hasId));
		}
		if (types.contains(ExampleSetType.FunctionDecl)) {
			attributeLists.put(ExampleSetType.FunctionDecl, createFunctionDeclAttributes(hasId));
		}
		if (types.contains(ExampleSetType.PredicateDecl)) {
			attributeLists.put(ExampleSetType.PredicateDecl, createPredicateDeclAttributes(hasId));
		}
		if (types.contains(ExampleSetType.QueryPredicateDecl)) {
			attributeLists.put(ExampleSetType.QueryPredicateDecl, createPredicateDeclAttributes(hasId));
		}
		if (types.contains(ExampleSetType.Formula)) {
			attributeLists.put(ExampleSetType.Formula, createFormulaAttributes(hasId));
		}
		if (types.contains(ExampleSetType.GroundFormula)) {
			attributeLists.put(ExampleSetType.GroundFormula, createGroundFormulaAttributes(hasId));
		}
		if (types.contains(ExampleSetType.ProbabilityStatement)) { 
			attributeLists.put(ExampleSetType.ProbabilityStatement, createProbabilityStatementAttributes(hasId));
		}
	}
	
	private List<Attribute> createProbabilityStatementAttributes(boolean hasId) {
		List<Attribute> attributes = new ArrayList<Attribute>();
		attributes.add(createAttribute(ExampleSetBuilderOntology.GF_RETURNVALUE, Ontology.STRING, 
				mappingManager.getPredicateMapping()));
		attributes.add(createAttribute(ExampleSetBuilderOntology.GF_ATOM_FUNCTION, Ontology.STRING, 
				mappingManager.getArgumentMapping()));
		attributes.add(createAttribute(ExampleSetBuilderOntology.GF_NEGATION, Ontology.BINOMINAL, 
				mappingManager.getBooleanMapping()));
		attributes.add(createAttribute(ExampleSetBuilderOntology.PS_PROBABILITY, Ontology.STRING,
				mappingManager.getProbabilityMapping()));
		if (hasId) {
			attributes.add(createAttribute(ExampleSetBuilderOntology.ID, Ontology.NUMERICAL));
		}
		return attributes;
	}
	
	private List<Attribute> createGroundFormulaAttributes(boolean hasId) {
		List<Attribute> attributes = new ArrayList<Attribute>();
		attributes.add(createAttribute(ExampleSetBuilderOntology.GF_RETURNVALUE, Ontology.STRING, 
				mappingManager.getReturnValueMapping()));
		attributes.add(createAttribute(ExampleSetBuilderOntology.GF_ATOM_FUNCTION, Ontology.STRING, 
				mappingManager.getGroundFormulaMapping()));
		attributes.add(createAttribute(ExampleSetBuilderOntology.GF_NEGATION, Ontology.BINOMINAL, 
				mappingManager.getBooleanMapping()));
		if (hasId) {
			attributes.add(createAttribute(ExampleSetBuilderOntology.ID, Ontology.NUMERICAL));
		}
		return attributes;
	}
	
	private List<Attribute> createTypeDeclAttributes(boolean hasId) {
		List<Attribute> attributes = new ArrayList<Attribute>();
		attributes.add(createAttribute(ExampleSetBuilderOntology.TD_TYPE, Ontology.STRING, 
				mappingManager.getTypeMapping()));
		attributes.add(createAttribute(ExampleSetBuilderOntology.TD_VALUES, Ontology.STRING, 
				mappingManager.getArgumentMapping()));
		if (hasId) {
			attributes.add(createAttribute(ExampleSetBuilderOntology.ID, Ontology.NUMERICAL));
		}
		return attributes;
	}
	
	private List<Attribute> createPredicateDeclAttributes(boolean hasId) {
		List<Attribute> attributes = new ArrayList<Attribute>();
		attributes.add(createAttribute(ExampleSetBuilderOntology.PD_PREDICATE, Ontology.STRING, 
				mappingManager.getPredicateMapping()));
		attributes.add(createAttribute(ExampleSetBuilderOntology.PD_ARGUMENTS, Ontology.STRING, 
				mappingManager.getArgumentMapping()));
		attributes.add(createAttribute(ExampleSetBuilderOntology.PD_CLOSEDWORLD, Ontology.STRING,
				mappingManager.getClosedWorldMapping()));
		if (hasId) {
			attributes.add(createAttribute(ExampleSetBuilderOntology.ID, Ontology.NUMERICAL));
		}
		return attributes;
	}
	
	private List<Attribute> createFunctionDeclAttributes(boolean hasId) {
		List<Attribute> attributes = new ArrayList<Attribute>();
		attributes.add(createAttribute(ExampleSetBuilderOntology.FD_RETURNTYPE, Ontology.STRING, 
				mappingManager.getTypeMapping()));
		attributes.add(createAttribute(ExampleSetBuilderOntology.FD_FUNCTION, Ontology.STRING, 
				mappingManager.getFunctionMapping()));
		attributes.add(createAttribute(ExampleSetBuilderOntology.FD_ARGUMENTS, Ontology.STRING, 
				mappingManager.getArgumentMapping()));
		if (hasId) {
			attributes.add(createAttribute(ExampleSetBuilderOntology.ID, Ontology.NUMERICAL));
		}
		return attributes;
	}
	
	private List<Attribute> createFormulaAttributes(boolean hasId) {
		List<Attribute> attributes = new ArrayList<Attribute>();
		attributes.add(createAttribute(ExampleSetBuilderOntology.FO_PROBWEIGHT, Ontology.STRING));
		attributes.add(createAttribute(ExampleSetBuilderOntology.FO_UTILWEIGHT, Ontology.STRING));
		attributes.add(createAttribute(ExampleSetBuilderOntology.FO_FORMULA, Ontology.STRING, 
				mappingManager.getFormulaMapping()));
		attributes.add(createAttribute(ExampleSetBuilderOntology.FO_HARD, Ontology.BINOMINAL, 
				mappingManager.getBooleanMapping()));
		if (hasId) {
			attributes.add(createAttribute(ExampleSetBuilderOntology.ID, Ontology.NUMERICAL));
		}
		return attributes;
	}
	
	private Attribute createAttribute(String name, int type) {
		return  AttributeFactory.createAttribute(name, type);
	}
	
	private Attribute createAttribute(String name, int type, NominalMapping mapping) {
		Attribute attr = createAttribute(name, type);
		attr.setMapping(mapping);
		return attr;
	}
	
	public Attribute[] getAttributes(ExampleSetType type) {
		List<Attribute> list = attributeLists.get(type);
		return safeToArray(list);
	}
	
	private Attribute[] safeToArray(List<Attribute> attrs) {
		int size=0, counter=0;
		for (Attribute attr: attrs) {
			size++;
		}
		Attribute[] arr = new Attribute[size];
		for (Attribute attr: attrs) {
			arr[counter] = attr;
			counter++;
		}
		return arr;

	}
	
	protected static Attribute[] getEmptyAttributes() {
		return new Attribute[0];
	}
}
