/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author kasun
 */
public class Orders {
    private int o_id;
    private Timestamp time;
    private double profit;
    private Date date;
    public Orders() {
    }

    public Orders(int o_id, Timestamp time,double profit) {
        this.o_id = o_id;
        this.time = time;
        this.profit=profit;
    }

    public int getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }

    public Timestamp getTime() {
        return time;
    }
    
    public Date getDate(){
        return date;
    }
    
    public void setDate(Date date){
        this.date=date;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
    
    public void setProfit(double profit){
        this.profit=profit;
    }
    
    public double getProfit(){
        return profit;
    }

    @Override
    public String toString() {
        return "Orders{" + "o_id=" + o_id + ", time=" + time + '}';
    }
    
    
}
