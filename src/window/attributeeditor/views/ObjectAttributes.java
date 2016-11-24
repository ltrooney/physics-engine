package window.attributeeditor.views;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import constants.Constants;

public class ObjectAttributes extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel objectPropertiesLabel;
	private JLabel colorLabel;
	private JComboBox<String> colorList;
	private JLabel massLabel;
	private JSpinner massSpinner;
	private JLabel widthLabel;
	private JSpinner widthSpinner;
	private JLabel heightLabel;
	private JSpinner heightSpinner;
	private JLabel xPosLabel;
	private JSpinner xPosSpinner;
	private JLabel yPosLabel;
	private JSpinner yPosSpinner;
	private JLabel currentVelocityLabel;
	private JLabel angleLabel;
	private JSpinner velocitySpinner;
	private JSpinner angleSpinner;
	private JLabel showTrajectoryLabel;
	private JCheckBox showTrajectoryCB;
	
	
	public ObjectAttributes() {
		setMaximumSize(new Dimension(Constants.EDITOR_WIDTH, Constants.OBJECT_VIEW_HEIGHT));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
				
		JPanel titleView = new JPanel();
		titleView.setLayout(new BoxLayout(titleView, BoxLayout.X_AXIS));
		objectPropertiesLabel = new JLabel("Object Properties");
		titleView.add(objectPropertiesLabel);
		add(titleView);
			
		// color attribute
		JPanel colorView = new JPanel();
		colorView.setLayout(new BoxLayout(colorView, BoxLayout.X_AXIS));
		colorLabel = new JLabel("Color: ");
		colorView.add(colorLabel);
		
		
		String[] colors = {"Black", "Blue", "Red", "Green", "Purple" };
		colorList = new JComboBox<String>(colors);
		colorList.addActionListener(this);
		colorList.setSelectedIndex(1);
		colorView.add(colorList);
		add(colorView);
				
		// width attribute
		widthLabel = new JLabel("width: ");
		widthSpinner = createSpinner(1.0, 0.1, 20, 0.5);
		widthSpinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {}
		});
	
		JPanel widthView = makeLabelAndSpinnerView(widthLabel, widthSpinner);
		add(widthView);
		
		// height attribute
		heightLabel = new JLabel("height: ");		
		heightSpinner = createSpinner(1.0, 0.1, 20, 0.5);
		heightSpinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {}
		});
		
		JPanel heightView = makeLabelAndSpinnerView(heightLabel, heightSpinner);
		add(heightView);
		
		// mass attribute
		massLabel = new JLabel("mass: ");		
		massSpinner = createSpinner(1.0, 0.1, 50, 1.0);
		massSpinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {}
		});

		JPanel massView = makeLabelAndSpinnerView(massLabel, massSpinner);
		add(massView);
		
		// x position attribute
		xPosLabel = new JLabel("x position: ");		
		xPosSpinner = createSpinner(5.0, 0.0, 100.0, 1.0);
		xPosSpinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {}
		});
		JPanel xPosView = makeLabelAndSpinnerView(xPosLabel, xPosSpinner);
		add(xPosView);
		
		
		// y position attribute 
		yPosLabel = new JLabel("y position: ");		
		yPosSpinner = createSpinner(0, 0.0, 100.0, 1.0);
		yPosSpinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {}
		});
		JPanel yPosView = makeLabelAndSpinnerView(yPosLabel, yPosSpinner);
		add(yPosView);
		
		
		// velocity attribute
		currentVelocityLabel = new JLabel("Velocity: ");		
		velocitySpinner = createSpinner(15.0, -500.0, 500.0, 1.0);
		velocitySpinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {}
		});
		JPanel currentVelocityView = makeLabelAndSpinnerView(currentVelocityLabel, 		velocitySpinner);
		add(currentVelocityView);
		
		// angle attribute
		angleLabel = new JLabel("Angle: ");		
		angleSpinner = createSpinner(60, -179, 180, 1.0);
		angleSpinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {}
		});
		JPanel angleView = makeLabelAndSpinnerView(angleLabel, angleSpinner);
		add(angleView);
		
		// show trajectory check box
		JPanel trajectoryView = new JPanel();
		trajectoryView.setLayout(new BoxLayout(trajectoryView, BoxLayout.X_AXIS));
		showTrajectoryLabel = new JLabel("Show path trajectory");
		showTrajectoryCB = new JCheckBox();
		
		trajectoryView.add(showTrajectoryLabel);
		trajectoryView.add(showTrajectoryCB);
		add(trajectoryView);
	}
	
	private JSpinner createSpinner(double value, double min, double max, double stepSize) {
		JSpinner spinner = new JSpinner(new SpinnerNumberModel(value, min, max, stepSize));
		Component spinnerEditor = spinner.getEditor();
		JFormattedTextField jftf = ((JSpinner.DefaultEditor) spinnerEditor).getTextField();
		jftf.setColumns(3);
		return spinner;
	}
	
	private JPanel makeLabelAndSpinnerView(JLabel label, JSpinner spinner) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.setMaximumSize(new Dimension(Constants.EDITOR_WIDTH, 25));
		panel.add(label);		
		panel.add(spinner);
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// colorList
		// massSpinner
		// widthSpinner
		// heightSpinner
		// xPosSpinner
		// yPosSpinner
		// velocitySpinner
		// angleSpinner
		// showTrajectoryCB
		if(e.getSource() == colorList) { 
			System.out.println("color");
		} else if(e.getSource() == massSpinner) { 
			System.out.println("spinner");
		} else if(e.getSource() == widthSpinner) { 
			
		} else if(e.getSource() == heightSpinner) { 
			
		} else if(e.getSource() == xPosSpinner) { 
			
		} else if(e.getSource() == yPosSpinner) { 
			
		} else if(e.getSource() == velocitySpinner) { 
			
		} else if(e.getSource() == angleSpinner) { 
			
		} else if(e.getSource() == showTrajectoryCB) { 
			
		} else {}
	}
	
}
