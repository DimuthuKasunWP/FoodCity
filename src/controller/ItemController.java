
package controller;
import dao.ItemDao;
import java.sql.SQLException;
import java.util.List;
import model.Category;
import model.Item;


public class ItemController {
    private CategoryController controller;
     private ItemDao dao;

    public ItemController() {
        controller=new CategoryController();
        dao=new ItemDao();
    }
    
    public boolean addItem(int item_id,double thoga_price,double quantity,double item_price,int batch_id,double taking_price,double our_price,String item_description,int category_id,int warning) throws SQLException{
        return dao.addItem(item_description,item_id,category_id,batch_id,taking_price,thoga_price,our_price,warning,quantity);
        
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
    public List<Item> getAllByCategory(String name) throws SQLException{
        Category category = controller.getCategory(name);
        return dao.getAllByCategory(category.getC_id());
    }
    
    
}
