package com.rapidminer.operator.modelling.converters.utilities.cnf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.rapidminer.operator.OperatorException;
import com.rapidminer.operator.modelling.MLNOperator;
import com.rapidminer.operator.modelling.configuration.MLNFileType;
import com.rapidminer.operator.modelling.configuration.fixed.MLNException;
import com.rapidminer.operator.modelling.configuration.fixed.MLNFileRole;
import com.rapidminer.operator.modelling.converters.MLNConverter;
import com.rapidminer.operator.modelling.converters.utilities.ConverterUtilities;
import com.rapidminer.operator.modelling.model.MLNFormula;
import com.rapidminer.operator.modelling.model.MLNModel;
import com.rapidminer.operator.modelling.model.MLNPlainFormula;
import com.rapidminer.operator.modelling.model.MLNQuantification;
import com.rapidminer.operator.modelling.model.MLNRelation;
import com.rapidminer.operator.modelling.model.MLNVariable;
import com.rapidminer.operator.modelling.model.MLNWeight;
import com.rapidminer.operator.modelling.model.operators.MLNFormulaOperator;
import com.rapidminer.operator.modelling.model.operators.MLNOperatorApplication;

public class CNFConverter {
	private MLNModel mlnModel;
	int counter = 0;
	
	
	public CNFConverter(MLNModel mlnModel) {
		this.mlnModel = mlnModel;
	}
//	
//	public static void main(String[] args) {
//		try {
//			try {
//				MLNOperator.loadConfiguration();
//			} catch (OperatorException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			MLNConverter conv = MLNConverter.getConverterForFileType(MLNFileType.fromKey("Tuffy"), 
//					new FileInputStream("/Users/yann/test.mln"));
//			MLNModel model = conv.buildModel(MLNFileRole.RULES);
//			List<MLNFormula> formulasToRemove = new ArrayList<MLNFormula>();
//			CNFConverter cnfConv = new CNFConverter(model);
//			for (MLNFormula formula: model.getAll(MLNFormula.class)) {
//				formulasToRemove.add(formula);
//				for (MLNFormula newFormula: cnfConv.formulaToCNF(formula)) {
//					model.addMlnObject(newFormula);
//				}
//			}
//			conv = MLNConverter.getConverterForFileType(MLNFileType.fromKey("Tuffy"), 
//					System.out);
//			conv.convertModel(model, MLNFileRole.RULES);
//		} catch (MLNException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public static void convertModelToCNF(MLNModel model) {
		List<MLNFormula> formulasToRemove = new ArrayList<MLNFormula>();
		CNFConverter cnfConv = new CNFConverter(model);
		for (MLNFormula formula: model.getAll(MLNFormula.class)) {
			formulasToRemove.add(formula);
			try {
				for (MLNFormula newFormula: cnfConv.formulaToCNF(formula)) {
					model.addMlnObject(newFormula);
				}
			} catch (MLNException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (MLNFormula formula: formulasToRemove) {
			model.removeMlnObject(formula);
		}
	}
	
	public List<MLNFormula> formulaToCNF(MLNFormula formula) throws MLNException {
		List<MLNPlainFormula> plainFormulas = plainFormulaToCNF(formula.getPlainFormula());
		List<MLNFormula> formulas = new ArrayList<MLNFormula>();
		MLNWeight newProbWeight=null, newUtilWeight=null;
		int divisor = plainFormulas.size();
		if (divisor>0) {
			if (formula.getProbabilityWeight()!=null) {
				if (formula.getProbabilityWeight().getSpecificWeight()!=null)
					newProbWeight = mlnModel.buildMLNWeight(formula.getProbabilityWeight().getSpecificWeight()/divisor);
				else
					newProbWeight = formula.getProbabilityWeight();
			}
			if (formula.getUtilityWeight()!=null) {
				if (formula.getProbabilityWeight().getSpecificWeight()!=null)
					newUtilWeight = mlnModel.buildMLNWeight(formula.getUtilityWeight().getSpecificWeight()/divisor);
				else
					newUtilWeight = formula.getUtilityWeight();
			}
			for (MLNPlainFormula plainFormula : plainFormulas) {
				formulas.add(new MLNFormula(plainFormula, newProbWeight,
						newUtilWeight, formula.isHardRule()));
			}
			return formulas;
		} else
			return new ArrayList<MLNFormula>();
	}
	
	public List<MLNPlainFormula> plainFormulaToCNF(MLNPlainFormula plainFormula) throws MLNException {
		plainFormula = removeEquivalence(plainFormula);
		plainFormula = removeImplication(plainFormula);
		plainFormula = pushNegationDown(plainFormula);
 		plainFormula = moveQuantifiersLeft(plainFormula);
		plainFormula = distributeAndOverOr(plainFormula);
		plainFormula = flattenParentheses(plainFormula);
		return removeAlwaysTrueFormulas(separateConjunctions(plainFormula));
	}
	
	private List<MLNPlainFormula> removeAlwaysTrueFormulas(List<MLNPlainFormula> plainFormulas) {
		Iterator<MLNPlainFormula> iterator = plainFormulas.iterator();
		MLNPlainFormula next;
		while (iterator.hasNext()) {
			next = iterator.next();
			if (isAlwaysTrueFormula(next))
				iterator.remove();
		}
		return plainFormulas;
	}
	
	//Only recursive for quantifications.
	private boolean isAlwaysTrueFormula(MLNPlainFormula plainFormula) {
		MLNOperatorApplication op;
		MLNPlainFormula arg1, arg2;
		if (plainFormula.getQuantification()!=null) {
			return isAlwaysTrueFormula(plainFormula.getQuantification().getPlainFormula());
		} else if (plainFormula.getPredicateApplication()!=null || plainFormula.getFunctionApplication()!=null)
			return false;
		else if (plainFormula.getOperatorApplication()!=null) {
			op = plainFormula.getOperatorApplication();
			if (op.getOperator().equals(mlnModel.getOperator(MLNModel.OR_SYMBOL))) {
				arg1 = op.getArguments().get(0);
				arg2 = op.getArguments().get(1);
				if (arg1.getOperatorApplication()!=null && arg1.getOperatorApplication().getOperator().equals(mlnModel.getOperator(
						MLNModel.NOT_SYMBOL))) {
					if (arg1.getOperatorApplication().getArguments().get(0).contentEquals(
								arg2, false))
						return true;
					else
						return false;	
				} else if (arg2.getOperatorApplication()!=null && arg2.getOperatorApplication().getOperator().equals(mlnModel.getOperator(
						MLNModel.NOT_SYMBOL))) {
					if (arg2.getOperatorApplication().getArguments().get(0).contentEquals(
								arg1, false))
						return true;
					else
						return false;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else
			return false;
	}
	
	private List<MLNPlainFormula> separateConjunctions(MLNPlainFormula plainFormula) {
		List<MLNPlainFormula> list = new ArrayList<MLNPlainFormula>();
		List<MLNVariable> varList;
		if (plainFormula.getOperatorApplication()!=null) {
			if (plainFormula.getOperatorApplication().getOperator().equals(
					mlnModel.getOperator(MLNModel.AND_SYMBOL))) {
				list.addAll(separateConjunctions(plainFormula.getOperatorApplication()
						.getArguments().get(0)));
				list.addAll(separateConjunctions(plainFormula.getOperatorApplication()
								.getArguments().get(1)));
			} else if (plainFormula.getOperatorApplication().getOperator().equals(
					mlnModel.getOperator(MLNModel.OR_SYMBOL))){
				return ConverterUtilities.compose(plainFormula);
			} else if (plainFormula.getOperatorApplication().getOperator().equals(mlnModel.getOperator(MLNModel.PARENTHESES_SYMBOL))) {
				list.add(plainFormula.getOperatorApplication().getArguments().get(0));
			} else if (plainFormula.getOperatorApplication().getOperator().equals(mlnModel.getOperator(MLNModel.NOT_SYMBOL))) {
				list.add(plainFormula);
			}
		} else if (plainFormula.getQuantification()!=null) {
			for (MLNPlainFormula formula: separateConjunctions(plainFormula.getQuantification().getPlainFormula())) {
				varList = new ArrayList<MLNVariable>();
				varList.addAll(plainFormula.getQuantification().getArguments());
				list.add(makeQuantification(plainFormula.getQuantification().getSymbol(),
						plainFormula.getQuantification().getNumber(), plainFormula.getQuantification().getRelation(),
						varList, formula));
			}
		} else {
			return ConverterUtilities.compose(plainFormula);
		}
		return list;
	}
	
	private MLNPlainFormula removeOperatorApplication(MLNPlainFormula plainFormula, String opSymbol,
			OperatorApplicationConverter converter) {
		if (plainFormula.getFunctionApplication()!=null) {
			return plainFormula;
		} else if (plainFormula.getPredicateApplication()!=null) {
			return plainFormula;
		} else if (plainFormula.getQuantification()!=null) {
			plainFormula.getQuantification().setPlainFormula(
					removeOperatorApplication(plainFormula.getQuantification().getPlainFormula(),
					opSymbol, converter));
			return plainFormula;
		} else if (plainFormula.getOperatorApplication()!=null) {
			if (plainFormula.getOperatorApplication().getOperator().equals(mlnModel.getOperator(
					opSymbol))) {
				return converter.convert(plainFormula.getOperatorApplication());
			} else {
				for (MLNPlainFormula formula: plainFormula.getOperatorApplication().getArguments()) {
					plainFormula.getOperatorApplication().getArguments().set(
							plainFormula.getOperatorApplication().getArguments().indexOf(formula),
							removeOperatorApplication(formula,
									opSymbol, converter));
				}
				return plainFormula;
			}
		} else {
			return null;
		}
	}
	
	private MLNPlainFormula removeEquivalence(MLNPlainFormula plainFormula) {
		return removeOperatorApplication(plainFormula, MLNModel.IFF_SYMBOL,
				new OperatorApplicationConverter() {
					@Override
					public MLNPlainFormula convert(MLNOperatorApplication appl) {
						return makeConjunction(makeImplication(removeOperatorApplication(appl.getArguments().get(0),
								MLNModel.IFF_SYMBOL, this),
								removeEquivalence(appl.getArguments().get(1))), 
								makeImplication(removeOperatorApplication(appl.getArguments().get(1),
										MLNModel.IFF_SYMBOL, this),
										removeEquivalence(appl.getArguments().get(0))));
					}
		});
	}
	
	private MLNPlainFormula removeImplication(MLNPlainFormula plainFormula) {
		return removeOperatorApplication(plainFormula, MLNModel.IMPLIES_SYMBOL,
				new OperatorApplicationConverter() {
					@Override
					public MLNPlainFormula convert(MLNOperatorApplication appl) {
						return makeDisjunction(makeNegation(removeOperatorApplication(appl.getArguments().get(0),
								MLNModel.IMPLIES_SYMBOL, this)), 
								removeOperatorApplication(appl.getArguments().get(1),
										MLNModel.IMPLIES_SYMBOL, this));
					}
		});
	}
	
	private MLNPlainFormula pushNegationDown(MLNPlainFormula plainFormula) {
		if (plainFormula.getOperatorApplication()!=null) {
			if (plainFormula.getOperatorApplication().getOperator().equals(
					mlnModel.getOperator(MLNModel.NOT_SYMBOL))) {
				if ((plainFormula.getOperatorApplication().getArguments().get(0).getPredicateApplication()!=null) 
						|| (plainFormula.getOperatorApplication().getArguments().get(0).getFunctionApplication()!=null) ) {
					return plainFormula;
				} else
					return applyDeMorgan(plainFormula);
			} else {
				for (int counter = 0; counter < plainFormula.getOperatorApplication().getArguments().size(); counter++) {
					plainFormula.getOperatorApplication().getArguments().set(counter, 
							pushNegationDown(plainFormula.getOperatorApplication().getArguments().get(counter)));
				}
				return plainFormula;
			}
		} else if (plainFormula.getQuantification()!=null) {
			plainFormula.getQuantification().setPlainFormula(
					pushNegationDown(plainFormula.getQuantification().getPlainFormula()));
			return plainFormula;
		} else {
			return plainFormula;
		}
	}

	private MLNPlainFormula applyDeMorgan(MLNPlainFormula plainFormula) {
		MLNPlainFormula arg = plainFormula.getOperatorApplication().getArguments().get(0);
		if (arg.getQuantification()!=null)
				return pushNegationDown(negateQuantification(arg.getQuantification()));
		else if (arg.getOperatorApplication()!=null) {
			 return pushNegationDown(negateOperatorApplication(arg.getOperatorApplication()));
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	private MLNPlainFormula distributeAndOverOr(MLNOperatorApplication and, MLNPlainFormula otherArgument) {
		otherArgument = distributeAndOverOr(otherArgument);
		return makeConjunction(makeDisjunction(distributeAndOverOr(and.getArguments().get(0)), otherArgument), 
				makeDisjunction(distributeAndOverOr(and.getArguments().get(1)), otherArgument));
	}
	
	private MLNPlainFormula distributeAndOverOr(MLNPlainFormula plainFormula) {
		if (plainFormula.getPredicateApplication()!=null || 
				plainFormula.getFunctionApplication()!=null)
			return plainFormula;
		else if (plainFormula.getOperatorApplication()!=null) {
			if (plainFormula.getOperatorApplication().getOperator().equals(mlnModel.getOperator(
							MLNModel.OR_SYMBOL))) {
				if ((plainFormula.getOperatorApplication().getArguments().get(0).getOperatorApplication()!=null)
					&& (plainFormula.getOperatorApplication().getArguments().get(0).getOperatorApplication()
					.getOperator().equals(mlnModel.getOperator(MLNModel.AND_SYMBOL)))) {
					return distributeAndOverOr(plainFormula.getOperatorApplication().getArguments().get(0).getOperatorApplication(),
							plainFormula.getOperatorApplication().getArguments().get(1));
				} else if ((plainFormula.getOperatorApplication().getArguments().get(1).getOperatorApplication()!=null)
						&& (plainFormula.getOperatorApplication().getArguments().get(1).getOperatorApplication()
								.getOperator().equals(mlnModel.getOperator(MLNModel.AND_SYMBOL)))) {
					return distributeAndOverOr(plainFormula.getOperatorApplication().getArguments().get(1).getOperatorApplication(),
							plainFormula.getOperatorApplication().getArguments().get(0));
				} else if ((plainFormula.getOperatorApplication().getArguments().get(0).getOperatorApplication()!=null)
					&& (plainFormula.getOperatorApplication().getArguments().get(0).getOperatorApplication()
					.getOperator().equals(mlnModel.getOperator(MLNModel.PARENTHESES_SYMBOL))) && (plainFormula.getOperatorApplication().getArguments().get(0).getOperatorApplication()
							.getArguments().get(0).getOperatorApplication()!=null)
							&& (plainFormula.getOperatorApplication().getArguments().get(0).getOperatorApplication()
							.getArguments().get(0).getOperatorApplication()
							.getOperator().equals(mlnModel.getOperator(MLNModel.AND_SYMBOL)))) {
						return distributeAndOverOr(
								plainFormula.getOperatorApplication().getArguments().get(0).getOperatorApplication()
								.getArguments().get(0).getOperatorApplication(),
								plainFormula.getOperatorApplication().getArguments().get(1));
				} else if ((plainFormula.getOperatorApplication().getArguments().get(1).getOperatorApplication()!=null)
					&& (plainFormula.getOperatorApplication().getArguments().get(1).getOperatorApplication()
					.getOperator().equals(mlnModel.getOperator(MLNModel.PARENTHESES_SYMBOL)))
					&& (plainFormula.getOperatorApplication().getArguments().get(1).getOperatorApplication()
							.getArguments().get(0).getOperatorApplication()!=null)
							&& (plainFormula.getOperatorApplication().getArguments().get(1).getOperatorApplication()
							.getArguments().get(0).getOperatorApplication()
							.getOperator().equals(mlnModel.getOperator(MLNModel.AND_SYMBOL)))) {
						return distributeAndOverOr(
								plainFormula.getOperatorApplication().getArguments().get(1).getOperatorApplication()
								.getArguments().get(0).getOperatorApplication(),
								plainFormula.getOperatorApplication().getArguments().get(0));
				} else {
					return makeDisjunction(
							distributeAndOverOr(plainFormula.getOperatorApplication().getArguments().get(0)),
							distributeAndOverOr(plainFormula.getOperatorApplication().getArguments().get(1)));
				}
			} else if (plainFormula.getOperatorApplication().getOperator().equals(mlnModel.getOperator(MLNModel.AND_SYMBOL))) {
				return makeConjunction(distributeAndOverOr(plainFormula.getOperatorApplication().getArguments().get(0)),
						distributeAndOverOr(plainFormula.getOperatorApplication().getArguments().get(1)));
			} else if (plainFormula.getOperatorApplication().getOperator().equals(mlnModel.getOperator(MLNModel.NOT_SYMBOL)))
				return makeNegation(distributeAndOverOr(plainFormula.getOperatorApplication().getArguments().get(0)));
			else if (plainFormula.getOperatorApplication().getOperator().equals(mlnModel.getOperator(MLNModel.PARENTHESES_SYMBOL)))
				return makeParentheses(distributeAndOverOr(plainFormula.getOperatorApplication().getArguments().get(0)));
			else
				throw new RuntimeException();
		}
		 else if (plainFormula.getQuantification()!=null) {
			plainFormula.getQuantification().setPlainFormula(distributeAndOverOr(
					plainFormula.getQuantification().getPlainFormula()));
			return plainFormula;
		} else {
			throw new RuntimeException();
		}
	}
	
	private MLNPlainFormula moveQuantifiersLeft(MLNPlainFormula plainFormula) {
		List<MLNQuantification> quantifications = new ArrayList<MLNQuantification>();
		return applyQuantifications(quantifications, moveQuantifiersLeft(plainFormula, quantifications));
	}
	
	private MLNPlainFormula moveQuantifiersLeft(MLNPlainFormula plainFormula, List<MLNQuantification> quantifications) {
		if ((plainFormula.getPredicateApplication()!=null) ||
				plainFormula.getFunctionApplication()!=null)
			return plainFormula;
		else if (plainFormula.getQuantification()!=null) {
			quantifications.add(plainFormula.getQuantification());
			return moveQuantifiersLeft(plainFormula.getQuantification().getPlainFormula(), quantifications);
		} else {
			for (MLNPlainFormula formula: plainFormula.getOperatorApplication().getArguments()) {
				plainFormula.getOperatorApplication().getArguments().set(
						plainFormula.getOperatorApplication().getArguments().indexOf(formula),
						moveQuantifiersLeft(formula, quantifications));
			}
			return plainFormula;
		}
	}
	
	private MLNPlainFormula flattenParentheses(MLNPlainFormula formula) {
		MLNPlainFormula arg1, arg2;
		MLNFormulaOperator op;
		if ((formula.getPredicateApplication()!=null)
			|| (formula.getFunctionApplication()!=null)) {
			return formula;
		} else if (formula.getQuantification()!=null) {
			formula.getQuantification().setPlainFormula(
					flattenParentheses(formula.getQuantification().getPlainFormula()));
			return formula;
		} else {
			if (formula.getOperatorApplication().getOperator().equals(mlnModel.getOperator(MLNModel.NOT_SYMBOL)))
				return formula;
			else {
				op = formula.getOperatorApplication().getOperator();
				if (formula.getOperatorApplication().getArguments().get(0).getOperatorApplication()!=null 
						&& formula.getOperatorApplication().getArguments().get(0).getOperatorApplication()
						.getOperator().equals(mlnModel.getOperator(MLNModel.PARENTHESES_SYMBOL))
						&& formula.getOperatorApplication().getArguments().get(0).getOperatorApplication()
						.getArguments().get(0).getOperatorApplication()!=null
						&& formula.getOperatorApplication().getArguments().get(0).getOperatorApplication()
						.getArguments().get(0).getOperatorApplication().getOperator().contentEquals(op, false)) {
					arg1 = formula.getOperatorApplication().getArguments().get(0).getOperatorApplication()
							.getArguments().get(0);
				} else {
					arg1 = formula.getOperatorApplication().getArguments().get(0);
				}
				if (formula.getOperatorApplication().getArguments().get(1).getOperatorApplication()!=null 
						&& formula.getOperatorApplication().getArguments().get(1).getOperatorApplication()
						.getOperator().equals(mlnModel.getOperator(MLNModel.PARENTHESES_SYMBOL))
						&& formula.getOperatorApplication().getArguments().get(1).getOperatorApplication()
						.getArguments().get(0).getOperatorApplication()!=null
						&& formula.getOperatorApplication().getArguments().get(1).getOperatorApplication()
						.getArguments().get(0).getOperatorApplication().getOperator().contentEquals(op, false)) {
					arg2 = formula.getOperatorApplication().getArguments().get(1).getOperatorApplication()
							.getArguments().get(0);
				} else {
					arg2 = formula.getOperatorApplication().getArguments().get(1);
				}
				formula.getOperatorApplication().getArguments().set(0, arg1);
				formula.getOperatorApplication().getArguments().set(1, arg2);
				return formula;
			}
		}
			
	}
	
	private MLNPlainFormula negateOperatorApplication(MLNOperatorApplication appl) {
		if (appl.getOperator().equals(mlnModel.getOperator(MLNModel.NOT_SYMBOL)))
			return appl.getArguments().get(0);
		else if (appl.getOperator().equals(mlnModel.getOperator(MLNModel.AND_SYMBOL)))
			return makeDisjunction(makeNegation(appl.getArguments().get(0)),
					makeNegation(appl.getArguments().get(1)));
		else if (appl.getOperator().equals(mlnModel.getOperator(MLNModel.OR_SYMBOL))) {
			return makeConjunction(makeNegation(appl.getArguments().get(0)),
					makeNegation(appl.getArguments().get(1)));
		} else if (appl.getOperator().equals(mlnModel.getOperator(MLNModel.PARENTHESES_SYMBOL))) {
			if (appl.getArguments().get(0).getOperatorApplication()!=null)
				return negateOperatorApplication(appl.getArguments().get(0).getOperatorApplication());
			else if (appl.getArguments().get(0).getQuantification()!=null)
				return negateQuantification(appl.getArguments().get(0).getQuantification());
			else
				return makeNegation(appl.getArguments().get(0));
		} else
			throw new IllegalArgumentException();
	}
	
	private MLNPlainFormula applyQuantifications(List<MLNQuantification> quantifications, MLNPlainFormula formula) {
		MLNPlainFormula currentFormula = formula;
		MLNQuantification quant;
		for (int counter = quantifications.size()-1; counter >= 0; counter--) {
			quant = quantifications.get(counter);
			currentFormula = makeQuantification(quant.getSymbol(), quant.getNumber(),
					quant.getRelation(), quant.getArguments(), currentFormula);
		}
		return currentFormula;
	}
	
	private MLNPlainFormula makeQuantification(String symbol, Integer number, MLNRelation relation, 
			List<MLNVariable> variables, MLNPlainFormula formula) {
		return new MLNPlainFormula(null, null, null, new MLNQuantification(symbol,
				number==MLNQuantification.E_QUANT_NUMBER
				&&
				relation.equals(MLNQuantification.E_QUANT_RELATION),
				number==MLNQuantification.U_QUANT_NUMBER
				&&
				relation.equals(MLNQuantification.U_QUANT_RELATION), formula, variables, relation, number));
	}
	
	private MLNPlainFormula makeEQuant(List<MLNVariable> variables, MLNPlainFormula formula) {
		return makeQuantification(MLNQuantification.E_QUANT_NAME, MLNQuantification.E_QUANT_NUMBER,
				MLNQuantification.E_QUANT_RELATION, variables, formula);
	}
	
	private MLNPlainFormula negateQuantification(MLNQuantification quantification) {
		if (quantification.getuQuant()) {
			return makeEQuant(quantification.getArguments(), makeNegation(
					quantification.getPlainFormula()));
		} else if (quantification.geteQuant()) {
			return makeNegation(quantification.getPlainFormula());
		} else {
			return makeQuantification(quantification.getSymbol(), quantification.getNumber(),
					MLNRelation.getOpposite(quantification.getRelation()), 
					quantification.getArguments(), quantification.getPlainFormula());
		}
	}
	
	private MLNPlainFormula makeOperatorApplication(String opSymbol, MLNPlainFormula op1,
			MLNPlainFormula op2) {
		if (op2 != null)
			return new MLNPlainFormula(new MLNOperatorApplication(
					mlnModel.getOperator(opSymbol), ConverterUtilities.compose(op1, op2)), null, null, null);
		else
			return new MLNPlainFormula(new MLNOperatorApplication(
					mlnModel.getOperator(opSymbol), ConverterUtilities.compose(op1)), null, null, null);
	}
	
	private MLNPlainFormula makeConjunction(MLNPlainFormula op1,
			MLNPlainFormula op2) {
		return makeOperatorApplication(MLNModel.AND_SYMBOL, op1, op2);
	}
	
	private MLNPlainFormula makeDisjunction(MLNPlainFormula op1,
			MLNPlainFormula op2) {
		return makeOperatorApplication(MLNModel.OR_SYMBOL, op1, op2);
	}
	
	private MLNPlainFormula makeImplication(MLNPlainFormula op1,
			MLNPlainFormula op2) {
		return makeOperatorApplication(MLNModel.IMPLIES_SYMBOL, op1, op2);
	}
	
	private MLNPlainFormula makeNegation(MLNPlainFormula op) {
		return makeOperatorApplication(MLNModel.NOT_SYMBOL, 
				op, null);
	}
	
	private MLNPlainFormula makeParentheses(MLNPlainFormula op) {
		return makeOperatorApplication(MLNModel.PARENTHESES_SYMBOL, 
				op, null);
	}

}
