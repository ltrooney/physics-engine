package window;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

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
	
	private JLabel currentVelocityLabel;
	private JSlider velocitySlider;
	
	public AttributeEditor() {
		setPreferredSize(new Dimension(Constants.VCP_WIDTH, Constants.ENG_HEIGHT));
		currentVelocityLabel = new JLabel("Current velocity: ");
		
		velocitySlider = new JSlider(0, 50);
		velocitySlider.setValue(15);
		velocitySlider.setMajorTickSpacing(5);
		velocitySlider.setPaintTicks(true);
		
		add(currentVelocityLabel);
		add(velocitySlider);
	}
	
}
