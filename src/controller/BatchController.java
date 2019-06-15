/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BatchDao;
import dao.SupplierDao;
import java.sql.SQLException;
import java.util.List;
import model.Batch;
import model.Supplier;

/**
 *
 * @author kasun
 */
public class BatchController {
    private BatchDao dao;
    private SupplierDao supDao;

    public BatchController() {
        dao=new BatchDao();
    }
    
    
    public boolean addBatch(String supplier,Batch batch) throws SQLException{
        return dao.addBatch(supplier, batch);
        
    }
    public boolean  updateBatch(Batch batch) throws SQLException{
        return dao.updateBatch(batch);
        
    }
    public boolean deleteBatch(Batch batch) throws SQLException{
        
        return dao.deleteBatch(batch);
    }
    
    public Batch getbatchByBID(int bid) throws SQLException{
        
        return dao.getBatchByBID(bid);
    }
    public List<Batch> getBatchesBySID(String name) throws SQLException{
        Supplier supplier = supDao.getSupplier(name);
        return dao.getBatchesBySID(supplier.getS_id());
    }
    
    public List<Batch> getAll() throws SQLException{
        return dao.getAll();
    }
    
    
}
