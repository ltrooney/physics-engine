package objects;

import java.util.ArrayList;

import window.Grid;
import constants.Constants;

public class DynamicObject extends Object {
	
	private double t; 
	private double theta; 		// in radians
	private double v0;
	
	// X:
	private double xf, vf_x, v0_x, a_x;	
	
	// Y:
	private double yf, vf_y, v0_y, a_y;
	
	private int pathCounter = 1;	// # of iterations that passed since last path line drawn
	public boolean showPath;
	public ArrayList<Integer[]> pathCoords;

	public DynamicObject() {
		super();	// call Object()
		
		t = 0.0;
		theta = Math.PI/4;		// 45 deg angle
		v0 = 15;
		
		v0_x = v0*Math.cos(theta);
		vf_x = v0_x;
		a_x = 0;
		
		v0_y = v0*Math.sin(theta);
		a_y = -9.8;	
		
		showPath = true;
		pathCoords = new ArrayList<Integer[]>();
	}
	
	public void addCoordinate(Integer x, Integer y) {
		Integer[] coord = {x, y};
		pathCoords.add(coord);
	}

	public void incrementObjectTimeBy(double time) {
		t += time;
		
		if(pathCounter == Constants.PATH_RESOLUTION) {
			addCoordinate(getXPos(), getYPos());
			pathCounter = 1;	// resets the path counter
		}
		pathCounter++;
		
	}
	
	public void calculateVelocityComponents() {
		v0_x = v0*Math.cos(theta);
		v0_y = v0*Math.sin(theta);
	}
	
	public void showPathTrajectory(boolean show) {
		showPath = show;
	}
	public void simulateMotion() {
		for(int i = 0; i < 10; i++) {
			t = i;
			
			xf = getXInitial() + (v0_x * t);				// total x traveled
			
			vf_y = v0_y + a_y*t;				// solve for velocity (in y-direction)
			yf = getYInitial() + (v0_y * t) + (0.5 * a_y * Math.pow(t, 2));	// solve for position (in y-direction)

			System.out.println("xf: " + xf + ", yf: " + yf);
		}
	}
	
	public void setTrajectoryAngleInDegrees(double deg) {
		theta = deg * (Math.PI/180);
		calculateVelocityComponents();
	}
	
	public void setInitialVelocity(int velocity) {
		v0 = velocity;
		calculateVelocityComponents();
	}
	
	public double getTime() {
		return t;
	}
	
	public int getXPos() {
		xf = getXInitial() + (v0_x*t); 			// in (meters)
		int xPos = (int) (xf * Grid.PIXELS_PER_METER);	// converts x position in meters to pixels
		xPos += Constants.FLOOR_X;		// shifts the object based off of where the floor starts
		xPos -= CENTER_X;				// places object relative to its midpoint
		return xPos;					// in (pixels)
	}
	
	public int getYPos() {
		vf_y = v0_y + a_y*t;									// solve for velocity (in y-direction)
		yf = getYInitial() + (v0_y * t) + (0.5 * a_y * Math.pow(t, 2));	// solve for position (in y-direction)
		
		int yPos = (int) (yf * Grid.PIXELS_PER_METER);		// converts the y position in meters to pixels
		yPos = Constants.FLOOR_Y - yPos;						// make y position relative to the floor
		yPos -= CENTER_Y;										// places object relative to its midpoint
		return yPos;
	}
	
	public String toString() {
		return  "t: " + t + ", theta: " + theta + 
				"\txf: " + xf + ", vf_x: " + vf_x + ", a_x: " + a_x + "\n" +
				"\tyf: " + yf + ", vf_y: " + vf_y + ", a_y: " + a_y;
	}
	
}
