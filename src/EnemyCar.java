import java.awt.event.*;
import javax.swing.*;

public class EnemyCar extends Object implements ActionListener{
	/*
	 * Sets the enemy’s speed, width, height, filename, and Space.  
	 * spawn() returns the vehicle for placement in the Game class.
	 */
	
	// below are the variables that will be needed
	private double speed;
	private Space pos;
	private String fileName;
	private int width;
	private int height;
	private Timer enemyTimer = new Timer(1000, this); // timer that can/will be adjusted
	
	
	public void actionPerformed(ActionEvent e) { // added an actionPerformed function for timer
		enemyTimer.stop();
	}
	
	public void run() { // added a run function to start timer and gave it a delay will be adjusted later can also change this into spawn function
		enemyTimer.setInitialDelay(1000);
		enemyTimer.start();
		
	}
	public void enemyCar (int level) { // finish this function
		
	}
	
//	public EnemyCar spawn() { have to add a global enemyCar
//		return EnemyCar;
//	}
	
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

	void update() {
		
	}
}
