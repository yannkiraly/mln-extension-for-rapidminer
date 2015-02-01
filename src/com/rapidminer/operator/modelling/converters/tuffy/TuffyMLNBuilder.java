package com.rapidminer.operator.modelling.converters.tuffy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.rapidminer.operator.modelling.model.MLNWeight;
import com.rapidminer.operator.modelling.model.operators.MLNFormulaOperator;
import com.rapidminer.operator.modelling.model.operators.MLNOperatorApplication;
import com.rapidminer.operator.modelling.model.types.MLNConstantType;
import com.rapidminer.operator.modelling.model.types.MLNRangeNumericalType;
import com.rapidminer.operator.modelling.model.types.MLNSpecifiedNumericalType;
import com.rapidminer.operator.modelling.model.types.MLNTypeArgument;
import com.rapidminer.operator.modelling.model.types.MLNTypeContainer;

public class TuffyMLNBuilder {
	private static final String LIST_SEPARATOR = ",";
	private MLNModel mlnModel;
	private Boolean containsQuantification=false;
	
	private static String[] builtinPredicates = {"=","!=", ">", "<", ">=", "<="};
	private static String[] builtinFunctions = {"+","-","*","/"};
	
	private static int varCounter = 0;
	
	public TuffyMLNBuilder(MLNModel mlnModel) throws MLNException {
		this.mlnModel = mlnModel;
		convertConstraintsToExcl();
	}
	
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

	
	//Constraints must exist in separate formulas and only refer to one variable at a time.
	private void convertConstraintsToExcl() throws MLNException {
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
	
	public String buildPredicateDeclaration(MLNPredicate predicate) throws MLNException {
		if (!isBuiltinPredicate(predicate.getName())) {
			String star;
			String str, name;
			if (predicate.getClosedWorldType().equals(MLNClosedWorldType.Query)) {
				star = "";
			} else {
				star = "*";
			}
			if (predicate.getName().length()>1)
				name = predicate.getName().substring(0, 1).toLowerCase()+predicate.getName().substring(1);
			else
				name = predicate.getName();
			str = ConverterUtilities.buildString(star, name, parenthesize(
							typeArgumentsToString(predicate.getArguments())));
			return str;
		} else
			return "";
	}
	
	public String buildQueryPredicateDeclaration(MLNPredicate predicate) throws MLNException {
		String star;
		String str, name;
		Map<MLNTypeArgument, Boolean> map = new HashMap<MLNTypeArgument, Boolean>();
		star = "";
		for (MLNTypeArgument arg: predicate.getArguments()) {
			map.put(arg, arg.isExcl());
			arg.setExcl(false);
		}
		if (predicate.getName().length()>1)
			name = predicate.getName().substring(0, 1).toLowerCase()+predicate.getName().substring(1);
		else
			name = predicate.getName();
		str = ConverterUtilities.buildString(star, name, parenthesize(
						typeArgumentsToString(predicate.getArguments())));
		for (MLNTypeArgument arg: predicate.getArguments()) {
			arg.setExcl(map.get(arg));
		}
		return str;
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
		String name;
		if (!isBuiltinFunction(function.getName())) {
			if (function.getName().length()>1)
				name = function.getName().substring(0, 1).toLowerCase()+function.getName().substring(1);
			else
				name = function.getName();
			return ConverterUtilities.buildString(name, parenthesize(
							typeArgumentsToString(function.getArguments())));
		} else
			return "";
	}
	
	public String groundAtomToString(MLNGroundAtom groundAtom) throws MLNException {
		String negatedSign = (groundAtom.isNegated())?ConverterUtilities.EXCL:"";
		String name;
		if (groundAtom.getPredicate().getName().length()>1)
			name = groundAtom.getPredicate().getName().substring(0, 1).toLowerCase()+groundAtom.getPredicate().getName().substring(1);
		else
			name = groundAtom.getPredicate().getName();
		return ConverterUtilities.buildString(negatedSign, name, parenthesize(
				mlnGroundArgumentsToString(groundAtom.getArguments())));
	}
	
	public String functionDefinitionToString(MLNFunctionDefinition functionDefinition) 
			throws MLNException {
		String name;
		if (functionDefinition.getFunction().getName().length()>1)
			name = functionDefinition.getFunction().getName().substring(0, 1).toLowerCase()+functionDefinition.getFunction().getName().substring(1);
		else
			name = functionDefinition.getFunction().getName();
		return ConverterUtilities.buildString(ExampleSetBuilder.functionReturnValueToString(functionDefinition.getReturnValue()), " = ",
				name, parenthesize(
						mlnGroundArgumentsToString(functionDefinition.getArguments())));
	}
	
	public String buildFormula(MLNFormula formula, boolean convertLEconstraints, boolean removeUnsupportedConstraints) 
			throws MLNException {
		setContainsQuantification(false);
		if (formula.getUtilityWeight()!=null) {
			MLNError.UTILITY_WEIGHTS.exception();
		}
		List<MLNFormula> formulas = (new CNFConverter(mlnModel)).formulaToCNF(formula);
		List<String> formulaStrings = new ArrayList<String>();
		String pfStr;
		for (MLNFormula mlnFormula : formulas) {
			pfStr = plainFormulaToString(mlnFormula.getPlainFormula(), this, convertLEconstraints, removeUnsupportedConstraints);
			if (!pfStr.equals(""))
				formulaStrings.add(ConverterUtilities.buildString(buildWeightString(
						mlnFormula.getProbabilityWeight(),mlnFormula.isHardRule()),
						plainFormulaToString(mlnFormula.getPlainFormula(), this, convertLEconstraints, removeUnsupportedConstraints),
						(mlnFormula.isHardRule()&&!containsQuantification)?".":""));
		}
		return ConverterUtilities.listToString(formulaStrings, "\n");
	}
	
	private String buildWeightString(MLNWeight probabilityWeight, boolean isHardRule) {
		boolean p=(probabilityWeight!=null);
		boolean v=p?(probabilityWeight.getVarWeight()!=null?true:false):false;
		//Defaults to 1 for learning
		String probabilityWeightString = p?probabilityWeight.toString():isHardRule?"":"1.0";
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
	
	public String mlnGroundArgumentsToString(List<MLNGroundArgument> arguments) throws MLNException {
		List<String> argString = new ArrayList<String>();
		for (MLNGroundArgument argument: arguments) {
			if (argument.getConstant() != null) {
				argString.add(argument.getConstant().getName());
			} else if (argument.getNumber() != null) {
				argString.add(argument.getNumber().toString());
			} else if (argument.getGroundAtom() != null) {
				argString.add(groundAtomToString(argument.getGroundAtom()));
			} else if (argument.getGroundFunctionApplication() != null) {
				argString.add(groundFunctionApplicationToString(argument.getGroundFunctionApplication()));
			}
		}
		return ConverterUtilities.listToString(argString, LIST_SEPARATOR);
	}
	
	public String groundFunctionApplicationToString(MLNGroundFunctionApplication groundFunctionAppl) 
			throws MLNException {
		return ConverterUtilities.buildString(groundFunctionAppl.getFunction().getName(),
				"(",mlnGroundArgumentsToString(groundFunctionAppl.getArguments()),")");
	}
	

	public static String plainFormulaToString( MLNPlainFormula formula, TuffyMLNBuilder builder,
			boolean convertLEconstraints, boolean removeUnsupportedConstraints) throws MLNException  {
		if (formula.getPredicateApplication() != null) {
			return predicateApplToString(formula.getPredicateApplication());
		} else if (formula.getFunctionApplication() != null) {
			return functionApplToString(formula.getFunctionApplication());
		} else if (formula.getOperatorApplication() != null) {
			return operatorApplToString(formula.getOperatorApplication(), builder, convertLEconstraints, removeUnsupportedConstraints);
		} else if (formula.getQuantification() != null) {
			return quantificationToString(formula.getQuantification(),builder, convertLEconstraints, removeUnsupportedConstraints);
		} else {
			return null;
		}
	}
	
	private static String predicateApplToString(MLNPredicateApplication predicateAppl) throws MLNException {
		StringBuilder sb = new StringBuilder();
		String name;
		if (predicateAppl.getPredicate().getName().length()>1)
			name = predicateAppl.getPredicate().getName().substring(0, 1).toLowerCase()+predicateAppl.getPredicate().getName().substring(1);
		else
			name = predicateAppl.getPredicate().getName();
		if (!isBuiltinPredicate(name)) {
			sb.append(name);
			sb.append("(");
			sb.append(mlnVarArgumentsToString(predicateAppl.getArguments()));
			sb.append(")");
		} else {
			sb.append("(");
			sb.append(mlnVarArgumentsToString(ConverterUtilities.compose(predicateAppl.getArguments().get(0)))+" ");
			sb.append(name+" ");
			sb.append(mlnVarArgumentsToString(ConverterUtilities.compose(predicateAppl.getArguments().get(0))));
			sb.append(")");
		}
		return sb.toString();
	}
	
	private static String functionApplToString(MLNFunctionApplication functionAppl) throws MLNException {
		StringBuilder sb = new StringBuilder();
		String name;
		if (functionAppl.getFunction().getName().length()>1)
			name = functionAppl.getFunction().getName().substring(0, 1).toLowerCase()+functionAppl.getFunction().getName().substring(1);
		else
			name = functionAppl.getFunction().getName();
		if (isBuiltinFunction(name)) {
			sb.append("(");
			sb.append(mlnVarArgumentsToString(ConverterUtilities.compose(functionAppl.getArguments().get(0)))+" ");
			sb.append(name+" ");
			sb.append(mlnVarArgumentsToString(ConverterUtilities.compose(functionAppl.getArguments().get(0))));
			sb.append(")");
		} else {
			sb.append(name);
			sb.append("(");
			sb.append(mlnVarArgumentsToString(functionAppl.getArguments()));
			sb.append(")");
		}
		return sb.toString();
	}
	
	private static String mlnVarArgumentsToString(List<MLNVarArgument> arguments) 
			throws MLNException {
		List<String> argString = new ArrayList<String>();
		for (MLNVarArgument argument: arguments) {
			if (argument.getConstant() != null) {
				argString.add((argument.isPlus()?"+":"")+argument.getConstant().getName());
			} else if (argument.getVariable() != null) {
				argString.add((argument.isPlus()?"+":"")+argument.getVariable().getName());
			} else if (argument.getNumber() != null) {
				argString.add((argument.isPlus()?"+":"")+argument.getNumber().toString());
			} else if (argument.getPredicateApplication() != null) {
				argString.add(predicateApplToString(argument.getPredicateApplication()));
			} else if (argument.getFunctionApplication() != null) {
				argString.add(functionApplToString(argument.getFunctionApplication()));
			}
		}
		return ConverterUtilities.listToString(argString, LIST_SEPARATOR);
	}
	
	
	private static String operatorApplToString(MLNOperatorApplication operatorAppl,
			TuffyMLNBuilder builder, boolean convertLEconstraints,
			boolean removeUnsupportedConstraints) throws MLNException {
		int position = operatorAppl.getOperator().getPosition();
		if (MLNFormulaOperator.PREFIX==position)
			return prefixOperatorApplToString(operatorAppl,  builder, convertLEconstraints, removeUnsupportedConstraints);
		if (MLNFormulaOperator.INFIX==position)
			return infixOperatorApplToString(operatorAppl, builder, convertLEconstraints, removeUnsupportedConstraints);
		if (MLNFormulaOperator.POSTFIX==position)
			return postfixOperatorApplToString(operatorAppl, builder, convertLEconstraints, removeUnsupportedConstraints);
		if (MLNFormulaOperator.SURROUNDING==position)
			return surroundingOperatorApplToString(operatorAppl, builder, convertLEconstraints,
					removeUnsupportedConstraints);
		return null;
	}
	
		
	private static String prefixOperatorApplToString(MLNOperatorApplication operatorAppl, 
			TuffyMLNBuilder builder, boolean convertLEconstraints, boolean removeUnsupportedConstraints) throws MLNException{
		StringBuilder sb = new StringBuilder();
		sb.append(operatorAppl.getOperator().getName()+" ");
		sb.append(
				plainFormulaToString(operatorAppl.getArguments().get(0), builder, convertLEconstraints, 
				removeUnsupportedConstraints));
		return sb.toString();
	}
	
	private static String infixOperatorApplToString(MLNOperatorApplication operatorAppl,
			TuffyMLNBuilder builder, boolean convertLEconstraints, boolean removeUnsupportedConstraints) throws MLNException{
		if (operatorAppl.getOperator().getArity() == 2) {
			StringBuilder sb = new StringBuilder();
			sb.append(plainFormulaToString(operatorAppl.getArguments().get(0), builder, convertLEconstraints, 
					removeUnsupportedConstraints));
			sb.append(" "+operatorAppl.getOperator().getName()+" ");
			sb.append(plainFormulaToString(operatorAppl.getArguments().get(1), builder, convertLEconstraints,
					removeUnsupportedConstraints));
			return sb.toString();
		} else {
			throw new MLNException("Operator is infix but does not have arity = 2.");
		}
	}
	
	private static String postfixOperatorApplToString(MLNOperatorApplication operatorAppl,
			TuffyMLNBuilder builder, boolean convertLEconstraints, boolean removeUnsupportedConstraints) throws MLNException{
		StringBuilder sb = new StringBuilder();
		sb.append(plainFormulaToString(
				operatorAppl.getArguments().get(0), builder, convertLEconstraints, removeUnsupportedConstraints));
		sb.append(" "+operatorAppl.getOperator().getName());
		return sb.toString();
	}
	
	private static String surroundingOperatorApplToString(MLNOperatorApplication operatorAppl,
			TuffyMLNBuilder builder, boolean convertLEconstraints, boolean removeUnsupportedConstraints) throws MLNException{
		if (operatorAppl.getOperator().getClosing()==null) {
			MLNError.SURROUNDING_NO_CLOSING.exception();
		}
		StringBuilder sb = new StringBuilder();
		sb.append(operatorAppl.getOperator().getName());
		sb.append(" "+plainFormulaToString(operatorAppl.getArguments().get(0), builder, convertLEconstraints,
				removeUnsupportedConstraints)+" ");
		sb.append(operatorAppl.getOperator().getClosing());
		return sb.toString();
	}
	
	private static String quantificationToString(MLNQuantification quantification,
			TuffyMLNBuilder builder, boolean convertLEconstraints, boolean removeUnsupportedConstraints) throws MLNException{
		String plainFormula;
		if ((quantification.geteQuant())|| (quantification.getuQuant())) {
			String quant;
			if (quantification.geteQuant())
				quant = MLNQuantification.E_QUANT_NAME;
			else
				quant = MLNQuantification.U_QUANT_NAME;
			builder.setContainsQuantification(true);
			return ConverterUtilities.buildString(quant, ConverterUtilities.SPACE, 
					ConverterUtilities.listToString(ConverterUtilities.namedMlnObjectsToStrings(quantification.getArguments()),","),
					ConverterUtilities.SPACE,plainFormulaToString(quantification.getPlainFormula(),
							builder, convertLEconstraints, removeUnsupportedConstraints));
		} else {
			if (quantification.getArguments()!=null && 
					quantification.getArguments().size()==1 && quantification.getNumber()==1 &&  
				(quantification.getRelation().equals(MLNRelation.EQ))){
				return "";
			} else if (quantification.getArguments()!=null && 
						quantification.getArguments().size()==1 && quantification.getNumber()==1 &&  
					(quantification.getRelation().equals(MLNRelation.LE) && convertLEconstraints)) {
				plainFormula = plainFormulaToString(quantification.getPlainFormula(), builder, convertLEconstraints,
						removeUnsupportedConstraints);
				plainFormula = ConverterUtilities.buildString("!"+
					plainFormula +" v "+
						"!("+quantification.getArguments().get(0).getName()+" = cEV"+
					varCounter+") v !"+plainFormula.replace(quantification.getArguments().get(0).getName(), 
							"cEV"+varCounter)+"");
				varCounter++;
				builder.setContainsQuantification(false);
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

	private void setContainsQuantification(Boolean containsQuantification) {
		this.containsQuantification = containsQuantification;
	}
	
	private static String typeArgumentsToString(List<MLNTypeArgument> typeArguments)  throws MLNException  {
		List<String> arguments = new ArrayList<String>();
		if (typeArguments != null) {
			for (MLNTypeArgument typeArgument: typeArguments) {
				arguments.add(typeArgument.getTypeContainer().getName()
						+(typeArgument.isExcl()?"!":""));
			}
			return ConverterUtilities.listToString(arguments, LIST_SEPARATOR);
		} else {
			return null;
		}
	}
}