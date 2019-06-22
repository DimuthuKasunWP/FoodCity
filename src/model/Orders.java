/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author kasun
 */
public class Orders {
    private int o_id;
    private Timestamp time;
    private double profit;

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }
    

    public Orders() {
    }

    public Orders(int o_id, Timestamp time) {
        this.o_id = o_id;
        this.time = time;
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

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Orders{" + "o_id=" + o_id + ", time=" + time + '}';
    }
    
    
}
