/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OrderDao;
import java.sql.SQLException;
import java.util.List;
import model.OrderDetail;
import model.Orders;

/**
 *
 * @author kasun
 */
public class OrderController {
    private OrderDao dao;

    public OrderController() {
    dao=new OrderDao();
    }
    
    
    public boolean placeOrder(Orders order,List<OrderDetail> details){
        return dao.placeOrder(order, details);
    }
    
     public List<Orders> getAll() throws SQLException{
        
       return dao.getAll();
    }
    
    public List<Orders> getOrderProfit() throws SQLException{
        return dao.getProfit();
    }
    
}
