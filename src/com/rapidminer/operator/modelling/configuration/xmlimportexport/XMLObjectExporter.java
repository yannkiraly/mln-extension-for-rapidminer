package com.rapidminer.operator.modelling.configuration.xmlimportexport;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class XMLObjectExporter<E> {
	
	public <S> void exportObject(JAXBElement<E> obj, String packageName, String filename) 
			throws JAXBException, FileNotFoundException {
		JAXBContext context = JAXBContext.newInstance(packageName);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty("jaxb.formatted.output",Boolean.TRUE);
		OutputStream out = new FileOutputStream(filename);
		marshaller.marshal(obj, out);
	}

}
