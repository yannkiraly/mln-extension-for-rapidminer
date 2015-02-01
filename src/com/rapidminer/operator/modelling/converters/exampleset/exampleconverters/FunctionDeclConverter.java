package com.rapidminer.operator.modelling.converters.exampleset.exampleconverters;

import com.rapidminer.example.Attributes;
import com.rapidminer.example.Example;
import com.rapidminer.operator.modelling.converters.exampleset.model.ExampleSetBuilderOntology;
import com.rapidminer.operator.modelling.converters.utilities.ConverterUtilities;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.Reducer;

public class FunctionDeclConverter extends ExampleConverter implements Reducer<Example, String> {

	@Override
	public String reduce(Example obj) {
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
		return ConverterUtilities.buildString(returnType, ConverterUtilities.space(ConverterUtilities.EQUALS),
				function,ConverterUtilities.parenthesize(arguments));
	}

}
