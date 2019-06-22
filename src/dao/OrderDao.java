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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.OrderDetail;
import model.Orders;

/**
 *
 * @author kasun
 */
public class OrderDao {
        private Connection connection;

    public OrderDao() {
        
        connection=DBConnection.getInstance().getConnection();
    }
    
    
    public boolean placeOrder(Orders orders,List<OrderDetail> details) {
        try{
        connection.setAutoCommit(false);
        String sql1="insert into orders(date,profit) values(?,?)";
        PreparedStatement stm = connection.prepareStatement(sql1);
            stm.setTimestamp(1, orders.getTime());
            stm.setDouble(2, orders.getProfit());
            int res = stm.executeUpdate();
            if(res>0){
                String temp="SELECT o_id AS LastID FROM orders WHERE ID = @@Identity";
                stm = connection.prepareStatement(temp);
                ResultSet rst = stm.executeQuery();
                int id=0;
                if(rst.next())
                    id=rst.getInt("o_id");
                for (OrderDetail detail : details) {
                    String sql2="insert  into order_details values(?,?,?,?)";
                    stm=connection.prepareStatement(sql2);
                    stm.setInt(1, id);
                    stm.setInt(2, detail.getI_Id());
                    stm.setDouble(3, detail.getQty());
                    stm.setDouble(4,detail.getPrice());
                    int res2 = stm.executeUpdate();
                    if(res2>0){
                        String sql3="update item set qty='"+detail.getQty()+"' where i_id='"+detail.getI_Id()+"' ";
                        stm=connection.prepareStatement(sql3);
                        int res3 = stm.executeUpdate();
                        if(res3>0){
                            connection.commit();
                            return true;
                        }else{
                            connection.rollback();
                            return false;
                        }
                    }else{
                        connection.rollback();
                        return false;
                    }
                    
                }
                return false;
            }else{
                connection.rollback();
                return false;
            }
        }catch(SQLException ex){
            
            ex.printStackTrace();
            return false;
        }finally{
            try {
                connection.setAutoCommit(true);
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
    }
    
}
