package window.attributeeditor.views;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import constants.Constants;

public class GenericAttributesView extends JPanel {
	
	private static final long serialVersionUID = 1L;

	public GenericAttributesView() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
	protected JSpinner createSpinner(double value, double min, double max, double stepSize) {
		JSpinner spinner = new JSpinner(new SpinnerNumberModel(value, min, max, stepSize));
		Component spinnerEditor = spinner.getEditor();
		JFormattedTextField jftf = ((JSpinner.DefaultEditor) spinnerEditor).getTextField();
		jftf.setColumns(3);
		return spinner;
	}
	
	protected JPanel makeLabelAndSpinnerView(JLabel label, JSpinner spinner) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.setMaximumSize(new Dimension(Constants.EDITOR_WIDTH, 25));
		panel.add(label);		
		panel.add(spinner);
		return panel;
	}
	
	protected JPanel makeSliderWithLabels(JLabel label, JButton reset, JSlider slider) {
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
	
}
