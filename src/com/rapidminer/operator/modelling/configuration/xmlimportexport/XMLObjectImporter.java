package com.rapidminer.operator.modelling.configuration.xmlimportexport;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

public class XMLObjectImporter<E> implements ValidationEventHandler {
	
	@SuppressWarnings("unchecked")
	public <S> E importObject(Class<S> objectFactory, String filename, String schemaFilename) 
			throws JAXBException, SAXException, FileNotFoundException {
		JAXBContext engineJaxbContext = 
				JAXBContext.newInstance(objectFactory);
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); 
		Schema schema = sf.newSchema(new File(schemaFilename)); 
		Unmarshaller unmarshaller = engineJaxbContext.createUnmarshaller();
		unmarshaller.setSchema(schema);
		unmarshaller.setEventHandler(this);
		E unmarshalledObject = (E)
				unmarshaller.unmarshal(
						new FileInputStream(new File(filename)));
		return unmarshalledObject;
	}
	
	@SuppressWarnings("unchecked")
	public <S> E importObject(Class<S> objectFactory, InputStream filename, URL schemaFilename) 
			throws JAXBException, SAXException, FileNotFoundException {
		JAXBContext engineJaxbContext = 
				JAXBContext.newInstance(objectFactory);
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf.newSchema(schemaFilename); 
		Unmarshaller unmarshaller = engineJaxbContext.createUnmarshaller();
		unmarshaller.setSchema(schema);
		unmarshaller.setEventHandler(this);
		E unmarshalledObject = (E)
				unmarshaller.unmarshal(
						filename);
		return unmarshalledObject;
	}
	

	@Override
	public boolean handleEvent(ValidationEvent event) {
		return true;
	}

}
