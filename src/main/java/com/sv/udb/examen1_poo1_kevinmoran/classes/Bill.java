/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.examen1_poo1_kevinmoran.classes;

import java.util.ArrayList;

/**
 *
 * @author Estudiante
 */
public class Bill {
    private ArrayList<BillItem> itemList;
    private double total;

    public Bill() {
        this.itemList = new ArrayList<>();
        this.total = 0;
    }

    public ArrayList<BillItem> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<BillItem> itemList) {
        this.itemList = itemList;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
}
