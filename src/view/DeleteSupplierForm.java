/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.SupplierController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import model.Supplier;

/**
 *
 * @author kasun
 */
public class DeleteSupplierForm extends javax.swing.JFrame {
    private SupplierController controller=null;
    /**
     * Creates new form DeleteSupplierForm
     */
    public DeleteSupplierForm() {
        initComponents();
//        this.setSize(968,523);
    }
    
    public DeleteSupplierForm(Supplier supplier){
        controller=new SupplierController();
        initComponents();
//        this.setSize(968,523);
        this.setLocationRelativeTo(null);
        
        txtId.setText(Integer.toString(supplier.getS_id()));
        txtName.setText(supplier.getName());
        txtMobile1.setText(supplier.getMobile().get(0));
        if(supplier.getMobile().size()>1){
        if(supplier.getMobile().get(1)!=null){
            txtMobile2.setEnabled(true);
            txtMobile2.setText(supplier.getMobile().get(1));
        }
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
        lblId = new javax.swing.JLabel();
        lblMobile = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtMobile1 = new javax.swing.JTextField();
        txtMobile2 = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        sepFour1 = new javax.swing.JSeparator();
        sepFour2 = new javax.swing.JSeparator();
        sepFour = new javax.swing.JSeparator();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        sepFour3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Delete");

        pnlBase.setBackground(new java.awt.Color(153, 0, 153));
        pnlBase.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblId.setBackground(new java.awt.Color(255, 255, 255));
        lblId.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lblId.setForeground(new java.awt.Color(255, 255, 255));
        lblId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblId.setText("ID");
        pnlBase.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 230, 80));

        lblMobile.setBackground(new java.awt.Color(255, 255, 255));
        lblMobile.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lblMobile.setForeground(new java.awt.Color(255, 255, 255));
        lblMobile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMobile.setText("Mobile");
        pnlBase.add(lblMobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 230, 80));

        txtId.setBackground(new java.awt.Color(153, 0, 153));
        txtId.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txtId.setForeground(new java.awt.Color(255, 255, 255));
        txtId.setToolTipText("");
        txtId.setBorder(null);
        txtId.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIdFocusGained(evt);
            }
        });
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        pnlBase.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 400, 30));

        txtMobile1.setBackground(new java.awt.Color(153, 0, 153));
        txtMobile1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txtMobile1.setForeground(new java.awt.Color(255, 255, 255));
        txtMobile1.setToolTipText("");
        txtMobile1.setBorder(null);
        txtMobile1.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtMobile1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMobile1FocusGained(evt);
            }
        });
        txtMobile1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMobile1ActionPerformed(evt);
            }
        });
        pnlBase.add(txtMobile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, 320, 30));

        txtMobile2.setBackground(new java.awt.Color(153, 0, 153));
        txtMobile2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txtMobile2.setForeground(new java.awt.Color(255, 255, 255));
        txtMobile2.setToolTipText("");
        txtMobile2.setBorder(null);
        txtMobile2.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtMobile2.setEnabled(false);
        txtMobile2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMobile2FocusGained(evt);
            }
        });
        txtMobile2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMobile2ActionPerformed(evt);
            }
        });
        pnlBase.add(txtMobile2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 320, 30));

        btnSubmit.setBackground(new java.awt.Color(51, 0, 255));
        btnSubmit.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("DELETE");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        pnlBase.add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 440, 120, 50));

        lblTitle.setBackground(new java.awt.Color(255, 255, 255));
        lblTitle.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Delete Supplier");
        pnlBase.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 410, 110));
        pnlBase.add(sepFour1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 320, 10));
        pnlBase.add(sepFour2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, 320, 10));
        pnlBase.add(sepFour, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 380, 320, 10));

        lblName.setBackground(new java.awt.Color(255, 255, 255));
        lblName.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblName.setText("Name");
        pnlBase.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 230, 80));

        txtName.setBackground(new java.awt.Color(153, 0, 153));
        txtName.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txtName.setForeground(new java.awt.Color(255, 255, 255));
        txtName.setToolTipText("");
        txtName.setBorder(null);
        txtName.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNameFocusGained(evt);
            }
        });
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        pnlBase.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 400, 30));
        pnlBase.add(sepFour3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 320, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBase, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBase, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdFocusGained
//        txtId.setText("");
    }//GEN-LAST:event_txtIdFocusGained

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtMobile1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMobile1FocusGained
        txtMobile1.setText("");
    }//GEN-LAST:event_txtMobile1FocusGained

    private void txtMobile1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMobile1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMobile1ActionPerformed

    private void txtMobile2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMobile2FocusGained
        txtMobile2.setText("");
        //        if(!flag)
        //        txtMobile.setText("");
        //        flag=false;
    }//GEN-LAST:event_txtMobile2FocusGained

    private void txtMobile2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMobile2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMobile2ActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        try {
            String id = txtId.getText();
            boolean isDeleted = controller.deleteSupplier(Integer.parseInt(id));
            if(isDeleted)
            this.setVisible(false);
            else{
                JOptionPane.showMessageDialog(this,"Deieted Failed", "Something went wrong", JOptionPane.ERROR);
                txtId.setText("");
                txtMobile1.setText("");
                txtMobile2.setText("");
            }

        } catch (SQLException ex) {
            Logger.getLogger(AddSupplierForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void txtNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameFocusGained

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

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
            java.util.logging.Logger.getLogger(DeleteSupplierForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeleteSupplierForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeleteSupplierForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeleteSupplierForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeleteSupplierForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblMobile;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlBase;
    private javax.swing.JSeparator sepFour;
    private javax.swing.JSeparator sepFour1;
    private javax.swing.JSeparator sepFour2;
    private javax.swing.JSeparator sepFour3;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMobile1;
    private javax.swing.JTextField txtMobile2;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
