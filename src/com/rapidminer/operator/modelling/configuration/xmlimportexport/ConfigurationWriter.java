package com.rapidminer.operator.modelling.configuration.xmlimportexport;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.rapidminer.operator.modelling.configuration.MLNGeneralParameter;
import com.rapidminer.operator.modelling.configuration.xsd.generalparameter.GeneralParameters;
import com.rapidminer.operator.modelling.configuration.xsd.generalparameter.GeneralParameters.GeneralParameter;

public class ConfigurationWriter {
	
	private static final String GENERAL_PARAMETER_PACKAGE = "com.rapidminer.operator.modelling.configuration.xsd.generalparameter";
	
	public static void writeGeneralParameters(MLNGeneralParameter[] parameters) {
		com.rapidminer.operator.modelling.configuration.xsd.generalparameter.ObjectFactory factory = 
				new com.rapidminer.operator.modelling.configuration.xsd.generalparameter.ObjectFactory();
		GeneralParameters generalParameters = factory.createGeneralParameters();
		GeneralParameter generalParameter=null;
		for (MLNGeneralParameter parameter: parameters) {
			generalParameter = factory.createGeneralParametersGeneralParameter();
			generalParameter.setKey(parameter.getKey());
			generalParameter.setValue(parameter.getValue());
			generalParameter.setDescription(parameter.getDescription());
			generalParameter.setTopic(parameter.getTopic());
			generalParameters.getGeneralParameter().add(generalParameter);
		}
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(GeneralParameters.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty("jaxb.formatted.output",Boolean.TRUE);
			OutputStream out = new FileOutputStream("GeneralParameters.xml");
			marshaller.marshal(generalParameters, out);
			System.out.println();
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
