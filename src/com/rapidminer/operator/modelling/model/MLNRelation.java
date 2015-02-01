package com.rapidminer.operator.modelling.model;

public enum MLNRelation {
	NE("!="), EQ("="), GT(">"), GE(">="), LT("<"), LE("<=");
	
	private String text;
	
	private MLNRelation(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	public static MLNRelation fromText(String text) {
		MLNRelation resultRelation = null;
		for (MLNRelation relation: values()) {
			if (relation.getText().equals(text)) {
				resultRelation = relation;
			}
		}
		return resultRelation;
	}
	
	public static MLNRelation getOpposite(MLNRelation relation) {
		if (relation.equals(GT))
			return LE;
		else if (relation.equals(GE))
			return LT;
		else if (relation.equals(LT))
			return GE;
		else if (relation.equals(LE))
			return GT;
		else if (relation.equals(NE))
			return EQ;
		else
			return NE;
	}
}
