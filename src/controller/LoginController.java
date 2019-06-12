/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.LoginDao;
import java.sql.SQLException;

/**
 *
 * @author kasun
 */
public class LoginController {
private LoginDao dao;
    public LoginController() {
        dao=new LoginDao();
    }
    
   
    public boolean Login(String userName,String password) throws SQLException{
        return dao.login(userName, password);
        
    }
    
    
    
    
}
