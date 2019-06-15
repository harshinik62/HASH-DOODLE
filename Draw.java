package mini;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;  // indicates that action has occurred
import java.awt.event.ActionListener;  // what should be done when user performs operation

import javax.swing.Box;  // used for BoxLayout
import javax.swing.Icon;  // used to decorate ImageIcon
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;  // top-level window with title & border
import javax.swing.JPanel;  // groups set of components together
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import javax.swing.JFileChooser;

import java.io.File;
import java.awt.BorderLayout;

public class Draw 
{
	Canvas canvas;	
	
	Color color = Color.WHITE;
	
	JButton clearButton, blackButton, blueButton, greenButton, redButton, txt,
	colorPicker, magentaButton, grayButton, orangeButton, yellowButton,
	pinkButton, cyanButton, lightGrayButton, undoButton, redoButton, loadButton, saveButton, saveAsButton;
	
	private JFileChooser fileChooser;
	private File file;
		
	private JSlider thicknessSlider; 
	private int saveCounter = 0; 
	private JLabel thicknessStat;
	
	private Icon save = new ImageIcon(getClass().getResource("save.png"));
	private Icon undo = new ImageIcon(getClass().getResource("undo.png"));
	private Icon redo = new ImageIcon(getClass().getResource("redo.png"));
	
	private int width, height;
	
	ChangeListener thick = new ChangeListener() 
	{				
		public void stateChanged(ChangeEvent e) 
		{				
			thicknessStat.setText(String.format("%s", thicknessSlider.getValue()));			
			canvas.setThickness(thicknessSlider.getValue());		
		}
	};		

	ActionListener listener = new ActionListener()   //click on button
	{
		public void actionPerformed(ActionEvent event) 
		{
			if (event.getSource() == clearButton) 			//which button clicked
			{
				canvas.clear();
			} 
			else if (event.getSource() == blackButton) 
			{
				canvas.black();
			} 
			else if (event.getSource() == blueButton) 
			{
				canvas.blue();
			} 
			else if (event.getSource() == greenButton) 
			{
				canvas.green();
			} 
			else if (event.getSource() == redButton) 
			{
				canvas.red();
			} 
			else if (event.getSource() == magentaButton) 
			{
				canvas.magenta();
			} 
			else if (event.getSource() == grayButton) 
			{
				canvas.gray();
			} 
			else if (event.getSource() == orangeButton) 
			{
				canvas.orange();
			} 
			else if (event.getSource() == yellowButton) 
			{
				canvas.yellow();
			} 
			else if (event.getSource() == pinkButton) 
			{
				canvas.pink();
			} 
			else if (event.getSource() == cyanButton) 
			{
				canvas.cyan();
			} 
			else if (event.getSource() == lightGrayButton) 
			{
				canvas.lightGray();
			} 
			
			else if(event.getSource() == txt)
			{
				canvas.txt();
			}
			
			 else if (event.getSource() == colorPicker) 
			 {
					color = JColorChooser.showDialog(null, "Pick your color!",color);
					
					if (color == null)
						color = (Color.WHITE);
					
					canvas.picker(color);
				}
			
			 else if (event.getSource() == loadButton) 
			 {	            
			            fileChooser = new JFileChooser();
			            
						if (fileChooser.showOpenDialog(loadButton) == JFileChooser.APPROVE_OPTION) 
						{
							file = fileChooser.getSelectedFile();
							canvas.load(file);
							
							/*l1 = new JLabel("Hello");
							l1.setBounds(50,50,100,20);
							f.add(l1);*/
						}
			 }
			
			 else if (event.getSource() == saveButton) 
			 {				
					if (saveCounter == 0) 
					{
						fileChooser = new JFileChooser();
						
						if (fileChooser.showSaveDialog(saveButton) == JFileChooser.APPROVE_OPTION) 
						{
							file = fileChooser.getSelectedFile();
							saveCounter = 1;
							canvas.save(file);
						}
					} 
					else 
					{
						canvas.save(file);
					}
				} 
			 
			 else if (event.getSource() == saveAsButton) 
			 {				
					saveCounter = 1;
					fileChooser = new JFileChooser();
					
					if (fileChooser.showSaveDialog(saveAsButton) == JFileChooser.APPROVE_OPTION) 
					{
						file = fileChooser.getSelectedFile();
						canvas.save(file);
					}
			 }	
		}
					
	};

	public void paint(int width,int height)  //POLYMORPHISM
	{
		this.width = width;
		this.height = height;
	}
	
	public void paint()  //POLYMORPHISM
	{
		JFrame frame = new JFrame(" Hash Doodle - A Paint Application ");
		
		Container container = frame.getContentPane();
		container.setLayout(new BorderLayout());
		
		canvas = new Canvas();
		container.add(canvas, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		Box box1 = Box.createVerticalBox();
		Box box2 = Box.createHorizontalBox();
		
		undoButton = new JButton(undo);
		undoButton.setPreferredSize(new Dimension(80, 80));
		undoButton.addActionListener(listener);
		
		redoButton = new JButton(redo);
		redoButton.setPreferredSize(new Dimension(80, 80));
		redoButton.addActionListener(listener);
		
		thicknessSlider = new JSlider(JSlider.HORIZONTAL, 0, 50, 1);
		thicknessSlider.setMajorTickSpacing(10);
		thicknessSlider.setPaintTicks(true);
		thicknessSlider.setPreferredSize(new Dimension(40, 40));
		thicknessSlider.addChangeListener(thick);
		
		blackButton = new JButton();
		blackButton.setBackground(Color.BLACK);
		blackButton.setPreferredSize(new Dimension(40, 40));
		blackButton.addActionListener(listener);
		
		blueButton = new JButton();
		blueButton.setBackground(Color.BLUE);
		blueButton.setPreferredSize(new Dimension(40, 40));
		blueButton.addActionListener(listener);
		
		greenButton = new JButton();
		greenButton.setBackground(Color.GREEN);
		greenButton.setPreferredSize(new Dimension(40, 40));
		greenButton.addActionListener(listener);
		
		redButton = new JButton();
		redButton.setBackground(Color.RED);
		redButton.setPreferredSize(new Dimension(40, 40));
		redButton.addActionListener(listener);
		
		magentaButton = new JButton();
		magentaButton.setBackground(Color.MAGENTA);
		magentaButton.setPreferredSize(new Dimension(40, 40));
		magentaButton.addActionListener(listener);
		
		grayButton = new JButton();
		grayButton.setBackground(Color.GRAY);
		grayButton.setPreferredSize(new Dimension(40, 40));
		grayButton.addActionListener(listener);
		
		orangeButton = new JButton();
		orangeButton.setBackground(Color.ORANGE);
		orangeButton.setPreferredSize(new Dimension(40, 40));
		orangeButton.addActionListener(listener);
		
		yellowButton = new JButton();
		yellowButton.setBackground(Color.YELLOW);
		yellowButton.setPreferredSize(new Dimension(40, 40));
		yellowButton.addActionListener(listener);
		
		pinkButton = new JButton();
		pinkButton.setBackground(Color.PINK);
		pinkButton.setPreferredSize(new Dimension(40, 40));
		pinkButton.addActionListener(listener);
		
		cyanButton = new JButton();
		cyanButton.setBackground(Color.CYAN);
		cyanButton.setPreferredSize(new Dimension(40, 40));
		cyanButton.addActionListener(listener);
		
		lightGrayButton = new JButton();
		lightGrayButton.setBackground(Color.LIGHT_GRAY);
		lightGrayButton.setPreferredSize(new Dimension(40, 40));
		lightGrayButton.addActionListener(listener);
		
		saveButton = new JButton(save);
		saveButton.setPreferredSize(new Dimension(120, 80));
		saveButton.addActionListener(listener);
		
		txt = new JButton("Add Text");
		txt.setPreferredSize(new Dimension(120, 80));
		txt.addActionListener(listener);
		
		saveAsButton = new JButton("Save As");
		saveAsButton.setPreferredSize(new Dimension(120, 80));
		saveAsButton.addActionListener(listener);
		
		loadButton = new JButton("Load");
		loadButton.setPreferredSize(new Dimension(120, 80));
		loadButton.addActionListener(listener);
		
		colorPicker = new JButton("Color Picker");
		colorPicker.setPreferredSize(new Dimension(120, 80));
		colorPicker.addActionListener(listener);
			
		clearButton = new JButton("Clear");
		clearButton.setPreferredSize(new Dimension(120, 80));
		clearButton.addActionListener(listener);
		
		thicknessStat = new JLabel("1");
		
		
		box2.add(thicknessSlider, BorderLayout.NORTH);
		box2.add(thicknessStat, BorderLayout.NORTH);
		box1.add(box2, BorderLayout.NORTH);
		
		box1.add(Box.createVerticalStrut(30));
		box1.add(undoButton, BorderLayout.NORTH);
		
		box1.add(Box.createVerticalStrut(60));
		box1.add(redoButton, BorderLayout.NORTH);
		
		panel.add(greenButton);
		panel.add(blueButton);
		panel.add(blackButton);
		panel.add(redButton);
		panel.add(magentaButton);
		panel.add(grayButton);
		panel.add(orangeButton);
		panel.add(yellowButton);
		panel.add(pinkButton);
		panel.add(cyanButton);
		panel.add(lightGrayButton);
		
		
		panel.add(Box.createHorizontalStrut(20));
		panel.add(saveButton);
		
		panel.add(Box.createHorizontalStrut(20));
		panel.add(saveAsButton);
		
		panel.add(Box.createHorizontalStrut(20));
		panel.add(loadButton);
		
		panel.add(Box.createHorizontalStrut(20));
		panel.add(colorPicker);
				
		panel.add(Box.createHorizontalStrut(20));
		panel.add(clearButton);
		
		panel.add(Box.createHorizontalStrut(20));
		panel.add(txt);

		container.add(panel, BorderLayout.NORTH);
		container.add(box1, BorderLayout.WEST);

		frame.setVisible(true);

		frame.setSize(width,height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
