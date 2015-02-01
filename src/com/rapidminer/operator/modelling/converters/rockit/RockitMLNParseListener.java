package com.rapidminer.operator.modelling.converters.rockit;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import com.rapidminer.operator.modelling.configuration.fixed.MLNException;
import com.rapidminer.operator.modelling.converters.exampleset.parser.ExampleSetMLNGrammarParser;
import com.rapidminer.operator.modelling.converters.rockit.parser.rockitMLNGrammarBaseListener;
import com.rapidminer.operator.modelling.converters.rockit.parser.rockitMLNGrammarParser;
import com.rapidminer.operator.modelling.converters.rockit.parser.rockitMLNGrammarParser.ArgumentContext;
import com.rapidminer.operator.modelling.converters.rockit.parser.rockitMLNGrammarParser.BuiltinFunctionSymbolContext;
import com.rapidminer.operator.modelling.converters.rockit.parser.rockitMLNGrammarParser.BuiltinPredicateSymbolContext;
import com.rapidminer.operator.modelling.converters.rockit.parser.rockitMLNGrammarParser.ConstantContext;
import com.rapidminer.operator.modelling.converters.rockit.parser.rockitMLNGrammarParser.GroundArgumentContext;
import com.rapidminer.operator.modelling.converters.rockit.parser.rockitMLNGrammarParser.QuantificationContext;
import com.rapidminer.operator.modelling.converters.rockit.parser.rockitMLNGrammarParser.ReturnValueContext;
import com.rapidminer.operator.modelling.converters.rockit.parser.rockitMLNGrammarParser.WeightsContext;
import com.rapidminer.operator.modelling.converters.utilities.ANTLRUtilityMethods;
import com.rapidminer.operator.modelling.converters.utilities.RockitGrammarUtilityMethods;
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

public class RockitMLNParseListener extends rockitMLNGrammarBaseListener {
	private static final boolean INT_ONLY = true;
	//private static final boolean NOT_INT_ONLY = false;
	private static final String INT_TYPE_NAME = "integerType";
	private static final int PROB_WEIGHT_INDEX = 0;
	private static final int UTIL_WEIGHT_INDEX = 1;
	private static final String ROCKIT_QUANTIFIER = "";
	private MLNModel mlnModel;
	
	private MLNTypeContainer integerType;
	private MLNTypeContainer floatType;
	
	private boolean containsQuantification;
	
	private MLNTypeContainer getFloatType() {
		if (floatType == null)
			floatType = mlnModel.buildMLNTypeContainer(RockitMLNConverter.FLOAT_TYPE_NAME, !INT_ONLY,
					Double.valueOf(Double.MIN_VALUE), 
					Double.valueOf(Double.MAX_VALUE));
		return floatType;
	}
	
	@Override
	public void exitGroundFormula(@NotNull rockitMLNGrammarParser.GroundFormulaContext ctx) {
		createGroundFormula(ctx);
	}
	
	public RockitMLNParseListener() throws MLNException {
		try {
			setMlnModel(new MLNModel());
		} catch (InstantiationException e) {
			throw new MLNException(e.getMessage());
		} catch(IllegalAccessException e) {
			throw new MLNException(e.getMessage());
		}
	}

	public MLNModel getMlnModel() {
		return mlnModel;
	}

	public void setMlnModel(MLNModel mlnModel) {
		this.mlnModel = mlnModel;
	}
	
	@Override
	public void exitRuleFile(@NotNull rockitMLNGrammarParser.RuleFileContext ctx) {
		
	}
	
	@Override
	public void exitConstant(@NotNull rockitMLNGrammarParser.ConstantContext ctx) {
		if (ctx.STRING() != null) {
			mlnModel.buildMLNConstant(ctx.STRING().getText());
		}
	}
	
	private String getVariableLabelText(rockitMLNGrammarParser.VariableLabelContext ctx) {
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
	public void exitVariable(@NotNull rockitMLNGrammarParser.VariableContext ctx) {
		mlnModel.buildMLNVariable(ctx.VAR_ID().getText(), false);
	}
	
	@Override
	public void exitExpVariable(@NotNull rockitMLNGrammarParser.ExpVariableContext ctx) {
		mlnModel.buildMLNVariable(ctx.variable().VAR_ID().getText(), true);
	}
	
	@Override
	public void exitBuiltinFunctionSymbol(@NotNull rockitMLNGrammarParser.BuiltinFunctionSymbolContext ctx) {
		String name = null;
		List<MLNTypeArgument> types = new ArrayList<MLNTypeArgument>();
		name = getBuiltinFunctionSymbolText(ctx);
		types.add(mlnModel.buildMLNTypeArgument(getIntegerType(), false));
		types.add(mlnModel.buildMLNTypeArgument(getIntegerType(), false));
		mlnModel.buildMLNFunction(name, types, mlnModel.buildMLNTypeArgument(getIntegerType(), 
				false));
	}
	
	@Override
	public void exitBuiltinPredicateSymbol(@NotNull rockitMLNGrammarParser.BuiltinPredicateSymbolContext ctx) {
		String name = null;
		List<MLNTypeArgument> types = new ArrayList<MLNTypeArgument>();
		name = getBuiltinPredicateSymbolText(ctx);
		types.add(mlnModel.buildMLNTypeArgument(getIntegerType(), false));
		types.add(mlnModel.buildMLNTypeArgument(getIntegerType(), false));
		mlnModel.buildMLNPredicate(name, types);
	}
	
	@Override
	public void exitTypeDecl(@NotNull rockitMLNGrammarParser.TypeDeclContext ctx) {
		List<Double> intList = null;
		Double lowerBound = null;
		Double upperBound = null;
		if (ctx.numList().plainNumList() != null) {
			intList = RockitGrammarUtilityMethods.processPlainNumList(
					ctx.numList().plainNumList());
			mlnModel.buildMLNTypeContainer(getVariableLabelText(ctx.type().variableLabel()).toLowerCase(), !INT_ONLY, intList);
		} else if (ctx.numList().exNumList() != null) {
			lowerBound = RockitGrammarUtilityMethods.numberValue(ctx.numList().exNumList().startNum().number());
			upperBound = RockitGrammarUtilityMethods.numberValue(ctx.numList().exNumList().endNum().number());
			mlnModel.buildMLNTypeContainer(getVariableLabelText(ctx.type().variableLabel()).toLowerCase(), !INT_ONLY, lowerBound, upperBound);
		} else if ((ctx.constantList() != null) && (ctx.constantList().constant() != null)) {
			mlnModel.buildMLNTypeContainerFromNames(getVariableLabelText(ctx.type().variableLabel()).toLowerCase(), 
					ANTLRUtilityMethods.buildTextList(ctx.constantList().constant()));
		}
	}
	
	@Override
	public void exitFunctionDecl(@NotNull rockitMLNGrammarParser.FunctionDeclContext ctx) {
		mlnModel.buildMLNFunction(getVariableLabelText(ctx.function().variableLabel()), 
				buildTypeArgumentList(ctx.typeList()),
				mlnModel.buildMLNTypeArgumentFromNames(getVariableLabelText(ctx.type().variableLabel()).toLowerCase(),
						ctx.type().exclType()!=null));
	}
	
	@Override
	public void exitPredicateDecl(@NotNull rockitMLNGrammarParser.PredicateDeclContext ctx) {
		rockitMLNGrammarParser.PlainPredicateContext plainCtx;
		MLNClosedWorldType closedWorld;
		if (ctx.closedWorldPredicate()!=null) {
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
	
	private List<MLNTypeArgument> buildTypeArgumentList(@NotNull rockitMLNGrammarParser.TypeListContext ctx) {
		List<MLNTypeArgument> types = new ArrayList<MLNTypeArgument>();
		boolean excl;
		for (rockitMLNGrammarParser.TypeContext type : ctx.type()) {
			if (type.exclType()!=null) {
				excl = true;
			} else {
				excl = false;
			}
			if (type.exclType() == null) {
				if (type.variableLabel().equals("float_"))
					types.add(mlnModel.buildMLNTypeArgument(getFloatType(),
							excl));
				else
					types.add(mlnModel.buildMLNTypeArgumentFromNames(getVariableLabelText(type.variableLabel()).toLowerCase(),
							excl));
			} else {
				types.add(mlnModel.buildMLNTypeArgumentFromNames(getVariableLabelText(type.exclType().variableLabel()).toLowerCase(),
						excl));
			}
		}
		return types;
	}
	
	
	@Override
	public void exitFormula(@NotNull rockitMLNGrammarParser.FormulaContext ctx) {
		MLNWeight[] weights = new MLNWeight[2];
		containsQuantification = false;
		MLNPlainFormula plainFormula;
		if (ctx.weightedFormula() != null) {
			getWeightValues(weights, ctx.weightedFormula().weights());
			mlnModel.buildMLNFormula(processPlainFormula(ctx.weightedFormula().plainFormula()),
					weights[PROB_WEIGHT_INDEX],weights[UTIL_WEIGHT_INDEX],
					 false);
		} else if (ctx.hardFormula() != null) {
			mlnModel.buildMLNFormula(processPlainFormula(ctx.hardFormula().plainFormula()), null, null, 
					true);
		} else if (ctx.plainFormula() != null) {
			plainFormula = processPlainFormula(ctx.plainFormula());
			mlnModel.buildMLNFormula(plainFormula, null, null,  containsQuantification);
		}
	}
	
	@Override
	public void exitProbabilityStatement(@NotNull rockitMLNGrammarParser.ProbabilityStatementContext ctx) {
		String probabilityStr = (ctx.probability()!=null)?(ctx.probability().FLOAT()!=null)?ctx.probability().FLOAT().getText()
				:(ctx.probability().INT()!=null)?ctx.probability().INT().getText():null:null;
		mlnModel.buildMLNProbabilityStatement(createGroundFormula(ctx.groundFormula()), probabilityStr!=null?
				Double.parseDouble(probabilityStr):null);
	}
	

	private MLNGroundFormula createGroundFormula(@NotNull rockitMLNGrammarParser.GroundFormulaContext ctx) {
		if (ctx.groundPredicateApplication()!=null) {
			return mlnModel.buildMLNGroundFormula(createGroundPredicateAppl(ctx.groundPredicateApplication()));
		} else if (ctx.functionDef()!=null) {
			return mlnModel.buildMLNGroundFormula(createFunctionDefinition(ctx.functionDef()));
		} else {
			return null;
		}
	}
	
	
	private MLNQuantification createQuantification(rockitMLNGrammarParser.QuantificationContext ctx) {
		Integer num = getQuantifierNumber(ctx);
		MLNRelation rel = getQuantifierRelation(ctx);
		containsQuantification = true;
		return mlnModel.buildMLNQuantificationFromNames(ROCKIT_QUANTIFIER, num==1&& rel.equals(MLNRelation.GE), false,
				processPlainFormula(ctx.plainFormula()),
				ANTLRUtilityMethods.buildTextList(ctx.variableList().variable()), 
				getQuantifierRelation(ctx),
				num);
	}
	
	private MLNOperatorApplication createOperatorApplication(rockitMLNGrammarParser.PlainFormulaContext ctx) {
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
	
	private MLNPlainFormula processPlainFormula(rockitMLNGrammarParser.PlainFormulaContext ctx) {
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
	
	private String getConstantName(ConstantContext ctx) {
		if (ctx.STRING()!=null) {
			return ctx.STRING().getText();
		} else {
			return ctx.CONST_ID().getText();
		}
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
		if (ctx.GE() != null) {
			relation = MLNRelation.GE;
		} else if (ctx.LE() != null) {
			relation = MLNRelation.LE;
		}
		return relation;
	}
	
	private Integer getQuantifierNumber(QuantificationContext ctx) {
		Integer number  = null;
		if (ctx.cardinality() != null) {
			number = Integer.parseInt(ctx.cardinality().INT().getText());
		}
		return number;
	}

	private List<MLNPlainFormula> processPlainFormulas(List<rockitMLNGrammarParser.PlainFormulaContext> ctxts) {
		List<MLNPlainFormula> plainFormulas = new ArrayList<MLNPlainFormula>();
		for (rockitMLNGrammarParser.PlainFormulaContext ctx : ctxts) {
			plainFormulas.add(processPlainFormula(ctx));
		}
		return plainFormulas;
	}
	

	//Start Alchemy insert
	@Override
	public void exitPredicateApplication(@NotNull rockitMLNGrammarParser.PredicateApplicationContext ctx) {
		createPredicateAppl(ctx);
	}
	
	@Override
	public void exitFunctionApplication(@NotNull rockitMLNGrammarParser.FunctionApplicationContext ctx) {
		createFunctionAppl(ctx);
	}
	
	@Override
	public void exitGroundPredicateApplication(@NotNull rockitMLNGrammarParser.GroundPredicateApplicationContext ctx) {
		createGroundPredicateAppl(ctx);
	}
	
	@Override
	public void exitFunctionDef(@NotNull rockitMLNGrammarParser.FunctionDefContext ctx) {
		createFunctionDefinition(ctx);
	}
	
	
	private MLNFunctionApplication createFunctionAppl(@NotNull rockitMLNGrammarParser.FunctionApplicationContext ctx) {
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
	
	private MLNFunctionApplication createFunctionAppl(@NotNull rockitMLNGrammarParser.ArgumentContext ctx) {
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
	
	private MLNPredicateApplication createPredicateAppl(@NotNull rockitMLNGrammarParser.PredicateApplicationContext ctx) {
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
	
	private MLNPredicateApplication createPredicateAppl(@NotNull rockitMLNGrammarParser.ArgumentContext ctx) {
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
	
	private MLNFunctionDefinition createFunctionDefinition(@NotNull rockitMLNGrammarParser.FunctionDefContext ctx) {
		return mlnModel.buildMLNFunctionDefinitionFromNames(
				getVariableLabelText(ctx.groundFunctionApplication().function().variableLabel()), 
				createReturnValue(ctx.returnValue()), createGroundArguments(ctx.groundFunctionApplication().groundArgument()));
	}
	
	private MLNGroundAtom createGroundPredicateAppl(@NotNull rockitMLNGrammarParser.GroundPredicateApplicationContext ctx) {
		if (ctx.predicate()!=null)
			return mlnModel.buildMLNGroundAtomFromNames(getVariableLabelText(ctx.predicate().variableLabel()), 
					createGroundArguments(ctx.groundArgument()), ctx.EXCL()!=null);
		else if (ctx.builtinPredicateSymbol()!=null)
			return mlnModel.buildMLNGroundAtomFromNames(ctx.builtinPredicateSymbol().getText(), 
					createGroundArguments(ctx.groundArgument()), ctx.EXCL()!=null);
		else
			throw new IllegalArgumentException();
	}
	
	private MLNGroundAtom createGroundPredicateAppl(@NotNull rockitMLNGrammarParser.GroundArgumentContext ctx) {
		return mlnModel.buildMLNGroundAtomFromNames(getVariableLabelText(ctx.predicate().variableLabel()), 
				createGroundArguments(ctx.groundArgument()), false);
	}
	
	private MLNGroundAtom createGroundFunctionAppl(@NotNull rockitMLNGrammarParser.GroundArgumentContext ctx) {
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
			return mlnModel.buildMLNFunctionReturnValueFromNames(getConstantName(ctx.constant()));
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
