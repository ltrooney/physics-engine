import java.awt.Color;


public class Runner {
	public static void main(String[] args) {

		Engine engine = new Engine();
		Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = new Object();
		
		obj1.setTrajectoryAngleInDegrees(45);
		obj1.placeAt(5, 15);
		obj1.setInitialVelocity(10);
		
		obj2.setColor(Color.GREEN);
		obj2.setInitialVelocity(20);
		obj2.placeAt(10, 0);
		obj2.setTrajectoryAngleInDegrees(70);
		
		obj3.setColor(Color.RED);
		obj3.setInitialVelocity(20);
		obj3.placeAt(10, 0);
		obj3.setTrajectoryAngleInDegrees(20);
				
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) { e.printStackTrace(); }
		
		engine.addObject(obj1);
		engine.addObject(obj2);
		engine.addObject(obj3);
		
		//obj1.simulateMotion();
	}
}
