/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author kasun
 */
public class Supplier {
    private int s_id ;
    private String name;
    private ArrayList<String> mobile;

    public Supplier() {
    }

    public Supplier(int s_id, String name, ArrayList<String> mobile) {
        this.s_id = s_id;
        this.name = name;
        this.mobile = mobile;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getMobile() {
        return mobile;
    }

    public void setMobile(ArrayList<String> mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Supplier{" + "s_id=" + s_id + ", name=" + name + ", mobile=" + mobile + '}';
    }
    
    
}
