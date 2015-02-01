package com.rapidminer.operator.modelling.converters.alchemy;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import com.rapidminer.operator.modelling.configuration.fixed.MLNException;
import com.rapidminer.operator.modelling.converters.alchemy.parser.alchemyMLNGrammarBaseListener;
import com.rapidminer.operator.modelling.converters.alchemy.parser.alchemyMLNGrammarParser;
import com.rapidminer.operator.modelling.converters.alchemy.parser.alchemyMLNGrammarParser.ArgumentContext;
import com.rapidminer.operator.modelling.converters.alchemy.parser.alchemyMLNGrammarParser.ConstantContext;
import com.rapidminer.operator.modelling.converters.alchemy.parser.alchemyMLNGrammarParser.GroundArgumentContext;
import com.rapidminer.operator.modelling.converters.alchemy.parser.alchemyMLNGrammarParser.QuantifierContext;
import com.rapidminer.operator.modelling.converters.alchemy.parser.alchemyMLNGrammarParser.ReturnValueContext;
import com.rapidminer.operator.modelling.converters.alchemy.parser.alchemyMLNGrammarParser.WeightsContext;
import com.rapidminer.operator.modelling.converters.utilities.ANTLRUtilityMethods;
import com.rapidminer.operator.modelling.converters.utilities.AlchemyGrammarUtilityMethods;
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

public class AlchemyMLNParseListener extends alchemyMLNGrammarBaseListener {
	private static final boolean INT_ONLY = true;
	private static final String INT_TYPE_NAME = "integerType";
	private static final int PROB_WEIGHT_INDEX = 0;
	private static final int UTIL_WEIGHT_INDEX = 1;
	
	private MLNModel mlnModel;
	
	private MLNTypeContainer integerType;
	
	public AlchemyMLNParseListener() throws MLNException {
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
	public void exitConstant(@NotNull alchemyMLNGrammarParser.ConstantContext ctx) {
		if (ctx.CONST_ID() != null) {
			mlnModel.buildMLNConstant("\""+ctx.CONST_ID().getText()+"\"");
		} else if (ctx.STRING() != null) {
			mlnModel.buildMLNConstant(ctx.STRING().getText());
		}
	}
	
	@Override
	public void exitVariable(@NotNull alchemyMLNGrammarParser.VariableContext ctx) {
		mlnModel.buildMLNVariable(ctx.VAR_ID().getText(), false);
	}
	
	@Override
	public void exitExpVariable(@NotNull alchemyMLNGrammarParser.ExpVariableContext ctx) {
		mlnModel.buildMLNVariable(ctx.variable().VAR_ID().getText(), true);
	}
	
	@Override
	public void exitTypeDecl(@NotNull alchemyMLNGrammarParser.TypeDeclContext ctx) {
		List<Double> intList = null;
		Double lowerBound = null;
		Double upperBound = null;
		if (ctx.intList().plainIntList() != null) {
			intList = AlchemyGrammarUtilityMethods.processPlainIntList(
					ctx.intList().plainIntList());
			mlnModel.buildMLNTypeContainer(ctx.type().VAR_ID().getText(), INT_ONLY, intList);
		} else if (ctx.intList().exIntList() != null) {
			lowerBound = Double.parseDouble(ctx.intList().exIntList().startInt().INT().getText());
			upperBound = Double.parseDouble(ctx.intList().exIntList().endInt().INT().getText());
			mlnModel.buildMLNTypeContainer(ctx.type().VAR_ID().getText(), INT_ONLY, lowerBound, upperBound);
		} else if ((ctx.constantList() != null) && (ctx.constantList().constant() != null)) {
			mlnModel.buildMLNTypeContainerFromNames(ctx.type().VAR_ID().getText(), 
					ANTLRUtilityMethods.buildTextList(ctx.constantList().constant()));
		}
	}
	
	@Override
	public void exitFunctionDecl(@NotNull alchemyMLNGrammarParser.FunctionDeclContext ctx) {
		mlnModel.buildMLNFunction(ctx.function().CONST_ID().getText(), 
				buildTypeArgumentList(ctx.typeList()),
				mlnModel.buildMLNTypeArgumentFromNames(ctx.type().VAR_ID()
						.getText(), ctx.type().exclType()!=null));
	}
	
	@Override
	public void exitPredicateDecl(@NotNull alchemyMLNGrammarParser.PredicateDeclContext ctx) {
		List<MLNTypeArgument> types = buildTypeArgumentList(ctx.typeList());
		mlnModel.buildMLNPredicate(ctx.predicate().CONST_ID().getText(), types);
	}
	
	private List<MLNTypeArgument> buildTypeArgumentList(@NotNull alchemyMLNGrammarParser.TypeListContext ctx) {
		List<MLNTypeArgument> types = new ArrayList<MLNTypeArgument>();
		boolean excl;
		for (alchemyMLNGrammarParser.TypeContext type : ctx.type()) {
			if (type.exclType()!=null) {
				excl = true;
			} else {
				excl = false;
			}
			if (type.VAR_ID() != null) {
				types.add(mlnModel.buildMLNTypeArgumentFromNames(type.VAR_ID().getText(),
						excl));
			} else {
				types.add(mlnModel.buildMLNTypeArgumentFromNames(type.exclType().VAR_ID().getText(),
						excl));
			}
		}
		return types;
	}
	

	@Override
	public void exitGroundFormula(@NotNull alchemyMLNGrammarParser.GroundFormulaContext ctx) {
		createGroundFormula(ctx);
	}
	
	private MLNGroundFormula createGroundFormula(@NotNull alchemyMLNGrammarParser.GroundFormulaContext ctx) {
		if (ctx.groundPredicateApplication()!=null) {
			return mlnModel.buildMLNGroundFormula(createGroundPredicateAppl(ctx.groundPredicateApplication()));
		} else if (ctx.functionDef()!=null) {
			return mlnModel.buildMLNGroundFormula(createFunctionDefinition(ctx.functionDef()));
		} else {
			return null;
		}
	}
	
	@Override
	public void exitPredicateApplication(@NotNull alchemyMLNGrammarParser.PredicateApplicationContext ctx) {
		createPredicateAppl(ctx);
	}
	
	@Override
	public void exitFunctionApplication(@NotNull alchemyMLNGrammarParser.FunctionApplicationContext ctx) {
		createFunctionAppl(ctx);
	}
	
	@Override
	public void exitGroundPredicateApplication(@NotNull alchemyMLNGrammarParser.GroundPredicateApplicationContext ctx) {
		createGroundPredicateAppl(ctx);
	}
	
	@Override
	public void exitFunctionDef(@NotNull alchemyMLNGrammarParser.FunctionDefContext ctx) {
		createFunctionDefinition(ctx);
	}
	
	
	private MLNFunctionApplication createFunctionAppl(@NotNull alchemyMLNGrammarParser.FunctionApplicationContext ctx) {
		String function;
		if (ctx.function()!=null)
			function = ctx.function().CONST_ID().getText();
		else if (ctx.builtinFunctionSymbol()!=null)
			function = ctx.builtinFunctionSymbol().getText();
		else if (ctx.builtinPrefixFunctionSymbol()!=null)
			function = ctx.builtinPrefixFunctionSymbol().getText();
		else
			throw new IllegalArgumentException();
		return mlnModel.buildMLNFunctionApplicationFromNames(function, 
				createVarArguments(ctx.argument()));
	}
	
	private MLNFunctionApplication createFunctionAppl(@NotNull alchemyMLNGrammarParser.ArgumentContext ctx) {
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
	
	private MLNPredicateApplication createPredicateAppl(@NotNull alchemyMLNGrammarParser.PredicateApplicationContext ctx) {
		if ((ctx.builtinPredicateSymbol()!=null) && ctx.argument().size()==2 && ctx.argument(0).builtinPredicateSymbol()!=null) {
			System.out.println(ctx.getText());
			System.out.println(ctx.argument(1).getText());
			System.out.println();
		}
		String predicate;
		if (ctx.predicate()!=null)
			predicate = ctx.predicate().CONST_ID().getText();
		else if (ctx.builtinPredicateSymbol()!=null)
			predicate = ctx.builtinPredicateSymbol().getText();
		else {
			throw new IllegalArgumentException();
		}
		return mlnModel.buildMLNPredicateApplicationFromNames(predicate, 
				createVarArguments(ctx.argument()));
	}
	
	private MLNPredicateApplication createPredicateAppl(@NotNull alchemyMLNGrammarParser.ArgumentContext ctx) {
		String predicate;
		if (ctx.predicate()!=null)
			predicate = ctx.predicate().CONST_ID().getText();
		else if (ctx.builtinPredicateSymbol()!=null)
			predicate = ctx.builtinPredicateSymbol().getText();
		else {
			throw new IllegalArgumentException();
		}
		return mlnModel.buildMLNPredicateApplicationFromNames(predicate, 
				createVarArguments(ctx.argument()));
	}
	
	private MLNFunctionDefinition createFunctionDefinition(@NotNull alchemyMLNGrammarParser.FunctionDefContext ctx) {
		return mlnModel.buildMLNFunctionDefinitionFromNames(ctx.groundFunctionApplication().function().CONST_ID().getText(), 
				createReturnValue(ctx.returnValue()), createGroundArguments(ctx.groundFunctionApplication().groundArgument()));
	}
	
	private MLNGroundAtom createGroundPredicateAppl(@NotNull alchemyMLNGrammarParser.GroundPredicateApplicationContext ctx) {
		if (ctx.predicate()!=null)
			return mlnModel.buildMLNGroundAtomFromNames(ctx.predicate().CONST_ID().getText(), 
					createGroundArguments(ctx.groundArgument()), ctx.EXCL()!=null);
		else if (ctx.builtinPredicateSymbol()!=null)
			return mlnModel.buildMLNGroundAtomFromNames(ctx.builtinPredicateSymbol().getText(), 
					createGroundArguments(ctx.groundArgument()), ctx.EXCL()!=null);
		else
			throw new IllegalArgumentException();
	}
	
	private MLNGroundAtom createGroundPredicateAppl(@NotNull alchemyMLNGrammarParser.GroundArgumentContext ctx) {
		return mlnModel.buildMLNGroundAtomFromNames(ctx.predicate().CONST_ID().getText(), 
				createGroundArguments(ctx.groundArgument()), false);
	}
	
	private MLNGroundAtom createGroundFunctionAppl(@NotNull alchemyMLNGrammarParser.GroundArgumentContext ctx) {
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
	
	private String getConstantName(ConstantContext ctx) {
		if (ctx.CONST_ID()!=null) {
			return ctx.CONST_ID().getText();
		} else {
			return ctx.STRING().getText();
		}
	}
	
	@Override
	public void exitFormula(@NotNull alchemyMLNGrammarParser.FormulaContext ctx) {
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
	public void exitProbabilityStatement(@NotNull alchemyMLNGrammarParser.ProbabilityStatementContext ctx) {
		String probabilityStr = (ctx.probability()!=null)?(ctx.probability().FLOAT()!=null)?ctx.probability().FLOAT().getText()
				:(ctx.probability().INT()!=null)?ctx.probability().INT().getText():null:null;
		mlnModel.buildMLNProbabilityStatement(createGroundFormula(ctx.groundFormula()), probabilityStr!=null?Double.parseDouble(probabilityStr):null);
	}
	
	private MLNQuantification createQuantification(alchemyMLNGrammarParser.PlainFormulaContext ctx) {
		return mlnModel.buildMLNQuantificationFromNames(getQuantifierName(ctx.quantifier()), ctx.quantifier().E_QUANT()!=null,
				ctx.quantifier().U_QUANT()!=null,
				processPlainFormula(ctx.plainFormula(0)),
				ANTLRUtilityMethods.buildTextList(ctx.variableList().variable()), 
				getQuantifierRelation(ctx.quantifier()),
				getQuantifierNumber(ctx.quantifier()));
	}
	
	private MLNOperatorApplication createOperatorApplication(alchemyMLNGrammarParser.PlainFormulaContext ctx) {
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
		} else if (ctx.and() != null) {
			operatorApplication = mlnModel.buildMLNOperatorApplicationFromNames(MLNModel.AND_SYMBOL,
					processPlainFormulas(ctx.plainFormula()));
		} else if (ctx.or() != null) {
			operatorApplication = mlnModel.buildMLNOperatorApplicationFromNames(MLNModel.OR_SYMBOL,
					processPlainFormulas(ctx.plainFormula()));
		} else if (ctx.implies() != null) {
			operatorApplication = mlnModel.buildMLNOperatorApplicationFromNames(MLNModel.IMPLIES_SYMBOL,
					processPlainFormulas(ctx.plainFormula()));
		} else if (ctx.iff() != null) {
			operatorApplication = mlnModel.buildMLNOperatorApplicationFromNames(MLNModel.IFF_SYMBOL,
					processPlainFormulas(ctx.plainFormula()));
		} else if (ctx.EQ() != null) {
			operatorApplication = mlnModel.buildMLNOperatorApplicationFromNames(MLNModel.EQ_SYMBOL, 
					processPlainFormulas(ctx.plainFormula()));
		}
		return operatorApplication;
	}
	
	private MLNPlainFormula processPlainFormula(alchemyMLNGrammarParser.PlainFormulaContext ctx) {
		MLNPlainFormula plainFormula;
		if (ctx.functionApplication() != null) {
			plainFormula = mlnModel.buildMLNPlainFormula(
					createFunctionAppl(ctx.functionApplication()));
		} else if (ctx.predicateApplication() != null) {
			plainFormula = mlnModel.buildMLNPlainFormula(
					createPredicateAppl(ctx.predicateApplication()));
		} else if (ctx.quantifier() != null) {
			plainFormula = mlnModel.buildMLNPlainFormula(createQuantification(ctx));
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
	
	private void getWeightValues(MLNWeight[] weights, 
			WeightsContext ctx) {
		if (ctx.probWeight() != null) {
			if ((ctx.probWeight().weight().INT()) != null) {
				weights[PROB_WEIGHT_INDEX] = 
						mlnModel.buildMLNWeight(Double.parseDouble(ctx.probWeight().weight().INT().getText()));
			} else if (ctx.probWeight().weight().FLOAT() != null) {
				weights[PROB_WEIGHT_INDEX] = 
						mlnModel.buildMLNWeight(Double.parseDouble(ctx.probWeight().weight().FLOAT().getText()));
			} else if (ctx.probWeight().weight().variable()!=null) {
				weights[PROB_WEIGHT_INDEX] = 
						mlnModel.buildMLNWeightFromNames(ctx.probWeight().weight().variable().VAR_ID().getText());
			} else {
				weights[PROB_WEIGHT_INDEX] = null;
			}
		}
		if (ctx.utilWeight() != null) {
			if ((ctx.utilWeight().weight().INT()) != null) {
				weights[UTIL_WEIGHT_INDEX] = 
						mlnModel.buildMLNWeight(Double.parseDouble(ctx.utilWeight().weight().INT().getText()));
			} else if (ctx.utilWeight().weight().FLOAT() != null) {
				weights[UTIL_WEIGHT_INDEX] = 
						mlnModel.buildMLNWeight(Double.parseDouble(ctx.utilWeight().weight().FLOAT().getText()));
			} else if (ctx.utilWeight().weight().variable()!=null) {
				weights[UTIL_WEIGHT_INDEX] = 
						mlnModel.buildMLNWeightFromNames(ctx.utilWeight().weight().variable().VAR_ID().getText());
			} else {
				weights[UTIL_WEIGHT_INDEX] = null;
			}
		}
	}
	
	private String getQuantifierName(QuantifierContext ctx) {
		String name = null;
		if (ctx.E_QUANT() != null) {
			name = MLNQuantification.E_QUANT_NAME;
		} else if (ctx.U_QUANT() != null) {
			name = MLNQuantification.U_QUANT_NAME;
		}
		return name;
	}
	
	private MLNRelation getQuantifierRelation(QuantifierContext ctx) {
		MLNRelation relation = null;
		if (ctx.E_QUANT() != null) {
			relation = MLNQuantification.E_QUANT_RELATION;
		} else if (ctx.U_QUANT() != null) {
			relation = MLNQuantification.U_QUANT_RELATION;
		}
		return relation;
	}
	
	private Integer getQuantifierNumber(QuantifierContext ctx) {
		Integer number  = null;
		if (ctx.E_QUANT() != null) {
			number = MLNQuantification.E_QUANT_NUMBER;
		} else if (ctx.U_QUANT() != null) {
			number = MLNQuantification.U_QUANT_NUMBER;
		}
		return number;
	}

	private List<MLNPlainFormula> processPlainFormulas(List<alchemyMLNGrammarParser.PlainFormulaContext> ctxts) {
		List<MLNPlainFormula> plainFormulas = new ArrayList<MLNPlainFormula>();
		for (alchemyMLNGrammarParser.PlainFormulaContext ctx : ctxts) {
			plainFormulas.add(processPlainFormula(ctx));
		}
		return plainFormulas;
	}
	
}
