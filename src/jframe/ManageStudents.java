/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.DefaultButtonModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Hello
 */
public class ManageStudents extends javax.swing.JFrame {

    /**
     * Creates new form ManageBooks
     */
    public ManageStudents() {
        initComponents();
        setStudentDetailsToTable();
    }
    // for set book information
    
    String studentName,deperment,batch;
    int studentId;
    DefaultTableModel model;   
    
    public void setStudentDetailsToTable(){
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root",""); 
             
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("select * from student_details");
             
             while (rs.next()) {                
                
                 String studentId = rs.getString("student_id");
                 String studentName = rs.getString("name");
                 String deperment =rs.getString("deperment");
                 String batch = rs.getString("batch");
                 
                 Object[] obj = {studentId,studentName,deperment,batch};
                 model = (DefaultTableModel) tbl_studentDetails.getModel();
                 model.addRow(obj);
                 
                 
            }             
             
        } catch (Exception e) {
            e.printStackTrace();
        }
                             
         
    }
    
    
    // to add new student
    public boolean addStudent(){
        
        boolean isAdded = false;
        
        studentId = Integer.parseInt(txt_studentId.getText());
        studentName = txt_studentName.getText();         
        deperment = combo_deperment.getSelectedItem().toString();
        batch = combo_batch.getSelectedItem().toString();
        
        
        try {
            Connection con =DBConnection.getConnection();
            String sql = "insert into student_details values (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1  , studentId);
            pst.setString(2, studentName);
            pst.setString(3, deperment);
            pst.setString(4, batch);
            
            int Rowcount = pst.executeUpdate();
            
            if(Rowcount >0){
                isAdded = true;
            }
            else
            {
                isAdded = false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAdded;
    }
    
    
    // update the student data
    
    
    public boolean updateStudent(){
        
        boolean isUpdated = false;
         
        studentId = Integer.parseInt(txt_studentId.getText());
        studentName = txt_studentName.getText();
        deperment = combo_deperment.getSelectedItem().toString();
        batch = combo_batch.getSelectedItem().toString();
        
        
        try {
            Connection con = DBConnection.getConnection();
            String sql ="update student_details set name = ? ,deperment = ? , batch = ? where student_id= ? ";
            PreparedStatement pst  =  con.prepareStatement(sql);
            
            pst.setString(1, studentName);
            pst.setString(2, deperment);
            pst.setString(3, batch);
            pst.setInt(4, studentId);
            
           int Rowcount = pst.executeUpdate();
           if(Rowcount > 0 )
           {
               isUpdated = true;
           }
            else
           {
               isUpdated = false;
           }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return isUpdated;
        
    }
    
    
    // for delete
  
    
    public boolean deleteStudent(){
        
        boolean isDeleted = false;
        
        studentId = Integer.parseInt(txt_studentId.getText());
         
        try {
            Connection con = DBConnection.getConnection();
            String sql = "delete from student_details where student_id  = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, studentId);
            int RowCount =  pst.executeUpdate();
            
            if(RowCount > 0)
            {
                isDeleted = true;
            }
            else
            {
                isDeleted = false;
                
            }
            
        } catch (Exception e) {
        }
        
        return isDeleted;
        
    }
    
    
//     clear the table 
//    public void clearTable()
//    {
//        DefaultButtonModel model = (DefaultButtonModel) tbl_bookDetails.getModel();
//        model.setRowCount(0);
//        
//    
//    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_studentId = new app.bolivia.swing.JCTextField();
        txt_studentName = new app.bolivia.swing.JCTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        combo_batch = new javax.swing.JComboBox<>();
        combo_deperment = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_studentDetails = new rojeru_san.complementos.RSTableMetro();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon("E:\\Project oop\\back1_89375.png")); // NOI18N
        jLabel8.setText("Back");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 90, 40));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Enter the new Book information");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 270, 30));

        txt_studentId.setPlaceholder("enter id...");
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        jPanel1.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, -1, -1));

        txt_studentName.setPlaceholder("enter name...");
        txt_studentName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentNameFocusLost(evt);
            }
        });
        txt_studentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon("E:\\Project oop\\New folder\\images\\AddNewBookIcons\\icons8_Moleskine_26px.png")); // NOI18N
        jLabel3.setText("Student Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, 30));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon("E:\\Project oop\\New folder\\images\\AddNewBookIcons\\icons8_Contact_26px.png")); // NOI18N
        jLabel4.setText("Select Deperment");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, 30));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon("E:\\Project oop\\position_icon_ 30  30-clip-art.png")); // NOI18N
        jLabel5.setText("Select Batch");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, -1, 30));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon("E:\\Project oop\\New folder\\images\\AddNewBookIcons\\icons8_Contact_26px.png")); // NOI18N
        jLabel6.setText("Student ID");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, 30));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle1.setText("delete");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 710, 150, 40));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle2.setText("Add");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 570, 150, 40));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle3.setText("Update");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 640, 150, 40));

        combo_batch.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        combo_batch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "221", "222", "223", "231" }));
        combo_batch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_batchActionPerformed(evt);
            }
        });
        jPanel1.add(combo_batch, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 480, 200, 40));

        combo_deperment.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        combo_deperment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CSE", "EEE", "BBA", "ENGLISH" }));
        combo_deperment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_depermentActionPerformed(evt);
            }
        });
        jPanel1.add(combo_deperment, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, 200, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 770));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("X");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 20, -1));

        tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Students ID", "Name", "Deperment", "Branch"
            }
        ));
        tbl_studentDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_studentDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_studentDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_studentDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_studentDetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_studentDetails.setRowHeight(40);
        tbl_studentDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_studentDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_studentDetails);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 630, 260));

        jLabel1.setBackground(new java.awt.Color(51, 0, 204));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon("E:\\Project oop\\New folder\\images\\AddNewBookIcons\\icons8_Student_Male_100px.png")); // NOI18N
        jLabel1.setText("Manage Students");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 290, 100));

        jPanel5.setBackground(new java.awt.Color(255, 0, 51));
        jPanel5.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 280, 250, 5));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 880, 770));

        setSize(new java.awt.Dimension(1366, 768));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
        // TODO add your handling code here:

        // foucas lost

    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_studentNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentNameFocusLost

    private void txt_studentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentNameActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        // back botton
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
                
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        // for 'x'
        System.exit(0);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void tbl_studentDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_studentDetailsMouseClicked
        // TODO add your handling code here:
        // full tabel
        
        int rowNo = tbl_studentDetails.getSelectedRow();
        TableModel model = tbl_studentDetails.getModel();
        
        txt_studentId.setText(model.getValueAt(rowNo, 0).toString());
        txt_studentName.setText(model.getValueAt(rowNo, 1).toString());
        combo_deperment.setSelectedItem(model.getValueAt(rowNo, 2).toString());
        combo_batch.setSelectedItem(model.getValueAt(rowNo, 3).toString());
               
     
        
        
        
    }//GEN-LAST:event_tbl_studentDetailsMouseClicked

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        // TODO add your handling code here:
        // add botton
        if (addStudent()== true) {
            JOptionPane.showMessageDialog(this, "Added new Student");     
//            clearTable();
           setStudentDetailsToTable();
        }
        else
        { 
           JOptionPane.showMessageDialog(this, "Addition Failed");  
        }         
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        // TODO add your handling code here:
        // update botton
         if (updateStudent()== true) {
            JOptionPane.showMessageDialog(this, "Student Updated");     
//            clearTable();
           setStudentDetailsToTable();
        }
        else
        {
           JOptionPane.showMessageDialog(this, "Updated Failed");  
        } 
        
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        // TODO add your handling code here:
        // delete botton
        if (deleteStudent()== true) {
            JOptionPane.showMessageDialog(this, "Student Deleted");     
//            clearTable();
           setStudentDetailsToTable();
        }
        else
        {
           JOptionPane.showMessageDialog(this, "Failed to Delete ");  
        } 
        
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void combo_batchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_batchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_batchActionPerformed

    private void combo_depermentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_depermentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_depermentActionPerformed

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
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_batch;
    private javax.swing.JComboBox<String> combo_deperment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojeru_san.complementos.RSTableMetro tbl_studentDetails;
    private app.bolivia.swing.JCTextField txt_studentId;
    private app.bolivia.swing.JCTextField txt_studentName;
    // End of variables declaration//GEN-END:variables
}
