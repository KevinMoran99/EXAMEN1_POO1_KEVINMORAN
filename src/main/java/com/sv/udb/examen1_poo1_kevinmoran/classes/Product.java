/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.examen1_poo1_kevinmoran.classes;

import java.util.Date;

/**
 *
 * @author Estudiante
 */
public class Product {
    private String name;
    private double price;
    private int stock;
    private int min;
    private Date expires;

    public Product() {
    }

    public Product(String name, double price, int stock, int min, Date expires) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.expires = expires;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
