/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author kasun
 */
public class OrderDetail {
    private int i_Id;
    private int o_id;
    private double qty;
    private double price;
    private String description;
    private double total;

    public OrderDetail() {
    }

    public OrderDetail(int i_Id, int o_id, double qty, double price,String description,double total) {
        this.i_Id = i_Id;
        this.o_id = o_id;
        this.qty = qty;
        this.price = price;
        this.description=description;
        this.total=total;
    }

    public int getI_Id() {
        return i_Id;
    }

    public void setI_Id(int i_Id) {
        this.i_Id = i_Id;
    }

    public int getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "i_Id=" + i_Id + ", o_id=" + o_id + ", qty=" + qty + ", price=" + price + ", description=" + description + ", total=" + total + '}';
    }
    

    
    
    
}
