package com.rapidminer.operator.modelling.model;

public class MLNProbabilityStatement extends MLNObject {
	

	public MLNProbabilityStatement(MLNGroundFormula groundFormula,
			Double probability) {
		super();
		this.groundFormula = groundFormula;
		this.probability = probability;
	}
	private MLNGroundFormula groundFormula;
	private Double probability;

	public Double getProbability() {
		return probability;
	}
	public void setProbability(Double probability) {
		this.probability = probability;
	}
	public MLNGroundFormula getGroundFormula() {
		return groundFormula;
	}
	public void setGroundFormula(MLNGroundFormula groundFormula) {
		this.groundFormula = groundFormula;
	}
	
	@Override
	public boolean contentEquals(Object obj, boolean strict) {
		if (obj instanceof MLNProbabilityStatement) {
			MLNProbabilityStatement statement = (MLNProbabilityStatement) obj;
			return applyContentEquals(statement.getGroundFormula(), getGroundFormula(), strict) &&
					statement.getProbability().equals(getProbability());
		} else 
			return false;
	}
	@Override
	public boolean contentEquals(Object obj, boolean strict,
			boolean allowGroundings) {
		if (allowGroundings) {
			if (obj instanceof MLNProbabilityStatement) {
				MLNProbabilityStatement statement = (MLNProbabilityStatement) obj;
				return applyContentEquals(statement.getGroundFormula(), getGroundFormula(), strict,
						allowGroundings) &&
						statement.getProbability().equals(getProbability());
			} else 
				return false;
		} else {
			return contentEquals(obj, strict);
		}
			
	}

}
