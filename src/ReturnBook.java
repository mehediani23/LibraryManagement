
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mehedi
 */
public class ReturnBook extends javax.swing.JFrame {
    Connection con;
    ResultSet rs;
    PreparedStatement pst;
    String ad1;
    String ad2;
    public ReturnBook() {
        super("ReturnBook");
        initComponents();
        con=JavaConnect.connectdb();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton3.setText("Return");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "BookDetail", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 102, 102))); // NOI18N

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Student Id:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(85, 85, 85))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Book_ID", "Name", "Category", "Author", "Publisher", "ISBN_NO", "Pages"
            }
        ));
        jTable1.setAutoscrolls(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(446, 446, 446)
                                .addComponent(jButton3)
                                .addGap(28, 28, 28)
                                .addComponent(jButton4)))
                        .addGap(0, 434, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(131, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        setVisible(false);
        Home obj=new Home();
        obj.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       boolean valid= checkvalid(jTextField1.getText());
          if(valid){
           TableModel model1=jTable1.getModel();
           int [] indexes=jTable1.getSelectedRows();
           for(int i=0;i<indexes.length;i++){
           
        Integer result=null; 
        String sql="Insert into NewBook(Book_Id,Name,Category,Author,Publisher,Isbn_no,Pages) Values(?,?,?,?,?,?,?)"; 
          try{
         pst=con.prepareStatement(sql);
          try{
          result=Integer.valueOf(model1.getValueAt(indexes[i], 6).toString());
          }
          catch(Exception e)
          {
            JOptionPane.showMessageDialog(null,"Cant convert String to integer");
          }
          pst.setString(1,model1.getValueAt(indexes[i], 0).toString());
          pst.setString(2,model1.getValueAt(indexes[i], 1).toString());
          pst.setString(3,model1.getValueAt(indexes[i], 2).toString());
          pst.setString(4,model1.getValueAt(indexes[i], 3).toString());
          pst.setString(5,model1.getValueAt(indexes[i], 4).toString());
          pst.setInt(7,result);
          pst.setString(6,model1.getValueAt(indexes[i], 6).toString());
          pst.execute();
          }
          catch(Exception e)
    {
        JOptionPane.showMessageDialog(null,e);
    }
                String sql1="Select student_id,student_name,roll From NewStudent where Student_Id=?";
        try
        {
            pst=con.prepareStatement(sql1);
            pst.setString(1,jTextField1.getText());
            rs=pst.executeQuery();
            if(rs.next())
            {
                ad1=rs.getString(2);
               // jTextField8.setText(ad1);
                 ad2=rs.getString(3);
                //jTextField10.setText(ad2);
                //String ad3=rs.getString(4);
                //jTextField11.setText(ad3);
               // String ad4=rs.getString(5);
                //jTextField12.setText(ad4);
                //String ad5=rs.getString(6);
                //jTextField7.setText(ad5);
                //String ad6=rs.getString(7);
                //jTextField14.setText(ad6);
                //String ad7=rs.getString(8);
                //jTextField15.setText(ad7);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
             DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
              LocalDate localDate = LocalDate.now();
              Calendar cal = Calendar.getInstance();
              String time= new SimpleDateFormat("HH:mm:ss").format(cal.getTime());
               
          String sql3="Insert into returnDetails(Book_Id,Name,Student_Id,Student_Name,Roll,Issuedate,Time_Issued) Values(?,?,?,?,?,?,?)"; 
          try{
         pst=con.prepareStatement(sql3);
          /*try{
          result=Integer.valueOf(jTextField5.getText());
          }
          catch(Exception e)
          {
            JOptionPane.showMessageDialog(null,"Cant convert String to integer");
          }*/
          pst.setString(1,model1.getValueAt(indexes[i], 0).toString());
          pst.setString(2,model1.getValueAt(indexes[i], 1).toString());
          pst.setString(3,jTextField1.getText());
          pst.setString(4,ad1);
          pst.setString(5,ad2);
          //pst.setInt(7,result);
          pst.setString(6,dtf.format(localDate).toString());
          pst.setString(7,time);
          pst.execute();
          }
          catch(Exception e)
                  {
                   JOptionPane.showMessageDialog(null,e);
                  }
          //JOptionPane.showMessageDialog(null,"Book Issued.");
          //obj.Jtable1();*/
          String sql2="Delete From IssuedBook where Book_Id=?";
            try{
            pst=con.prepareStatement(sql2);
            pst.setString(1,model1.getValueAt(indexes[i], 0).toString());
            pst.execute();
              }
              catch(Exception e)
              {
                  JOptionPane.showMessageDialog(null,e);
              }
           }
            JOptionPane.showMessageDialog(null,"Book Issued.");
           // obj1.Jtable1();*/
          }
          else
          {
              JOptionPane.showMessageDialog(null,"Please Try again!! ");
          }
        /* Integer result=null;
        String sql="Insert into NewBook(Book_Id,Name,Category,Author,Publisher,Isbn_no,Pages) Values(?,?,?,?,?,?,?)";
        try{
            pst=con.prepareStatement(sql);
            try{
                result=Integer.valueOf(jTextField5.getText());
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Cant convert String to integer");
            }
            pst.setString(1,jTextField6.getText());
            pst.setString(2,jTextField1.getText());
            pst.setString(3,jTextField13.getText());
            pst.setString(4,jTextField2.getText());
            pst.setString(5,jTextField3.getText());
            pst.setInt(7,result);
            pst.setString(6, jTextField4.getText());
            pst.execute();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        JOptionPane.showMessageDialog(null,"Book Returned.");
        String sql2="Delete From IssuedBook where Book_Id=?";
        try{
            pst=con.prepareStatement(sql2);
            pst.setString(1,jTextField6.getText());
            pst.execute();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        */
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Jtable1();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private void Jtable1() {
        try
        {
            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
            
            String sql="Select * from Issuedbook where Book_Id in(select book_id from issuedetails where student_id=?)";
            pst=con.prepareStatement(sql);
            pst.setString(1,jTextField1.getText());
            rs=pst.executeQuery();
            //tableModel.setRowCount(0);
            tableModel.fireTableDataChanged();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            //tableModel.fireTableDataChanged();
         }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }

    private boolean checkvalid(String text) {
        //To change body of generated methods, choose Tools | Templates.
               boolean a=true;
        //System.out.println("");
        if(text.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please enter Your student id");
            a=false;
            return a;
        }
        else{
         String sql1="Select student_id,student_name,roll From NewStudent where Student_Id=?";
        try
        {
            pst=con.prepareStatement(sql1);
            pst.setString(1,text);
            rs=pst.executeQuery();
            if(rs.next())
            {
                a=true;
            }
            else
            {
               a=false;
                JOptionPane.showMessageDialog(null, "Invalid Student Id.");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return a;
        }
    }

}