/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class StudentSales extends javax.swing.JFrame {

    public StudentSales() throws SQLException {
        initComponents();
        Connect();
        sales_load();
        Book();
    }
        Connection con;
        PreparedStatement pst1;
        PreparedStatement pst;
        ResultSet rs;
        ResultSet rs1;
    public void Connect() throws SQLException{
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3307/Bookinventorysystem", "root", "");
        } catch(ClassNotFoundException ex){
            Logger.getLogger(StudentSales.class.getName()).log(Level.SEVERE, null, ex);
        } catch(SQLException ex){
            Logger.getLogger(StudentSales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public void Book() throws SQLException{
        try{
        pst=con.prepareStatement("select * from bookmanage");
         rs=pst.executeQuery();
         txtbname.removeAllItems(); 
         while(rs.next()){
            txtbname.addItem(rs.getString(2));
         }
        
        }catch(SQLException ex){
            Logger.getLogger(StudentSales.class.getName()).log(Level.SEVERE,null, ex);
        }
    }    
    
    public void sales_load(){
        try {
            pst = con.prepareStatement("select * from sales");
            rs=pst.executeQuery();
            ResultSetMetaData rsd=rs.getMetaData();
            int c;
            
            c=rsd.getColumnCount();
            DefaultTableModel d=(DefaultTableModel)jTable1.getModel();
            d.setRowCount(0);
            while(rs.next()){
                Vector v2=new Vector();
                for(int i=1;i<=c;i++){
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("studentid"));
                    v2.add(rs.getString("stname"));
                    v2.add(rs.getString("book"));
                    v2.add(rs.getString("bookpart"));
                }
                d.addRow(v2);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(StudentSales.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtbpart = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtbname = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(224, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 153));
        jLabel1.setText("Student Sales");

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Student ID");

        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("EDIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("CANCEL");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("DELETE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtbpart.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        txtbpart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbpartActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Book Part");

        txtbname.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        txtbname.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtbnameItemStateChanged(evt);
            }
        });
        txtbname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbnameActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Book ");

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Student Name");

        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtbname, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtbpart, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtid)
                            .addComponent(txtname)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addGap(59, 59, 59))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtbname, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(txtbpart, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "Student ID", "Student Name", "Book ", "Bookpart"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addComponent(jLabel1)))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String sid=txtid.getText();
        String sname=txtname.getText();
        String book=txtbname.getSelectedItem().toString();
        String bookpart=txtbpart.getSelectedItem().toString();
        
        try {
            pst=con.prepareStatement("insert into sales( studentid,stname,book,bookpart)values(?,?,?,?)");
            pst.setString(1, sid);
            pst.setString(2, sname);
            pst.setString(3,book);
            pst.setString(4,bookpart);
            
            int k=pst.executeUpdate();
            if(k==1){
                JOptionPane.showMessageDialog(this, "Book Issused");
                txtid.setText("");
                txtname.setText(""); 
                txtbname.setSelectedItem(-1);
                txtbpart.setSelectedIndex(-1);
      
                sales_load();
            } 
            else{ 
                JOptionPane.showMessageDialog(this, "Errorr");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentSales.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
       DefaultTableModel d1 = (DefaultTableModel) jTable1.getModel();
    int selectIndex = jTable1.getSelectedRow(); // Get the selected row index

    // Validate that the selected index is within bounds
    if (selectIndex >= 0 && selectIndex < d1.getRowCount()) {
        try {
            // Retrieve data from the selected row
            int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());
            String sid = txtid.getText();
            String sname = txtname.getText();
            String book = (txtbname.getSelectedItem() != null) ? txtbname.getSelectedItem().toString() : "";
            String bookpart = (txtbpart.getSelectedItem() != null) ? txtbpart.getSelectedItem().toString() : "";

            // Prepare and execute the update statement
            pst = con.prepareStatement("update sales set studentid=?, stname=?, book=?, bookpart=? where id =?");
            pst.setString(1, sid);
            pst.setString(2, sname);
            pst.setString(3, book);
            pst.setString(4, bookpart);
            pst.setInt(5, id);

            int k = pst.executeUpdate(); // Execute the update
            if (k == 1) {
                JOptionPane.showMessageDialog(this, "Sales Updated");
                // Reset fields and reload the sales data
                txtid.setText("");
                txtname.setText("");
                txtbname.setSelectedIndex(-1);
                txtbpart.setSelectedIndex(-1);
                sales_load(); // Reload the data to reflect the update
                jButton1.setEnabled(true); // Re-enable the add button
            } else {
                JOptionPane.showMessageDialog(this, "Error updating sales");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentSales.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException nfe) {
            System.err.println("Error parsing ID: " + nfe.getMessage());
            JOptionPane.showMessageDialog(this, "Error parsing ID. Please check the data.");
        } catch (Exception ex) {
            System.err.println("An error occurred during the update: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "An error occurred. Please try again.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "No row selected or invalid row index");
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
                
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
           DefaultTableModel d1 = (DefaultTableModel) jTable1.getModel();
    int selectIndex = jTable1.getSelectedRow(); // Get the selected row index

    if (selectIndex >= 0 && selectIndex < d1.getRowCount()) { // Validate the selected index
        try {
            // Retrieve the ID from the selected row
            int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString()); 

            // Prepare the delete statement and execute it
            pst = con.prepareStatement("delete from sales where id =?");
            pst.setInt(1, id); // Set the ID for deletion

            int k = pst.executeUpdate(); // Execute the delete
            if (k == 1) { // Check if the deletion was successful
                JOptionPane.showMessageDialog(this, "Record deleted successfully.");
                // Reset selections and reload the data
                txtbname.setSelectedIndex(-1);                                                                                                                                                                                      
                txtbpart.setSelectedIndex(-1);
                txtid.setText("");
                txtname.setText("");
                sales_load(); // Reload the data
                jButton1.setEnabled(true); // Re-enable the add button
            } else {
                JOptionPane.showMessageDialog(this, "Deletion failed. Please try again.");
            }
        } catch (SQLException ex) { // Handle SQL exceptions
            Logger.getLogger(StudentSales.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "SQL error occurred. Please check your connection or data.");
        } catch (NumberFormatException nfe) { // Handle errors in parsing
            System.err.println("Error parsing ID: " + nfe.getMessage());
            JOptionPane.showMessageDialog(this, "Error parsing ID. Please check the data.");
        } catch (Exception ex) { // Handle general exceptions
            System.err.println("An error occurred during deletion: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "An error occurred. Please try again.");
        }
    } else { // No row selected or invalid index
        JOptionPane.showMessageDialog(this, "No row selected or invalid index. Please select a row to delete.");
    } 
         
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
                                         
        DefaultTableModel d1 = (DefaultTableModel) jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();  // Get the selected row index

        // Ensure a row is selected and that it's within bounds
        if (selectIndex == -1 || selectIndex >= d1.getRowCount()) {
            JOptionPane.showMessageDialog(this, "No row selected or out of bounds.");
            return;  // Exit early if there's an error
        }

        // Attempt to retrieve the data from the selected row
        try {
            int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());  // Get the ID
            txtbname.setSelectedItem(d1.getValueAt(selectIndex, 1).toString());  // Set the book name
            txtbpart.setSelectedItem(d1.getValueAt(selectIndex, 2).toString());
    //        txtstatus.setSelectedItem(d1.getValueAt(selectIndex, 3).toString());  // Set the status
            jButton1.setEnabled(false);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "An error occurred: " + ex.getMessage());
        } 
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtbpartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbpartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbpartActionPerformed

    private void txtbnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbnameActionPerformed
    try{
         String book=txtbname.getSelectedItem().toString(); 
         pst1=con.prepareStatement("select * from bookpart where bookname=?");
         pst1.setString(1, book);
         rs1=pst1.executeQuery();
         txtbpart.removeAllItems(); 
         while(rs1.next()){
            txtbpart.addItem(rs1.getString(3));
         }
        
        }catch(SQLException ex){
            Logger.getLogger(StudentSales.class.getName()).log(Level.SEVERE,null, ex);
        }catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Out of bounds access: " + e.getMessage());
        } catch (NumberFormatException nfe) {
            System.err.println("Error parsing ID: " + nfe.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }//GEN-LAST:event_txtbnameActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void txtbnameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtbnameItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtbnameItemStateChanged

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
            java.util.logging.Logger.getLogger(StudentSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new StudentSales().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(StudentSales.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> txtbname;
    private javax.swing.JComboBox<String> txtbpart;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    // End of variables declaration//GEN-END:variables
}
