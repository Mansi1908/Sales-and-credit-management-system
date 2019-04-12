package restaurentsystem;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Label;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.border.TitledBorder;

//import com.maildemos.MailingDemo;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;
public class LoginPage extends JFrame {
	
	Connection con = null;
	ResultSet rs=null;
	PreparedStatement pst=null;
	static int id;
	static String name;
	//static String email;
	
	private JFrame frame;
	private JPanel contentPane;
	public static String uemail;
	private JTextField textField;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public  Connection ConnecrDb()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/foodcourtdb","root","Mansi@123");  
			System.out.println("Connection Established");
			return con;
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, ex);
			return null;
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginPage() {
		//JavaConnection c = new JavaConnection();
		con=ConnecrDb();
		setTitle("Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 682, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(new Color(153, 0, 0));
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(146, 106, 164, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(153, 0, 0));
		lblPassword.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
		lblPassword.setBounds(146, 150, 164, 25);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(286, 106, 224, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				id=Integer.parseInt(textField.getText());
				String sql="Select * from customers where id=? and password = ?";
				//String sql2="Select name from customers where id=? and password = ?";
				try
				{
					pst=con.prepareStatement(sql);
					pst.setInt(1,Integer.parseInt(textField.getText()));
					pst.setString(2,passwordField.getText());
					rs=pst.executeQuery();
					/*pst1=con.prepareStatement(sql2);
					pst1.setInt(1,Integer.parseInt(textField.getText()));
					pst1.setString(2,passwordField.getText());
					rs1=pst1.executeQuery();
						*/	
					if(rs.next())
					{
						name=rs.getString("name");
						uemail=rs.getString("email");
						JOptionPane.showMessageDialog(null, "Username and password is correct");
						//frame.dispose();
						//Login.DISPOSE_ON_CLOSE;
						
						//MailingDemo s = new MailingDemo();
						ItemMngmnt s=new ItemMngmnt();
						s.setVisible(true);
						close();
						//this.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Username and password is not correct");
						
					}/*
					if(rs1.next())
					{
						name=rs1.getString("name");
					}*/
					
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
				}
			});
			
			
		btnNewButton.setForeground(new Color(204, 51, 51));
		btnNewButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBounds(356, 237, 123, 33);
		contentPane.add(btnNewButton);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Register r= new Register();
				r.setVisible(true);
				close();
			}
		});
		btnRegister.setForeground(new Color(204, 51, 51));
		btnRegister.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
		btnRegister.setBounds(160, 237, 123, 33);
		contentPane.add(btnRegister);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(286, 153, 224, 25);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\DELL1\\Desktop\\upppeess.jpg"));
		lblNewLabel_1.setBounds(0, 0, 666, 413);
		contentPane.add(lblNewLabel_1);
	}
	 public void close(){
		 
		 WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		 Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
		 
		 }
}
