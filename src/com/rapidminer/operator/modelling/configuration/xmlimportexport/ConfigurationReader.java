package com.rapidminer.operator.modelling.configuration.xmlimportexport;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.bind.JAXBException;

import org.xml.sax.SAXException;

import com.rapidminer.condition.mln.MLNCondition;
import com.rapidminer.operator.Operator;
import com.rapidminer.operator.modelling.adapters.MLNInferenceAdapter;
import com.rapidminer.operator.modelling.adapters.MLNLearningAdapter;
import com.rapidminer.operator.modelling.configuration.MLNEngine;
import com.rapidminer.operator.modelling.configuration.MLNFileType;
import com.rapidminer.operator.modelling.configuration.MLNGeneralParameter;
import com.rapidminer.operator.modelling.configuration.MLNOptionalParameter;
import com.rapidminer.operator.modelling.configuration.fixed.MLNInferenceType;
import com.rapidminer.operator.modelling.configuration.fixed.MLNLearningType;
import com.rapidminer.operator.modelling.configuration.fixed.MLNParameterType;
import com.rapidminer.operator.modelling.configuration.xsd.generalparameter.GeneralParameters;
import com.rapidminer.operator.modelling.configuration.xsd.generalparameter.GeneralParameters.GeneralParameter;
import com.rapidminer.operator.modelling.configuration.xsd.mlnenginespecification.MlnEngine;
import com.rapidminer.operator.modelling.configuration.xsd.mlnenginespecification.MlnEngine.InferenceTypes.InferenceType;
import com.rapidminer.operator.modelling.configuration.xsd.mlnenginespecification.MlnEngine.LearningTypes.LearningType;
import com.rapidminer.operator.modelling.configuration.xsd.mlnenginespecification.MlnEngines;
import com.rapidminer.operator.modelling.configuration.xsd.mlnenginespecification.ObjectFactory;
import com.rapidminer.operator.modelling.configuration.xsd.mlnfiletypespecification.FileType;
import com.rapidminer.operator.modelling.configuration.xsd.mlnfiletypespecification.FileTypes;
import com.rapidminer.operator.modelling.configuration.xsd.optionalparameterspecification.OptionalParameter;
import com.rapidminer.operator.modelling.configuration.xsd.optionalparameterspecification.OptionalParameter.Categories.Category;
import com.rapidminer.operator.modelling.configuration.xsd.optionalparameterspecification.OptionalParameter.ParameterConditions;
import com.rapidminer.operator.modelling.configuration.xsd.optionalparameterspecification.OptionalParameters;
import com.rapidminer.operator.modelling.converters.MLNConverter;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduce;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.MapReduceException;
import com.rapidminer.operator.modelling.converters.utilities.mapreduce.Mappable;
import com.rapidminer.parameter.ParameterHandler;
import com.rapidminer.parameter.conditions.ParameterCondition;

public class ConfigurationReader {
	
	public static void loadMlnEngines() throws JAXBException, MapReduceException,
		ClassNotFoundException, InstantiationException, IllegalAccessException, SAXException,
		FileNotFoundException  {
		XMLObjectImporter<MlnEngines> importer = new XMLObjectImporter<MlnEngines>();
		MlnEngines engines = importer.importObject(ObjectFactory.class, 
				ConfigurationReader.class.getResourceAsStream("/com/rapidminer/resources/extension/MLNEngineSpecifications.xml"),
				ConfigurationReader.class.getResource("/MLNEngineSpecification.xsd"));
//				"/Users/yann/Documents/workspace/RapidMiner_MLN_Extension/"+
//				"resources/com/rapidminer/resources/extension/MLNEngineSpecifications.xml"
//				, "/Users/yann/Documents/workspace/RapidMiner_MLN_Extension/src/MLNEngineSpecification.xsd");
		for (MlnEngine engine: engines.getMlnEngine()) {
			new MLNEngine(engine.getKey(), (MLNInferenceAdapter) MLNInferenceAdapter.class.getClassLoader()
					.loadClass(engine.getInferenceAdapter()).newInstance(),
					(MLNLearningAdapter) MLNLearningAdapter.class
					.getClassLoader().loadClass(engine.getLearningAdapter()).newInstance(),
					engine.getFileType(), (engine.getLearningTypes()!=null)?
					MapReduce.map(engine.getLearningTypes().getLearningType(), 
					new Mappable<LearningType, MLNLearningType>() {
						@Override
						public MLNLearningType apply(LearningType object)
								throws MapReduceException {
							return MLNLearningType.fromKey(object.getKey());
						}
			}):null, (engine.getInferenceTypes()!=null)?
					MapReduce.map(engine.getInferenceTypes().getInferenceType(), 
					new Mappable<InferenceType, MLNInferenceType>() {
				@Override
				public MLNInferenceType apply(InferenceType object)
						throws MapReduceException {
					return MLNInferenceType.fromKey(object.getKey());
				}
			}):null, engine.isQueryAtomsInRules(), engine.isMultipleEvidenceFilesInference(), 
			engine.isMultipleEvidenceFilesLearning(), engine.getVariableWeights(),
			engine.isPlusNotation(), engine.isExclConstraintConversion());
		}
	}
	
	public static void loadMlnFileTypes() throws JAXBException, MapReduceException,
		IllegalAccessException, ClassNotFoundException, InstantiationException, SAXException,
		FileNotFoundException, InvocationTargetException, NoSuchMethodException {
		XMLObjectImporter<FileTypes> importer = new XMLObjectImporter<FileTypes>();
		FileTypes types = importer.importObject(
				com.rapidminer.operator.modelling.configuration.xsd.
				mlnfiletypespecification.ObjectFactory.class, 
				ConfigurationReader.class.getResourceAsStream("/com/rapidminer/resources/extension/MLNFileTypeSpecifications.xml"),
				ConfigurationReader.class.getResource("/MLNFileTypeSpecification.xsd"));
//				ConfigurationReader.class.getResourceAsStream("/com/rapidminer/resources/extension/MLNFileTypeSpecifications.xml"),
//				ConfigurationReader.class.getResource("/com/MLNFileTypeSpecification.xsd"));
		for (FileType type: types.getFileType()) {
			new MLNFileType(type.getKey(), (MLNConverter) MLNConverter.class.getClassLoader()
					.loadClass(type.getConverter()).getConstructor(InputStream.class, OutputStream.class)
					.newInstance(null,null),
					type.isQueryAtomFileType(), type.isNonEvidenceAtomFileType(),
					type.isSupportsLEConstraintConversion(), type.isSupportsUnsupportedConstraintRemoval());
		}	
	}
	
	@SuppressWarnings("unchecked")
	public static void loadOptionalParameters(Operator operator) throws JAXBException, MapReduceException,
	IllegalAccessException, ClassNotFoundException, InstantiationException, SAXException,
	FileNotFoundException  {
	final Operator operatorInt = operator;
	XMLObjectImporter<OptionalParameters> importer = new XMLObjectImporter<OptionalParameters>();
	OptionalParameters parameters = importer.importObject(
			com.rapidminer.operator.modelling.configuration.xsd.
			optionalparameterspecification.ObjectFactory.class, 
//			"/Users/yann/Documents/workspace/RapidMiner_MLN_Extension/resources/com/rapidminer/resources"
//			+ "/extension/OptionalParameterSpecifications.xml",
//			"/Users/yann/Documents/workspace/RapidMiner_MLN_Extension/src/OptionalParameterSpecification.xsd");
			ConfigurationReader.class.getResourceAsStream("/com/rapidminer/resources/extension/OptionalParameterSpecifications.xml"),
			ConfigurationReader.class.getResource("/OptionalParameterSpecification.xsd"));
		for (OptionalParameter parameter: parameters.getOptionalParameter()) {
			new MLNOptionalParameter(parameter.getKey(), parameter.getDescription(),
					parameter.getFlag(), 
					parameter.getNumberOfArguments(), 
					(parameter.getMlnEngines()!=null)?MapReduce.map(parameter.getMlnEngines().getMlnEngine(), new Mappable<
							OptionalParameter.MlnEngines.MlnEngine, String>() {
								@Override
								public String apply(
										com.rapidminer.operator.modelling
										.configuration.xsd.optionalparameterspecification
										.OptionalParameter.MlnEngines.MlnEngine object)
										throws MapReduceException {
									return object.getKey();
								}
					}):null,
					parameter.isInferenceArgument(), parameter.isLearnArgument(), parameter.isExpert(),
					MLNParameterType.valueOf(parameter.getParameterType()), 
					(parameter.getCategories()!=null)?MapReduce.map(parameter.getCategories().getCategory(), 
							new Mappable<OptionalParameter.Categories.Category, String>() {
								@Override
								public String apply(Category object)
										throws MapReduceException {
									return object.getLabel();
								}
					}):null,
					parameter.getMinInt(),
					parameter.getMaxInt(), 
					parameter.getDefaultCategoryIndex(),
					(parameter.getParameterConditions()!=null)?MapReduce.map(parameter.getParameterConditions()
							.getParameterCondition(),
							new Mappable<ParameterConditions.ParameterCondition, ParameterCondition>() {
								@Override
								public ParameterCondition apply(ParameterConditions.ParameterCondition object)
										throws MapReduceException {
									try {
										String className = object.getClazz();
										Class<MLNCondition> cl = 
												(Class<MLNCondition>)
												MLNCondition.class.getClassLoader()
												.loadClass(className);
										Constructor<MLNCondition> constr = 
												cl.getConstructor(ParameterHandler.class);
										com.rapidminer.parameter.conditions.ParameterCondition cond = constr.newInstance(operatorInt);
										return cond;
									} catch (InstantiationException e) {
										throw new MapReduceException(e.getMessage());
									} catch (IllegalAccessException e) {
										throw new MapReduceException(e.getMessage());
									} catch (NoSuchMethodException e) {
										throw new MapReduceException(e.getMessage());
									} catch (InvocationTargetException e) {
										throw new MapReduceException(e.getMessage());
									}catch (ClassNotFoundException e) {
										throw new MapReduceException(e.getMessage());
									}
								}
					}):null, 
					(parameter.getDefaultInt()!=null)?parameter.getDefaultInt():null, parameter.isDefaultBoolean());
		}
	}
	
	public static void loadGeneralParameters() throws JAXBException, SAXException, FileNotFoundException {
		XMLObjectImporter<GeneralParameters> importer = new XMLObjectImporter<GeneralParameters>();
		InputStream stream;
		if (Files.exists(Paths.get("GeneralParameters.xml"))) {
			stream = new FileInputStream(new File("GeneralParameters.xml"));
		} else {
			stream = ConfigurationReader.class.getResourceAsStream("/com/rapidminer/resources/extension/GeneralParameters.xml");
		}
		GeneralParameters parameters = importer.importObject(
				com.rapidminer.operator.modelling.configuration.xsd.
				generalparameter.ObjectFactory.class, 
//				"/Users/yann/Documents/workspace/RapidMiner_MLN_Extension/resources/com/rapidminer/resources"
//				+ "/extension/GeneralParameters.xml",
//				"/Users/yann/Documents/workspace/RapidMiner_MLN_Extension/src/GeneralParameter.xsd");
				stream,
				ConfigurationReader.class.getResource("/GeneralParameter.xsd"));
		for (GeneralParameter parameter: parameters.getGeneralParameter()) {
			new MLNGeneralParameter(parameter.getKey(), parameter.getValue(), parameter.getTopic(),
					parameter.getDescription());
		}
	}
}
