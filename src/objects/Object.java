package objects;
import java.awt.Color;
import window.Grid;


public class Object {
	private int width;			// width in pixels
	private int height;		// height in pixels
	final int CENTER_Y = width/2;
	final int CENTER_X = height/2;
	
	Color c;
	
	private double x0, y0;
	
	public Object() {
		c = Color.BLACK;
		width = Grid.PIXELS_PER_METER;			// 1 meter width
		height = Grid.PIXELS_PER_METER;			// 1 meter height
		
		x0 = 5;
		y0 = 1;
	}
	
	public void setColor(Color color) {
		c = color;
	}
	
	public Color getColor() {
		return c;
	}
	
	public void setDimension(double w, double h) {
		// convert meters to pixels
		width = (int) (w*Grid.PIXELS_PER_METER);		
		height = (int) (h*Grid.PIXELS_PER_METER);
	}
	
	
	public void placeAt(int x, int y) {
		// converts meters to pixels for each measurement
		x0 = x;
		y0 = y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
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
