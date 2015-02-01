package com.rapidminer.operator.modelling.converters.tuffy;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import com.rapidminer.operator.modelling.configuration.fixed.MLNException;
import com.rapidminer.operator.modelling.converters.tuffy.parser.TuffyMLNGrammarBaseListener;
import com.rapidminer.operator.modelling.converters.tuffy.parser.TuffyMLNGrammarParser;
import com.rapidminer.operator.modelling.converters.tuffy.parser.TuffyMLNGrammarParser.ArgumentContext;
import com.rapidminer.operator.modelling.converters.tuffy.parser.TuffyMLNGrammarParser.BuiltinFunctionSymbolContext;
import com.rapidminer.operator.modelling.converters.tuffy.parser.TuffyMLNGrammarParser.BuiltinPredicateSymbolContext;
import com.rapidminer.operator.modelling.converters.tuffy.parser.TuffyMLNGrammarParser.ConstantContext;
import com.rapidminer.operator.modelling.converters.tuffy.parser.TuffyMLNGrammarParser.GroundArgumentContext;
import com.rapidminer.operator.modelling.converters.tuffy.parser.TuffyMLNGrammarParser.QuantificationContext;
import com.rapidminer.operator.modelling.converters.tuffy.parser.TuffyMLNGrammarParser.ReturnValueContext;
import com.rapidminer.operator.modelling.converters.tuffy.parser.TuffyMLNGrammarParser.WeightsContext;
import com.rapidminer.operator.modelling.converters.utilities.ANTLRUtilityMethods;
import com.rapidminer.operator.modelling.converters.utilities.TuffyGrammarUtilityMethods;
import com.rapidminer.operator.modelling.model.MLNClosedWorldType;
import com.rapidminer.operator.modelling.model.MLNConstant;
import com.rapidminer.operator.modelling.model.MLNFunctionApplication;
import com.rapidminer.operator.modelling.model.MLNFunctionDefinition;
import com.rapidminer.operator.modelling.model.MLNFunctionReturnValue;
import com.rapidminer.operator.modelling.model.MLNGroundArgument;
import com.rapidminer.operator.modelling.model.MLNGroundAtom;
import com.rapidminer.operator.modelling.model.MLNGroundFormula;
import com.rapidminer.operator.modelling.model.MLNModel;
import com.rapidminer.operator.modelling.model.MLNPlainFormula;
import com.rapidminer.operator.modelling.model.MLNPredicateApplication;
import com.rapidminer.operator.modelling.model.MLNQuantification;
import com.rapidminer.operator.modelling.model.MLNRelation;
import com.rapidminer.operator.modelling.model.MLNVarArgument;
import com.rapidminer.operator.modelling.model.MLNVariable;
import com.rapidminer.operator.modelling.model.MLNWeight;
import com.rapidminer.operator.modelling.model.operators.MLNOperatorApplication;
import com.rapidminer.operator.modelling.model.types.MLNTypeArgument;
import com.rapidminer.operator.modelling.model.types.MLNTypeContainer;

public class TuffyMLNParseListener extends TuffyMLNGrammarBaseListener {
	private static final boolean INT_ONLY = true;
	//private static final boolean NOT_INT_ONLY = false;
	private static final String INT_TYPE_NAME = "integerType";
	private static final int PROB_WEIGHT_INDEX = 0;
	private static final int UTIL_WEIGHT_INDEX = 1;
	
	private MLNModel mlnModel;
	
	private MLNTypeContainer integerType;
	
	private boolean queryFile = false;
	
	public TuffyMLNParseListener() throws MLNException {
		try {
			setMlnModel(new MLNModel());
		} catch (InstantiationException e) {
			throw new MLNException(e.getMessage(), e);
		} catch(IllegalAccessException e) {
			throw new MLNException(e.getMessage(), e);
		}
	}

	public MLNModel getMlnModel() {
		return mlnModel;
	}

	public void setMlnModel(MLNModel mlnModel) {
		this.mlnModel = mlnModel;
	}
	
	@Override
	public void exitRuleFile(@NotNull TuffyMLNGrammarParser.RuleFileContext ctx) {
		
	}
	
	@Override
	public void exitConstant(@NotNull TuffyMLNGrammarParser.ConstantContext ctx) {
		if (ctx.STRING() != null) {
			mlnModel.buildMLNConstant(ctx.STRING().getText());
		}
	}
	
	private String getVariableLabelText(TuffyMLNGrammarParser.VariableLabelContext ctx) {
		String str;
		if (ctx.VAR_ID()!=null) {
			str = ctx.VAR_ID().getText();
			str = str.substring(0, 1).toUpperCase()+str.substring(1);
			return str;
		} else {
			return ctx.CONST_ID().getText();
		}
	}
	
	@Override
	public void exitVariable(@NotNull TuffyMLNGrammarParser.VariableContext ctx) {
		mlnModel.buildMLNVariable(ctx.VAR_ID().getText(), false);
	}
	
	@Override
	public void exitExpVariable(@NotNull TuffyMLNGrammarParser.ExpVariableContext ctx) {
		mlnModel.buildMLNVariable(ctx.variable().VAR_ID().getText(), true);
	}
	
	@Override
	public void exitBuiltinFunctionSymbol(@NotNull TuffyMLNGrammarParser.BuiltinFunctionSymbolContext ctx) {
		String name = null;
		List<MLNTypeArgument> types = new ArrayList<MLNTypeArgument>();
		name = getBuiltinFunctionSymbolText(ctx);
		types.add(mlnModel.buildMLNTypeArgument(getIntegerType(), false));
		types.add(mlnModel.buildMLNTypeArgument(getIntegerType(), false));
		mlnModel.buildMLNFunction(name, types, mlnModel.buildMLNTypeArgument(getIntegerType(), 
				false));
	}
	
	@Override
	public void exitBuiltinPredicateSymbol(@NotNull TuffyMLNGrammarParser.BuiltinPredicateSymbolContext ctx) {
		String name = null;
		List<MLNTypeArgument> types = new ArrayList<MLNTypeArgument>();
		name = getBuiltinPredicateSymbolText(ctx);
		types.add(mlnModel.buildMLNTypeArgument(getIntegerType(), false));
		types.add(mlnModel.buildMLNTypeArgument(getIntegerType(), false));
		mlnModel.buildMLNPredicate(name, types);
	}
	
	@Override
	public void exitTypeDecl(@NotNull TuffyMLNGrammarParser.TypeDeclContext ctx) {
		List<Double> intList = null;
		Double lowerBound = null;
		Double upperBound = null;
		if (ctx.numList().plainNumList() != null) {
			intList = TuffyGrammarUtilityMethods.processPlainNumList(
					ctx.numList().plainNumList());
			mlnModel.buildMLNTypeContainer(ctx.type().VAR_ID().getText(), !INT_ONLY, intList);
		} else if (ctx.numList().exNumList() != null) {
			lowerBound = TuffyGrammarUtilityMethods.numberValue(ctx.numList().exNumList().startNum().number());
			upperBound = TuffyGrammarUtilityMethods.numberValue(ctx.numList().exNumList().endNum().number());
			mlnModel.buildMLNTypeContainer(ctx.type().VAR_ID().getText(), !INT_ONLY, lowerBound, upperBound);
		} else if ((ctx.constantList() != null) && (ctx.constantList().constant() != null)) {
			mlnModel.buildMLNTypeContainerFromNames(ctx.type().VAR_ID().getText(), 
					ANTLRUtilityMethods.buildTextList(ctx.constantList().constant()));
		}
	}
	
	@Override
	public void exitFunctionDecl(@NotNull TuffyMLNGrammarParser.FunctionDeclContext ctx) {
		mlnModel.buildMLNFunction(getVariableLabelText(ctx.function().variableLabel()), 
				buildTypeArgumentList(ctx.typeList()),
				mlnModel.buildMLNTypeArgumentFromNames(ctx.type().VAR_ID().getText(),
						ctx.type().exclType()!=null));
	}
	
	@Override
	public void enterQueryFile(@NotNull TuffyMLNGrammarParser.QueryFileContext ctx) {
		queryFile = true;
	}
	@Override
	public void exitPredicateDecl(@NotNull TuffyMLNGrammarParser.PredicateDeclContext ctx) {
		TuffyMLNGrammarParser.PlainPredicateContext plainCtx;
		MLNClosedWorldType closedWorld;
		if (isQueryFile()) {
			closedWorld = MLNClosedWorldType.Query;
			plainCtx = ctx.plainPredicate();
		} else if (ctx.closedWorldPredicate()!=null) {
			closedWorld = MLNClosedWorldType.ClosedWorld;
			plainCtx = ctx.closedWorldPredicate().plainPredicate();
		} else {
			closedWorld = MLNClosedWorldType.Query;
			plainCtx = ctx.plainPredicate();
		}
		List<MLNTypeArgument> types = buildTypeArgumentList(plainCtx.typeList());
		mlnModel.buildMLNPredicate(getVariableLabelText(plainCtx.predicate()
				.variableLabel()), types, closedWorld);
	}
	
	private List<MLNTypeArgument> buildTypeArgumentList(@NotNull TuffyMLNGrammarParser.TypeListContext ctx) {
		List<MLNTypeArgument> types = new ArrayList<MLNTypeArgument>();
		boolean excl;
		for (TuffyMLNGrammarParser.TypeContext type : ctx.type()) {
			if (type.exclType()!=null) {
				excl = true;
			} else {
				excl = false;
			}
			if (type.exclType() == null) {
				types.add(mlnModel.buildMLNTypeArgumentFromNames(type.VAR_ID().getText(),
						excl));
			} else {
				types.add(mlnModel.buildMLNTypeArgumentFromNames(getVariableLabelText(type.exclType().variableLabel()),
						excl));
			}
		}
		return types;
	}
	
	@Override
	public void exitFormula(@NotNull TuffyMLNGrammarParser.FormulaContext ctx) {
		MLNWeight[] weights = new MLNWeight[2];
		if (ctx.weightedFormula() != null) {
			getWeightValues(weights, ctx.weightedFormula().weights());
			mlnModel.buildMLNFormula(processPlainFormula(ctx.weightedFormula().plainFormula()),
					weights[PROB_WEIGHT_INDEX],weights[UTIL_WEIGHT_INDEX],
					 false);
		} else if (ctx.hardFormula() != null) {
			mlnModel.buildMLNFormula(processPlainFormula(ctx.hardFormula().plainFormula()), null, null, 
					true);
		} else if (ctx.plainFormula() != null) {
			mlnModel.buildMLNFormula(processPlainFormula(ctx.plainFormula()), null, null,  false);
		}
	}
	
	
	@Override
	public void exitProbabilityStatement(@NotNull TuffyMLNGrammarParser.ProbabilityStatementContext ctx) {
		String probabilityStr;
		if (ctx.probability()!=null) {
			if (ctx.probability().INT()!=null) {
				probabilityStr = ctx.probability().INT().getText();
			} else {
				probabilityStr = ctx.probability().FLOAT().getText();
			}
		} else {
			probabilityStr = null;
		}

		mlnModel.buildMLNProbabilityStatement(createGroundFormula(ctx.groundFormula()), probabilityStr!=null?
				Double.parseDouble(probabilityStr):null);
	}
	
	
	private MLNQuantification createQuantification(TuffyMLNGrammarParser.QuantificationContext ctx) {
		return mlnModel.buildMLNQuantificationFromNames(getQuantifierName(ctx.quantifier()), ctx.quantifier().E_QUANT()!=null,
				ctx.quantifier().U_QUANT()!=null,
				processPlainFormula(ctx.plainFormula()),
				ANTLRUtilityMethods.buildTextList(ctx.variableList().variable()), 
				getQuantifierRelation(ctx),
				getQuantifierNumber(ctx));
	}
	
	private String getQuantifierName(TuffyMLNGrammarParser.QuantifierContext ctx) {
		String name = null;
		if (ctx.E_QUANT() != null) {
			name = MLNQuantification.E_QUANT_NAME;
		} else if (ctx.U_QUANT() != null) {
			name = MLNQuantification.U_QUANT_NAME;
		}
		return name;
	}
	
	private MLNOperatorApplication createOperatorApplication(TuffyMLNGrammarParser.PlainFormulaContext ctx) {
		MLNOperatorApplication operatorApplication = null;
		if (ctx.LP() != null) {
			operatorApplication = mlnModel.buildMLNOperatorApplicationFromNames(MLNModel.PARENTHESES_SYMBOL, 
					ANTLRUtilityMethods.listFromElement(processPlainFormula(ctx.plainFormula(0))));
		} else if (ctx.LSP() != null) {
			operatorApplication = mlnModel.buildMLNOperatorApplicationFromNames(MLNModel.SQUARE_BRACKETS_SYMBOL, 
					ANTLRUtilityMethods.listFromElement(processPlainFormula(ctx.plainFormula(0))));
		} else if (ctx.EXCL() != null) {
			operatorApplication = mlnModel.buildMLNOperatorApplicationFromNames(MLNModel.NOT_SYMBOL, 
					ANTLRUtilityMethods.listFromElement(processPlainFormula(ctx.plainFormula(0))));
		} else if (ctx.or() != null) {
			operatorApplication = mlnModel.buildMLNOperatorApplicationFromNames(MLNModel.OR_SYMBOL,
					processPlainFormulas(ctx.plainFormula()));
		}
		return operatorApplication;
	}
	
	private MLNPlainFormula processPlainFormula(TuffyMLNGrammarParser.PlainFormulaContext ctx) {
		MLNPlainFormula plainFormula;
		if (ctx.functionApplication() != null) {
			plainFormula = mlnModel.buildMLNPlainFormula(
					createFunctionAppl(ctx.functionApplication()));
		} else if (ctx.predicateApplication() != null) {
			plainFormula = mlnModel.buildMLNPlainFormula(
					createPredicateAppl(ctx.predicateApplication()));
		} else if (ctx.quantification() != null) {
			plainFormula = mlnModel.buildMLNPlainFormula(createQuantification(ctx.quantification()));
		} else {
			plainFormula = mlnModel.buildMLNPlainFormula(createOperatorApplication(ctx));
		}
		return plainFormula;
	}
	
	public MLNTypeContainer getIntegerType() {
		if (integerType == null) {
			integerType = mlnModel.buildMLNTypeContainer(INT_TYPE_NAME, INT_ONLY,
					Double.valueOf(Integer.MIN_VALUE), 
					Double.valueOf(Integer.MAX_VALUE));
		}
		return integerType;
	}
	
	private String getBuiltinFunctionSymbolText(BuiltinFunctionSymbolContext ctx) {
		String name = null;
		if (ctx.PLUS() != null) {
			name = ctx.PLUS().getText();
		} else if (ctx.MINUS() != null) {
			name = ctx.MINUS().getText();
		} else if (ctx.STAR() != null) {
			name = ctx.STAR().getText();
		} else if (ctx.SLASH() != null) {
			name = ctx.SLASH().getText();
		} else if (ctx.MOD() != null) {
			name = ctx.MOD().getText();
		}
		return name;
	}
	
	private String getBuiltinPredicateSymbolText(BuiltinPredicateSymbolContext ctx) {
		String name = null;
		if (ctx.GE() != null) {
			name = ctx.GE().getText();
		} else if (ctx.GT() != null) {
			name = ctx.GT().getText();
		} else if (ctx.LE() != null) {
			name = ctx.LE().getText();
		} else if (ctx.LT() != null) {
			name = ctx.LT().getText();
		} else if (ctx.EQ() != null) {
			name = ctx.EQ().getText();
		}
		return name;
	}

	private void getWeightValues(MLNWeight[] weights, 
			WeightsContext ctx) {
		if ((ctx.weight().INT()) != null) {
			weights[PROB_WEIGHT_INDEX] = 
					mlnModel.buildMLNWeight(Double.parseDouble(ctx.weight().INT().getText()));
		} else if (ctx.weight().FLOAT() != null) {
			weights[PROB_WEIGHT_INDEX] = 
					mlnModel.buildMLNWeight(Double.parseDouble(ctx.weight().FLOAT().getText()));
		} else if (ctx.weight().variable()!=null) {
			weights[PROB_WEIGHT_INDEX] = 
					mlnModel.buildMLNWeightFromNames(ctx.weight().variable().VAR_ID().getText());
		}
	}

	private MLNRelation getQuantifierRelation(QuantificationContext ctx) {
		MLNRelation relation = null;
		if (ctx.quantifier().E_QUANT() != null) {
			relation = MLNQuantification.E_QUANT_RELATION;
		} else if (ctx.quantifier().U_QUANT() != null) {
			relation = MLNQuantification.U_QUANT_RELATION;
		}
		return relation;
	}
	
	private Integer getQuantifierNumber(QuantificationContext ctx) {
		Integer number  = null;
		if (ctx.quantifier().E_QUANT() != null) {
			number = MLNQuantification.E_QUANT_NUMBER;
		} else if (ctx.quantifier().U_QUANT() != null) {
			number = MLNQuantification.U_QUANT_NUMBER;
		}
		return number;
	}

	private List<MLNPlainFormula> processPlainFormulas(List<TuffyMLNGrammarParser.PlainFormulaContext> ctxts) {
		List<MLNPlainFormula> plainFormulas = new ArrayList<MLNPlainFormula>();
		for (TuffyMLNGrammarParser.PlainFormulaContext ctx : ctxts) {
			plainFormulas.add(processPlainFormula(ctx));
		}
		return plainFormulas;
	}

	private boolean isQueryFile() {
		return queryFile;
	}
	
	
	
//Alchemy insert

	@Override
	public void exitGroundFormula(@NotNull TuffyMLNGrammarParser.GroundFormulaContext ctx) {
		createGroundFormula(ctx);
	}
	
	private MLNGroundFormula createGroundFormula(@NotNull TuffyMLNGrammarParser.GroundFormulaContext ctx) {
		if (ctx.groundPredicateApplication()!=null) {
			return mlnModel.buildMLNGroundFormula(createGroundPredicateAppl(ctx.groundPredicateApplication()));
		} else if (ctx.functionDef()!=null) {
			return mlnModel.buildMLNGroundFormula(createFunctionDefinition(ctx.functionDef()));
		} else {
			return null;
		}
	}
	
	@Override
	public void exitPredicateApplication(@NotNull TuffyMLNGrammarParser.PredicateApplicationContext ctx) {
		createPredicateAppl(ctx);
	}
	
	@Override
	public void exitFunctionApplication(@NotNull TuffyMLNGrammarParser.FunctionApplicationContext ctx) {
		createFunctionAppl(ctx);
	}
	
	@Override
	public void exitGroundPredicateApplication(@NotNull TuffyMLNGrammarParser.GroundPredicateApplicationContext ctx) {
		createGroundPredicateAppl(ctx);
	}
	
	@Override
	public void exitFunctionDef(@NotNull TuffyMLNGrammarParser.FunctionDefContext ctx) {
		createFunctionDefinition(ctx);
	}
	
	
	private MLNFunctionApplication createFunctionAppl(@NotNull TuffyMLNGrammarParser.FunctionApplicationContext ctx) {
		String function;
		if (ctx.function()!=null)
			function = getVariableLabelText(ctx.function().variableLabel());
		else if (ctx.builtinFunctionSymbol()!=null)
			function = ctx.builtinFunctionSymbol().getText();
		else if (ctx.builtinPrefixFunctionSymbol()!=null)
			function = ctx.builtinPrefixFunctionSymbol().getText();
		else
			throw new IllegalArgumentException();
		return mlnModel.buildMLNFunctionApplicationFromNames(function, 
				createVarArguments(ctx.argument()));
	}
	
	private MLNFunctionApplication createFunctionAppl(@NotNull TuffyMLNGrammarParser.ArgumentContext ctx) {
		String function;
		if (ctx.function()!=null)
			function = ctx.function().getText();
		else if (ctx.builtinFunctionSymbol()!=null)
			function = ctx.builtinFunctionSymbol().getText();
		else if (ctx.builtinPrefixFunctionSymbol()!=null)
			function = ctx.builtinPrefixFunctionSymbol().getText();
		else
			throw new IllegalArgumentException();
		return mlnModel.buildMLNFunctionApplicationFromNames(function, 
				createVarArguments(ctx.argument()));
	}
	
	private MLNPredicateApplication createPredicateAppl(@NotNull TuffyMLNGrammarParser.PredicateApplicationContext ctx) {
		String predicate;
		if (ctx.predicate()!=null)
			predicate = getVariableLabelText(ctx.predicate().variableLabel());
		else if (ctx.builtinPredicateSymbol()!=null)
			predicate = ctx.builtinPredicateSymbol().getText();
		else {
			throw new IllegalArgumentException();
		}
		return mlnModel.buildMLNPredicateApplicationFromNames(predicate, 
				createVarArguments(ctx.argument()));
	}
	
	private MLNPredicateApplication createPredicateAppl(@NotNull TuffyMLNGrammarParser.ArgumentContext ctx) {
		String predicate;
		if (ctx.predicate()!=null)
			predicate = getVariableLabelText(ctx.predicate().variableLabel());
		else if (ctx.builtinPredicateSymbol()!=null)
			predicate = ctx.builtinPredicateSymbol().getText();
		else {
			throw new IllegalArgumentException();
		}
		return mlnModel.buildMLNPredicateApplicationFromNames(predicate, 
				createVarArguments(ctx.argument()));
	}
	
	private MLNFunctionDefinition createFunctionDefinition(@NotNull TuffyMLNGrammarParser.FunctionDefContext ctx) {
		return mlnModel.buildMLNFunctionDefinitionFromNames(
				getVariableLabelText(ctx.groundFunctionApplication().function().variableLabel()), 
				createReturnValue(ctx.returnValue()), createGroundArguments(ctx.groundFunctionApplication().groundArgument()));
	}
	
	private MLNGroundAtom createGroundPredicateAppl(@NotNull TuffyMLNGrammarParser.GroundPredicateApplicationContext ctx) {
		if (ctx.predicate()!=null)
			return mlnModel.buildMLNGroundAtomFromNames(
					getVariableLabelText(ctx.predicate().variableLabel()), 
					createGroundArguments(ctx.groundArgument()), ctx.EXCL()!=null);
		else if (ctx.builtinPredicateSymbol()!=null)
			return mlnModel.buildMLNGroundAtomFromNames(ctx.builtinPredicateSymbol().getText(), 
					createGroundArguments(ctx.groundArgument()), ctx.EXCL()!=null);
		else
			throw new IllegalArgumentException();
	}
	
	private MLNGroundAtom createGroundPredicateAppl(@NotNull TuffyMLNGrammarParser.GroundArgumentContext ctx) {
		return mlnModel.buildMLNGroundAtomFromNames(getVariableLabelText(ctx.predicate().variableLabel()), 
				createGroundArguments(ctx.groundArgument()), false);
	}
	
	private MLNGroundAtom createGroundFunctionAppl(@NotNull TuffyMLNGrammarParser.GroundArgumentContext ctx) {
		String function;
		if (ctx.function()!=null)
			function = ctx.function().getText();
		else if (ctx.builtinFunctionSymbol()!=null)
			function = ctx.builtinFunctionSymbol().getText();
		else if (ctx.builtinPrefixFunctionSymbol()!=null)
			function = ctx.builtinPrefixFunctionSymbol().getText();
		else
			throw new IllegalArgumentException();
		return mlnModel.buildMLNGroundAtomFromNames(function, 
				createGroundArguments(ctx.groundArgument()), false);
	}
	
	private String getConstantName(ConstantContext ctx) {
		if (ctx.STRING()!=null) {
			return ctx.STRING().getText();
		} else {
			return ctx.CONST_ID().getText();
		}
	}
	
	private List<MLNVarArgument> createVarArguments(List<ArgumentContext> contexts) {
		List<MLNVarArgument> list = new ArrayList<MLNVarArgument>();
		for (ArgumentContext ctx: contexts) {
			if (ctx.predicate()!=null || ctx.builtinPredicateSymbol()!=null)
				list.add(mlnModel.buildMLNVarArgument(createPredicateAppl(ctx), false));
			else if (ctx.function()!=null || ctx.builtinFunctionSymbol()!=null || ctx.builtinPrefixFunctionSymbol()!=null)
				list.add(mlnModel.buildMLNVarArgument(createFunctionAppl(ctx), false));
			else if (ctx.constant()!=null)
				list.add(mlnModel.buildMLNVarArgumentFromNames(MLNConstant.class, getConstantName(ctx.constant()),
						false));
			else if (ctx.variable()!=null)
				list.add(mlnModel.buildMLNVarArgumentFromNames(MLNVariable.class, ctx.variable().VAR_ID().getText(),
						false));
			else if (ctx.expVariable()!=null)
				list.add(mlnModel.buildMLNVarArgumentFromNames(MLNVariable.class, ctx.expVariable().variable().VAR_ID().getText(),
						true));
			else if (ctx.number()!=null)
				list.add(mlnModel.buildMLNVarArgument(Double.parseDouble(ctx.number().getText()), false));
		}
		return list;
	}
	
	private MLNFunctionReturnValue createReturnValue(ReturnValueContext ctx) {
		if (ctx.constant()!=null)
			return mlnModel.buildMLNFunctionReturnValueFromNames(ctx.constant().CONST_ID().getText());
		else if (ctx.number()!=null)
			return mlnModel.buildMLNFunctionReturnValue(Double.parseDouble(ctx.number().getText()));
		else
			throw new IllegalArgumentException();
	}
	
	private List<MLNGroundArgument> createGroundArguments(List<GroundArgumentContext> contexts) {
		List<MLNGroundArgument> list = new ArrayList<MLNGroundArgument>();
		for (GroundArgumentContext ctx: contexts) {
			if (ctx.predicate()!=null || ctx.builtinPredicateSymbol()!=null)
				list.add(mlnModel.buildMLNGroundArgument(createGroundPredicateAppl(ctx)));
			else if (ctx.function()!=null || ctx.builtinFunctionSymbol()!=null || ctx.builtinPrefixFunctionSymbol()!=null)
				list.add(mlnModel.buildMLNGroundArgument(createGroundFunctionAppl(ctx)));
			else if (ctx.constant()!=null)
				list.add(mlnModel.buildMLNGroundArgumentFromNames(getConstantName(ctx.constant())));
			else if (ctx.number()!=null)
				list.add(mlnModel.buildMLNGroundArgument(Double.parseDouble(ctx.number().getText())));
			else
				throw new IllegalArgumentException();
		}
		return list;
	}
	

}
