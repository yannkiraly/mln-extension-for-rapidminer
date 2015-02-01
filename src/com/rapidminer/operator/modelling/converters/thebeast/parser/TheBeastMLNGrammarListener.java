// Generated from TheBeastMLNGrammar.g4 by ANTLR 4.2
package com.rapidminer.operator.modelling.converters.thebeast.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TheBeastMLNGrammarParser}.
 */
public interface TheBeastMLNGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#formulaName}.
	 * @param ctx the parse tree
	 */
	void enterFormulaName(@NotNull TheBeastMLNGrammarParser.FormulaNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#formulaName}.
	 * @param ctx the parse tree
	 */
	void exitFormulaName(@NotNull TheBeastMLNGrammarParser.FormulaNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#predicateCategoryDefinition}.
	 * @param ctx the parse tree
	 */
	void enterPredicateCategoryDefinition(@NotNull TheBeastMLNGrammarParser.PredicateCategoryDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#predicateCategoryDefinition}.
	 * @param ctx the parse tree
	 */
	void exitPredicateCategoryDefinition(@NotNull TheBeastMLNGrammarParser.PredicateCategoryDefinitionContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(@NotNull TheBeastMLNGrammarParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(@NotNull TheBeastMLNGrammarParser.ConstantContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#predicateLabel}.
	 * @param ctx the parse tree
	 */
	void enterPredicateLabel(@NotNull TheBeastMLNGrammarParser.PredicateLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#predicateLabel}.
	 * @param ctx the parse tree
	 */
	void exitPredicateLabel(@NotNull TheBeastMLNGrammarParser.PredicateLabelContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#weightedFormulaUnsplit}.
	 * @param ctx the parse tree
	 */
	void enterWeightedFormulaUnsplit(@NotNull TheBeastMLNGrammarParser.WeightedFormulaUnsplitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#weightedFormulaUnsplit}.
	 * @param ctx the parse tree
	 */
	void exitWeightedFormulaUnsplit(@NotNull TheBeastMLNGrammarParser.WeightedFormulaUnsplitContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#builtinPredicate}.
	 * @param ctx the parse tree
	 */
	void enterBuiltinPredicate(@NotNull TheBeastMLNGrammarParser.BuiltinPredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#builtinPredicate}.
	 * @param ctx the parse tree
	 */
	void exitBuiltinPredicate(@NotNull TheBeastMLNGrammarParser.BuiltinPredicateContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#infixFunction}.
	 * @param ctx the parse tree
	 */
	void enterInfixFunction(@NotNull TheBeastMLNGrammarParser.InfixFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#infixFunction}.
	 * @param ctx the parse tree
	 */
	void exitInfixFunction(@NotNull TheBeastMLNGrammarParser.InfixFunctionContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#saveStatement}.
	 * @param ctx the parse tree
	 */
	void enterSaveStatement(@NotNull TheBeastMLNGrammarParser.SaveStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#saveStatement}.
	 * @param ctx the parse tree
	 */
	void exitSaveStatement(@NotNull TheBeastMLNGrammarParser.SaveStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull TheBeastMLNGrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull TheBeastMLNGrammarParser.TypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(@NotNull TheBeastMLNGrammarParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(@NotNull TheBeastMLNGrammarParser.PredicateContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#groundAtomDefinitionRow}.
	 * @param ctx the parse tree
	 */
	void enterGroundAtomDefinitionRow(@NotNull TheBeastMLNGrammarParser.GroundAtomDefinitionRowContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#groundAtomDefinitionRow}.
	 * @param ctx the parse tree
	 */
	void exitGroundAtomDefinitionRow(@NotNull TheBeastMLNGrammarParser.GroundAtomDefinitionRowContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#path}.
	 * @param ctx the parse tree
	 */
	void enterPath(@NotNull TheBeastMLNGrammarParser.PathContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#path}.
	 * @param ctx the parse tree
	 */
	void exitPath(@NotNull TheBeastMLNGrammarParser.PathContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#typeStatement}.
	 * @param ctx the parse tree
	 */
	void enterTypeStatement(@NotNull TheBeastMLNGrammarParser.TypeStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#typeStatement}.
	 * @param ctx the parse tree
	 */
	void exitTypeStatement(@NotNull TheBeastMLNGrammarParser.TypeStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#functionApplication}.
	 * @param ctx the parse tree
	 */
	void enterFunctionApplication(@NotNull TheBeastMLNGrammarParser.FunctionApplicationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#functionApplication}.
	 * @param ctx the parse tree
	 */
	void exitFunctionApplication(@NotNull TheBeastMLNGrammarParser.FunctionApplicationContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(@NotNull TheBeastMLNGrammarParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(@NotNull TheBeastMLNGrammarParser.FileContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#predicateDefinition}.
	 * @param ctx the parse tree
	 */
	void enterPredicateDefinition(@NotNull TheBeastMLNGrammarParser.PredicateDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#predicateDefinition}.
	 * @param ctx the parse tree
	 */
	void exitPredicateDefinition(@NotNull TheBeastMLNGrammarParser.PredicateDefinitionContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#weightedFormulaAcyclic}.
	 * @param ctx the parse tree
	 */
	void enterWeightedFormulaAcyclic(@NotNull TheBeastMLNGrammarParser.WeightedFormulaAcyclicContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#weightedFormulaAcyclic}.
	 * @param ctx the parse tree
	 */
	void exitWeightedFormulaAcyclic(@NotNull TheBeastMLNGrammarParser.WeightedFormulaAcyclicContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#setStatement}.
	 * @param ctx the parse tree
	 */
	void enterSetStatement(@NotNull TheBeastMLNGrammarParser.SetStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#setStatement}.
	 * @param ctx the parse tree
	 */
	void exitSetStatement(@NotNull TheBeastMLNGrammarParser.SetStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#typeDefinition}.
	 * @param ctx the parse tree
	 */
	void enterTypeDefinition(@NotNull TheBeastMLNGrammarParser.TypeDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#typeDefinition}.
	 * @param ctx the parse tree
	 */
	void exitTypeDefinition(@NotNull TheBeastMLNGrammarParser.TypeDefinitionContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(@NotNull TheBeastMLNGrammarParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(@NotNull TheBeastMLNGrammarParser.TermContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#weightFunction}.
	 * @param ctx the parse tree
	 */
	void enterWeightFunction(@NotNull TheBeastMLNGrammarParser.WeightFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#weightFunction}.
	 * @param ctx the parse tree
	 */
	void exitWeightFunction(@NotNull TheBeastMLNGrammarParser.WeightFunctionContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#groundAtomDefinition}.
	 * @param ctx the parse tree
	 */
	void enterGroundAtomDefinition(@NotNull TheBeastMLNGrammarParser.GroundAtomDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#groundAtomDefinition}.
	 * @param ctx the parse tree
	 */
	void exitGroundAtomDefinition(@NotNull TheBeastMLNGrammarParser.GroundAtomDefinitionContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#order}.
	 * @param ctx the parse tree
	 */
	void enterOrder(@NotNull TheBeastMLNGrammarParser.OrderContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#order}.
	 * @param ctx the parse tree
	 */
	void exitOrder(@NotNull TheBeastMLNGrammarParser.OrderContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#typedVariableList}.
	 * @param ctx the parse tree
	 */
	void enterTypedVariableList(@NotNull TheBeastMLNGrammarParser.TypedVariableListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#typedVariableList}.
	 * @param ctx the parse tree
	 */
	void exitTypedVariableList(@NotNull TheBeastMLNGrammarParser.TypedVariableListContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#weightedFormulaSplit}.
	 * @param ctx the parse tree
	 */
	void enterWeightedFormulaSplit(@NotNull TheBeastMLNGrammarParser.WeightedFormulaSplitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#weightedFormulaSplit}.
	 * @param ctx the parse tree
	 */
	void exitWeightedFormulaSplit(@NotNull TheBeastMLNGrammarParser.WeightedFormulaSplitContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#ruleFile}.
	 * @param ctx the parse tree
	 */
	void enterRuleFile(@NotNull TheBeastMLNGrammarParser.RuleFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#ruleFile}.
	 * @param ctx the parse tree
	 */
	void exitRuleFile(@NotNull TheBeastMLNGrammarParser.RuleFileContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#predicateCategory}.
	 * @param ctx the parse tree
	 */
	void enterPredicateCategory(@NotNull TheBeastMLNGrammarParser.PredicateCategoryContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#predicateCategory}.
	 * @param ctx the parse tree
	 */
	void exitPredicateCategory(@NotNull TheBeastMLNGrammarParser.PredicateCategoryContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#quantification}.
	 * @param ctx the parse tree
	 */
	void enterQuantification(@NotNull TheBeastMLNGrammarParser.QuantificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#quantification}.
	 * @param ctx the parse tree
	 */
	void exitQuantification(@NotNull TheBeastMLNGrammarParser.QuantificationContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#booleanFormula}.
	 * @param ctx the parse tree
	 */
	void enterBooleanFormula(@NotNull TheBeastMLNGrammarParser.BooleanFormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#booleanFormula}.
	 * @param ctx the parse tree
	 */
	void exitBooleanFormula(@NotNull TheBeastMLNGrammarParser.BooleanFormulaContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#weightTerm}.
	 * @param ctx the parse tree
	 */
	void enterWeightTerm(@NotNull TheBeastMLNGrammarParser.WeightTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#weightTerm}.
	 * @param ctx the parse tree
	 */
	void exitWeightTerm(@NotNull TheBeastMLNGrammarParser.WeightTermContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#loadStatement}.
	 * @param ctx the parse tree
	 */
	void enterLoadStatement(@NotNull TheBeastMLNGrammarParser.LoadStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#loadStatement}.
	 * @param ctx the parse tree
	 */
	void exitLoadStatement(@NotNull TheBeastMLNGrammarParser.LoadStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#learnStatement}.
	 * @param ctx the parse tree
	 */
	void enterLearnStatement(@NotNull TheBeastMLNGrammarParser.LearnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#learnStatement}.
	 * @param ctx the parse tree
	 */
	void exitLearnStatement(@NotNull TheBeastMLNGrammarParser.LearnStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#weightFunctionApplication}.
	 * @param ctx the parse tree
	 */
	void enterWeightFunctionApplication(@NotNull TheBeastMLNGrammarParser.WeightFunctionApplicationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#weightFunctionApplication}.
	 * @param ctx the parse tree
	 */
	void exitWeightFunctionApplication(@NotNull TheBeastMLNGrammarParser.WeightFunctionApplicationContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#weightFunctionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterWeightFunctionDefinition(@NotNull TheBeastMLNGrammarParser.WeightFunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#weightFunctionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitWeightFunctionDefinition(@NotNull TheBeastMLNGrammarParser.WeightFunctionDefinitionContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#possibleWorld}.
	 * @param ctx the parse tree
	 */
	void enterPossibleWorld(@NotNull TheBeastMLNGrammarParser.PossibleWorldContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#possibleWorld}.
	 * @param ctx the parse tree
	 */
	void exitPossibleWorld(@NotNull TheBeastMLNGrammarParser.PossibleWorldContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#dbFile}.
	 * @param ctx the parse tree
	 */
	void enterDbFile(@NotNull TheBeastMLNGrammarParser.DbFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#dbFile}.
	 * @param ctx the parse tree
	 */
	void exitDbFile(@NotNull TheBeastMLNGrammarParser.DbFileContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(@NotNull TheBeastMLNGrammarParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(@NotNull TheBeastMLNGrammarParser.PrintStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#setValue}.
	 * @param ctx the parse tree
	 */
	void enterSetValue(@NotNull TheBeastMLNGrammarParser.SetValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#setValue}.
	 * @param ctx the parse tree
	 */
	void exitSetValue(@NotNull TheBeastMLNGrammarParser.SetValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#includeStatement}.
	 * @param ctx the parse tree
	 */
	void enterIncludeStatement(@NotNull TheBeastMLNGrammarParser.IncludeStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#includeStatement}.
	 * @param ctx the parse tree
	 */
	void exitIncludeStatement(@NotNull TheBeastMLNGrammarParser.IncludeStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(@NotNull TheBeastMLNGrammarParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(@NotNull TheBeastMLNGrammarParser.VariableContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#prefixFunction}.
	 * @param ctx the parse tree
	 */
	void enterPrefixFunction(@NotNull TheBeastMLNGrammarParser.PrefixFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#prefixFunction}.
	 * @param ctx the parse tree
	 */
	void exitPrefixFunction(@NotNull TheBeastMLNGrammarParser.PrefixFunctionContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#typeLabel}.
	 * @param ctx the parse tree
	 */
	void enterTypeLabel(@NotNull TheBeastMLNGrammarParser.TypeLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#typeLabel}.
	 * @param ctx the parse tree
	 */
	void exitTypeLabel(@NotNull TheBeastMLNGrammarParser.TypeLabelContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#nextStatement}.
	 * @param ctx the parse tree
	 */
	void enterNextStatement(@NotNull TheBeastMLNGrammarParser.NextStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#nextStatement}.
	 * @param ctx the parse tree
	 */
	void exitNextStatement(@NotNull TheBeastMLNGrammarParser.NextStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#weightedFormula}.
	 * @param ctx the parse tree
	 */
	void enterWeightedFormula(@NotNull TheBeastMLNGrammarParser.WeightedFormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#weightedFormula}.
	 * @param ctx the parse tree
	 */
	void exitWeightedFormula(@NotNull TheBeastMLNGrammarParser.WeightedFormulaContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#operationInstruction}.
	 * @param ctx the parse tree
	 */
	void enterOperationInstruction(@NotNull TheBeastMLNGrammarParser.OperationInstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#operationInstruction}.
	 * @param ctx the parse tree
	 */
	void exitOperationInstruction(@NotNull TheBeastMLNGrammarParser.OperationInstructionContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#groundAtomValue}.
	 * @param ctx the parse tree
	 */
	void enterGroundAtomValue(@NotNull TheBeastMLNGrammarParser.GroundAtomValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#groundAtomValue}.
	 * @param ctx the parse tree
	 */
	void exitGroundAtomValue(@NotNull TheBeastMLNGrammarParser.GroundAtomValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link TheBeastMLNGrammarParser#collectStatement}.
	 * @param ctx the parse tree
	 */
	void enterCollectStatement(@NotNull TheBeastMLNGrammarParser.CollectStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheBeastMLNGrammarParser#collectStatement}.
	 * @param ctx the parse tree
	 */
	void exitCollectStatement(@NotNull TheBeastMLNGrammarParser.CollectStatementContext ctx);
}