package com.rapidminer.operator.modelling.converters.exampleset.model;

import com.rapidminer.operator.modelling.converters.exampleset.exampleconverters.ExampleConverter;
import com.rapidminer.operator.modelling.converters.exampleset.exampleconverters.FormulaConverter;
import com.rapidminer.operator.modelling.converters.exampleset.exampleconverters.FunctionDeclConverter;
import com.rapidminer.operator.modelling.converters.exampleset.exampleconverters.GroundFormulaConverter;
import com.rapidminer.operator.modelling.converters.exampleset.exampleconverters.PredicateDeclConverter;
import com.rapidminer.operator.modelling.converters.exampleset.exampleconverters.ProbabilityStatementConverter;
import com.rapidminer.operator.modelling.converters.exampleset.exampleconverters.TypeDeclConverter;
import com.rapidminer.operator.modelling.model.MLNFormula;
import com.rapidminer.operator.modelling.model.MLNFunction;
import com.rapidminer.operator.modelling.model.MLNGroundFormula;
import com.rapidminer.operator.modelling.model.MLNObject;
import com.rapidminer.operator.modelling.model.MLNPredicate;
import com.rapidminer.operator.modelling.model.MLNProbabilityStatement;
import com.rapidminer.operator.modelling.model.types.MLNTypeContainer;

public enum ExampleSetType {
	TypeDecl(MLNTypeContainer.class, "Type Declarations", new TypeDeclConverter()), 
	FunctionDecl(MLNFunction.class, "Function Declarations", new FunctionDeclConverter()), 
	PredicateDecl(MLNPredicate.class, "Predicate Declarations", new PredicateDeclConverter()), 
	Formula(MLNFormula.class, "Rules", new FormulaConverter()),
	ProbabilityStatement(MLNProbabilityStatement.class, "Probability Statements", new
			ProbabilityStatementConverter()),
	GroundFormula(MLNGroundFormula.class, "Ground Formulas", new GroundFormulaConverter()),
	QueryPredicateDecl(MLNPredicate.class, "Query Predicates", new PredicateDeclConverter());
	
	private final Class<? extends MLNObject> mlnClass;
	private final String title;
	private final ExampleConverter converter;
	
	private ExampleSetType(Class<? extends MLNObject> mlnClass, String title, ExampleConverter converter) {
		this.mlnClass = mlnClass;
		this.title = title;
		this.converter = converter;
	}
	
	public Class<? extends MLNObject> getMlnClass() {
		return mlnClass;
	}
	
	public String getTitle() {
		return title;
	}
	
	public ExampleConverter getConverter() {
		return converter;
	}
}
