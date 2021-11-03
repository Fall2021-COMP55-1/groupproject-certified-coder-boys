
	/*
	 * Sets the powerup’s speed, width, height, filename, and Space.
	 */
import java.awt.event.*;
import javax.swing.*;

public class Powerup implements ActionListener {

	private Space pos;
	private String fileName;
	private int width;
	private int height;
	private Timer PowerupTimer = new Timer(1000, this); // timer that can/will be adjusted
	
	public void actionPerformed(ActionEvent e) { // added an actionPerformed function for timer
		PowerupTimer.stop();
	}
	
	public void run() { // added a run function to start timer and gave it a delay will be adjusted later can also change this into spawn function
		PowerupTimer.setInitialDelay(1000);
		PowerupTimer.start();
		
	}
	public void Powerup (int level) { // finish this function
		
	}

	
	public int getWidth() { // may need to be fixed
		return width;
	}
	
	public int getHeight() { // may need to be fixed
		return height;
	}
	
	public Space getSpace() { // may need to be fixed
		return pos;
	}
	
	public String getFileName() { // may need to be fixed
		return fileName;
	}
}