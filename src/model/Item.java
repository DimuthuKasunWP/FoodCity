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

    public Item() {
    }

    public Item(int i_id, int b_id, int c_id) {
        this.i_id = i_id;
        this.b_id = b_id;
        this.c_id = c_id;
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

    @Override
    public String toString() {
        return "Item{" + "i_id=" + i_id + ", b_id=" + b_id + ", c_id=" + c_id + '}';
    }
    
}
