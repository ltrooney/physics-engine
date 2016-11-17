package window.attributeeditor;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class ObjectAttributes extends JPanel {

	private static final long serialVersionUID = 1L;
	private GridBagConstraints c;
	private JLabel objectPropertiesLabel;
	private JLabel colorLabel;
	private JComboBox colorList;
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
	
	public ObjectAttributes() {
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
		colorList = new JComboBox(colors);
		colorList.setSelectedIndex(1);
		c.gridx = 1;
		c.gridy = y++;
		add(colorList, c);
				
		// dimension attributes
		widthLabel = new JLabel("width: ");
		c.gridx = 0;
		c.gridy = y;
		add(widthLabel, c);
		
		widthSpinner = createSpinner(1.0, 0.1, 20, 0.5);
		c.gridx = 1;
		c.gridy = y++;
		add(widthSpinner, c);
		
		heightLabel = new JLabel("height: ");
		c.gridx = 0;
		c.gridy = y;
		add(heightLabel, c);
		
		heightSpinner = createSpinner(1.0, 0.1, 20, 0.5);
		c.gridx = 1;
		c.gridy = y++;
		add(heightSpinner, c);
		
		// position attributes
		xPosLabel = new JLabel("x position: ");
		c.gridx = 0;
		c.gridy = y;
		add(xPosLabel, c);
		
		xPosSpinner = createSpinner(5.0, 0.0, 100.0, 1.0);
		c.gridx = 1;
		c.gridy = y++;
		add(xPosSpinner, c);
		
		yPosLabel = new JLabel("y position: ");
		c.gridx = 0;
		c.gridy = y;
		add(yPosLabel, c);
		
		yPosSpinner = createSpinner(0, 0.0, 100.0, 1.0);
		c.gridx = 1;
		c.gridy = y++;
		add(yPosSpinner, c);
		
		// velocity attribute
		currentVelocityLabel = new JLabel("Velocity: ");
		c.gridx = 0;
		c.gridy = y;
		add(currentVelocityLabel, c);
		
		
		velocitySpinner = createSpinner(15.0, -500.0, 500.0, 1.0);
		c.gridx = 1;
		c.gridy = y++;
		add(velocitySpinner, c);
		
		
		// angle attribute
		angleLabel = new JLabel("Angle: ");
		c.gridx = 0;
		c.gridy = y;
		add(angleLabel, c);
		
		angleSpinner = createSpinner(60, -179, 180, 1.0);
		c.gridx = 1;
		c.gridy = y++;
		add(angleSpinner, c);
	}
	
	private JSpinner createSpinner(double value, double min, double max, double stepSize) {
		JSpinner spinner = new JSpinner(new SpinnerNumberModel(value, min, max, stepSize));
		Component spinnerEditor = spinner.getEditor();
		JFormattedTextField jftf = ((JSpinner.DefaultEditor) spinnerEditor).getTextField();
		jftf.setColumns(3);
		return spinner;
	}
	
}
