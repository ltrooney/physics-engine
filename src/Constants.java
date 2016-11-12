
public class Constants {

	// engine
	public static final int ENG_WIDTH = 1000;						// width of engine
	public static final int ENG_HEIGHT = 750;						// height of engin
	public static final String ENG_TITLE = "Physics Engine v1.0";	// title of engine
	
	public static final int METERS_IN_X = 50;								// # of meters on the x-axis
	
	// conversion
	public static final int PIXELS_PER_METER = ENG_WIDTH / METERS_IN_X;		// # pixels / 1 meter 
	
	
	// grid
	public static final int GRID_TICK_SIZE = 7;						// length/width of a grid tick
	public static final int TICK_OFFSET = 5;						// number of meters between each tick
	public static final int Y_TICK_START = ENG_HEIGHT - 100;		// y position of first y-axis tick
	public static final int X_TICK_START = 65;						// x position of first x-axis tick
	
	// environment objects
	public static final int FLOOR_Y = Y_TICK_START;					// y position of floor
	public static final int FLOOR_X = X_TICK_START;					// x position of floor
	
	// clock
	public static final int TICK_SPEED = 28;						// number of millis the thread pauses for
	public static final int FRAMES_PER_SECOND = 30;
}
