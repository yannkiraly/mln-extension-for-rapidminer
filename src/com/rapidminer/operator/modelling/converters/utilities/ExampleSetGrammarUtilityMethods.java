package com.rapidminer.operator.modelling.converters.utilities;

import java.util.ArrayList;
import java.util.List;

import com.rapidminer.operator.modelling.converters.exampleset.parser.ExampleSetMLNGrammarParser.ArgumentContext;
import com.rapidminer.operator.modelling.converters.exampleset.parser.ExampleSetMLNGrammarParser.GroundArgumentContext;
import com.rapidminer.operator.modelling.converters.exampleset.parser.ExampleSetMLNGrammarParser.NumberContext;
import com.rapidminer.operator.modelling.converters.exampleset.parser.ExampleSetMLNGrammarParser.PlainNumListContext;

public class ExampleSetGrammarUtilityMethods {
	public static List<Double> processPlainNumList(PlainNumListContext tree) {
		List<Double> numList = new ArrayList<Double>();
		if (tree != null) {
				for (NumberContext number: tree.number()) {
					numList.add(getNumberValue(number));
				}
		}
		return numList;
	}
	
	public static void processArguments(List<ArgumentContext> arguments, List<String> constantNames, 
			List<String> variableNames, List<Double> numbers) {
		for (ArgumentContext argument: arguments) {
			if (argument.constant() != null) {
				constantNames.add(argument.constant().getText());
			} else if (argument.variable() != null) {
				variableNames.add(argument.variable().getText());
			} else if (argument.number() != null) {
				numbers.add(getNumberValue(argument.number()));
			}
		}
	}
	
	public static Double getNumberValue(NumberContext ctx) {
		String val;
		if (ctx.INT()!=null) {
			val = ctx.INT().getText();
		} else {
			val = ctx.FLOAT().getText();
		}
		return Double.parseDouble(val);
	}
	
	public static void processGroundArguments(List<GroundArgumentContext> arguments, List<String> constantNames, 
			List<Double> numbers) {
		for (GroundArgumentContext argument: arguments) {
			if (argument.constant() != null) {
				constantNames.add(argument.constant().getText());
			} else if (argument.number() != null) {
				numbers.add(getNumberValue(argument.number()));
			}
		}
	}
}
