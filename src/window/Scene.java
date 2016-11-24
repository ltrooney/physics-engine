package window;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import objects.DynamicObject;
import window.attributeeditor.views.ObjectAttributes;
import constants.Constants;

public class Scene extends JPanel implements MouseListener {

	private static ArrayList<DynamicObject> dynamicObjects;
	private static final long serialVersionUID = 1L;
	private Grid grid;
	private static boolean isPlaying;
	private static double skipIncrement;
	
	long start = System.currentTimeMillis();
	long now;
	
	int frames = 0;
	double timeDifference = 1000;	// tracks the amount of time taken to render 30 frames
	
	public Scene() {
		grid = new Grid();		
		dynamicObjects = new ArrayList<DynamicObject>();
		isPlaying = true;
		skipIncrement = 0.5;
		addMouseListener(this);
		
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT));
	}
	
	public static void play() {
		isPlaying = !isPlaying;
	}
	public static void pause() {
		isPlaying = !isPlaying;
	}
	public static void reset() {
		isPlaying = false;
		Engine.setSimulationTimeElapsed(0.0);
		
		for(DynamicObject obj : dynamicObjects) {
			obj.resetCoordinates();
		}
	}
	public static void skip() {
		Engine.setSimulationTimeElapsed(Engine.getSimulationTimeElapsed() + skipIncrement);
	}
	
	public static void setSkipIncrement(double inc) {
		skipIncrement = inc;
	}
	
	public void addDynamicObject(DynamicObject o) {
		o.addCoordinate(o.getXPos(), o.getYPos());
		dynamicObjects.add(o);
	}
	
	public void drawGrid(Graphics g) {
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
	}
	
	public void drawObjects(Graphics g) {
		// update dynamic objects
		for(DynamicObject obj : dynamicObjects) {
			g.setColor(obj.getColor());
			
			// updates the path coordinates
			if(obj.shouldShowPath()) {
				obj.addCoordinate(obj.getXPos(), obj.getYPos());
			}
			
			//System.out.println(obj + "\n");
			
			// draw the object and add its grid coordinate
			g.fillRect(obj.getXPos()-obj.getRadiusInPixels(), obj.getYPos()-obj.getRadiusInPixels(), obj.getWidthInPixels(), obj.getHeightInPixels());
			
					
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
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
				
		if(isPlaying) {
			Engine.incrementSimulationTimeBy(Engine.getSimulationTimeIncrement());
		}
		
		// draw floor
		g.drawLine(Constants.FLOOR_X, Constants.FLOOR_Y, Constants.ENG_WIDTH, Constants.FLOOR_Y);
		drawGrid(g);
		drawObjects(g);
		
		// pause the thread
		try {
			Thread.sleep(Constants.TICK_SPEED);		// 28 for 30 fps
		} catch (InterruptedException e) { e.printStackTrace(); }
		
		frames++;
		
		// updates the fps
		if(frames == Constants.FRAMES_PER_SECOND) {
			now = System.currentTimeMillis();
			timeDifference = now - start;
			//System.out.println(Constants.FRAMES_PER_SECOND + " frames in " + timeDifference + " ms, sim. time elapsed: " + Engine.getSimulationTimeElapsed());
			start = now;
			frames = 0;
		}
		
		repaint();
	}
	
	public Grid grid() {
		return grid;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for(DynamicObject obj : dynamicObjects) {
			if((e.getX() > obj.getXPos()-obj.getWidthInPixels()/2) && (e.getX() < obj.getXPos()+obj.getWidthInPixels()/2)) {
				if((e.getY() > obj.getYPos()-obj.getHeightInPixels()/2) && (e.getY() < obj.getYPos()+obj.getHeightInPixels()/2)) {
					ObjectAttributes.setFocusedObject(obj);
					return;
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	
	
}
