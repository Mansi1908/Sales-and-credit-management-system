/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package restaurentsystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class DeleteLabour extends javax.swing.JFrame {
    private DltLabour d;
    private int dltName;
    
   
    public DeleteLabour() {
        initComponents();
        performFileRelatedTask();
    }
    private void performFileRelatedTask()
    {
        d = new DltLabour();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dltButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        dlttext = new javax.swing.JTextField();
        view = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 255));

        dltButton.setText("Delete");
        dltButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dltButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        text.setEditable(false);
        text.setColumns(20);
        text.setRows(5);
        jScrollPane1.setViewportView(text);

        jLabel1.setText("Which Labour ID  want to Delete");

        view.setText("View");
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addComponent(dlttext, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(view)
                .addGap(32, 32, 32)
                .addComponent(dltButton)
                .addGap(18, 18, 18)
                .addComponent(backButton)
                .addGap(57, 57, 57))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(dlttext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(view)
                    .addComponent(dltButton)
                    .addComponent(backButton))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dltButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dltButtonActionPerformed
        // TODO add your handling code here:
        
        dltName=Integer.parseInt(dlttext.getText());
        d.setId(dltName);// calling the methods of another class
        d.deleteItem();
        dlttext.setText("");
        JOptionPane.showMessageDialog(this, "Labour has been Deleted");

    }//GEN-LAST:event_dltButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        LabourManagement lm = new LabourManagement();
        lm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
        // TODO add your handling code here:
            d = new DltLabour();
            text.setText(d.getFullNames().toString());
        

    }//GEN-LAST:event_viewActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DeleteLabour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeleteLabour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeleteLabour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeleteLabour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeleteLabour().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton dltButton;
    private javax.swing.JTextField dlttext;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea text;
    private javax.swing.JButton view;
    // End of variables declaration//GEN-END:variables
}
class DltLabour {
    
    private Scanner scan;
    private String name;
    private int ID;
    private float salary;
    private StringBuilder fullnames;
    private String itemName [];
    
    public DltLabour()
    {
        fullnames = new StringBuilder();
       // openFile();
        readFile();
        
        //closeFile();
        
    }
    
    public StringBuilder getFullNames()
    {
        return fullnames;
    }
    
    
    public void setName(String name) {
        this.name = name;
    }
    public void setId(int ID)
    {
    	this.ID=ID;
    }
    
    public String getName() {
        return name;
    }
    public int getId()
    {
    	return ID;
    }
    private void readFile()
    {
    
    	try{  
    		Class.forName("com.mysql.jdbc.Driver");  
        	java.sql.Connection con=DriverManager.getConnection(  
        	"jdbc:mysql://localhost:3306/foodcourtdb","root","Mansi@123");
        	PreparedStatement stmt=con.prepareStatement("select * from Labor_info");  
        	ResultSet rs=stmt.executeQuery();  
        	while(rs.next()){
        		ID = rs.getInt(1);
        		//i= rs.getInt(2);
        		name = rs.getString(2);
          		//j= rs.getFloat(3);
        		salary = rs.getFloat(3);
        		 fullnames.append(ID + "\t" + name + "\t" + salary +"\n");
        	//fullnames.append(rs.getString(1)+" \t"+rs.getInt(2)+" \t"+rs.getInt(3));  
        	}  
        		con.close();
    	}
    	catch(Exception e){ System.out.println(e);}  }  
    
   
    
    public  void deleteItem(){
        
           	int dlt=getId();
        try{  
    		Class.forName("com.mysql.jdbc.Driver");  
        	java.sql.Connection con=DriverManager.getConnection(  
        	"jdbc:mysql://localhost:3306/foodcourtdb","root","Mansi@123");
        	PreparedStatement stmt=con.prepareStatement("delete from Labor_info where ID=?");  
        	stmt.setInt(1,dlt);
        	int i = stmt.executeUpdate();
        	System.out.println(i+ " item deleted");
        	con.close();
    	}
    	catch(Exception e){ System.out.println(e);}  
    }  
}
