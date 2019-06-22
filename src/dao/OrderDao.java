
package dao;

import connection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.Batch;
import model.Category;
import model.Orders;
import model.Supplier;

public class OrderDao {
     private Connection connection;
    private SupplierDao dao;
  
    public OrderDao() {
        connection=DBConnection.getInstance().getConnection();

    }
    
     public List<Orders> getAll() throws SQLException{
        List<Orders> list=new ArrayList<>();
        String sql="select * from orders";
        PreparedStatement stm=connection.prepareStatement(sql);
        ResultSet rst = stm.executeQuery();
        while(rst.next()){
            Orders orders=new Orders();
            orders.setO_id(rst.getInt("o_id"));
            orders.setTime(rst.getTimestamp("date"));
            orders.setProfit(rst.getDouble("profit"));
            list.add(orders);
        }
        
        return list;
        
    }
     
     public List<Orders> getProfit() throws SQLException{
        List<Orders> profit_list=new ArrayList<>();
        String sql="select SUM(profit) as profits,DATE_FORMAT(date, '%Y-%m-%d') AS dates from orders group by DATE(date) desc";
        PreparedStatement stm=connection.prepareStatement(sql);
        ResultSet rst = stm.executeQuery();
        while(rst.next()){
            Orders order=new Orders();
            order.setProfit(rst.getDouble("profits"));
            order.setDate(rst.getDate("dates"));
            profit_list.add(order);
        }
        
        return profit_list;
       
     }
    
}
