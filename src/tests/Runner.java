package tests;
import java.awt.Color;
import objects.DynamicObject;
import window.Engine;


public class Runner {
	public static void main(String[] args) {

		Engine engine = new Engine();
		DynamicObject obj1 = new DynamicObject();
		DynamicObject obj2 = new DynamicObject();
		DynamicObject obj3 = new DynamicObject();
		
		obj1.setTrajectoryAngleInDegrees(90);
		obj1.placeAt(5, 15);
		obj1.setInitialVelocity(25);
		obj1.setDimension(2, 2);
		
		obj2.showPathTrajectory(true);
		obj2.setColor(Color.BLUE);
		obj2.setInitialVelocity(20);
		obj2.placeAt(10, 0);
		obj2.setTrajectoryAngleInDegrees(70);
		
		obj3.showPathTrajectory(true);
		obj3.setColor(Color.RED);
		obj3.setInitialVelocity(20);
		obj3.placeAt(10, 0);
		obj3.setTrajectoryAngleInDegrees(20);
		
		engine.addDynamicObject(obj1);
		engine.addDynamicObject(obj2);
		engine.addDynamicObject(obj3);
		
		//obj1.simulateMotion();
	}
}
