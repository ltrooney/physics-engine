package window.attributeeditor.views;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import constants.Constants;

public class AttributeEditor extends JPanel {
	
	/*
	 * Functionality:
	 * 1. When an object in the scene is clicked on, the attribute editor
	 * 	  should display properties for that object.
	 * 2. Buttons for play, pause, restart, and fast forward. Buttons should only be 
	 *    clickable when they can be.
	 * 3. User can change different fields for that object, then click
	 *    "restart" to play the simulation w/ new values.
	 */
	
	private static final long serialVersionUID = 1L;
	
	SimulationAttributes simulationView;
	ObjectAttributes objectView;
	EnvironmentAttributes envView;
	
	
	public AttributeEditor() {
		setBackground(new Color(230, 230, 230));
		setPreferredSize(new Dimension(Constants.EDITOR_WIDTH, Constants.ENG_HEIGHT));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		simulationView = new SimulationAttributes();
		objectView = new ObjectAttributes();
		envView = new EnvironmentAttributes();

		add(simulationView);
		add(objectView);
		add(envView);
	}
	
}
