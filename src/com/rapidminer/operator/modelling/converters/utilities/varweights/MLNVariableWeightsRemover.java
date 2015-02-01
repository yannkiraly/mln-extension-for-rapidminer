package com.rapidminer.operator.modelling.converters.utilities.varweights;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javafx.util.Pair;

import com.rapidminer.operator.OperatorException;
import com.rapidminer.operator.modelling.MLNOperator;
import com.rapidminer.operator.modelling.configuration.MLNFileType;
import com.rapidminer.operator.modelling.configuration.fixed.MLNError;
import com.rapidminer.operator.modelling.configuration.fixed.MLNException;
import com.rapidminer.operator.modelling.configuration.fixed.MLNFileRole;
import com.rapidminer.operator.modelling.converters.MLNConverter;
import com.rapidminer.operator.modelling.converters.utilities.ConverterUtilities;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.Filter;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduce;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduceException;
import com.rapidminer.operator.modelling.model.MLNClosedWorldType;
import com.rapidminer.operator.modelling.model.MLNConstant;
import com.rapidminer.operator.modelling.model.MLNFormula;
import com.rapidminer.operator.modelling.model.MLNFunctionApplication;
import com.rapidminer.operator.modelling.model.MLNGroundArgument;
import com.rapidminer.operator.modelling.model.MLNGroundAtom;
import com.rapidminer.operator.modelling.model.MLNGroundFormula;
import com.rapidminer.operator.modelling.model.MLNModel;
import com.rapidminer.operator.modelling.model.MLNPlainFormula;
import com.rapidminer.operator.modelling.model.MLNPredicate;
import com.rapidminer.operator.modelling.model.MLNPredicateApplication;
import com.rapidminer.operator.modelling.model.MLNVarArgument;
import com.rapidminer.operator.modelling.model.MLNVariable;
import com.rapidminer.operator.modelling.model.types.MLNTypeArgument;
import com.rapidminer.operator.modelling.model.types.MLNTypeContainer;

public class MLNVariableWeightsRemover {
	
	private MLNModel ruleMlnModel;
	private List<MLNModel> evidenceMlnModels;
	
	private static final String DOUBLE_TYPE_NAME = "doubleType";
	private static final String TYPE_NAME = "typ";
	
	private int occuranceCounter = 0;
	
	public static void main(String[] args) {
		String ruleFilename = "/Users/yann/test.mln";
		String evidenceFilename = "/Users/yann/test.db";
		try {
			MLNOperator.loadConfiguration();
			MLNConverter ruleConv = MLNConverter.getConverterForFileType(MLNFileType.fromKey("Alchemy"), 
					new FileInputStream(ruleFilename));
			MLNConverter evidenceConv = MLNConverter.getConverterForFileType(MLNFileType.fromKey("Alchemy"), 
						new FileInputStream(evidenceFilename));
			MLNModel ruleModel = ruleConv.buildModel(MLNFileRole.RULES);
			MLNModel evidenceModel = evidenceConv.buildModel(MLNFileRole.EVIDENCE);
			MLNVariableWeightsRemover rem = new MLNVariableWeightsRemover(ruleModel,
					ConverterUtilities.compose(evidenceModel));
			rem.expandPlusVariables();
			ruleConv = MLNConverter.getConverterForFileType(MLNFileType.fromKey("Alchemy"), System.out);
			ruleConv.convertModel(ruleModel, MLNFileRole.RULES);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MLNException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OperatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public MLNVariableWeightsRemover(MLNModel model) {
		this.ruleMlnModel = model;
	}
	
	private MLNTypeContainer getDoubleType() {
		return new MLNTypeContainer(DOUBLE_TYPE_NAME, false, Double.MIN_VALUE, Double.MAX_VALUE);
	}
	
	public MLNVariableWeightsRemover(MLNModel ruleModel, List<MLNModel> evidenceMlnModels) {
		this.ruleMlnModel = ruleModel;
		this.evidenceMlnModels = evidenceMlnModels;
	}
	
	public void reinsertVariableProbabilityWeightFormulas(MLNModel varOldFormulas, MLNModel varNewFormulas) 
			throws MLNException {
		List<MLNFormula> formulasToRemove = new ArrayList<MLNFormula>();
		Pair<MLNPredicate, Integer> predicatePair = null;
		MLNPredicate predicate;
		MLNPredicateApplication appl;
		int argCounter;
		MLNTypeArgument typeArg;
		for (MLNFormula varNewFormula: varNewFormulas.getAll(MLNFormula.class)) {
			for (MLNFormula weightedFormula: ruleMlnModel.getWeightedFormulas()) {
				if (varNewFormula.contentEquals(weightedFormula, false, true))
					formulasToRemove.add(weightedFormula);
			}
		}
		for (MLNFormula remFormula: formulasToRemove) {
			ruleMlnModel.removeMlnObject(remFormula);
		}
		for (MLNFormula varOldFormula: varOldFormulas.getAll(MLNFormula.class)) {
			ruleMlnModel.addMlnObject(varOldFormula);
			appl = findPredicateApplicationContainingProbabilityWeightVariable(varOldFormula.getProbabilityWeight()
					.getVarWeight(), varOldFormula.getPlainFormula());
			argCounter = 0;
			for (MLNVarArgument arg: appl.getArguments()) {
				if (arg.getVariable()!=null && arg.getVariable().getName().equals(
						varOldFormula.getProbabilityWeight()
						.getVarWeight().getName())) {
					predicatePair = new Pair<MLNPredicate, Integer>(appl.getPredicate(), argCounter);
					break;
				}
				argCounter++;
			}
			if ((predicate = ruleMlnModel.getForNameNoCreation(MLNPredicate.class, predicatePair.getKey().getName()))
					!=null) {
				if (predicate.getArguments()!=null) {
					if  (predicate.getArguments().size()<appl.getArguments().size()) {
						typeArg = ruleMlnModel.buildMLNTypeArgument(ruleMlnModel.addMlnNamedObject(getDoubleType()), false);
						predicate.getArguments().add(predicatePair.getValue(), typeArg);
					} else if (predicate.getArguments().size()>appl.getArguments().size())
						throw new IllegalArgumentException();
				} else {
					predicate.setArguments(buildTypeArgumentList(argCounter, appl.getArguments().size()));
				}
				predicate.setClosedWorldType(MLNClosedWorldType.ClosedWorld);
			} else {
				ruleMlnModel.buildMLNPredicate(appl.getPredicate().getName(), 
						buildTypeArgumentList(argCounter, appl.getArguments().size()), MLNClosedWorldType.ClosedWorld);
			}
		}
	}
	
	private List<MLNTypeArgument> buildTypeArgumentList(int weightPosition, int size) {
		List<MLNTypeArgument> typeArgList = new ArrayList<MLNTypeArgument>();
		for (int varArgCounter = 0; varArgCounter<size; varArgCounter++) {
			if (varArgCounter != weightPosition)
				typeArgList.add(ruleMlnModel.buildMLNTypeArgumentFromNames(TYPE_NAME+varArgCounter, false));
			else
				typeArgList.add(ruleMlnModel.buildMLNTypeArgument(getDoubleType(), false));
		}
		return typeArgList;
	}
	
	public MLNPredicateApplication findPredicateApplicationContainingProbabilityWeightVariable
		(MLNVariable variable, MLNPlainFormula formula) {
		MLNPredicateApplication appl;
		if(formula.getPredicateApplication()!=null) {
			return findPredicateApplicationContainingProbabilityWeightVariable(variable, 
					formula.getPredicateApplication());
		} else if (formula.getFunctionApplication()!=null) {
			return findPredicateApplicationContainingProbabilityWeightVariable(variable, 
					formula.getFunctionApplication());
		} else if (formula.getOperatorApplication()!=null) {
			for (MLNPlainFormula arg: formula.getOperatorApplication().getArguments()) {
				appl = findPredicateApplicationContainingProbabilityWeightVariable(variable,
						arg);
				if (appl!=null)
					return appl;
			}
			return null;
		} else if (formula.getQuantification()!=null) {
			return findPredicateApplicationContainingProbabilityWeightVariable(variable,
					formula.getQuantification().getPlainFormula());
		} else {
			return null;
		}
	}
	
	private MLNPredicateApplication findPredicateApplicationContainingProbabilityWeightVariable(MLNVariable variable,
			MLNPredicateApplication appl) {
		for (MLNVarArgument varArg: appl.getArguments()) {
			if ((varArg.getVariable()!=null) && (varArg.getVariable().getName().equals(variable.getName()))) {
					return appl;
			} else if (varArg.getPredicateApplication()!=null) {
				return findPredicateApplicationContainingProbabilityWeightVariable(variable, 
						varArg.getPredicateApplication());
			}
		}
		return null;
	}
	
	private MLNPredicateApplication findPredicateApplicationContainingProbabilityWeightVariable(MLNVariable variable,
			MLNFunctionApplication appl) {
		for (MLNVarArgument varArg: appl.getArguments()) {
			if (varArg.getPredicateApplication()!=null) {
				return findPredicateApplicationContainingProbabilityWeightVariable(variable, 
						varArg.getPredicateApplication());
			} else if (varArg.getFunctionApplication()!=null) {
				return findPredicateApplicationContainingProbabilityWeightVariable(variable, 
						varArg.getFunctionApplication());
			}
		}
		return null;
	}
	
	public void removeVariableProbabilityWeights(MLNModel varOldFormulas, MLNModel varNewFormulas) throws MLNException {
		List<MLNFormula> variableWeightFormulas = collectVariableProbabilityWeightFormulas();
		Pair<MLNPredicate, Integer> pair;
		List<MLNGroundArgument> arguments;
		List<MLNFormula> oldFormulas;
		Map<MLNVariable, List<MLNFormula>> variableFormulaAssociation = 
				associateFormulasWithWeightVariables(variableWeightFormulas);
		List<MLNGroundAtom> groundings;
		MLNGroundAtom newGrounding;
		for (MLNVariable variable: variableFormulaAssociation.keySet()) {
			oldFormulas = variableFormulaAssociation.get(variable);
			for (MLNFormula formula: oldFormulas) {
				varOldFormulas.addMlnObject(formula);
				pair = findPredicateContainingProbabilityWeightVariable(variable, formula.getPlainFormula());
				if (pair != null) {
					groundings = getGroundAtoms(pair.getKey());
					if (groundings!=null) {
						for (MLNGroundAtom grounding: groundings) {
							arguments = new ArrayList<MLNGroundArgument>();
							for (int counter = 0; counter < grounding.getArguments().size(); counter++) {
								if (counter != pair.getValue())
									arguments.add(grounding.getArguments().get(counter));
							}
							newGrounding = ruleMlnModel.buildMLNGroundAtom(pair.getKey(), arguments, grounding.isNegated());
							varNewFormulas.addMlnObject(ruleMlnModel.buildMLNFormula(
									clonePlainFormulaWhileReplacingPredicateApplication(formula.getPlainFormula(), 
											ruleMlnModel.buildMLNPredicateApplication(newGrounding)), 
									ruleMlnModel.buildMLNWeight(grounding.getArguments().get(pair.getValue()).getNumber()), 
									formula.getUtilityWeight(), false));
							grounding.getArguments().remove(pair.getValue().intValue());
						}
					}
					pair.getKey().getArguments().remove(pair.getValue().intValue());
				}
			}
			if (oldFormulas!=null)
				removeFormulas(oldFormulas);
		}
	}
	
	private void removeFormulas(List<MLNFormula> formulas) {
		for (MLNFormula formula: formulas) {
			ruleMlnModel.removeMlnObject(formula);
		}
	}
	
	private void findPlusPredicateApplications(Map<MLNPredicate, Set<Integer>> map,
			MLNPredicateApplication appl) {
		if (appl!=null) {
			for (int counter = 0; counter < appl.getArguments().size(); counter++) {
				if ((appl.getArguments().get(counter).getVariable()!=null) && 
						(appl.getArguments().get(counter).isPlus())) {
					if (map.get(appl.getPredicate())==null) {
						map.put(appl.getPredicate(), new TreeSet<Integer>());
					}
					map.get(appl.getPredicate()).add(counter);
				} else if (appl.getArguments().get(counter).getPredicateApplication()!= null)
					findPlusPredicateApplications(map, appl.getArguments().get(counter).getPredicateApplication());
				else if (appl.getArguments().get(counter).getFunctionApplication()!=null)
					findPlusPredicateApplications(map, appl.getArguments().get(counter).getFunctionApplication());
			}
		}
	}
	
	private void findPlusPredicateApplications(Map<MLNPredicate, Set<Integer>> map,
			MLNFunctionApplication appl) {
		if (appl!=null) {
			for (int counter = 0; counter < appl.getArguments().size(); counter++) {
				if (appl.getArguments().get(counter).getPredicateApplication()!= null)
					findPlusPredicateApplications(map, appl.getArguments().get(counter).getPredicateApplication());
				else if (appl.getArguments().get(counter).getFunctionApplication()!=null)
					findPlusPredicateApplications(map, appl.getArguments().get(counter).getFunctionApplication());
			}
		}
	}
	
	private void findPlusPredicateApplications(Map<MLNPredicate, Set<Integer>> map,
			MLNPlainFormula formula) {
		if (formula.getPredicateApplication()!=null) {
			findPlusPredicateApplications(map, formula.getPredicateApplication());
		} else if (formula.getFunctionApplication()!=null) {
			findPlusPredicateApplications(map, formula.getFunctionApplication());
		} else if (formula.getOperatorApplication()!=null) {
			for (MLNPlainFormula plainFormula: formula.getOperatorApplication().getArguments()) {
				findPlusPredicateApplications(map, plainFormula);
			}
		} else if (formula.getQuantification()!=null) {
			findPlusPredicateApplications(map, formula.getQuantification().getPlainFormula());
		}
	}

	public void expandPlusVariables() {
		Map<MLNPredicate, Set<Integer>> map;
		List<MLNPlainFormula> oldPlainFormulas, newPlainFormulas;
		List<MLNFormula> formulasToRemove = new ArrayList<MLNFormula>();
		int occLimit;
		for (MLNFormula formula: ruleMlnModel.getAll(MLNFormula.class)) {
			map  = new HashMap<MLNPredicate, Set<Integer>>();
			findPlusPredicateApplications(map, formula.getPlainFormula());
			oldPlainFormulas = new ArrayList<MLNPlainFormula>();
			oldPlainFormulas.add(formula.getPlainFormula());
			newPlainFormulas = new ArrayList<MLNPlainFormula>();
			for (MLNPredicate predicate: map.keySet()) {
				for (Integer pos: map.get(predicate)) {
					occuranceCounter = 0;
					clonePlainFormulaWhileReplacingArgument(
							formula.getPlainFormula(), predicate, 
									pos, null, -1);
					occLimit = occuranceCounter;	
					for (int occ = 0; occ < occLimit; occ++) {
						newPlainFormulas = new ArrayList<MLNPlainFormula>();
						for (MLNPlainFormula oldPlainFormula: oldPlainFormulas) {
							if (predicate.getArguments()!=null && predicate.getArguments().get(pos)!=null && !predicate.getArguments().get(
									pos).getTypeContainer().isUnspecified()) {
								for (MLNGroundArgument gArg: buildPossibleVariableGroundings(predicate.getArguments().get(
										pos).getTypeContainer())) {
									occuranceCounter = 0;
									newPlainFormulas.add(clonePlainFormulaWhileReplacingArgument(
											oldPlainFormula, predicate, pos, groundArgumentToVar(gArg), occ));
								}
							} else {
								for (MLNGroundArgument gArg: findVariableGroundings(predicate, pos)) {
									occuranceCounter = 0;
									newPlainFormulas.add(clonePlainFormulaWhileReplacingArgument(
											oldPlainFormula, predicate, 
													pos, groundArgumentToVar(gArg), occ));
								}
							}
						}
						oldPlainFormulas = newPlainFormulas;
					}
				}
			}
			for (MLNPlainFormula plainFormula: oldPlainFormulas) {
				ruleMlnModel.buildMLNFormula(plainFormula, formula.getProbabilityWeight(), 
						formula.getUtilityWeight(), formula.isHardRule());
			}
			formulasToRemove.add(formula);
		}
		for (MLNFormula formula: formulasToRemove) {
			ruleMlnModel.removeMlnObject(formula);
		}
	}
	
	private List<MLNGroundArgument> buildPossibleVariableGroundings(MLNTypeContainer type) {
		List<MLNGroundArgument> groundArguments = new ArrayList<MLNGroundArgument>();
		if (type.getSpecifiedNumericalType()!=null) {
			for (Double number: type.getSpecifiedNumericalType().getNumbers()) {
				groundArguments.add(ruleMlnModel.buildMLNGroundArgument(number));
			}
		} else if (type.getRangeNumericalType()!=null) {
			for (double number = type.getRangeNumericalType().getLowerBound();
					number <= type.getRangeNumericalType().getUpperBound(); number++) {
				groundArguments.add(ruleMlnModel.buildMLNGroundArgument(number));
			}
		} else if (type.getConstantType()!=null) {
			for (MLNConstant constant: type.getConstantType().getConstants()) {
				groundArguments.add(ruleMlnModel.buildMLNGroundArgument(constant));
			}
		}
		return groundArguments;
	}
	
	private List<MLNVarArgument> replaceArgument(Integer position, MLNVarArgument arg, List<MLNVarArgument> list) {
		List<MLNVarArgument> newList = new ArrayList<MLNVarArgument>();
		for (int counter = 0; counter < list.size(); counter++) {
			if (counter == position)
				newList.add(arg);
			else
				newList.add(list.get(counter));
		}
		return newList;
	}
	
	
	private MLNVarArgument groundArgumentToVar(MLNGroundArgument arg) {
		if (arg.getConstant()!=null)
			return ruleMlnModel.buildMLNVarArgument(arg.getConstant(), false);
		else if (arg.getNumber()!=null)
			return ruleMlnModel.buildMLNVarArgument(arg.getNumber(), false);
		else if (arg.getGroundAtom()!=null)
			return ruleMlnModel.buildMLNVarArgument(ruleMlnModel.buildMLNPredicateApplication(arg.getGroundAtom()), false);
		else if (arg.getGroundFunctionApplication()!=null) {
			return ruleMlnModel.buildMLNVarArgument(ruleMlnModel.buildMLNFunctionApplication(arg.getGroundFunctionApplication()), false);
		} else
			throw new IllegalArgumentException();
	}
	
	private Set<MLNGroundArgument> findVariableGroundings(MLNPredicate predicate, Integer pos) {
		Set<MLNGroundArgument> list = new TreeSet<MLNGroundArgument>();
		if (this.evidenceMlnModels!=null) {
			for (MLNModel model: this.evidenceMlnModels) {
				for (MLNGroundAtom atom: model.getAll(MLNGroundAtom.class)) {
					if (atom.getPredicate().contentEquals(predicate, false)) {
						list.add(atom.getArguments().get(pos));
					}
				}
			}
		}
		return list;
	}
	
	private MLNPlainFormula clonePlainFormulaWhileReplacingArgument
	(MLNPlainFormula formula, MLNPredicate predicate, int position, MLNVarArgument argument,
			int occuranceTarget) {
	List<MLNPlainFormula> plainFormulas;
	if (formula.getFunctionApplication()!=null) {
		return ruleMlnModel.buildMLNPlainFormula(cloneFunctionApplicationWhileReplacingArgument(
				formula.getFunctionApplication(), predicate, position, argument,
				occuranceTarget));
	} else if (formula.getPredicateApplication()!=null)  {
		if (formula.getPredicateApplication().getPredicate().contentEquals(predicate, false))  {
			if (occuranceCounter == occuranceTarget) {
				occuranceCounter++;
				return ruleMlnModel.buildMLNPlainFormula(
						ruleMlnModel.buildMLNPredicateApplication(predicate, 
								replaceArgument(position, argument, formula.getPredicateApplication().getArguments())));
			} else {
				occuranceCounter++;
				return formula;
			}
		}
		else {
			return ruleMlnModel.buildMLNPlainFormula(clonePredicateApplicationWhileReplacingArgument(
					formula.getPredicateApplication(), predicate, position, argument, occuranceTarget));
		}
	} else if (formula.getOperatorApplication()!=null) {
		plainFormulas = new ArrayList<MLNPlainFormula>();
		for (MLNPlainFormula plainFormula : formula.getOperatorApplication().getArguments()) {
			plainFormulas.add(clonePlainFormulaWhileReplacingArgument(plainFormula, predicate, position, argument,
					occuranceTarget));
		}
		return ruleMlnModel.buildMLNPlainFormula(ruleMlnModel.buildMLNOperatorApplication(
				formula.getOperatorApplication().getOperator(), plainFormulas));
	} else if (formula.getQuantification()!=null) {
		return ruleMlnModel.buildMLNPlainFormula(ruleMlnModel.buildMLNQuantification(
				formula.getQuantification().getSymbol(), 
				formula.getQuantification().geteQuant(), 
				formula.getQuantification().getuQuant(), 
				clonePlainFormulaWhileReplacingArgument(
						formula.getQuantification().getPlainFormula(), predicate,position, argument,
						occuranceTarget), 
						formula.getQuantification().getArguments(), 
						formula.getQuantification().getRelation(), 
						formula.getQuantification().getNumber()));
	} else {
		return null;
	}
}

	private MLNFunctionApplication cloneFunctionApplicationWhileReplacingArgument(MLNFunctionApplication
			functionAppl, MLNPredicate predicate, int position, MLNVarArgument argument, int occuranceTarget) {
		return ruleMlnModel.buildMLNFunctionApplication(functionAppl.getFunction(), 
				cloneVarArgumentsWhileReplacingArgument(functionAppl.getArguments(),
						predicate, position, argument, occuranceTarget));
	}
	
	private MLNPredicateApplication clonePredicateApplicationWhileReplacingArgument(MLNPredicateApplication
			innerPredicateAppl,MLNPredicate predicate, int position, MLNVarArgument argument,
			int occuranceTarget) {
		return ruleMlnModel.buildMLNPredicateApplication(innerPredicateAppl.getPredicate(), 
				cloneVarArgumentsWhileReplacingArgument(innerPredicateAppl.getArguments(),
						predicate, position, argument, occuranceTarget));
	}
	
	private List<MLNVarArgument> cloneVarArgumentsWhileReplacingArgument(List<MLNVarArgument> arguments,
			MLNPredicate predicate, int position, MLNVarArgument argument, int occuranceTarget) {
		List<MLNVarArgument> varArguments = new ArrayList<MLNVarArgument>();
		for (MLNVarArgument arg: arguments) {
			if (arg.getFunctionApplication()!=null) {
				varArguments.add(
						ruleMlnModel.buildMLNVarArgument(cloneFunctionApplicationWhileReplacingArgument(
								arg.getFunctionApplication(),
								predicate, position, argument, occuranceTarget),false));
			} else if (arg.getPredicateApplication()!=null) {
				if (arg.getPredicateApplication().getPredicate().contentEquals(predicate, false)) {
					if (occuranceTarget == occuranceCounter) {
						varArguments.add(
								ruleMlnModel.buildMLNVarArgument(
										ruleMlnModel.buildMLNPredicateApplication(predicate, 
												replaceArgument(position, argument, arg.getPredicateApplication().getArguments())),
												false));
						occuranceCounter++;
					} else {
						varArguments.add(arg);
						occuranceCounter++;
					}
				}
			}  else {
				varArguments.add(arg);
			}
		}
		return varArguments;
	}


	private MLNPlainFormula clonePlainFormulaWhileReplacingPredicateApplication
		(MLNPlainFormula formula, MLNPredicateApplication predicateAppl) {
		List<MLNPlainFormula> plainFormulas;
		if (formula.getFunctionApplication()!=null) {
			return ruleMlnModel.buildMLNPlainFormula(cloneFunctionApplicationWhileReplacingPredicateApplication(
					formula.getFunctionApplication(), predicateAppl));
		} else if (formula.getPredicateApplication()!=null)  {
			if (formula.getPredicateApplication().getPredicate().contentEquals(predicateAppl.getPredicate(), false))
				return ruleMlnModel.buildMLNPlainFormula(predicateAppl);
			else
				return ruleMlnModel.buildMLNPlainFormula(clonePredicateApplicationWhileReplacingPredicateApplication(
						formula.getPredicateApplication(), predicateAppl));
		} else if (formula.getOperatorApplication()!=null) {
			plainFormulas = new ArrayList<MLNPlainFormula>();
			for (MLNPlainFormula plainFormula : formula.getOperatorApplication().getArguments()) {
				plainFormulas.add(clonePlainFormulaWhileReplacingPredicateApplication(plainFormula, predicateAppl));
			}
			return ruleMlnModel.buildMLNPlainFormula(ruleMlnModel.buildMLNOperatorApplication(
					formula.getOperatorApplication().getOperator(), plainFormulas));
		} else if (formula.getQuantification()!=null) {
			return ruleMlnModel.buildMLNPlainFormula(ruleMlnModel.buildMLNQuantification(
					formula.getQuantification().getSymbol(), 
					formula.getQuantification().geteQuant(), 
					formula.getQuantification().getuQuant(), 
					clonePlainFormulaWhileReplacingPredicateApplication(
							formula.getQuantification().getPlainFormula(), predicateAppl), 
							formula.getQuantification().getArguments(), 
							formula.getQuantification().getRelation(), 
							formula.getQuantification().getNumber()));
		} else {
			return null;
		}
	}
	
	private MLNFunctionApplication cloneFunctionApplicationWhileReplacingPredicateApplication(MLNFunctionApplication
			functionAppl, MLNPredicateApplication predicateAppl) {
		return ruleMlnModel.buildMLNFunctionApplication(functionAppl.getFunction(), 
				cloneVarArgumentsWhileReplacingPredicateApplication(functionAppl.getArguments(),
						predicateAppl));
	}
	
	private MLNPredicateApplication clonePredicateApplicationWhileReplacingPredicateApplication(MLNPredicateApplication
			innerPredicateAppl, MLNPredicateApplication predicateAppl) {
		return ruleMlnModel.buildMLNPredicateApplication(innerPredicateAppl.getPredicate(), 
				cloneVarArgumentsWhileReplacingPredicateApplication(innerPredicateAppl.getArguments(),
						predicateAppl));
	}
	
	private List<MLNVarArgument> cloneVarArgumentsWhileReplacingPredicateApplication(List<MLNVarArgument> arguments,
			MLNPredicateApplication predicateAppl) {
		List<MLNVarArgument> varArguments = new ArrayList<MLNVarArgument>();
		for (MLNVarArgument argument: arguments) {
			if (argument.getFunctionApplication()!=null) {
				varArguments.add(
						ruleMlnModel.buildMLNVarArgument(cloneFunctionApplicationWhileReplacingPredicateApplication(argument.getFunctionApplication(),
								predicateAppl),false));
			} else if (argument.getPredicateApplication()!=null) {
				if (argument.getPredicateApplication().getPredicate().contentEquals(predicateAppl.getPredicate(), false))
					varArguments.add(ruleMlnModel.buildMLNVarArgument(predicateAppl, false));
				varArguments.add(
						ruleMlnModel.buildMLNVarArgument(clonePredicateApplicationWhileReplacingPredicateApplication(argument.getPredicateApplication(),
								predicateAppl), false));
			}  else {
				varArguments.add(argument);
			}
		}
		return varArguments;
	}
	
	private Pair<MLNPredicate, Integer> findPredicateContainingProbabilityWeightVariable(
			MLNVariable variable, MLNPlainFormula formula) {
		Pair<MLNPredicate, Integer> pair = null;
		if (formula.getPredicateApplication()!=null) {
			return findPredicateContainingProbabilityWeightVariable(variable,
					formula.getPredicateApplication().getPredicate(), 
					formula.getPredicateApplication().getArguments());
		} else if (formula.getFunctionApplication()!=null) {
			return findPredicateContainingProbabilityWeightVariable(variable,
					formula.getFunctionApplication().getArguments());
		} else if (formula.getOperatorApplication()!=null) {
			return findPredicateContainingProbabilityWeightVariable(formula.getOperatorApplication().getArguments(),
					variable );
		} else if (formula.getQuantification()!=null) {
			return findPredicateContainingProbabilityWeightVariable(variable, formula.getQuantification().getPlainFormula());
		}
		return pair;
	}
	
	private Pair<MLNPredicate, Integer> findPredicateContainingProbabilityWeightVariable(List<MLNPlainFormula> formulas,
			MLNVariable variable) {
		Pair<MLNPredicate, Integer> pair = null;
		for (MLNPlainFormula formula : formulas) {
			pair = findPredicateContainingProbabilityWeightVariable(variable, formula);
			if (pair!=null)
				break;
		}
		return pair;
	}
	
	
	private Pair<MLNPredicate, Integer> findPredicateContainingProbabilityWeightVariable(MLNVariable variable, 
			MLNPredicate predicate,
			List<MLNVarArgument> arguments) {
		Pair<MLNPredicate, Integer> pair = null;
		int argumentCounter = 0;
		for (MLNVarArgument argument: arguments) {
			if (argument.getVariable()!=null) {
				if (argument.getVariable().contentEquals(variable, false))
					pair = new Pair<MLNPredicate, Integer>(predicate, 
							argumentCounter);
			} else if (argument.getPredicateApplication()!=null)
				pair = findPredicateContainingProbabilityWeightVariable(variable, 
						new MLNPlainFormula(null,null,argument.getPredicateApplication(),null));
			else if (argument.getFunctionApplication()!=null)
				pair = findPredicateContainingProbabilityWeightVariable(variable, 
						new MLNPlainFormula(null,argument.getFunctionApplication(),null,null));
			argumentCounter++;
		}
		return pair;
	}
	
	private Pair<MLNPredicate, Integer> findPredicateContainingProbabilityWeightVariable(MLNVariable variable, 
			List<MLNVarArgument> arguments) {
		Pair<MLNPredicate, Integer> pair = null;
		for (MLNVarArgument argument: arguments) {
			if (argument.getPredicateApplication()!=null)
				pair = findPredicateContainingProbabilityWeightVariable(variable, 
						new MLNPlainFormula(null,null,argument.getPredicateApplication(),null));
			else if (argument.getFunctionApplication()!=null)
				pair = findPredicateContainingProbabilityWeightVariable(variable, 
						new MLNPlainFormula(null,argument.getFunctionApplication(),null,null));
		}
		return pair;
	}
	
	private List<MLNGroundAtom> getGroundAtoms(MLNPredicate predicate)  {
		List<MLNGroundAtom> atoms = new ArrayList<MLNGroundAtom>();
		for (MLNGroundAtom atom: ruleMlnModel.getAll(MLNGroundAtom.class)) {
			if (atom.getPredicate().contentEquals(predicate, false)) {
				atoms.add(atom);
			}
		}
		return atoms;
	}
	
	private Map<MLNModel, List<MLNGroundFormula>> getGroundFormulas(MLNPredicate predicate)  {
			Map<MLNModel, List<MLNGroundFormula>> map = new HashMap<MLNModel, List<MLNGroundFormula>>();
			for (MLNModel model: evidenceMlnModels) {
				model.integrateModel(ruleMlnModel);
				List<MLNGroundFormula> formulas = new ArrayList<MLNGroundFormula>();
				for (MLNGroundFormula formula: model.getAll(MLNGroundFormula.class)) {
					if ((formula.getGroundAtom()!=null)&&(formula.getGroundAtom()
							.getPredicate().contentEquals(predicate, false))) {
						formulas.add(formula);
					}
				}
				map.put(model, formulas);
			}
			return map;
		}
	
	private Map<MLNVariable, List<MLNFormula>> associateFormulasWithWeightVariables(List<MLNFormula> formulas)  
		throws MLNException {
		Map<MLNVariable, List<MLNFormula>> map = new HashMap<MLNVariable, List<MLNFormula>>();
		MLNVariable variable;
		for (MLNFormula formula: formulas) {
			variable = identifyProbabilityWeightVariable(formula);
			if (map.containsKey(variable))
				map.get(variable).add(formula);
			else {
				map.put(variable, new ArrayList<MLNFormula>());
				map.get(variable).add(formula);
			}
		}
		return map;
	}
	
	private MLNVariable identifyProbabilityWeightVariable(MLNFormula formula) throws MLNException {
		MLNVariable weightVariable = null;
		if (formula.getProbabilityWeight()!=null) {
			if (formula.getProbabilityWeight().getVarWeight() != null) {
				weightVariable = formula.getProbabilityWeight().getVarWeight();
			}
		}
		if (weightVariable!=null) {
			return weightVariable;
		} else {
			MLNError.NO_VARIABLE_WEIGHT.exception();
			return null;
		}
	}
	
	private List<MLNFormula> collectVariableProbabilityWeightFormulas() {
		try {
			return MapReduce.filter(ruleMlnModel.getAll(MLNFormula.class), new Filter<MLNFormula>() {
				@Override
				public boolean test(MLNFormula object) {
					return ((object.getProbabilityWeight()!=null)&&(object.getProbabilityWeight().getVarWeight()!=null));
				}
			});
		} catch (MapReduceException e) {
			throw new RuntimeException();
		}
	}

	public MLNModel getCombinedMlnModel() {
		return ruleMlnModel;
	}

	public void setCombinedMlnModel(MLNModel mlnModel) {
		this.ruleMlnModel = mlnModel;
	}
	
	

}
