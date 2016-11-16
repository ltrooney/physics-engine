package window.attributeeditor;


import javax.swing.JLabel;
import javax.swing.JPanel;

public class EnvironmentAttributes extends JPanel {

	private static final long serialVersionUID = 1L;
	JLabel environment;

	public EnvironmentAttributes() {
		environment = new JLabel("Environment");
		
		add(environment);
	}
}
