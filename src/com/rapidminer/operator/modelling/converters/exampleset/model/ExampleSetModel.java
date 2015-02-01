package com.rapidminer.operator.modelling.converters.exampleset.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import com.rapidminer.example.ExampleSet;
import com.rapidminer.operator.Annotations;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduce;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduceException;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.Mappable;

public class ExampleSetModel {
	private LinkedHashMap<ExampleSetType, ExampleSet> exampleSets;
	
	private ExampleTableManager exampleTableManager;
	private ExampleSetAttributeManager attributeManager;
	private ExampleSetDataRowManager dataRowManager;
	private Double id;
	
	public ExampleSetModel(List<ExampleSetType> types, Double id) {
		this.id = id;
		attributeManager = new ExampleSetAttributeManager(types, (id!=null));
		exampleTableManager = new ExampleTableManager(attributeManager, types);
		exampleSets = new LinkedHashMap<ExampleSetType, ExampleSet>();
		initializeExampleSets(types);
		dataRowManager = new ExampleSetDataRowManager(attributeManager);
		initializeAnnotations(types);
	}
	
	public ExampleSetModel(List<ExampleSetType> types){
		this(types, null);
	}
	
	public void setId(Double id) {
		this.id = id;
	}

	private void initializeExampleSets(List<ExampleSetType> types) {
		ExampleSet set;
		for (ExampleSetType type: types) {
			set = exampleTableManager.createExampleSet(type);
			if (id!=null)
				set.getAttributes().setLabel(set.getAttributes().get(ExampleSetBuilderOntology.ID));
			exampleSets.put(type, set);
		}
		System.out.println();
	}
	
	private void initializeAnnotations(List<ExampleSetType> types) {
		for (ExampleSetType type: types) {
			setAnnotations(exampleSets.get(type), type.getTitle());
		}
	}

	private void setAnnotations(ExampleSet set, String title) {
		Annotations annotations = set.getAnnotations();
		annotations.setAnnotation(Annotations.KEY_DC_TITLE, title);
	}
	
	public ExampleSet getExampleSet(ExampleSetType type) {
		return exampleSets.get(type);
	}
	
	public LinkedHashMap<ExampleSetType, ExampleSet> getExampleSets() {
		return exampleSets;
	}
	
	public void addDataRow(ExampleSetType type, String[] values) throws MapReduceException {
		values = MapReduce.map(new ArrayList<String>(Arrays.asList(values)), new Mappable<String, String>() {
			@Override
			public String apply(String object) throws MapReduceException {
				if ((object == null) || object.equals(""))
					return "NA";
				else
					return object;
			}
		}).toArray(new String[values.length]);
		if (id!=null) {
			values = Arrays.copyOf(values, values.length+1);
			values[values.length-1] = id.toString();
		}
		exampleTableManager.addDataRow(type, 
				dataRowManager.createDataRow(type, values));
	}
	
	public static ExampleSet getEmptyExampleSet() {
		return ExampleTableManager.getEmptyExampleTable().createExampleSet();
	}
}