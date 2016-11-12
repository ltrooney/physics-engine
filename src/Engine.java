import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Engine extends JFrame {	
	
	private static final long serialVersionUID = 1L;
	
	ArrayList<Object> objects;
	
	public Engine() {
		setLayout(null);
		setContentPane(new DrawPane());
		setSize(Constants.ENG_WIDTH, Constants.ENG_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setTitle(Constants.ENG_TITLE);
				
		objects = new ArrayList<Object>();
	}
	
	public void addObject(Object o) {
		objects.add(o);
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
			for(int y = Constants.Y_TICK_START; y >= 0; y -= (Constants.PIXELS_PER_METER * Constants.TICK_OFFSET)) {
				g.drawLine(0, y, Constants.GRID_TICK_SIZE, y);
				g.drawString(String.valueOf(meter) + "m", Constants.GRID_TICK_SIZE + 3, y);
				meter += Constants.TICK_OFFSET;
			}
			
			// draw grid marks for x axis
			meter = 0;
			for(int x = Constants.X_TICK_START; x <= Constants.ENG_WIDTH; x += (Constants.PIXELS_PER_METER * Constants.TICK_OFFSET)) {
				g.drawLine(x, Constants.ENG_HEIGHT - Constants.GRID_TICK_SIZE-23, x, Constants.ENG_HEIGHT);
				g.drawString(String.valueOf(meter) + "m", x+7, Constants.ENG_HEIGHT-28);
				meter += Constants.TICK_OFFSET;
			}
			
			// draw every object in the scene
			for(Object obj : objects) {
				g.setColor(Color.BLACK);
				
				System.out.println(obj);
				g.fillRect(obj.getXPos(), obj.getYPos(), obj.getWidth(), obj.getHeight());
				
				
				// temporary fix to synch the time of the object with 
				// the time of the engine update
				obj.incrementObjectTimeBy(0.033);
				//obj.incrementObjectTimeBy(double)Constants.FRAMES_PER_SECOND/timeDifference));
			}
			
			
			// pause the thread
			try {
				Thread.sleep(Constants.TICK_SPEED);		// 28 for 30 fps
			} catch (InterruptedException e) { e.printStackTrace(); }
			System.out.println();
			
			frames++;
			
			// updates the fps
			if(frames == Constants.FRAMES_PER_SECOND) {
				now = System.currentTimeMillis();
				timeDifference = now - start;
				System.out.println(Constants.FRAMES_PER_SECOND + " frames per " + timeDifference + " ms");
				start = now;
				frames = 0;
			}
			
			repaint();
		}
	}

}
