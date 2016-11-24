package constants;
import window.Grid;


public class Constants {

	// scene
	public static final int SCENE_WIDTH = 1000;
	public static final int SCENE_HEIGHT = 750;
	
	// attribute editor
	public static final int EDITOR_WIDTH = 250;
	public static final int SIMULATION_VIEW_HEIGHT = 250;
	public static final int OBJECT_VIEW_HEIGHT = 300;
	public static final int ENVIRONMENT_VIEW_HEIGHT = SCENE_HEIGHT - OBJECT_VIEW_HEIGHT - SIMULATION_VIEW_HEIGHT;
	
	public static final int SKIP_SLIDER_INITIAL_VAL = 500;
	public static final int SKIP_SLIDER_START = 50;
	public static final int SKIP_SLIDER_END = 1000;
	public static final int SKIP_SLIDER_NUM_TICKS = 20;
	public static final int SKIP_SLIDER_STEP = (SKIP_SLIDER_END - SKIP_SLIDER_START)/SKIP_SLIDER_NUM_TICKS;
	
	public static final int SPEED_SLIDER_INITIAL_VAL = 33;
	public static final int SPEED_SLIDER_START = 3;
	public static final int SPEED_SLIDER_END = 132;
	public static final int SPEED_SLIDER_NUM_TICKS = 20;
	public static final int SPEED_SLIDER_STEP = (SPEED_SLIDER_END - SPEED_SLIDER_START)/SPEED_SLIDER_NUM_TICKS;
	
	// engine
	public static final int ENG_WIDTH = SCENE_WIDTH + EDITOR_WIDTH;	// width of engine
	public static final int ENG_HEIGHT = SCENE_HEIGHT;				// height of engin
	public static final String ENG_TITLE = "Physics Engine v1.0";	// title of engine

	
	// path
	public static final int PATH_RESOLUTION = 3;					// higher value = lower resolution trajectory path
		
	// environment objects
	public static final int FLOOR_Y = Grid.Y_TICK_START;					// y position of floor
	public static final int FLOOR_X = Grid.X_TICK_START;					// x position of floor
	
	// clock
	public static final int TICK_SPEED = 26;						// number of millis the thread pauses for
	public static final int FRAMES_PER_SECOND = 30;
}
