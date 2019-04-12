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


public class TotalPrice {
    private Scanner sc;
    private Scanner scan;
    private String name;
    private int price;
    private int quantity;
    private StringBuilder fullnames;
    private double dPrice;
    private int dQuantity;
    private double multi;
    private PrintWriter pw;
    public TotalPrice()
    {
        fullnames = new StringBuilder();
        readFile();
    }

    public StringBuilder getFullNames()
    {
        return fullnames;
    }
    private void readFile()
    {
    	
    	try{  
    		//opening db  connection
    		Class.forName("com.mysql.jdbc.Driver");  
        	java.sql.Connection con=DriverManager.getConnection(  
        	"jdbc:mysql://localhost:3306/foodcourtdb","root","Mansi@123");
        	PreparedStatement ps=con.prepareStatement("Select Name,Price,Quantity from order_item");
        	ResultSet rs=ps.executeQuery();
        	while(rs.next())
        	{
        		name=rs.getString("Name");
        		price=rs.getInt("Price");
        		quantity=rs.getInt("Quantity");
        		  fullnames.append(name + " \t"+quantity+"\t"+price+ "\n");
        	}
            con.close();
    	}
    	catch (Exception e) {
			// TODO: handle exception
		}
    	
    }
}
