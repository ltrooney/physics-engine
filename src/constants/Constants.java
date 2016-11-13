package constants;
import window.Grid;


public class Constants {

	// engine
	public static final int ENG_WIDTH = 1000;						// width of engine
	public static final int ENG_HEIGHT = 750;						// height of engin
	public static final String ENG_TITLE = "Physics Engine v1.0";	// title of engine
	
	// path
	public static final int PATH_RESOLUTION = 3;					// higher value = lower resolution trajectory path
		
	// environment objects
	public static final int FLOOR_Y = Grid.Y_TICK_START;					// y position of floor
	public static final int FLOOR_X = Grid.X_TICK_START;					// x position of floor
	
	// clock
	public static final int TICK_SPEED = 28;						// number of millis the thread pauses for
	public static final int FRAMES_PER_SECOND = 30;
}
