package com.rapidminer.operator.modelling.converters.utilities;

import java.util.ArrayList;
import java.util.List;

import com.rapidminer.operator.modelling.converters.rockit.parser.rockitMLNGrammarParser.NumberContext;
import com.rapidminer.operator.modelling.converters.rockit.parser.rockitMLNGrammarParser.PlainNumListContext;
public class RockitGrammarUtilityMethods {
	
	public static List<Double> processPlainNumList(PlainNumListContext tree) {
		List<Double> numList = new ArrayList<Double>();
		if (tree != null) {
				for (NumberContext numCtx: tree.number()) {
					numList.add(numberValue(numCtx));
				}
		}
		return numList;
	}
	
	public static Double numberValue(NumberContext number) {
		if (number.INT()!=null){
			return Double.parseDouble(number.INT().getText());
		} else {
			return Double.parseDouble(number.FLOAT().getText());
		}
	}
//	
//	public static void processArguments(List<ArgumentContext> arguments, List<String> constantNames, 
//			List<String> variableNames, List<Double> numbers) {
//		for (ArgumentContext argument: arguments) {
//			if (argument.constant() != null) {
//				constantNames.add(argument.constant().getText());
//			} else if (argument.variable() != null) {
//				variableNames.add(argument.variable().getText());
//			} else if (argument.number() != null) {
//				numbers.add();
//			}
//		}
//	}
	
//	public static void processGroundArguments(List<GroundArgumentContext> arguments, List<String> constantNames, 
//			List<Double> numbers) {
//		for (GroundArgumentContext argument: arguments) {
//			if (argument.constant() != null) {
//				constantNames.add(argument.constant().getText());
//			} else if (argument.INT() != null) {
//				numbers.add(Double.parseDouble(argument.INT().getText()));
//			}
//		}
//	}
}

