package com.epam.training;

import com.epam.training.jaxb.marhsaller.ProductsMarshaller;
import com.epam.training.jaxb.unmarhsaller.ProductsUnmarshaller;
import generate.products.Products;

import java.io.*;
import java.net.URL;

import java.util.Scanner;

public class Main {

    public static final URL SCHEMAPRODUCTS = Main.class.getClassLoader().getResource("products.xsd");

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("in:");
        String inputPath = in.next();
        System.out.println("out:");
        String outputPath = in.next();

        Products products = ProductsUnmarshaller.unmarshaller(inputPath);

        products.getProduct().forEach((s)-> System.out.println("name: "+s.getName()+", price: "+s.getPrice()+", amount: "+s.getAmount()+", description: "+s.getDescription()+", productType: "+s.getProductType()));

        ProductsMarshaller.marshaller(products,outputPath);
    }
}
