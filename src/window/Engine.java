package window;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import objects.DynamicObject;
import window.attributeeditor.AttributeEditor;
import constants.Constants;

public class Engine extends JFrame {	
	
	private static final long serialVersionUID = 1L;
	
	private AttributeEditor valueChanger;
	private Scene scene;
	
	public Engine() {
		scene = new Scene();
		valueChanger = new AttributeEditor();
		
		setLayout(new BorderLayout());
		setContentPane(scene);
		setMinimumSize(new Dimension(Constants.ENG_WIDTH, Constants.ENG_HEIGHT));
		setMaximumSize(new Dimension(Constants.ENG_WIDTH, Constants.ENG_HEIGHT));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setTitle(Constants.ENG_TITLE);
		
		add(valueChanger, BorderLayout.EAST);
		pack();				
	}
	
	public Scene scene() {
		return scene;
	}
	
	public Grid grid() {
		return scene.grid();
	}
	
	public void addDynamicObject(DynamicObject o) {
		scene.addDynamicObject(o);
	}
	
	public void setTickOffset(int offs) {
		scene.grid().setTickOffset(offs);
	}
		
	public void setRange(int range) {
		scene.grid().setRange(range);
	}
	
	class DrawPane extends JPanel {	

		private static final long serialVersionUID = 1L;
		
	}

}
