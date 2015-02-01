package com.rapidminer.operator.modelling.converters.utilities;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;

public class ANTLRUtilityMethods {
	
	public static List<String> buildTextList(List<? extends ParseTree> trees) {
		List<String> textList = new ArrayList<String>();
		for (ParseTree tree: trees) {
			textList.add(tree.getText());
		}
		return textList;
	}
	
	public static <C> List<C> listFromElement(C element) {
		List<C> list = new ArrayList<C>();
		list.add(element);
		return list;
	}

}
