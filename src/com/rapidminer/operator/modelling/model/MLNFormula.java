package com.rapidminer.operator.modelling.model;


public class MLNFormula extends MLNObject {
	public MLNFormula(MLNPlainFormula plainFormula, MLNWeight probabilityWeight,
			MLNWeight utilityWeight, boolean hardRule) {
		super();
		this.plainFormula = plainFormula;
		this.probabilityWeight = probabilityWeight;
		this.utilityWeight = utilityWeight;
		this.hardRule = hardRule;
	}

	private MLNPlainFormula plainFormula;
	
	private MLNWeight probabilityWeight;
	
	private MLNWeight utilityWeight;
	
	private boolean hardRule;

	public MLNPlainFormula getPlainFormula() {
		return plainFormula;
	}

	public void setPlainFormula(MLNPlainFormula plainFormula) {
		this.plainFormula = plainFormula;
	}

	public boolean isHardRule() {
		return hardRule;
	}

	public void setHardRule(boolean hardRule) {
		this.hardRule = hardRule;
	}

	public MLNWeight getProbabilityWeight() {
		return probabilityWeight;
	}

	public void setProbabilityWeight(MLNWeight probabilityWeight) {
		this.probabilityWeight = probabilityWeight;
	}

	public MLNWeight getUtilityWeight() {
		return utilityWeight;
	}

	public void setUtilityWeight(MLNWeight utilityWeight) {
		this.utilityWeight = utilityWeight;
	}

	@Override
	public boolean contentEquals(Object obj, boolean strict) {
		MLNFormula formula;
		if (obj instanceof MLNFormula) {
			formula = (MLNFormula) obj;
			return applyContentEquals(formula.getPlainFormula(), getPlainFormula(), strict)
					&&
					applyContentEquals(formula.getProbabilityWeight(), getProbabilityWeight(), strict)
					&&
					applyContentEquals(formula.getUtilityWeight(), getUtilityWeight(), strict)
					&&
					formula.isHardRule() == isHardRule();
		} else {
			return false;
		}
	}

	@Override
	public boolean contentEquals(Object obj, boolean strict,
			boolean allowGroundings) {
		MLNFormula formula;
		if (allowGroundings) {
			if (obj instanceof MLNFormula) {
				formula = (MLNFormula) obj;
				return applyContentEquals(formula.getPlainFormula(), getPlainFormula(), strict, allowGroundings)
						&&
						applyContentEquals(formula.getProbabilityWeight(), getProbabilityWeight(), strict, allowGroundings)
						&&
						applyContentEquals(formula.getUtilityWeight(), getUtilityWeight(), strict, allowGroundings)
						&&
						formula.isHardRule() == isHardRule();
			} else {
				return false;
			}
		} else {
			return contentEquals(obj, strict);
		}
	}
}
