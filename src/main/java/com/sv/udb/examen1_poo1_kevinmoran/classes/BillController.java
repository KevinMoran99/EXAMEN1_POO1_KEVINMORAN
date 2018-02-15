/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.examen1_poo1_kevinmoran.classes;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Estudiante
 */
public class BillController {
    private Bill bill;

    public BillController() {
        bill = new Bill();
    }
    
    /**
     * Agrega un producto a la factura y actualiza el total
     * @param product El producto a agregar
     * @param quantity La cantidad de productos
     * @return Booleano, si la operación fue exitosa o no
     */
    public boolean addItem (Product product, int quantity) {
        try {
            if (!ProductController.checkStock(product, quantity))
                return false;
            
            double subTotal = product.getPrice() * quantity;
            ArrayList<BillItem> itemList = bill.getItemList();
            
            itemList.add(new BillItem(product, quantity, subTotal));
            bill.setItemList(itemList);
            
            bill.setTotal(bill.getTotal() + subTotal);
            
            return true;
            
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * 
     * @return Modelo con todos los datos de la factura
     */
    public DefaultTableModel getBill() {
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("Producto");
        model.addColumn("Precio unitario");
        model.addColumn("Cantidad");
        model.addColumn("Subtotal");
        
        for (BillItem item : bill.getItemList()) {
            model.addRow(new Object[]{item.getProduct().getName(), "$" + item.getProduct().getPrice(), 
                item.getQuantity(), "$" + item.getSubTotal()});
        }
        
        return model;
    }
    
    /**
     * 
     * @return El total de la factura
     */
    public String getTotal() {
        return "$" + String.valueOf(bill.getTotal());
    }
}
