package com.rapidminer.operator.modelling;

import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.operator.modelling.configuration.fixed.MLNFileRole;

/**
 * Describes an evidence file reader operator.
 * <p>
 * Provides its superclass with file role information. The parent class ({@link MLNAbstractFileReaderOperator})
 * then creates output ports for all example set types required by the file role.
 * 
 * @author Yann Kiraly
 *
 */
public class MLNEvidenceFileReaderOperator extends MLNAbstractFileReaderOperator {

	/**
	 * Passes an OperatorDescription on to {@link MLNAbstractFileReaderOperator}.
	 * 
	 * @param description: OperatorDescription RapidMiner requires to be accepted by all operator classes.
	 * @throws OperatorException
	 */
	public MLNEvidenceFileReaderOperator(OperatorDescription description)
			throws OperatorException {
		super(description);
	}

	@Override
	protected MLNFileRole getRole() {
		return MLNFileRole.EVIDENCE;
	}

}
