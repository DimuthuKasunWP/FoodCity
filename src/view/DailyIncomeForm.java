
package view;

import controller.OrderController;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import model.Orders;

public class DailyIncomeForm extends javax.swing.JFrame {
private String date=null;
private DefaultTableModel default_table=null;
private OrderController ordercontroller=new OrderController();
    public DailyIncomeForm() {
        initComponents();
         this.setLocationRelativeTo(null);
    try {
        displayDailyProfit();
    } catch (SQLException ex) {
        Logger.getLogger(DailyIncomeForm.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
//    public String getCurrentDate(){
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//	Date date = new Date();
//        return dateFormat.format(date);	
//    }
    
    public void displayDailyProfit() throws SQLException{
        default_table=(DefaultTableModel)dailyProfit.getModel();
        List<Orders> list=new ArrayList<>();
        list=ordercontroller.getOrderProfit();
        if(!list.isEmpty()){
        for(Orders orders:list){
            default_table.addRow(new Object[]{orders.getDate(),orders.getProfit()});
        }
    }
        else{
            JOptionPane.showMessageDialog(null,"Empty Records");
        }
    }
    
//    public String convertDateFormat(){
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//	Date date = new Date();
//        return dateFormat.format(date);
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dailyProfit = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Daily Profit");

        jPanel1.setBackground(new java.awt.Color(153, 0, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Daily Profit");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 490, 100));

        dailyProfit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Profit"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(dailyProfit);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(AddBatchForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddBatchForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddBatchForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddBatchForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DailyIncomeForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable dailyProfit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
