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
import model.Category;

/**
 *
 * @author kasun
 */
public class CategoryDao {
    private Connection connection;
    public CategoryDao() {
        connection=DBConnection.getInstance().getConnection();
    }
    
    public boolean addCategory(String name) throws SQLException{
        String sql="insert into category(name) values('"+name+"')";
        Statement stm= connection.createStatement();
        int res = stm.executeUpdate(sql);
        return res>0 ?true:false;
        
    }
    
    public boolean updateCategory(int id,String name) throws SQLException{
        String sql="update category set name='"+name+"' where c_id='"+id+"'";
        Statement stm=connection.createStatement();
        int res = stm.executeUpdate(sql);
        return res>0 ?true:false;
        
    }
    
    public Category getCategory(String name) throws SQLException{
        Category category=new Category();
        String sql="select * from category where name='"+name+"'";
         PreparedStatement stm=connection.prepareStatement(sql);
        ResultSet rst = stm.executeQuery();
        while(rst.next()){
            category.setC_id(rst.getInt("c_id"));
            category.setName(rst.getString("name"));
        }
        return category;
    }
    
    public List<Category> getAll() throws SQLException{
        List<Category> list=new ArrayList<>();
        String sql="select * from category ";
        PreparedStatement stm=connection.prepareStatement(sql);
        ResultSet rst = stm.executeQuery();
        while(rst.next()){
            Category category=new Category();
            category.setC_id(rst.getInt("c_id"));
            category.setName(rst.getString("name"));
            list.add(category);
        }
        return list;
    }
    
    public boolean deleteCategory(String name) throws SQLException{
        String sql="delete from category where name='"+name+"'";
        Statement stm=connection.createStatement();
        int res = stm.executeUpdate(sql);
        if(res>0){
            return true;
        }else{
            return false;
        }
        
        
    }
    
    
    
}
