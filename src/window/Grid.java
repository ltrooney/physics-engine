package window;
import constants.Constants;


public class Grid {
	
	public static int TICK_OFFSET;											// number of meters between each tick
	public static int METERS_IN_X;											// # of meters on the x-axis
	public static int PIXELS_PER_METER;										// # pixels / 1 meter
	public static int TICK_GAP;  											// number of pixels between each tick
	public static final int GRID_TICK_SIZE = 7;								// length/width of a grid tick
	public static final int Y_TICK_START = Constants.SCENE_HEIGHT - 100;		// y position of first y-axis tick
	public static final int X_TICK_START = 65;								// x position of first x-axis tick
	
	public Grid() {
		TICK_OFFSET = 5;
		METERS_IN_X = 50;
		calculateVariables();
	}
	
	public void calculateVariables() {
		PIXELS_PER_METER = Constants.SCENE_WIDTH / METERS_IN_X;
		TICK_GAP = PIXELS_PER_METER * TICK_OFFSET;
	}
	
	public void setTickOffset(int offs) {
		TICK_OFFSET = offs;
		calculateVariables();
	}
		
	public void setRange(int range) {
		// sets x axis range and accounts for the shift from the floor
		METERS_IN_X = range +  (Constants.FLOOR_X/PIXELS_PER_METER);
		System.out.println(METERS_IN_X + "m");
		calculateVariables();
	}
}
