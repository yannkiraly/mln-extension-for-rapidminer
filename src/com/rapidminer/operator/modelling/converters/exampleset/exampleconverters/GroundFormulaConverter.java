package com.rapidminer.operator.modelling.converters.exampleset.exampleconverters;

import com.rapidminer.example.Attributes;
import com.rapidminer.example.Example;
import com.rapidminer.operator.modelling.converters.exampleset.model.ExampleSetBuilderOntology;
import com.rapidminer.operator.modelling.converters.utilities.ConverterUtilities;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.Reducer;

public class GroundFormulaConverter extends ExampleConverter implements Reducer<Example, String> {
	
	@Override
	public String reduce(Example obj) {
		Attributes attributes = obj.getAttributes();
		String negationSign = "", equalsSign = "", returnValue = obj.getNominalValue(obj.getAttributes()
				.get(ExampleSetBuilderOntology.GF_RETURNVALUE)), 
				atomFunction = obj.getNominalValue(attributes.get(
						ExampleSetBuilderOntology.GF_ATOM_FUNCTION)), 
				negation = obj.getNominalValue(attributes.get(ExampleSetBuilderOntology.GF_NEGATION));
		//returnValue = removeNA(returnValue);
		//atomFunction = removeNA(atomFunction);
		//negation = removeNA(negation);
		if (!(returnValue.equals("")))
			equalsSign = ConverterUtilities.EQUALS;
		if (negation.equals(ConverterUtilities.TRUE))
			negationSign = ConverterUtilities.EXCL;
		return ConverterUtilities.buildString( returnValue, ConverterUtilities.space(equalsSign), 
				negationSign, atomFunction);
	}
	
}
