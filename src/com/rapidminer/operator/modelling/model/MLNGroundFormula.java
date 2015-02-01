package com.rapidminer.operator.modelling.model;

public class MLNGroundFormula extends MLNObject{

	private MLNGroundAtom groundAtom;
	private MLNFunctionDefinition functionDefinition;
	
	public MLNGroundFormula(MLNFunctionDefinition functionDefinition) {
		super();
		this.functionDefinition = functionDefinition;
	}
	public MLNGroundFormula(MLNGroundAtom groundAtom) {
		super();
		this.groundAtom = groundAtom;
	}
	
	public MLNGroundAtom getGroundAtom() {
		return groundAtom;
	}
	public void setGroundAtom(MLNGroundAtom groundAtom) {
		this.groundAtom = groundAtom;
	}
	public MLNFunctionDefinition getFunctionDefinition() {
		return functionDefinition;
	}
	public void setFunctionDefinition(
			MLNFunctionDefinition functionDefinition) {
		this.functionDefinition = functionDefinition;
	}
	
	@Override
	public boolean contentEquals(Object obj, boolean strict) {
		if (obj instanceof MLNGroundFormula) {
			MLNGroundFormula groundFormula = (MLNGroundFormula) obj;
			return applyContentEquals(groundFormula.getFunctionDefinition(), getFunctionDefinition(), strict)
					&&
					applyContentEquals(groundFormula.getGroundAtom(), getGroundAtom(), strict);
		} else
			return false;
	}
	@Override
	public boolean contentEquals(Object obj, boolean strict,
			boolean allowGroundings) {
		if (allowGroundings) {
			if (obj instanceof MLNGroundFormula) {
				MLNGroundFormula groundFormula = (MLNGroundFormula) obj;
				return applyContentEquals(groundFormula.getFunctionDefinition(), getFunctionDefinition(), strict,
						allowGroundings)
						&&
						applyContentEquals(groundFormula.getGroundAtom(), getGroundAtom(), strict,
								allowGroundings);
			} else
				return false;
		} else {
			return contentEquals(obj, strict);
		}
	}

}
