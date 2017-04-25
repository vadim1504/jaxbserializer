package com.epam.training.jaxb.unmarhsaller;

import com.epam.training.Main;
import generate.products.Products;
import org.xml.sax.SAXException;


import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

public class ProductsUnmarshaller {

    public static Products unmarshaller(String path){
        try {
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = sf.newSchema(Main.SCHEMAPRODUCTS);

            JAXBContext jaxbContext=JAXBContext.newInstance(Products.class);
            Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
            unmarshaller.setSchema(schema);
            return (Products) unmarshaller.unmarshal(new File(path));
        } catch (SAXException | JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
