/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuickEats;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
      type.setText("Beverage");
        searches();
       S_Item1.setVisible(false);
       S_Item2.setVisible(false);
       S_Item3.setVisible(false);
       S_Item4.setVisible(false);
       S_Item5.setVisible(false);
       S_Item6.setVisible(false);
       S_Item7.setVisible(false);
       S_Item8.setVisible(false);
       S_Item9.setVisible(false);
       S_Item10.setVisible(false);
       S_Item11.setVisible(false);
       S_Item12.setVisible(false);
       FINAL_AMOUNT();
      
            list.setVisible(false);
                DisplayTable.setVisible(false);
                product();
                data();
                 display();
                 int size = DisplayTable.getRowCount();
                if(size < 1){
                       DATE.setText("           NO ORDERS YET1       " );
            ORDER_NUMB.setText("");
                }if(size >= 1){
                    order();  
                }
            
           
                 
    }
   
    Connection con;
    PreparedStatement pst;
    ResultSet rs ;

  
      /*public void tellers(){
      String r="r";
         if(TellerID.getText().endsWith(r)){
                OrderB.setVisible(false);Cancel.setVisible(false);
                logout.setVisible(false);
            }else if(TellerID.getText().endsWith("-1")){
             OrderB.setEnabled(true);Cancel.setEnabled(true);
             logout.setVisible(true);
         }
    }*/
    public  void order(){
          Date todaysDate = new Date();
            DateFormat df6 = new SimpleDateFormat("E, MMM dd yyyy ,    HH:mm");

            String datee = df6.format(todaysDate);
             Random rand = new Random();

             int ORDER = rand.nextInt(1000);
             String s=String.valueOf(ORDER);
             
             
            DATE.setText("DATE        : "+datee);
            ORDER_NUMB.setText("ORDER NO. : "+s);
    }
    private void searches(){
        if(sid.isSelected()){
                SEARCH_BAR.setEnabled(true);
                 SEARCH_BUTTON.setEnabled(true);
                 scode.setSelected(false);
            }
             if(scode.isSelected()){
                SEARCH_BAR.setEnabled(true);
                 SEARCH_BUTTON.setEnabled(true);
                 sid.setSelected(false);
            }
    }        

    private void data(){
         String typo = type.getText();
          String typ = type.getText();
            
            String ok = typ;
      try{
        con = DriverManager.getConnection("jdbc:mysql://localhost/quickeats?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");

         pst = con.prepareStatement("SELECT *  FROM `items` WHERE TYPEofProd = '"+ok+"' ORDER BY ID" );
            rs = pst.executeQuery();
            
            if(rs.next()){
                        
                          
                           AMOUNT.setText(rs.getString("PRICE"));
                    CODE.setText(rs.getString("ID"));
                    NAME.setText(rs.getString("item").toUpperCase());
                    
                    rs.next();
                    
                    AMOUNT1.setText(rs.getString("PRICE"));
                    CODE1.setText(rs.getString("ID"));
                    NAME1.setText(rs.getString("item").toUpperCase());
                    rs.next();
                    
                     AMOUNT2.setText(rs.getString("PRICE"));
                    CODE2.setText(rs.getString("ID"));
                    NAME2.setText(rs.getString("item").toUpperCase());
                    rs.next();
                    
                     AMOUNT3.setText(rs.getString("PRICE"));
                    CODE3.setText(rs.getString("ID"));
                    NAME3.setText(rs.getString("item").toUpperCase());
                    rs.next();
                    
                     AMOUNT4.setText(rs.getString("PRICE"));
                    CODE4.setText(rs.getString("ID"));
                    NAME4.setText(rs.getString("item").toUpperCase());
                    rs.next();
                    
                     AMOUNT5.setText(rs.getString("PRICE"));
                    CODE5.setText(rs.getString("ID"));
                    NAME5.setText(rs.getString("item").toUpperCase());
                    rs.next();
                    
                     AMOUNT6.setText(rs.getString("PRICE"));
                    CODE6.setText(rs.getString("ID"));
                    NAME6.setText(rs.getString("item").toUpperCase());
                    rs.next();
                    
                     AMOUNT7.setText(rs.getString("PRICE"));
                    CODE7.setText(rs.getString("ID"));
                    NAME7.setText(rs.getString("item").toUpperCase());
                    rs.next();
                    
                     AMOUNT8.setText(rs.getString("PRICE"));
                    CODE8.setText(rs.getString("ID").toUpperCase());
                    NAME8.setText(rs.getString("item").toUpperCase());
                    rs.next();
                    
                     AMOUNT9.setText(rs.getString("PRICE"));
                    CODE9.setText(rs.getString("ID").toUpperCase());
                    NAME9.setText(rs.getString("item").toUpperCase());
                    rs.next();
                    
                     AMOUNT10.setText(rs.getString("PRICE"));
                    CODE10.setText(rs.getString("ID").toUpperCase());
                    NAME10.setText(rs.getString("item").toUpperCase());
                    rs.last(); 
                    
                     AMOUNT11.setText(rs.getString("PRICE"));
                    CODE11.setText(rs.getString("ID").toUpperCase());
                    NAME11.setText(rs.getString("item").toUpperCase());
                     }
           
      }
      catch (SQLException ex) {
            
            //JOptionPane.showMessageDialog(null,ex);
        }
      
  }
    private void display(){
        
       DefaultTableModel table = (DefaultTableModel) DisplayTable.getModel();
        
        try {
            
             con = DriverManager.getConnection("jdbc:mysql://localhost/quickeats?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
            
            pst = con.prepareStatement("SELECT ITEM,CODE,PRICE FROM `customerlist` ORDER BY ID   ");
            
            rs = pst.executeQuery();
             DisplayTable.setVisible(true);
                  list.setVisible(true);
            this.DisplayTable.setModel(DbUtils.resultSetToTableModel(this.rs));
           
           
            
            
            
            
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null,ex);
        }
        
        
        
    }
    private void FINAL_AMOUNT(){
        try {
          
            
             con = DriverManager.getConnection("jdbc:mysql://localhost/quickeats?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
            String typ = type.getText();
            
            String ok = typ;
            
            
              pst = con.prepareStatement("SELECT SUM(PRICE) AS SUMPRICE FROM `customerlist` ORDER BY ID " );
            
            
           rs = pst.executeQuery();
         
            if(rs.next()){
               
         //num.setText(rs.getString("SUMPRICE").trim());
         //JOptionPane.showMessageDialog(null,rs.getString("SUMPRICE") );
         
         //String  number = num.getText().toString();
         
        // double value = Integer.parseInt(number);
                if (rs.getString("SUMPRICE") == null) {
                    FINAL_AM.setText("K 0.0");
                    display();
                }else{
         FINAL_AM.setText("K " + rs.getString("SUMPRICE"));
         
            }
            }
         
             }catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null,ex );
            
           
        }
        }
    private void product(){
        try {
          
            
             con = DriverManager.getConnection("jdbc:mysql://localhost/quickeats?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
            String typ = type.getText();
            
            String ok = typ;
            
            
              pst = con.prepareStatement("SELECT COUNT(*) FROM `items` WHERE TYPEofProd = '"+ok+"' ORDER BY ID " );
            
            
           rs = pst.executeQuery();
         
            if(rs.next()){
               
         num.setText(rs.getString("count(*)"));
         
         String  number = num.getText();
         
         int value = Integer.parseInt(number);
            
     
           
                if (value == 1) {
                    
                     // con = DriverManager.getConnection("jdbc:mysql://localhost/quickeats?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
                    
                  
                    
                     
                        
                     
                     
                     
                    
                     
                     
                    S_Item1.setVisible(true);
                    
                    
                      
                    
                           
                }if (value == 2) {
                     
                
                          
                    S_Item1.setVisible(true);
                    
                  
                     
                     
                    S_Item2.setVisible(true);
                    
                 
                    
                } if (value == 3) {
                     
                    S_Item1.setVisible(true);
                    S_Item2.setVisible(true);
                    S_Item3.setVisible(true);
                  
                    
                } if (value == 4) {
                     
                    S_Item1.setVisible(true);
                    S_Item2.setVisible(true);
                    S_Item3.setVisible(true);
                    S_Item4.setVisible(true);
                    
                } if (value == 5) {
                     
                    S_Item1.setVisible(true);
                    S_Item2.setVisible(true);
                    S_Item3.setVisible(true);
                    S_Item4.setVisible(true);
                    S_Item5.setVisible(true);
                    S_Item6.setVisible(true);
                    
                } if (value == 6) {
                     
                     S_Item1.setVisible(true);
                    S_Item2.setVisible(true);
                    S_Item3.setVisible(true);
                    S_Item4.setVisible(true);
                    S_Item5.setVisible(true);
                    S_Item6.setVisible(true);
                    
                } if (value == 7) {
                     
                    S_Item1.setVisible(true);
                    S_Item2.setVisible(true);
                    S_Item3.setVisible(true);
                    S_Item4.setVisible(true);
                    S_Item5.setVisible(true);
                    S_Item6.setVisible(true);
                    S_Item7.setVisible(true);
                    
                } if (value == 8) {
                     
                    S_Item1.setVisible(true);
                    S_Item2.setVisible(true);
                    S_Item3.setVisible(true);
                    S_Item4.setVisible(true);
                    S_Item5.setVisible(true);
                    S_Item6.setVisible(true);
                     S_Item7.setVisible(true);
                    S_Item8.setVisible(true);
                    
                } if (value == 9) {
                     
                      S_Item1.setVisible(true);
                    S_Item2.setVisible(true);
                    S_Item3.setVisible(true);
                    S_Item4.setVisible(true);
                    S_Item5.setVisible(true);
                    S_Item6.setVisible(true);
                     S_Item7.setVisible(true);
                    S_Item8.setVisible(true);
                    S_Item9.setVisible(true);
                    
                    
                } if (value == 10) {
                     
                      S_Item1.setVisible(true);
                    S_Item2.setVisible(true);
                    S_Item3.setVisible(true);
                    S_Item4.setVisible(true);
                    S_Item5.setVisible(true);
                    S_Item6.setVisible(true);
                     S_Item7.setVisible(true);
                    S_Item8.setVisible(true);
                    S_Item9.setVisible(true);
                    S_Item10.setVisible(true);
                    
                } if (value == 11) {
                     
                       S_Item1.setVisible(true);
                    S_Item2.setVisible(true);
                    S_Item3.setVisible(true);
                    S_Item4.setVisible(true);
                    S_Item5.setVisible(true);
                    S_Item6.setVisible(true);
                     S_Item7.setVisible(true);
                    S_Item8.setVisible(true);
                    S_Item9.setVisible(true);
                    S_Item10.setVisible(true);
                    S_Item11.setVisible(true);
                    
                } if (value == 12) {
                     
                     S_Item1.setVisible(true);
                    S_Item2.setVisible(true);
                    S_Item3.setVisible(true);
                    S_Item4.setVisible(true);
                    S_Item5.setVisible(true);
                    S_Item6.setVisible(true);
                     S_Item7.setVisible(true);
                    S_Item8.setVisible(true);
                    S_Item9.setVisible(true);
                    S_Item10.setVisible(true);
                    S_Item11.setVisible(true);
                    S_Item12.setVisible(true);
                    
                } 
                
                
                
                
                
                
                
                
                
                else {
                    alert.setText("No Item in Stock" );
                }
         
         
         
        
        
        
                 
                  
              
                
                
            }
         
            
            
            else{
               
                
            }
             
            
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null,ex );
            
           
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        TellerName = new javax.swing.JLabel();
        TellerID = new javax.swing.JLabel();
        TellerName1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        logout = new javax.swing.JLabel();
        TellerName2 = new javax.swing.JLabel();
        productList = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        S_Item1 = new javax.swing.JPanel();
        CODE = new javax.swing.JLabel();
        NAME = new javax.swing.JLabel();
        AMOUNT = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        S_Item2 = new javax.swing.JPanel();
        CODE1 = new javax.swing.JLabel();
        NAME1 = new javax.swing.JLabel();
        AMOUNT1 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        S_Item3 = new javax.swing.JPanel();
        CODE2 = new javax.swing.JLabel();
        NAME2 = new javax.swing.JLabel();
        AMOUNT2 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        S_Item4 = new javax.swing.JPanel();
        CODE3 = new javax.swing.JLabel();
        NAME3 = new javax.swing.JLabel();
        AMOUNT3 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        S_Item5 = new javax.swing.JPanel();
        CODE4 = new javax.swing.JLabel();
        NAME4 = new javax.swing.JLabel();
        AMOUNT4 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        S_Item6 = new javax.swing.JPanel();
        CODE5 = new javax.swing.JLabel();
        NAME5 = new javax.swing.JLabel();
        AMOUNT5 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        S_Item7 = new javax.swing.JPanel();
        CODE6 = new javax.swing.JLabel();
        NAME6 = new javax.swing.JLabel();
        AMOUNT6 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        S_Item8 = new javax.swing.JPanel();
        CODE7 = new javax.swing.JLabel();
        NAME7 = new javax.swing.JLabel();
        AMOUNT7 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        S_Item9 = new javax.swing.JPanel();
        CODE8 = new javax.swing.JLabel();
        NAME8 = new javax.swing.JLabel();
        AMOUNT8 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        S_Item10 = new javax.swing.JPanel();
        CODE9 = new javax.swing.JLabel();
        NAME9 = new javax.swing.JLabel();
        AMOUNT9 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        S_Item11 = new javax.swing.JPanel();
        CODE10 = new javax.swing.JLabel();
        NAME10 = new javax.swing.JLabel();
        AMOUNT10 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        S_Item12 = new javax.swing.JPanel();
        CODE11 = new javax.swing.JLabel();
        NAME11 = new javax.swing.JLabel();
        AMOUNT11 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        alert = new javax.swing.JLabel();
        cartContainer = new javax.swing.JPanel();
        OrderB = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        list1 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        FINAL_AM = new javax.swing.JLabel();
        list = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DisplayTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        num = new javax.swing.JLabel();
        type = new javax.swing.JLabel();
        DATE = new javax.swing.JLabel();
        ORDER_NUMB = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        BeverageBtn = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        SnackBtn = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        TakeBtn = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        Item12 = new javax.swing.JPanel();
        item11 = new javax.swing.JLabel();
        code11 = new javax.swing.JLabel();
        price11 = new javax.swing.JLabel();
        closelist11 = new javax.swing.JLabel();
        Item13 = new javax.swing.JPanel();
        item12 = new javax.swing.JLabel();
        code12 = new javax.swing.JLabel();
        price12 = new javax.swing.JLabel();
        closelist12 = new javax.swing.JLabel();
        Item14 = new javax.swing.JPanel();
        item13 = new javax.swing.JLabel();
        code13 = new javax.swing.JLabel();
        price13 = new javax.swing.JLabel();
        closelist13 = new javax.swing.JLabel();
        Item15 = new javax.swing.JPanel();
        item14 = new javax.swing.JLabel();
        code14 = new javax.swing.JLabel();
        price14 = new javax.swing.JLabel();
        closelist14 = new javax.swing.JLabel();
        Item16 = new javax.swing.JPanel();
        item15 = new javax.swing.JLabel();
        code15 = new javax.swing.JLabel();
        price15 = new javax.swing.JLabel();
        closelist15 = new javax.swing.JLabel();
        Item17 = new javax.swing.JPanel();
        item16 = new javax.swing.JLabel();
        code16 = new javax.swing.JLabel();
        price16 = new javax.swing.JLabel();
        closelist16 = new javax.swing.JLabel();
        Item18 = new javax.swing.JPanel();
        item17 = new javax.swing.JLabel();
        code17 = new javax.swing.JLabel();
        price17 = new javax.swing.JLabel();
        closelist17 = new javax.swing.JLabel();
        Item19 = new javax.swing.JPanel();
        item18 = new javax.swing.JLabel();
        code18 = new javax.swing.JLabel();
        price18 = new javax.swing.JLabel();
        closelist18 = new javax.swing.JLabel();
        Item20 = new javax.swing.JPanel();
        item19 = new javax.swing.JLabel();
        code19 = new javax.swing.JLabel();
        price19 = new javax.swing.JLabel();
        closelist19 = new javax.swing.JLabel();
        Item21 = new javax.swing.JPanel();
        item20 = new javax.swing.JLabel();
        code20 = new javax.swing.JLabel();
        price20 = new javax.swing.JLabel();
        closelist20 = new javax.swing.JLabel();
        Item22 = new javax.swing.JPanel();
        item21 = new javax.swing.JLabel();
        code21 = new javax.swing.JLabel();
        price21 = new javax.swing.JLabel();
        closelist21 = new javax.swing.JLabel();
        scode = new javax.swing.JRadioButton();
        sid = new javax.swing.JRadioButton();
        SEARCH_BUTTON = new javax.swing.JButton();
        SEARCH_BAR = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(55, 12, 12));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(37, 43, 48));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QuickEats/user_1.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 110, 120));

        TellerName.setBackground(new java.awt.Color(191, 214, 229));
        TellerName.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        TellerName.setForeground(new java.awt.Color(192, 211, 221));
        TellerName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TellerName.setText("Telller");
        jPanel2.add(TellerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 170, -1));

        TellerID.setBackground(new java.awt.Color(191, 214, 229));
        TellerID.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        TellerID.setForeground(new java.awt.Color(255, 0, 0));
        TellerID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TellerID.setText("Teller");
        jPanel2.add(TellerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 190, 30));

        TellerName1.setBackground(new java.awt.Color(191, 214, 229));
        TellerName1.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        TellerName1.setForeground(new java.awt.Color(192, 211, 221));
        TellerName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TellerName1.setText("Restaurant ");
        jPanel2.add(TellerName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 640, 170, -1));

        jPanel3.setBackground(new java.awt.Color(255, 0, 0));

        logout.setBackground(new java.awt.Color(191, 214, 229));
        logout.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logout.setText("LOGOUT");
        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logout, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, 60));

        TellerName2.setBackground(new java.awt.Color(191, 214, 229));
        TellerName2.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        TellerName2.setForeground(new java.awt.Color(192, 211, 221));
        TellerName2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TellerName2.setText("QuickEats FastFoods");
        jPanel2.add(TellerName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 190, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 210, 690));

        productList.setLayout(new java.awt.CardLayout());

        jScrollPane2.setHorizontalScrollBar(null);

        jPanel7.setBackground(new java.awt.Color(251, 242, 242));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        S_Item1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CODE.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        CODE.setForeground(new java.awt.Color(247, 247, 247));
        CODE.setText("149");
        S_Item1.add(CODE, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 90, 30));

        NAME.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        NAME.setForeground(new java.awt.Color(255, 255, 255));
        NAME.setText("CHICKEN ");
        S_Item1.add(NAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 160, 160, 30));

        AMOUNT.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        AMOUNT.setForeground(new java.awt.Color(173, 13, 13));
        AMOUNT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AMOUNT.setText("K 45.99");
        S_Item1.add(AMOUNT, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 190, 30));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QuickEats/bans.png"))); // NOI18N
        jLabel19.setText("jLabel19");
        S_Item1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 190));

        jPanel14.setBackground(new java.awt.Color(186, 0, 0));
        jPanel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel14MouseClicked(evt);
            }
        });
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(244, 244, 244));
        jLabel8.setText("Add to Cart");
        jPanel14.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 6, -1, 20));

        S_Item1.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 230, 30));

        jPanel7.add(S_Item1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 230, 250));

        S_Item2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CODE1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        CODE1.setForeground(new java.awt.Color(247, 247, 247));
        CODE1.setText("149");
        S_Item2.add(CODE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 90, 30));

        NAME1.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        NAME1.setForeground(new java.awt.Color(255, 255, 255));
        NAME1.setText("CHICKEN ");
        S_Item2.add(NAME1, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 160, 160, 30));

        AMOUNT1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        AMOUNT1.setForeground(new java.awt.Color(173, 13, 13));
        AMOUNT1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AMOUNT1.setText("K 45.99");
        S_Item2.add(AMOUNT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 190, 30));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QuickEats/bans.png"))); // NOI18N
        jLabel23.setText("jLabel19");
        S_Item2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 190));

        jPanel15.setBackground(new java.awt.Color(186, 0, 0));
        jPanel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel15MouseClicked(evt);
            }
        });
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(244, 244, 244));
        jLabel9.setText("Add to Cart");
        jPanel15.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 6, -1, 20));

        S_Item2.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 230, 30));

        jPanel7.add(S_Item2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 230, 250));

        S_Item3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CODE2.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        CODE2.setForeground(new java.awt.Color(247, 247, 247));
        CODE2.setText("149");
        S_Item3.add(CODE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 90, 30));

        NAME2.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        NAME2.setForeground(new java.awt.Color(255, 255, 255));
        NAME2.setText("CHICKEN ");
        S_Item3.add(NAME2, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 160, 150, 30));

        AMOUNT2.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        AMOUNT2.setForeground(new java.awt.Color(173, 13, 13));
        AMOUNT2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AMOUNT2.setText("K 45.99");
        S_Item3.add(AMOUNT2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 190, 30));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QuickEats/bans.png"))); // NOI18N
        jLabel24.setText("jLabel19");
        S_Item3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 190));

        jPanel16.setBackground(new java.awt.Color(186, 0, 0));
        jPanel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel16MouseClicked(evt);
            }
        });
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(244, 244, 244));
        jLabel10.setText("Add to Cart");
        jPanel16.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 6, -1, 20));

        S_Item3.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 230, 30));

        jPanel7.add(S_Item3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 230, 250));

        S_Item4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CODE3.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        CODE3.setForeground(new java.awt.Color(247, 247, 247));
        CODE3.setText("149");
        S_Item4.add(CODE3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 90, 30));

        NAME3.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        NAME3.setForeground(new java.awt.Color(255, 255, 255));
        NAME3.setText("CHICKEN ");
        S_Item4.add(NAME3, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 160, 160, 30));

        AMOUNT3.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        AMOUNT3.setForeground(new java.awt.Color(173, 13, 13));
        AMOUNT3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AMOUNT3.setText("K 45.99");
        S_Item4.add(AMOUNT3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 190, 30));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QuickEats/bans.png"))); // NOI18N
        jLabel25.setText("jLabel19");
        S_Item4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 190));

        jPanel17.setBackground(new java.awt.Color(186, 0, 0));
        jPanel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel17MouseClicked(evt);
            }
        });
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(244, 244, 244));
        jLabel26.setText("Add to Cart");
        jPanel17.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 6, -1, 20));

        S_Item4.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 230, 30));

        jPanel7.add(S_Item4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 230, 250));

        S_Item5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CODE4.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        CODE4.setForeground(new java.awt.Color(247, 247, 247));
        CODE4.setText("149");
        S_Item5.add(CODE4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 90, 30));

        NAME4.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        NAME4.setForeground(new java.awt.Color(255, 255, 255));
        NAME4.setText("CHICKEN ");
        S_Item5.add(NAME4, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 160, 150, 30));

        AMOUNT4.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        AMOUNT4.setForeground(new java.awt.Color(173, 13, 13));
        AMOUNT4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AMOUNT4.setText("K 45.99");
        S_Item5.add(AMOUNT4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 190, 30));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QuickEats/bans.png"))); // NOI18N
        jLabel27.setText("jLabel19");
        S_Item5.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 190));

        jPanel19.setBackground(new java.awt.Color(186, 0, 0));
        jPanel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel19MouseClicked(evt);
            }
        });
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(244, 244, 244));
        jLabel28.setText("Add to Cart");
        jPanel19.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 6, -1, 20));

        S_Item5.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 230, 30));

        jPanel7.add(S_Item5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 230, 250));

        S_Item6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CODE5.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        CODE5.setForeground(new java.awt.Color(247, 247, 247));
        CODE5.setText("149");
        S_Item6.add(CODE5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 90, 30));

        NAME5.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        NAME5.setForeground(new java.awt.Color(255, 255, 255));
        NAME5.setText("CHICKEN ");
        S_Item6.add(NAME5, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 160, 160, 30));

        AMOUNT5.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        AMOUNT5.setForeground(new java.awt.Color(173, 13, 13));
        AMOUNT5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AMOUNT5.setText("K 45.99");
        S_Item6.add(AMOUNT5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 190, 30));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QuickEats/bans.png"))); // NOI18N
        jLabel29.setText("jLabel19");
        S_Item6.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 190));

        jPanel27.setBackground(new java.awt.Color(186, 0, 0));
        jPanel27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel27MouseClicked(evt);
            }
        });
        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(244, 244, 244));
        jLabel30.setText("Add to Cart");
        jPanel27.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 6, -1, 20));

        S_Item6.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 230, 30));

        jPanel7.add(S_Item6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, 230, 250));

        S_Item7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CODE6.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        CODE6.setForeground(new java.awt.Color(247, 247, 247));
        CODE6.setText("149");
        S_Item7.add(CODE6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 90, 30));

        NAME6.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        NAME6.setForeground(new java.awt.Color(255, 255, 255));
        NAME6.setText("CHICKEN ");
        S_Item7.add(NAME6, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 160, 150, 30));

        AMOUNT6.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        AMOUNT6.setForeground(new java.awt.Color(173, 13, 13));
        AMOUNT6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AMOUNT6.setText("K 45.99");
        S_Item7.add(AMOUNT6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 190, 30));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QuickEats/bans.png"))); // NOI18N
        jLabel31.setText("jLabel19");
        S_Item7.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 190));

        jPanel28.setBackground(new java.awt.Color(186, 0, 0));
        jPanel28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel28MouseClicked(evt);
            }
        });
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(244, 244, 244));
        jLabel32.setText("Add to Cart");
        jPanel28.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 6, -1, 20));

        S_Item7.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 230, 30));

        jPanel7.add(S_Item7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 230, 250));

        S_Item8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CODE7.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        CODE7.setForeground(new java.awt.Color(247, 247, 247));
        CODE7.setText("149");
        S_Item8.add(CODE7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 90, 30));

        NAME7.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        NAME7.setForeground(new java.awt.Color(255, 255, 255));
        NAME7.setText("CHICKEN ");
        S_Item8.add(NAME7, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 160, 150, 30));

        AMOUNT7.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        AMOUNT7.setForeground(new java.awt.Color(173, 13, 13));
        AMOUNT7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AMOUNT7.setText("K 45.99");
        S_Item8.add(AMOUNT7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 190, 30));

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QuickEats/bans.png"))); // NOI18N
        jLabel33.setText("jLabel19");
        S_Item8.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 190));

        jPanel29.setBackground(new java.awt.Color(186, 0, 0));
        jPanel29.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel29MouseClicked(evt);
            }
        });
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(244, 244, 244));
        jLabel34.setText("Add to Cart");
        jPanel29.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 6, -1, 20));

        S_Item8.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 230, 30));

        jPanel7.add(S_Item8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 530, 230, 250));

        S_Item9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CODE8.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        CODE8.setForeground(new java.awt.Color(247, 247, 247));
        CODE8.setText("149");
        S_Item9.add(CODE8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 90, 30));

        NAME8.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        NAME8.setForeground(new java.awt.Color(255, 255, 255));
        NAME8.setText("CHICKEN ");
        S_Item9.add(NAME8, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 160, 150, 30));

        AMOUNT8.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        AMOUNT8.setForeground(new java.awt.Color(173, 13, 13));
        AMOUNT8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AMOUNT8.setText("K 45.99");
        S_Item9.add(AMOUNT8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 190, 30));

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QuickEats/bans.png"))); // NOI18N
        jLabel35.setText("jLabel19");
        S_Item9.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 190));

        jPanel30.setBackground(new java.awt.Color(186, 0, 0));
        jPanel30.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel30MouseClicked(evt);
            }
        });
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(244, 244, 244));
        jLabel36.setText("Add to List");
        jPanel30.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 6, -1, 20));

        S_Item9.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 230, 30));

        jPanel7.add(S_Item9, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 530, 230, 250));

        S_Item10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CODE9.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        CODE9.setForeground(new java.awt.Color(247, 247, 247));
        CODE9.setText("149");
        S_Item10.add(CODE9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 90, 30));

        NAME9.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        NAME9.setForeground(new java.awt.Color(255, 255, 255));
        NAME9.setText("CHICKEN ");
        S_Item10.add(NAME9, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 160, -1, 30));

        AMOUNT9.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        AMOUNT9.setForeground(new java.awt.Color(173, 13, 13));
        AMOUNT9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AMOUNT9.setText("K 45.99");
        S_Item10.add(AMOUNT9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 190, 30));

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QuickEats/bans.png"))); // NOI18N
        jLabel37.setText("jLabel19");
        S_Item10.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 190));

        jPanel31.setBackground(new java.awt.Color(186, 0, 0));
        jPanel31.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel31MouseClicked(evt);
            }
        });
        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(244, 244, 244));
        jLabel38.setText("Add to Cart");
        jPanel31.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 6, -1, 20));

        S_Item10.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 230, 30));

        jPanel7.add(S_Item10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 790, 230, 250));

        S_Item11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CODE10.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        CODE10.setForeground(new java.awt.Color(247, 247, 247));
        CODE10.setText("149");
        S_Item11.add(CODE10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 90, 30));

        NAME10.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        NAME10.setForeground(new java.awt.Color(255, 255, 255));
        NAME10.setText("CHICKEN ");
        S_Item11.add(NAME10, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 160, -1, 30));

        AMOUNT10.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        AMOUNT10.setForeground(new java.awt.Color(173, 13, 13));
        AMOUNT10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AMOUNT10.setText("K 45.99");
        S_Item11.add(AMOUNT10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 190, 30));

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QuickEats/bans.png"))); // NOI18N
        jLabel39.setText("jLabel19");
        S_Item11.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 190));

        jPanel32.setBackground(new java.awt.Color(186, 0, 0));
        jPanel32.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel32MouseClicked(evt);
            }
        });
        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(244, 244, 244));
        jLabel40.setText("Add to Cart");
        jPanel32.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 6, -1, 20));

        S_Item11.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 230, 30));

        jPanel7.add(S_Item11, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 790, 230, 250));

        S_Item12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CODE11.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        CODE11.setForeground(new java.awt.Color(247, 247, 247));
        CODE11.setText("149");
        S_Item12.add(CODE11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 90, 30));

        NAME11.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        NAME11.setForeground(new java.awt.Color(255, 255, 255));
        NAME11.setText("CHICKEN ");
        S_Item12.add(NAME11, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 160, -1, 30));

        AMOUNT11.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        AMOUNT11.setForeground(new java.awt.Color(173, 13, 13));
        AMOUNT11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AMOUNT11.setText("K 45.99");
        S_Item12.add(AMOUNT11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 190, 30));

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QuickEats/bans.png"))); // NOI18N
        jLabel41.setText("jLabel19");
        S_Item12.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 190));

        jPanel33.setBackground(new java.awt.Color(186, 0, 0));
        jPanel33.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel33MouseClicked(evt);
            }
        });
        jPanel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(244, 244, 244));
        jLabel42.setText("Add to Cart");
        jPanel33.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 6, -1, 20));

        S_Item12.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 230, 30));

        jPanel7.add(S_Item12, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 790, 230, 250));

        alert.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        alert.setForeground(new java.awt.Color(175, 10, 10));
        alert.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel7.add(alert, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 127, 540, 160));

        jScrollPane2.setViewportView(jPanel7);

        productList.add(jScrollPane2, "card5");

        getContentPane().add(productList, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 740, 740));

        cartContainer.setBackground(new java.awt.Color(73, 76, 79));
        cartContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OrderB.setBackground(new java.awt.Color(16, 171, 93));
        OrderB.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        OrderB.setForeground(new java.awt.Color(255, 255, 255));
        OrderB.setText("Order / Print ");
        OrderB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrderBMouseClicked(evt);
            }
        });
        OrderB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderBActionPerformed(evt);
            }
        });
        cartContainer.add(OrderB, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 650, 130, 38));

        Cancel.setBackground(new java.awt.Color(229, 10, 10));
        Cancel.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        Cancel.setForeground(new java.awt.Color(255, 255, 255));
        Cancel.setText("Cancel Order");
        Cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelMouseClicked(evt);
            }
        });
        cartContainer.add(Cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 650, 143, 38));

        list1.setBackground(new java.awt.Color(102, 102, 102));
        list1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel43.setBackground(new java.awt.Color(239, 238, 238));
        jLabel43.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 248, 250));
        jLabel43.setText("TOTAL AMOUNT (VAT INCL)");
        list1.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 9, 166, 30));

        FINAL_AM.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        FINAL_AM.setForeground(new java.awt.Color(238, 238, 238));
        FINAL_AM.setText("K");
        list1.add(FINAL_AM, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 11, 110, 30));

        cartContainer.add(list1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 360, 50));

        list.setBackground(new java.awt.Color(102, 102, 102));

        jLabel20.setBackground(new java.awt.Color(239, 238, 238));
        jLabel20.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 248, 250));
        jLabel20.setText("ITEM ");

        jLabel21.setBackground(new java.awt.Color(239, 238, 238));
        jLabel21.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 248, 250));
        jLabel21.setText("CODE ");

        jLabel22.setBackground(new java.awt.Color(239, 238, 238));
        jLabel22.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 248, 250));
        jLabel22.setText("PRICE ");

        javax.swing.GroupLayout listLayout = new javax.swing.GroupLayout(list);
        list.setLayout(listLayout);
        listLayout.setHorizontalGroup(
            listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        listLayout.setVerticalGroup(
            listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22))
                .addContainerGap())
        );

        cartContainer.add(list, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 360, 40));

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N

        DisplayTable.setAutoCreateRowSorter(true);
        DisplayTable.setBackground(new java.awt.Color(255, 51, 51));
        DisplayTable.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        DisplayTable.setForeground(new java.awt.Color(255, 255, 255));
        DisplayTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        DisplayTable.setAutoscrolls(false);
        DisplayTable.setDragEnabled(true);
        DisplayTable.setGridColor(new java.awt.Color(75, 1, 1));
        DisplayTable.setRowHeight(40);
        DisplayTable.setRowMargin(0);
        DisplayTable.setSelectionBackground(new java.awt.Color(153, 153, 153));
        DisplayTable.setSelectionForeground(new java.awt.Color(248, 248, 248));
        DisplayTable.setShowVerticalLines(false);
        DisplayTable.setTableHeader(null);
        jScrollPane1.setViewportView(DisplayTable);

        cartContainer.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 360, 420));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Clear cart");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        cartContainer.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, 70, -1));

        num.setForeground(new java.awt.Color(73, 76, 79));
        num.setText("jLabel1");
        cartContainer.add(num, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        type.setForeground(new java.awt.Color(73, 76, 79));
        type.setText("jLabel1");
        cartContainer.add(type, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        DATE.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        DATE.setForeground(new java.awt.Color(204, 204, 204));
        DATE.setText("DATE");
        cartContainer.add(DATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 290, 20));

        ORDER_NUMB.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        ORDER_NUMB.setForeground(new java.awt.Color(204, 204, 204));
        ORDER_NUMB.setText("ORDER_NUMB");
        cartContainer.add(ORDER_NUMB, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 240, 20));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QuickEats/Untitled-2.png"))); // NOI18N
        cartContainer.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 230, -1));

        getContentPane().add(cartContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 90, 390, 710));

        jPanel26.setBackground(new java.awt.Color(37, 43, 48));
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BeverageBtn.setBackground(new java.awt.Color(249, 17, 38));
        BeverageBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BeverageBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BeverageBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BeverageBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BeverageBtnMouseExited(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(239, 238, 238));
        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 248, 250));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("FOODS");

        javax.swing.GroupLayout BeverageBtnLayout = new javax.swing.GroupLayout(BeverageBtn);
        BeverageBtn.setLayout(BeverageBtnLayout);
        BeverageBtnLayout.setHorizontalGroup(
            BeverageBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BeverageBtnLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        BeverageBtnLayout.setVerticalGroup(
            BeverageBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BeverageBtnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        jPanel26.add(BeverageBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 250, 40));

        SnackBtn.setBackground(new java.awt.Color(249, 17, 38));
        SnackBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SnackBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SnackBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SnackBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SnackBtnMouseExited(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(239, 238, 238));
        jLabel11.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 248, 250));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("BEVERAGES");

        javax.swing.GroupLayout SnackBtnLayout = new javax.swing.GroupLayout(SnackBtn);
        SnackBtn.setLayout(SnackBtnLayout);
        SnackBtnLayout.setHorizontalGroup(
            SnackBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SnackBtnLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SnackBtnLayout.setVerticalGroup(
            SnackBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SnackBtnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addContainerGap())
        );

        jPanel26.add(SnackBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 250, 40));

        TakeBtn.setBackground(new java.awt.Color(249, 17, 38));
        TakeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TakeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TakeBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TakeBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TakeBtnMouseExited(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(239, 238, 238));
        jLabel12.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 248, 250));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("OTHERS");

        javax.swing.GroupLayout TakeBtnLayout = new javax.swing.GroupLayout(TakeBtn);
        TakeBtn.setLayout(TakeBtnLayout);
        TakeBtnLayout.setHorizontalGroup(
            TakeBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TakeBtnLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        TakeBtnLayout.setVerticalGroup(
            TakeBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TakeBtnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addContainerGap())
        );

        jPanel26.add(TakeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 220, 40));

        getContentPane().add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 740, 50));

        jPanel18.setBackground(new java.awt.Color(0, 0, 0));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Item12.setBackground(new java.awt.Color(204, 204, 204));

        item11.setBackground(new java.awt.Color(243, 243, 243));
        item11.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        item11.setForeground(new java.awt.Color(244, 244, 244));
        item11.setText("Item");

        code11.setBackground(new java.awt.Color(243, 243, 243));
        code11.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        code11.setForeground(new java.awt.Color(244, 244, 244));
        code11.setText("Code");

        price11.setBackground(new java.awt.Color(243, 243, 243));
        price11.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        price11.setForeground(new java.awt.Color(244, 244, 244));
        price11.setText("Price");

        closelist11.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        closelist11.setText("x");

        javax.swing.GroupLayout Item12Layout = new javax.swing.GroupLayout(Item12);
        Item12.setLayout(Item12Layout);
        Item12Layout.setHorizontalGroup(
            Item12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Item12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(item11, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(code11, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(price11, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(closelist11, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        Item12Layout.setVerticalGroup(
            Item12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Item12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Item12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(item11)
                    .addComponent(code11)
                    .addComponent(price11)
                    .addComponent(closelist11))
                .addContainerGap())
        );

        jPanel18.add(Item12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 290, -1));

        Item13.setBackground(new java.awt.Color(204, 204, 204));

        item12.setBackground(new java.awt.Color(243, 243, 243));
        item12.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        item12.setForeground(new java.awt.Color(244, 244, 244));
        item12.setText("Item");

        code12.setBackground(new java.awt.Color(243, 243, 243));
        code12.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        code12.setForeground(new java.awt.Color(244, 244, 244));
        code12.setText("Code");

        price12.setBackground(new java.awt.Color(243, 243, 243));
        price12.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        price12.setForeground(new java.awt.Color(244, 244, 244));
        price12.setText("Price");

        closelist12.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        closelist12.setText("x");

        javax.swing.GroupLayout Item13Layout = new javax.swing.GroupLayout(Item13);
        Item13.setLayout(Item13Layout);
        Item13Layout.setHorizontalGroup(
            Item13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Item13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(item12, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(code12, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(price12, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(closelist12, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        Item13Layout.setVerticalGroup(
            Item13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Item13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Item13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(item12)
                    .addComponent(code12)
                    .addComponent(price12)
                    .addComponent(closelist12))
                .addContainerGap())
        );

        jPanel18.add(Item13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 290, -1));

        Item14.setBackground(new java.awt.Color(204, 204, 204));

        item13.setBackground(new java.awt.Color(243, 243, 243));
        item13.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        item13.setForeground(new java.awt.Color(244, 244, 244));
        item13.setText("Item");

        code13.setBackground(new java.awt.Color(243, 243, 243));
        code13.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        code13.setForeground(new java.awt.Color(244, 244, 244));
        code13.setText("Code");

        price13.setBackground(new java.awt.Color(243, 243, 243));
        price13.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        price13.setForeground(new java.awt.Color(244, 244, 244));
        price13.setText("Price");

        closelist13.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        closelist13.setText("x");

        javax.swing.GroupLayout Item14Layout = new javax.swing.GroupLayout(Item14);
        Item14.setLayout(Item14Layout);
        Item14Layout.setHorizontalGroup(
            Item14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Item14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(item13, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(code13, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(price13, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(closelist13, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        Item14Layout.setVerticalGroup(
            Item14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Item14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Item14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(item13)
                    .addComponent(code13)
                    .addComponent(price13)
                    .addComponent(closelist13))
                .addContainerGap())
        );

        jPanel18.add(Item14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        Item15.setBackground(new java.awt.Color(204, 204, 204));

        item14.setBackground(new java.awt.Color(243, 243, 243));
        item14.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        item14.setForeground(new java.awt.Color(244, 244, 244));
        item14.setText("Item");

        code14.setBackground(new java.awt.Color(243, 243, 243));
        code14.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        code14.setForeground(new java.awt.Color(244, 244, 244));
        code14.setText("Code");

        price14.setBackground(new java.awt.Color(243, 243, 243));
        price14.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        price14.setForeground(new java.awt.Color(244, 244, 244));
        price14.setText("Price");

        closelist14.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        closelist14.setText("x");

        javax.swing.GroupLayout Item15Layout = new javax.swing.GroupLayout(Item15);
        Item15.setLayout(Item15Layout);
        Item15Layout.setHorizontalGroup(
            Item15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Item15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(item14, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(code14, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(price14, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(closelist14, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        Item15Layout.setVerticalGroup(
            Item15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Item15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Item15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(item14)
                    .addComponent(code14)
                    .addComponent(price14)
                    .addComponent(closelist14))
                .addContainerGap())
        );

        jPanel18.add(Item15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        Item16.setBackground(new java.awt.Color(204, 204, 204));

        item15.setBackground(new java.awt.Color(243, 243, 243));
        item15.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        item15.setForeground(new java.awt.Color(244, 244, 244));
        item15.setText("Item");

        code15.setBackground(new java.awt.Color(243, 243, 243));
        code15.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        code15.setForeground(new java.awt.Color(244, 244, 244));
        code15.setText("Code");

        price15.setBackground(new java.awt.Color(243, 243, 243));
        price15.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        price15.setForeground(new java.awt.Color(244, 244, 244));
        price15.setText("Price");

        closelist15.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        closelist15.setText("x");

        javax.swing.GroupLayout Item16Layout = new javax.swing.GroupLayout(Item16);
        Item16.setLayout(Item16Layout);
        Item16Layout.setHorizontalGroup(
            Item16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Item16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(item15, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(code15, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(price15, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(closelist15, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        Item16Layout.setVerticalGroup(
            Item16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Item16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Item16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(item15)
                    .addComponent(code15)
                    .addComponent(price15)
                    .addComponent(closelist15))
                .addContainerGap())
        );

        jPanel18.add(Item16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 290, -1));

        Item17.setBackground(new java.awt.Color(204, 204, 204));

        item16.setBackground(new java.awt.Color(243, 243, 243));
        item16.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        item16.setForeground(new java.awt.Color(244, 244, 244));
        item16.setText("Item");

        code16.setBackground(new java.awt.Color(243, 243, 243));
        code16.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        code16.setForeground(new java.awt.Color(244, 244, 244));
        code16.setText("Code");

        price16.setBackground(new java.awt.Color(243, 243, 243));
        price16.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        price16.setForeground(new java.awt.Color(244, 244, 244));
        price16.setText("Price");

        closelist16.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        closelist16.setText("x");

        javax.swing.GroupLayout Item17Layout = new javax.swing.GroupLayout(Item17);
        Item17.setLayout(Item17Layout);
        Item17Layout.setHorizontalGroup(
            Item17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Item17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(item16, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(code16, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(price16, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(closelist16, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        Item17Layout.setVerticalGroup(
            Item17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Item17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Item17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(item16)
                    .addComponent(code16)
                    .addComponent(price16)
                    .addComponent(closelist16))
                .addContainerGap())
        );

        jPanel18.add(Item17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 290, -1));

        Item18.setBackground(new java.awt.Color(204, 204, 204));

        item17.setBackground(new java.awt.Color(243, 243, 243));
        item17.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        item17.setForeground(new java.awt.Color(244, 244, 244));
        item17.setText("Item");

        code17.setBackground(new java.awt.Color(243, 243, 243));
        code17.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        code17.setForeground(new java.awt.Color(244, 244, 244));
        code17.setText("Code");

        price17.setBackground(new java.awt.Color(243, 243, 243));
        price17.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        price17.setForeground(new java.awt.Color(244, 244, 244));
        price17.setText("Price");

        closelist17.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        closelist17.setText("x");

        javax.swing.GroupLayout Item18Layout = new javax.swing.GroupLayout(Item18);
        Item18.setLayout(Item18Layout);
        Item18Layout.setHorizontalGroup(
            Item18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Item18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(item17, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(code17, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(price17, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(closelist17, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        Item18Layout.setVerticalGroup(
            Item18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Item18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Item18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(item17)
                    .addComponent(code17)
                    .addComponent(price17)
                    .addComponent(closelist17))
                .addContainerGap())
        );

        jPanel18.add(Item18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 290, -1));

        Item19.setBackground(new java.awt.Color(204, 204, 204));

        item18.setBackground(new java.awt.Color(243, 243, 243));
        item18.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        item18.setForeground(new java.awt.Color(244, 244, 244));
        item18.setText("Item");

        code18.setBackground(new java.awt.Color(243, 243, 243));
        code18.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        code18.setForeground(new java.awt.Color(244, 244, 244));
        code18.setText("Code");

        price18.setBackground(new java.awt.Color(243, 243, 243));
        price18.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        price18.setForeground(new java.awt.Color(244, 244, 244));
        price18.setText("Price");

        closelist18.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        closelist18.setText("x");

        javax.swing.GroupLayout Item19Layout = new javax.swing.GroupLayout(Item19);
        Item19.setLayout(Item19Layout);
        Item19Layout.setHorizontalGroup(
            Item19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Item19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(item18, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(code18, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(price18, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(closelist18, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        Item19Layout.setVerticalGroup(
            Item19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Item19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Item19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(item18)
                    .addComponent(code18)
                    .addComponent(price18)
                    .addComponent(closelist18))
                .addContainerGap())
        );

        jPanel18.add(Item19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 290, -1));

        Item20.setBackground(new java.awt.Color(204, 204, 204));

        item19.setBackground(new java.awt.Color(243, 243, 243));
        item19.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        item19.setForeground(new java.awt.Color(244, 244, 244));
        item19.setText("Item");

        code19.setBackground(new java.awt.Color(243, 243, 243));
        code19.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        code19.setForeground(new java.awt.Color(244, 244, 244));
        code19.setText("Code");

        price19.setBackground(new java.awt.Color(243, 243, 243));
        price19.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        price19.setForeground(new java.awt.Color(244, 244, 244));
        price19.setText("Price");

        closelist19.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        closelist19.setText("x");

        javax.swing.GroupLayout Item20Layout = new javax.swing.GroupLayout(Item20);
        Item20.setLayout(Item20Layout);
        Item20Layout.setHorizontalGroup(
            Item20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Item20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(item19, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(code19, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(price19, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(closelist19, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        Item20Layout.setVerticalGroup(
            Item20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Item20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Item20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(item19)
                    .addComponent(code19)
                    .addComponent(price19)
                    .addComponent(closelist19))
                .addContainerGap())
        );

        jPanel18.add(Item20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 290, -1));

        Item21.setBackground(new java.awt.Color(204, 204, 204));

        item20.setBackground(new java.awt.Color(243, 243, 243));
        item20.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        item20.setForeground(new java.awt.Color(244, 244, 244));
        item20.setText("Item");

        code20.setBackground(new java.awt.Color(243, 243, 243));
        code20.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        code20.setForeground(new java.awt.Color(244, 244, 244));
        code20.setText("Code");

        price20.setBackground(new java.awt.Color(243, 243, 243));
        price20.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        price20.setForeground(new java.awt.Color(244, 244, 244));
        price20.setText("Price");

        closelist20.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        closelist20.setText("x");

        javax.swing.GroupLayout Item21Layout = new javax.swing.GroupLayout(Item21);
        Item21.setLayout(Item21Layout);
        Item21Layout.setHorizontalGroup(
            Item21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Item21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(item20, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(code20, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(price20, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(closelist20, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        Item21Layout.setVerticalGroup(
            Item21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Item21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Item21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(item20)
                    .addComponent(code20)
                    .addComponent(price20)
                    .addComponent(closelist20))
                .addContainerGap())
        );

        jPanel18.add(Item21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 290, -1));

        Item22.setBackground(new java.awt.Color(204, 204, 204));

        item21.setBackground(new java.awt.Color(243, 243, 243));
        item21.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        item21.setForeground(new java.awt.Color(244, 244, 244));
        item21.setText("Item");

        code21.setBackground(new java.awt.Color(243, 243, 243));
        code21.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        code21.setForeground(new java.awt.Color(244, 244, 244));
        code21.setText("Code");

        price21.setBackground(new java.awt.Color(243, 243, 243));
        price21.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        price21.setForeground(new java.awt.Color(244, 244, 244));
        price21.setText("Price");

        closelist21.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        closelist21.setText("x");

        javax.swing.GroupLayout Item22Layout = new javax.swing.GroupLayout(Item22);
        Item22.setLayout(Item22Layout);
        Item22Layout.setHorizontalGroup(
            Item22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Item22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(item21, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(code21, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(price21, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(closelist21, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        Item22Layout.setVerticalGroup(
            Item22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Item22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Item22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(item21)
                    .addComponent(code21)
                    .addComponent(price21)
                    .addComponent(closelist21))
                .addContainerGap())
        );

        jPanel18.add(Item22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 290, -1));

        getContentPane().add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 310, 460));

        scode.setBackground(new java.awt.Color(249, 17, 38));
        scode.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        scode.setForeground(new java.awt.Color(247, 247, 247));
        scode.setText("Scan Product ID");
        scode.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        scode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scodeMouseClicked(evt);
            }
        });
        getContentPane().add(scode, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, 200, 30));

        sid.setBackground(new java.awt.Color(249, 17, 38));
        sid.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        sid.setForeground(new java.awt.Color(247, 247, 247));
        sid.setText("Search Product ID");
        sid.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sidMouseClicked(evt);
            }
        });
        getContentPane().add(sid, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 10, 170, 30));

        SEARCH_BUTTON.setBackground(new java.awt.Color(249, 17, 38));
        SEARCH_BUTTON.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        SEARCH_BUTTON.setForeground(new java.awt.Color(240, 234, 234));
        SEARCH_BUTTON.setText("Search");
        SEARCH_BUTTON.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(137, 9, 21), 2, true));
        SEARCH_BUTTON.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SEARCH_BUTTON.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SEARCH_BUTTONMouseClicked(evt);
            }
        });
        getContentPane().add(SEARCH_BUTTON, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 40, 120, 40));

        SEARCH_BAR.setBackground(new java.awt.Color(137, 9, 21));
        SEARCH_BAR.setFont(new java.awt.Font("Tw Cen MT", 0, 36)); // NOI18N
        SEARCH_BAR.setForeground(new java.awt.Color(225, 204, 204));
        SEARCH_BAR.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SEARCH_BAR.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(137, 9, 21), 3, true));
        SEARCH_BAR.setCaretColor(new java.awt.Color(221, 184, 184));
        getContentPane().add(SEARCH_BAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 40, 370, 40));

        jPanel1.setBackground(new java.awt.Color(249, 17, 38));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QuickEats/Untitled-2_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 110));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
  
    private void BeverageBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BeverageBtnMouseEntered
        BeverageBtn.setBackground(new Color(186,0,0));
    }//GEN-LAST:event_BeverageBtnMouseEntered

    private void BeverageBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BeverageBtnMouseExited
      BeverageBtn.setBackground(new Color(255,0,0));
    }//GEN-LAST:event_BeverageBtnMouseExited

    private void BeverageBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BeverageBtnMouseClicked
       BeverageBtn.setBackground(new Color(136,0,0));
       
       type.setText("Snack");
       product(); 
       data();
                 
                 
    }//GEN-LAST:event_BeverageBtnMouseClicked

    private void SnackBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SnackBtnMouseClicked
         SnackBtn.setBackground(new Color(136,0,0));
         
         type.setText("Beverage");
         product();
         data();
                 
                 
         
         
    }//GEN-LAST:event_SnackBtnMouseClicked

    private void SnackBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SnackBtnMouseEntered
         SnackBtn.setBackground(new Color(186,0,0));
    }//GEN-LAST:event_SnackBtnMouseEntered

    private void SnackBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SnackBtnMouseExited
        SnackBtn.setBackground(new Color(255,0,0));
    }//GEN-LAST:event_SnackBtnMouseExited

    private void TakeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TakeBtnMouseClicked
         TakeBtn.setBackground(new Color(136,0,0));
    }//GEN-LAST:event_TakeBtnMouseClicked

    private void TakeBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TakeBtnMouseEntered
         TakeBtn.setBackground(new Color(186,0,0));
    }//GEN-LAST:event_TakeBtnMouseEntered

    private void TakeBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TakeBtnMouseExited
       TakeBtn.setBackground(new Color(255,0,0));
    }//GEN-LAST:event_TakeBtnMouseExited

    private void jPanel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseClicked
          Random rand = new Random();

            int id = rand.nextInt(1000);
            String name = NAME.getText().toUpperCase();

            String numb  = AMOUNT.getText().toUpperCase();
            
            double amount = Double.parseDouble(numb);

            String CODENUM  = CODE.getText().toUpperCase();

            //SimpleDateFormat date = new SimpleDateFormat("YY-MM-dd");

            //  String datee = date.format(DOBAREA.getDate());

            Date todaysDate = new Date();
            DateFormat df6 = new SimpleDateFormat("E, MMM dd yyyy , HH:mm");

            String datee = df6.format(todaysDate);

            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/quickeats?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");

                pst = con.prepareStatement("insert into `customerlist` values(?,?,?,?)");

                pst.setInt(1,id);

                pst.setString(2, name);

                pst.setDouble(3, amount );

                pst.setString(4, CODENUM );

                // pst.setString(5, datee);

                //  pst.setBinaryStream(11, fin, (int) files.length());

                pst.executeUpdate();
                 display();
                   FINAL_AMOUNT();
            String d =DATE.getText();
            
            if(d == ""){
                 order(); 
            }
                    
                

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(null, ex);
            }
    }//GEN-LAST:event_jPanel14MouseClicked

    private void jPanel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseClicked
      Random rand = new Random();

            int id = rand.nextInt(1000);
            String name = NAME1.getText().toUpperCase();

             String numb  = AMOUNT1.getText().toUpperCase();
            
            double amount = Double.parseDouble(numb);

            String CODENUM  = CODE1.getText().toUpperCase();

            //SimpleDateFormat date = new SimpleDateFormat("YY-MM-dd");

            //  String datee = date.format(DOBAREA.getDate());

            Date todaysDate = new Date();
            DateFormat df6 = new SimpleDateFormat("E, MMM dd yyyy , HH:mm");

            String datee = df6.format(todaysDate);

            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/quickeats?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");

                pst = con.prepareStatement("insert into `customerlist` values(?,?,?,?)");

                pst.setInt(1,id);

                pst.setString(2, name);

                pst.setDouble(3, amount );

                pst.setString(4, CODENUM );

                // pst.setString(5, datee);

                //  pst.setBinaryStream(11, fin, (int) files.length());

                pst.executeUpdate();
                 display();
                 FINAL_AMOUNT();
                 String d =DATE.getText();
            
            if(d == ""){
                 order(); 
            }
            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(null, ex);
            }
    }//GEN-LAST:event_jPanel15MouseClicked

    private void jPanel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseClicked
       Random rand = new Random();

            int id = rand.nextInt(1000);
            String name = NAME2.getText().toUpperCase();

              String numb  = AMOUNT2.getText().toUpperCase();
            
          double amount = Double.parseDouble(numb);

            String CODENUM  = CODE2.getText().toUpperCase();

            //SimpleDateFormat date = new SimpleDateFormat("YY-MM-dd");

            //  String datee = date.format(DOBAREA.getDate());

            Date todaysDate = new Date();
            DateFormat df6 = new SimpleDateFormat("E, MMM dd yyyy , HH:mm");

            String datee = df6.format(todaysDate);

            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/quickeats?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");

                pst = con.prepareStatement("insert into `customerlist` values(?,?,?,?)");

                pst.setInt(1,id);

                pst.setString(2, name);

                pst.setDouble(3, amount );

                pst.setString(4, CODENUM );

                // pst.setString(5, datee);

                //  pst.setBinaryStream(11, fin, (int) files.length());

                pst.executeUpdate();
                 display();
                 FINAL_AMOUNT();
                 String d =DATE.getText();
            
            if(d == ""){
                 order(); 
            }

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(null, ex);
            }
    }//GEN-LAST:event_jPanel16MouseClicked

    private void jPanel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseClicked
       Random rand = new Random();

            int id = rand.nextInt(1000);
            String name = NAME3.getText().toUpperCase();

            String numb  = AMOUNT3.getText().toUpperCase();
            
           double amount = Double.parseDouble(numb);

            String CODENUM  = CODE3.getText().toUpperCase();

            //SimpleDateFormat date = new SimpleDateFormat("YY-MM-dd");

            //  String datee = date.format(DOBAREA.getDate());

            Date todaysDate = new Date();
            DateFormat df6 = new SimpleDateFormat("E, MMM dd yyyy , HH:mm");

            String datee = df6.format(todaysDate);

            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/quickeats?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");

                pst = con.prepareStatement("insert into `customerlist` values(?,?,?,?)");

                pst.setInt(1,id);

                pst.setString(2, name);

                pst.setDouble(3, amount );

                pst.setString(4, CODENUM );

                // pst.setString(5, datee);

                //  pst.setBinaryStream(11, fin, (int) files.length());

                pst.executeUpdate();
                 display();
                 FINAL_AMOUNT();
                 String d =DATE.getText();
            
            if(d == ""){
                 order(); 
            }
            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(null, ex);
            }
    }//GEN-LAST:event_jPanel17MouseClicked

    private void jPanel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MouseClicked
        Random rand = new Random();

            int id = rand.nextInt(1000);
            String name = NAME4.getText().toUpperCase();

             String numb  = AMOUNT4.getText().toUpperCase();
            
         double amount = Double.parseDouble(numb);

            String CODENUM  = CODE4.getText().toUpperCase();

            //SimpleDateFormat date = new SimpleDateFormat("YY-MM-dd");

            //  String datee = date.format(DOBAREA.getDate());

            Date todaysDate = new Date();
            DateFormat df6 = new SimpleDateFormat("E, MMM dd yyyy , HH:mm");

            String datee = df6.format(todaysDate);

            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/quickeats?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");

                pst = con.prepareStatement("insert into `customerlist` values(?,?,?,?)");

                pst.setInt(1,id);

                pst.setString(2, name);

                pst.setDouble(3, amount );

                pst.setString(4, CODENUM );

                // pst.setString(5, datee);

                //  pst.setBinaryStream(11, fin, (int) files.length());

                pst.executeUpdate();
                 display();
                 FINAL_AMOUNT();
                 String d =DATE.getText();
            
            if(d == ""){
                 order(); 
            }

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(null, ex);
            }
    }//GEN-LAST:event_jPanel19MouseClicked

    private void jPanel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel27MouseClicked
        Random rand = new Random();

            int id = rand.nextInt(1000);
            String name = NAME5.getText().toUpperCase();

              String numb  = AMOUNT5.getText().toUpperCase();
            
            double amount = Double.parseDouble(numb);

            String CODENUM  = CODE5.getText().toUpperCase();

            //SimpleDateFormat date = new SimpleDateFormat("YY-MM-dd");

            //  String datee = date.format(DOBAREA.getDate());

            Date todaysDate = new Date();
            DateFormat df6 = new SimpleDateFormat("E, MMM dd yyyy , HH:mm");

            String datee = df6.format(todaysDate);

            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/quickeats?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");

                pst = con.prepareStatement("insert into `customerlist` values(?,?,?,?)");

                pst.setInt(1,id);

                pst.setString(2, name);

                pst.setDouble(3, amount );

                pst.setString(4, CODENUM );

                // pst.setString(5, datee);

                //  pst.setBinaryStream(11, fin, (int) files.length());

                pst.executeUpdate();
                 display();
                 FINAL_AMOUNT();
                 String d =DATE.getText();
            
            if(d == ""){
                 order(); 
            }

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(null, ex);
            }
    }//GEN-LAST:event_jPanel27MouseClicked

    private void jPanel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel28MouseClicked
        Random rand = new Random();

            int id = rand.nextInt(1000);
            String name = NAME6.getText().toUpperCase();

             String numb  = AMOUNT6.getText().toUpperCase();
            
           double amount = Double.parseDouble(numb);

            String CODENUM  = CODE6.getText().toUpperCase();

            //SimpleDateFormat date = new SimpleDateFormat("YY-MM-dd");

            //  String datee = date.format(DOBAREA.getDate());

            Date todaysDate = new Date();
            DateFormat df6 = new SimpleDateFormat("E, MMM dd yyyy , HH:mm");

            String datee = df6.format(todaysDate);

            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/quickeats?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");

                pst = con.prepareStatement("insert into `customerlist` values(?,?,?,?)");

                pst.setInt(1,id);

                pst.setString(2, name);

                pst.setDouble(3, amount );

                pst.setString(4, CODENUM );

                // pst.setString(5, datee);

                //  pst.setBinaryStream(11, fin, (int) files.length());

                pst.executeUpdate();
                 display();
                 FINAL_AMOUNT();
                 String d =DATE.getText();
            
            if(d == ""){
                 order(); 
            }

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(null, ex);
            }
    }//GEN-LAST:event_jPanel28MouseClicked

    private void jPanel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel29MouseClicked
       Random rand = new Random();

            int id = rand.nextInt(1000);
            String name = NAME7.getText().toUpperCase();

             String numb  = AMOUNT7.getText().toUpperCase();
            
           double amount = Double.parseDouble(numb);

            String CODENUM  = CODE7.getText().toUpperCase();

            //SimpleDateFormat date = new SimpleDateFormat("YY-MM-dd");

            //  String datee = date.format(DOBAREA.getDate());

            Date todaysDate = new Date();
            DateFormat df6 = new SimpleDateFormat("E, MMM dd yyyy , HH:mm");

            String datee = df6.format(todaysDate);

            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/quickeats?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");

                pst = con.prepareStatement("insert into `customerlist` values(?,?,?,?)");

                pst.setInt(1,id);

                pst.setString(2, name);

                pst.setDouble(3, amount );

                pst.setString(4, CODENUM );

                // pst.setString(5, datee);

                //  pst.setBinaryStream(11, fin, (int) files.length());

                pst.executeUpdate();
                 display();
                 FINAL_AMOUNT();
                                    String d =DATE.getText();
            
            if(d == ""){
                 order(); 
            }
            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(null, ex);
            }
    }//GEN-LAST:event_jPanel29MouseClicked

    private void jPanel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel30MouseClicked
        Random rand = new Random();

            int id = rand.nextInt(1000);
            String name = NAME8.getText().toUpperCase();

             String numb  = AMOUNT8.getText().toUpperCase();
            
           double amount = Double.parseDouble(numb);

            String CODENUM  = CODE8.getText().toUpperCase();

            //SimpleDateFormat date = new SimpleDateFormat("YY-MM-dd");

            //  String datee = date.format(DOBAREA.getDate());

            Date todaysDate = new Date();
            DateFormat df6 = new SimpleDateFormat("E, MMM dd yyyy , HH:mm");

            String datee = df6.format(todaysDate);

            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/quickeats?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");

                pst = con.prepareStatement("insert into `customerlist` values(?,?,?,?)");

                pst.setInt(1,id);

                pst.setString(2, name);

                pst.setDouble(3, amount );

                pst.setString(4, CODENUM );

                // pst.setString(5, datee);

                //  pst.setBinaryStream(11, fin, (int) files.length());

                pst.executeUpdate();
                 display();
                 FINAL_AMOUNT();
                 String d =DATE.getText();
            
            if(d == ""){
                 order(); 
            }

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(null, ex);
            }
    }//GEN-LAST:event_jPanel30MouseClicked

    private void jPanel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel31MouseClicked
       Random rand = new Random();

            int id = rand.nextInt(1000);
            String name = NAME9.getText().toUpperCase();

           String numb  = AMOUNT9.getText().toUpperCase();
            
           double amount = Double.parseDouble(numb);

            String CODENUM  = CODE9.getText().toUpperCase();

            //SimpleDateFormat date = new SimpleDateFormat("YY-MM-dd");

            //  String datee = date.format(DOBAREA.getDate());

            Date todaysDate = new Date();
            DateFormat df6 = new SimpleDateFormat("E, MMM dd yyyy , HH:mm");

            String datee = df6.format(todaysDate);

            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/quickeats?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");

                pst = con.prepareStatement("insert into `customerlist` values(?,?,?,?)");

                pst.setInt(1,id);

                pst.setString(2, name);

                pst.setDouble(3, amount );

                pst.setString(4, CODENUM );

                // pst.setString(5, datee);

                //  pst.setBinaryStream(11, fin, (int) files.length());

                pst.executeUpdate();
                 display();
               FINAL_AMOUNT();
                 String d =DATE.getText();
            
            if(d == ""){
                 order(); 
            }

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(null, ex);
            }
    }//GEN-LAST:event_jPanel31MouseClicked

    private void jPanel32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel32MouseClicked
        Random rand = new Random();

            int id = rand.nextInt(1000);
            String name = NAME10.getText().toUpperCase();

             String numb  = AMOUNT10.getText().toUpperCase();
            
           double amount = Double.parseDouble(numb);

            String CODENUM  = CODE10.getText().toUpperCase();

            //SimpleDateFormat date = new SimpleDateFormat("YY-MM-dd");

            //  String datee = date.format(DOBAREA.getDate());

            Date todaysDate = new Date();
            DateFormat df6 = new SimpleDateFormat("E, MMM dd yyyy , HH:mm");

            String datee = df6.format(todaysDate);

            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/quickeats?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");

                pst = con.prepareStatement("insert into `customerlist` values(?,?,?,?)");

                pst.setInt(1,id);

                pst.setString(2, name);

                pst.setDouble(3, amount );

                pst.setString(4, CODENUM );

                // pst.setString(5, datee);

                //  pst.setBinaryStream(11, fin, (int) files.length());

                pst.executeUpdate();
                 display();
                 FINAL_AMOUNT();
                 String d =DATE.getText();
            
            if(d == ""){
                 order(); 
            }

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(null, ex);
            }
    }//GEN-LAST:event_jPanel32MouseClicked

    private void jPanel33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel33MouseClicked
       Random rand = new Random();

            int id = rand.nextInt(1000);
            String name = NAME11.getText().toUpperCase();

             String numb  = AMOUNT11.getText().toUpperCase();
            
           double amount = Double.parseDouble(numb);

            String CODENUM  = CODE11.getText().toUpperCase();

            //SimpleDateFormat date = new SimpleDateFormat("YY-MM-dd");

            //  String datee = date.format(DOBAREA.getDate());

            Date todaysDate = new Date();
            DateFormat df6 = new SimpleDateFormat("E, MMM dd yyyy , HH:mm");

            String datee = df6.format(todaysDate);

            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/quickeats?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");

                pst = con.prepareStatement("insert into `customerlist` values(?,?,?,?)");

                pst.setInt(1,id);

                pst.setString(2, name);

                pst.setDouble(3, amount );

                pst.setString(4, CODENUM );

                // pst.setString(5, datee);

                //  pst.setBinaryStream(11, fin, (int) files.length());

                pst.executeUpdate();
                 display();
                FINAL_AMOUNT();
                 String d =DATE.getText();
            
            if(d == ""){
                 order(); 
            }

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(null, ex);
            }
    }//GEN-LAST:event_jPanel33MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
       display();
        
        try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/quickeats?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");

                pst = con.prepareStatement("DELETE FROM `customerlist` WHERE 1");
                pst.executeUpdate();display();
                 FINAL_AMOUNT();
                 String d =DATE.getText();
            
            if(!d.isEmpty()){
                    DATE.setText("" );
            ORDER_NUMB.setText("");
            }
                
                 
          
                 
               
                
                 } catch (SQLException ex) {

                JOptionPane.showMessageDialog(null, ex);
            }
        display();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void OrderBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderBMouseClicked
      
    // TODO add your handling code here:
    Toolkit tkp = cartContainer.getToolkit();
    PrintJob pjp = tkp.getPrintJob(this, null, null);
    Graphics g = pjp.getGraphics();
    cartContainer.print(g);
    g.dispose();
    pjp.end();

    }//GEN-LAST:event_OrderBMouseClicked

    private void SEARCH_BUTTONMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SEARCH_BUTTONMouseClicked
      
        
         Random rand = new Random();
        
        try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/quickeats?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");

                 pst = con.prepareStatement("SELECT ITEM, PRICE, ID  FROM `items` WHERE ID = "+SEARCH_BAR.getText()+" " );
            rs = pst.executeQuery();
            
            if(rs.first())
                {
                    int id = rand.nextInt(1000);
                String CODER = null;
                CODER = rs.getString("ID");
                String amounts = null;
                amounts = rs.getString("PRICE");
                 double amount = Double.parseDouble(amounts);
                String name = null;
                name = rs.getString("ITEM");
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                  con = DriverManager.getConnection("jdbc:mysql://localhost/quickeats?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");

                pst = con.prepareStatement("insert into `customerlist` values(?,?,?,?)");

                pst.setInt(1,id);

                pst.setString(2, name);

                pst.setDouble(3, amount );

                pst.setString(4, CODER );

                // pst.setString(5, datee);

                //  pst.setBinaryStream(11, fin, (int) files.length());

                pst.executeUpdate();
                 display();
                   FINAL_AMOUNT();
               SEARCH_BAR.setText("");
               
                }         
            

                // pst.setString(5, datee);

                //  pst.setBinaryStream(11, fin, (int) files.length());

              
                else
                {
                    JOptionPane.showMessageDialog(null, "Product not in Stock");
                }               

           
              

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(null, ex);
            }
    }//GEN-LAST:event_SEARCH_BUTTONMouseClicked

    private void scodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scodeMouseClicked
         SEARCH_BAR.setEnabled(false);
            SEARCH_BUTTON.setVisible(false);
            sid.setSelected(false);
        
        
        if(scode.isSelected()){
            SEARCH_BAR.setEnabled(false);
            SEARCH_BUTTON.setVisible(false);
            sid.setSelected(false);
            
        }
    }//GEN-LAST:event_scodeMouseClicked

    private void sidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidMouseClicked
          SEARCH_BAR.setEnabled(true);
            SEARCH_BUTTON.setVisible(true);
            scode.setSelected(false);  
        
        if(sid.isSelected()){
            SEARCH_BAR.setEnabled(true);
            SEARCH_BUTTON.setVisible(true);
            scode.setSelected(false);
            
        }
    }//GEN-LAST:event_sidMouseClicked

    private void CancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelMouseClicked
        DATE.setText("" );
            ORDER_NUMB.setText("");
            
            
             display();
        
        try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/quickeats?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");

                pst = con.prepareStatement("DELETE FROM `customerlist` WHERE 1");
                pst.executeUpdate();display();
                 FINAL_AMOUNT();
                 String d =DATE.getText();
            
            if(!d.isEmpty()){
                    DATE.setText("" );
            ORDER_NUMB.setText("");
            }
                
                 
          
                 
               
                
                 } catch (SQLException ex) {

                JOptionPane.showMessageDialog(null, ex);
            }
        display();
    }//GEN-LAST:event_CancelMouseClicked

    private void OrderBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OrderBActionPerformed

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
      
        TellerID.setText("Teller");
       
    }//GEN-LAST:event_logoutMouseClicked

    
  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
       
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Home().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AMOUNT;
    private javax.swing.JLabel AMOUNT1;
    private javax.swing.JLabel AMOUNT10;
    private javax.swing.JLabel AMOUNT11;
    private javax.swing.JLabel AMOUNT2;
    private javax.swing.JLabel AMOUNT3;
    private javax.swing.JLabel AMOUNT4;
    private javax.swing.JLabel AMOUNT5;
    private javax.swing.JLabel AMOUNT6;
    private javax.swing.JLabel AMOUNT7;
    private javax.swing.JLabel AMOUNT8;
    private javax.swing.JLabel AMOUNT9;
    private javax.swing.JPanel BeverageBtn;
    private javax.swing.JLabel CODE;
    private javax.swing.JLabel CODE1;
    private javax.swing.JLabel CODE10;
    private javax.swing.JLabel CODE11;
    private javax.swing.JLabel CODE2;
    private javax.swing.JLabel CODE3;
    private javax.swing.JLabel CODE4;
    private javax.swing.JLabel CODE5;
    private javax.swing.JLabel CODE6;
    private javax.swing.JLabel CODE7;
    private javax.swing.JLabel CODE8;
    private javax.swing.JLabel CODE9;
    private javax.swing.JButton Cancel;
    private javax.swing.JLabel DATE;
    private javax.swing.JTable DisplayTable;
    private javax.swing.JLabel FINAL_AM;
    private javax.swing.JPanel Item12;
    private javax.swing.JPanel Item13;
    private javax.swing.JPanel Item14;
    private javax.swing.JPanel Item15;
    private javax.swing.JPanel Item16;
    private javax.swing.JPanel Item17;
    private javax.swing.JPanel Item18;
    private javax.swing.JPanel Item19;
    private javax.swing.JPanel Item20;
    private javax.swing.JPanel Item21;
    private javax.swing.JPanel Item22;
    private javax.swing.JLabel NAME;
    private javax.swing.JLabel NAME1;
    private javax.swing.JLabel NAME10;
    private javax.swing.JLabel NAME11;
    private javax.swing.JLabel NAME2;
    private javax.swing.JLabel NAME3;
    private javax.swing.JLabel NAME4;
    private javax.swing.JLabel NAME5;
    private javax.swing.JLabel NAME6;
    private javax.swing.JLabel NAME7;
    private javax.swing.JLabel NAME8;
    private javax.swing.JLabel NAME9;
    private javax.swing.JLabel ORDER_NUMB;
    private javax.swing.JButton OrderB;
    private javax.swing.JTextField SEARCH_BAR;
    private javax.swing.JButton SEARCH_BUTTON;
    private javax.swing.JPanel S_Item1;
    private javax.swing.JPanel S_Item10;
    private javax.swing.JPanel S_Item11;
    private javax.swing.JPanel S_Item12;
    private javax.swing.JPanel S_Item2;
    private javax.swing.JPanel S_Item3;
    private javax.swing.JPanel S_Item4;
    private javax.swing.JPanel S_Item5;
    private javax.swing.JPanel S_Item6;
    private javax.swing.JPanel S_Item7;
    private javax.swing.JPanel S_Item8;
    private javax.swing.JPanel S_Item9;
    public javax.swing.JPanel SnackBtn;
    private javax.swing.JPanel TakeBtn;
    public static javax.swing.JLabel TellerID;
    private javax.swing.JLabel TellerName;
    private javax.swing.JLabel TellerName1;
    private javax.swing.JLabel TellerName2;
    private javax.swing.JLabel alert;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel cartContainer;
    private javax.swing.JLabel closelist11;
    private javax.swing.JLabel closelist12;
    private javax.swing.JLabel closelist13;
    private javax.swing.JLabel closelist14;
    private javax.swing.JLabel closelist15;
    private javax.swing.JLabel closelist16;
    private javax.swing.JLabel closelist17;
    private javax.swing.JLabel closelist18;
    private javax.swing.JLabel closelist19;
    private javax.swing.JLabel closelist20;
    private javax.swing.JLabel closelist21;
    private javax.swing.JLabel code11;
    private javax.swing.JLabel code12;
    private javax.swing.JLabel code13;
    private javax.swing.JLabel code14;
    private javax.swing.JLabel code15;
    private javax.swing.JLabel code16;
    private javax.swing.JLabel code17;
    private javax.swing.JLabel code18;
    private javax.swing.JLabel code19;
    private javax.swing.JLabel code20;
    private javax.swing.JLabel code21;
    private javax.swing.JLabel item11;
    private javax.swing.JLabel item12;
    private javax.swing.JLabel item13;
    private javax.swing.JLabel item14;
    private javax.swing.JLabel item15;
    private javax.swing.JLabel item16;
    private javax.swing.JLabel item17;
    private javax.swing.JLabel item18;
    private javax.swing.JLabel item19;
    private javax.swing.JLabel item20;
    private javax.swing.JLabel item21;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel list;
    private javax.swing.JPanel list1;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel num;
    private javax.swing.JLabel price11;
    private javax.swing.JLabel price12;
    private javax.swing.JLabel price13;
    private javax.swing.JLabel price14;
    private javax.swing.JLabel price15;
    private javax.swing.JLabel price16;
    private javax.swing.JLabel price17;
    private javax.swing.JLabel price18;
    private javax.swing.JLabel price19;
    private javax.swing.JLabel price20;
    private javax.swing.JLabel price21;
    private javax.swing.JPanel productList;
    private javax.swing.JRadioButton scode;
    private javax.swing.JRadioButton sid;
    private javax.swing.JLabel type;
    // End of variables declaration//GEN-END:variables
}
