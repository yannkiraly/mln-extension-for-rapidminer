// Generated from rockitMLNGrammar.g4 by ANTLR 4.2
package com.rapidminer.operator.modelling.converters.rockit.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link rockitMLNGrammarParser}.
 */
public interface rockitMLNGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(@NotNull rockitMLNGrammarParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(@NotNull rockitMLNGrammarParser.ArgumentContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(@NotNull rockitMLNGrammarParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(@NotNull rockitMLNGrammarParser.ConstantContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#closedWorldPredicate}.
	 * @param ctx the parse tree
	 */
	void enterClosedWorldPredicate(@NotNull rockitMLNGrammarParser.ClosedWorldPredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#closedWorldPredicate}.
	 * @param ctx the parse tree
	 */
	void exitClosedWorldPredicate(@NotNull rockitMLNGrammarParser.ClosedWorldPredicateContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull rockitMLNGrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull rockitMLNGrammarParser.TypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#plainFormula}.
	 * @param ctx the parse tree
	 */
	void enterPlainFormula(@NotNull rockitMLNGrammarParser.PlainFormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#plainFormula}.
	 * @param ctx the parse tree
	 */
	void exitPlainFormula(@NotNull rockitMLNGrammarParser.PlainFormulaContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(@NotNull rockitMLNGrammarParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(@NotNull rockitMLNGrammarParser.NumberContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(@NotNull rockitMLNGrammarParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(@NotNull rockitMLNGrammarParser.PredicateContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(@NotNull rockitMLNGrammarParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(@NotNull rockitMLNGrammarParser.FunctionContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#groundFormula}.
	 * @param ctx the parse tree
	 */
	void enterGroundFormula(@NotNull rockitMLNGrammarParser.GroundFormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#groundFormula}.
	 * @param ctx the parse tree
	 */
	void exitGroundFormula(@NotNull rockitMLNGrammarParser.GroundFormulaContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#plainPredicate}.
	 * @param ctx the parse tree
	 */
	void enterPlainPredicate(@NotNull rockitMLNGrammarParser.PlainPredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#plainPredicate}.
	 * @param ctx the parse tree
	 */
	void exitPlainPredicate(@NotNull rockitMLNGrammarParser.PlainPredicateContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#infFile}.
	 * @param ctx the parse tree
	 */
	void enterInfFile(@NotNull rockitMLNGrammarParser.InfFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#infFile}.
	 * @param ctx the parse tree
	 */
	void exitInfFile(@NotNull rockitMLNGrammarParser.InfFileContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#groundFunctionApplication}.
	 * @param ctx the parse tree
	 */
	void enterGroundFunctionApplication(@NotNull rockitMLNGrammarParser.GroundFunctionApplicationContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#groundFunctionApplication}.
	 * @param ctx the parse tree
	 */
	void exitGroundFunctionApplication(@NotNull rockitMLNGrammarParser.GroundFunctionApplicationContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#quantification}.
	 * @param ctx the parse tree
	 */
	void enterQuantification(@NotNull rockitMLNGrammarParser.QuantificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#quantification}.
	 * @param ctx the parse tree
	 */
	void exitQuantification(@NotNull rockitMLNGrammarParser.QuantificationContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#probability}.
	 * @param ctx the parse tree
	 */
	void enterProbability(@NotNull rockitMLNGrammarParser.ProbabilityContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#probability}.
	 * @param ctx the parse tree
	 */
	void exitProbability(@NotNull rockitMLNGrammarParser.ProbabilityContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#builtinFunctionSymbol}.
	 * @param ctx the parse tree
	 */
	void enterBuiltinFunctionSymbol(@NotNull rockitMLNGrammarParser.BuiltinFunctionSymbolContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#builtinFunctionSymbol}.
	 * @param ctx the parse tree
	 */
	void exitBuiltinFunctionSymbol(@NotNull rockitMLNGrammarParser.BuiltinFunctionSymbolContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#weight}.
	 * @param ctx the parse tree
	 */
	void enterWeight(@NotNull rockitMLNGrammarParser.WeightContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#weight}.
	 * @param ctx the parse tree
	 */
	void exitWeight(@NotNull rockitMLNGrammarParser.WeightContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#eq}.
	 * @param ctx the parse tree
	 */
	void enterEq(@NotNull rockitMLNGrammarParser.EqContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#eq}.
	 * @param ctx the parse tree
	 */
	void exitEq(@NotNull rockitMLNGrammarParser.EqContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#typeDecl}.
	 * @param ctx the parse tree
	 */
	void enterTypeDecl(@NotNull rockitMLNGrammarParser.TypeDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#typeDecl}.
	 * @param ctx the parse tree
	 */
	void exitTypeDecl(@NotNull rockitMLNGrammarParser.TypeDeclContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#weights}.
	 * @param ctx the parse tree
	 */
	void enterWeights(@NotNull rockitMLNGrammarParser.WeightsContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#weights}.
	 * @param ctx the parse tree
	 */
	void exitWeights(@NotNull rockitMLNGrammarParser.WeightsContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#dbFile}.
	 * @param ctx the parse tree
	 */
	void enterDbFile(@NotNull rockitMLNGrammarParser.DbFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#dbFile}.
	 * @param ctx the parse tree
	 */
	void exitDbFile(@NotNull rockitMLNGrammarParser.DbFileContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#builtinPredicateSymbol}.
	 * @param ctx the parse tree
	 */
	void enterBuiltinPredicateSymbol(@NotNull rockitMLNGrammarParser.BuiltinPredicateSymbolContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#builtinPredicateSymbol}.
	 * @param ctx the parse tree
	 */
	void exitBuiltinPredicateSymbol(@NotNull rockitMLNGrammarParser.BuiltinPredicateSymbolContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#startNum}.
	 * @param ctx the parse tree
	 */
	void enterStartNum(@NotNull rockitMLNGrammarParser.StartNumContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#startNum}.
	 * @param ctx the parse tree
	 */
	void exitStartNum(@NotNull rockitMLNGrammarParser.StartNumContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#endNum}.
	 * @param ctx the parse tree
	 */
	void enterEndNum(@NotNull rockitMLNGrammarParser.EndNumContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#endNum}.
	 * @param ctx the parse tree
	 */
	void exitEndNum(@NotNull rockitMLNGrammarParser.EndNumContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(@NotNull rockitMLNGrammarParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(@NotNull rockitMLNGrammarParser.FunctionDeclContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#returnValue}.
	 * @param ctx the parse tree
	 */
	void enterReturnValue(@NotNull rockitMLNGrammarParser.ReturnValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#returnValue}.
	 * @param ctx the parse tree
	 */
	void exitReturnValue(@NotNull rockitMLNGrammarParser.ReturnValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#doubleNL}.
	 * @param ctx the parse tree
	 */
	void enterDoubleNL(@NotNull rockitMLNGrammarParser.DoubleNLContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#doubleNL}.
	 * @param ctx the parse tree
	 */
	void exitDoubleNL(@NotNull rockitMLNGrammarParser.DoubleNLContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#predicateApplication}.
	 * @param ctx the parse tree
	 */
	void enterPredicateApplication(@NotNull rockitMLNGrammarParser.PredicateApplicationContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#predicateApplication}.
	 * @param ctx the parse tree
	 */
	void exitPredicateApplication(@NotNull rockitMLNGrammarParser.PredicateApplicationContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#constantList}.
	 * @param ctx the parse tree
	 */
	void enterConstantList(@NotNull rockitMLNGrammarParser.ConstantListContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#constantList}.
	 * @param ctx the parse tree
	 */
	void exitConstantList(@NotNull rockitMLNGrammarParser.ConstantListContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#expVariable}.
	 * @param ctx the parse tree
	 */
	void enterExpVariable(@NotNull rockitMLNGrammarParser.ExpVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#expVariable}.
	 * @param ctx the parse tree
	 */
	void exitExpVariable(@NotNull rockitMLNGrammarParser.ExpVariableContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#plainNumList}.
	 * @param ctx the parse tree
	 */
	void enterPlainNumList(@NotNull rockitMLNGrammarParser.PlainNumListContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#plainNumList}.
	 * @param ctx the parse tree
	 */
	void exitPlainNumList(@NotNull rockitMLNGrammarParser.PlainNumListContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#functionApplication}.
	 * @param ctx the parse tree
	 */
	void enterFunctionApplication(@NotNull rockitMLNGrammarParser.FunctionApplicationContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#functionApplication}.
	 * @param ctx the parse tree
	 */
	void exitFunctionApplication(@NotNull rockitMLNGrammarParser.FunctionApplicationContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#typeList}.
	 * @param ctx the parse tree
	 */
	void enterTypeList(@NotNull rockitMLNGrammarParser.TypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#typeList}.
	 * @param ctx the parse tree
	 */
	void exitTypeList(@NotNull rockitMLNGrammarParser.TypeListContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#groundPredicateApplication}.
	 * @param ctx the parse tree
	 */
	void enterGroundPredicateApplication(@NotNull rockitMLNGrammarParser.GroundPredicateApplicationContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#groundPredicateApplication}.
	 * @param ctx the parse tree
	 */
	void exitGroundPredicateApplication(@NotNull rockitMLNGrammarParser.GroundPredicateApplicationContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#predicateDecl}.
	 * @param ctx the parse tree
	 */
	void enterPredicateDecl(@NotNull rockitMLNGrammarParser.PredicateDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#predicateDecl}.
	 * @param ctx the parse tree
	 */
	void exitPredicateDecl(@NotNull rockitMLNGrammarParser.PredicateDeclContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#groundArgument}.
	 * @param ctx the parse tree
	 */
	void enterGroundArgument(@NotNull rockitMLNGrammarParser.GroundArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#groundArgument}.
	 * @param ctx the parse tree
	 */
	void exitGroundArgument(@NotNull rockitMLNGrammarParser.GroundArgumentContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#ruleFile}.
	 * @param ctx the parse tree
	 */
	void enterRuleFile(@NotNull rockitMLNGrammarParser.RuleFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#ruleFile}.
	 * @param ctx the parse tree
	 */
	void exitRuleFile(@NotNull rockitMLNGrammarParser.RuleFileContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#or}.
	 * @param ctx the parse tree
	 */
	void enterOr(@NotNull rockitMLNGrammarParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#or}.
	 * @param ctx the parse tree
	 */
	void exitOr(@NotNull rockitMLNGrammarParser.OrContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#cardinality}.
	 * @param ctx the parse tree
	 */
	void enterCardinality(@NotNull rockitMLNGrammarParser.CardinalityContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#cardinality}.
	 * @param ctx the parse tree
	 */
	void exitCardinality(@NotNull rockitMLNGrammarParser.CardinalityContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#exNumList}.
	 * @param ctx the parse tree
	 */
	void enterExNumList(@NotNull rockitMLNGrammarParser.ExNumListContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#exNumList}.
	 * @param ctx the parse tree
	 */
	void exitExNumList(@NotNull rockitMLNGrammarParser.ExNumListContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#probabilityStatement}.
	 * @param ctx the parse tree
	 */
	void enterProbabilityStatement(@NotNull rockitMLNGrammarParser.ProbabilityStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#probabilityStatement}.
	 * @param ctx the parse tree
	 */
	void exitProbabilityStatement(@NotNull rockitMLNGrammarParser.ProbabilityStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#builtinPrefixFunctionSymbol}.
	 * @param ctx the parse tree
	 */
	void enterBuiltinPrefixFunctionSymbol(@NotNull rockitMLNGrammarParser.BuiltinPrefixFunctionSymbolContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#builtinPrefixFunctionSymbol}.
	 * @param ctx the parse tree
	 */
	void exitBuiltinPrefixFunctionSymbol(@NotNull rockitMLNGrammarParser.BuiltinPrefixFunctionSymbolContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDef(@NotNull rockitMLNGrammarParser.FunctionDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDef(@NotNull rockitMLNGrammarParser.FunctionDefContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(@NotNull rockitMLNGrammarParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(@NotNull rockitMLNGrammarParser.VariableContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#hardFormula}.
	 * @param ctx the parse tree
	 */
	void enterHardFormula(@NotNull rockitMLNGrammarParser.HardFormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#hardFormula}.
	 * @param ctx the parse tree
	 */
	void exitHardFormula(@NotNull rockitMLNGrammarParser.HardFormulaContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#variableList}.
	 * @param ctx the parse tree
	 */
	void enterVariableList(@NotNull rockitMLNGrammarParser.VariableListContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#variableList}.
	 * @param ctx the parse tree
	 */
	void exitVariableList(@NotNull rockitMLNGrammarParser.VariableListContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterFormula(@NotNull rockitMLNGrammarParser.FormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitFormula(@NotNull rockitMLNGrammarParser.FormulaContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#exclType}.
	 * @param ctx the parse tree
	 */
	void enterExclType(@NotNull rockitMLNGrammarParser.ExclTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#exclType}.
	 * @param ctx the parse tree
	 */
	void exitExclType(@NotNull rockitMLNGrammarParser.ExclTypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#variableLabel}.
	 * @param ctx the parse tree
	 */
	void enterVariableLabel(@NotNull rockitMLNGrammarParser.VariableLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#variableLabel}.
	 * @param ctx the parse tree
	 */
	void exitVariableLabel(@NotNull rockitMLNGrammarParser.VariableLabelContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#numList}.
	 * @param ctx the parse tree
	 */
	void enterNumList(@NotNull rockitMLNGrammarParser.NumListContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#numList}.
	 * @param ctx the parse tree
	 */
	void exitNumList(@NotNull rockitMLNGrammarParser.NumListContext ctx);

	/**
	 * Enter a parse tree produced by {@link rockitMLNGrammarParser#weightedFormula}.
	 * @param ctx the parse tree
	 */
	void enterWeightedFormula(@NotNull rockitMLNGrammarParser.WeightedFormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link rockitMLNGrammarParser#weightedFormula}.
	 * @param ctx the parse tree
	 */
	void exitWeightedFormula(@NotNull rockitMLNGrammarParser.WeightedFormulaContext ctx);
}