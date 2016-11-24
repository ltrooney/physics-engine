package window.attributeeditor.views;


import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import constants.Constants;

public class EnvironmentAttributes extends JPanel {

	private static final long serialVersionUID = 1L;
	JLabel environment;
	JLabel gravityLabel;
	JSpinner gravitySpinner;

	public EnvironmentAttributes() {
		setSize(new Dimension(Constants.EDITOR_WIDTH, Constants.ENVIRONMENT_VIEW_HEIGHT));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel titleView = new JPanel();
		titleView.setLayout(new BoxLayout(titleView, BoxLayout.X_AXIS));
		environment = new JLabel("Environment");
		titleView.add(environment);
		add(titleView);
		
		gravityLabel = new JLabel("gravity: ");
		gravitySpinner = createSpinner(9.8, 0.1, 25.0, 0.2);
		JPanel gravityView = makeLabelAndSpinnerView(gravityLabel, gravitySpinner);
		add(gravityView);
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
}
