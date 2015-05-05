package com.processing.testproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import processing.core.*;

public class HomeScreen {

	JFrame myFrame = new JFrame("Test Project");
	PApplet sketch = new MovingCar();
	
	
	JPanel sketch_panel = new JPanel();
	JPanel buttons_panel = new JPanel();
	
	public static int FrameRate = 60;
	
	public static boolean revarse = false;
	
	public HomeScreen() {

		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
		myFrame.setSize( 1100, 400);
		
		JButton pauseBtn = new JButton("Pause");
		pauseBtn.addActionListener( new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				sketch.noLoop();				
			}			
		});
		
		JButton startBtn = new JButton("Start");
		startBtn.addActionListener( new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				sketch.loop();
				//sketch.start();
			}			
		});

		JButton frameRateBtn = new JButton("Set Frame Rate");
		frameRateBtn.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String fmRate = JOptionPane.showInputDialog("Enter Frame Rate");
				FrameRate = Integer.parseInt( fmRate);
				
			}
		});
		
		JButton revarseBtn = new JButton("Revarse Animation");
		revarseBtn.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				revarse = true;
			}
		});
		
		buttons_panel.setBounds( 0, 0, 1000, 150);
		buttons_panel.add(pauseBtn);
		buttons_panel.add(startBtn);
		buttons_panel.add(frameRateBtn);
		buttons_panel.add( revarseBtn);
		
		sketch_panel.setBounds(20, 70, 1000, 150);		
		sketch_panel.add(sketch);
		
		myFrame.add(sketch_panel);
		myFrame.add(buttons_panel);
		sketch.init();
		myFrame.setVisible(true);
	}
	
	public static int getFrameRate(){
		return FrameRate;				
	}
	
	public static boolean getRevarseStatus(){
		return revarse;
	}
	
	public static void setRevarseStatus(boolean status){
		revarse = status;
	}
}
