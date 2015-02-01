package com.rapidminer.operator.modelling.converters.rockit;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.rapidminer.operator.modelling.configuration.fixed.MLNError;
import com.rapidminer.operator.modelling.configuration.fixed.MLNException;
import com.rapidminer.operator.modelling.configuration.fixed.MLNFileRole;
import com.rapidminer.operator.modelling.converters.MLNFileConverter;
import com.rapidminer.operator.modelling.converters.rockit.parser.rockitMLNGrammarLexer;
import com.rapidminer.operator.modelling.converters.rockit.parser.rockitMLNGrammarParser;
import com.rapidminer.operator.modelling.model.MLNClosedWorldType;
import com.rapidminer.operator.modelling.model.MLNFormula;
import com.rapidminer.operator.modelling.model.MLNFunction;
import com.rapidminer.operator.modelling.model.MLNGroundFormula;
import com.rapidminer.operator.modelling.model.MLNModel;
import com.rapidminer.operator.modelling.model.MLNPredicate;
import com.rapidminer.operator.modelling.model.MLNProbabilityStatement;
import com.rapidminer.operator.modelling.model.types.MLNTypeContainer;

public class RockitMLNConverter extends MLNFileConverter {
	
	public RockitMLNConverter(InputStream inputStream, OutputStream outputStream) {
		super(inputStream, outputStream);
	}

	private RockitMLNParseListener parseListener;
	private ANTLRInputStream inputData;
	private OutputStreamWriter outputStreamWriter;
	private RockitMLNBuilder rockitBuilder;
	public static final String FLOAT_TYPE_NAME = "float_";

	private boolean convertExcl = false;
	
	
	private TokenStream getTokenStream() {
		rockitMLNGrammarLexer lexer =  new rockitMLNGrammarLexer(inputData);
		return new CommonTokenStream(lexer);
	}
	
	private rockitMLNGrammarParser getParser(TokenStream tokenStream) {
		return new rockitMLNGrammarParser(tokenStream);
	}
	
	@Override
	public MLNModel internalBuildModel(MLNFileRole role) throws MLNException{
		parseListener = new RockitMLNParseListener();
		ParseTree tree;
		try {
			inputData = new ANTLRInputStream(inputStream);
			MLNModel mlnModel;
			if (this.model == null) {
				try {
					mlnModel = new MLNModel();
					this.model = mlnModel;
				} catch (InstantiationException e) {
					throw new MLNException(e.getMessage());
				} catch (IllegalAccessException e) {
					throw new MLNException(e.getMessage());
				}
			} else {
				mlnModel = this.model;
			}
			parseListener.setMlnModel(mlnModel);
			rockitMLNGrammarParser parser = getParser(getTokenStream());
			if (role.name().equals(MLNFileRole.EVIDENCE.name())) {
				tree = parser.dbFile();
			} else if (role.name().equals(MLNFileRole.INFERENCE_RESULT.name())) {
				tree = parser.infFile();
			} else {
				tree = parser.ruleFile();
			}
			ParseTreeWalker walker = new ParseTreeWalker();
			walker.walk(parseListener, tree);
			return mlnModel;
		} catch (IOException e) {
			throw new MLNException(e.getMessage());
		}
	}
	
	protected int buildTypeDeclarations(MLNModel mlnModel) throws MLNException {
		List<MLNTypeContainer> list =  mlnModel.getAll(MLNTypeContainer.class);
		for (MLNTypeContainer typeContainer : list) {
			write(rockitBuilder.buildTypeDeclaration(typeContainer)+"\n");
		}
		return list.size();
	}
	
	protected int buildPredicateDeclarations(MLNModel mlnModel, MLNClosedWorldType... types) throws MLNException {
		List<MLNPredicate> list =  mlnModel.getAll(MLNPredicate.class);
		for (MLNPredicate predicate : list) {
			write(rockitBuilder.buildPredicateDeclaration(predicate, convertExcl)+"\n");
		}
		return list.size();
	}
	
	protected int buildFunctionDeclarations(MLNModel mlnModel) throws MLNException {
		List<MLNFunction> list =  mlnModel.getAll(MLNFunction.class);
		for (MLNFunction function : list) {
			write(rockitBuilder.buildFunctionDeclaration(function)+"\n");
		}
		return list.size();
	}
	
	protected int buildGroundFormulas(MLNModel mlnModel) throws MLNException {
		List<MLNGroundFormula> list =  mlnModel.getAll(MLNGroundFormula.class);
		for (MLNGroundFormula groundFormula : list) {
			write(rockitBuilder.buildGroundFormula(groundFormula)+"\n");
		}
		return list.size();
	}
	
	protected int buildProbabilityStatements(MLNModel mlnModel) throws MLNException {
		List<MLNProbabilityStatement> list = mlnModel.getAll(MLNProbabilityStatement.class);
		for (MLNProbabilityStatement statement: list) {
			write(rockitBuilder.buildProbablityStatement(statement)+"\n");
		}
		return list.size();
	}
	
	protected int buildFormulas(MLNModel mlnModel) throws MLNException {
		List<MLNFormula> list =  mlnModel.getAll(MLNFormula.class);
		for (MLNFormula formula : list) {
			write(rockitBuilder.buildFormula(formula)+"\n");
		}
		return list.size();
	}
	
	private void write(String str) {
		try {
			outputStreamWriter.write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void setExclConstraintConversion(boolean value) {
		convertExcl = value;
	}
	
	@Override
	public void internalConvertModel(MLNModel model, MLNFileRole role)
			throws MLNException {
		updateFloatType(model, FLOAT_TYPE_NAME, false, Double.MIN_VALUE, Double.MAX_VALUE);
		this.rockitBuilder = new RockitMLNBuilder(model);
		outputStreamWriter = new OutputStreamWriter(outputStream);
		if (role.equals(MLNFileRole.RULES)) {
			if(buildTypeDeclarations(model) >0) 
				write("\n");
			if(buildPredicateDeclarations(model) >0) 
				write("\n");
			if(buildFunctionDeclarations(model) >0) 
				write("\n");
			buildFormulas(model);
		} else if (role.equals(MLNFileRole.QUERY)) {
			buildPredicateDeclarations(model);
		} else if (role.equals(MLNFileRole.EVIDENCE)){
			buildGroundFormulas(model);
		} else {
			if (buildProbabilityStatements(model)>0)
				write("\n");
			buildProbabilityStatements(model);
		}
		
		try {
			outputStreamWriter.flush();
			outputStreamWriter.close();
		} catch (IOException e) {
			throw new MLNException(e.getMessage());
		}
	}
	
	@Override
	public void setConvertLEConstraint(boolean value) throws MLNException {
		MLNError.LE_CONV.exception();
	}

	@Override
	public void setRemoveUnsupportedConstraints(boolean value) throws MLNException {
		MLNError.REMOVE_NOT_SUPPORTED.exception();
	}
}

