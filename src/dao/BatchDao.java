/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Batch;
import model.Supplier;

/**
 *
 * @author kasun
 */
public class BatchDao {
    private Connection connection;
    private SupplierDao dao;

    public BatchDao() {
        connection=DBConnection.getInstance().getConnection();

    }
    
    public boolean addBatch(String supplier,Batch batch) throws SQLException{
        Supplier object = dao.getSupplier(supplier);
        String sql="insert into batch(s_id,date)values('"+object.getS_id()+"','"+batch.getTime()+"')";
        Statement stm=connection.createStatement();
        int res = stm.executeUpdate(sql);
        return res>0?true:false;
        
    }
    
    public boolean updateBatch(Batch batch) throws SQLException{
        
        String sql="update batch set s_id='"+batch.getS_id()+"' where b_id='"+batch.getB_id()+"'";
        Statement stm=connection.createStatement();
        int res = stm.executeUpdate(sql);
        return res>0?true:false;
    }
    
    public  boolean deleteBatch(Batch batch) throws SQLException{
        
        String sql="delete from batch where b_id='"+batch.getB_id()+"'";
        Statement stm=connection.createStatement();
        int res = stm.executeUpdate(sql);
        return res>0?true:false;
    }
    
    public Batch getBatchByBID(int id) throws SQLException{
        Batch batch=new Batch();
        String sql="select * from batch where b_id='"+id+"'";
        PreparedStatement stm=connection.prepareStatement(sql);
        ResultSet rst = stm.executeQuery();
        while(rst.next()){
            batch.setB_id(id);
            batch.setS_id(rst.getInt("s_id"));
            batch.setTime(rst.getTimestamp("date"));
            
        }
        return batch;
        
    }
    
    public List<Batch> getBatchesBySID(int sid) throws SQLException{
        List<Batch> list=new ArrayList<>();
        String sql="select * from batch where s_id='"+sid+"'";
        PreparedStatement stm=connection.prepareStatement(sql);
        ResultSet rst = stm.executeQuery();
        while(rst.next()){
            Batch batch=new Batch();
            batch.setB_id(rst.getInt("b_id"));
            batch.setS_id(sid);
            batch.setTime(rst.getTimestamp("date"));
            list.add(batch);
        }
        
        return list;
        
    }
    
     public List<Batch> getAll() throws SQLException{
        List<Batch> list=new ArrayList<>();
        String sql="select * from batch ";
        PreparedStatement stm=connection.prepareStatement(sql);
        ResultSet rst = stm.executeQuery();
        while(rst.next()){
            Batch batch=new Batch();
            batch.setB_id(rst.getInt("b_id"));
            batch.setS_id(rst.getInt("s_id"));
            batch.setTime(rst.getTimestamp("date"));
            list.add(batch);
        }
        
        return list;
        
    }
    
    
}


