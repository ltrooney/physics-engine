
public class Runner {
	public static void main(String[] args) {

		Engine engine = new Engine();
		Object obj1 = new Object();
		
		obj1.setInitialVelocity(0);
		obj1.setTrajectoryAngleInDegrees(90);
		
		engine.addObject(obj1);
		
		//obj1.simulateMotion();
	}
}
