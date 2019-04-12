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


public class OrderManagement extends javax.swing.JFrame {
     private OrdrManagement o;
     private ReciptFile r;
    private String srcName;// get the id of source
    private String modName;
    private String modPrice;
    private String ModQuantity;// getting quantity from text field
    private int pass;
    protected BillManagement b;
    private PrintWriter pw;
    public static int id;
   private  TotalPrice t;
   private inTotal it;
  
    public OrderManagement() {
        initComponents();
        performFileRelatedTask();
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        billButton = new javax.swing.JButton();
        orderButton = new javax.swing.JButton();
        viewbutton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        item_Quantity = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        newItemButton = new javax.swing.JButton();
        ItemId = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        reciptArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        totalPriceField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        text.setEditable(false);
        text.setBackground(new java.awt.Color(204, 204, 204));
        text.setColumns(20);
        text.setRows(5);
        jScrollPane1.setViewportView(text);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        billButton.setText("Bill");
        billButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billButtonActionPerformed(evt);
            }
        });

        orderButton.setText("Order");
        orderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderButtonActionPerformed(evt);
            }
        });

        viewbutton.setText("viewbutton");
        viewbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewbuttonActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Which ID Item You want?");

        jLabel4.setText("Enter  Quantity");

        newItemButton.setText("New Item");
        newItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newItemButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(28, 28, 28)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(item_Quantity, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(ItemId))
                .addGap(113, 113, 113))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(newItemButton)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ItemId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(item_Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newItemButton)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(viewbutton)
                .addGap(18, 18, 18)
                .addComponent(orderButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(billButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backButton)
                .addGap(108, 108, 108))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewbutton)
                    .addComponent(orderButton)
                    .addComponent(billButton)
                    .addComponent(backButton))
                .addGap(23, 23, 23))
        );

        reciptArea.setBackground(new java.awt.Color(255, 153, 102));
        reciptArea.setColumns(20);
        reciptArea.setRows(5);
        jScrollPane2.setViewportView(reciptArea);

        jLabel2.setText("Name");

        jLabel3.setText("Price");

        jLabel5.setText("Quantity");

        totalPriceField.setEditable(false);
        totalPriceField.setBackground(new java.awt.Color(255, 204, 51));

        jLabel6.setText("ID");

        jLabel8.setText("Price");

        jLabel7.setText("Quantity");

        jLabel10.setText("Name");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jLabel3)
                                .addGap(48, 48, 48)
                                .addComponent(jLabel5))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalPriceField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(34, 34, 34))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(jLabel10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
     private void performFileRelatedTask()
    {
        o = new OrdrManagement();
       
    }
    
    private void viewbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewbuttonActionPerformed
            // TODO add your handling code here:
            o = new OrdrManagement();
            text.setText(o.getFullNames().toString());
        
    }//GEN-LAST:event_viewbuttonActionPerformed

    private void orderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderButtonActionPerformed
        
       // o.delete();
        BillManagement b = new BillManagement();
        this.dispose();
        b.setVisible(true);
        
    }//GEN-LAST:event_orderButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        RestaurentManagement im = new RestaurentManagement();
        im.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    private void billButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billButtonActionPerformed
            // TODO add your handling code here:
        
        b= new BillManagement();
        b.setVisible(true);
          this.dispose();
        
    }
    private void newItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newItemButtonActionPerformed
    	srcName=ItemId.getText();// getting name
    	id=Integer.parseInt(srcName);// converting it into integer
    	// to store the values fetched from the database
    	String name;// 
    	int prc;
    	int quantity;
    	int q;
    	ModQuantity=item_Quantity.getText();	// user given quantity
    	try{  
    		//opening db  connection
    		Class.forName("com.mysql.jdbc.Driver");  
        	java.sql.Connection con=DriverManager.getConnection(  
        	"jdbc:mysql://localhost:3306/foodcourtdb","root","Mansi@123");
        	PreparedStatement stmt2=con.prepareStatement("select Name,Price,Quantity from add_item where ID = ?");
        	stmt2.setInt(1, id);
        	ResultSet rs2=stmt2.executeQuery(); 
        	//System.out.println("Heloo");
        	if(rs2.next())
        	{
        		 name=rs2.getString("Name");
        		 prc=rs2.getInt("Price");
        		 quantity=rs2.getInt("Quantity");
        
        		if(quantity < Integer.parseInt(ModQuantity))
        		{
        			JOptionPane.showMessageDialog(null, "Sorry this product is out of stock");
        			item_Quantity.setText("");
        		}
        		else {
        		 q=Integer.parseInt(ModQuantity);
        			//quantity=quantity-q;
                	PreparedStatement stmt3=con.prepareStatement("insert into order_item values (?,?,?,?)");
                	stmt3.setInt(1, id);
                	stmt3.setString(2, name);
                	stmt3.setInt(3, prc);
                	stmt3.setInt(4, q);
                	int l=stmt3.executeUpdate();
                	//System.out.println(l+" rows affected");
                	JOptionPane.showMessageDialog(null, "New item inserted in the order list");
                	ItemId.setText("");
                	item_Quantity.setText("");
                	quantity=quantity-q;
                	// updating the item table after ordering the food
                	PreparedStatement stmt4=con.prepareStatement("update add_item set Quantity = ? where ID = ?");
                	stmt4.setInt(1, quantity);
                	stmt4.setInt(2, id);
                	int m=stmt4.executeUpdate();
                	System.out.println(m +"records updated");
                	/* r = new ReciptFile();// object of class is created
                     reciptArea.setText(r.getFullNames().toString());
                     totalPriceField.setText("Total price : "+r.getSum().toString());
                    */
                	 t = new TotalPrice();
                     // r= new ReciptFile();
                     it=new inTotal();
                     reciptArea.setText(t.getFullNames().toString());
                         
                    totalPriceField.setText(it.getTotal());
                	
            	}
                	
                	
                	
                	con.close();
        		}
        			
        			
        		
        	}
   	catch (Exception e) {
			// TODO: handle exception
   		System.out.println(e);
		}
    	
    	    }
        
        
        
        
   //GEN-LAST:event_newItemButtonActionPerformed
    
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
            java.util.logging.Logger.getLogger(OrderManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton newItemButton;
    private javax.swing.JButton billButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField item_Quantity;
    private javax.swing.JTextField ItemId;
    private javax.swing.JButton orderButton;
    private javax.swing.JTextArea reciptArea;
    private javax.swing.JTextArea text;
    private javax.swing.JTextField totalPriceField;
    private javax.swing.JButton viewbutton;
    // End of variables declaration//GEN-END:variables
}



class OrdrManagement {
  //  protected OrderManagement o = new OrderManagement();
    private Scanner scan;
    private String srchName;
    private int num=1;
    private String s1,s2;

    private String name;
    private int cngQuantity;
    
    private String price;
    private String quantity;
    private StringBuilder fullnames;

    private StringBuilder fullnames2;
    private String itemName [];
    private StringBuilder reciptName;
    private int i,j,id;
    public OrdrManagement()
    {
        fullnames = new StringBuilder();
      //  fullnames2 = new StringBuilder();
        //openFile();
        readFile();
        
        //closeFile();
        
    }
    
    public StringBuilder getFullNames()
    {
        return fullnames;
    }
    public StringBuilder getReciptName()
    {
        return reciptName ;
    }
  
    public void setSrchName(String srchName) {
        this.srchName = srchName;
    }
     public String getSrchName() {
        return srchName;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    
    public String getPrice() {
        return price;
    }
    
    public String getQuantity() {
        return quantity;
    }
    
    
    private void readFile()
            
    {

    	try{  
    		Class.forName("com.mysql.jdbc.Driver");  
        	java.sql.Connection con=DriverManager.getConnection(  
        	"jdbc:mysql://localhost:3306/foodcourtdb","root","Mansi@123");
        	PreparedStatement stmt2=con.prepareStatement("select * from add_item");  
        	ResultSet rs2=stmt2.executeQuery();  
        	while(rs2.next()){
        		id = rs2.getInt("ID");
        		name = rs2.getString("name");
        		i= rs2.getInt("Price");
        		price = String.valueOf(i);
          		j= rs2.getInt("Quantity");
        		quantity = String.valueOf(j);
        		 fullnames.append(String.valueOf(id)+ "\t" + name + " \t" + price + " \t" + quantity+"\n");
        	//fullnames.append(rs.getString(1)+" \t"+rs.getInt(2)+" \t"+rs.getInt(3));  
        	}  
        		con.close();
    	}
    	catch(Exception e){ System.out.println(e);}  
    }  
    	
    public  void ModifyItem(){
        String srcKey=getSrchName();
        System.out.println(srcKey +" is going to be changed in quantity");
        
        System.out.println(srcKey+"will be modified");
        
        
        int c=0,track, cnt=0,temp=0;
        
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
                if(itemName[c].equalsIgnoreCase(srcKey)){
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
                if(i==temp+2){
                    cngQuantity= Integer.decode(itemName[i]);
                    
                    cngQuantity=cngQuantity-Integer.decode(getQuantity());
                    pw.println(cngQuantity);
                    System.out.println("Value has been changed ");
                    
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
        
      
    }
    
    public int checkQuantity(int n){
        int i=1;
        int quantity;
        int count;
         try{
            Scanner sc = new Scanner(new FileInputStream("item.txt"));
            while(sc.hasNextLine()){
                if(i==n){
                    sc.nextLine();sc.nextLine();
                    quantity=Integer.decode(sc.nextLine());
                    return quantity;
                } else {
                sc.nextLine();
                sc.nextLine();
                sc.nextLine();
            }
                i++;
            }
            sc.close();
            }
        catch(Exception e){
            System.out.println(e);
            
        }
         return 0;
    }
    public void temp(int n, int i) {
        
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream("temp.txt",true));
            
         Scanner sc = new Scanner(new FileInputStream("Item.txt"));
            for(int j=1;sc.hasNextLine(); j++){
                if (j==n){
                 s1 = sc.nextLine();
                 pw.println(s1);
                 
                 s2 = sc.nextLine();
                 pw.println(i);
                 sc.nextLine();
                } else {sc.nextLine();sc.nextLine();sc.nextLine();}
            }
            sc.close();
            pw.close();
      
                    
        } catch (Exception e) {}
        //delete();
    }
    public void delete(){
      
    	
    	try{  
    		//opening db  connection
    		Class.forName("com.mysql.jdbc.Driver");  
        	java.sql.Connection con=DriverManager.getConnection(  
        	"jdbc:mysql://localhost:3306/foodcourtdb","root","Mansi@123");
        	PreparedStatement ps = con.prepareStatement("delete from order_item");
        	int k=ps.executeUpdate();
        	System.out.println(k+" rows deleted");
        	
        	con.close();
    	}
    	catch (Exception e) {
			// TODO: handle exception
		}
    
    }
    
    public void readRecipt(){
        
        try{
            Scanner sc = new Scanner(new FileInputStream("temp.txt"));
            while(sc.hasNextLine())
            {
                name = sc.nextLine();
                //price = scan.nextLine();
                quantity=sc.nextLine(); // + " \t"+quantity+
                reciptName.append(name + " \t" + quantity +"\n");
            }
          sc.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    
    
}

