package com.epam.training.jaxb.marhsaller;

import com.epam.training.Main;
import generate.products.Products;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

public class ProductsMarshaller {

    public static void marshaller(Products products,String path){
        try {
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = sf.newSchema(Main.SCHEMAPRODUCTS);

            JAXBContext context = JAXBContext.newInstance(Products.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setSchema(schema);

            marshaller.marshal(products, new File(path));
        } catch (JAXBException | SAXException e) {
            e.printStackTrace();
        }
    }
}
