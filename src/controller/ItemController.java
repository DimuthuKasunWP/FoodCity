
package controller;
import dao.ItemDao;
import java.sql.SQLException;
import java.util.List;
import model.Item;


public class ItemController {
     private ItemDao dao;

    public ItemController() {
        
        dao=new ItemDao();
    }
    
    public boolean addItem(int item_id,double thoga_price,double quantity,double item_price,int batch_id,double taking_price,double our_price,String item_description,int category_id) throws SQLException{
        return dao.addItem(item_description,item_id,category_id,batch_id,taking_price,thoga_price,our_price,"Ok",quantity);
        
    }
    
    public boolean updateItem(Item item) throws SQLException {
        return dao.updateItem(item);
        
    }
    
    public Item getItem(int id) throws SQLException{
        
        return dao.getItem(id);
        
    }
    public List<Item> getAll() throws SQLException{
        
        return dao.getAll();
    }
    
    public boolean deleteItem(int id) throws SQLException{
        return dao.deleteItem(id);
    }
    
    
}
