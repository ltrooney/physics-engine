package window.attributeeditor.views;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import constants.Constants;

public class EnvironmentAttributes extends JPanel {

	private static final long serialVersionUID = 1L;
	private GridBagConstraints c;
	JLabel environment;

	public EnvironmentAttributes() {
		setSize(new Dimension(Constants.EDITOR_WIDTH, Constants.ENVIRONMENT_VIEW_HEIGHT));
		setLayout(new GridBagLayout());
		setBackground(Color.BLACK);
		c = new GridBagConstraints();
		
		environment = new JLabel("Environment");
		c.gridx = 0;
		c.gridy = 0;
		add(environment, c);
	}
}
