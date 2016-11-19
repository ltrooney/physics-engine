package objects;
import java.awt.Color;
import window.Grid;


public class Object {
	private double width;		// width in meters
	private double height;		// height in meters
	private double radius;
	
	Color c;
	
	private double x0, y0;
	
	public Object() {
		c = Color.BLACK;
		width = 1;			// 1 meter width
		height = 1;			// 1 meter height
		radius = width/2;
		
		x0 = 5;
		y0 = 1;
	}
	
	public void setColor(Color color) {
		c = color;
	}
	
	public void setDimension(double w, double h) {
		// convert meters to pixels
		width = w;		
		height = h;
	}
	
	public void placeAt(int x, int y) {
		// converts meters to pixels for each measurement
		x0 = x;
		y0 = y;
	}
	
	public Color getColor() {
		return c;
	}
	
	public double getWidthInMeters() {
		return width;
	}
	
	public double getHeightInMeters() {
		return height;
	}
	
	public double getRadiusInMeters() {
		return radius;
	}
	
	public int getWidthInPixels() {
		return (int) (width*Grid.PIXELS_PER_METER);
	}
	
	public int getHeightInPixels() {
		return (int) (height*Grid.PIXELS_PER_METER);
	}
	
	public int getRadiusInPixels() {
		return (int) (width/2 * Grid.PIXELS_PER_METER);
	}
	
	public double getXInitial() { return x0; }
	public double getYInitial() { return y0; }
	
	public int getXPos() {
		return (int) (x0 * Grid.PIXELS_PER_METER);	// in (pixels)
	}
	
	public int getYPos() {
		return (int) (y0 * Grid.PIXELS_PER_METER);	// in (pixels)
	}
	
	public String toString() {
		return  "x: " + x0 + ", y: " + y0;
	}
}
