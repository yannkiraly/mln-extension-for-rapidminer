package com.rapidminer.operator.modelling.model.operators;

import com.rapidminer.operator.modelling.model.MLNNamedObject;


public class MLNFormulaOperator extends MLNNamedObject {
	
	public MLNFormulaOperator(String name, int arity, int precedence, int position) {
		super(name);
		this.arity = arity;
		this.precedence = precedence;
		this.position = position;
	}
	
	public MLNFormulaOperator(String name, int arity, int precedence, int position, String closing) {
		this(name, arity, precedence, position);
		this.closing = closing;
	}
	
	public static final int INFIX = 0;
	public static final int PREFIX = -1;
	public static final int POSTFIX = 1;
	public static final int SURROUNDING = 2;
	
	public static final int PARENTHESES_PREC = 0;
	public static final int SQUARE_BRACKETS_PREC = 0;
	public static final int NOT_PREC = 1;
	public static final int EQ_PREC = 2;
	public static final int AND_PREC = 3;
	public static final int OR_PREC = 4;
	public static final int IMPLIES_PREC = 5;
	public static final int IFF_PREC = 6;
	
	private int arity;
	
	private int precedence;
	
	private int position;
	
	private String closing;

	public int getArity() {
		return arity;
	}

	public void setArity(int arity) {
		this.arity = arity;
	}

	public int getPrecedence() {
		return precedence;
	}

	public void setPrecedence(int precedence) {
		this.precedence = precedence;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getClosing() {
		return closing;
	}

	public void setClosing(String closing) {
		this.closing = closing;
	}
	
	@Override
	public boolean isUnspecified() {
		return false;
	}
	
	@Override
	public boolean internalContentEquals(Object obj, boolean strict) {
		if (obj instanceof MLNFormulaOperator) {
			MLNFormulaOperator operator = (MLNFormulaOperator) obj;
			if ((operator.getClosing()!=null  && getClosing()==null) || (operator.getClosing()==null && getClosing()!=null)) {
				return false;
			} else if (operator.getClosing()==null && getClosing()==null) {
				return (operator.getArity() == getArity()) && (operator.getPrecedence() == getPrecedence())
						&& (operator.getPosition() == getPosition());
			} else {
				return (operator.getArity() == getArity()) && (operator.getPrecedence() == getPrecedence())
						&& (operator.getPosition() == getPosition()) && (operator.getClosing().equals(getClosing()));
			}
		} else {
			return false;
		}
	}
}
