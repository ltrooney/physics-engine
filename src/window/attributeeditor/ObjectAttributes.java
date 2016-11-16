package window.attributeeditor;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class ObjectAttributes extends JPanel {

	private static final long serialVersionUID = 1L;
	private GridBagConstraints c;
	private JLabel objectPropertiesLabel;
	private JLabel colorLabel;
	private JLabel currentVelocityLabel;
	private JSpinner velocitySpinner;
	
	public ObjectAttributes() {
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		
		//c.weightx = 0.5;
		
		objectPropertiesLabel = new JLabel("Object Properties");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 3;
		c.gridheight = 1;
		c.gridx = 1;
		c.gridy = 0;
		add(objectPropertiesLabel, c);
		
		
		colorLabel = new JLabel("Color: Blue");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 1;
		add(colorLabel, c);
				
		currentVelocityLabel = new JLabel("Velocity: ");
		c.fill = GridBagConstraints.NONE;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 2;
		add(currentVelocityLabel, c);
		
		
		velocitySpinner = new JSpinner(new SpinnerNumberModel(15.0, -500.0, 500.0, 1.0));
		
		Component spinnerEditor = velocitySpinner.getEditor();
		JFormattedTextField jftf = ((JSpinner.DefaultEditor) spinnerEditor).getTextField();
		jftf.setColumns(3);
		c.fill = GridBagConstraints.NONE;
		c.gridx = 2;
		c.gridy = 2;
		add(velocitySpinner, c);
	}
	
}
