/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurentsystem;

import java.io.*;
import java.io.FileInputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


class ReciptFile {
	private Scanner sc;
	private Scanner scan;
	private String name;
	private String price;
	private String quantity;
	private StringBuilder fullnames;
	private double dPrice;
	private int dQuantity;
	private  double multi;
	private  static double sum=0;
	private PrintWriter pw;
	//private int id;
	public ReciptFile()// constructor
	{
		fullnames = new StringBuilder();
		//  openFile();
		readFile();
		//closeFile();
	}

	public StringBuilder getFullNames()
	{
		return fullnames;
	}
	public String getSum(){

		return String.valueOf(sum);
	}
	/*
    private void openFile()
    {
        try
        {
            pw = new PrintWriter(new FileOutputStream("order.txt",true));
            scan = new Scanner(new File("temp.txt"));
            sc = new Scanner(new FileInputStream("item.txt"));
            System.out.println("File found!");
        }

        catch(Exception e)
        {
            System.out.println("File not found");
        }
    }
	 */
	private void readFile()
	{
		int id=OrderManagement.id;
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			java.sql.Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/foodcourtdb","root","Mansi@123");
			PreparedStatement ps= con.prepareStatement("Select Name,Price,Quantity from order_item where ID=?");
			ps.setInt(1, id);
			ResultSet rs= ps.executeQuery();
			if(rs.next())
			{
				multi=1;
				name=rs.getString("Name");
				price=rs.getString("Price");
				dPrice=Double.valueOf(price);

				quantity=rs.getString("Quantity");
				dQuantity=Integer.decode(quantity);
				multi=dPrice*dQuantity;
				sum+=multi;
				fullnames.append(name + " \t"+quantity+"\t"+multi+ "\n");

			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}


	public String getName() {
		return name;
	}

	public String getQuantity() {
		return quantity;
	}

	public double getMulti() {
		return multi;
	}

}
