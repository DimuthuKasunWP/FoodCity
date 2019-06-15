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
public class Batch {
    private int b_id;
    private int s_id;
    private Timestamp time;

    public Batch() {
    }

    public Batch(int b_id, int s_id, Timestamp time) {
        this.b_id = b_id;
        this.s_id = s_id;
        this.time = time;
    }

    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Batch{" + "b_id=" + b_id + ", s_id=" + s_id + ", time=" + time + '}';
    }
    
    
}
