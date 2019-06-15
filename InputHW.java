package mini;

import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;  //interface

public class InputHW
{
	
	  public int width;
	  public int height;
	  
	  Draw draw = new Draw();
	  
	  InputHW()
	  {
		    JPanel p = new JPanel(new BorderLayout(20,20));  // row, col
			JPanel label1 = new JPanel(new GridLayout(0,1,2,2));  // row, col, hgap, vgap
			JPanel label2 = new JPanel(new FlowLayout());  // center align
			
			label1.add(new JLabel("Width", SwingConstants.RIGHT));
			label1.add(new JLabel("Height", SwingConstants.RIGHT));
			
			label2.add(new JLabel("Minimum Width : 900 , Minimum Height : 800"));
			
			p.add(label1, BorderLayout.WEST);
			p.add(label2, BorderLayout.SOUTH);
			
			JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
			JTextField widthField = new JTextField();
			controls.add(widthField);
			JTextField heightField = new JTextField();
			controls.add(heightField);
			
			p.add(controls, BorderLayout.CENTER);
			
			JOptionPane.showMessageDialog(null, p, "Enter Width and Height of Canvas",JOptionPane.QUESTION_MESSAGE);
			
			try 
			{
				width = Integer.parseInt(widthField.getText());
				height = Integer.parseInt(heightField.getText());
				
				if(width<900 || height <800)
				{	
				  JOptionPane.showMessageDialog(null, p,"Minimum requirement W : 900 , H : 800", JOptionPane.ERROR_MESSAGE);
				}
				
					draw.paint(width, height);  //POLYMORPHISM
				    draw.paint();  //POLYMORPHISM
			} 
			
			catch (IllegalArgumentException e) 	//wrong i/p parameters
				{
					JOptionPane.showMessageDialog(null, p,"Please enter valid numbers!", JOptionPane.ERROR_MESSAGE);
				}
		    }
		  
	 /* public void run() 
		{
			new InputHW();
		
		} */
		
	  public static void main(String[] args) 
		{
		  new InputHW();
		}
}
