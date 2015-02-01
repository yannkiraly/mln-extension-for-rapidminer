package com.rapidminer.operator.modelling.converters.exampleset.exampleconverters;

import com.rapidminer.example.Attributes;
import com.rapidminer.example.Example;
import com.rapidminer.operator.modelling.converters.exampleset.model.ExampleSetBuilderOntology;
import com.rapidminer.operator.modelling.converters.utilities.ConverterUtilities;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.Reducer;
import com.rapidminer.operator.modelling.model.MLNClosedWorldType;

public class PredicateDeclConverter extends ExampleConverter implements Reducer<Example, String> {

	@Override
	public String reduce(Example obj) {
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
		return ConverterUtilities.buildString(closedWorldSign,
				predicate,ConverterUtilities.parenthesize(arguments));
	}

}
