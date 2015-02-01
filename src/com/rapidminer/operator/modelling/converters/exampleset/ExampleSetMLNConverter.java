package com.rapidminer.operator.modelling.converters.exampleset;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.rapidminer.example.Example;
import com.rapidminer.example.ExampleSet;
import com.rapidminer.operator.modelling.configuration.fixed.MLNError;
import com.rapidminer.operator.modelling.configuration.fixed.MLNException;
import com.rapidminer.operator.modelling.configuration.fixed.MLNFileRole;
import com.rapidminer.operator.modelling.converters.MLNConverter;
import com.rapidminer.operator.modelling.converters.exampleset.exampleconverters.ExampleConverter;
import com.rapidminer.operator.modelling.converters.exampleset.exampleconverters.FastExampleConverter;
import com.rapidminer.operator.modelling.converters.exampleset.model.ExampleSetType;
import com.rapidminer.operator.modelling.converters.exampleset.parser.ExampleSetMLNGrammarLexer;
import com.rapidminer.operator.modelling.converters.exampleset.parser.ExampleSetMLNGrammarParser;
import com.rapidminer.operator.modelling.converters.utilities.ConverterUtilities;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduce;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduceException;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.Mappable;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.Reducer;
import com.rapidminer.operator.modelling.model.MLNModel;
import com.rapidminer.operator.modelling.model.MLNPredicate;

public class ExampleSetMLNConverter extends MLNConverter {
	
	private ExampleSetParseListener parseListener;
	private ANTLRInputStream inputData;
	private List<ExampleSet> exampleSetInput;
	private LinkedHashMap<ExampleSetType, ExampleSet> exampleSetOutput;
	private MLNModel model;
	private List<ExampleSetType> exampleSetTypes;
	
	@Override
	public void setConvertLEConstraint(boolean value) throws MLNException {
		MLNError.LE_CONV.exception();
	}
	
	public ExampleSetMLNConverter(List<ExampleSet> exampleSetInput, 
			LinkedHashMap<ExampleSetType, ExampleSet>  exampleSetOutput) {
		this.exampleSetInput = exampleSetInput;
		this.exampleSetOutput = exampleSetOutput;
	}
	
	public ExampleSetMLNConverter(List<ExampleSet> exampleSetInput, 
			LinkedHashMap<ExampleSetType, ExampleSet>  exampleSetOutput,
			MLNModel model) {
		this(exampleSetInput, exampleSetOutput);
		this.model= model;
	}
	
	public ExampleSetMLNConverter(List<ExampleSet> exampleSetInput, 
			LinkedHashMap<ExampleSetType, ExampleSet>  exampleSetOutput,
			List<ExampleSetType> exampleSetTypes) {
		this(exampleSetInput, exampleSetOutput);
		this.exampleSetTypes = exampleSetTypes;
	}
	
	public ExampleSetMLNConverter(List<ExampleSet> exampleSetInput, 
			LinkedHashMap<ExampleSetType, ExampleSet>  exampleSetOutput,
			MLNModel model, List<ExampleSetType> exampleSetTypes) {
		this(exampleSetInput, exampleSetOutput, model);
		this.exampleSetTypes = exampleSetTypes;
	}

	@Override
	public MLNModel buildModel(MLNFileRole role)
			throws MLNException {
		parseListener = new ExampleSetParseListener();
		ParseTree tree;
		MLNModel mlnModel;
		String modelString;
		Double id = null;
		int esCounter = 0;
		Example es;
		if (this.model == null) {
			try {
				mlnModel = new MLNModel();
			} catch (InstantiationException e) {
				throw new MLNException(e.getMessage(), e);
			} catch (IllegalAccessException e) {
				throw new MLNException(e.getMessage(), e);
			}
		} else {
			mlnModel = this.model;
		}
		parseListener.setMlnModel(mlnModel);
		try {
			while (id==null && esCounter < exampleSetInput.size()) {
				if (exampleSetInput.get(esCounter).size()>0) {
					es = exampleSetInput.get(esCounter).getExample(0);
					if (es.getAttributes().getLabel()!=null)
						id = es.getAttributes().getLabel().getValue(es.getDataRow());
				}
				esCounter++;
			}
			if (id != null)
				mlnModel.setId(id);
			if (exampleSetTypes == null)  {
				modelString = fastExampleSetsToString(
						exampleSetInput, role);
			} else
				modelString = fastExampleSetsToString(
						exampleSetInput, exampleSetTypes);
			inputData = new ANTLRInputStream(new ByteArrayInputStream(modelString.getBytes()));
			ExampleSetMLNGrammarParser parser = getParser(getTokenStream());
			if (role.getKey().equals(MLNFileRole.EVIDENCE.getKey())) {
				tree = parser.dbFile();
			} else if (role.getKey().equals(MLNFileRole.INFERENCE_RESULT.getKey())) {
				tree = parser.infFile();
			} else if (role.getKey().equals(MLNFileRole.QUERY.getKey())) {
				tree = parser.queryFile();
			}	else {
				tree = parser.ruleFile();
			}
			ParseTreeWalker walker = new ParseTreeWalker();
			walker.walk(parseListener, tree);
			List<MLNPredicate> preds = mlnModel.getAll(MLNPredicate.class);
			return mlnModel;
		} catch (IOException e) {
			throw new MLNException(e.getMessage(), e);
		}
		
	}
	
	private String exampleSetsToString(List<ExampleSet> setLists, MLNFileRole role) throws MLNException {
		return exampleSetsToString(setLists, role.getExampleSetTypes());
	}
	
	private String fastExampleSetsToString(List<ExampleSet> setLists, MLNFileRole role) {
		FastExampleConverter conv = new FastExampleConverter();
		return conv.convertExampleSets(setLists, role.getExampleSetTypes());
	}
	
	private String fastExampleSetsToString(List<ExampleSet> setLists, List<ExampleSetType> types) {
		FastExampleConverter conv = new FastExampleConverter();
		return conv.convertExampleSets(setLists, types);
	}
	
	private String exampleSetsToString(List<ExampleSet> setLists, List<ExampleSetType> exampleSetTypes) 
	throws MLNException {
		try {
			String str = ConverterUtilities.listToString(ExampleConverter.convertExampleSets(setLists, MapReduce.map(exampleSetTypes.iterator(),
					new Mappable<ExampleSetType, Reducer<Example, String>>() {
						@Override
						public Reducer<Example, String> apply(ExampleSetType object)
								throws MapReduceException {
							return object.getConverter();
						}
			})), ConverterUtilities.NEW_LINE);
			return str;
		} catch (MapReduceException e) {
			throw new MLNException(e.getMessage(), e);
		}
	}
	
	private ExampleSetMLNGrammarParser getParser(TokenStream tokenStream) {
		return new ExampleSetMLNGrammarParser(tokenStream);
	}
	
	private TokenStream getTokenStream() {
		ExampleSetMLNGrammarLexer lexer =  new ExampleSetMLNGrammarLexer(inputData);
		return new CommonTokenStream(lexer);
	}

	protected String exampleSetsToString(MLNModel mlnModel, List<ExampleSet> exampleSets, 
			MLNFileRole role) throws MLNException {
		try {
			return ConverterUtilities.listToString(ExampleConverter.convertExampleSets(exampleSets, 
					MapReduce.map(role.getExampleSetTypes().iterator(), 
							new Mappable<ExampleSetType, Reducer<Example, String>>() {
								@Override
								public Reducer<Example, String> apply(ExampleSetType object)
										throws MapReduceException {
									return object.getConverter();
								}
					})), ConverterUtilities.NEW_LINE);
			
		} catch (MapReduceException e) {
			throw new MLNException(e.getMessage(), e);
		}
	}


	@Override
	public void convertModel(MLNModel model, 
			MLNFileRole role) throws MLNException {
		List<ExampleSetType> types;
		if (this.exampleSetTypes == null)
			types = role.getExampleSetTypes();
		else
			types = this.exampleSetTypes;
		this.exampleSetOutput.putAll((new ExampleSetBuilder(types,
				model.getId())).buildExampleSets(model));
	}

	@Override
	public MLNModel buildModel(MLNFileRole role, MLNModel modelToExtend)
			throws MLNException {
		this.model = modelToExtend;
		return buildModel(role);
	}
	
	@Override
	public void setExclConstraintConversion(boolean value) throws MLNException {
		throw new RuntimeException();
	}

	@Override
	public void setRemoveUnsupportedConstraints(boolean value)
			throws MLNException {
		MLNError.REMOVE_NOT_SUPPORTED.exception();
	}
	
}
