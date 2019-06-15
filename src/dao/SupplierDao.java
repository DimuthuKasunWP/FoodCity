/*+
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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Supplier;

/**
 *
 * @author kasun
 */
public class SupplierDao {
    private Connection connection;

    public SupplierDao() {
    
    connection=DBConnection.getInstance().getConnection();
    }
    
    
    
    public boolean addSupplier(Supplier supplier) throws SQLException {
        try {
            connection.setAutoCommit(false);
            String sql="insert into supplier(name) values('"+supplier.getName()+"')";
            Statement stm= connection.createStatement();
            int res = stm.executeUpdate(sql);
            if(res>0){
                ArrayList<String> list = supplier.getMobile();
                for (String string : list) {
                   sql="insert into supplier_mobile values('"+getSupplier(supplier.getName()).getS_id()+"','"+string+"') " ;
                   Statement stm2= connection.createStatement();   
                   res=stm.executeUpdate(sql);
                   if(res>0){
                       connection.commit();
                       return true;
                   }
                   else{
                       connection.rollback();
                       return false;
                   }
                   
                }
                return false;
                
            }else{
                connection.rollback();
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            connection.setAutoCommit(true);
        }
        
    }
    
    public Supplier getSupplier(String name) throws SQLException{
        Supplier supplier=new Supplier();
        String sql="select * from supplier where name='"+name+"'";
        PreparedStatement stm=connection.prepareStatement(sql);
        ResultSet rst = stm.executeQuery();
        while(rst.next()){
            supplier.setS_id(rst.getInt("s_id"));
            supplier.setName(name);
            sql="select * from supplier_mobile where s_id='"+rst.getInt("s_id")+"'";
            PreparedStatement stm2=connection.prepareStatement(sql);
            ResultSet executeQuery = stm2.executeQuery();
            ArrayList<String> list=new ArrayList<>();
            while(executeQuery.next()){
                list.add(executeQuery.getString("mobile"));
            }
            supplier.setMobile(list);
        }
        return supplier;
        
    }
    
    public List<Supplier> getAll() throws SQLException{
        
        String sql="select * from supplier";
        PreparedStatement stm=connection.prepareStatement(sql);
        ResultSet rst = stm.executeQuery();
        List<Supplier> list=new ArrayList<>();
        while(rst.next()){
            Supplier supplier=new Supplier();
            supplier.setS_id(rst.getInt("s_id"));
            supplier.setName(rst.getString("name"));
            
            sql="select * from supplier_mobile where s_id='"+rst.getInt("s_id")+"'";
            PreparedStatement stm2=connection.prepareStatement(sql);
            ResultSet executeQuery = stm2.executeQuery();
            List<String> mobileList=new ArrayList<>();
            while(executeQuery.next()){
                mobileList.add(executeQuery.getString("mobile"));
            }
            supplier.setMobile((ArrayList<String>) mobileList);
            
        }
        return list;
    }
    
    
    public boolean update(Supplier supplier) throws SQLException {
        try {
            Supplier value = getSupplier(supplier.getName());
            connection.setAutoCommit(false);
            String sql="update supplier set name='"+value.getName()+"' where s_id='"+value.getS_id()+"'";
            Statement stm= connection.createStatement();
            int res = stm.executeUpdate(sql);
            if(res>0){
                ArrayList<String> mobileList = supplier.getMobile();
                sql="delete from supplier_mobile where s_id='"+value.getS_id()+"'";
                Statement statement2=connection.createStatement();
                int executeUpdate = stm.executeUpdate(sql);
                if(executeUpdate>0){
                    for (String string : mobileList) {
                        sql="insert into supplier_mobile values('"+getSupplier(supplier.getName()).getS_id()+"','"+string+"') " ;
                        Statement stm2= connection.createStatement();
                        res=stm.executeUpdate(sql);
                        if(res>0){
                            connection.commit();
                            return true;
                        }
                        else{
                            connection.rollback();
                            return false;
                        }
                        
                    }
                }else{
                    connection.rollback();
                    return false;
                }
                return false;
            }else{
                connection.rollback();
                return false;
            }
        } catch (SQLException ex) {
            
            Logger.getLogger(SupplierDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally{
            connection.setAutoCommit(true);
            
        }
        
    }
    
    public boolean deleteSupplier(int  id) throws SQLException{
//        Supplier supplier = getSupplier(name);
        String sql="delete from supplier_mobile where s_id='"+id+"'";
        Statement stm=connection.createStatement();
        int res = stm.executeUpdate(sql);
        if(res>0){
            
            sql="delete from supplier where s_id='"+id+"'";
            stm=connection.createStatement();
            int executeUpdate = stm.executeUpdate(sql);
            if(executeUpdate>0){
                return true;
            }else{
                return false;
            }
        }
        else{
            return false;
        }
        
    }
}
