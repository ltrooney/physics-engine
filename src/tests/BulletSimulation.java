package tests;

import objects.DynamicObject;
import window.Engine;

public class BulletSimulation {

	public static void main(String[] args) {
		Engine engine = new Engine();
		DynamicObject obj1 = new DynamicObject();
		
		obj1.setDimension(0.05, 0.05);
		obj1.setTrajectoryAngleInDegrees(0);
		obj1.setInitialVelocity(400);
		obj1.placeAt(0, 5);
		engine.setRange(500);
		engine.setTickOffset(50);
		engine.addDynamicObject(obj1);		
	}

}
