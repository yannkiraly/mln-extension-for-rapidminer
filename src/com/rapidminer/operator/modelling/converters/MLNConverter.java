package com.rapidminer.operator.modelling.converters;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import com.rapidminer.example.ExampleSet;
import com.rapidminer.operator.modelling.configuration.MLNFileType;
import com.rapidminer.operator.modelling.configuration.fixed.MLNException;
import com.rapidminer.operator.modelling.configuration.fixed.MLNFileRole;
import com.rapidminer.operator.modelling.converters.exampleset.ExampleSetMLNConverter;
import com.rapidminer.operator.modelling.converters.exampleset.model.ExampleSetModel;
import com.rapidminer.operator.modelling.converters.exampleset.model.ExampleSetType;
import com.rapidminer.operator.modelling.model.MLNModel;

public abstract class MLNConverter {
	
	public abstract MLNModel buildModel(MLNFileRole role) throws MLNException;
	
	public abstract MLNModel buildModel(MLNFileRole role, MLNModel modelToExtend) throws MLNException;
	
	public abstract void setRemoveUnsupportedConstraints(boolean value) throws MLNException;
	
	public abstract void convertModel(MLNModel model, MLNFileRole role) 
			throws MLNException;
	
	public abstract void setExclConstraintConversion(boolean value) throws MLNException;
	
	public abstract void setConvertLEConstraint(boolean value) throws MLNException;

	public static ExampleSet getEmptyExampleSet() {
		return ExampleSetModel.getEmptyExampleSet();
	}
	
	
	public static MLNFileConverter getConverterForFileType(MLNFileType fileType, 
			InputStream inputStream) throws MLNException {
		try {
			return (MLNFileConverter) fileType.getConverter()
					.getConstructor(InputStream.class, OutputStream.class)
					.newInstance(inputStream, null);
		} catch (Exception e) {
			throw new MLNException(e.getMessage());
		}
	}
	
	public static MLNFileConverter getConverterForFileType(MLNFileType fileType, 
			OutputStream outputStream) throws MLNException {
		try {
			return (MLNFileConverter) fileType.getConverter()
					.getConstructor(InputStream.class, OutputStream.class)
					.newInstance(null, outputStream);
		} catch (Exception e) {
			throw new MLNException(e.getMessage());
		}
	}
	
	public static MLNFileConverter getConverterForFileType(MLNFileType fileType, 
			InputStream inputStream, OutputStream outputStream) 
					throws MLNException {
		try {
			return (MLNFileConverter) fileType.getConverter()
					.getConstructor(InputStream.class, OutputStream.class)
					.newInstance(inputStream, outputStream);
		} catch (Exception e) {
			throw new MLNException(e.getMessage());
		}
	}
	
	public static ExampleSetMLNConverter getConverterForExampleSets(List<ExampleSet> inputExampleSets,
			LinkedHashMap<ExampleSetType, ExampleSet> outputExampleSets) {
		return new ExampleSetMLNConverter(inputExampleSets, outputExampleSets);
	}
	
	public static ExampleSetMLNConverter getConverterForExampleSets(List<ExampleSet> inputExampleSets,
			LinkedHashMap<ExampleSetType, ExampleSet> outputExampleSets, MLNModel model) {
		//TODO: LinkedHashMap really necessary?
		return new ExampleSetMLNConverter(inputExampleSets, outputExampleSets, model);
	}
	
	public static ExampleSetMLNConverter getConverterForExampleSets(List<ExampleSet> inputExampleSets,
			LinkedHashMap<ExampleSetType, ExampleSet> outputExampleSets, List<ExampleSetType> exampleSetTypes) {
		return new ExampleSetMLNConverter(inputExampleSets, outputExampleSets, exampleSetTypes);
	}
	
	public static ExampleSetMLNConverter getConverterForExampleSets(List<ExampleSet> inputExampleSets,
			LinkedHashMap<ExampleSetType, ExampleSet> outputExampleSets, MLNModel model, List<ExampleSetType> exampleSetTypes) {
		return new ExampleSetMLNConverter(inputExampleSets, outputExampleSets);
	}
	
	public MLNConverter() {
		
	}
	
}
