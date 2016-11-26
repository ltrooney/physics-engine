package window.attributeeditor.views;


import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import constants.Constants;

public class EnvironmentAttributes extends GenericAttributesView {

	private static final long serialVersionUID = 1L;
	JLabel environment;
	JLabel gravityLabel;
	JSpinner gravitySpinner;

	public EnvironmentAttributes() {
		super();
		setSize(new Dimension(Constants.EDITOR_WIDTH, Constants.ENVIRONMENT_VIEW_HEIGHT));
		
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
}
