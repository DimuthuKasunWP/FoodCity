/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SupplierDao;
import java.sql.SQLException;
import java.util.List;
import model.Supplier;

/**
 *
 * @author kasun
 */
public class SupplierController {
    private SupplierDao dao;

    public SupplierController() {
        dao=new SupplierDao();
    }
    
    public boolean addSupplier(Supplier supplier) throws SQLException{
       
        return dao.addSupplier(supplier);
    }
    
    public boolean updateSupplier(Supplier supplier) throws SQLException{
        
        return dao.update(supplier);
    }
    
    public Supplier getSupplier(String name) throws SQLException{
        
        return dao.getSupplier(name);
    }
    
    public List<Supplier> getAll() throws SQLException{
        
        return dao.getAll();
    }
    
    public boolean deleteSupplier(String name) throws SQLException{
        
        return dao.deleteSupplier(name);
        
    }
    
    
}
