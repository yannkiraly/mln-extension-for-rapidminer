package com.rapidminer.operator.modelling.converters.exampleset.exampleconverters;

import com.rapidminer.example.Attributes;
import com.rapidminer.example.Example;
import com.rapidminer.operator.modelling.converters.exampleset.model.ExampleSetBuilderOntology;
import com.rapidminer.operator.modelling.converters.utilities.ConverterUtilities;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.Reducer;

public class TypeDeclConverter extends ExampleConverter implements Reducer<Example, String> {

	@Override
	public String reduce(Example obj) {
		Attributes attributes = obj.getAttributes();
		String type = obj.getNominalValue(obj.getAttributes()
				.get(ExampleSetBuilderOntology.TD_TYPE)), 
				values = obj.getNominalValue(attributes.get(
						ExampleSetBuilderOntology.TD_VALUES));
		type = removeNA(type);
		values = removeNA(values);
		return ConverterUtilities.buildString(type, ConverterUtilities.space(ConverterUtilities.EQUALS),
				ConverterUtilities.squareBracket((values.equals("NA")?"":values)));
	}

}
