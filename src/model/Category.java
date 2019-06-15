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
public class Category {
    private int c_id;
    private String name;

    public Category() {
    }

    public Category(int c_id, String name) {
        this.c_id = c_id;
        this.name = name;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" + "c_id=" + c_id + ", name=" + name + '}';
    }
    
    
}
