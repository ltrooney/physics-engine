package window.attributeeditor.views;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToolBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import window.Engine;
import window.Scene;
import constants.Constants;

public class SimulationAttributes extends JPanel implements ActionListener, ChangeListener {

	private static final long serialVersionUID = 1L;
	private JLabel simulation;
	
	private JToolBar buttons;	// tool bar for simulation buttons
	private JButton reset;
	private JButton play;
	private JButton pause;
	private JButton forward;
	private JLabel fastForwardLabel;
	private JButton fastForwardReset;
	private JSlider fastForwardSlider;
	private JPanel fastForwardSliderView;
	private JLabel speedLabel;
	private JButton speedReset;
	private JSlider speedSlider;
	
	
	public SimulationAttributes() {
		setSize(new Dimension(Constants.EDITOR_WIDTH, Constants.SIMULATION_VIEW_HEIGHT));
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.add(new Box.Filler(new Dimension(10, 15), new Dimension(10, 15), new Dimension(10, 15)));
				
		simulation = new JLabel("Simulation");
		simulation.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(simulation);
		
		this.add(Box.createRigidArea(new Dimension(0, 5)));
		
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
		add(buttons);
		
		this.add(Box.createRigidArea(new Dimension(0, 15)));
		
		speedLabel = new JLabel("playback speed");
		speedReset = new JButton("reset");
		speedReset.addActionListener(this);

		speedSlider = new JSlider(JSlider.HORIZONTAL, Constants.SPEED_SLIDER_START, Constants.SPEED_SLIDER_END, 33);
		speedSlider.setPaintTicks(true);
		speedSlider.setMajorTickSpacing(6);
		speedSlider.setSnapToTicks(true);
		speedSlider.setValue(Constants.SPEED_SLIDER_INITIAL_VAL);
		speedSlider.addChangeListener(this);
		
		JPanel speedView = makeSliderWithLabels(speedLabel, speedReset, speedSlider);
		add(speedView);
		
		this.add(Box.createRigidArea(new Dimension(0, 20)));
		
		fastForwardLabel = new JLabel("ff speed");
		fastForwardReset = new JButton("reset");
		fastForwardReset.addActionListener(this);
		
		fastForwardSlider = new JSlider(JSlider.HORIZONTAL, Constants.SKIP_SLIDER_START, Constants.SKIP_SLIDER_END, 100);
		fastForwardSlider.setPaintTicks(true);
		fastForwardSlider.setMajorTickSpacing(Constants.SKIP_SLIDER_STEP);
		fastForwardSlider.setSnapToTicks(true);
		fastForwardSlider.setValue(Constants.SKIP_SLIDER_INITIAL_VAL);
		fastForwardSlider.addChangeListener(this);
		
		fastForwardSliderView = makeSliderWithLabels(fastForwardLabel, fastForwardReset, fastForwardSlider);
		add(fastForwardSliderView);
		
		this.add(Box.createRigidArea(new Dimension(0, 20)));
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
	
	private JPanel makeSliderWithLabels(JLabel label, JButton reset, JSlider slider) {
		JPanel aggregateView = new JPanel();
		aggregateView.setLayout(new BoxLayout(aggregateView, BoxLayout.Y_AXIS));
		aggregateView.setMaximumSize(new Dimension(Constants.EDITOR_WIDTH, 200));
		JPanel labelsView = new JPanel();
		labelsView.setLayout(new BoxLayout(labelsView, BoxLayout.X_AXIS));
		JPanel sliderView = new JPanel();
		sliderView.setLayout(new BoxLayout(sliderView, BoxLayout.X_AXIS));
		
		labelsView.add(label);
		labelsView.add(Box.createRigidArea(new Dimension(60, 0)));
		
		labelsView.add(reset);
		sliderView.add(slider);
		
		aggregateView.add(labelsView);
		aggregateView.add(sliderView);
		return aggregateView;
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
		
		if(e.getSource() == fastForwardReset) {
			fastForwardSlider.setValue(Constants.SKIP_SLIDER_INITIAL_VAL);
			Scene.setSkipIncrement(Constants.SKIP_SLIDER_INITIAL_VAL/1000);
		} else if(e.getSource() == speedReset) {
			speedSlider.setValue(Constants.SPEED_SLIDER_INITIAL_VAL);
			Engine.setSimulationTimeIncrement((double)Constants.SPEED_SLIDER_INITIAL_VAL/1000);
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider slider = (JSlider) e.getSource();
		if(slider == fastForwardSlider) {
			Scene.setSkipIncrement((double)slider.getValue()/1000);
		} else if(slider == speedSlider) {
			Engine.setSimulationTimeIncrement((double)slider.getValue()/1000);
		}
	}
}
