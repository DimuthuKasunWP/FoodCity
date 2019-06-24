
package view;

import controller.ItemController;
import controller.OrderController;
import static java.awt.Component.TOP_ALIGNMENT;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static java.awt.font.TextAttribute.FONT;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.Attribute;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import model.Item;
import model.OrderDetail;
import model.Orders;

/**
 *
 * @author Benura
 */
public class DashBoard extends javax.swing.JFrame {
    List<OrderDetail> temp=new ArrayList<>();
    private ItemController controller=new ItemController();
    private OrderController orderController=new OrderController();
    private boolean isLoaded=false;
    private int item_quantity;
    private double item_quantity_d;
    /**
     * Creates new form DashBoard
     */
    public DashBoard() {
        initComponents();
        this.setSize(1441,768);
        this.setLocationRelativeTo(null);
        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setSelected(true);
        txtItemId.requestFocus();
        txtQty.setText(""+1);
        txtProfit.setText(""+0.0);
        txtGrandPrice.setText(""+0.0);
         loadData();
    }
    public DashBoard(Item item){
        initComponents();
        this.setSize(1441,768);
        this.setLocationRelativeTo(null);
        loadData(item);
        txtProfit.setText(""+0.0);
        txtGrandPrice.setText(""+0.0);
    }
    public void loadData(Item item){
        isLoaded=true;
        txtProfit.setText(""+0.0);
        txtGrandPrice.setText(""+0.0);
        txtItemId.requestFocus();
        jRadioButton2.setSelected(true);
        txtItemId.setText(Integer.toString(item.getI_id()));
        txtDescription.setText(item.getDescription());
        txtName6.setText(Double.toString(item.getThoga_price()));
        txtName1.setText(Double.toString(item.getTaking_price()));
        txtPrice.setText(Double.toString(item.getOur_price()));
        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        txtQty.setText(""+1);
        if(jRadioButton1.isSelected())
            txtPrice.setText(Double.toString(item.getThoga_price()));
        else
            txtPrice.setText(Double.toString(item.getTaking_price()));
    }
    
    public int countRow(){
        return jTable1.getRowCount();
    }
    
    public double paidAmount(){
        return 20000.00;
    }
    
    private void loadData(){
        txtProfit.setText(""+0.0);
        txtGrandPrice.setText(""+0.0);
        txtItemId.requestFocus();
        jRadioButton2.setSelected(true);
        txtItemId.setText("");
        txtDescription.setText("");
        txtName6.setText("");
        txtName1.setText("");
        txtPrice.setText("");
        txtQty.setText(""+1);
    }
    
    public PageFormat getPage(PrinterJob print){
        
        PageFormat pf=print.defaultPage();
        Paper paper=pf.getPaper();
        int row_count=jTable1.getRowCount();
        double cm_per_item=3.0;
        double middleHeight=row_count*cm_per_item;
        double headerHeight=4.0;
        double footerHeight=4.0;
        double width=convert_CM_to_PPI(8);
      //  double width=20.32;
        double height=convert_CM_to_PPI(middleHeight+headerHeight+footerHeight);
        System.out.println(height);
        paper.setSize(width, height);
        paper.setImageableArea(0,2,width, height);
        pf.setOrientation(PageFormat.PORTRAIT);
        pf.setPaper(paper);
        
        return pf;
        
    }
    
    protected static double convert_CM_to_PPI(double cm){
        return toPPI(cm*0.393600787);
    }
    
    protected static double toPPI(double inch){
        return inch*72d;
    }
    
    public class billprintable implements Printable{
    
    @Override    
    public int print(Graphics graphics,PageFormat pageformat,int pageIndex){
        int result=NO_SUCH_PAGE;
        if(pageIndex==0){
            Graphics2D g2d=(Graphics2D)graphics;
            double width=pageformat.getImageableWidth();
            System.out.println(width);
            g2d.translate((int)pageformat.getImageableX(),(int)pageformat.getImageableY());
            FontMetrics metrics=g2d.getFontMetrics(new Font("Arial",Font.BOLD,5));
            int idLength=metrics.stringWidth("000");
            int x_length=1;
            int smtLength=metrics.stringWidth("000000");
            int qtyLength=metrics.stringWidth("00000");
            int priceLength=metrics.stringWidth("000000");
            int productLength=(int)width-idLength-qtyLength-priceLength-17;
            int productPosition=0;
            int discountPosition=productLength+5;
            int pricePosition=discountPosition+idLength+10;
            int qtyPosition=pricePosition+priceLength+4;
            int amtPosition=qtyPosition+qtyLength;
            
            try{
                int y=20;
                int yShift=10;
                int headerRectHeight=15;
                int headerRectHeighta=40;
                String pn1a="ksdnknv";
                String pn2a="kdlkvmvf";
                String pn3a="dnawodnofw";
                String pn4a="dnalknkeo";
                int pp1a=10;
                int pp2a=10;
                int pp3a=10;
                int pp4a=10;
                int sum=pp1a+pp2a+pp3a+pp4a;
                g2d.setFont(new Font("Nirmala UI",Font.PLAIN,14));
                g2d.drawString("       රසාංජන    ට්‍  ඩර්ස්                                                                                                                                                                                            "
                        + "    ",10,y);y+=yShift;
               // g2d.drawString("විරාෂා ටේඩර්ස් ",5,y);y+=yShift;
                g2d.setFont(new Font("Nirmala UI",Font.PLAIN,9));
                g2d.drawString("   නො:100 පරණ පාර, කොරළවැ ල්ල, මොරටුව                                         "
                        + "         ",10,y);y+=yShift;
                g2d.setFont(new Font("Monospaced",Font.PLAIN,10));
                g2d.drawString("Tel 071-6302364 / 071-5875426",32,y);y+=yShift+2;
                g2d.setFont(new Font("Nirmala UI",Font.PLAIN,9));
                g2d.drawString("බිල්පත් අංකය : 00000001                                                                         "
                        + "         ",1,y);y+=yShift+2;
                g2d.setFont(new Font("Monospaced",Font.PLAIN,10));
                g2d.drawString("Staff :- None",1,y);
                g2d.setFont(new Font("Monospaced",Font.PLAIN,10));
                g2d.drawString("Cash : admin",100,y);y+=yShift;
                g2d.setFont(new Font("Nirmala UI",Font.PLAIN,10));
                g2d.drawString("=================================================================================================================",1,y); y+=yShift;
                g2d.drawString("ප්‍රමාණය                                                             "
                        + "",x_length,y);x_length+=50;
                g2d.drawString("   සඳහන් මිල                                                                            "
                        + "  ",x_length,y);x_length+=60;
                g2d.drawString("   අපේ මිල                                                                                  "
                        + "        ",x_length,y);x_length+=50;
                g2d.drawString("   ඵකතුව                                                                               "
                        + "      ",x_length,y);y+=yShift;
                g2d.drawString("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------",1,y);y+=yShift;
                for(int i=0;i<countRow();i++){
                     int x_length_temp=1;
                     String item_name=jTable1.getValueAt(i,0).toString();
                     String combo_selected=cmbRatio.getSelectedItem().toString();
                     String total_per_item=jTable1.getValueAt(i,4).toString();
                     g2d.drawString(item_name,1,y);y+=yShift;
                     if(combo_selected=="none"){
                         item_quantity=Integer.parseInt(jTable1.getValueAt(i,2).toString());
                         g2d.drawString(String.valueOf(item_quantity),x_length_temp, y);x_length_temp+=50;
                     }  
                     else{
                         item_quantity_d=Double.parseDouble(jTable1.getValueAt(i,2).toString());
                         g2d.drawString(String.valueOf(item_quantity),x_length_temp, y);x_length_temp+=50;
                     } 
                        g2d.drawString("600.00",x_length_temp, y);x_length_temp+=60;
                        g2d.drawString(txtPrice.getText().toString(),x_length_temp, y);x_length_temp+=50;
                        g2d.drawString(total_per_item,x_length_temp,y);y+=yShift+1;
                
                }
               
                g2d.drawString("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ ",1,y);y+=yShift;
                g2d.drawString("       උප ඵකතුව : " + txtGrandPrice.getText().toString()
                        + "       ", 20, y);y+=yShift+4;
                g2d.drawString("       මුලු ඵකතුව : " + txtGrandPrice.getText().toString()
                        + "       ", 20, y);y+=yShift+6;
                g2d.drawString("***  ගෙවීම්  ***                                                                         "
                        + "       ", 1, y);y+=yShift+3;
                g2d.drawString("                   ගෙවූ මුදල               "+ String.valueOf(paidAmount())                                                                                  
                        + "       ", 10, y);y+=yShift+5;
                g2d.drawString("                   ඉතිරි මුදල              " + String.valueOf(paidAmount()-(Double.parseDouble(txtGrandPrice.getText().toString())))
                        + "       ", 10, y);y+=yShift+5;    
                g2d.drawString("================================================================================================================= " , 2, y);y+=yShift+8;
                g2d.drawString(" දිනය  :  2019-10-10                                                                                                          "
                        + "       ", 1, y);y+=yShift+4;      
                g2d.drawString(" වේලාව  :  07:44:15 PM                                                                                                          "
                        + "       ", 1, y);y+=yShift;      
                
                
                
                
                
                
            }catch(Exception ex){
                
            }
            result=PAGE_EXISTS;
        }
        return result;
    }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtName1 = new javax.swing.JTextField();
        sepFour3 = new javax.swing.JSeparator();
        txtItemId = new javax.swing.JTextField();
        sepFour4 = new javax.swing.JSeparator();
        txtDescription = new javax.swing.JTextField();
        sepFour5 = new javax.swing.JSeparator();
        txtProfit = new javax.swing.JTextField();
        sepFour7 = new javax.swing.JSeparator();
        txtName6 = new javax.swing.JTextField();
        sepFour8 = new javax.swing.JSeparator();
        txtGrandPrice = new javax.swing.JTextField();
        sepFour9 = new javax.swing.JSeparator();
        txtPrice = new javax.swing.JTextField();
        sepFour10 = new javax.swing.JSeparator();
        txtQty = new javax.swing.JTextField();
        sepFour11 = new javax.swing.JSeparator();
        cmbRatio = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DashBoard");

        jPanel1.setBackground(new java.awt.Color(153, 0, 153));
        jPanel1.setMaximumSize(new java.awt.Dimension(1500, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 0, 255));
        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jButton1.setText("Choose Item");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 190, 40));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Item Code");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 130, 40));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 110, 40));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Thoga Price");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 80, 150, 40));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Sillara Price");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 80, 150, 40));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Selection");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 130, 40));

        jRadioButton1.setBackground(new java.awt.Color(153, 0, 153));
        jRadioButton1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("Thoga");
        jPanel1.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 120, 40));

        jRadioButton2.setBackground(new java.awt.Color(153, 0, 153));
        jRadioButton2.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("Sillara");
        jPanel1.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 130, 40));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, -1, -1));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Quantity");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 110, 40));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Our Price");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, 120, 40));

        jTable1.setBackground(new java.awt.Color(255, 255, 51));
        jTable1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Id", "Description", "Quantity", "Price", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 950, 320));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Profit");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 430, 100, 35));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Grand Price");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 510, 160, 35));

        jButton2.setBackground(new java.awt.Color(0, 0, 255));
        jButton2.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jButton2.setText("Proceed");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 610, 120, 40));

        txtName1.setBackground(new java.awt.Color(153, 0, 153));
        txtName1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        txtName1.setForeground(new java.awt.Color(255, 255, 255));
        txtName1.setToolTipText("");
        txtName1.setBorder(null);
        txtName1.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtName1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtName1FocusGained(evt);
            }
        });
        txtName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtName1ActionPerformed(evt);
            }
        });
        jPanel1.add(txtName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 80, 150, 30));
        jPanel1.add(sepFour3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 110, 130, 10));

        txtItemId.setBackground(new java.awt.Color(153, 0, 153));
        txtItemId.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        txtItemId.setForeground(new java.awt.Color(255, 255, 255));
        txtItemId.setText("Enter Code");
        txtItemId.setToolTipText("");
        txtItemId.setBorder(null);
        txtItemId.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtItemId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtItemIdFocusGained(evt);
            }
        });
        txtItemId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemIdActionPerformed(evt);
            }
        });
        jPanel1.add(txtItemId, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 170, 30));
        jPanel1.add(sepFour4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 140, 10));

        txtDescription.setBackground(new java.awt.Color(153, 0, 153));
        txtDescription.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        txtDescription.setForeground(new java.awt.Color(255, 255, 255));
        txtDescription.setText("Enter Name");
        txtDescription.setToolTipText("");
        txtDescription.setBorder(null);
        txtDescription.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtDescription.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDescriptionFocusGained(evt);
            }
        });
        txtDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescriptionActionPerformed(evt);
            }
        });
        jPanel1.add(txtDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 170, 30));
        jPanel1.add(sepFour5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 150, 10));

        txtProfit.setBackground(new java.awt.Color(153, 0, 153));
        txtProfit.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        txtProfit.setForeground(new java.awt.Color(255, 255, 255));
        txtProfit.setToolTipText("");
        txtProfit.setBorder(null);
        txtProfit.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtProfit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtProfitFocusGained(evt);
            }
        });
        txtProfit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProfitActionPerformed(evt);
            }
        });
        jPanel1.add(txtProfit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 430, 210, 30));
        jPanel1.add(sepFour7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 460, 210, 10));

        txtName6.setBackground(new java.awt.Color(153, 0, 153));
        txtName6.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        txtName6.setForeground(new java.awt.Color(255, 255, 255));
        txtName6.setToolTipText("");
        txtName6.setBorder(null);
        txtName6.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtName6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtName6FocusGained(evt);
            }
        });
        txtName6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtName6ActionPerformed(evt);
            }
        });
        jPanel1.add(txtName6, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 80, 130, 30));
        jPanel1.add(sepFour8, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 110, 130, 10));

        txtGrandPrice.setBackground(new java.awt.Color(153, 0, 153));
        txtGrandPrice.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        txtGrandPrice.setForeground(new java.awt.Color(255, 255, 255));
        txtGrandPrice.setToolTipText("");
        txtGrandPrice.setBorder(null);
        txtGrandPrice.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtGrandPrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtGrandPriceFocusGained(evt);
            }
        });
        txtGrandPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGrandPriceActionPerformed(evt);
            }
        });
        jPanel1.add(txtGrandPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 510, 210, 30));
        jPanel1.add(sepFour9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 540, 210, 10));

        txtPrice.setBackground(new java.awt.Color(153, 0, 153));
        txtPrice.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        txtPrice.setForeground(new java.awt.Color(255, 255, 255));
        txtPrice.setText("Enter Price");
        txtPrice.setToolTipText("");
        txtPrice.setBorder(null);
        txtPrice.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtPrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPriceFocusGained(evt);
            }
        });
        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });
        jPanel1.add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, 140, 30));
        jPanel1.add(sepFour10, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 290, 130, 10));

        txtQty.setBackground(new java.awt.Color(153, 0, 153));
        txtQty.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        txtQty.setForeground(new java.awt.Color(255, 255, 255));
        txtQty.setText("Enter Qty");
        txtQty.setToolTipText("");
        txtQty.setBorder(null);
        txtQty.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtQty.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtQtyFocusGained(evt);
            }
        });
        txtQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtyActionPerformed(evt);
            }
        });
        jPanel1.add(txtQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 140, 30));
        jPanel1.add(sepFour11, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 140, 10));

        cmbRatio.setBackground(new java.awt.Color(153, 0, 153));
        cmbRatio.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        cmbRatio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE", "G", "ML", " " }));
        cmbRatio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbRatioMouseClicked(evt);
            }
        });
        cmbRatio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRatioActionPerformed(evt);
            }
        });
        jPanel1.add(cmbRatio, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 262, 80, 30));

        btnAdd.setBackground(new java.awt.Color(51, 0, 255));
        btnAdd.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setBorder(null);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 260, 100, 40));

        jButton4.setBackground(new java.awt.Color(51, 0, 255));
        jButton4.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jButton4.setText("Change Order");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 250, 270, 40));

        jButton5.setBackground(new java.awt.Color(51, 0, 255));
        jButton5.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jButton5.setText("Get Previous Order");
        jButton5.setBorder(null);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 320, 270, 40));

        btnDelete.setBackground(new java.awt.Color(51, 0, 255));
        btnDelete.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 610, 130, 40));

        jMenuBar1.setBackground(new java.awt.Color(153, 0, 153));

        jMenu1.setBackground(new java.awt.Color(153, 0, 153));
        jMenu1.setText("Supplier");
        jMenu1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem1.setText("Create Supplier");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItem2.setText("View ");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setBackground(new java.awt.Color(153, 0, 153));
        jMenu2.setText("Categories");
        jMenu2.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItem3.setText("Add ");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jMenuItem4.setText("View");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        jMenu3.setBackground(new java.awt.Color(153, 0, 153));
        jMenu3.setText("Reports");
        jMenu3.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem5.setText("Daily Income");
        jMenu3.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        jMenuItem6.setText("Income Per Order");
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        jMenu5.setBackground(new java.awt.Color(153, 0, 153));
        jMenu5.setText("Items");
        jMenu5.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        jMenuItem7.setText("Add Item");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem7);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        jMenuItem8.setText("View");
        jMenu5.add(jMenuItem8);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1398, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new AddSupplierForm().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void txtName1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtName1FocusGained
        txtName1.setText(null);
    }//GEN-LAST:event_txtName1FocusGained

    private void txtName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtName1ActionPerformed

    private void txtItemIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtItemIdFocusGained
        if(!isLoaded)
        txtItemId.setText(null);
    }//GEN-LAST:event_txtItemIdFocusGained

    private void txtItemIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemIdActionPerformed
        txtQty.requestFocus();
    }//GEN-LAST:event_txtItemIdActionPerformed

    private void txtDescriptionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescriptionFocusGained
        txtDescription.setText(null);
    }//GEN-LAST:event_txtDescriptionFocusGained

    private void txtDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescriptionActionPerformed

    private void txtProfitFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProfitFocusGained
        txtProfit.setText(null);
    }//GEN-LAST:event_txtProfitFocusGained

    private void txtProfitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProfitActionPerformed
        // TODO add your handling code here:
        txtProfit.setText("");
    }//GEN-LAST:event_txtProfitActionPerformed

    private void txtName6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtName6FocusGained
        txtName6.setText(null);
    }//GEN-LAST:event_txtName6FocusGained

    private void txtName6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtName6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtName6ActionPerformed

    private void txtGrandPriceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGrandPriceFocusGained
         txtGrandPrice.setText(null);
    }//GEN-LAST:event_txtGrandPriceFocusGained

    private void txtGrandPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGrandPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGrandPriceActionPerformed

    private void txtPriceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPriceFocusGained
        txtPrice.setText(null);
    }//GEN-LAST:event_txtPriceFocusGained

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        btnAdd.doClick();
    }//GEN-LAST:event_txtPriceActionPerformed

    private void txtQtyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQtyFocusGained
        txtQty.setText("");
    }//GEN-LAST:event_txtQtyFocusGained

    private void txtQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtyActionPerformed
        cmbRatio.requestFocus();
    }//GEN-LAST:event_txtQtyActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ChooseItemForm form=new ChooseItemForm(this);
        form.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
            boolean isAvailable=false;
            int rowIndex=0;
            double qty=0;
            double price=0.0;
            double Grandtotal=0.0;
            double profit=0.0;
           int rowCount = jTable1.getRowCount();
            DefaultTableModel dtm= (DefaultTableModel) jTable1.getModel();
            for (int count = 0; count < dtm.getRowCount(); count++){
                if(dtm.getValueAt(count, 0).toString().equals(txtItemId.getText().trim())){
                    isAvailable=true;
                    rowIndex=count;
                }
            
            }
            if(!isAvailable){
            String description=txtDescription.getText();
            qty= Double.parseDouble(txtQty.getText());
            price=Double.parseDouble(txtPrice.getText());
            int i_id=Integer.parseInt(txtItemId.getText());
            double total=0;
            if(cmbRatio.getSelectedItem().toString().equals("NONE")){
                total=qty*price;
            }else if(cmbRatio.getSelectedItem().toString().equals("G")){
                total=qty*(price/1000);
            }else{
                total=qty*(price/1000);
            }
            Object row[]= {i_id,description,qty,price,total};
            dtm.addRow(row);
            }else{
                int previousQty=(int)dtm.getValueAt(rowIndex, 2);
                dtm.setValueAt(previousQty+qty, rowIndex, 2);
                double newTotal=((previousQty+qty)*price);
                dtm.setValueAt(newTotal, rowIndex, 4);
            }
            int newRowCount=jTable1.getRowCount();
            dtm= (DefaultTableModel) jTable1.getModel();
            for (int count = 0; count < dtm.getRowCount(); count++){
                try {
                    Grandtotal+=(double)dtm.getValueAt(count, 4);
                    
                    Item item = controller.getItem((int)dtm.getValueAt(count, 0));
                    double sellingPrice=(double)dtm.getValueAt(count, 4);
                    double normalPrice=(double)dtm.getValueAt(count, 2)*item.getTaking_price();
                    profit+=sellingPrice-normalPrice;
                            } catch (SQLException ex) {
                    Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
                    txtProfit.setText(""+profit);
                    txtGrandPrice.setText(""+Grandtotal);
                    loadData();
            
            
    }//GEN-LAST:event_btnAddActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int rowCount = jTable1.getRowCount();
         
        DefaultTableModel dtm=(DefaultTableModel) jTable1.getModel();
        for (int count = 0; count < dtm.getRowCount(); count++){
            OrderDetail detail=new OrderDetail();
            detail.setI_Id(Integer.parseInt(dtm.getValueAt(count, 0).toString()));
            detail.setDescription(dtm.getValueAt(count, 1).toString());
            detail.setPrice(Double.parseDouble(dtm.getValueAt(count,3 ).toString()));
            detail.setQty(Double.parseDouble(dtm.getValueAt(count,2 ).toString()));
            detail.setTotal(Double.parseDouble(dtm.getValueAt(count,4).toString()));
            temp.add(detail);
        }
        jTable1.removeAll();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jTable1.removeAll();
        DefaultTableModel dtm=(DefaultTableModel) jTable1.getModel();
        for (OrderDetail detail : temp) {
            Object [] row={detail.getI_Id(),detail.getDescription(),detail.getPrice(),detail.getQty(),detail.getTotal()};
            dtm.addRow(row);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void cmbRatioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRatioActionPerformed
        txtPrice.selectAll();
        txtPrice.requestFocus();
    }//GEN-LAST:event_cmbRatioActionPerformed

    private void cmbRatioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbRatioMouseClicked
        txtPrice.selectAll();
        txtPrice.requestFocus();
    }//GEN-LAST:event_cmbRatioMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            Orders orders=new Orders();
            orders.setProfit(Double.parseDouble(txtProfit.getText()));
            orders.setTime(new Timestamp(new Date().getTime()));
            
            List<OrderDetail> list=new ArrayList<>();
            int rowCount = jTable1.getRowCount();
         
        DefaultTableModel dtm=(DefaultTableModel) jTable1.getModel();
        for (int count = 0; count < dtm.getRowCount(); count++){
                try {
                    OrderDetail detail=new OrderDetail();
                    detail.setDescription((String)dtm.getValueAt(count, 1));
                    detail.setI_Id((int) dtm.getValueAt(count,0));
                    detail.setPrice((double) dtm.getValueAt(count,3));
                    Item item = controller.getItem((int) dtm.getValueAt(count,0));
                    detail.setQty(item.getQuantity()-((double) dtm.getValueAt(count, 2)));
                    detail.setTotal((double) dtm.getValueAt(count, 4));
                    list.add(detail);
                } catch (SQLException ex) {
                    Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        boolean isOrderPlaced = orderController.placeOrder(orders, list);
        if(isOrderPlaced){
            loadData();
            PrinterJob pj=PrinterJob.getPrinterJob();
            PrintService service=PrintServiceLookup.lookupDefaultPrintService();
            
//       if(service!=null){
//        try{
//        System.out.println(service);
//        File outputFile = new File("2010-10-10"+"-Recibo"+"print"+".xps");
//        
//        Doc doc = new SimpleDoc(new billprintable(), DocFlavor.SERVICE_FORMATTED.PRINTABLE, null);
//     
//        PrintRequestAttributeSet attributes = new HashPrintRequestAttributeSet();
//        attributes.add(new Copies(1)outputFile);
//
//        DocPrintJob job = service.createPrintJob();
//        job.print(doc, attributes);
//    } catch(Exception e){
//        System.out.println("kaboom"+e);
//    }
//}
                try {
                    pj.setPrintService(service);
                    pj.setPrintable(new billprintable(),getPage(pj));
                    pj.print();
                } catch (PrinterException ex) {
                    Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
              }
        }else{
            JOptionPane.showMessageDialog(this,"Something went wrong","Error",JOptionPane.ERROR);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int selectedCount = jTable1.getSelectedRowCount();
        if(selectedCount<=0){
            JOptionPane.showMessageDialog(this, "Select a row","Warning",JOptionPane.WARNING_MESSAGE);
        }else{
            DefaultTableModel dtm= (DefaultTableModel) jTable1.getModel();
            int[] selectedRows = jTable1.getSelectedRows();
            for(int count=0;count<selectedCount;count++){
                dtm.removeRow(selectedRows[count]);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       new ViewSupplierForm().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       new AddCategoryForm().setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       new ViewCategoryForm().setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

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
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbRatio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JSeparator sepFour10;
    private javax.swing.JSeparator sepFour11;
    private javax.swing.JSeparator sepFour3;
    private javax.swing.JSeparator sepFour4;
    private javax.swing.JSeparator sepFour5;
    private javax.swing.JSeparator sepFour7;
    private javax.swing.JSeparator sepFour8;
    private javax.swing.JSeparator sepFour9;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtGrandPrice;
    private javax.swing.JTextField txtItemId;
    private javax.swing.JTextField txtName1;
    private javax.swing.JTextField txtName6;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProfit;
    private javax.swing.JTextField txtQty;
    // End of variables declaration//GEN-END:variables
}
