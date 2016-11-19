package window.attributeeditor.views;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToolBar;

import window.Scene;
import constants.Constants;

public class SimulationAttributes extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel simulation;
	
	private JToolBar buttons;	// tool bar for simulation buttons
	private JButton reset;
	private JButton play;
	private JButton pause;
	private JButton forward;
	private JSlider fastForwardSlider;
	
	public SimulationAttributes() {
		setSize(new Dimension(Constants.EDITOR_WIDTH, Constants.SIMULATION_VIEW_HEIGHT));
		simulation = new JLabel("Simulation");
		buttons = new JToolBar();
		reset = makeNavigationButton("reset", "reset", "Restarts the simulation", "Reset");
		play = makeNavigationButton("play", "play", "Plays the simulation", "Play");
		pause = makeNavigationButton("pause", "pause", "Pauses the simulation", "Pause");
		forward = makeNavigationButton("skip", "skip", "Skips to the end of the simulation", "Skip");
		
		buttons.setRollover(true);
		buttons.add(reset);
		buttons.add(play);
		buttons.add(pause);
		buttons.add(forward);
		
		add(simulation);
		add(buttons);
		
		fastForwardSlider = new JSlider(JSlider.HORIZONTAL, 100, 2000, 100);
		add(fastForwardSlider);
	}
	
	protected JButton makeNavigationButton(String imageName,
	            String actionCommand,
	            String toolTipText,
	            String altText) {
		//Look for the image.
		String imgLocation = "/images/" + imageName + ".png";
		URL imageURL = SimulationAttributes.class.getResource(imgLocation);
		
		//Create and initialize the button.
		JButton button = new JButton();
		button.setActionCommand(actionCommand);
		button.setToolTipText(toolTipText);
		button.addActionListener(this);
		
		if (imageURL != null) {                      //image found
			button.setIcon(new ImageIcon(imageURL, altText));
		} else {                                     //no image found
			button.setText(altText);
			System.err.println("Resource not found: " + imgLocation);
		}
		
		return button;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == reset) {
			Scene.reset();
		} else if(e.getSource() == play) {
			Scene.play();
		} else if(e.getSource() == pause) {
			Scene.pause();
		} else if(e.getSource() == forward) {
			Scene.skip();
		}
	}
}
