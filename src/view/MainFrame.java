/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.LoginController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author kasun
 */
public class MainFrame extends javax.swing.JFrame {
 private LoginController controller;
 private boolean flag=false;
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        flag=true;
        initComponents();
        this.setLocationRelativeTo(null);
        controller=new LoginController();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        pnlLeft = new javax.swing.JPanel();
        lblCart = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        sepThree = new javax.swing.JSeparator();
        sepOne = new javax.swing.JSeparator();
        sepTwo = new javax.swing.JSeparator();
        pnlRight = new javax.swing.JPanel();
        lblPassword = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        sepFour = new javax.swing.JSeparator();
        password = new javax.swing.JPasswordField();
        sepFour1 = new javax.swing.JSeparator();
        txtUserName = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Log-in");

        pnlMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlLeft.setBackground(new java.awt.Color(102, 255, 153));
        pnlLeft.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnlLeft.add(lblCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, -1, -1));

        lblTitle.setBackground(new java.awt.Color(255, 255, 255));
        lblTitle.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Thogakade");
        pnlLeft.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 410, 110));
        pnlLeft.add(sepThree, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 640, 140, 20));
        pnlLeft.add(sepOne, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 620, 410, 20));
        pnlLeft.add(sepTwo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 630, 260, 20));

        pnlMain.add(pnlLeft, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 750));

        pnlRight.setBackground(new java.awt.Color(36, 47, 65));
        pnlRight.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPassword.setBackground(new java.awt.Color(255, 255, 255));
        lblPassword.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPassword.setText("Password");
        pnlRight.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 230, 80));

        lblLogin.setBackground(new java.awt.Color(255, 255, 255));
        lblLogin.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        lblLogin.setForeground(new java.awt.Color(255, 255, 255));
        lblLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogin.setText("Log In");
        pnlRight.add(lblLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 410, 110));

        lblUserName.setBackground(new java.awt.Color(255, 255, 255));
        lblUserName.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lblUserName.setForeground(new java.awt.Color(255, 255, 255));
        lblUserName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserName.setText("User Name");
        pnlRight.add(lblUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 230, 80));
        pnlRight.add(sepFour, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 400, -1));

        password.setBackground(new java.awt.Color(36, 47, 65));
        password.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        password.setForeground(new java.awt.Color(255, 255, 255));
        password.setText("jkjjfdksfdasa");
        password.setToolTipText("");
        password.setBorder(null);
        password.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        password.setOpaque(false);
        password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFocusGained(evt);
            }
        });
        pnlRight.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 580, 400, 30));
        pnlRight.add(sepFour1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 610, 400, 50));

        txtUserName.setBackground(new java.awt.Color(36, 47, 65));
        txtUserName.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txtUserName.setForeground(new java.awt.Color(255, 255, 255));
        txtUserName.setText("Enter Your User Name Here");
        txtUserName.setToolTipText("");
        txtUserName.setBorder(null);
        txtUserName.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtUserName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserNameFocusGained(evt);
            }
        });
        txtUserName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUserNameMouseClicked(evt);
            }
        });
        txtUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserNameActionPerformed(evt);
            }
        });
        pnlRight.add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 400, 30));

        btnSubmit.setBackground(new java.awt.Color(102, 255, 153));
        btnSubmit.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        pnlRight.add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 660, 110, 40));

        pnlMain.add(pnlRight, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, -100, 650, 750));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserNameActionPerformed

    private void txtUserNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserNameFocusGained
           
        if(flag)
        txtUserName.setText("");
        flag=false;
    }//GEN-LAST:event_txtUserNameFocusGained

    private void passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusGained
        password.setText("");
    }//GEN-LAST:event_passwordFocusGained

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
     try {
         String userName=txtUserName.getText();
         String password=this.password.getPassword().toString();
         if(controller.Login(userName, password)){
             this.setVisible(false);
             
         }
         else{
             JOptionPane.showMessageDialog(this, "Enter Details Again","Login Falied", JOptionPane.ERROR_MESSAGE);
         }
             } catch (SQLException ex) {
         Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
     }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void txtUserNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUserNameMouseClicked
        txtUserName.setText("");
    }//GEN-LAST:event_txtUserNameMouseClicked

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
//                
                UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");    

            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame=new MainFrame();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel lblCart;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JPasswordField password;
    private javax.swing.JPanel pnlLeft;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlRight;
    private javax.swing.JSeparator sepFour;
    private javax.swing.JSeparator sepFour1;
    private javax.swing.JSeparator sepOne;
    private javax.swing.JSeparator sepThree;
    private javax.swing.JSeparator sepTwo;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
