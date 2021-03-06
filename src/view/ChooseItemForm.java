/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Font.FontLoader;
import controller.CategoryController;
import controller.ItemController;
import java.awt.Font;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import model.Category;
import model.Item;

/**
 *
 * @author kasun
 */
public class ChooseItemForm extends javax.swing.JFrame {
    private CategoryController controller;
    private ItemController itemController;
    DashBoard board=null;
    /**
     * Creates new form ChooseItemForm
     */
    public ChooseItemForm() {
        controller=new CategoryController();
        itemController=new ItemController();
        initComponents();
//        this.setSize(1189,744);
        this.setLocationRelativeTo(null);
        loadCombo();
    }
    public ChooseItemForm(DashBoard dash){
        controller=new CategoryController();
        itemController=new ItemController();
        board=dash;
        initComponents();
        this.setSize(1189,744);
        this.setLocationRelativeTo(null);
        loadCombo();
        view_details.setFont(FontLoader.loadFont(16, Font.PLAIN));
    }
    private void loadCombo(){
        cmbCategory.removeAllItems();
        try {
            List<Category> all = controller.getAll();
            for (Category item : all) {
                cmbCategory.addItem(item.getName());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChooseItemForm.class.getName()).log(Level.SEVERE, null, ex);
        }
//        cmbCategory.setSelectedIndex(0);
        loadTable();
        
    }
    
    private void loadTable(){
        try {
            DefaultTableModel dtm=(DefaultTableModel) view_details.getModel();
            String  selectedItem = (String) cmbCategory.getSelectedItem();
            List<Item> all = itemController.getAllByCategory(selectedItem);
            for (Item elem : all) {
                Object[] row={elem.getI_id(),elem.getC_id(),elem.getDescription(),elem.getTaking_price(),elem.getThoga_price(),elem.getShown_price(),elem.getOur_price(),elem.getQuantity()};
                dtm.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChooseItemForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBase = new javax.swing.JPanel();
        cmbCategory = new javax.swing.JComboBox<>();
        lblCategory = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        view_details = new javax.swing.JTable();
        btnSelect = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Select Ctegory");

        pnlBase.setBackground(new java.awt.Color(153, 0, 153));
        pnlBase.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbCategory.setBackground(new java.awt.Color(153, 0, 153));
        cmbCategory.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        pnlBase.add(cmbCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, 346, 53));

        lblCategory.setBackground(new java.awt.Color(255, 255, 255));
        lblCategory.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        lblCategory.setForeground(new java.awt.Color(255, 255, 255));
        lblCategory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCategory.setText("Choose Category");
        pnlBase.add(lblCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 390, 70));

        view_details.setFont(new java.awt.Font("Nirmala UI", 0, 24)); // NOI18N
        view_details.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Category ID", "Description", "Taking Price", "Thoga Price", "Shown_Price", "Our Price", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(view_details);

        pnlBase.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 870, 490));

        btnSelect.setBackground(new java.awt.Color(51, 0, 255));
        btnSelect.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        btnSelect.setForeground(new java.awt.Color(255, 255, 255));
        btnSelect.setText("Select");
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });
        pnlBase.add(btnSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 660, 230, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBase, javax.swing.GroupLayout.DEFAULT_SIZE, 1189, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBase, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        DefaultTableModel dtm= (DefaultTableModel) view_details.getModel();
        if(view_details.getSelectedRowCount()>1){
            JOptionPane.showMessageDialog(this, "select only one row at time", "Warning", JOptionPane.WARNING_MESSAGE);
      }
        else if(view_details.getSelectedRowCount()==0)
            JOptionPane.showMessageDialog(this, "select one row at time", "Warning", JOptionPane.WARNING_MESSAGE);
        else{
            long  id = (long) dtm.getValueAt(view_details.getSelectedRow(), 0);
            int category_id= (int) dtm.getValueAt(view_details.getSelectedRow(), 1);
             String desctiption =(String) dtm.getValueAt(view_details.getSelectedRow(), 2);
            double taking_price=(double) dtm.getValueAt(view_details.getSelectedRow(), 3);
             double thoga_price= (double) dtm.getValueAt(view_details.getSelectedRow(), 4);
             double our_price= (double) dtm.getValueAt(view_details.getSelectedRow(), 6);
             double shown_price=(double) dtm.getValueAt(view_details.getSelectedRow(), 5);
             double qty=(double) dtm.getValueAt(view_details.getSelectedRow(), 7);
           Item item=new Item(id, 0, category_id, desctiption, taking_price, thoga_price, our_price,shown_price, 0, qty);
//           DashBoard board=new DashBoard();
            board.loadData(item);
           this.dispose();
        }
    }//GEN-LAST:event_btnSelectActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
               UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");    
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChooseItemForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChooseItemForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChooseItemForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChooseItemForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChooseItemForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelect;
    private javax.swing.JComboBox<String> cmbCategory;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JPanel pnlBase;
    private javax.swing.JTable view_details;
    // End of variables declaration//GEN-END:variables
}
