package com.rapidminer.operator.modelling.model;


public abstract class MLNNamedObject extends MLNObject {
	
	private String name;
	
	public abstract boolean isUnspecified();
	
	protected abstract boolean internalContentEquals(Object obj, boolean strict);
	
	public MLNNamedObject(String name) {
		this.name = name;
	}
	
	public MLNNamedObject() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean contentEquals(Object obj, boolean strict) {
		MLNNamedObject namedObj;
		if (obj instanceof MLNNamedObject) {
			namedObj = (MLNNamedObject) obj;
			if (namedObj instanceof MLNVariable)
				return true;
			else {
				if (namedObj.getName().equals(getName()) ||
						getFirstToLower(namedObj.getName()).equals(getName())) {
					if ((namedObj.isUnspecified() || (this.isUnspecified())) && !strict) {
						return true;
					} else
						return internalContentEquals(obj, strict);
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
	}
	
	@Override
	public boolean contentEquals(Object obj, boolean strict, boolean allowGroundings) {
		if (!allowGroundings)
			return contentEquals(obj, strict);
		else {
			if (obj instanceof MLNNamedObject) {
				if (obj instanceof MLNVariable)
					return true;
				else
					return ((obj.getClass().equals(this.getClass())) && ((MLNNamedObject) obj).getName().equals(getName()));
			} else {
				return false;
			}
		}
			
	}
	
	private String getFirstToLower(String str) {
		if (str.length()>1)
			return str.substring(0,1).toLowerCase()+str.substring(1);
		else
			return str.toLowerCase();
	}
}
