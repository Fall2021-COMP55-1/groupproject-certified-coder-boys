import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

import acm.graphics.GImage;

public class EnemyCar extends Object implements ActionListener{
	/*
	 * Sets the enemy’s speed, width, height, filename, and Space.  
	 * spawn() returns the vehicle for placement in the Game class.
	 */
	
	// below are the variables that will be needed
	private double speed;
	private String fileName;
	private int width;
	private int height;
	private double x;
	private double y;
	private double dx;
	private double dy;
	private Timer enemyTimer = new Timer(1000, this); // timer that can/will be adjusted
	private MainApplication program;
	private PlayPane game;
	private GImage car;
	
	public void actionPerformed(ActionEvent e) { // added an actionPerformed function for timer
		enemyTimer.stop();
	}
	
//	public void run() { // added a run function to start timer and gave it a delay will be adjusted later can also change this into spawn function
//		enemyTimer.setInitialDelay(1000);
//		enemyTimer.start();
//		
//	}
	
	public EnemyCar(MainApplication app, PlayPane pane, double dx, double dy, double x, double y) { // finish this function
		//x = 400;
		//y = 300;
		Random rand = new Random();
		program = app;
		int roll = rand.nextInt() % 5;
		switch(roll) {
			case 0:
				// the filenames
		}
		fileName = "AssetImages/JeepB.png";
		car = new GImage(fileName,x,y);
		
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
		car.move(dx, dy);
		// TODO Auto-generated method stub
		
	}
	public void show() {
		program.add(car); // adds one car right now
	}
	public void hide() {
		program.remove(car);
	}
}
