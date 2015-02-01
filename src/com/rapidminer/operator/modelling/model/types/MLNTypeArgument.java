package com.rapidminer.operator.modelling.model.types;

import com.rapidminer.operator.modelling.model.MLNObject;

public class MLNTypeArgument extends MLNObject {
	
	private MLNTypeContainer typeContainer;
	private boolean excl;
	
	public MLNTypeArgument(MLNTypeContainer typeContainer, boolean excl) {
		this.typeContainer = typeContainer;
		this.excl = excl;
	}

	public MLNTypeContainer getTypeContainer() {
		return typeContainer;
	}

	public void setTypeContainer(MLNTypeContainer typeContainer) {
		this.typeContainer = typeContainer;
	}

	public boolean isExcl() {
		return excl;
	}

	public void setExcl(boolean excl) {
		this.excl = excl;
	}
	
	@Override
	public boolean contentEquals(Object obj, boolean strict) {
		MLNTypeArgument castObj;
		if (obj instanceof MLNTypeArgument) {
			castObj = (MLNTypeArgument) obj;
			return applyContentEquals(castObj.getTypeContainer(), 
				getTypeContainer(), strict) &&
			(castObj.isExcl() == isExcl());
		} else {
			return false;
		}
	}

	@Override
	public boolean contentEquals(Object obj, boolean strict,
			boolean allowGroundings) {
		return contentEquals(obj, strict);
	}
}
