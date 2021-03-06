package objects;

import java.awt.Color;
import java.util.ArrayList;

import window.Engine;
import window.Grid;
import constants.Constants;

public class DynamicObject extends Object {
	
	private double initialSimulationTime; // simulation time that the object is created
	private Color c;
	
	private double t; 
	private double theta; 		// in radians
	private double v0;
	
	// X:
	private double xf, vf_x, v0_x, a_x;	
	
	// Y:
	private double yf, vf_y, v0_y, a_y;
	
	private int pathCounter = 0;	// # of iterations that passed since last path line drawn
	public boolean showPath;
	public ArrayList<Integer[]> pathCoords;

	public DynamicObject() {
		super();	// call Object()
		c = Color.BLACK;

		initialSimulationTime = Engine.getSimulationTimeElapsed();
		t = 0.0;
		theta = Math.PI/4;		// 45 deg angle
		v0 = 15;
		
		v0_x = v0*Math.cos(theta);
		vf_x = v0_x;
		a_x = 0;
		
		v0_y = v0*Math.sin(theta);
		a_y = -9.8;	
		
		showPath = false;
		pathCoords = new ArrayList<Integer[]>();
	}
	
	public void addCoordinate(Integer x, Integer y) {
		if(pathCounter != Constants.PATH_RESOLUTION) {
			Integer[] coord = {x, y};
			pathCoords.add(coord);
			pathCounter++;
		} else {
			pathCounter = 0;
		}
	}
	
	public void resetCoordinates() {
		pathCoords.clear();
	}
	
	public void calculateVelocityComponents() {
		v0_x = v0*Math.cos(theta);
		v0_y = v0*Math.sin(theta);
	}
	
	public void showPathTrajectory(boolean show) {
		showPath = show;
	}
	public boolean shouldShowPath() {
		return showPath;
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
	
	public void setColor(Color color) {
		c = color;
	}
	
	public void setColorString(String color) {
		if(color.equalsIgnoreCase("black")) {
			setColor(Color.BLACK);
		} else if(color.equalsIgnoreCase("blue")) {
			setColor(Color.BLUE);
		} else if(color.equalsIgnoreCase("red")) {
			setColor(Color.RED);
		} else if(color.equalsIgnoreCase("green")) {
			setColor(Color.GREEN);
		} else if(color.equalsIgnoreCase("cyan")) {
			setColor(Color.CYAN);
		}
	}
	
	public void setTrajectoryAngleInDegrees(double deg) {
		theta = deg * (Math.PI/180);
		calculateVelocityComponents();
	}
	
	public void setInitialVelocity(double d) {
		v0 = d;
		calculateVelocityComponents();
	}
	
	public double getTime() {
		return Engine.getSimulationTimeElapsed() - initialSimulationTime;
	}
	
	public Color getColor() {
		return c;
	}
	
	public int getXPos() {
		double t = getTime();
		xf = getXInitial() + (v0_x*t); 					// in (meters)
		int xPos = (int) (xf * Grid.PIXELS_PER_METER);	// converts x position in meters to pixels
		xPos += Constants.FLOOR_X;		// shifts the object based off of where the floor starts
		xPos -= getRadiusInPixels();				// places object relative to its midpoint
		return xPos;					// in (pixels)
	}
	
	public int getYPos() {
		double t = getTime();
		vf_y = v0_y + a_y*t;									// solve for velocity (in y-direction)
		yf = getYInitial() + (v0_y * t) + (0.5 * a_y * Math.pow(t, 2));	// solve for position (in y-direction)
		
		int yPos = (int) (yf * Grid.PIXELS_PER_METER);		// converts the y position in meters to pixels
		yPos = Constants.FLOOR_Y - yPos;						// make y position relative to the floor
		yPos -= getRadiusInPixels();										// places object relative to its midpoint
		return yPos;
	}
	
	public double getInitialVelocity() {
		return v0;
	}
	
	public double getTrajectoryAngle() {
		return theta;
	}
	
	public String toString() {
		return  "t: " + getTime() + ", theta: " + theta + 
				"\txf: " + xf + ", vf_x: " + vf_x + ", a_x: " + a_x + "\n" +
				"\tyf: " + yf + ", vf_y: " + vf_y + ", a_y: " + a_y;
	}
	
}
