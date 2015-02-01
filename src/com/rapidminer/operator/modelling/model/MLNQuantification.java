package com.rapidminer.operator.modelling.model;

import java.util.List;

import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduce;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduceException;

public class MLNQuantification extends MLNObject {
	
	public MLNQuantification() {
		
	}
	
	public MLNQuantification(String symbol, boolean eQuant, boolean uQuant, MLNPlainFormula plainFormula,
			List<MLNVariable> arguments, MLNRelation relation, Integer number) {
		super();
		this.symbol = symbol;
		this.plainFormula = plainFormula;
		this.arguments = arguments;
		this.relation = relation.getText();
		this.number = number;
		this.eQuant = eQuant;
		this.uQuant = uQuant;
	}

	public static final Integer U_QUANT_NUMBER = -1;
	public static final Integer E_QUANT_NUMBER = 1;
	
	public static final MLNRelation U_QUANT_RELATION = MLNRelation.EQ;
	public static final MLNRelation E_QUANT_RELATION = MLNRelation.GE;
	
	public static final String U_QUANT_NAME = "Forall";
	public static final String E_QUANT_NAME = "Exist";
	
	private String symbol;
	
	private MLNPlainFormula plainFormula;
	
	private List<MLNVariable> arguments;
	
	private String relation;
	
	private Integer number;
	
	private Boolean eQuant, uQuant;
	

	public MLNPlainFormula getPlainFormula() {
		return plainFormula;
	}

	public void setPlainFormula(MLNPlainFormula plainFormula) {
		this.plainFormula = plainFormula;
	}

	public MLNRelation getRelation() {
		return MLNRelation.fromText(relation);
	}

	public void setRelation(MLNRelation relation) {
		this.relation = relation.getText();
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public List<MLNVariable> getArguments() {
		return arguments;
	}

	public void setArguments(List<MLNVariable> arguments) {
		this.arguments = arguments;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}


	@Override
	public boolean contentEquals(Object obj, boolean strict) {
		if (obj instanceof MLNQuantification) {
			MLNQuantification quantification = (MLNQuantification) obj;
			try {
			boolean r = quantification.getSymbol().equals(getSymbol()) &&
					quantification.getRelation().equals(getRelation()) && 
					applyContentEquals(quantification.getPlainFormula(), getPlainFormula(), strict);
			final List<MLNVariable> argumentList = getArguments();
			return r&& 
						MapReduce.reduce(argumentList.iterator(), 
								new MLNListCompare<MLNVariable>(getArguments().iterator(), strict));
			} catch (MapReduceException e) {
				return false;
			}
					
		} else
			return false;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Boolean geteQuant() {
		return eQuant;
	}

	public Boolean getuQuant() {
		return uQuant;
	}

	public void seteQuant(Boolean eQuant) {
		this.eQuant = eQuant;
	}

	public void setuQuant(Boolean uQuant) {
		this.uQuant = uQuant;
	}

	@Override
	public boolean contentEquals(Object obj, boolean strict,
			boolean allowGroundings) {
		if (allowGroundings) {
			if (obj instanceof MLNQuantification) {
				MLNQuantification quantification = (MLNQuantification) obj;
				try {
				boolean r = quantification.getSymbol().equals(getSymbol()) &&
						quantification.getRelation().equals(getRelation()) && 
						applyContentEquals(quantification.getPlainFormula(), getPlainFormula(), strict,
								allowGroundings);
				final List<MLNVariable> argumentList = getArguments();
				return r&& 
							MapReduce.reduce(argumentList.iterator(), 
									new MLNListCompare<MLNVariable>(getArguments().iterator(), strict,
											allowGroundings));
				} catch (MapReduceException e) {
					return false;
				}
						
			} else
				return false;
		} else {
			return contentEquals(obj, strict, allowGroundings);
		}
	}
}
