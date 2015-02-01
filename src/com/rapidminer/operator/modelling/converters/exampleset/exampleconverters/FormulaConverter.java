package com.rapidminer.operator.modelling.converters.exampleset.exampleconverters;

import com.rapidminer.example.Attributes;
import com.rapidminer.example.Example;
import com.rapidminer.operator.modelling.converters.exampleset.model.ExampleSetBuilderOntology;
import com.rapidminer.operator.modelling.converters.utilities.ConverterUtilities;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.Reducer;

public class FormulaConverter extends ExampleConverter implements Reducer<Example, String> {

	@Override
	public String reduce(Example obj) {
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
		String str = ConverterUtilities.buildString(probWeight, colon, utilWeight, ConverterUtilities.SPACE, 
				formula, hardSign);
		return str;
	}
	
}
