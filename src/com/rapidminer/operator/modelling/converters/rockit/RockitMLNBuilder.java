package com.rapidminer.operator.modelling.converters.rockit;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.rapidminer.operator.modelling.configuration.fixed.MLNError;
import com.rapidminer.operator.modelling.configuration.fixed.MLNException;
import com.rapidminer.operator.modelling.converters.exampleset.ExampleSetBuilder;
import com.rapidminer.operator.modelling.converters.exampleset.model.ExampleSetBuilderOntology;
import com.rapidminer.operator.modelling.converters.utilities.ConverterUtilities;
import com.rapidminer.operator.modelling.converters.utilities.cnf.CNFConverter;
import com.rapidminer.operator.modelling.model.MLNClosedWorldType;
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
import com.rapidminer.operator.modelling.model.MLNVariable;
import com.rapidminer.operator.modelling.model.MLNWeight;
import com.rapidminer.operator.modelling.model.operators.MLNFormulaOperator;
import com.rapidminer.operator.modelling.model.operators.MLNOperatorApplication;
import com.rapidminer.operator.modelling.model.types.MLNConstantType;
import com.rapidminer.operator.modelling.model.types.MLNRangeNumericalType;
import com.rapidminer.operator.modelling.model.types.MLNSpecifiedNumericalType;
import com.rapidminer.operator.modelling.model.types.MLNTypeArgument;
import com.rapidminer.operator.modelling.model.types.MLNTypeContainer;

public class RockitMLNBuilder {
	private final String LIST_SEPARATOR = ",";
	
	private List<MLNPredicate> predicatesToExcl;
	
	private static String CONVERT_EXCL_KEY = "Replace ! notation with cardinality constraints";
	
	
	private static String[] builtinPredicates = {"=","!=", ">", "<", ">=", "<="};
	private static String[] builtinFunctions = {"+","-","*","/","%"};
	
	private boolean containsQuantification=false;
	
	private MLNModel mlnModel;
	public RockitMLNBuilder(MLNModel mlnModel) {
		this.mlnModel = mlnModel;
		this.predicatesToExcl = new ArrayList<MLNPredicate>();
	}
	
	public String buildTypeDeclaration(MLNTypeContainer typeContainer) throws MLNException {
//		if (!typeContainer.isUnspecified()) {
//			return ConverterUtilities.buildString(typeContainer.getName()," = ", parenthesize_square(
//					typeValuesToString(typeContainer)), "\n");}
//		else 
			return "";
	}
	
	public String buildProbablityStatement(MLNProbabilityStatement statement) throws MLNException {
		return ConverterUtilities.buildString(ExampleSetBuilder.groundFormulaToString(statement.getGroundFormula())," ",
				(statement.getProbability()!=null)?
						ConverterUtilities.SPACE+statement.getProbability().toString():"");
	}
	
	public String buildPredicateDeclaration(MLNPredicate predicate, boolean convertExcl) throws MLNException {
		String star, pred;
		if (!isBuiltinPredicate(predicate.getName())) {
			if (predicate.getClosedWorldType().name().equals(MLNClosedWorldType.Query.name())) {
				star = "";
			} else {
				star = "*";
			}
			if (predicate.getArguments()!=null) {
				for (MLNTypeArgument type: predicate.getArguments()) {
					if (type.isExcl() && convertExcl) {
						predicatesToExcl.add(predicate);
					}
				}
			}
			if (predicate.getName().length()>1) {
				pred = predicate.getName().substring(0, 1).toLowerCase()
						+predicate.getName().substring(1);
			} else {
				pred = 	predicate.getName().toLowerCase();
			}
			return ConverterUtilities.buildString(star, pred, parenthesize(
							typeArgumentsToString(predicate.getArguments())));
		} else {
			return "";
		}
	}
	
	private boolean isBuiltinPredicate(String predicate) {
		if (ConverterUtilities.arrayContains(builtinPredicates, predicate))
			return true;
		else
			return false;
	}
	
	private boolean isBuiltinFunction(String function) {
		if (ConverterUtilities.arrayContains(builtinFunctions, function))
			return true;
		else
			return false;
	}
	
	private boolean isBuiltinPrefixFunction(String function) {
		if (ConverterUtilities.arrayContains(builtinFunctions, function))
			return true;
		else
			return false;
	}

	public String buildGroundFormula(MLNGroundFormula groundFormula) throws MLNException {
		if (groundFormula.getGroundAtom() != null) {
			return groundAtomToString(groundFormula.getGroundAtom());
		} else if (groundFormula.getFunctionDefinition() != null) {
			return functionDefinitionToString(groundFormula.getFunctionDefinition());
		} else {
			return null;
		}
	}
	
	public String buildFunctionDeclaration(MLNFunction function) throws MLNException {
		if (!isBuiltinFunction(function.getName())) {
			String functionStr;
			if (function.getName().length()>1)
				functionStr = function.getName().substring(0, 1).toLowerCase()
						+function.getName().substring(1);
			else {
				functionStr = function.getName().toLowerCase();
			}
			return ConverterUtilities.buildString(functionStr, parenthesize(
							typeArgumentsToString(function.getArguments())));
		} else {
			return "";
		}
	}
	
	public String groundAtomToString(MLNGroundAtom groundAtom) throws MLNException {
		String negatedSign = (groundAtom.isNegated())?ConverterUtilities.EXCL:"";
		String atom;
		if (groundAtom.getPredicate().getName().length()>1)
			atom = groundAtom.getPredicate().getName().substring(0, 1).toLowerCase()+
					groundAtom.getPredicate().getName().substring(1);
		else
			atom = groundAtom.getPredicate().getName().toLowerCase();
		if (isBuiltinPredicate(groundAtom.getPredicate().getName())) {
			if (groundAtom.isNegated()) {
				return ConverterUtilities.buildString(negatedSign, ConverterUtilities.PARENTHESIS_LEFT,
						mlnGroundArgumentToString(groundAtom.getArguments().get(0))+" ", atom, 
						mlnGroundArgumentToString(groundAtom.getArguments().get(1)),  ConverterUtilities.PARENTHESIS_RIGHT);
			} else {
				return ConverterUtilities.buildString(
						mlnGroundArgumentToString(groundAtom.getArguments().get(0))+" ", atom, 
						mlnGroundArgumentToString(groundAtom.getArguments().get(1)));
			}
		} else
			return ConverterUtilities.buildString(negatedSign, atom, parenthesize(
					mlnGroundArgumentsToString(groundAtom.getArguments())));
	}
	
	public String functionDefinitionToString(MLNFunctionDefinition functionDefinition) 
			throws MLNException {
		return ConverterUtilities.buildString(ExampleSetBuilder.functionReturnValueToString(functionDefinition.getReturnValue()), " = ",
				functionDefinition.getFunction().getName(), parenthesize(
						mlnGroundArgumentsToString(functionDefinition.getArguments())));
	}
	
	public String buildFormula(MLNFormula formula) throws MLNException{
		String str="";
		if(predicatesToExcl.size()>0)
			str = handlePredicatesToExcl();
		return str+buildFormulaInternal(formula);
	}
	
	private String buildFormulaInternal(MLNFormula formula) throws MLNException {
		if (formula.getUtilityWeight()!=null) {
			MLNError.UTILITY_WEIGHTS.exception();
		}
		List<MLNFormula> formulas = (new CNFConverter(mlnModel)).formulaToCNF(formula);
		List<String> formulaStrings = new ArrayList<String>();
		String plainFormulaString;
		for (MLNFormula mlnFormula : formulas) {
			containsQuantification = false;
			plainFormulaString = plainFormulaToString(mlnFormula.getPlainFormula(), this);
			if (!plainFormulaString.equals(""))
				formulaStrings.add(ConverterUtilities.buildString((!containsQuantification)?buildWeightString(
						mlnFormula.getProbabilityWeight()):"",
						plainFormulaString ,(mlnFormula.isHardRule()
								&&(!containsQuantification))?".":""));
		}
		return ConverterUtilities.listToString(formulaStrings, "\n")+"\n";
	}
	
	private String handlePredicatesToExcl() throws MLNException {
		List<MLNVarArgument> varArgs = new ArrayList<MLNVarArgument>();
		MLNVariable var = null;
		int counter = 0;
		String ret = "";
		for (MLNPredicate predicate: predicatesToExcl) {
			for (MLNTypeArgument type: predicate.getArguments()) {
				varArgs.add(mlnModel.buildMLNVarArgument(
						mlnModel.buildMLNVariable("constraintVar"+counter, false), false));
				if (type.isExcl()) {
					var = varArgs.get(counter).getVariable();
				}
				counter++;
			}
			ret = ret + buildFormulaInternal(mlnModel.buildMLNFormula(
					mlnModel.buildMLNPlainFormula(
							mlnModel.buildMLNQuantification("", false, 
									false, 
									mlnModel.buildMLNPlainFormula(
									mlnModel.buildMLNPredicateApplication(
									predicate, varArgs)), ConverterUtilities.compose(var),
									MLNRelation.EQ, 1)), null, null, true));
		}
		return ret;
	}
	
	private String buildWeightString(MLNWeight probabilityWeight) {
		boolean p=(probabilityWeight!=null);
		boolean v=p?(probabilityWeight.getVarWeight()!=null?true:false):false;
		String probabilityWeightString = p?probabilityWeight.toString():"";
		return probabilityWeightString+(v?ConverterUtilities.COLON:"")+ConverterUtilities.SPACE;
	}

	
	private String parenthesize(String text) {
		return "("+text+")";
	}
	
	private String parenthesize_square(String text) {
		return "{"+text+"}";
	}

	public String typeValuesToString(MLNTypeContainer type) throws MLNException {
		if (type.getConstantType() != null) {
			return constantTypeValuesToString(type.getConstantType());
		} else if (type.getSpecifiedNumericalType() != null) {
			return specifiedNumericalTypeValuesToString(type.getSpecifiedNumericalType());
		} else if (type.getRangeNumericalType() != null) {
			return rangeNumericalTypeValuesToString(type.getRangeNumericalType());
		}
		return null;
	}
	
	public String constantTypeValuesToString(MLNConstantType type) throws MLNException {
		return ConverterUtilities.listToString(ConverterUtilities
				.namedMlnObjectsToStrings(type.getConstants()), LIST_SEPARATOR);
	}
	
	public String specifiedNumericalTypeValuesToString(MLNSpecifiedNumericalType type)
			throws MLNException {
		return ConverterUtilities.listToString(ConverterUtilities.integerListToString(
				ConverterUtilities.doublesToIntegers(type.getNumbers())), LIST_SEPARATOR);
	}
	
	public String rangeNumericalTypeValuesToString(MLNRangeNumericalType type) {
		return type.getLowerBound().intValue() +  ExampleSetBuilderOntology.DOTS +
				type.getUpperBound().intValue();
	}
	
	private String mlnGroundArgumentsToString(List<MLNGroundArgument> arguments) throws MLNException {
		List<String> argString = new ArrayList<String>();
		for (MLNGroundArgument argument: arguments) {
			argString.add(mlnGroundArgumentToString(argument));
		}
		return ConverterUtilities.listToString(argString, LIST_SEPARATOR);
	}
	
	private String mlnGroundArgumentToString(MLNGroundArgument argument) throws MLNException {
		if (argument.getConstant() != null) {
			return argument.getConstant().getName();
		} else if (argument.getNumber() != null) {
			return numberToString(argument.getNumber());
		} else if (argument.getGroundAtom() != null) {
			return groundAtomToString(argument.getGroundAtom());
		} else if (argument.getGroundFunctionApplication() != null) {
			return groundFunctionApplicationToString(argument.getGroundFunctionApplication());
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	private String numberToString(Double number) {
		if ((number == Math.floor(number)) && !Double.isInfinite(number)) {
			return ConverterUtilities.safeToString(Math.floor(number));
		} else {
			return ConverterUtilities.safeToString(number);
		}
	}
	
	public String groundFunctionApplicationToString(MLNGroundFunctionApplication groundFunctionAppl) 
			throws MLNException {
		String functionStr;
		if (groundFunctionAppl.getFunction().getName().length()>1)
			functionStr = groundFunctionAppl.getFunction().getName().substring(0, 1).toLowerCase()+
					groundFunctionAppl.getFunction().getName().substring(1);
		else 
			functionStr = groundFunctionAppl.getFunction().getName().toLowerCase();
		if (isBuiltinFunction(groundFunctionAppl.getFunction().getName())) {
			return ConverterUtilities.buildString(
					mlnGroundArgumentToString(groundFunctionAppl.getArguments().get(0))+" ", functionStr, 
					mlnGroundArgumentToString(groundFunctionAppl.getArguments().get(1)));
		} else {
			return ConverterUtilities.buildString(functionStr,
					ConverterUtilities.PARENTHESIS_LEFT, mlnGroundArgumentsToString(groundFunctionAppl.getArguments()),
					ConverterUtilities.PARENTHESIS_RIGHT);
		}
	}

	public String plainFormulaToString( MLNPlainFormula formula, RockitMLNBuilder builder) throws MLNException  {
		if (formula.getPredicateApplication() != null) {
			return predicateApplToString(formula.getPredicateApplication(), builder);
		} else if (formula.getFunctionApplication() != null) {
			return functionApplToString(formula.getFunctionApplication(), builder);
		} else if (formula.getOperatorApplication() != null) {
			return operatorApplToString(formula.getOperatorApplication(), builder);
		} else if (formula.getQuantification() != null) {
			builder.setContainsQuantification(true);
			return quantificationToString(formula.getQuantification(), builder);
		} else {
			return null;
		}
	}
	
	private String predicateApplToString(MLNPredicateApplication predicateAppl,
			RockitMLNBuilder builder) throws MLNException {
		String pred;
		if (predicateAppl.getPredicate().getName().length()>1)
			pred = predicateAppl.getPredicate().getName().substring(0, 1).toLowerCase()+
					predicateAppl.getPredicate().getName().substring(1);
		else
			pred = predicateAppl.getPredicate().getName().toLowerCase();
		StringBuilder sb = new StringBuilder();
		if (isBuiltinPredicate(predicateAppl.getPredicate().getName())) {
			sb.append(mlnVarArgumentsToString(
					ConverterUtilities.compose(predicateAppl.getArguments().get(0)), builder)+" ");
			sb.append(pred+" ");
			sb.append(mlnVarArgumentsToString(
					ConverterUtilities.compose(predicateAppl.getArguments().get(1)), builder));
		} else {
			sb.append(pred);
			sb.append("(");
			sb.append(mlnVarArgumentsToString(predicateAppl.getArguments(), builder));
			sb.append(")");
		}
		return sb.toString();
	}
	
	private String functionApplToString(MLNFunctionApplication functionAppl, RockitMLNBuilder builder) throws MLNException {
		StringBuilder sb = new StringBuilder();
		String functionStr;
		if (functionAppl.getFunction().getName().length()>1)
			functionStr = functionAppl.getFunction().getName().substring(0, 1).toLowerCase()+
					functionAppl.getFunction().getName().substring(1);
		else
			functionStr = functionAppl.getFunction().getName().toLowerCase();
		if (isBuiltinFunction(functionAppl.getFunction().getName()) && (functionAppl.getArguments().size()==2) ) {
			sb.append(mlnVarArgumentsToString(
					ConverterUtilities.compose(functionAppl.getArguments().get(0)), builder)+" ");
			sb.append(functionStr+" ");
			sb.append(mlnVarArgumentsToString(
					ConverterUtilities.compose(functionAppl.getArguments().get(1)), builder));
		} else if (isBuiltinPrefixFunction(functionAppl.getFunction().getName())) {
			sb.append(functionStr);
			sb.append(mlnVarArgumentsToString(
					ConverterUtilities.compose(functionAppl.getArguments().get(0)), builder));
		} else {
			sb.append(functionStr);
			sb.append("(");
			sb.append(mlnVarArgumentsToString(functionAppl.getArguments(), builder));
			sb.append(")");
		}
		return sb.toString();
	}
	
	private String mlnVarArgumentsToString(List<MLNVarArgument> arguments, RockitMLNBuilder builder) 
			throws MLNException {
		List<String> argString = new ArrayList<String>();
		for (MLNVarArgument argument: arguments) {
			argString.add(mlnVarArgumentToString(argument, builder));
		}
		return ConverterUtilities.listToString(argString, LIST_SEPARATOR);
	}
	
	private String mlnVarArgumentToString(MLNVarArgument argument, RockitMLNBuilder builder) 
		throws MLNException {
		if (argument.getConstant() != null) {
			return (argument.isPlus()?"+":"")+argument.getConstant().getName();
		} else if (argument.getVariable() != null) {
			return (argument.isPlus()?"+":"")+argument.getVariable().getName();
		} else if (argument.getNumber() != null) {
			return (argument.isPlus()?"+":"")+numberToString(argument.getNumber());
		} else if (argument.getPredicateApplication() != null) {
			return predicateApplToString(argument.getPredicateApplication(), builder);
		} else if (argument.getFunctionApplication() != null) {
			return functionApplToString(argument.getFunctionApplication(), builder);
		} else
			throw new IllegalArgumentException();
	}
	
	private String operatorApplToString(MLNOperatorApplication operatorAppl, RockitMLNBuilder builder) throws MLNException {
		int position = operatorAppl.getOperator().getPosition();
		if (MLNFormulaOperator.PREFIX==position)
			return prefixOperatorApplToString(operatorAppl, builder);
		if (MLNFormulaOperator.INFIX==position)
			return infixOperatorApplToString(operatorAppl, builder);
		if (MLNFormulaOperator.POSTFIX==position)
			return postfixOperatorApplToString(operatorAppl, builder);
		if (MLNFormulaOperator.SURROUNDING==position)
			return surroundingOperatorApplToString(operatorAppl, builder);
		return null;
	}
	
	private String plainFormulasToString(List<MLNPlainFormula> formulas, RockitMLNBuilder builder) throws MLNException{
		List<String> formulaStrings = new ArrayList<String>();
		for (MLNPlainFormula formula: formulas) {
			formulaStrings.add(plainFormulaToString(formula, builder));
		}
		return ConverterUtilities.listToString(formulaStrings, LIST_SEPARATOR);
	}
		
	private String processOperatorArguments(MLNOperatorApplication operatorAppl, RockitMLNBuilder builder) 
		throws MLNException{
		if (operatorAppl.getOperator().getArity() == 1) {
			return plainFormulaToString(operatorAppl.getArguments().get(0), builder);
		} else {
			return "("+plainFormulasToString(
					operatorAppl.getArguments(), builder)+")";
		}
	}
		
	private String prefixOperatorApplToString(MLNOperatorApplication operatorAppl,
			RockitMLNBuilder builder) throws MLNException{
		StringBuilder sb = new StringBuilder();
		sb.append(operatorAppl.getOperator().getName()+" ");
		sb.append(
				plainFormulaToString(operatorAppl.getArguments().get(0), builder));
		return sb.toString();
	}
	
	private String infixOperatorApplToString(MLNOperatorApplication operatorAppl,
			RockitMLNBuilder builder) throws MLNException{
		if (operatorAppl.getOperator().getArity() == 2) {
			StringBuilder sb = new StringBuilder();
			sb.append(plainFormulaToString(operatorAppl.getArguments().get(0), builder));
			sb.append(" "+operatorAppl.getOperator().getName()+" ");
			sb.append(plainFormulaToString(operatorAppl.getArguments().get(1), builder));
			return sb.toString();
		} else {
			MLNError.INFIX_NOT_TWO.exception();
			return null;
		}
	}
	
	private String postfixOperatorApplToString(MLNOperatorApplication operatorAppl,
			RockitMLNBuilder builder) throws MLNException{
		StringBuilder sb = new StringBuilder();
		sb.append(plainFormulaToString(
				operatorAppl.getArguments().get(0), builder));
		sb.append(" "+operatorAppl.getOperator().getName());
		return sb.toString();
	}
	
	private String surroundingOperatorApplToString(MLNOperatorApplication operatorAppl,
			RockitMLNBuilder builder) throws MLNException{
		if (operatorAppl.getOperator().getClosing()==null) {
			MLNError.SURROUNDING_NO_CLOSING.exception();
		}
		StringBuilder sb = new StringBuilder();
		sb.append(operatorAppl.getOperator().getName());
		sb.append(" "+processOperatorArguments(operatorAppl, builder)+" ");
		sb.append(operatorAppl.getOperator().getClosing());
		return sb.toString();
	}
	
	private String quantificationToString(MLNQuantification quantification, RockitMLNBuilder builder) throws MLNException{
		StringBuilder sb = new StringBuilder();
		String relation, numberText, start="|", end="|";
		if (quantification.getuQuant()) {
				sb.append(plainFormulaToString(quantification.getPlainFormula(), builder));
		} else {
			if (quantification.geteQuant()) {
				relation = MLNQuantification.E_QUANT_RELATION.getText();
				numberText = MLNQuantification.E_QUANT_NUMBER.toString();
			} else {
				relation = (quantification.getRelation()!=null)?quantification.getRelation().getText():"";
				numberText = (quantification.getNumber()!=null)?quantification.getNumber().toString():"";
			}
			sb.append(start);
			for (String str : ConverterUtilities.namedMlnObjectsToStrings(quantification.getArguments())) {
				sb.append(str);
			}
			sb.append(end+" ");
			sb.append(plainFormulaToString(quantification.getPlainFormula(), builder));
			sb.append(" "+relation+" "+numberText);
		}
		return sb.toString();
	}
	
	public static String typeArgumentsToString(List<MLNTypeArgument> typeArguments)  throws MLNException  {
		List<String> arguments = new ArrayList<String>();
		String type;
		if (typeArguments != null) {
			for (MLNTypeArgument typeArgument: typeArguments) {
				type = typeArgument.getTypeContainer().getName();
				if ((type.equals(RockitMLNConverter.FLOAT_TYPE_NAME)) || 
						(typeArgument.getTypeContainer().getRangeNumericalType()!=null) ||
						(typeArgument.getTypeContainer().getSpecifiedNumericalType()!=null)) {
					type = RockitMLNConverter.FLOAT_TYPE_NAME;
					arguments.add(type);
				} else {
					type = type.substring(0, 1).toUpperCase()+type.substring(1);
					arguments.add(type);
				}
			}
			return ConverterUtilities.listToString(arguments, ",");
		} else {
			return null;
		}
	}

	private void setContainsQuantification(boolean containsQuantification) {
		this.containsQuantification = containsQuantification;
	}
}