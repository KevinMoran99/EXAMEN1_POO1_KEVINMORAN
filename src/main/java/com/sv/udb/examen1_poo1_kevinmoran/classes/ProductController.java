/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.examen1_poo1_kevinmoran.classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.DefaultListModel;

/**
 *
 * @author Estudiante
 */
public class ProductController {
    
    /**
     * Contiene la lista de productos
     */
    ArrayList<Product> productList;

    /**
     * 
     */
    public ProductController() {
        productList = new ArrayList<>();
    }
    
    public boolean addProduct (String name, double price, int stock, int min, Date expires) {
        try {
            productList.add(new Product(name, price, stock, min, expires));
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public DefaultListModel getExpensiveProducts () {
        DefaultListModel model = new DefaultListModel ();
        //Arreglom que contiene el top 3, con productos vacios
        Product[] prodArray = {new Product ("ninguno", 0, 0, 0, new Date()),
                                new Product ("ninguno", 0, 0, 0, new Date()),
                                new Product ("ninguno", 0, 0, 0, new Date())};
        
        //Comparando precios y desplazando si hay ganadores
        for (Product product : productList) {
            if (product.getPrice() > prodArray[2].getPrice()) {
               
                if (product.getPrice() > prodArray[1].getPrice()) {
                    
                    if (product.getPrice() > prodArray[0].getPrice()) {
                        prodArray[2] = prodArray[1];
                        prodArray[1] = prodArray[0];
                        prodArray[0] = product;
                    }
                    else {
                        prodArray[2] = prodArray[1];
                        prodArray[1] = product;
                    }
                }
                else 
                    prodArray[2] = product;
            }
        }
        
        for (Product product : prodArray) {
            model.addElement(product);
        }
        
        return model;
    }
    
    private static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
    }
    
    public String getExpiredProduct () {
        
        String productName = "ninguno";
        long dayCount = Long.MAX_VALUE;
        
        for (Product product : productList) {
            
            long dateDiff = getDateDiff(product.getExpires(), new Date(), TimeUnit.DAYS);
            
            if (dateDiff < dayCount){
                productName = product.getName();
                dayCount = dateDiff;
            }
              
        }
        
        return productName;
    }
    
    public DefaultListModel getMinedProducts () {
        DefaultListModel model = new DefaultListModel ();
        
        for (Product product : productList) 
            if (product.getMin() >= product.getStock())
                model.addElement(product);
        
        return model;
    }
    
}
