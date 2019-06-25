/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author kasun
 */
public class LoginDao {
    private Connection connection;

    public LoginDao() {
        
        connection=DBConnection.getInstance().getConnection();
    }
    
    
    
    public boolean login(String userName,String password) throws SQLException{
//        System.out.println("username"+userName);
//        System.out.println("password"+password);
        String sql="select * from login where username='"+userName+"' and pass='"+password+"'";
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next())
            return true;
        else
            return false;
        
    }
}
