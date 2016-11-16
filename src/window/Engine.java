package window;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import objects.DynamicObject;
import constants.Constants;

public class Engine extends JFrame {	
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<DynamicObject> dynamicObjects;
	private Grid grid;
	private AttributeEditor valueChanger;
	private Scene scene;
	
	public Engine() {
		scene = new Scene();
		valueChanger = new AttributeEditor();
		setLayout(new BorderLayout());
		setContentPane(new DrawPane());
		setMinimumSize(new Dimension(Constants.ENG_WIDTH, Constants.ENG_HEIGHT));
		setMaximumSize(new Dimension(Constants.ENG_WIDTH, Constants.ENG_HEIGHT));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setTitle(Constants.ENG_TITLE);
		
		add(scene, BorderLayout.WEST);
		add(valueChanger, BorderLayout.EAST);
		pack();
				
		dynamicObjects = new ArrayList<DynamicObject>();
		grid = new Grid();
		grid.setRange(50);
	}
	
	public Grid getGrid() {
		return grid;
	}
	
	public void addDynamicObject(DynamicObject o) {
		dynamicObjects.add(o);
	}
	
	class DrawPane extends JPanel {	

		private static final long serialVersionUID = 1L;
		long start = System.currentTimeMillis();
		long now;
		
		int frames = 0;
		double timeDifference = 1000;	// tracks the amount of time taken to render 30 frames
		
		public void paintComponent(Graphics g) {	
			
			// draw floor
			g.drawLine(Constants.FLOOR_X, Constants.FLOOR_Y, Constants.ENG_WIDTH, Constants.FLOOR_Y);
			
			// draw grid marks for y axis
			int meter = 0;
			for(int y = Grid.Y_TICK_START; y >= 0; y -= Grid.TICK_GAP) {
				g.drawLine(0, y, Grid.GRID_TICK_SIZE, y);
				g.drawString(String.valueOf(meter) + "m", Grid.GRID_TICK_SIZE + 3, y);
				meter += Grid.TICK_OFFSET;
			}
			
			// draw grid marks for x axis
			meter = 0;
			for(int x = Grid.X_TICK_START; x <= Constants.SCENE_WIDTH; x += Grid.TICK_GAP) {
				g.drawLine(x, Constants.SCENE_HEIGHT - Grid.GRID_TICK_SIZE-23, x, Constants.SCENE_HEIGHT);
				g.drawString(String.valueOf(meter) + "m", x+7, Constants.SCENE_HEIGHT-28);
				meter += Grid.TICK_OFFSET;
			}
			
			// update dynamic objects
			for(DynamicObject obj : dynamicObjects) {
				g.setColor(obj.getColor());
				
				//System.out.println(obj + "\n");
				
				// draw the object and add its grid coordinate
				g.fillRect(obj.getXPos(), obj.getYPos(), obj.getWidth(), obj.getHeight());
				
				
				// draw the trajectory path
				if(obj.showPath) {
					for(int i = 1; i < obj.pathCoords.size(); i++) {
						int currX, currY, lastX, lastY;
						Integer[] lastCoord = obj.pathCoords.get(i-1);
						Integer[] currCoord = obj.pathCoords.get(i);
						currX = (int) currCoord[0];
						currY = (int) currCoord[1];
						lastX = (int) lastCoord[0];;
				        lastY = (int) lastCoord[1];;
						g.drawLine(lastX, lastY, currX, currY);
					}
				}
				
				// temporary fix to synch the time of the object with 
				// the time of the engine update
				obj.incrementObjectTimeBy(0.033);
				//obj.incrementObjectTimeBy(double)Constants.FRAMES_PER_SECOND/timeDifference));
			}
			
			
			// pause the thread
			try {
				Thread.sleep(Constants.TICK_SPEED);		// 28 for 30 fps
			} catch (InterruptedException e) { e.printStackTrace(); }
			
			frames++;
			
			// updates the fps
			if(frames == Constants.FRAMES_PER_SECOND) {
				now = System.currentTimeMillis();
				timeDifference = now - start;
				System.out.println(Constants.FRAMES_PER_SECOND + " frames in " + timeDifference + " ms");
				start = now;
				frames = 0;
			}
			
			repaint();
		}
	}

}
