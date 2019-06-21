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
public class Item {
    private int i_id;
    private int b_id;
    private int c_id;
    private String description=null;
    private double taking_price;
    private double thoga_price;
    private double our_price;
    private String warning;
    private double quantity;

    public Item() {
    }

    public Item(int i_id, int b_id, int c_id,String description,double taking_price,double thoga_price,double our_price,String warning,double quantity) {
        this.i_id = i_id;
        this.b_id = b_id;
        this.c_id = c_id;
        this.description=description;
        this.taking_price=taking_price;
        this.thoga_price=thoga_price;
        this.our_price=our_price;
        this.warning=warning;
        this.quantity=quantity;
    }

    public int getI_id() {
        return i_id;
    }

    public void setI_id(int i_id) {
        this.i_id = i_id;
    }

    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }
    
    public void setDescription(String description){
        this.description=description;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setTaking_price(double taking_price){
        this.taking_price=taking_price;
    }
    
    public double getTaking_price(){
        return taking_price;
    }
    
    public void setThoga_price(double thoga_price){
        this.thoga_price=thoga_price;
    }
    
    public double getThoga_price(){
        return thoga_price;
    }
    
    public void setOur_price(double thoga_price){
        this.thoga_price=thoga_price;
    }
    
    public double getOur_price(){
        return taking_price;
    }
    
    public void setWarning(String warning){
        this.warning=warning;
    }
    
    public String getWarning(){
        return warning;
    }
    
    public void setQuantity(double quantity)
    {
       this.quantity=quantity;
    }    
    
    public double getQuantity(){
        return quantity;
    }

    @Override
    public String toString() {
        return "Item{" + "i_id=" + i_id + ", b_id=" + b_id + ", c_id=" + c_id + '}';
    }
    
}
