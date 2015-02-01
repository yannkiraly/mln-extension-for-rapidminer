package com.rapidminer.operator.modelling.converters.thebeast;

import java.util.ArrayList;
import java.util.List;

import com.rapidminer.operator.modelling.configuration.fixed.MLNError;
import com.rapidminer.operator.modelling.configuration.fixed.MLNException;
import com.rapidminer.operator.modelling.converters.exampleset.ExampleSetBuilder;
import com.rapidminer.operator.modelling.converters.exampleset.model.ExampleSetBuilderOntology;
import com.rapidminer.operator.modelling.converters.utilities.ConverterUtilities;
import com.rapidminer.operator.modelling.model.MLNFormula;
import com.rapidminer.operator.modelling.model.MLNFunction;
import com.rapidminer.operator.modelling.model.MLNFunctionApplication;
import com.rapidminer.operator.modelling.model.MLNFunctionDefinition;
import com.rapidminer.operator.modelling.model.MLNGroundArgument;
import com.rapidminer.operator.modelling.model.MLNGroundAtom;
import com.rapidminer.operator.modelling.model.MLNGroundFormula;
import com.rapidminer.operator.modelling.model.MLNGroundFunctionApplication;
import com.rapidminer.operator.modelling.model.MLNModel;
import com.rapidminer.operator.modelling.model.MLNPlainFormula;
import com.rapidminer.operator.modelling.model.MLNPredicate;
import com.rapidminer.operator.modelling.model.MLNPredicateApplication;
import com.rapidminer.operator.modelling.model.MLNProbabilityStatement;
import com.rapidminer.operator.modelling.model.MLNQuantification;
import com.rapidminer.operator.modelling.model.MLNRelation;
import com.rapidminer.operator.modelling.model.MLNVarArgument;
import com.rapidminer.operator.modelling.model.MLNWeight;
import com.rapidminer.operator.modelling.model.operators.MLNFormulaOperator;
import com.rapidminer.operator.modelling.model.operators.MLNOperatorApplication;
import com.rapidminer.operator.modelling.model.types.MLNConstantType;
import com.rapidminer.operator.modelling.model.types.MLNRangeNumericalType;
import com.rapidminer.operator.modelling.model.types.MLNSpecifiedNumericalType;
import com.rapidminer.operator.modelling.model.types.MLNTypeArgument;
import com.rapidminer.operator.modelling.model.types.MLNTypeContainer;

public class TheBeastMLNBuilder {
	private static final String NO_VAR_WEIGHTS_ERROR = "Variable weights are not supported by Alchemy.";
	private static final String LIST_SEPARATOR = ",";
	
	private MLNModel mlnModel;
	
	private static String[] builtinPredicates = {"=","!=", ">", "<", ">=", "<="};
	private static String[] builtinFunctions = {"+","-","*","/"};
	private static String[] builtinPrefixFunctions = {"-"};
	private static int varCounter = 0;
	
	private static boolean isBuiltinPredicate(String predicate) {
		if (ConverterUtilities.arrayContains(builtinPredicates, predicate))
			return true;
		else
			return false;
	}
	
	private static boolean isBuiltinFunction(String function) {
		if (ConverterUtilities.arrayContains(builtinFunctions, function))
			return true;
		else
			return false;
	}
	
	private static boolean isBuiltinPrefixFunction(String function) {
		if (ConverterUtilities.arrayContains(builtinPrefixFunctions, function))
			return true;
		else
			return false;
	}
	
	
	//Constraints must exist in separate formulas and only refer to one variable at a time.
		private void convertConstraints() throws MLNException {
			int pos=-1, counter;
			MLNTypeArgument arg;
			for (MLNFormula formula: mlnModel.getAll(MLNFormula.class)) {
				if ((formula.getPlainFormula()!=null) && (formula.getPlainFormula().getQuantification()!=null)
				 && (formula.getPlainFormula().getQuantification().getPlainFormula().getPredicateApplication()!=null) 
				 && (formula.getPlainFormula().getQuantification().getRelation().equals(MLNRelation.EQ))
				&& (formula.getPlainFormula().getQuantification().getNumber()==1) && 
				(formula.getPlainFormula().getQuantification().getArguments().size()==1)){
					counter = 0;
					for (MLNVarArgument varArg: 
						formula.getPlainFormula().getQuantification().getPlainFormula().getPredicateApplication()
						.getArguments()) {
						if ((varArg.getVariable()!=null) && (varArg.getVariable().contentEquals(
								formula.getPlainFormula().getQuantification().getArguments().get(0), false))) {
							pos = counter;
							break;
						}
						counter++;
					}
					if (pos>-1) {
						for (counter = 0; counter < formula.getPlainFormula().getQuantification()
							.getPlainFormula().getPredicateApplication().getPredicate().getArguments().size(); counter++) {
							arg = formula.getPlainFormula().getQuantification().getPlainFormula().getPredicateApplication().
									getPredicate().getArguments().get(counter);
							if (arg.isExcl() && counter!=pos) {
								MLNError.ONLY_ONE_EXCL.exception();
							} else if (counter==pos) {
								arg.setExcl(true);
							}
						}
					}
				}
			}
		}
	
	public TheBeastMLNBuilder(MLNModel model) throws MLNException {
		this.mlnModel = model;
		convertConstraints();
	}
	
	
	public static String buildTypeDeclaration(MLNTypeContainer typeContainer) throws MLNException {
		String ret;
		if (!typeContainer.isUnspecified()) {
			ret = ConverterUtilities.buildString(typeContainer.getName()," = ", parenthesize_square(
					typeValuesToString(typeContainer)), "\n");
					return ret;
		}
		else 
			return "";
	}

	public static String buildGroundFormula(MLNGroundFormula groundFormula)  throws MLNException {
		if (groundFormula.getGroundAtom() != null) {
			return groundAtomToString(groundFormula.getGroundAtom());
		} else if (groundFormula.getFunctionDefinition() != null) {
			return functionDefinitionToString(groundFormula.getFunctionDefinition());
		} else {
			return null;
		}
	}
	
	public static String buildPredicateDeclaration(MLNPredicate predicate)  throws MLNException {
		if (!isBuiltinPredicate(predicate.getName()))
			return ConverterUtilities.buildString(predicate.getName(), ConverterUtilities.parenthesize(
							ExampleSetBuilder.typeArgumentsToString(predicate.getArguments())));
		else
			return "";
	}
	
	public static String buildFunctionDeclaration(MLNFunction function)  throws MLNException {
		if (!isBuiltinFunction(function.getName()))
			return ConverterUtilities.buildString(function.getName(), ConverterUtilities.parenthesize(
						ExampleSetBuilder.typeArgumentsToString(function.getArguments())));
		else
			return "";
	}
	
	public static String groundAtomToString(MLNGroundAtom groundAtom) throws MLNException  {
		String negatedSign = (groundAtom.isNegated())?ConverterUtilities.EXCL:"";
		return ConverterUtilities.buildString(negatedSign, groundAtom.getPredicate().getName(), ConverterUtilities.parenthesize(
				mlnGroundArgumentsToString(groundAtom.getArguments())));
	}
	
	public static String functionDefinitionToString(MLNFunctionDefinition functionDefinition)  
			throws MLNException {
		return ConverterUtilities.buildString(ExampleSetBuilder.functionReturnValueToString(functionDefinition.getReturnValue()), " = ",
				functionDefinition.getFunction().getName(), ConverterUtilities.parenthesize(
						mlnGroundArgumentsToString(functionDefinition.getArguments())));
	}
	
	public static String groundFunctionApplicationToString(MLNGroundFunctionApplication groundFunctionApplication) 
			 throws MLNException {
		return ConverterUtilities.buildString(groundFunctionApplication.getFunction().getName(), ConverterUtilities.parenthesize(
						mlnGroundArgumentsToString(groundFunctionApplication.getArguments())));
	}
	
	public static String buildProbablityStatement(MLNProbabilityStatement statement)  throws MLNException {
		return ConverterUtilities.buildString(ExampleSetBuilder.groundFormulaToString(statement.getGroundFormula())," ",
				(statement.getProbability()!=null)?
						ConverterUtilities.SPACE+statement.getProbability().toString():"");
	}
	
	public static String buildFormula(MLNFormula formula, boolean convertLEconstraints,
			boolean removeUnsupportedConstraints) throws MLNException {
		String hardRuleString = (formula.isHardRule())?".":"";
		String pStr = plainFormulaToString(formula.getPlainFormula(), convertLEconstraints, removeUnsupportedConstraints);
		if (!pStr.equals(""))
			return ConverterUtilities.buildString(buildWeightString(formula.getProbabilityWeight(),formula.getUtilityWeight()),
			pStr, hardRuleString);
		else
			return "";
	}
	
	private static String buildWeightString(MLNWeight probabilityWeight, MLNWeight utilityWeight) throws MLNException {
		boolean p=(probabilityWeight!=null), u = (utilityWeight!=null);
		if (p && probabilityWeight.getVarWeight()!=null)
			throw new MLNException(NO_VAR_WEIGHTS_ERROR);
		String probabilityWeightString = p?probabilityWeight.toString():"";
		String utilityWeightString = u?utilityWeight.toString():"";
		return probabilityWeightString+(u?ConverterUtilities.COLON:"")+
				utilityWeightString+((p||u)?ConverterUtilities.SPACE:"");
	}
	
	private static String parenthesize_square(String text) {
		return "{"+text+"}";
	}

	public static String typeValuesToString(MLNTypeContainer type) throws MLNException {
		if (type.getConstantType() != null) {
			return constantTypeValuesToString(type.getConstantType());
		} else if (type.getSpecifiedNumericalType() != null) {
			return specifiedNumericalTypeValuesToString(type.getSpecifiedNumericalType());
		} else if (type.getRangeNumericalType() != null) {
			return rangeNumericalTypeValuesToString(type.getRangeNumericalType());
		}
		return null;
	}
	
	public static String constantTypeValuesToString(MLNConstantType type) throws MLNException {
		return ConverterUtilities.listToString(ConverterUtilities
				.namedMlnObjectsToStrings(type.getConstants()), LIST_SEPARATOR);
	}
	
	public static String specifiedNumericalTypeValuesToString(MLNSpecifiedNumericalType type) throws MLNException {
		return ConverterUtilities.listToString(ConverterUtilities.integerListToString(
				ConverterUtilities.doublesToIntegers(type.getNumbers())), LIST_SEPARATOR);
	}
	
	public static String rangeNumericalTypeValuesToString(MLNRangeNumericalType type) {
		return type.getLowerBound().intValue() +  ExampleSetBuilderOntology.DOTS +
				type.getUpperBound().intValue();
	}
	
	public static String mlnGroundArgumentsToString(List<MLNGroundArgument> arguments) throws MLNException {
		List<String> argString = new ArrayList<String>();
		for (MLNGroundArgument argument: arguments) {
			if (argument.getConstant() != null) {
				argString.add(argument.getConstant().getName());
			} else if (argument.getNumber() != null) {
				argString.add(argument.getNumber().intValue()+"");
			} else if (argument.getGroundAtom() != null) {
				argString.add(groundAtomToString(argument.getGroundAtom()));
			} else if (argument.getGroundFunctionApplication() != null) {
				argString.add(groundFunctionApplicationToString(argument.getGroundFunctionApplication()));
			}
		}
		return ConverterUtilities.listToString(argString, LIST_SEPARATOR);
	}
	

	public static String plainFormulaToString(MLNPlainFormula formula, boolean convertLEconstraints,
			boolean removeUnsupportedConstraints) throws MLNException {
		if (formula.getPredicateApplication() != null) {
			return predicateApplToString(formula.getPredicateApplication());
		} else if (formula.getFunctionApplication() != null) {
			return functionApplToString(formula.getFunctionApplication());
		} else if (formula.getOperatorApplication() != null) {
			return operatorApplToString(formula.getOperatorApplication(), convertLEconstraints, removeUnsupportedConstraints);
		} else if (formula.getQuantification() != null) {
			return quantificationToString(formula.getQuantification(), convertLEconstraints, removeUnsupportedConstraints);
		} else {
			return null;
		}
	}
	
	private static String predicateApplToString(MLNPredicateApplication predicateAppl)  throws MLNException {
		StringBuilder sb = new StringBuilder();
		if (isBuiltinPredicate(predicateAppl.getPredicate().getName())) {
			sb.append("(");
			sb.append(mlnVarArgumentsToString(ConverterUtilities.compose(predicateAppl.getArguments().get(0)))+" ");
			sb.append(predicateAppl.getPredicate().getName()+" ");
			sb.append(mlnVarArgumentsToString(ConverterUtilities.compose(predicateAppl.getArguments().get(1))));
			sb.append(")");
		} else {
			sb.append(predicateAppl.getPredicate().getName());
			sb.append("(");
			sb.append(mlnVarArgumentsToString(predicateAppl.getArguments()));
			sb.append(")");
		}
		return sb.toString();
	}
	
	private static String functionApplToString(MLNFunctionApplication functionAppl)  throws MLNException {
		StringBuilder sb = new StringBuilder();
		if (isBuiltinFunction(functionAppl.getFunction().getName()) && (functionAppl.getArguments().size()==2)) {
			sb.append("(");
			sb.append(mlnVarArgumentsToString(ConverterUtilities.compose(functionAppl.getArguments().get(0)))+" ");
			sb.append(functionAppl.getFunction().getName()+" ");
			sb.append(mlnVarArgumentsToString(ConverterUtilities.compose(functionAppl.getArguments().get(1))));
			sb.append(")");
		} else if (isBuiltinPrefixFunction(functionAppl.getFunction().getName())) {
			sb.append(functionAppl.getFunction().getName());
			sb.append(mlnVarArgumentsToString(ConverterUtilities.compose(functionAppl.getArguments().get(0))));
		} else {
			sb.append(functionAppl.getFunction().getName());
			sb.append("(");
			sb.append(mlnVarArgumentsToString(functionAppl.getArguments()));
			sb.append(")");
		}
		return sb.toString();
	}
	
	private static String mlnVarArgumentsToString(List<MLNVarArgument> arguments)  throws MLNException {
		List<String> argString = new ArrayList<String>();
		for (MLNVarArgument argument: arguments) {
			if (argument.getConstant() != null) {
				argString.add((argument.isPlus()?"+":"")+argument.getConstant().getName());
			} else if (argument.getVariable() != null) {
				argString.add((argument.isPlus()?"+":"")+argument.getVariable().getName());
			} else if (argument.getNumber() != null) {
				argString.add((argument.isPlus()?"+":"")+argument.getNumber().intValue()+"");
			} else if (argument.getPredicateApplication() != null) {
				argString.add(predicateApplToString(argument.getPredicateApplication()));
			} else if (argument.getFunctionApplication() != null) {
				argString.add(functionApplToString(argument.getFunctionApplication()));
			}
		}
		return ConverterUtilities.listToString(argString, LIST_SEPARATOR);
	}
	
	private static String operatorApplToString(MLNOperatorApplication operatorAppl,
			boolean convertLEconstraints, boolean removeUnsupportedConstraints) throws MLNException {
		int position = operatorAppl.getOperator().getPosition();
		if (MLNFormulaOperator.PREFIX==position)
			return prefixOperatorApplToString(operatorAppl, convertLEconstraints, removeUnsupportedConstraints);
		if (MLNFormulaOperator.INFIX==position)
			return infixOperatorApplToString(operatorAppl, convertLEconstraints, removeUnsupportedConstraints);
		if (MLNFormulaOperator.POSTFIX==position)
			return postfixOperatorApplToString(operatorAppl, convertLEconstraints, removeUnsupportedConstraints);
		if (MLNFormulaOperator.SURROUNDING==position)
			return surroundingOperatorApplToString(operatorAppl, convertLEconstraints, removeUnsupportedConstraints);
		return null;
	}
	
	private static String plainFormulasToString(List<MLNPlainFormula> formulas,
			boolean convertLEconstraints, boolean removeUnsupportedConstraints) throws MLNException{
		List<String> formulaStrings = new ArrayList<String>();
		for (MLNPlainFormula formula: formulas) {
			formulaStrings.add(plainFormulaToString(formula, convertLEconstraints, removeUnsupportedConstraints));
		}
		return ConverterUtilities.listToString(formulaStrings, LIST_SEPARATOR);
	}
		
	private static String processOperatorArguments(MLNOperatorApplication operatorAppl, boolean convertLEconstraints,
			boolean removeUnsupportedConstraints) throws MLNException{
		if (operatorAppl.getOperator().getArity() == 1) {
			return plainFormulaToString(operatorAppl.getArguments().get(0), convertLEconstraints, removeUnsupportedConstraints);
		} else {
			return "("+plainFormulasToString(
					operatorAppl.getArguments(), convertLEconstraints, removeUnsupportedConstraints)+")";
		}
	}
		
	private static String prefixOperatorApplToString(MLNOperatorApplication operatorAppl, boolean convertLEconstraints,
			boolean removeUnsupportedConstraints) 
			throws MLNException{
		StringBuilder sb = new StringBuilder();
		sb.append(operatorAppl.getOperator().getName()+" ");
		sb.append(ConverterUtilities.parenthesize(processOperatorArguments(operatorAppl, convertLEconstraints,
				removeUnsupportedConstraints)));
		return sb.toString();
	}
	
	private static String infixOperatorApplToString(MLNOperatorApplication operatorAppl,
			boolean convertLEconstraints, boolean removeUnsupportedConstraints) throws MLNException{
		if (operatorAppl.getOperator().getArity() == 2) {
			StringBuilder sb = new StringBuilder();
			sb.append(ConverterUtilities.parenthesize(
					plainFormulaToString(operatorAppl.getArguments().get(0),  convertLEconstraints, removeUnsupportedConstraints)));
			sb.append(" "+operatorAppl.getOperator().getName()+" ");
			sb.append(ConverterUtilities.parenthesize(
					plainFormulaToString(operatorAppl.getArguments().get(1), convertLEconstraints, removeUnsupportedConstraints)));
			return sb.toString();
		} else {
			MLNError.INFIX_NOT_TWO.exception();
			return "";
		}
	}
	
	private static String postfixOperatorApplToString(MLNOperatorApplication operatorAppl,
			boolean convertLEconstraints, boolean removeUnsupportedConstraints) throws MLNException{
		StringBuilder sb = new StringBuilder();
		sb.append(ConverterUtilities.parenthesize(processOperatorArguments(operatorAppl, convertLEconstraints,
				removeUnsupportedConstraints)));
		sb.append(" "+operatorAppl.getOperator().getName());
		return sb.toString();
	}
	
	private static String surroundingOperatorApplToString(MLNOperatorApplication operatorAppl,
			boolean convertLEconstraints, boolean removeUnsupportedConstraints) throws MLNException{
		if (operatorAppl.getOperator().getClosing()==null) {
			throw new MLNException("Operator is surrounding but does not have a closing.");
		}
		StringBuilder sb = new StringBuilder();
		sb.append(operatorAppl.getOperator().getName());
		sb.append(" "+processOperatorArguments(operatorAppl, convertLEconstraints,
				removeUnsupportedConstraints)+" ");
		sb.append(operatorAppl.getOperator().getClosing());
		return sb.toString();
	}
	
	private static String quantificationToString(MLNQuantification quantification,
			boolean convertLEconstraints, boolean removeUnsupportedConstraints) throws MLNException{
		String quant, plainFormula;
		if ((quantification.geteQuant())|| (quantification.getuQuant())) {

			if (quantification.geteQuant())
				quant = MLNQuantification.E_QUANT_NAME;
			else
				quant = MLNQuantification.U_QUANT_NAME;
			return ConverterUtilities.buildString(quant, ConverterUtilities.SPACE, 
					ConverterUtilities.listToString(ConverterUtilities.namedMlnObjectsToStrings(quantification.getArguments()),","),
					ConverterUtilities.SPACE,plainFormulaToString(quantification.getPlainFormula(), convertLEconstraints,
							removeUnsupportedConstraints));
			
		} else {
			if (quantification.getArguments()!=null && 
					quantification.getArguments().size()==1 && quantification.getNumber()==1 &&  
				(quantification.getRelation().equals(MLNRelation.EQ))){
				return "";
			} else if (quantification.getArguments()!=null && 
						quantification.getArguments().size()==1 && quantification.getNumber()==1 &&  
					(quantification.getRelation().equals(MLNRelation.LE) && convertLEconstraints)) {
				plainFormula = plainFormulaToString(quantification.getPlainFormula(), convertLEconstraints,
						removeUnsupportedConstraints);
				plainFormula = ConverterUtilities.buildString("!"+
					plainFormula +" v "+
						"!("+quantification.getArguments().get(0).getName()+" = cEV"+
					varCounter+") v !"+plainFormula.replace(quantification.getArguments().get(0).getName(), 
							"cEV"+varCounter));
				varCounter++;
				return plainFormula;
			} else {
				if (removeUnsupportedConstraints)
					return "";
				else {
					MLNError.QUANTIFICATION_TYPE.exception();
					return "";
				}
			}
		}
	}
}
