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


public class DeleteItem extends javax.swing.JFrame {
    private DltItem d;// object of DltItem class d
    private String dltName;
    /**
     * Creates new form DeleteItem
     */
    public DeleteItem() {
        initComponents();
        performFileRelatedTask();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        dlttext = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        dltButton = new javax.swing.JButton();
        view = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 255));

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        text.setEditable(false);
        text.setBackground(new java.awt.Color(204, 255, 204));
        text.setColumns(20);
        text.setRows(5);
        jScrollPane1.setViewportView(text);

        jLabel1.setText("Which Item You want to Delete");

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        dltButton.setText("Delete");
        dltButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dltButtonActionPerformed(evt);
            }
        });

        view.setText("View");
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dlttext, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(view)
                        .addGap(32, 32, 32)
                        .addComponent(dltButton)
                        .addGap(18, 18, 18)
                        .addComponent(backButton)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dlttext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(view)
                    .addComponent(dltButton)
                    .addComponent(backButton))
                .addGap(0, 64, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void performFileRelatedTask()
    {
        d = new DltItem();//creating the object of delete class
    }
    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
        // TODO add your handling code here:
            d = new DltItem();
            text.setText(d.getFullNames().toString());
        
        
    }//GEN-LAST:event_viewActionPerformed

    private void dltButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dltButtonActionPerformed
        // TODO add your handling code here:
        
        dltName=dlttext.getText();
        d.setName(dltName);
        d.deleteItem();
         JOptionPane.showMessageDialog(this, "Item has been removed");
        
        
        
    }//GEN-LAST:event_dltButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        ItemMngmnt im = new ItemMngmnt();
        im.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed
    
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
            java.util.logging.Logger.getLogger(DeleteItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeleteItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeleteItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeleteItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeleteItem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton dltButton;
    private javax.swing.JTextField dlttext;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea text;
    private javax.swing.JButton view;
    // End of variables declaration//GEN-END:variables
}

class DltItem {
    
    private Scanner scan;
    private String name;
    private String price;
    private String quantity;
    private StringBuilder fullnames;
    private String itemName [];
    int i,j;
    
    public DltItem()
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
    
    /*private void openFile()
    {
        try
        {
            scan = new Scanner(new File("item.txt"));
            System.out.println("File found!");
        }
        
        catch(Exception e)
        {
            System.out.println("File not found");
        }
    }*/
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    private void readFile()
    {
   /*     try{
            while(scan.hasNextLine())
        {
            name = scan.nextLine();
            price = scan.nextLine();
            quantity=scan.nextLine();
            fullnames.append(name + " \t" + price + " \t"+quantity+"\n");
        }
        }
        catch(Exception e){
            System.out.println(e);
        }*/
    	
    	try{  
    		Class.forName("com.mysql.jdbc.Driver");  
        	java.sql.Connection con=DriverManager.getConnection(  
        	"jdbc:mysql://localhost:3306/foodcourtdb","root","Mansi@123");
        	PreparedStatement stmt=con.prepareStatement("select * from add_item");  
        	ResultSet rs=stmt.executeQuery();  
        	while(rs.next()){
        		name = rs.getString(1);
        		i= rs.getInt(2);
        		price = String.valueOf(i);
          		j= rs.getInt(3);
        		quantity = String.valueOf(j);
        		 fullnames.append(name + " \t" + price + " \t" + quantity+"\n");
        	//fullnames.append(rs.getString(1)+" \t"+rs.getInt(2)+" \t"+rs.getInt(3));  
        	}  
        		con.close();
    	}
    	catch(Exception e){ System.out.println(e);}  
    }  
    
    /*private void closeFile()
    {
        scan.close();
    }*/
    
    public  void deleteItem(){
        
        String dlt = getName();	//It will return the string that you want to delete
        
        //System.out.println(dlt+"will be deleted");
        try{  
    		Class.forName("com.mysql.jdbc.Driver");  
        	java.sql.Connection con=DriverManager.getConnection(  
        	"jdbc:mysql://localhost:3306/foodcourtdb","root","Mansi@123");
        	PreparedStatement stmt=con.prepareStatement("delete from add_item where name=?");  
        	stmt.setString(1, dlt);
        	int i = stmt.executeUpdate();
        	System.out.println(i+ " item deleted");
        	con.close();
    	}
    	catch(Exception e){ System.out.println(e);}  
    }  
        
        
        /*int c=0,track, cnt=0,temp=0;
        
        try{
            Scanner sc = new Scanner(new FileInputStream("item.txt"));
            while(sc.hasNextLine()){
                cnt++;
                sc.nextLine();
                
            }
            itemName= new String[cnt];
            sc.close();
            sc = new Scanner(new FileInputStream("item.txt"));
            while(sc.hasNextLine()){
                itemName[c]=sc.nextLine();
                if(itemName[c].equalsIgnoreCase(dlt)){
                    temp=c;
                    System.out.println("Index will be deleted" +c);
                }
                c++;
                
            }
            
            
        }
        catch(Exception e){
            System.out.println(e);
            
        }
        
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream("item.txt"));
            for (int i = 0; i < c; i++) {
                if(i==temp ||i==temp+1 ||i==temp+2){
                    
                }
                else{
                    pw.println(itemName[i]);
                }
                
            }
            System.out.println("Your item has been deleted.");
            pw.close();
        }
        catch (Exception e) {
        }
        
        
        
        
        
    */
    
    
    
    
}

