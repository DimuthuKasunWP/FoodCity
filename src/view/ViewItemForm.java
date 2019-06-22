
package view;

import controller.ItemController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Batch;
import model.Item;

public class ViewItemForm extends javax.swing.JFrame {
    public DefaultTableModel default_table=null;
    private ItemController itemcontroller=new ItemController();
    private Item item=null;
 
    public ViewItemForm(){
        initComponents();
        this.setLocationRelativeTo(null);
        try {
            getItems();
        } catch (SQLException ex) {
            Logger.getLogger(ViewItemForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getItems() throws SQLException{
        default_table=(DefaultTableModel)view_details.getModel();
        List<Item> list=new ArrayList<>();
        list=itemcontroller.getAll();
        if(!list.isEmpty()){
        for(Item item:list){
            default_table.addRow(new Object[]{item.getI_id(),item.getB_id(),item.getC_id(),item.getDescription(),item.getTaking_price(),item.getThoga_price(),item.getOur_price(),item.getWarning(),item.getQuantity()});
        }
    }
        else{
            JOptionPane.showMessageDialog(null,"Empty Records");
        }
    }
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        view_details = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 0, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("View Items");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 320, 70));

        view_details.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Batch ID", "Category ID", "Description", "Taking Price", "Thoga Price", "Our Price", "Warning Level", "Quantity"
            }
        ));
        jScrollPane1.setViewportView(view_details);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 810, 480));

        jButton1.setBackground(new java.awt.Color(0, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Update");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204), 3));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 620, 120, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            int row=view_details.getSelectedRow();
//            int column=view_details.getSelectedColumn();
        
//            String data=view_details.getModel().getValueAt(row, column).toString();
//            int item_id=Integer.parseInt(data);
            int row_no_of_data=view_details.getRowCount();
            for(int i=0;i<row_no_of_data;i++){
                String items_id=view_details.getModel().getValueAt(row,0).toString();
                int item_id=Integer.parseInt(items_id);
                int batch_id=Integer.parseInt(view_details.getModel().getValueAt(row,1).toString());
                int category_id=Integer.parseInt(view_details.getModel().getValueAt(row,2).toString());
                String description=view_details.getModel().getValueAt(row,3).toString();
                double taking_price=Double.parseDouble(view_details.getModel().getValueAt(row,4).toString());
                double thoga_price=Double.parseDouble(view_details.getModel().getValueAt(row,5).toString());
                double our_price=Double.parseDouble(view_details.getModel().getValueAt(row,6).toString());
                String warning=view_details.getModel().getValueAt(row,7).toString();
                double quantity=Double.parseDouble(view_details.getModel().getValueAt(row,8).toString());
                item=new Item(item_id,batch_id,category_id,description,taking_price,thoga_price,our_price,warning,quantity);
                try {
                    boolean isUpdated=itemcontroller.updateItem(item);
                    if(isUpdated==false)
                        break;
                    
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Error Updating");
                    Logger.getLogger(ViewItemForm.class.getName()).log(Level.SEVERE, null, ex);
                    break;
                }
            }
    }//GEN-LAST:event_jButton1ActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable view_details;
    // End of variables declaration//GEN-END:variables
}
