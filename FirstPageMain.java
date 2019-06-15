package mini;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class FirstPage implements ActionListener
{
	JLabel l1,bg;
	JButton b;
	JFrame jf=new JFrame("HASH DOODLE \n");
	
	FirstPage()
	{
		jf.setVisible(true);
		jf.setSize(2000,2000);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLayout(null);
		
		JLabel l1=new JLabel("Welcome to Hash Doodle!!! \n");
		l1.setFont(new Font("Serif",Font.BOLD,90));
		
		ImageIcon img=new ImageIcon("C:\\Users\\Harshini\\OneDrive\\Desktop\\paints.jpg");
		bg=new JLabel("",img,JLabel.CENTER);
	
		b=new JButton("CONTINUE");
		
		jf.add(l1); 
		jf.add(b);
		jf.add(bg);
		
		l1.setBounds(400,70,1200,100);
		b.setBounds(850,900,150,60);
		bg.setBounds(100,0,1650,1080);
		
		b.addActionListener(this); 
}
	public void actionPerformed(ActionEvent e)
	{ 
      if(e.getSource()==b)
      {
    	  jf.setVisible(false);
    	  new SwingLogin();
      }
	}
}

public class FirstPageMain 
{
	public static void main(String args[])
	{
			new FirstPage();
	}
}