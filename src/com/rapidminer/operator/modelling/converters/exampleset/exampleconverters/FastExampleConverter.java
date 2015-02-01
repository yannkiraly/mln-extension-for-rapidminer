package com.rapidminer.operator.modelling.converters.exampleset.exampleconverters;

import java.util.Iterator;
import java.util.List;

import com.rapidminer.example.Attributes;
import com.rapidminer.example.Example;
import com.rapidminer.example.ExampleSet;
import com.rapidminer.example.set.AttributesExampleReader;
import com.rapidminer.operator.modelling.converters.exampleset.model.ExampleSetBuilderOntology;
import com.rapidminer.operator.modelling.converters.exampleset.model.ExampleSetType;
import com.rapidminer.operator.modelling.converters.utilities.ConverterUtilities;
import com.rapidminer.operator.modelling.model.MLNClosedWorldType;

public class FastExampleConverter {
	
	//Inelegant design due to last-minute speedup efforts
	public String convertExampleSets(List<ExampleSet> sets, List<ExampleSetType> types) {
		StringBuilder sb = new StringBuilder();
		Iterator<Example> examples;
		ExampleSetType type;
		for (int counter = 0; counter < sets.size(); counter++) {
			examples = getIterator(sets.get(counter));
			type = types.get(counter);
			if (type.equals(ExampleSetType.Formula)) {
				while (examples.hasNext()) {
					convertFormula(sb, examples.next());
					sb.append("\n");
				}
			} else if (type.equals(ExampleSetType.FunctionDecl)) {
				while (examples.hasNext()) {
					convertFunctionDecl(sb, examples.next());
					sb.append("\n");
				}
			} else if (type.equals(ExampleSetType.PredicateDecl) || 
				type.equals(ExampleSetType.QueryPredicateDecl)) {
				while (examples.hasNext()) {
					convertPredicateDecl(sb, examples.next());
					sb.append("\n");
				}
			} else if (type.equals(ExampleSetType.GroundFormula)) {
				while (examples.hasNext()) {
					convertGroundFormula(sb, examples.next());
					sb.append("\n");
				}
			} else if (type.equals(ExampleSetType.ProbabilityStatement)) {
				while (examples.hasNext()) {
					convertProbabilityStatement(sb, examples.next());
					sb.append("\n");
				}
			} else if (type.equals(ExampleSetType.TypeDecl)) {
				while (examples.hasNext()) {
					convertTypeDecl(sb, examples.next());
					sb.append("\n");
				}
			}
				sb.append("\n");
			}
		return sb.toString();
	}
	
	private Iterator<Example> getIterator(ExampleSet set) {
		AttributesExampleReader reader = new AttributesExampleReader(set.iterator(), set);
		return reader;
	}
	
	public void convertFormula(StringBuilder sb, Example obj) {
		Attributes attributes = obj.getAttributes();
		String hardSign = "", colon = "", probWeight = obj.getNominalValue(obj.getAttributes()
				.get(ExampleSetBuilderOntology.FO_PROBWEIGHT)),
				utilWeight = obj.getNominalValue(obj.getAttributes()
						.get(ExampleSetBuilderOntology.FO_UTILWEIGHT)),
				formula = obj.getNominalValue(attributes.get(
						ExampleSetBuilderOntology.FO_FORMULA)), 
				hard = obj.getNominalValue(attributes.get(ExampleSetBuilderOntology.FO_HARD));
		probWeight = removeNA(probWeight);
		utilWeight = removeNA(utilWeight);
		formula = removeNA(formula);
		hard = removeNA(hard);
		if (!(utilWeight.equals("")))
			colon = ConverterUtilities.COLON;
		if (hard.equals(ConverterUtilities.TRUE))
			hardSign = ConverterUtilities.PERIOD;
		sb.append(probWeight);
		sb.append(colon);
		sb.append(utilWeight);
		sb.append(" "); 
		sb.append(formula);
		sb.append(hardSign);
	}
	
	public void convertFunctionDecl(StringBuilder sb, Example obj) {
		Attributes attributes = obj.getAttributes();
		String returnType = obj.getNominalValue(obj.getAttributes()
				.get(ExampleSetBuilderOntology.FD_RETURNTYPE)), 
				function = obj.getNominalValue(attributes.get(
						ExampleSetBuilderOntology.FD_FUNCTION)),
				arguments = obj.getNominalValue(attributes.get(
						ExampleSetBuilderOntology.FD_ARGUMENTS));
		returnType = removeNA(returnType);
		function = removeNA(function);
		arguments = removeNA(arguments);
		if (returnType!="") {
			sb.append(returnType);
			sb.append(" ");
			sb.append("=");
			sb.append(" ");
		}
		sb.append(function);
		sb.append("(");
		sb.append(arguments);
		sb.append(")");
	}
	
	public void convertGroundFormula(StringBuilder sb, Example obj) {
		Attributes attributes = obj.getAttributes();
		String negationSign = "", equalsSign = "", returnValue = obj.getNominalValue(obj.getAttributes()
				.get(ExampleSetBuilderOntology.GF_RETURNVALUE)), 
				atomFunction = obj.getNominalValue(attributes.get(
						ExampleSetBuilderOntology.GF_ATOM_FUNCTION)), 
				negation = obj.getNominalValue(attributes.get(ExampleSetBuilderOntology.GF_NEGATION));
		returnValue = removeNA(returnValue);
		atomFunction = removeNA(atomFunction);
		negation = removeNA(negation);
		if (!(returnValue.equals("")))
			equalsSign = " = ";
		if (negation.equals(ConverterUtilities.TRUE))
			negationSign = ConverterUtilities.EXCL;
		sb.append(returnValue);
		sb.append(equalsSign);
		sb.append(negationSign);
		sb.append(atomFunction);
	}
	
	public void convertPredicateDecl(StringBuilder sb, Example obj) {
		Attributes attributes = obj.getAttributes();
		String closedWorldSign = "", closedWorld = obj.getNominalValue(obj.getAttributes()
				.get(ExampleSetBuilderOntology.PD_CLOSEDWORLD)), 
				predicate = obj.getNominalValue(attributes.get(
						ExampleSetBuilderOntology.PD_PREDICATE)),
				arguments = obj.getNominalValue(attributes.get(
						ExampleSetBuilderOntology.PD_ARGUMENTS));
		closedWorld = removeNA(closedWorld);
		predicate = removeNA(predicate);
		arguments = removeNA(arguments);
		if (closedWorld.equals(MLNClosedWorldType.ClosedWorld.name()))
			closedWorldSign=ConverterUtilities.STAR;
		sb.append(closedWorldSign);
		sb.append(predicate);
		sb.append("(");
		sb.append(arguments);
		sb.append(")");
	}
	
	public void convertProbabilityStatement(StringBuilder sb, Example obj) {
		Attributes attributes = obj.getAttributes();
		String negationSign = "", equalsSign = "", returnValue = obj.getNominalValue(obj.getAttributes()
				.get(ExampleSetBuilderOntology.GF_RETURNVALUE)), 
				atomFunction = obj.getNominalValue(attributes.get(
						ExampleSetBuilderOntology.GF_ATOM_FUNCTION)), 
				negation = obj.getNominalValue(attributes.get(ExampleSetBuilderOntology.GF_NEGATION)),
				probability = obj.getNominalValue(attributes.get(ExampleSetBuilderOntology.PS_PROBABILITY));
		returnValue = removeNA(returnValue);
		atomFunction = removeNA(atomFunction);
		negation = removeNA(negation);
		probability = removeNA(probability);
		if (!(returnValue.equals("")))
			equalsSign = ConverterUtilities.EQUALS;
		if (negation.equals(ConverterUtilities.TRUE))
			negationSign = ConverterUtilities.EXCL;
		sb.append(negationSign);
		sb.append(returnValue);
		sb.append(" = ");
		sb.append(atomFunction);
		sb.append(" ");
		sb.append(probability);
	}
	
	public void convertTypeDecl(StringBuilder sb, Example obj) {
		Attributes attributes = obj.getAttributes();
		String type = obj.getNominalValue(obj.getAttributes()
				.get(ExampleSetBuilderOntology.TD_TYPE)), 
				values = obj.getNominalValue(attributes.get(
						ExampleSetBuilderOntology.TD_VALUES));
		type = removeNA(type);
		values = removeNA(values);
		sb.append(type);
		sb.append(" = ");
		sb.append("{");
		sb.append(values.equals("NA")?"":values);
		sb.append("}");
	}
	
	protected String removeNA(String str) {
		if (str.equals("NA"))
			return "";
		else
			return str;
	}

}
