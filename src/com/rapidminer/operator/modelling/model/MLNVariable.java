package com.rapidminer.operator.modelling.model;


public class MLNVariable extends MLNNamedObject {
	private boolean plus;
	
	public MLNVariable() {
		
	}
	
	public MLNVariable(String name, boolean plus) {
		super(name);
		this.plus = plus;
	}
	
	public boolean isPlus() {
		return plus;
	}

	public void setPlus(boolean plus) {
		this.plus = plus;
	}
	
	@Override
	public boolean isUnspecified() {
		return false;
	}
	
	@Override
	public boolean contentEquals(Object obj, boolean strict) {
		return true;
	}

	@Override
	protected boolean internalContentEquals(Object obj, boolean strict) {
		return true;
	}

}
