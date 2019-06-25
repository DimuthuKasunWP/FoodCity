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
        
//            connection.setAutoCommit(false);
            String sql;
            if(supplier.getMobile().size()>1)
             sql="insert into supplier(name,mob1,mob2) values('"+supplier.getName()+"','"+supplier.getMobile().get(0)+"','"+supplier.getMobile().get(1)+"')";
            else
               sql="insert into supplier(name,mob1) values('"+supplier.getName()+"','"+supplier.getMobile().get(0)+"')";  
            Statement stm= connection.createStatement();
            int res = stm.executeUpdate(sql);
            if(res>0){
                return true;
//                ArrayList<String> list = supplier.getMobile();
//                for (String string : list) {
//                   sql="insert into supplier_mobile values('"+getSupplier(supplier.getS_id())+"','"+string+"') " ;
//                   Statement stm2= connection.createStatement();   
//                   res=stm.executeUpdate(sql);
//                   if(res>0){
//                       connection.commit();
//                       return true;
//                   }
//                   else{
//                       connection.rollback();
//                       return false;
//                   }
//                   
//                }
//                return false;
                
            }else{
//                connection.rollback();
                return false;
            }
        
        
    }
    
    public Supplier getSupplier(int id) throws SQLException{
        Supplier supplier=new Supplier();
        System.out.println("id"+id);
        String sql="select * from supplier where s_id='"+id+"'";
        PreparedStatement stm=connection.prepareStatement(sql);
        ResultSet rst = stm.executeQuery();
        while(rst.next()){
            supplier.setS_id(rst.getInt("s_id"));
            supplier.setName(rst.getString("name"));
//            sql="select * from supplier_mobile where s_id='"+id+"'";
//            PreparedStatement stm2=connection.prepareStatement(sql);
//            ResultSet executeQuery = stm2.executeQuery();
            
            ArrayList<String> list=new ArrayList<>();
           list.add(rst.getString("mob1"));
           list.add(rst.getString("mob2"));
            supplier.setMobile(list);
        }
        return supplier;
        
    }
    
    public List<Supplier> getAll() throws SQLException{
        
        String sql="select * from supplier";
        Statement stm=connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        List<Supplier> list=new ArrayList<>();
        int i=0;
        while(rst.next()){
            System.out.println(i++);
            Supplier supplier=new Supplier();
            supplier.setS_id(rst.getInt("s_id"));
            supplier.setName(rst.getString("name"));
            ArrayList<String> mobList=new ArrayList<>();
            mobList.add(rst.getString("mob1"));
            mobList.add(rst.getString("mob2"));
//            sql="select * from supplier_mobile where s_id='"+rst.getInt("s_id")+"'";
//            PreparedStatement stm2=connection.prepareStatement(sql);
//            ResultSet executeQuery = stm2.executeQuery();
//            List<String> mobileList=new ArrayList<>();
//            while(executeQuery.next()){
//                mobileList.add(executeQuery.getString("mobile"));
//            }
            supplier.setMobile(mobList);
            list.add(supplier);
            
        }
        return list;
    }
    
    
    public boolean update(Supplier supplier) throws SQLException {

            Supplier value = getSupplier(supplier.getS_id());
//            connection.setAutoCommit(false);
            String sql;
            System.out.println("name"+supplier.getName());
            if(supplier.getMobile().size()>1)
             sql="update supplier set name='"+supplier.getName()+"',mob1='"+supplier.getMobile().get(0)+"',mob2='"+supplier.getMobile().get(1)+"' where s_id='"+value.getS_id()+"'";
            else
                sql="update supplier set name='"+supplier.getName()+"',mob1='"+supplier.getMobile().get(0)+"',mob2=' ' where s_id='"+value.getS_id()+"'";
            Statement stm= connection.createStatement();
            int res = stm.executeUpdate(sql);
            if(res>0){
                return true;
//                ArrayList<String> mobileList = supplier.getMobile();
//                sql="delete from supplier_mobile where s_id='"+value.getS_id()+"'";
//                Statement statement2=connection.createStatement();
//                int executeUpdate = stm.executeUpdate(sql);
//                if(executeUpdate>0){
//                    for (String string : mobileList) {
//                        sql="insert into supplier_mobile values('"+getSupplier(supplier.getS_id())+"','"+string+"') " ;
//                        Statement stm2= connection.createStatement();
//                        res=stm.executeUpdate(sql);
//                        if(res>0){
//                            connection.commit();
//                            return true;
//                        }
//                        else{
//                            connection.rollback();
//                            return false;
//                        }
//                        
//                    }
//                }else{
//                    connection.rollback();
//                    return false;
//                }
//                return false;
            }else{
//                connection.rollback();
                return false;
            }
        
    }
    
    public boolean deleteSupplier(int  id) throws SQLException{
//        Supplier supplier = getSupplier(name);
        String sql="delete from supplier where s_id='"+id+"'";
        Statement stm=connection.createStatement();
        int res = stm.executeUpdate(sql);
        if(res>0){
            
           return true;
        }
        else{
            return false;
        }
        
    }
}
