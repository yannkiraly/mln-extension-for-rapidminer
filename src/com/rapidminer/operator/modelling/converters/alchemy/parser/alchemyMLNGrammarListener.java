// Generated from alchemyMLNGrammar.g4 by ANTLR 4.2
package com.rapidminer.operator.modelling.converters.alchemy.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link alchemyMLNGrammarParser}.
 */
public interface alchemyMLNGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#endInt}.
	 * @param ctx the parse tree
	 */
	void enterEndInt(@NotNull alchemyMLNGrammarParser.EndIntContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#endInt}.
	 * @param ctx the parse tree
	 */
	void exitEndInt(@NotNull alchemyMLNGrammarParser.EndIntContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(@NotNull alchemyMLNGrammarParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(@NotNull alchemyMLNGrammarParser.ArgumentContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(@NotNull alchemyMLNGrammarParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(@NotNull alchemyMLNGrammarParser.ConstantContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#intList}.
	 * @param ctx the parse tree
	 */
	void enterIntList(@NotNull alchemyMLNGrammarParser.IntListContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#intList}.
	 * @param ctx the parse tree
	 */
	void exitIntList(@NotNull alchemyMLNGrammarParser.IntListContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull alchemyMLNGrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull alchemyMLNGrammarParser.TypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#plainFormula}.
	 * @param ctx the parse tree
	 */
	void enterPlainFormula(@NotNull alchemyMLNGrammarParser.PlainFormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#plainFormula}.
	 * @param ctx the parse tree
	 */
	void exitPlainFormula(@NotNull alchemyMLNGrammarParser.PlainFormulaContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(@NotNull alchemyMLNGrammarParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(@NotNull alchemyMLNGrammarParser.NumberContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(@NotNull alchemyMLNGrammarParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(@NotNull alchemyMLNGrammarParser.PredicateContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#exIntList}.
	 * @param ctx the parse tree
	 */
	void enterExIntList(@NotNull alchemyMLNGrammarParser.ExIntListContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#exIntList}.
	 * @param ctx the parse tree
	 */
	void exitExIntList(@NotNull alchemyMLNGrammarParser.ExIntListContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(@NotNull alchemyMLNGrammarParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(@NotNull alchemyMLNGrammarParser.FunctionContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#groundFormula}.
	 * @param ctx the parse tree
	 */
	void enterGroundFormula(@NotNull alchemyMLNGrammarParser.GroundFormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#groundFormula}.
	 * @param ctx the parse tree
	 */
	void exitGroundFormula(@NotNull alchemyMLNGrammarParser.GroundFormulaContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#infFile}.
	 * @param ctx the parse tree
	 */
	void enterInfFile(@NotNull alchemyMLNGrammarParser.InfFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#infFile}.
	 * @param ctx the parse tree
	 */
	void exitInfFile(@NotNull alchemyMLNGrammarParser.InfFileContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#groundFunctionApplication}.
	 * @param ctx the parse tree
	 */
	void enterGroundFunctionApplication(@NotNull alchemyMLNGrammarParser.GroundFunctionApplicationContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#groundFunctionApplication}.
	 * @param ctx the parse tree
	 */
	void exitGroundFunctionApplication(@NotNull alchemyMLNGrammarParser.GroundFunctionApplicationContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#probability}.
	 * @param ctx the parse tree
	 */
	void enterProbability(@NotNull alchemyMLNGrammarParser.ProbabilityContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#probability}.
	 * @param ctx the parse tree
	 */
	void exitProbability(@NotNull alchemyMLNGrammarParser.ProbabilityContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#builtinFunctionSymbol}.
	 * @param ctx the parse tree
	 */
	void enterBuiltinFunctionSymbol(@NotNull alchemyMLNGrammarParser.BuiltinFunctionSymbolContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#builtinFunctionSymbol}.
	 * @param ctx the parse tree
	 */
	void exitBuiltinFunctionSymbol(@NotNull alchemyMLNGrammarParser.BuiltinFunctionSymbolContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#weight}.
	 * @param ctx the parse tree
	 */
	void enterWeight(@NotNull alchemyMLNGrammarParser.WeightContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#weight}.
	 * @param ctx the parse tree
	 */
	void exitWeight(@NotNull alchemyMLNGrammarParser.WeightContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#eq}.
	 * @param ctx the parse tree
	 */
	void enterEq(@NotNull alchemyMLNGrammarParser.EqContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#eq}.
	 * @param ctx the parse tree
	 */
	void exitEq(@NotNull alchemyMLNGrammarParser.EqContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#typeDecl}.
	 * @param ctx the parse tree
	 */
	void enterTypeDecl(@NotNull alchemyMLNGrammarParser.TypeDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#typeDecl}.
	 * @param ctx the parse tree
	 */
	void exitTypeDecl(@NotNull alchemyMLNGrammarParser.TypeDeclContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#weights}.
	 * @param ctx the parse tree
	 */
	void enterWeights(@NotNull alchemyMLNGrammarParser.WeightsContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#weights}.
	 * @param ctx the parse tree
	 */
	void exitWeights(@NotNull alchemyMLNGrammarParser.WeightsContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#dbFile}.
	 * @param ctx the parse tree
	 */
	void enterDbFile(@NotNull alchemyMLNGrammarParser.DbFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#dbFile}.
	 * @param ctx the parse tree
	 */
	void exitDbFile(@NotNull alchemyMLNGrammarParser.DbFileContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#builtinPredicateSymbol}.
	 * @param ctx the parse tree
	 */
	void enterBuiltinPredicateSymbol(@NotNull alchemyMLNGrammarParser.BuiltinPredicateSymbolContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#builtinPredicateSymbol}.
	 * @param ctx the parse tree
	 */
	void exitBuiltinPredicateSymbol(@NotNull alchemyMLNGrammarParser.BuiltinPredicateSymbolContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#probWeight}.
	 * @param ctx the parse tree
	 */
	void enterProbWeight(@NotNull alchemyMLNGrammarParser.ProbWeightContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#probWeight}.
	 * @param ctx the parse tree
	 */
	void exitProbWeight(@NotNull alchemyMLNGrammarParser.ProbWeightContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#plainIntList}.
	 * @param ctx the parse tree
	 */
	void enterPlainIntList(@NotNull alchemyMLNGrammarParser.PlainIntListContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#plainIntList}.
	 * @param ctx the parse tree
	 */
	void exitPlainIntList(@NotNull alchemyMLNGrammarParser.PlainIntListContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(@NotNull alchemyMLNGrammarParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(@NotNull alchemyMLNGrammarParser.FunctionDeclContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#returnValue}.
	 * @param ctx the parse tree
	 */
	void enterReturnValue(@NotNull alchemyMLNGrammarParser.ReturnValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#returnValue}.
	 * @param ctx the parse tree
	 */
	void exitReturnValue(@NotNull alchemyMLNGrammarParser.ReturnValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#doubleNL}.
	 * @param ctx the parse tree
	 */
	void enterDoubleNL(@NotNull alchemyMLNGrammarParser.DoubleNLContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#doubleNL}.
	 * @param ctx the parse tree
	 */
	void exitDoubleNL(@NotNull alchemyMLNGrammarParser.DoubleNLContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#predicateApplication}.
	 * @param ctx the parse tree
	 */
	void enterPredicateApplication(@NotNull alchemyMLNGrammarParser.PredicateApplicationContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#predicateApplication}.
	 * @param ctx the parse tree
	 */
	void exitPredicateApplication(@NotNull alchemyMLNGrammarParser.PredicateApplicationContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#constantList}.
	 * @param ctx the parse tree
	 */
	void enterConstantList(@NotNull alchemyMLNGrammarParser.ConstantListContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#constantList}.
	 * @param ctx the parse tree
	 */
	void exitConstantList(@NotNull alchemyMLNGrammarParser.ConstantListContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#expVariable}.
	 * @param ctx the parse tree
	 */
	void enterExpVariable(@NotNull alchemyMLNGrammarParser.ExpVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#expVariable}.
	 * @param ctx the parse tree
	 */
	void exitExpVariable(@NotNull alchemyMLNGrammarParser.ExpVariableContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#startInt}.
	 * @param ctx the parse tree
	 */
	void enterStartInt(@NotNull alchemyMLNGrammarParser.StartIntContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#startInt}.
	 * @param ctx the parse tree
	 */
	void exitStartInt(@NotNull alchemyMLNGrammarParser.StartIntContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#functionApplication}.
	 * @param ctx the parse tree
	 */
	void enterFunctionApplication(@NotNull alchemyMLNGrammarParser.FunctionApplicationContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#functionApplication}.
	 * @param ctx the parse tree
	 */
	void exitFunctionApplication(@NotNull alchemyMLNGrammarParser.FunctionApplicationContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#typeList}.
	 * @param ctx the parse tree
	 */
	void enterTypeList(@NotNull alchemyMLNGrammarParser.TypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#typeList}.
	 * @param ctx the parse tree
	 */
	void exitTypeList(@NotNull alchemyMLNGrammarParser.TypeListContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#and}.
	 * @param ctx the parse tree
	 */
	void enterAnd(@NotNull alchemyMLNGrammarParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#and}.
	 * @param ctx the parse tree
	 */
	void exitAnd(@NotNull alchemyMLNGrammarParser.AndContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#groundPredicateApplication}.
	 * @param ctx the parse tree
	 */
	void enterGroundPredicateApplication(@NotNull alchemyMLNGrammarParser.GroundPredicateApplicationContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#groundPredicateApplication}.
	 * @param ctx the parse tree
	 */
	void exitGroundPredicateApplication(@NotNull alchemyMLNGrammarParser.GroundPredicateApplicationContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#predicateDecl}.
	 * @param ctx the parse tree
	 */
	void enterPredicateDecl(@NotNull alchemyMLNGrammarParser.PredicateDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#predicateDecl}.
	 * @param ctx the parse tree
	 */
	void exitPredicateDecl(@NotNull alchemyMLNGrammarParser.PredicateDeclContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#utilWeight}.
	 * @param ctx the parse tree
	 */
	void enterUtilWeight(@NotNull alchemyMLNGrammarParser.UtilWeightContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#utilWeight}.
	 * @param ctx the parse tree
	 */
	void exitUtilWeight(@NotNull alchemyMLNGrammarParser.UtilWeightContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#groundArgument}.
	 * @param ctx the parse tree
	 */
	void enterGroundArgument(@NotNull alchemyMLNGrammarParser.GroundArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#groundArgument}.
	 * @param ctx the parse tree
	 */
	void exitGroundArgument(@NotNull alchemyMLNGrammarParser.GroundArgumentContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#ruleFile}.
	 * @param ctx the parse tree
	 */
	void enterRuleFile(@NotNull alchemyMLNGrammarParser.RuleFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#ruleFile}.
	 * @param ctx the parse tree
	 */
	void exitRuleFile(@NotNull alchemyMLNGrammarParser.RuleFileContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#or}.
	 * @param ctx the parse tree
	 */
	void enterOr(@NotNull alchemyMLNGrammarParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#or}.
	 * @param ctx the parse tree
	 */
	void exitOr(@NotNull alchemyMLNGrammarParser.OrContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#iff}.
	 * @param ctx the parse tree
	 */
	void enterIff(@NotNull alchemyMLNGrammarParser.IffContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#iff}.
	 * @param ctx the parse tree
	 */
	void exitIff(@NotNull alchemyMLNGrammarParser.IffContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void enterQuantifier(@NotNull alchemyMLNGrammarParser.QuantifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void exitQuantifier(@NotNull alchemyMLNGrammarParser.QuantifierContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#probabilityStatement}.
	 * @param ctx the parse tree
	 */
	void enterProbabilityStatement(@NotNull alchemyMLNGrammarParser.ProbabilityStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#probabilityStatement}.
	 * @param ctx the parse tree
	 */
	void exitProbabilityStatement(@NotNull alchemyMLNGrammarParser.ProbabilityStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#builtinPrefixFunctionSymbol}.
	 * @param ctx the parse tree
	 */
	void enterBuiltinPrefixFunctionSymbol(@NotNull alchemyMLNGrammarParser.BuiltinPrefixFunctionSymbolContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#builtinPrefixFunctionSymbol}.
	 * @param ctx the parse tree
	 */
	void exitBuiltinPrefixFunctionSymbol(@NotNull alchemyMLNGrammarParser.BuiltinPrefixFunctionSymbolContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDef(@NotNull alchemyMLNGrammarParser.FunctionDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDef(@NotNull alchemyMLNGrammarParser.FunctionDefContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(@NotNull alchemyMLNGrammarParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(@NotNull alchemyMLNGrammarParser.VariableContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#hardFormula}.
	 * @param ctx the parse tree
	 */
	void enterHardFormula(@NotNull alchemyMLNGrammarParser.HardFormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#hardFormula}.
	 * @param ctx the parse tree
	 */
	void exitHardFormula(@NotNull alchemyMLNGrammarParser.HardFormulaContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#variableList}.
	 * @param ctx the parse tree
	 */
	void enterVariableList(@NotNull alchemyMLNGrammarParser.VariableListContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#variableList}.
	 * @param ctx the parse tree
	 */
	void exitVariableList(@NotNull alchemyMLNGrammarParser.VariableListContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterFormula(@NotNull alchemyMLNGrammarParser.FormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitFormula(@NotNull alchemyMLNGrammarParser.FormulaContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#exclType}.
	 * @param ctx the parse tree
	 */
	void enterExclType(@NotNull alchemyMLNGrammarParser.ExclTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#exclType}.
	 * @param ctx the parse tree
	 */
	void exitExclType(@NotNull alchemyMLNGrammarParser.ExclTypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#implies}.
	 * @param ctx the parse tree
	 */
	void enterImplies(@NotNull alchemyMLNGrammarParser.ImpliesContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#implies}.
	 * @param ctx the parse tree
	 */
	void exitImplies(@NotNull alchemyMLNGrammarParser.ImpliesContext ctx);

	/**
	 * Enter a parse tree produced by {@link alchemyMLNGrammarParser#weightedFormula}.
	 * @param ctx the parse tree
	 */
	void enterWeightedFormula(@NotNull alchemyMLNGrammarParser.WeightedFormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link alchemyMLNGrammarParser#weightedFormula}.
	 * @param ctx the parse tree
	 */
	void exitWeightedFormula(@NotNull alchemyMLNGrammarParser.WeightedFormulaContext ctx);
}