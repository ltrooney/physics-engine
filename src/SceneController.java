import window.Engine;


public class SceneController {
	
	private static boolean isPlaying;
	
	public boolean isPlaying() {
		return isPlaying;
	}

	public SceneController() {
		isPlaying = false;
	}

	public static void play() {
		isPlaying = true;
	}
	public static void pause() {
		isPlaying = !isPlaying;
	}
	public static void reset() {
		isPlaying = false;
		Engine.setSimulationTimeElapsed(0.0);
	}
	public void skip() {}
	
}
