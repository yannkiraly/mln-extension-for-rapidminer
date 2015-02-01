package com.rapidminer.operator.modelling.converters.exampleset.exampleconverters;

import java.util.Iterator;
import java.util.List;

import com.rapidminer.example.Example;
import com.rapidminer.example.ExampleSet;
import com.rapidminer.example.set.AttributesExampleReader;
import com.rapidminer.operator.modelling.configuration.fixed.MLNException;
import com.rapidminer.operator.modelling.converters.utilities.ConverterUtilities;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduce;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduceException;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.Mappable;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.Reducer;

public abstract class ExampleConverter  implements Reducer<Example, String>{
	
	@Override
	public abstract String reduce(Example obj);
	
	public static List<String> convertExampleSets(List<ExampleSet> exampleSets, 
			List<Reducer<Example, String>> converters)  throws MLNException {
		try {
			return MapReduce.listReduce(getExampleIterators(exampleSets).iterator(), 
					converters.iterator());
		} catch (MapReduceException e) {
			throw new MLNException(e.getMessage());
		}
	}
	
	public static List<Iterator<Example>> getExampleIterators(List<ExampleSet> exampleSets) 
			throws MLNException {
		try {
			return MapReduce.map(exampleSets.iterator(), 
					new Mappable<ExampleSet, Iterator<Example>>() {
				@Override
				public Iterator<Example> apply(ExampleSet object) {
					AttributesExampleReader reader = new AttributesExampleReader(object.iterator(), object);
					return reader;
				}
			});
		} catch (MapReduceException e) {
			throw new MLNException(e.getMessage());
		}
	}
	
	@Override
	public String reduce(String a, Example b) {
		return a + ConverterUtilities.NEW_LINE + reduce(b);
	}
	
	protected String removeNA(String str) {
		if (str.equals("NA"))
			return "";
		else
			return str;
	}

}
