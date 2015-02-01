package com.rapidminer.operator.modelling.converters.exampleset.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rapidminer.example.ExampleSet;
import com.rapidminer.example.table.DataRow;
import com.rapidminer.example.table.ExampleTable;
import com.rapidminer.example.table.MemoryExampleTable;

public class ExampleTableManager {
	
	private Map<ExampleSetType, MemoryExampleTable> exampleTables;
	private ExampleSetAttributeManager attributeManager;
	
	
	public ExampleTableManager(ExampleSetAttributeManager attributeManager, List<ExampleSetType> types) {
		this.attributeManager = attributeManager;
		exampleTables = new HashMap<ExampleSetType, MemoryExampleTable>();
		initializeExampleTables(types);
	}
	
	private void initializeExampleTables(List<ExampleSetType> types) {
		for (ExampleSetType type: types) {
			MemoryExampleTable table = new MemoryExampleTable(attributeManager.getAttributes(type));
			exampleTables.put(type, table);
		}
	}
	
	public ExampleSet createExampleSet(ExampleSetType type) {
		return exampleTables.get(type).createExampleSet();
	}
	
	public void addDataRow(ExampleSetType type, DataRow dataRow) {
		exampleTables.get(type).addDataRow(dataRow);
	}
	
	protected static ExampleTable getEmptyExampleTable() {
		return new MemoryExampleTable(ExampleSetAttributeManager.getEmptyAttributes());
	}
}
