package mini;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font; 

import java.sql.*;

class SwingLogin implements ActionListener		//notified when button clicked
{ 
	JLabel l1,l2,l3,l4;
	JTextField t1; 
	JPasswordField t2; 
	JButton b1; 
	JFrame jf=new JFrame("LOGIN");
	
	SwingLogin()
	{
		jf.setVisible(true);
		jf.setSize(500,340); 
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		jf.setLayout(null); 
	
		l1=new JLabel("Login to open Hash Doodle!");
		jf.add(l1); 
		l1.setFont(new Font("Serif",Font.BOLD,30));
	
		l2=new JLabel("Username"); 
		jf.add(l2);
		l2.setFont(new Font("Serif",Font.BOLD,20));
		
		t1=new JTextField();
		jf.add(t1); 
		
		l3=new JLabel("Password");
		l3.setFont(new Font("Serif",Font.BOLD,20));
		jf.add(l3);
		
		t2=new JPasswordField(); 
		jf.add(t2); 
		
		b1=new JButton("Login");
		jf.add(b1); 
		
		l4=new JLabel();
		jf.add(l4); 
		
		l1.setBounds(70,30,400,30);
		l2.setBounds(100,80,200,20); 
		t1.setBounds(200,80,200,20); 
		l3.setBounds(100,130,200,20);
		t2.setBounds(200,130,200,20); 
		b1.setBounds(170,180,100,20); 
		l4.setBounds(170,240,100,20); 
		
		b1.addActionListener(this); 
	}
	
	public void actionPerformed(ActionEvent e)
	{ 
			String str1 = t1.getText();
			char[] p = t2.getPassword();
			String str2 = new String(p);
			
			try
			{
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proj","root","");
				
				String q2="Select password from user where name='"+str1+"'";
				
				PreparedStatement ps = conn.prepareStatement(q2);
				ResultSet r=ps.executeQuery(q2);
				r.next();
				
				if (str2.equals(r.getString(1)))
				{
					l4.setText("Login Success!");
					b1.setBackground(Color.GREEN); 
					
					JOptionPane.showMessageDialog(null," Connected to database \n Succesfully logged in");
					
					jf.setVisible(false);
					new InputHW();
				}
				else
				{   
					l4.setText("Login Fail!");
					b1.setBackground(Color.RED); 
					
					JOptionPane.showMessageDialog(null," Incorrect password or username");
				}
			}
	
			catch (Exception ex)
			{
				JOptionPane.showMessageDialog(null,"This user doesn't exist & can't login to Hash Doodle");
			}
		}
}


public class LoginMain
{ 
	public static void main(String[] args)
	{ 
		new SwingLogin();
	} 
}