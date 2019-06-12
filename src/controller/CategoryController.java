/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CategoryDao;
import java.sql.SQLException;
import java.util.List;
import model.Category;

/**
 *
 * @author kasun
 */
public class CategoryController {
    private CategoryDao dao;

    public CategoryController() {
        
        dao=new CategoryDao();
    }
    
    public boolean addCategory(String name) throws SQLException{
        return dao.addCategory(name);
        
    }
    
    public boolean updateCategory(String name) throws SQLException {
        Category category = dao.getCategory(name);
        return dao.updateCategory(category.getC_id(), name);
        
    }
    
    public Category getCategory(String name) throws SQLException{
        
        return dao.getCategory(name);
        
    }
    public List<Category> getAll() throws SQLException{
        
        return dao.getAll();
    }
    
    public boolean deleteCategory(String name) throws SQLException{
        return dao.deleteCategory(name);
    }
    
    
    
}
