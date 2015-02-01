package com.rapidminer.operator.modelling.converters.utilities;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.TerminalNode;

import com.rapidminer.operator.modelling.converters.alchemy.parser.alchemyMLNGrammarParser.ArgumentContext;
import com.rapidminer.operator.modelling.converters.alchemy.parser.alchemyMLNGrammarParser.GroundArgumentContext;
import com.rapidminer.operator.modelling.converters.alchemy.parser.alchemyMLNGrammarParser.PlainIntListContext;

public class AlchemyGrammarUtilityMethods {
	
	public static List<Double> processPlainIntList(PlainIntListContext tree) {
		List<Double> intList = new ArrayList<Double>();
		if (tree != null) {
				for (TerminalNode node : tree.INT()) {
					intList.add(Double.parseDouble(node.getText()));
				}
		}
		return intList;
	}
	
	
}
