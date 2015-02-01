// Generated from ExampleSetMLNGrammar.g4 by ANTLR 4.2
package com.rapidminer.operator.modelling.converters.exampleset.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExampleSetMLNGrammarParser}.
 */
public interface ExampleSetMLNGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(@NotNull ExampleSetMLNGrammarParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(@NotNull ExampleSetMLNGrammarParser.ArgumentContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(@NotNull ExampleSetMLNGrammarParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(@NotNull ExampleSetMLNGrammarParser.ConstantContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#startNumber}.
	 * @param ctx the parse tree
	 */
	void enterStartNumber(@NotNull ExampleSetMLNGrammarParser.StartNumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#startNumber}.
	 * @param ctx the parse tree
	 */
	void exitStartNumber(@NotNull ExampleSetMLNGrammarParser.StartNumberContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#closedWorldPredicate}.
	 * @param ctx the parse tree
	 */
	void enterClosedWorldPredicate(@NotNull ExampleSetMLNGrammarParser.ClosedWorldPredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#closedWorldPredicate}.
	 * @param ctx the parse tree
	 */
	void exitClosedWorldPredicate(@NotNull ExampleSetMLNGrammarParser.ClosedWorldPredicateContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull ExampleSetMLNGrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull ExampleSetMLNGrammarParser.TypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#plainFormula}.
	 * @param ctx the parse tree
	 */
	void enterPlainFormula(@NotNull ExampleSetMLNGrammarParser.PlainFormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#plainFormula}.
	 * @param ctx the parse tree
	 */
	void exitPlainFormula(@NotNull ExampleSetMLNGrammarParser.PlainFormulaContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(@NotNull ExampleSetMLNGrammarParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(@NotNull ExampleSetMLNGrammarParser.NumberContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(@NotNull ExampleSetMLNGrammarParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(@NotNull ExampleSetMLNGrammarParser.PredicateContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(@NotNull ExampleSetMLNGrammarParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(@NotNull ExampleSetMLNGrammarParser.FunctionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#groundFormula}.
	 * @param ctx the parse tree
	 */
	void enterGroundFormula(@NotNull ExampleSetMLNGrammarParser.GroundFormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#groundFormula}.
	 * @param ctx the parse tree
	 */
	void exitGroundFormula(@NotNull ExampleSetMLNGrammarParser.GroundFormulaContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#plainPredicate}.
	 * @param ctx the parse tree
	 */
	void enterPlainPredicate(@NotNull ExampleSetMLNGrammarParser.PlainPredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#plainPredicate}.
	 * @param ctx the parse tree
	 */
	void exitPlainPredicate(@NotNull ExampleSetMLNGrammarParser.PlainPredicateContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#infFile}.
	 * @param ctx the parse tree
	 */
	void enterInfFile(@NotNull ExampleSetMLNGrammarParser.InfFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#infFile}.
	 * @param ctx the parse tree
	 */
	void exitInfFile(@NotNull ExampleSetMLNGrammarParser.InfFileContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#groundFunctionApplication}.
	 * @param ctx the parse tree
	 */
	void enterGroundFunctionApplication(@NotNull ExampleSetMLNGrammarParser.GroundFunctionApplicationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#groundFunctionApplication}.
	 * @param ctx the parse tree
	 */
	void exitGroundFunctionApplication(@NotNull ExampleSetMLNGrammarParser.GroundFunctionApplicationContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#queryFile}.
	 * @param ctx the parse tree
	 */
	void enterQueryFile(@NotNull ExampleSetMLNGrammarParser.QueryFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#queryFile}.
	 * @param ctx the parse tree
	 */
	void exitQueryFile(@NotNull ExampleSetMLNGrammarParser.QueryFileContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#quantification}.
	 * @param ctx the parse tree
	 */
	void enterQuantification(@NotNull ExampleSetMLNGrammarParser.QuantificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#quantification}.
	 * @param ctx the parse tree
	 */
	void exitQuantification(@NotNull ExampleSetMLNGrammarParser.QuantificationContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#probability}.
	 * @param ctx the parse tree
	 */
	void enterProbability(@NotNull ExampleSetMLNGrammarParser.ProbabilityContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#probability}.
	 * @param ctx the parse tree
	 */
	void exitProbability(@NotNull ExampleSetMLNGrammarParser.ProbabilityContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#builtinFunctionSymbol}.
	 * @param ctx the parse tree
	 */
	void enterBuiltinFunctionSymbol(@NotNull ExampleSetMLNGrammarParser.BuiltinFunctionSymbolContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#builtinFunctionSymbol}.
	 * @param ctx the parse tree
	 */
	void exitBuiltinFunctionSymbol(@NotNull ExampleSetMLNGrammarParser.BuiltinFunctionSymbolContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#weight}.
	 * @param ctx the parse tree
	 */
	void enterWeight(@NotNull ExampleSetMLNGrammarParser.WeightContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#weight}.
	 * @param ctx the parse tree
	 */
	void exitWeight(@NotNull ExampleSetMLNGrammarParser.WeightContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#eq}.
	 * @param ctx the parse tree
	 */
	void enterEq(@NotNull ExampleSetMLNGrammarParser.EqContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#eq}.
	 * @param ctx the parse tree
	 */
	void exitEq(@NotNull ExampleSetMLNGrammarParser.EqContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#typeDecl}.
	 * @param ctx the parse tree
	 */
	void enterTypeDecl(@NotNull ExampleSetMLNGrammarParser.TypeDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#typeDecl}.
	 * @param ctx the parse tree
	 */
	void exitTypeDecl(@NotNull ExampleSetMLNGrammarParser.TypeDeclContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#weights}.
	 * @param ctx the parse tree
	 */
	void enterWeights(@NotNull ExampleSetMLNGrammarParser.WeightsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#weights}.
	 * @param ctx the parse tree
	 */
	void exitWeights(@NotNull ExampleSetMLNGrammarParser.WeightsContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#dbFile}.
	 * @param ctx the parse tree
	 */
	void enterDbFile(@NotNull ExampleSetMLNGrammarParser.DbFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#dbFile}.
	 * @param ctx the parse tree
	 */
	void exitDbFile(@NotNull ExampleSetMLNGrammarParser.DbFileContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#builtinPredicateSymbol}.
	 * @param ctx the parse tree
	 */
	void enterBuiltinPredicateSymbol(@NotNull ExampleSetMLNGrammarParser.BuiltinPredicateSymbolContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#builtinPredicateSymbol}.
	 * @param ctx the parse tree
	 */
	void exitBuiltinPredicateSymbol(@NotNull ExampleSetMLNGrammarParser.BuiltinPredicateSymbolContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#probWeight}.
	 * @param ctx the parse tree
	 */
	void enterProbWeight(@NotNull ExampleSetMLNGrammarParser.ProbWeightContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#probWeight}.
	 * @param ctx the parse tree
	 */
	void exitProbWeight(@NotNull ExampleSetMLNGrammarParser.ProbWeightContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(@NotNull ExampleSetMLNGrammarParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(@NotNull ExampleSetMLNGrammarParser.FunctionDeclContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#returnValue}.
	 * @param ctx the parse tree
	 */
	void enterReturnValue(@NotNull ExampleSetMLNGrammarParser.ReturnValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#returnValue}.
	 * @param ctx the parse tree
	 */
	void exitReturnValue(@NotNull ExampleSetMLNGrammarParser.ReturnValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#doubleNL}.
	 * @param ctx the parse tree
	 */
	void enterDoubleNL(@NotNull ExampleSetMLNGrammarParser.DoubleNLContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#doubleNL}.
	 * @param ctx the parse tree
	 */
	void exitDoubleNL(@NotNull ExampleSetMLNGrammarParser.DoubleNLContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#predicateApplication}.
	 * @param ctx the parse tree
	 */
	void enterPredicateApplication(@NotNull ExampleSetMLNGrammarParser.PredicateApplicationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#predicateApplication}.
	 * @param ctx the parse tree
	 */
	void exitPredicateApplication(@NotNull ExampleSetMLNGrammarParser.PredicateApplicationContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#constantList}.
	 * @param ctx the parse tree
	 */
	void enterConstantList(@NotNull ExampleSetMLNGrammarParser.ConstantListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#constantList}.
	 * @param ctx the parse tree
	 */
	void exitConstantList(@NotNull ExampleSetMLNGrammarParser.ConstantListContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#expVariable}.
	 * @param ctx the parse tree
	 */
	void enterExpVariable(@NotNull ExampleSetMLNGrammarParser.ExpVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#expVariable}.
	 * @param ctx the parse tree
	 */
	void exitExpVariable(@NotNull ExampleSetMLNGrammarParser.ExpVariableContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#plainNumList}.
	 * @param ctx the parse tree
	 */
	void enterPlainNumList(@NotNull ExampleSetMLNGrammarParser.PlainNumListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#plainNumList}.
	 * @param ctx the parse tree
	 */
	void exitPlainNumList(@NotNull ExampleSetMLNGrammarParser.PlainNumListContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#functionApplication}.
	 * @param ctx the parse tree
	 */
	void enterFunctionApplication(@NotNull ExampleSetMLNGrammarParser.FunctionApplicationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#functionApplication}.
	 * @param ctx the parse tree
	 */
	void exitFunctionApplication(@NotNull ExampleSetMLNGrammarParser.FunctionApplicationContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#typeList}.
	 * @param ctx the parse tree
	 */
	void enterTypeList(@NotNull ExampleSetMLNGrammarParser.TypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#typeList}.
	 * @param ctx the parse tree
	 */
	void exitTypeList(@NotNull ExampleSetMLNGrammarParser.TypeListContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#and}.
	 * @param ctx the parse tree
	 */
	void enterAnd(@NotNull ExampleSetMLNGrammarParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#and}.
	 * @param ctx the parse tree
	 */
	void exitAnd(@NotNull ExampleSetMLNGrammarParser.AndContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#groundPredicateApplication}.
	 * @param ctx the parse tree
	 */
	void enterGroundPredicateApplication(@NotNull ExampleSetMLNGrammarParser.GroundPredicateApplicationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#groundPredicateApplication}.
	 * @param ctx the parse tree
	 */
	void exitGroundPredicateApplication(@NotNull ExampleSetMLNGrammarParser.GroundPredicateApplicationContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#predicateDecl}.
	 * @param ctx the parse tree
	 */
	void enterPredicateDecl(@NotNull ExampleSetMLNGrammarParser.PredicateDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#predicateDecl}.
	 * @param ctx the parse tree
	 */
	void exitPredicateDecl(@NotNull ExampleSetMLNGrammarParser.PredicateDeclContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#utilWeight}.
	 * @param ctx the parse tree
	 */
	void enterUtilWeight(@NotNull ExampleSetMLNGrammarParser.UtilWeightContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#utilWeight}.
	 * @param ctx the parse tree
	 */
	void exitUtilWeight(@NotNull ExampleSetMLNGrammarParser.UtilWeightContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#groundArgument}.
	 * @param ctx the parse tree
	 */
	void enterGroundArgument(@NotNull ExampleSetMLNGrammarParser.GroundArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#groundArgument}.
	 * @param ctx the parse tree
	 */
	void exitGroundArgument(@NotNull ExampleSetMLNGrammarParser.GroundArgumentContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#ruleFile}.
	 * @param ctx the parse tree
	 */
	void enterRuleFile(@NotNull ExampleSetMLNGrammarParser.RuleFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#ruleFile}.
	 * @param ctx the parse tree
	 */
	void exitRuleFile(@NotNull ExampleSetMLNGrammarParser.RuleFileContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#or}.
	 * @param ctx the parse tree
	 */
	void enterOr(@NotNull ExampleSetMLNGrammarParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#or}.
	 * @param ctx the parse tree
	 */
	void exitOr(@NotNull ExampleSetMLNGrammarParser.OrContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#iff}.
	 * @param ctx the parse tree
	 */
	void enterIff(@NotNull ExampleSetMLNGrammarParser.IffContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#iff}.
	 * @param ctx the parse tree
	 */
	void exitIff(@NotNull ExampleSetMLNGrammarParser.IffContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#endNumber}.
	 * @param ctx the parse tree
	 */
	void enterEndNumber(@NotNull ExampleSetMLNGrammarParser.EndNumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#endNumber}.
	 * @param ctx the parse tree
	 */
	void exitEndNumber(@NotNull ExampleSetMLNGrammarParser.EndNumberContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void enterQuantifier(@NotNull ExampleSetMLNGrammarParser.QuantifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void exitQuantifier(@NotNull ExampleSetMLNGrammarParser.QuantifierContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#cardinality}.
	 * @param ctx the parse tree
	 */
	void enterCardinality(@NotNull ExampleSetMLNGrammarParser.CardinalityContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#cardinality}.
	 * @param ctx the parse tree
	 */
	void exitCardinality(@NotNull ExampleSetMLNGrammarParser.CardinalityContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#exNumList}.
	 * @param ctx the parse tree
	 */
	void enterExNumList(@NotNull ExampleSetMLNGrammarParser.ExNumListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#exNumList}.
	 * @param ctx the parse tree
	 */
	void exitExNumList(@NotNull ExampleSetMLNGrammarParser.ExNumListContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#probabilityStatement}.
	 * @param ctx the parse tree
	 */
	void enterProbabilityStatement(@NotNull ExampleSetMLNGrammarParser.ProbabilityStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#probabilityStatement}.
	 * @param ctx the parse tree
	 */
	void exitProbabilityStatement(@NotNull ExampleSetMLNGrammarParser.ProbabilityStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#builtinPrefixFunctionSymbol}.
	 * @param ctx the parse tree
	 */
	void enterBuiltinPrefixFunctionSymbol(@NotNull ExampleSetMLNGrammarParser.BuiltinPrefixFunctionSymbolContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#builtinPrefixFunctionSymbol}.
	 * @param ctx the parse tree
	 */
	void exitBuiltinPrefixFunctionSymbol(@NotNull ExampleSetMLNGrammarParser.BuiltinPrefixFunctionSymbolContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDef(@NotNull ExampleSetMLNGrammarParser.FunctionDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDef(@NotNull ExampleSetMLNGrammarParser.FunctionDefContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(@NotNull ExampleSetMLNGrammarParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(@NotNull ExampleSetMLNGrammarParser.VariableContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#hardFormula}.
	 * @param ctx the parse tree
	 */
	void enterHardFormula(@NotNull ExampleSetMLNGrammarParser.HardFormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#hardFormula}.
	 * @param ctx the parse tree
	 */
	void exitHardFormula(@NotNull ExampleSetMLNGrammarParser.HardFormulaContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#variableList}.
	 * @param ctx the parse tree
	 */
	void enterVariableList(@NotNull ExampleSetMLNGrammarParser.VariableListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#variableList}.
	 * @param ctx the parse tree
	 */
	void exitVariableList(@NotNull ExampleSetMLNGrammarParser.VariableListContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterFormula(@NotNull ExampleSetMLNGrammarParser.FormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitFormula(@NotNull ExampleSetMLNGrammarParser.FormulaContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#exclType}.
	 * @param ctx the parse tree
	 */
	void enterExclType(@NotNull ExampleSetMLNGrammarParser.ExclTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#exclType}.
	 * @param ctx the parse tree
	 */
	void exitExclType(@NotNull ExampleSetMLNGrammarParser.ExclTypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#numList}.
	 * @param ctx the parse tree
	 */
	void enterNumList(@NotNull ExampleSetMLNGrammarParser.NumListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#numList}.
	 * @param ctx the parse tree
	 */
	void exitNumList(@NotNull ExampleSetMLNGrammarParser.NumListContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#implies}.
	 * @param ctx the parse tree
	 */
	void enterImplies(@NotNull ExampleSetMLNGrammarParser.ImpliesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#implies}.
	 * @param ctx the parse tree
	 */
	void exitImplies(@NotNull ExampleSetMLNGrammarParser.ImpliesContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExampleSetMLNGrammarParser#weightedFormula}.
	 * @param ctx the parse tree
	 */
	void enterWeightedFormula(@NotNull ExampleSetMLNGrammarParser.WeightedFormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleSetMLNGrammarParser#weightedFormula}.
	 * @param ctx the parse tree
	 */
	void exitWeightedFormula(@NotNull ExampleSetMLNGrammarParser.WeightedFormulaContext ctx);
}