import java.awt.Color;
import java.util.ArrayList;


public class Object {
	int width;			// width in pixels
	int height	;		// height in pixels
	final int CENTER_Y = width/2;
	final int CENTER_X = height/2;
	
	int pathCounter = 1;	// # of iterations that passed since last path line drawn
	
	Color c;
	
	ArrayList<Integer[]> pathCoords;
	
	// shared variables
	double t; 				// initial start time (in sec)
	double theta; 			// in radians
	double v0;
	
	// X:
	double xf, x0, vf_x, v0_x, a_x;	
	
	// Y:
	double yf, y0, vf_y, v0_y, a_y;
	
	public Object() {
		c = Color.BLACK;
		width = Constants.PIXELS_PER_METER;			// 1 meter width
		height = Constants.PIXELS_PER_METER;		// 1 meter height
		
		t = 0.0;
		theta = Math.PI/4;							// 45 deg angle
		v0 = 15;
		
		x0 = 5;
		v0_x = v0*Math.cos(theta);
		vf_x = v0_x;
		a_x = 0;
		
		y0 = 1;
		v0_y = v0*Math.sin(theta);
		a_y = -9.8;	// positive due to inverted y axis, still assuming down as negative	
		
		pathCoords = new ArrayList<Integer[]>();
	}
	
	public void addCoordinate(Integer x, Integer y) {
		Integer[] coord = {x, y};
		pathCoords.add(coord);
	}
	
	public void setColor(Color color) {
		c = color;
	}
	
	public Color getColor() {
		return c;
	}
	
	public void setDimension(int w, int h) {
		// convert meters to pixels
		width = w*Constants.PIXELS_PER_METER;		
		height = h*Constants.PIXELS_PER_METER;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setTrajectoryAngleInDegrees(double deg) {
		theta = deg * (Math.PI/180);
		calculateVelocityComponents();
	}
	
	public void placeAt(int x, int y) {
		// converts meters to pixels for each measurement
		x0 = x;
		y0 = y;
	}
	
	public void setInitialVelocity(int velocity) {
		v0 = velocity;
		calculateVelocityComponents();
	}
	
	public int getXPos() {
		xf = x0 + (v0_x*t); 			// in (meters)
		int xPos = (int) (xf * Constants.PIXELS_PER_METER);	// converts x position in meters to pixels
		xPos += Constants.FLOOR_X;		// shifts the object based off of where the floor starts
		xPos -= CENTER_X;				// places object relative to its midpoint
		return xPos;					// in (pixels)
	}
	
	public int getYPos() {
		vf_y = v0_y + a_y*t;									// solve for velocity (in y-direction)
		yf = y0 + (v0_y * t) + (0.5 * a_y * Math.pow(t, 2));	// solve for position (in y-direction)
		
		int yPos = (int) (yf * Constants.PIXELS_PER_METER);		// converts the y position in meters to pixels
		yPos = Constants.FLOOR_Y - yPos;						// make y position relative to the floor
		yPos -= CENTER_Y;										// places object relative to its midpoint
		return yPos;
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
	
	public void simulateMotion() {
		for(int i = 0; i < 10; i++) {
			t = i;
			
			xf = x0 + (v0_x * t);				// total x traveled
			
			vf_y = v0_y + a_y*t;				// solve for velocity (in y-direction)
			yf = y0 + (v0_y * t) + (0.5 * a_y * Math.pow(t, 2));	// solve for position (in y-direction)

			System.out.println("xf: " + xf + ", yf: " + yf);
		}
	}
	
	public String toString() {
		return  "t: " + t + ", theta: " + theta + 
				"\txf: " + xf + ", vf_x: " + vf_x + ", a_x: " + a_x + "\n" +
				"\tyf: " + yf + ", vf_y: " + vf_y + ", a_y: " + a_y;
	}
}
