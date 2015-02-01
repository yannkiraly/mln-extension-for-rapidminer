package com.rapidminer.operator.modelling.converters.exampleset.exampleconverters;

import com.rapidminer.example.Attributes;
import com.rapidminer.example.Example;
import com.rapidminer.operator.modelling.converters.exampleset.model.ExampleSetBuilderOntology;
import com.rapidminer.operator.modelling.converters.utilities.ConverterUtilities;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.Reducer;

public class ProbabilityStatementConverter extends ExampleConverter implements Reducer<Example, String> {

	@Override
	public String reduce(Example obj) {
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
		return ConverterUtilities.buildString(negationSign, returnValue, ConverterUtilities.space(equalsSign), 
				atomFunction, ConverterUtilities.SPACE, probability);
	}

}
