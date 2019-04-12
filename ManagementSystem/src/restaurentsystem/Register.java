package restaurentsystem;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Register extends JFrame {

	Connection con = null;
	ResultSet rs=null;
	PreparedStatement pst=null;

	private JPanel contentPane;
	private JTextField sap_id;
	private JTextField name;
	private JTextField email;
	private JPasswordField password;
	private JTextField number;
	private JPasswordField cnfrmpwd;

	/**
	 * Launch the application.
	 */
	public  Connection connecrDb()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/foodcourtdb","root","Mansi@123");  
			System.out.println("Connection Established");
			return con;

		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		//con=JavaConnection.ConnecrDb();
		con=connecrDb();
		setTitle("Register Form");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 535, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GREEN));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(Color.BLUE);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Register", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 139)));
		panel.setBounds(34, 19, 439, 336);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblSapId = new JLabel("Sap Id");
		lblSapId.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 13));
		lblSapId.setBounds(30, 30, 71, 14);
		panel.add(lblSapId);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 13));
		lblName.setBounds(30, 75, 71, 14);
		panel.add(lblName);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 13));
		lblPassword.setBounds(30, 165, 71, 14);
		panel.add(lblPassword);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 13));
		lblEmail.setBounds(30, 120, 57, 14);
		panel.add(lblEmail);

		JLabel lblContactno = new JLabel("Contact_No");
		lblContactno.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 13));
		lblContactno.setBounds(30, 255, 71, 14);
		panel.add(lblContactno);

		sap_id = new JTextField();
		sap_id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char vChar = evt.getKeyChar();
				if (!(Character.isDigit(vChar)
						|| (vChar == KeyEvent.VK_BACK_SPACE)
						|| (vChar == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					JOptionPane.showMessageDialog(null, "This field accepts numeric values");
					evt.consume();
				}
			}
		});
		sap_id.setBounds(211, 24, 158, 20);
		panel.add(sap_id);
		sap_id.setColumns(10);

		name = new JTextField();

		name.setBounds(211, 69, 158, 20);
		panel.add(name);
		name.setColumns(10);

		email = new JTextField();
		email.setBounds(211, 114, 158, 20);
		panel.add(email);
		email.setColumns(10);

		password = new JPasswordField();
		password.setBounds(211, 159, 158, 20);
		panel.add(password);

		number = new JTextField();
		number.setBounds(211, 249, 158, 20);
		panel.add(number);
		number.setColumns(10);

		JButton btnRegister = new JButton("Submit");
		btnRegister.setBounds(242, 302, 128, 23);
		panel.add(btnRegister);
		btnRegister.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 13));

		JButton btnBa = new JButton("Login");
		btnBa.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 13));
		btnBa.addActionListener(new ActionListener() {
			public void actionP1erformed(ActionEvent arg0) {
				LoginPage p=new LoginPage();
				p.setVisible(true);
				close();

			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LoginPage p=new LoginPage();
				p.setVisible(true);
				close();

			}
		});
		btnBa.setBounds(52, 302, 89, 23);
		panel.add(btnBa);

		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 13));
		lblConfirmPassword.setBounds(30, 209, 122, 14);
		panel.add(lblConfirmPassword);

		cnfrmpwd = new JPasswordField();
		cnfrmpwd.setBounds(211, 204, 158, 20);
		panel.add(cnfrmpwd);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String pass=password.getText();
				String cnfrmpass=cnfrmpwd.getText();
				if(sap_id.getText().isEmpty() || name.getText().isEmpty() ||email.getText().isEmpty() ||password.getText().isEmpty() ||cnfrmpwd.getText().isEmpty() || number.getText().isEmpty() )
				{
					JOptionPane.showMessageDialog(null, "All Fields are mandatory");
				}
				else if (!(Pattern.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", email.getText()))) 
				{
					JOptionPane.showMessageDialog(null, "Please enter a valid email", "Error", JOptionPane.ERROR_MESSAGE);
				}

				else if(cnfrmpass != null && !cnfrmpass.equals(pass))
				{
					JOptionPane.showMessageDialog(null, "Password doesn't match");

				}
				else if (!(Pattern.matches("(0|91)?[7-9][0-9]{9}", number.getText()))) 
				{
					JOptionPane.showMessageDialog(null, "Please enter a valid Mobile No", "Error", JOptionPane.ERROR_MESSAGE);
				}



				else {
					String sql="Insert into customers values (?,?,?,?,?)";
					try {
						pst=con.prepareStatement(sql);
						pst.setInt(1, Integer.parseInt(sap_id.getText()));
						pst.setString(2, name.getText());
						pst.setString(3, email.getText());
						pst.setString(4, password.getText());
						pst.setString(5, number.getText());

						int i=pst.executeUpdate();
						System.out.println(i+" records inserted");  
						if(i>0) {
							JOptionPane.showMessageDialog(null, "Inserted Successfully");}
						//Frame1 f = new Frame1();
						//f.setVisible(true);

					} catch (NumberFormatException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}}
		});
	}
	public void close(){

		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);

	}
}
