package window.attributeeditor.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JSeparator;

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
		setPreferredSize(new Dimension(Constants.EDITOR_WIDTH, Constants.ENG_HEIGHT));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		simulationView = new SimulationAttributes();
		objectView = new ObjectAttributes();
		envView = new EnvironmentAttributes();

		add(simulationView);
		add(createSeparatorView());
		add(objectView);
		add(createSeparatorView());
		add(envView);
	}
	
	public ObjectAttributes getObjectView() {
		return objectView;
	}
	
	private JPanel createSeparatorView() {
		JPanel separatorView = new JPanel(new BorderLayout());
		separatorView.setBorder(BorderFactory.createEmptyBorder());
		separatorView.add(new JSeparator(JSeparator.HORIZONTAL));
		separatorView.setMinimumSize(new Dimension(Constants.EDITOR_WIDTH, 25));
		separatorView.setPreferredSize(new Dimension(Constants.EDITOR_WIDTH, 25));
		separatorView.setMaximumSize(new Dimension(Constants.EDITOR_WIDTH, 25));
		return separatorView;
	}
	
}
