
package controller;

import dao.CategoryDao;
import dao.OrderDao;
import java.sql.SQLException;
import java.util.List;
import model.Category;
import model.Orders;
import java.sql.Timestamp;
public class OrderController {
    
    private OrderDao dao;
    
     public OrderController() {
        
        dao=new OrderDao();
    }
    
    public List<Orders> getAll() throws SQLException{
        
        return dao.getAll();
    }
    
    public List<Orders> getOrderProfit() throws SQLException{
        return dao.getProfit();
    }
      
}
