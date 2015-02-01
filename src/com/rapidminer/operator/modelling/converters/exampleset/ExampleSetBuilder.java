package com.rapidminer.operator.modelling.converters.exampleset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import com.rapidminer.example.ExampleSet;
import com.rapidminer.operator.modelling.configuration.fixed.MLNException;
import com.rapidminer.operator.modelling.converters.exampleset.model.ExampleSetBuilderOntology;
import com.rapidminer.operator.modelling.converters.exampleset.model.ExampleSetModel;
import com.rapidminer.operator.modelling.converters.exampleset.model.ExampleSetType;
import com.rapidminer.operator.modelling.converters.utilities.ConverterUtilities;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduceException;
import com.rapidminer.operator.modelling.model.MLNClosedWorldType;
import com.rapidminer.operator.modelling.model.MLNFormula;
import com.rapidminer.operator.modelling.model.MLNFunction;
import com.rapidminer.operator.modelling.model.MLNFunctionApplication;
import com.rapidminer.operator.modelling.model.MLNFunctionDefinition;
import com.rapidminer.operator.modelling.model.MLNFunctionReturnValue;
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
import com.rapidminer.operator.modelling.model.MLNVarArgument;
import com.rapidminer.operator.modelling.model.MLNWeight;
import com.rapidminer.operator.modelling.model.operators.MLNFormulaOperator;
import com.rapidminer.operator.modelling.model.operators.MLNOperatorApplication;
import com.rapidminer.operator.modelling.model.types.MLNConstantType;
import com.rapidminer.operator.modelling.model.types.MLNRangeNumericalType;
import com.rapidminer.operator.modelling.model.types.MLNSpecifiedNumericalType;
import com.rapidminer.operator.modelling.model.types.MLNTypeArgument;
import com.rapidminer.operator.modelling.model.types.MLNTypeContainer;

public class ExampleSetBuilder {
	private ExampleSetModel exampleSetModel;
	private static final String LIST_SEPARATOR = ",";
	private List<ExampleSetType> types;
	
	protected ExampleSetBuilder(List<ExampleSetType> types) {
		this(types, null);
	}
	
	protected ExampleSetBuilder(List<ExampleSetType> types, Double id) {
		exampleSetModel  = new ExampleSetModel(types, id);
		this.types = types;
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
	
	private static String[] builtinPredicates = {"=","!=", ">", "<", ">=", "<="};
	private static String[] builtinFunctions = {"+","-","*","/"};
	
	public LinkedHashMap<ExampleSetType, ExampleSet> buildExampleSets(MLNModel mlnModel) 
			throws MLNException{
		if (mlnModel.getId()!=null)
			exampleSetModel.setId(mlnModel.getId());
		if (types.contains(ExampleSetType.GroundFormula))
			buildGroundFormulaExampleSet(mlnModel);
		if (types.contains(ExampleSetType.ProbabilityStatement))
			buildProbabilityStatementExampleSets(mlnModel);
		if (types.contains(ExampleSetType.TypeDecl))
			buildTypeExampleSet(mlnModel);
		if (types.contains(ExampleSetType.PredicateDecl))
			buildPredicateExampleSet(mlnModel);
		if (types.contains(ExampleSetType.FunctionDecl))
			buildFunctionExampleSet(mlnModel);
		if (types.contains(ExampleSetType.Formula))
			buildFormulaExampleSet(mlnModel);
		if (types.contains(ExampleSetType.QueryPredicateDecl))
			buildQueryPredicateExampleSet(mlnModel);
		return getExampleSetMap();
	}

	private void buildProbabilityStatementExampleSets(MLNModel mlnModel)  throws MLNException {
		for (MLNProbabilityStatement statement: mlnModel.getAll(MLNProbabilityStatement.class)) {
			addProbabilitySatement(statement);
		}
	}
	
	private void buildTypeExampleSet(MLNModel mlnModel)   throws MLNException {
		for (MLNTypeContainer type : mlnModel.getAll(MLNTypeContainer.class)) {
			addTypeDecl(type);
		}
	}
	
	private void buildPredicateExampleSet(MLNModel mlnModel)  throws MLNException {
		for (MLNPredicate predicate : mlnModel.getAll(MLNPredicate.class)) {
			addPredicateDecl(predicate);
		}
	}
	
	private void buildQueryPredicateExampleSet(MLNModel mlnModel)  throws MLNException {
		for (MLNPredicate predicate : mlnModel.getAll(MLNPredicate.class)) {
			addQueryPredicateDecl(predicate);
		}
	}
	
	
	private void buildFormulaExampleSet(MLNModel mlnModel) throws MLNException{
		for (MLNFormula formula: mlnModel.getAll(MLNFormula.class)) {
			addFormula(formula);
		}
	}
	
	private void buildFunctionExampleSet(MLNModel mlnModel)  throws MLNException {
		for (MLNFunction function: mlnModel.getAll(MLNFunction.class)) {
			addFunctionDecl(function);
		}
	}
	
	private void buildGroundFormulaExampleSet(MLNModel mlnModel)  throws MLNException  {
		for (MLNGroundFormula groundFormula: mlnModel.getAll(MLNGroundFormula.class)) {
			addGroundFormula(groundFormula);
		}
	}
	
	private LinkedHashMap<ExampleSetType, ExampleSet> getExampleSetMap() {
		return exampleSetModel.getExampleSets();
	}
	
	public void addTypeDecl(MLNTypeContainer type)  throws MLNException  {
		String[] vals = new String[2];
		vals[0] = type.getName();
		vals[1] = typeValuesToString(type);
		try {
			exampleSetModel.addDataRow(ExampleSetType.TypeDecl, 
					vals);
		} catch (MapReduceException e) {
			throw new MLNException(e.getMessage());
		}
	}
	
	public static String typeValuesToString(MLNTypeContainer type)  throws MLNException  {
		if (type.getConstantType() != null) {
			return constantTypeValuesToString(type.getConstantType());
		} else if (type.getSpecifiedNumericalType() != null) {
			return specifiedNumericalTypeValuesToString(type.getSpecifiedNumericalType());
		} else if (type.getRangeNumericalType() != null) {
			return rangeNumericalTypeValuesToString(type.getRangeNumericalType());
		}
		return null;
	}
	
	public static String constantTypeValuesToString(MLNConstantType type)  throws MLNException {
		return ConverterUtilities.listToString(ConverterUtilities
				.namedMlnObjectsToStrings(type.getConstants()), LIST_SEPARATOR);
	}
	
	public static String specifiedNumericalTypeValuesToString(MLNSpecifiedNumericalType type)  
			throws MLNException  {
		return ConverterUtilities.listToString(ConverterUtilities
				.doubleListToString(type.getNumbers()), LIST_SEPARATOR);
	}
	
	public static String rangeNumericalTypeValuesToString(MLNRangeNumericalType type) {
		return type.getLowerBound().toString() + ExampleSetBuilderOntology.DOTS +
				type.getUpperBound().toString();
	}

	public void addQueryPredicateDecl(MLNPredicate predicate)  throws MLNException {
		String[] values = new String[3];
		values[0] = predicate.getName();
		values[1] = typeArgumentsToString(predicate.getArguments());
		values[2] = MLNClosedWorldType.Query.name();
		try {
			exampleSetModel.addDataRow(ExampleSetType.QueryPredicateDecl, 
					values);
		} catch (MapReduceException e) {
			throw new MLNException(e.getMessage());
		}
	}
	
	public void addPredicateDecl(MLNPredicate predicate)  throws MLNException {
		if (!isBuiltinPredicate(predicate.getName())) {
			String[] values = new String[3];
			values[0] = predicate.getName();
			values[1] = typeArgumentsToString(predicate.getArguments());
			values[2] = predicate.getClosedWorldType().name()+"";
			try {
				exampleSetModel.addDataRow(ExampleSetType.PredicateDecl, 
						values);
			} catch (MapReduceException e) {
				throw new MLNException(e.getMessage());
			}
		}
	}

	public void addFunctionDecl(MLNFunction function)  throws MLNException  {
		if (!isBuiltinFunction(function.getName())) {
			String[] values = new String[3];
			if (function.getReturnType()!=null && function.getReturnType().getTypeContainer()!=null)
				values[0] = function.getReturnType().getTypeContainer().getName();
			else
				values[0] = "";
			values[1] = function.getName();
			values[2] = typeArgumentsToString(function.getArguments());
			try {
				exampleSetModel.addDataRow(ExampleSetType.FunctionDecl, 
						values);
			} catch (MapReduceException e) {
				throw new MLNException(e.getMessage());
			}
		}
	}
	
	public static String typeArgumentsToString(List<MLNTypeArgument> typeArguments)  throws MLNException  {
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

	public void addFormula(MLNFormula formula) throws MLNException{
		String[] values = new String[4];
		MLNWeight probWeight = formula.getProbabilityWeight();
		MLNWeight utilWeight = formula.getUtilityWeight();
		values[0] = (probWeight==null)?null:
			probWeight.toString();
		values[1] = (utilWeight==null)?null:
			utilWeight.toString();
		values[2] = plainFormulaToString(formula.getPlainFormula());
		values[3] = Boolean.toString(formula.isHardRule());
		try {
			exampleSetModel.addDataRow(ExampleSetType.Formula, 
					values);
		} catch (MapReduceException e) {
			throw new MLNException(e.getMessage());
		}
	}
	
	private static String plainFormulasToString(List<MLNPlainFormula> formulas) throws MLNException{
		List<String> formulaStrings = new ArrayList<String>();
		for (MLNPlainFormula formula: formulas) {
			formulaStrings.add(plainFormulaToString(formula));
		}
		return ConverterUtilities.listToString(formulaStrings, LIST_SEPARATOR);
	}
	
	public static String plainFormulaToString(MLNPlainFormula formula) throws MLNException {
		if (formula.getPredicateApplication() != null) {
			return predicateApplToString(formula.getPredicateApplication());
		} else if (formula.getFunctionApplication() != null) {
			return functionApplToString(formula.getFunctionApplication());
		} else if (formula.getOperatorApplication() != null) {
			return operatorApplToString(formula.getOperatorApplication());
		} else if (formula.getQuantification() != null) {
			return quantificationToString(formula.getQuantification());
		} else {
			return null;
		}
	}
	
	private static String predicateApplToString(MLNPredicateApplication predicateAppl)  throws MLNException {
		return ConverterUtilities.buildString(predicateAppl.getPredicate().getName(),
				"(",varArgumentsToString(predicateAppl.getArguments()),")");
	}
	
	private static String functionApplToString(MLNFunctionApplication functionAppl)  throws MLNException {
		return ConverterUtilities.buildString(functionAppl.getFunction().getName(),
				"(",varArgumentsToString(functionAppl.getArguments()),")");
	}
	
	private static String varArgumentsToString(List<MLNVarArgument> arguments)  throws MLNException {
		List<String> argString = new ArrayList<String>();
		for (MLNVarArgument argument: arguments) {
			if (argument.getConstant() != null) {
				argString.add((argument.isPlus()?"+":"")+argument.getConstant().getName());
			} else if (argument.getVariable() != null) {
				argString.add((argument.isPlus()?"+":"")+argument.getVariable().getName());
			} else if (argument.getNumber() != null) {
				argString.add((argument.isPlus()?"+":"")+argument.getNumber().toString());
			} else if (argument.getPredicateApplication() != null) {
				argString.add((argument.isPlus()?"+":"")+predicateApplToString(argument.getPredicateApplication()));
			} else if (argument.getFunctionApplication() != null) {
				argString.add((argument.isPlus()?"+":"")+functionApplToString(argument.getFunctionApplication()));
			}
		}
		return ConverterUtilities.listToString(argString, LIST_SEPARATOR);
	}
	
	private static String operatorApplToString(MLNOperatorApplication operatorAppl) throws MLNException {
		int position = operatorAppl.getOperator().getPosition();
		if (MLNFormulaOperator.PREFIX==position)
			return prefixOperatorApplToString(operatorAppl);
		if (MLNFormulaOperator.INFIX==position)
			return infixOperatorApplToString(operatorAppl);
		if (MLNFormulaOperator.POSTFIX==position)
			return postfixOperatorApplToString(operatorAppl);
		if (MLNFormulaOperator.SURROUNDING==position)
			return surroundingOperatorApplToString(operatorAppl);
		return null;
	}
		
	private static String processOperatorArguments(MLNOperatorApplication operatorAppl) throws MLNException{
		if (operatorAppl.getOperator().getArity() == 1) {
			return plainFormulaToString(operatorAppl.getArguments().get(0));
		} else {
			return "("+plainFormulasToString(
					operatorAppl.getArguments())+")";
		}
	}
		
	private static String prefixOperatorApplToString(MLNOperatorApplication operatorAppl) throws MLNException{
		StringBuilder sb = new StringBuilder();
		sb.append(operatorAppl.getOperator().getName()+" ");
		sb.append(processOperatorArguments(operatorAppl));
		return sb.toString();
	}
	
	private static String infixOperatorApplToString(MLNOperatorApplication operatorAppl) throws MLNException{
		if (operatorAppl.getOperator().getArity() == 2) {
			StringBuilder sb = new StringBuilder();
			sb.append(plainFormulaToString(operatorAppl.getArguments().get(0)));
			sb.append(" "+operatorAppl.getOperator().getName()+" ");
			sb.append(plainFormulaToString(operatorAppl.getArguments().get(1)));
			return sb.toString();
		} else {
			throw new MLNException("Operator is infix but does not have arity = 2.");
		}
	}
	
	private static String postfixOperatorApplToString(MLNOperatorApplication operatorAppl) throws MLNException{
		StringBuilder sb = new StringBuilder();
		sb.append(processOperatorArguments(operatorAppl));
		sb.append(" "+operatorAppl.getOperator().getName());
		return sb.toString();
	}
	
	private static String surroundingOperatorApplToString(MLNOperatorApplication operatorAppl) throws MLNException{
		if (operatorAppl.getOperator().getClosing()==null) {
			throw new MLNException("Operator is surrounding but does not have a closing.");
		}
		StringBuilder sb = new StringBuilder();
		sb.append(operatorAppl.getOperator().getName()+" ");
		sb.append(processOperatorArguments(operatorAppl));
		sb.append(" "+operatorAppl.getOperator().getClosing());
		return sb.toString();
	}
	
	private static String quantificationToString(MLNQuantification quantification) throws MLNException{
		String quant;
		StringBuilder sb;
		String s;
		if ((quantification.geteQuant()) || (quantification.getuQuant())) {
			if (quantification.geteQuant())
				quant = MLNQuantification.E_QUANT_NAME;
			else
				quant = MLNQuantification.U_QUANT_NAME;
			s = ConverterUtilities.buildString(quant, ConverterUtilities.SPACE, 
					ConverterUtilities.listToString(ConverterUtilities.namedMlnObjectsToStrings(quantification.getArguments()),","),
					ConverterUtilities.SPACE,plainFormulaToString(quantification.getPlainFormula()));
			return s;
		} else {
			sb = new StringBuilder();
			sb.append("|");
			for (String arg: ConverterUtilities.namedMlnObjectsToStrings(quantification.getArguments()))
				sb.append(arg);
			sb.append("|"+" ");
			sb.append(plainFormulaToString(quantification.getPlainFormula()));
			if (quantification.getRelation() != null)
				sb.append(" "+quantification.getRelation().getText()+" "+quantification.getNumber());
			s = sb.toString();
			return sb.toString();
		}
	}

	
	public static String[] buildFunctionDefinitionText(MLNFunctionDefinition functionDefinition)  
			throws MLNException {
		String[] values = new String[3];
		values[0] = functionReturnValueToString(functionDefinition.getReturnValue());
		values[1] = functionDefinition.getFunction().getName();
		values[2] = groundArgumentsToString(functionDefinition.getArguments());
		return values;
	}
	
	public static String functionReturnValueToString(MLNFunctionReturnValue returnValue) {
		if (returnValue.getConstant() != null) {
			return returnValue.getConstant().getName();
		} else if (returnValue.getNumber() != null) {
			return returnValue.getNumber().toString();
		} else {
			return null;
		}
	}
	
	public void addGroundFormula(MLNGroundFormula groundFormula)  throws MLNException {
		try {
			exampleSetModel.addDataRow(ExampleSetType.GroundFormula, 
					buildGroundFormulaText(groundFormula));
		} catch (MapReduceException e) {
			throw new MLNException(e.getMessage());
		}
	}
	
	public static String[] buildGroundFormulaText(MLNGroundFormula groundFormula)  throws MLNException {
		MLNGroundAtom groundAtom = groundFormula.getGroundAtom();
		MLNFunctionDefinition functionDefinition = groundFormula.getFunctionDefinition();
		String[] values = new String[3];
		values[0] = (functionDefinition!=null)?functionReturnValueToString(functionDefinition.getReturnValue()):"";
		values[1] = groundFormulaToString(groundFormula);
		values[2] = (groundAtom!=null)?Boolean.toString(groundAtom.isNegated()):"";
		return values;
	}
	
	public static String groundFormulaToString(MLNGroundFormula groundFormula)  throws MLNException {
		MLNGroundAtom groundAtom = groundFormula.getGroundAtom();
		MLNFunctionDefinition functionDefinition = groundFormula.getFunctionDefinition();
		if (groundAtom!=null) 
			return groundAtomToString(groundAtom);
		else if (functionDefinition!=null)
			return functionDefinitionToString(functionDefinition);
		else 
			return null;
	}

	private static String functionDefinitionToString(MLNFunctionDefinition functionDefinition) 
			 throws MLNException {
		return ConverterUtilities.buildString(functionReturnValueToString(functionDefinition.getReturnValue())," = ",
				functionDefinition.getFunction().getName(),
				ConverterUtilities.parenthesize(groundArgumentsToString(functionDefinition.getArguments())));
	}
	
	
	private static String groundAtomToString(MLNGroundAtom groundAtom)  throws MLNException {
		return ConverterUtilities.buildString(groundAtom.getPredicate().getName(),
				ConverterUtilities.parenthesize(groundArgumentsToString(groundAtom.getArguments())));
	}
	
	private static String groundFunctionApplicationToString(MLNGroundFunctionApplication groundFunctionApplication)
			 throws MLNException {
		return ConverterUtilities.buildString(groundFunctionApplication.getFunction().getName(),
				ConverterUtilities.parenthesize(groundArgumentsToString(groundFunctionApplication.getArguments())));
	}
	
	
	
	public static String groundArgumentsToString(List<MLNGroundArgument> arguments)  throws MLNException {
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
	
	public void addProbabilitySatement(MLNProbabilityStatement statement)  throws MLNException {
		try {
			exampleSetModel.addDataRow(ExampleSetType.ProbabilityStatement, 
					buildProbabilityStatementText(statement));
		} catch (MapReduceException e) {
			throw new MLNException(e.getMessage());
		}
	}
	
	private String[] buildProbabilityStatementText(MLNProbabilityStatement statement)  throws MLNException {
		String [] values;
		values = Arrays.copyOf(buildGroundFormulaText(statement.getGroundFormula()), 4);
		values[3] = (statement.getProbability()!=null)?statement.getProbability().toString():"";
		return values;
	}
	
}
