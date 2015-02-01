// Generated from TuffyMLNGrammar.g4 by ANTLR 4.2
package com.rapidminer.operator.modelling.converters.tuffy.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TuffyMLNGrammarParser}.
 */
public interface TuffyMLNGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(@NotNull TuffyMLNGrammarParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(@NotNull TuffyMLNGrammarParser.ArgumentContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(@NotNull TuffyMLNGrammarParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(@NotNull TuffyMLNGrammarParser.ConstantContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#closedWorldPredicate}.
	 * @param ctx the parse tree
	 */
	void enterClosedWorldPredicate(@NotNull TuffyMLNGrammarParser.ClosedWorldPredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#closedWorldPredicate}.
	 * @param ctx the parse tree
	 */
	void exitClosedWorldPredicate(@NotNull TuffyMLNGrammarParser.ClosedWorldPredicateContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull TuffyMLNGrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull TuffyMLNGrammarParser.TypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#plainFormula}.
	 * @param ctx the parse tree
	 */
	void enterPlainFormula(@NotNull TuffyMLNGrammarParser.PlainFormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#plainFormula}.
	 * @param ctx the parse tree
	 */
	void exitPlainFormula(@NotNull TuffyMLNGrammarParser.PlainFormulaContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(@NotNull TuffyMLNGrammarParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(@NotNull TuffyMLNGrammarParser.NumberContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(@NotNull TuffyMLNGrammarParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(@NotNull TuffyMLNGrammarParser.PredicateContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(@NotNull TuffyMLNGrammarParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(@NotNull TuffyMLNGrammarParser.FunctionContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#groundFormula}.
	 * @param ctx the parse tree
	 */
	void enterGroundFormula(@NotNull TuffyMLNGrammarParser.GroundFormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#groundFormula}.
	 * @param ctx the parse tree
	 */
	void exitGroundFormula(@NotNull TuffyMLNGrammarParser.GroundFormulaContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#plainPredicate}.
	 * @param ctx the parse tree
	 */
	void enterPlainPredicate(@NotNull TuffyMLNGrammarParser.PlainPredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#plainPredicate}.
	 * @param ctx the parse tree
	 */
	void exitPlainPredicate(@NotNull TuffyMLNGrammarParser.PlainPredicateContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#infFile}.
	 * @param ctx the parse tree
	 */
	void enterInfFile(@NotNull TuffyMLNGrammarParser.InfFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#infFile}.
	 * @param ctx the parse tree
	 */
	void exitInfFile(@NotNull TuffyMLNGrammarParser.InfFileContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#groundFunctionApplication}.
	 * @param ctx the parse tree
	 */
	void enterGroundFunctionApplication(@NotNull TuffyMLNGrammarParser.GroundFunctionApplicationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#groundFunctionApplication}.
	 * @param ctx the parse tree
	 */
	void exitGroundFunctionApplication(@NotNull TuffyMLNGrammarParser.GroundFunctionApplicationContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#queryFile}.
	 * @param ctx the parse tree
	 */
	void enterQueryFile(@NotNull TuffyMLNGrammarParser.QueryFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#queryFile}.
	 * @param ctx the parse tree
	 */
	void exitQueryFile(@NotNull TuffyMLNGrammarParser.QueryFileContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#quantification}.
	 * @param ctx the parse tree
	 */
	void enterQuantification(@NotNull TuffyMLNGrammarParser.QuantificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#quantification}.
	 * @param ctx the parse tree
	 */
	void exitQuantification(@NotNull TuffyMLNGrammarParser.QuantificationContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#probability}.
	 * @param ctx the parse tree
	 */
	void enterProbability(@NotNull TuffyMLNGrammarParser.ProbabilityContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#probability}.
	 * @param ctx the parse tree
	 */
	void exitProbability(@NotNull TuffyMLNGrammarParser.ProbabilityContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#builtinFunctionSymbol}.
	 * @param ctx the parse tree
	 */
	void enterBuiltinFunctionSymbol(@NotNull TuffyMLNGrammarParser.BuiltinFunctionSymbolContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#builtinFunctionSymbol}.
	 * @param ctx the parse tree
	 */
	void exitBuiltinFunctionSymbol(@NotNull TuffyMLNGrammarParser.BuiltinFunctionSymbolContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#weight}.
	 * @param ctx the parse tree
	 */
	void enterWeight(@NotNull TuffyMLNGrammarParser.WeightContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#weight}.
	 * @param ctx the parse tree
	 */
	void exitWeight(@NotNull TuffyMLNGrammarParser.WeightContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#eq}.
	 * @param ctx the parse tree
	 */
	void enterEq(@NotNull TuffyMLNGrammarParser.EqContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#eq}.
	 * @param ctx the parse tree
	 */
	void exitEq(@NotNull TuffyMLNGrammarParser.EqContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#typeDecl}.
	 * @param ctx the parse tree
	 */
	void enterTypeDecl(@NotNull TuffyMLNGrammarParser.TypeDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#typeDecl}.
	 * @param ctx the parse tree
	 */
	void exitTypeDecl(@NotNull TuffyMLNGrammarParser.TypeDeclContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#weights}.
	 * @param ctx the parse tree
	 */
	void enterWeights(@NotNull TuffyMLNGrammarParser.WeightsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#weights}.
	 * @param ctx the parse tree
	 */
	void exitWeights(@NotNull TuffyMLNGrammarParser.WeightsContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#dbFile}.
	 * @param ctx the parse tree
	 */
	void enterDbFile(@NotNull TuffyMLNGrammarParser.DbFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#dbFile}.
	 * @param ctx the parse tree
	 */
	void exitDbFile(@NotNull TuffyMLNGrammarParser.DbFileContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#builtinPredicateSymbol}.
	 * @param ctx the parse tree
	 */
	void enterBuiltinPredicateSymbol(@NotNull TuffyMLNGrammarParser.BuiltinPredicateSymbolContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#builtinPredicateSymbol}.
	 * @param ctx the parse tree
	 */
	void exitBuiltinPredicateSymbol(@NotNull TuffyMLNGrammarParser.BuiltinPredicateSymbolContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#startNum}.
	 * @param ctx the parse tree
	 */
	void enterStartNum(@NotNull TuffyMLNGrammarParser.StartNumContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#startNum}.
	 * @param ctx the parse tree
	 */
	void exitStartNum(@NotNull TuffyMLNGrammarParser.StartNumContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#endNum}.
	 * @param ctx the parse tree
	 */
	void enterEndNum(@NotNull TuffyMLNGrammarParser.EndNumContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#endNum}.
	 * @param ctx the parse tree
	 */
	void exitEndNum(@NotNull TuffyMLNGrammarParser.EndNumContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(@NotNull TuffyMLNGrammarParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(@NotNull TuffyMLNGrammarParser.FunctionDeclContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#returnValue}.
	 * @param ctx the parse tree
	 */
	void enterReturnValue(@NotNull TuffyMLNGrammarParser.ReturnValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#returnValue}.
	 * @param ctx the parse tree
	 */
	void exitReturnValue(@NotNull TuffyMLNGrammarParser.ReturnValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#predicateApplication}.
	 * @param ctx the parse tree
	 */
	void enterPredicateApplication(@NotNull TuffyMLNGrammarParser.PredicateApplicationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#predicateApplication}.
	 * @param ctx the parse tree
	 */
	void exitPredicateApplication(@NotNull TuffyMLNGrammarParser.PredicateApplicationContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#constantList}.
	 * @param ctx the parse tree
	 */
	void enterConstantList(@NotNull TuffyMLNGrammarParser.ConstantListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#constantList}.
	 * @param ctx the parse tree
	 */
	void exitConstantList(@NotNull TuffyMLNGrammarParser.ConstantListContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#expVariable}.
	 * @param ctx the parse tree
	 */
	void enterExpVariable(@NotNull TuffyMLNGrammarParser.ExpVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#expVariable}.
	 * @param ctx the parse tree
	 */
	void exitExpVariable(@NotNull TuffyMLNGrammarParser.ExpVariableContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#plainNumList}.
	 * @param ctx the parse tree
	 */
	void enterPlainNumList(@NotNull TuffyMLNGrammarParser.PlainNumListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#plainNumList}.
	 * @param ctx the parse tree
	 */
	void exitPlainNumList(@NotNull TuffyMLNGrammarParser.PlainNumListContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#functionApplication}.
	 * @param ctx the parse tree
	 */
	void enterFunctionApplication(@NotNull TuffyMLNGrammarParser.FunctionApplicationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#functionApplication}.
	 * @param ctx the parse tree
	 */
	void exitFunctionApplication(@NotNull TuffyMLNGrammarParser.FunctionApplicationContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#typeList}.
	 * @param ctx the parse tree
	 */
	void enterTypeList(@NotNull TuffyMLNGrammarParser.TypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#typeList}.
	 * @param ctx the parse tree
	 */
	void exitTypeList(@NotNull TuffyMLNGrammarParser.TypeListContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#groundPredicateApplication}.
	 * @param ctx the parse tree
	 */
	void enterGroundPredicateApplication(@NotNull TuffyMLNGrammarParser.GroundPredicateApplicationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#groundPredicateApplication}.
	 * @param ctx the parse tree
	 */
	void exitGroundPredicateApplication(@NotNull TuffyMLNGrammarParser.GroundPredicateApplicationContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#predicateDecl}.
	 * @param ctx the parse tree
	 */
	void enterPredicateDecl(@NotNull TuffyMLNGrammarParser.PredicateDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#predicateDecl}.
	 * @param ctx the parse tree
	 */
	void exitPredicateDecl(@NotNull TuffyMLNGrammarParser.PredicateDeclContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#groundArgument}.
	 * @param ctx the parse tree
	 */
	void enterGroundArgument(@NotNull TuffyMLNGrammarParser.GroundArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#groundArgument}.
	 * @param ctx the parse tree
	 */
	void exitGroundArgument(@NotNull TuffyMLNGrammarParser.GroundArgumentContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#ruleFile}.
	 * @param ctx the parse tree
	 */
	void enterRuleFile(@NotNull TuffyMLNGrammarParser.RuleFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#ruleFile}.
	 * @param ctx the parse tree
	 */
	void exitRuleFile(@NotNull TuffyMLNGrammarParser.RuleFileContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#or}.
	 * @param ctx the parse tree
	 */
	void enterOr(@NotNull TuffyMLNGrammarParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#or}.
	 * @param ctx the parse tree
	 */
	void exitOr(@NotNull TuffyMLNGrammarParser.OrContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void enterQuantifier(@NotNull TuffyMLNGrammarParser.QuantifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void exitQuantifier(@NotNull TuffyMLNGrammarParser.QuantifierContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#cardinality}.
	 * @param ctx the parse tree
	 */
	void enterCardinality(@NotNull TuffyMLNGrammarParser.CardinalityContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#cardinality}.
	 * @param ctx the parse tree
	 */
	void exitCardinality(@NotNull TuffyMLNGrammarParser.CardinalityContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#exNumList}.
	 * @param ctx the parse tree
	 */
	void enterExNumList(@NotNull TuffyMLNGrammarParser.ExNumListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#exNumList}.
	 * @param ctx the parse tree
	 */
	void exitExNumList(@NotNull TuffyMLNGrammarParser.ExNumListContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#probabilityStatement}.
	 * @param ctx the parse tree
	 */
	void enterProbabilityStatement(@NotNull TuffyMLNGrammarParser.ProbabilityStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#probabilityStatement}.
	 * @param ctx the parse tree
	 */
	void exitProbabilityStatement(@NotNull TuffyMLNGrammarParser.ProbabilityStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#builtinPrefixFunctionSymbol}.
	 * @param ctx the parse tree
	 */
	void enterBuiltinPrefixFunctionSymbol(@NotNull TuffyMLNGrammarParser.BuiltinPrefixFunctionSymbolContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#builtinPrefixFunctionSymbol}.
	 * @param ctx the parse tree
	 */
	void exitBuiltinPrefixFunctionSymbol(@NotNull TuffyMLNGrammarParser.BuiltinPrefixFunctionSymbolContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDef(@NotNull TuffyMLNGrammarParser.FunctionDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDef(@NotNull TuffyMLNGrammarParser.FunctionDefContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(@NotNull TuffyMLNGrammarParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(@NotNull TuffyMLNGrammarParser.VariableContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#hardFormula}.
	 * @param ctx the parse tree
	 */
	void enterHardFormula(@NotNull TuffyMLNGrammarParser.HardFormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#hardFormula}.
	 * @param ctx the parse tree
	 */
	void exitHardFormula(@NotNull TuffyMLNGrammarParser.HardFormulaContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#variableList}.
	 * @param ctx the parse tree
	 */
	void enterVariableList(@NotNull TuffyMLNGrammarParser.VariableListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#variableList}.
	 * @param ctx the parse tree
	 */
	void exitVariableList(@NotNull TuffyMLNGrammarParser.VariableListContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterFormula(@NotNull TuffyMLNGrammarParser.FormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitFormula(@NotNull TuffyMLNGrammarParser.FormulaContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#exclType}.
	 * @param ctx the parse tree
	 */
	void enterExclType(@NotNull TuffyMLNGrammarParser.ExclTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#exclType}.
	 * @param ctx the parse tree
	 */
	void exitExclType(@NotNull TuffyMLNGrammarParser.ExclTypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#variableLabel}.
	 * @param ctx the parse tree
	 */
	void enterVariableLabel(@NotNull TuffyMLNGrammarParser.VariableLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#variableLabel}.
	 * @param ctx the parse tree
	 */
	void exitVariableLabel(@NotNull TuffyMLNGrammarParser.VariableLabelContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#numList}.
	 * @param ctx the parse tree
	 */
	void enterNumList(@NotNull TuffyMLNGrammarParser.NumListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#numList}.
	 * @param ctx the parse tree
	 */
	void exitNumList(@NotNull TuffyMLNGrammarParser.NumListContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuffyMLNGrammarParser#weightedFormula}.
	 * @param ctx the parse tree
	 */
	void enterWeightedFormula(@NotNull TuffyMLNGrammarParser.WeightedFormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuffyMLNGrammarParser#weightedFormula}.
	 * @param ctx the parse tree
	 */
	void exitWeightedFormula(@NotNull TuffyMLNGrammarParser.WeightedFormulaContext ctx);
}