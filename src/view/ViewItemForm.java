
package view;

import Font.FontLoader;
import controller.ItemController;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import model.Item;
import model.Supplier;

public class ViewItemForm extends javax.swing.JFrame {

    private ItemController itemcontroller=new ItemController();
    private Item item=null;
 
    public ViewItemForm() {
        initComponents();
        this.setLocationRelativeTo(null);
//        this.setSize(916,718);
        loadTable();
        view_details.setFont(FontLoader.loadFont(16, Font.PLAIN));
    }
    private void loadTable(){
        try {
            DefaultTableModel dtm=(DefaultTableModel) view_details.getModel();
            List<Item> all = itemcontroller.getAll();
            for (Item elem : all) {
                Object[] row={elem.getI_id(),elem.getB_id(),elem.getC_id(),elem.getDescription(),elem.getTaking_price(),elem.getThoga_price(),elem.getShown_price(),elem.getOur_price(),elem.getWarning(),elem.getQuantity()};
                dtm.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewItemForm.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        view_details = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("View Items");

        jPanel1.setBackground(new java.awt.Color(153, 0, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("View Items");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 320, 70));

        view_details.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        view_details.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Batch ID", "Category ID", "Description", "Taking Price", "Thoga Price", "Show Price", "Our Price", "Warning Level", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(view_details);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1350, 480));

        btnDelete.setBackground(new java.awt.Color(51, 0, 255));
        btnDelete.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("DELETE");
        btnDelete.setBorder(null);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 620, 120, 50));

        jButton2.setBackground(new java.awt.Color(51, 0, 255));
        jButton2.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Update");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 620, 120, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1434, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
//            DeleteItemForm form= new DeleteItemForm();
//            form.setVisible(true);DefaultTableModel dtm=(DefaultTableModel) view_details.getModel();
        int res = JOptionPane.showConfirmDialog(this, "Do you want to delete?");
        if(res==JOptionPane.YES_OPTION){
        DefaultTableModel dtm=(DefaultTableModel) view_details.getModel();
        if(view_details.getSelectedRowCount()>1){
            JOptionPane.showMessageDialog(this, "select only one row at time", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else if(view_details.getSelectedRowCount()==0)
            JOptionPane.showMessageDialog(this, "select one row at time", "Warning", JOptionPane.WARNING_MESSAGE);
        else{
        
         try {
             long  id = (long) dtm.getValueAt(view_details.getSelectedRow(), 0);
             boolean isDeleted = itemcontroller.deleteItem(id);
             if(isDeleted){
                 this.dispose();
                 
             }else{
                 JOptionPane.showMessageDialog(this, "Something Went Wrong", "Error", JOptionPane.ERROR);
             }
         } catch (SQLException ex) {
             Logger.getLogger(DeleteItemForm.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
        }
        
            
            
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       DefaultTableModel dtm=(DefaultTableModel) view_details.getModel();
        if(view_details.getSelectedRowCount()>1){
            JOptionPane.showMessageDialog(this, "select only one row at time", "Warning", JOptionPane.WARNING_MESSAGE);
      }
        else if(view_details.getSelectedRowCount()==0)
            JOptionPane.showMessageDialog(this, "select one row at time", "Warning", JOptionPane.WARNING_MESSAGE);
        else{
            long  id =  (long) dtm.getValueAt(view_details.getSelectedRow(), 0);
            int batch_id =   (int) dtm.getValueAt(view_details.getSelectedRow(), 1);
            int category_id= (int) dtm.getValueAt(view_details.getSelectedRow(), 2);
             String desctiption =(String) dtm.getValueAt(view_details.getSelectedRow(), 3);
            double taking_price=(double) dtm.getValueAt(view_details.getSelectedRow(), 4);
             double thoga_price= (double) dtm.getValueAt(view_details.getSelectedRow(), 5);
             double our_price= (double) dtm.getValueAt(view_details.getSelectedRow(), 7);
              int warning=(int) dtm.getValueAt(view_details.getSelectedRow(), 8);
               double qty=(double) dtm.getValueAt(view_details.getSelectedRow(), 9);
               double shown_price=(double) dtm.getValueAt(view_details.getSelectedRow(), 6);
           Item item=new Item(id, batch_id, category_id, desctiption, taking_price, thoga_price, our_price,shown_price, warning, qty);
            JFrame frame= new UpdateItemForm(item);
            frame.setVisible(true);    
            loadTable();
      
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewItemForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewItemForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewItemForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewItemForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewItemForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable view_details;
    // End of variables declaration//GEN-END:variables
}
