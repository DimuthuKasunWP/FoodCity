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
    private long i_id;
    private int b_id;
    private int c_id;
    private String description=null;
    private double taking_price;
    private double thoga_price;
    private double our_price;
    private double shown_price;
    private int warning;
    private double quantity;
    

    public Item() {
    }

    public Item(long i_id, int b_id, int c_id,String description,double taking_price,double thoga_price,double our_price,double shown_price,int warning,double quantity) {
        this.i_id = i_id;
        this.b_id = b_id;
        this.c_id = c_id;
        this.description=description;
        this.taking_price=taking_price;
        this.thoga_price=thoga_price;
        this.our_price=our_price;
        this.warning=warning;
        this.quantity=quantity;
        this.shown_price=shown_price;
    }

    public long getI_id() {
        return i_id;
    }

    public void setI_id(long i_id) {
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

    public double getShown_price() {
        return shown_price;
    }

    public void setShown_price(double shown_price) {
        this.shown_price = shown_price;
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
    
    public void setOur_price(double our_Price){
        this.our_price=our_Price;
    }
    
    public double getOur_price(){
        return our_price;
    }
    
    public void setWarning(int warning){
        this.warning=warning;
    }
    
    public int getWarning(){
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
        return "Item{" + "i_id=" + i_id + ", b_id=" + b_id + ", c_id=" + c_id + ", description=" + description + ", taking_price=" + taking_price + ", thoga_price=" + thoga_price + ", our_price=" + our_price + ", shown_price=" + shown_price + ", warning=" + warning + ", quantity=" + quantity + '}';
    }

   
    
}
