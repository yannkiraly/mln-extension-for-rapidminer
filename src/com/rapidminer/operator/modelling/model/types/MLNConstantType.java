package com.rapidminer.operator.modelling.model.types;

import java.util.List;

import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduce;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduceException;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.Reducer;
import com.rapidminer.operator.modelling.model.MLNConstant;

public class MLNConstantType extends MLNType {
	
	public MLNConstantType(List<MLNConstant> constants) {
		this.constants = constants;
	}

	private List<MLNConstant> constants;

	public List<MLNConstant> getConstants() {
		return constants;
	}

	public void setConstants(List<MLNConstant> constants) {
		this.constants = constants;
	}
	
	@Override
	public boolean isInstance(Object obj) {
		return ((obj instanceof MLNConstant) && (constants.contains(obj)));
	}
	
	@Override
	public boolean contentEquals(Object obj, boolean strict) {
		if (obj instanceof MLNConstantType) {
			final List<MLNConstant> constantList = ((MLNConstantType) obj).getConstants();
			final boolean passStrict = strict;
			try {
				if ((getConstants()!=null)&&(getConstants().size()>0)) {
					if ((constantList!=null)&&(constantList.size()>0)) {
						return MapReduce.reduce(getConstants(), new Reducer<MLNConstant, Boolean>() {
							private int counter = -1;
							@Override
							public Boolean reduce(MLNConstant constant) {
								counter++;
								return constant.contentEquals(constantList.get(counter), passStrict);
							}
							
							@Override
							public Boolean reduce(Boolean existingValue, MLNConstant nextConstant) {
								return existingValue && reduce(nextConstant);
							}
						});
					} else {
						if (strict)
							return getConstants().size()==0;
						else
							return true;
					}
				} else {
					if (strict)
						return ((((MLNConstantType) obj).getConstants()==null)||((((MLNConstantType) obj).getConstants().size()==0)));
					else
						return true;
				}
			} catch (MapReduceException e) {
				return false;
			}
		} else
			return false;
	}

	@Override
	public boolean contentEquals(Object obj, boolean strict,
			boolean allowGroundings) {
		return contentEquals(obj, strict);
	}

}
