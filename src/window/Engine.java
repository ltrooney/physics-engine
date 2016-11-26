package window;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import objects.DynamicObject;
import window.attributeeditor.views.AttributeEditor;
import constants.Constants;

public class Engine extends JFrame {	
	
	private static final long serialVersionUID = 1L;
	
	private static AttributeEditor attrEditor;
	private Scene scene;
	private static double simulationTimeElapsed;
	private static double simulationTimeIncrement;		// # of seconds to increase the simulation time by in each refresh
	
	public Engine() {
		scene = new Scene();
		attrEditor = new AttributeEditor();
		
		setLayout(new BorderLayout());
		setContentPane(scene);
		setMinimumSize(new Dimension(Constants.ENG_WIDTH, Constants.ENG_HEIGHT));
		setMaximumSize(new Dimension(Constants.ENG_WIDTH, Constants.ENG_HEIGHT));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setTitle(Constants.ENG_TITLE);
		
		simulationTimeElapsed = 0.0;
		simulationTimeIncrement = Constants.TIME_INCREMENT; // 0.0333
		
		add(attrEditor, BorderLayout.EAST);
		pack();				
	}
	
	public Scene scene() {
		return scene;
	}
	
	public Grid grid() {
		return scene.grid();
	}
	
	public void addDynamicObject(DynamicObject o) {
		scene.addDynamicObject(o);
	}
	
	public void setTickOffset(int offs) {
		scene.grid().setTickOffset(offs);
	}
		
	public void setRange(int range) {
		scene.grid().setRange(range);
	}
	
	public static void setSimulationTimeElapsed(double time) {
		simulationTimeElapsed = time;
	}
	
	public static void setSimulationTimeIncrement(double time) {
		simulationTimeIncrement = time;
	}
	
	public static void incrementSimulationTimeBy(double time) {
		simulationTimeElapsed += time;
	}
	
	public static double getSimulationTimeElapsed() {
		return simulationTimeElapsed;
	}
	
	public static double getSimulationTimeIncrement() {
		return simulationTimeIncrement;
	}
	
	public static void updateObjectAttributesView() {
		attrEditor.getObjectView().updateView();;
	}

}
