/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author kasun
 */
public class DBConnection {
    private Connection connection;
    private static DBConnection connectionFactory;
    
    private DBConnection(){
       
        try {
            
//            Class.forName("com.mysql.jdbc.Driver");
//        
//            Properties dbProperties=new Properties();
//            File file=new File("Settings/dbSettings.properties");
//            FileReader dbFileReader =new FileReader(file);
//            dbProperties.load(dbFileReader);
//        
            String url="jdbc:mysql://"
                    +"localhost"
                    +"/"
                    +"thogakade"+"?useUnicode=true&characterEncoding=utf8";

//            String userName=dbProperties.getProperty("userName");
//            String password=dbProperties.getProperty("password");
        
        
            connection=DriverManager.getConnection(url,"root","");
      
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Connection getConnection(){
            return connection;
    }
    public static DBConnection getInstance(){
        if(connectionFactory==null){
            connectionFactory=new DBConnection();
        }
        return connectionFactory;
    }
}
