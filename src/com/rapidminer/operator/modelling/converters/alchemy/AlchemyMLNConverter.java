package com.rapidminer.operator.modelling.converters.alchemy;

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

import com.rapidminer.operator.modelling.configuration.fixed.MLNException;
import com.rapidminer.operator.modelling.configuration.fixed.MLNFileRole;
import com.rapidminer.operator.modelling.converters.MLNFileConverter;
import com.rapidminer.operator.modelling.converters.alchemy.parser.alchemyMLNGrammarLexer;
import com.rapidminer.operator.modelling.converters.alchemy.parser.alchemyMLNGrammarParser;
import com.rapidminer.operator.modelling.model.MLNFormula;
import com.rapidminer.operator.modelling.model.MLNFunction;
import com.rapidminer.operator.modelling.model.MLNGroundFormula;
import com.rapidminer.operator.modelling.model.MLNModel;
import com.rapidminer.operator.modelling.model.MLNPredicate;
import com.rapidminer.operator.modelling.model.MLNProbabilityStatement;
import com.rapidminer.operator.modelling.model.types.MLNTypeContainer;

public class AlchemyMLNConverter extends MLNFileConverter {
	private AlchemyMLNParseListener parseListener;
	private ANTLRInputStream inputData;
	private OutputStreamWriter outputStreamWriter;
	
	private boolean convertLEconstraints = false;
	private boolean removeUnsupportedConstraints = false;
	
	public AlchemyMLNConverter(InputStream inputStream, OutputStream outputStream) {
		super(inputStream, outputStream);
	}
	
	private TokenStream getTokenStream() {
		alchemyMLNGrammarLexer lexer =  new alchemyMLNGrammarLexer(inputData);
		return new CommonTokenStream(lexer);
	}
	
	private alchemyMLNGrammarParser getParser(TokenStream tokenStream) {
		return new alchemyMLNGrammarParser(tokenStream);
	}
	
	@Override
	public MLNModel internalBuildModel(MLNFileRole role) throws MLNException{
		parseListener = new AlchemyMLNParseListener();
		ParseTree tree;
		try {
			inputData = new ANTLRInputStream(inputStream);
			MLNModel mlnModel;
			if (this.model == null) {
				try {
					mlnModel = new MLNModel();
					this.model = mlnModel;
				} catch (InstantiationException e) {
					throw new MLNException(e.getMessage(), e);
				} catch (IllegalAccessException e) {
					throw new MLNException(e.getMessage(), e);
				}
			} else {
				mlnModel = this.model;
			}
			parseListener.setMlnModel(mlnModel);
			alchemyMLNGrammarParser parser = getParser(getTokenStream());
			if (role.name().equals(MLNFileRole.EVIDENCE.name())) {
				tree = parser.dbFile();
			} else if (role.name().equals(MLNFileRole.INFERENCE_RESULT.name())) {
				tree = parser.infFile();
			}	else {
				tree = parser.ruleFile();
			}
			ParseTreeWalker walker = new ParseTreeWalker();
			walker.walk(parseListener, tree);
			return mlnModel;
		} catch (IOException e) {
			throw new MLNException(e.getMessage(), e);
		}
	}
	
	protected int buildTypeDeclarations(MLNModel mlnModel)  throws MLNException  {
		List<MLNTypeContainer> list =  mlnModel.getAll(MLNTypeContainer.class);
		for (MLNTypeContainer typeContainer : list) {
			write(AlchemyMLNBuilder.buildTypeDeclaration(typeContainer)+"\n");
		}
		return list.size();
	}
	
	protected int buildPredicateDeclarations(MLNModel mlnModel)  throws MLNException {
		List<MLNPredicate> list =  mlnModel.getAll(MLNPredicate.class);
		for (MLNPredicate predicate : list) {
			write(AlchemyMLNBuilder.buildPredicateDeclaration(predicate)+"\n");
		}
		return list.size();
	}
	
	protected int buildFunctionDeclarations(MLNModel mlnModel)  throws MLNException  {
		List<MLNFunction> list =  mlnModel.getAll(MLNFunction.class);
		for (MLNFunction function : list) {
			write(AlchemyMLNBuilder.buildFunctionDeclaration(function)+"\n");
		}
		return list.size();
	}
	
	protected int buildGroundFormulas(MLNModel mlnModel)  throws MLNException  {
		List<MLNGroundFormula> list =  mlnModel.getAll(MLNGroundFormula.class);
		for (MLNGroundFormula groundFormula : list) {
			write(AlchemyMLNBuilder.buildGroundFormula(groundFormula)+"\n");
		}
		return list.size();
	}
	
	protected int buildProbabilityStatements(MLNModel mlnModel) throws MLNException  {
		List<MLNProbabilityStatement> list = mlnModel.getAll(MLNProbabilityStatement.class);
		for (MLNProbabilityStatement statement: list) {
			write(AlchemyMLNBuilder.buildProbablityStatement(statement)+"\n");
		}
		return list.size();
	}
	
	protected int buildFormulas(MLNModel mlnModel) throws MLNException {
		List<MLNFormula> list =  mlnModel.getAll(MLNFormula.class);
		for (MLNFormula formula : list) {
			write(AlchemyMLNBuilder.buildFormula(formula, convertLEconstraints, removeUnsupportedConstraints)+"\n");
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
	public void setExclConstraintConversion(boolean value) throws MLNException {
		throw new RuntimeException();
	}

	@Override
	public void internalConvertModel(MLNModel model, MLNFileRole role)
			throws MLNException {
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
			buildProbabilityStatements(model);
		}
		
		try {
			outputStreamWriter.flush();
			outputStreamWriter.close();
		} catch (IOException e) {
			throw new MLNException(e.getMessage(), e);
		}
	}

	@Override
	public void setConvertLEConstraint(boolean value) throws MLNException {
		this.convertLEconstraints = value;
	}
	
	@Override
	public void setRemoveUnsupportedConstraints(boolean value) throws MLNException {
		this.removeUnsupportedConstraints = value;
	}
}
