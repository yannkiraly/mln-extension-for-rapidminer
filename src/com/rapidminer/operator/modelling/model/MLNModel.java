package com.rapidminer.operator.modelling.model;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.rapidminer.operator.ResultObjectAdapter;
import com.rapidminer.operator.modelling.model.operators.MLNFormulaOperator;
import com.rapidminer.operator.modelling.model.operators.MLNOperatorApplication;
import com.rapidminer.operator.modelling.model.types.MLNTypeArgument;
import com.rapidminer.operator.modelling.model.types.MLNTypeContainer;

public class MLNModel extends ResultObjectAdapter {
	
	private static final long serialVersionUID = -5105865180042973L;
	
	private Map<String, MLNFormulaOperator> mlnOperators;
	
	private Class<?>[] mlnObjectClasses = {MLNConstant.class, MLNFormula.class,
			MLNFunction.class, MLNFunctionApplication.class, MLNFunctionDefinition.class,
			MLNGroundAtom.class,
			MLNOperatorApplication.class, MLNPlainFormula.class, MLNPredicate.class,
			MLNPredicateApplication.class, MLNQuantification.class,
			MLNVariable.class, MLNTypeContainer.class,
			MLNVarArgument.class, MLNGroundArgument.class, MLNFormulaOperator.class, MLNTypeArgument.class,
			MLNProbabilityStatement.class, MLNWeight.class, MLNGroundFunctionApplication.class, MLNGroundFormula.class};
	
	private Map<Class<?>, List<MLNObject>> mlnUnnamedObjects;
	private Map<Class<?>, Map<String, MLNNamedObject>> mlnNamedObjects;
	private List<MLNFormula> weightedFormulas;
	
	private List<MLNPredicate> unusedPredicates;
	private List<MLNFormula> quantifiedFormulas;
	
	public static final String EQ_SYMBOL = "=";
	public static final String NOT_SYMBOL = "!";
	public static final String IFF_SYMBOL = "<=>";
	public static final String IMPLIES_SYMBOL = "=>";
	public static final String OR_SYMBOL = "v";
	public static final String AND_SYMBOL = "^";
	private static final String SQUARE_BRACKETS_CLOSING = "]";
	private static final String PARENTHESES_CLOSING = ")";
	public static final String SQUARE_BRACKETS_SYMBOL = "[";
	public static final String PARENTHESES_SYMBOL = "(";
	
	private Double id;
	
	public MLNModel (Double id) throws InstantiationException, IllegalAccessException {
		this();
		this.id = id;
	}
	
	public MLNModel() throws InstantiationException, IllegalAccessException{
		buildMaps();
		buildOperators();
		unusedPredicates = new ArrayList<MLNPredicate>();
		weightedFormulas = new ArrayList<MLNFormula>();
		quantifiedFormulas = new ArrayList<MLNFormula>();
	}
	
	@SuppressWarnings("unchecked")
	public MLNModel integrateModel(MLNModel mlnModel)  {
		Class<? extends MLNNamedObject> mlnNamedObjectClass;
		Class<? extends MLNObject> mlnObjectClass;
		if (!(mlnModel.equals(this))) {
			Map<Class<?>, List<MLNObject>> mlnObjects = mlnModel.getMlnObjects();
			Map<Class<?>, Map<String, MLNNamedObject>> mlnNamedObjects = mlnModel.getMlnNamedObjects();
			for (Class<?> mlnClass: mlnObjectClasses) {
				if (MLNNamedObject.class.isAssignableFrom(mlnClass)) {
					mlnNamedObjectClass = (Class<? extends MLNNamedObject>) mlnClass;
					for (Object obj : mlnNamedObjects.get(mlnClass).values()) {
						addMlnNamedObject((mlnNamedObjectClass).cast(obj));
					}
				}  else {
					mlnObjectClass = (Class<? extends MLNObject>) mlnClass;
					for (Object obj: mlnObjects.get(mlnClass)) {
						addMlnObject((mlnObjectClass).cast(obj));
					}
				}
			}
		}
		return mlnModel;
	}
	
	private boolean searchForClass(Class<? extends MLNObject> mlnClass) {
		boolean contains = false;
		for (Class<?> mlnClassIter : mlnObjectClasses) {
			if (mlnClassIter.equals(mlnClass)) {
				contains = true;
			}
		}
		return contains;
	}
	
	private void buildOperators()  {
		if (mlnOperators == null) {
			mlnOperators = new HashMap<String, MLNFormulaOperator>();
		}
		mlnOperators.put(AND_SYMBOL, addMlnNamedObject(new MLNFormulaOperator(AND_SYMBOL, 2, MLNFormulaOperator.AND_PREC, 
				MLNFormulaOperator.INFIX)));
		mlnOperators.put(MLNRelation.EQ.getText(),addMlnNamedObject(new MLNFormulaOperator(MLNRelation.EQ.getText(), 2, MLNFormulaOperator.EQ_PREC, 
				MLNFormulaOperator.INFIX)));
		mlnOperators.put(IMPLIES_SYMBOL,addMlnNamedObject(new MLNFormulaOperator(IMPLIES_SYMBOL, 2, MLNFormulaOperator.IMPLIES_PREC, 
				MLNFormulaOperator.INFIX)));
		mlnOperators.put(IFF_SYMBOL,addMlnNamedObject(new MLNFormulaOperator(IFF_SYMBOL,2,MLNFormulaOperator.IFF_PREC, 
				MLNFormulaOperator.INFIX)));
		mlnOperators.put(NOT_SYMBOL,addMlnNamedObject(new MLNFormulaOperator(NOT_SYMBOL,1, MLNFormulaOperator.NOT_PREC, 
				MLNFormulaOperator.PREFIX)));
		mlnOperators.put(OR_SYMBOL,addMlnNamedObject(new MLNFormulaOperator(OR_SYMBOL, 2, MLNFormulaOperator.OR_PREC, 
				MLNFormulaOperator.INFIX)));
		mlnOperators.put(PARENTHESES_SYMBOL,addMlnNamedObject(new MLNFormulaOperator(PARENTHESES_SYMBOL, 1, MLNFormulaOperator.PARENTHESES_PREC, 
				MLNFormulaOperator.SURROUNDING, PARENTHESES_CLOSING)));
		mlnOperators.put(SQUARE_BRACKETS_SYMBOL,addMlnNamedObject(new MLNFormulaOperator(SQUARE_BRACKETS_SYMBOL, 1, MLNFormulaOperator.SQUARE_BRACKETS_PREC, 
				MLNFormulaOperator.SURROUNDING, SQUARE_BRACKETS_CLOSING)));
	}
	
	public MLNFormulaOperator getOperator(String name) {
		return mlnOperators.get(name);
	}
	
	public boolean containsVariableWeights() {
		for (MLNFormula formula: getAll(MLNFormula.class)) {
			if ((formula.getProbabilityWeight()!=null && formula.getProbabilityWeight().getVarWeight()!=null) ||
					(formula.getUtilityWeight()!=null && formula.getUtilityWeight().getVarWeight()!=null))
				return true;
		}
		return false;
	}
	
	private void buildMaps() {
		mlnUnnamedObjects = new HashMap<Class<?>, List<MLNObject>>();
		mlnNamedObjects = new HashMap<Class<?>, Map<String, MLNNamedObject>>();
		for (Class<?> mlnObjectClass : mlnObjectClasses) {
			if (MLNNamedObject.class.isAssignableFrom(mlnObjectClass))
				mlnNamedObjects.put(mlnObjectClass,  new HashMap<String, MLNNamedObject>());
			else
				mlnUnnamedObjects.put(mlnObjectClass, new ArrayList<MLNObject>());
		}
	}
	
	public <C extends MLNObject> C addMlnObject(C mlnObject) {
		MLNFormula formula;
		if (mlnObject instanceof MLNFormula) {
			formula = (MLNFormula) mlnObject;
			if (formula.getProbabilityWeight()!=null || formula.getUtilityWeight()!=null) {
				weightedFormulas.add(formula);
			}
			if (formula.getPlainFormula().getQuantification()!=null)
				quantifiedFormulas.add(formula);
		}
		mlnUnnamedObjects.get(mlnObject.getClass()).add(mlnObject);
		return mlnObject;
	}

	@SuppressWarnings("unchecked")
	public <C extends MLNNamedObject> C addMlnNamedObject(C mlnNamedObject)  {
			C obj = (C) getForNameNoCreation(mlnNamedObject.getClass(), mlnNamedObject.getName());
			if (obj == null) {
				mlnNamedObjects.get(mlnNamedObject.getClass()).put(mlnNamedObject.getName(), mlnNamedObject);
				return mlnNamedObject;
			} else {
				//Note: The existing version of a named MLN object is the one that is kept in the new model.
				try {
					if ((!mlnNamedObject.isUnspecified()) && obj.isUnspecified()) {
						BeanUtils.copyProperties(obj, mlnNamedObject);
					}
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				return obj;
			}
	}
	
	
	@SuppressWarnings("unchecked")
	public <C extends MLNObject> List<C> getAll(Class<C> mlnClass) {
		List<C> mlnObjects = new ArrayList<C>();
		Collection<MLNObject> genericMlnObjects;
		Collection<MLNNamedObject> genericMlnNamedObjects;
		if (MLNNamedObject.class.isAssignableFrom(mlnClass)) {
			genericMlnNamedObjects = this.mlnNamedObjects.get(mlnClass).values();
			for (MLNObject obj : genericMlnNamedObjects) {
				mlnObjects.add((C) obj);
			}
		} else {
			genericMlnObjects = this.mlnUnnamedObjects.get(mlnClass);
			for (MLNObject obj : genericMlnObjects) {
				mlnObjects.add((C) obj);
			}
		}
		return mlnObjects;
	}
	
	@SuppressWarnings("unchecked")
	public <C extends MLNNamedObject> C getForNameNoCreation(Class<C> mlnClass, String name) {
		C obj = (C) mlnNamedObjects.get(mlnClass).get(name);
		return obj;
	}
	
	public <C extends MLNNamedObject> C getForName(Class<C> mlnClass, String name){
		C obj = null;
		obj = getForNameNoCreation(mlnClass, name);
		if (obj == null) {
			if (MLNNamedObject.class.isAssignableFrom(mlnClass) && searchForClass(mlnClass)) {
				try {
					obj = mlnClass.newInstance();
					obj.setName(name);
					if (obj instanceof MLNPredicate) {
						((MLNPredicate) obj).setClosedWorldType(MLNClosedWorldType.Undefined);
						unusedPredicates.remove(obj);
					}
					addMlnNamedObject(obj);
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		return obj;
	}
	
	public <C extends MLNNamedObject> List<C> getForNames(Class<C> mlnClass, List<String> names)
			 {
		List<C> values = new ArrayList<C>();
		for (String name : names) {
			values.add(getForName(mlnClass, name));
		}
		return values;
	}
	
	//Factory Methods

	
	public MLNConstant buildMLNConstant(String name)  {
		MLNConstant obj = new MLNConstant(name);
		return addMlnNamedObject(obj);
	}
	
	public MLNFormula buildMLNFormula(MLNPlainFormula plainFormula, MLNWeight probabilityWeight,
			MLNWeight utilityWeight, boolean hardRule) {
		return addMlnObject(new MLNFormula(plainFormula, probabilityWeight,
			utilityWeight, hardRule));
	}
	
	public MLNFunction buildMLNFunction(String name, List<MLNTypeArgument> arguments, MLNTypeArgument returnType) 
			 {
		MLNFunction obj = new MLNFunction(name, arguments, returnType);
		return addMlnNamedObject(obj);
	}
	
	public MLNFunctionApplication buildMLNFunctionApplication(MLNGroundFunctionApplication functionAppl) {
		List<MLNVarArgument> arguments = new ArrayList<MLNVarArgument>();
		for (MLNGroundArgument groundArgument: functionAppl.getArguments()) {
			arguments.add(buildMLNVarArgument(groundArgument));
		}
		return buildMLNFunctionApplication(functionAppl.getFunction(), arguments);
	}
	
	public MLNFunctionApplication buildMLNFunctionApplication(MLNFunction function,
			List<MLNVarArgument> arguments) {
		return addMlnObject(new MLNFunctionApplication(function, arguments));
	}
	
	public MLNFunctionApplication buildMLNFunctionApplicationFromNames(String function,
			List<MLNVarArgument> arguments)  {
		return addMlnObject(new MLNFunctionApplication(getForName(MLNFunction.class, function), arguments));
	}
	
	public MLNFunctionDefinition buildMLNFunctionDefinition(MLNFunction function,
			MLNFunctionReturnValue returnValue,
			List<MLNGroundArgument> arguments) {
		return addMlnObject(new MLNFunctionDefinition(function, returnValue, arguments));
	}
	
	public MLNFunctionDefinition buildMLNFunctionDefinitionFromNames(String function,
			MLNFunctionReturnValue returnValue,
			List<MLNGroundArgument> arguments)  {
		return addMlnObject(new MLNFunctionDefinition(getForName(MLNFunction.class, function), 
				returnValue,
				arguments));
	}
	
	public MLNGroundAtom buildMLNGroundAtom(MLNPredicate predicate, List<MLNGroundArgument> arguments,
			boolean negated) {
		return addMlnObject(new MLNGroundAtom(predicate, arguments, negated));
	}
	
	public MLNGroundAtom buildMLNGroundAtomFromNames(String predicate, List<MLNGroundArgument> arguments,
			boolean negated)  {
		return addMlnObject(new MLNGroundAtom(getForName(MLNPredicate.class, predicate), 
				arguments, negated));
	}
	
	public MLNOperatorApplication buildMLNOperatorApplication(MLNFormulaOperator operator, List<MLNPlainFormula> arguments) {
		return addMlnObject(new MLNOperatorApplication(operator, 
				arguments));
	}
	
	public MLNOperatorApplication buildMLNOperatorApplicationFromNames(String operator, List<MLNPlainFormula> arguments)  
			 {
		return addMlnObject(new MLNOperatorApplication(getForName(MLNFormulaOperator.class, operator), 
				arguments));
	}
	
	public MLNPlainFormula buildMLNPlainFormula(MLNOperatorApplication operatorApplication,
			MLNFunctionApplication functionApplication,
			MLNPredicateApplication predicateApplication,
			MLNQuantification quantification) {
		return addMlnObject(new MLNPlainFormula(operatorApplication, functionApplication, predicateApplication,
				quantification));
	}
	
	public MLNPlainFormula buildMLNPlainFormula(MLNOperatorApplication operatorApplication) {
		return buildMLNPlainFormula(operatorApplication, null, null, null);
	}
	
	public MLNPlainFormula buildMLNPlainFormula(MLNFunctionApplication functionApplication) {
		return buildMLNPlainFormula(null, functionApplication, null, null);
	}
	
	public MLNPlainFormula buildMLNPlainFormula(MLNPredicateApplication predicateApplication) {
		return buildMLNPlainFormula(null, null, predicateApplication, null);
	}
	
	public MLNPlainFormula buildMLNPlainFormula(MLNQuantification quantification) {
		return buildMLNPlainFormula(null, null, null, quantification);
	}
	
	public MLNPredicate buildMLNPredicate(String name, List<MLNTypeArgument> arguments)  {
		MLNPredicate p =  addMlnNamedObject(new MLNPredicate(name, arguments));
		unusedPredicates.add(p);
		return p;
	}
	
	public MLNPredicate buildMLNPredicate(String name, List<MLNTypeArgument> arguments, MLNClosedWorldType closedWorld) 
			 {
		MLNPredicate p = addMlnNamedObject(new MLNPredicate(name, arguments, closedWorld));
		unusedPredicates.add(p);
		return p;
	}
	
	public MLNPredicateApplication buildMLNPredicateApplication(MLNGroundAtom atom) {
		List<MLNVarArgument> arguments = new ArrayList<MLNVarArgument>();
		for (MLNGroundArgument groundArgument: atom.getArguments()) {
			arguments.add(buildMLNVarArgument(groundArgument));
		}
		MLNPredicateApplication pA = buildMLNPredicateApplication(atom.getPredicate(), arguments);
		unusedPredicates.remove(pA.getPredicate());
		return pA;
	}
	
	public MLNPredicateApplication buildMLNPredicateApplication(MLNPredicate predicate,
			List<MLNVarArgument> arguments) {
		MLNPredicateApplication pA = addMlnObject(new MLNPredicateApplication(predicate, arguments));
		unusedPredicates.remove(pA.getPredicate());
		return pA;
	}
	
	public void unifyPredicateState(MLNClosedWorldType type) {
		for (MLNPredicate pred: getAll(MLNPredicate.class)) {
			pred.setClosedWorldType(type);
		}
	}

	
	public MLNPredicateApplication buildMLNPredicateApplicationFromNames(String predicate,
			List<MLNVarArgument> arguments)  {
		MLNPredicateApplication pA = addMlnObject(new MLNPredicateApplication(getForName(MLNPredicate.class, predicate), 
				arguments));
		unusedPredicates.remove(pA.getPredicate());
		return pA;
	}
	
	public MLNQuantification buildMLNQuantification(String name, Boolean eQuant, Boolean uQuant, MLNPlainFormula plainFormula,
			List<MLNVariable> arguments, MLNRelation relation, Integer number) {
		return addMlnObject(new MLNQuantification(name, eQuant, uQuant, plainFormula, arguments, relation, number));
	}
	
	public MLNQuantification buildMLNQuantificationFromNames(String name, Boolean eQuant, Boolean uQuant, MLNPlainFormula plainFormula,
			List<String> arguments, MLNRelation relation, Integer number)  {
		return addMlnObject(new MLNQuantification(name, eQuant, uQuant, plainFormula, getForNames(MLNVariable.class, arguments), 
				relation, number));
	}
	
	public MLNVariable buildMLNVariable(String name, boolean plus)  {
		return addMlnNamedObject(new MLNVariable(name, plus));
	}
	
	public MLNTypeContainer buildMLNTypeContainer(String name, List<MLNConstant> constants) 
			 {
		return addMlnNamedObject(new MLNTypeContainer(name, constants));
	}
	
	public MLNTypeContainer buildMLNTypeContainerFromNames(String name, List<String> constants) 
			 {
		return addMlnNamedObject(new MLNTypeContainer(name, getForNames(MLNConstant.class, constants)));
	}
	
	public MLNTypeContainer buildMLNTypeContainer(String name, boolean intOnly, Double lowerBound, Double upperBound) 
			 {
		return addMlnNamedObject(new MLNTypeContainer(name, intOnly, lowerBound, upperBound));
	}
	
	public MLNTypeContainer buildMLNTypeContainer(String name, boolean intOnly, List<Double> numbers) 
			 {
		return addMlnNamedObject(new MLNTypeContainer(name, intOnly, numbers));
	}
	
	public MLNVarArgument buildMLNVarArgument(MLNGroundArgument groundArgument) {
		if (groundArgument.getConstant()!=null) {
			return buildMLNVarArgument(groundArgument.getConstant(), false);
		} else if (groundArgument.getNumber()!=null) {
			return buildMLNVarArgument(groundArgument.getNumber(), false);
		} else if (groundArgument.getGroundAtom()!=null) {
			return buildMLNVarArgument(buildMLNPredicateApplication(groundArgument.getGroundAtom()), false);
		} else if (groundArgument.getGroundFunctionApplication()!=null) {
			return buildMLNVarArgument(buildMLNFunctionApplication(groundArgument.getGroundFunctionApplication()), false);
		} else {
			return null;
		}
	}
	
	public MLNVarArgument buildMLNVarArgument(MLNPredicateApplication predicateApplication, boolean plus) {
		return addMlnObject(new MLNVarArgument(predicateApplication, plus));
	}
	
	public MLNVarArgument buildMLNVarArgument(MLNFunctionApplication functionApplication, boolean plus) {
		return addMlnObject(new MLNVarArgument(functionApplication, plus));
	}
	
	public MLNVarArgument buildMLNVarArgument(MLNConstant constant, boolean plus) {
		return addMlnObject(new MLNVarArgument(constant, plus));
	}
	
	public MLNVarArgument buildMLNVarArgument(Double number, boolean plus) {
		return addMlnObject(new MLNVarArgument(number, plus));
	}
	
	public MLNVarArgument buildMLNVarArgument(MLNVariable variable, boolean plus) {
		return addMlnObject(new MLNVarArgument(variable, plus));
	}
	
	public <C extends MLNNamedObject> MLNVarArgument buildMLNVarArgumentFromNames(Class<C> mlnClass, 
			String name, boolean plus)  {
		if (mlnClass.equals(MLNVariable.class)) {
			return addMlnObject(new MLNVarArgument((MLNVariable) getForName(mlnClass, name), plus));
		} else if (mlnClass.equals(MLNConstant.class)) {
			return addMlnObject(new MLNVarArgument((MLNConstant) getForName(mlnClass, name), plus));
		} else {
			return null;
		}
	}
	
	public MLNGroundArgument buildMLNGroundArgument(MLNGroundAtom groundAtom) {
		return addMlnObject(new MLNGroundArgument(groundAtom));
	}
	
	public MLNGroundArgument buildMLNGroundArgument(MLNGroundFunctionApplication functionApplication) {
		return addMlnObject(new MLNGroundArgument(functionApplication));
	}
	
	public MLNGroundArgument buildMLNGroundArgument(MLNConstant constant) {
		return addMlnObject(new MLNGroundArgument(constant));
	}
	
	public MLNGroundArgument buildMLNGroundArgument(Double number) {
		return addMlnObject(new MLNGroundArgument(number));
	}
	
	public MLNGroundArgument buildMLNGroundArgumentFromNames(String name)  {
		return addMlnObject(new MLNGroundArgument(getForName(MLNConstant.class, name)));
	}
	
	public MLNFunctionReturnValue buildMLNFunctionReturnValue(MLNConstant constant) {
		return addMlnObject(new MLNFunctionReturnValue(constant));
	}
	
	public MLNFunctionReturnValue buildMLNFunctionReturnValue(Double number)   {
		return addMlnObject(new MLNFunctionReturnValue(number));
	}
	
	public MLNFunctionReturnValue buildMLNFunctionReturnValueFromNames(String constant) 
			 {
		return addMlnObject(new MLNFunctionReturnValue(getForName(MLNConstant.class, constant)));
	}
	
	public MLNTypeArgument buildMLNTypeArgument(MLNTypeContainer typeContainer, boolean excl) {
		return addMlnObject(new MLNTypeArgument(typeContainer, excl));
	}
	
	public MLNTypeArgument buildMLNTypeArgumentFromNames(String typeContainer, boolean excl) 
			 {
		return addMlnObject(new MLNTypeArgument(getForName(MLNTypeContainer.class, typeContainer), excl));
	}
	
	public MLNProbabilityStatement buildMLNProbabilityStatement(MLNGroundFormula groundFormula, Double probability) {
		return addMlnObject(new MLNProbabilityStatement(groundFormula, probability));
	}
	
	public MLNWeight buildMLNWeight(Double weight) {
		return addMlnObject(new MLNWeight(weight));
	}
	
	public MLNWeight buildMLNWeight(MLNVariable weight) {
		return addMlnObject(new MLNWeight(weight));
	}
	
	public MLNWeight buildMLNWeightFromNames(String weight)  {
		return addMlnObject(new MLNWeight(getForName(MLNVariable.class, weight)));
	}
	
	public MLNGroundFunctionApplication buildMLNGroundFunctionApplication(MLNFunction function,
			List<MLNGroundArgument> arguments) {
		return addMlnObject(new MLNGroundFunctionApplication(function, arguments));
	}
	
	public MLNGroundFunctionApplication buildMLNGroundFunctionApplicationFromNames(String function,
			List<MLNGroundArgument> arguments)  {
		return addMlnObject(new MLNGroundFunctionApplication(getForName(MLNFunction.class, function), arguments));
	}
	
	public MLNGroundFormula buildMLNGroundFormula(MLNGroundAtom groundAtom) {
		return addMlnObject(new MLNGroundFormula(groundAtom));
	}
	
	public MLNGroundFormula buildMLNGroundFormula(MLNFunctionDefinition functionDefinition) {
		return addMlnObject(new MLNGroundFormula(functionDefinition));
	}
			
	public List<MLNPredicate> getPredicatesForClosedWorldType(MLNClosedWorldType type) {
		List<MLNPredicate> predicates = new ArrayList<MLNPredicate>();
		for (MLNPredicate predicate: this.getAll(MLNPredicate.class)) {
			if (predicate.getClosedWorldType().name().equals(type.name()));
				predicates.add(predicate);
		}
		return predicates;
	}

	protected Map<Class<?>, List<MLNObject>> getMlnObjects() {
		return mlnUnnamedObjects;
	}

	protected void setMlnObjects(Map<Class<?>, List<MLNObject>> mlnObjects) {
		this.mlnUnnamedObjects = mlnObjects;
	}

	protected Map<Class<?>, Map<String, MLNNamedObject>> getMlnNamedObjects() {
		return mlnNamedObjects;
	}

	protected void setMlnNamedObjects(
			Map<Class<?>, Map<String, MLNNamedObject>> mlnNamedObjects) {
		this.mlnNamedObjects = mlnNamedObjects;
	}
	
	public void removeMlnObject(MLNObject obj) {
		Class<?> cl = obj.getClass();
		if (obj instanceof MLNNamedObject) {
			MLNNamedObject namedObj = (MLNNamedObject) obj;
			mlnNamedObjects.get(cl).remove(namedObj.getName());
		} else {
			if (obj instanceof MLNFormula) {
				if (weightedFormulas.contains(obj))
					weightedFormulas.remove(obj);
				if (quantifiedFormulas.contains(obj))
					quantifiedFormulas.remove(obj);
			}
			mlnUnnamedObjects.get(cl).remove(obj);
		}
	}
	
	public void removeUnusedPredicates() {
		for (MLNPredicate predicate : unusedPredicates) {
			removeMlnObject(predicate);
		}
	}
	
	public List<MLNFormula> getWeightedFormulas() {
		return this.weightedFormulas;
	}
	
	public List<MLNFormula> getQuantifiedFormulas() {
		return this.quantifiedFormulas;
	}
	
	public void transferWeights(MLNModel weightModel, boolean skipLE) {
		List<MLNFormula> formulasToRemove = new ArrayList<MLNFormula>();
		boolean transfered;
		List<MLNFormula> formulasToAdd = new ArrayList<MLNFormula>();
		for (MLNFormula weightFormula: weightModel.getWeightedFormulas()) {
			transfered = false;
			if (weightFormula.getProbabilityWeight()!=null || weightFormula.getUtilityWeight()!=null) {
				for (MLNFormula targetFormula: getAll(MLNFormula.class)) {
					if (weightFormula.getPlainFormula().contentEquals(targetFormula.getPlainFormula(), false,
							false)) {
						targetFormula.setProbabilityWeight(weightFormula.getProbabilityWeight());
						targetFormula.setUtilityWeight(weightFormula.getUtilityWeight());
						transfered = true;
						break;
					} else if (!targetFormula.isHardRule() && targetFormula.getProbabilityWeight()==null)
						targetFormula.setProbabilityWeight(buildMLNWeight(0.0));
				}
			}
			if (!transfered) {
				formulasToAdd.add(weightFormula);
			}
		}
		for (MLNFormula quantifiedFormula: getQuantifiedFormulas()) {
			if (quantifiedFormula.getPlainFormula()!=null && quantifiedFormula.getPlainFormula().getQuantification()!=null
					&& quantifiedFormula.getPlainFormula().getQuantification().getRelation().equals(MLNRelation.LE)
					&& skipLE) {
				formulasToRemove.add(quantifiedFormula);
			}
		}
		for (MLNFormula formula: formulasToRemove)
			removeMlnObject(formula);
		for (MLNFormula formula: formulasToAdd) {
			addMlnObject(formula);
		}
	}

	public Double getId() {
		return id;
	}

	public void setId(Double id) {
		this.id = id;
	}
	
}
