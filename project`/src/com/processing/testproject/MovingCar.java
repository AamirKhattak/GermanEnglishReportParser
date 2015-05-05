package com.processing.testproject;

/*
 * MrGreen
 * aamir.fui@gmail.com
 * 
 */

import processing.core.PApplet;
import processing.core.PFont;
import processing.event.MouseEvent;

@SuppressWarnings("serial")
public class MovingCar extends PApplet {

	private PFont f;
	private int car_x = 0;
	private int car_length = 70;
	private boolean forward = false, backward = false;

	private float zoom = 0;
	private float xo, yo;
	private int myX;
	private int myY;
	private boolean mouseDragged;

	public void setup() {

		// size( width, height);
		size(1000, 150);

		// font
		f = createFont("Arial", 16, true);

		// setting rec mode for car
		rectMode(CORNERS);
		// car(i, i + 70);

		// prevent from direct start
		noLoop();
	}

	public void draw() {
		background(0, 200, 0);

		// setting frame rate, default is 60
		frameRate(HomeScreen.getFrameRate());

		// road
		line(0, height - 10, width, height - 10);

		// to move around
		translate(xo, yo);

		// to zoom
		
		if( zoom > 0){
			if( mouseDragged){
				translate( xo, yo);				
			}
			translate( width-mouseX, height-mouseY);
		scale( zoom);
		//translate( mouseX, mouseY);	
		}

		// changing cursor, hand || arrow
		if ((mouseX >= car_x) && (mouseX <= car_x + car_length)) {
			if ((mouseY >= height - 60) && (mouseY <= height - 20)) {
				cursor(HAND);
			} else {
				cursor(ARROW);
			}
		} else {
			cursor(ARROW);
		}

		// forward, backword move
		if (forward == true) {
			car_x++;
			car(car_x, car_x + car_length);
		} else if (backward == true) {
			car_x--;
			car(car_x, car_x + car_length);
		}
		
		//checking Explicit reverse order from user 
		checkExplicitReverseOrder();
		
		//checking boundry, for movement direction
		checkImplicityReverseCondition();

		// setting to default view
		if (keyPressed) {
			if (key == ' ') {
				zoom = 1;
				xo = yo = 0;
			}
		}

		// displaying text
		textFont(f, 26);
		text("frameRate(FPS): " + (this.frameRate), 10, 30);
		text("frameCount: " + (this.frameCount), 400, 30);
		text("frameRate: " + (HomeScreen.getFrameRate()), 700, 30);
		text("Zoom: " +  zoom, 700, 70);

	}

	void car(int start_x, int end_x) {
		rect(start_x, height - 60, end_x, height - 20);
	}

	// checking Explicit revarse order from user
	// condition for forward/backword move
	private void checkExplicitReverseOrder() {
		if (HomeScreen.getRevarseStatus() == true) {
			if (forward == true) {
				forward = false;
				backward = true;
				HomeScreen.setRevarseStatus(false);
			} else {
				forward = true;
				backward = false;
				HomeScreen.setRevarseStatus(false);
			}
		}
	}
	
	// checking boundry,
	// condition for forward/backword move
	private void checkImplicityReverseCondition(){
		if (car_x <= 0) {
			forward = true;
			backward = false;
		} else if (car_x + car_length >= width) {
			backward = true;
			forward = false;
		}
		
	}

	/*
	 * Below HANDLING MOUSE EVENTS
	 * ####################################################
	 */

	// for changing car color
	public void mousePressed() {

		// if user click on/in car, true red
		if ((mouseX >= car_x) && (mouseX <= car_x + car_length)) {
			if ((mouseY >= height - 60) && (mouseY <= height - 20)) {
				fill(255, 0, 0);
			} else {
				fill(255);
			}
		} else {
			fill(255);
		}
	}

	// Mouse wheel to zoom in, out
	public void mouseWheel(MouseEvent event) {
		float e = event.getAmount();
		if (e < 0)
			{
			zoom++;}
		else
		{	if( zoom > 0)		
			zoom--;
		}
		
	}

	// to move around
	public void mouseDragged() {
		mouseDragged = true;
		xo = xo + (mouseX - pmouseX);
		yo = yo + (mouseY - pmouseY);
	}
}
