package com.rapidminer.operator.modelling.model;

public class MLNConstant extends MLNNamedObject {
	public MLNConstant() {
		
	}
	
	public MLNConstant(String name) {
		super(encloseName(name));
	}
	
	@Override
	public void setName(String name) {
		super.setName(encloseName(name));
	}
	
	private static String encloseName(String name) {
		if (name.startsWith("\"") && name.endsWith("\"")) {
			return name;
		} else {
			return "\""+name+"\"";
		}
	}
	
	@Override
	public boolean isUnspecified() {
		return false;
	}
	
	@Override
	public boolean internalContentEquals(Object obj, boolean strict) {
		return true;
	}

}
