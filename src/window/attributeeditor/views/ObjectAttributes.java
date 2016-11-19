package window.attributeeditor.views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private GridBagConstraints c;
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
		setSize(new Dimension(Constants.EDITOR_WIDTH, Constants.OBJECT_VIEW_HEIGHT));
		setBackground(Color.WHITE);
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		
		int y = 0;
		
		objectPropertiesLabel = new JLabel("Object Properties");
		c.gridx = 0;
		c.gridy = y++;
		add(objectPropertiesLabel, c);
			
		// color attribute
		colorLabel = new JLabel("Color: ");
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = y;
		add(colorLabel, c);
		
		String[] colors = {"Black", "Blue", "Red", "Green", "Purple" };
		colorList = new JComboBox<String>(colors);
		colorList.addActionListener(this);
		colorList.setSelectedIndex(1);
		c.gridx = 1;
		c.gridy = y++;
		add(colorList, c);
				
		// width attribute
		widthLabel = new JLabel("width: ");
		c.gridx = 0;
		c.gridy = y;
		add(widthLabel, c);
		
		widthSpinner = createSpinner(1.0, 0.1, 20, 0.5);
		widthSpinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {}
		});
		
		c.gridx = 1;
		c.gridy = y++;
		add(widthSpinner, c);
		
		// height attribute
		heightLabel = new JLabel("height: ");
		c.gridx = 0;
		c.gridy = y;
		add(heightLabel, c);
		
		heightSpinner = createSpinner(1.0, 0.1, 20, 0.5);
		heightSpinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {}
		});
		c.gridx = 1;
		c.gridy = y++;
		add(heightSpinner, c);
		
		// mass attribute
		massLabel = new JLabel("mass: ");
		c.gridx = 0;
		c.gridy = y;
		add(massLabel, c);
		
		massSpinner = createSpinner(1.0, 0.1, 50, 1.0);
		massSpinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {}
		});
		c.gridx = 1;
		c.gridy = y++;
		add(massSpinner, c);
		
		// x position attribute
		xPosLabel = new JLabel("x position: ");
		c.gridx = 0;
		c.gridy = y;
		add(xPosLabel, c);
		
		xPosSpinner = createSpinner(5.0, 0.0, 100.0, 1.0);
		xPosSpinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {}
		});
		c.gridx = 1;
		c.gridy = y++;
		add(xPosSpinner, c);
		
		// y position attribute 
		yPosLabel = new JLabel("y position: ");
		c.gridx = 0;
		c.gridy = y;
		add(yPosLabel, c);
		
		yPosSpinner = createSpinner(0, 0.0, 100.0, 1.0);
		yPosSpinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {}
		});
		c.gridx = 1;
		c.gridy = y++;
		add(yPosSpinner, c);
		
		// velocity attribute
		currentVelocityLabel = new JLabel("Velocity: ");
		c.gridx = 0;
		c.gridy = y;
		add(currentVelocityLabel, c);
		
		velocitySpinner = createSpinner(15.0, -500.0, 500.0, 1.0);
		velocitySpinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {}
		});
		c.gridx = 1;
		c.gridy = y++;
		add(velocitySpinner, c);
		
		
		// angle attribute
		angleLabel = new JLabel("Angle: ");
		c.gridx = 0;
		c.gridy = y;
		add(angleLabel, c);
		
		angleSpinner = createSpinner(60, -179, 180, 1.0);
		angleSpinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {}
		});
		c.gridx = 1;
		c.gridy = y++;
		add(angleSpinner, c);
		
		// show trajectory check box
		showTrajectoryLabel = new JLabel("Show path trajectory");
		c.gridx = 0;
		c.gridy = y;
		add(showTrajectoryLabel, c);
		
		showTrajectoryCB = new JCheckBox();
		c.gridx = 1;
		c.gridy = y++;
		add(showTrajectoryCB, c);
	}
	
	private JSpinner createSpinner(double value, double min, double max, double stepSize) {
		JSpinner spinner = new JSpinner(new SpinnerNumberModel(value, min, max, stepSize));
		Component spinnerEditor = spinner.getEditor();
		JFormattedTextField jftf = ((JSpinner.DefaultEditor) spinnerEditor).getTextField();
		jftf.setColumns(3);
		return spinner;
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
