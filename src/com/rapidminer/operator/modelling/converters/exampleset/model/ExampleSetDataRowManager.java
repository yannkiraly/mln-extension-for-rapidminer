package com.rapidminer.operator.modelling.converters.exampleset.model;

import java.util.HashMap;
import java.util.Map;

import com.rapidminer.example.table.DataRow;
import com.rapidminer.example.table.DataRowFactory;

public class ExampleSetDataRowManager {
	private ExampleSetAttributeManager attributeManager;
	private Map<ExampleSetType, DataRowFactory> dataRowFactories;
	
	public ExampleSetDataRowManager(ExampleSetAttributeManager attributeManager) {
		dataRowFactories = new HashMap<ExampleSetType, DataRowFactory>();
		initializeDataRowFactories();
		this.attributeManager = attributeManager;
	}
	
	private void initializeDataRowFactories() {
		for (ExampleSetType element: ExampleSetType.values()) {
			dataRowFactories.put(element, 
					new DataRowFactory(DataRowFactory.TYPE_INT_ARRAY,'.'));
		}
	}
	
	public DataRow createDataRow(ExampleSetType type, String[] values) {
		System.out.println(type.getTitle());
		return dataRowFactories.get(type).create(values, 
				attributeManager.getAttributes(type));
	}

	

}
