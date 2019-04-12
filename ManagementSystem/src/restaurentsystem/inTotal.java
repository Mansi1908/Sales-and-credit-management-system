/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurentsystem;

import java.io.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class inTotal {
    public Scanner scan;
    public double total=0;
    public int price;
    public double sum =1;
    public int quantity;
    public double dprice;

    public double dquantity;
    public String getTotal() {
        
    	
    	try{  
    		//opening db  connection
    		Class.forName("com.mysql.jdbc.Driver");  
        	java.sql.Connection con=DriverManager.getConnection(  
        	"jdbc:mysql://localhost:3306/foodcourtdb","root","Mansi@123");
        	PreparedStatement ps=con.prepareStatement("Select Quantity,Price from order_item");
        	ResultSet rs=ps.executeQuery();
        	while(rs.next())
        	{
        		price=rs.getInt("Price");
        		quantity=rs.getInt("Quantity");
        		dprice = Double.valueOf(price);
        		dquantity=Double.valueOf(quantity);
        		sum=dprice*dquantity;
        		total=total+sum;
        	}
        	
        	
        	}
        	catch (Exception e) {
				// TODO: handle exception
        		System.out.println(e);
			}
    	
    	return String.valueOf("Total Price is : "+total);
    }  	
    	
    	
    	
       
    
}