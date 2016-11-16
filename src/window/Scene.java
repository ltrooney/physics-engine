package window;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import constants.Constants;

public class Scene extends JPanel {

	private static final long serialVersionUID = 1L;

	public Scene() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT));
	}
}
