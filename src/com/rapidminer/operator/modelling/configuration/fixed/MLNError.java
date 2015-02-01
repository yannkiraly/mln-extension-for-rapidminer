package com.rapidminer.operator.modelling.configuration.fixed;

public enum MLNError {	
	VAR_WEIGHTS_INF("Variable weights not supported by engine for inference."),
	VAR_WEIGHTS_LEARN("Variable weights not supported by engine for learning."),
	REMOVE_NOT_SUPPORTED("Removing unsupported constraints not supported by converter."),
	LE_CONV("Conversion of <= constraints not supported by file type converter."),
	ONLY_ONE_EXCL("Only one variable in a predicate may be restricted to a single value."),
	INPUT_ERROR("InputStream not defined but buildModel requested."),
	OUTPUT_ERROR("OutputStream not defined but convertModel requested."),
	SURROUNDING_NO_CLOSING("Operator is surrounding but does not have a closing."),
	UTILITY_WEIGHTS("Utility weights not supported by engine."),
	INFIX_NOT_TWO("Operator is infix but does not have arity = 2."),
	QUANTIFICATION_TYPE("Quantification type not supported by engine."),
	FILE_ROLE("File role could not be identified."),
	NO_VARIABLE_WEIGHT("No variable weight to remove."),
	MC_SAT_OR_GIBBS("Choose either MC-SAT or Gibbs samling."),
	FILE_NOT_FOUND("File not found."),
	LEARNING_TYPE("Learning type not supported by engine."),
	INFERENCE_TYPE("Inference type not supported by engine.");
	private String message;
	
	private MLNError(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void exception() throws MLNException {
		throw new MLNException(message);
	}

}
