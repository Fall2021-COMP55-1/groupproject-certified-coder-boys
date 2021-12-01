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
	private int width = 50;
	private int height = 100;
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
		program = app;
		
		this.dx = dx;
		this.dy = Math.abs(dy);
		if(dy < 1)
			this.dy=1;
		Random rand = new Random();
		int roll = rand.nextInt() % 5; //based on number of cars
		
		switch(roll) {
			case 0:
			case 1:
			case 2:
			case 3:
				fileName = "AssetImages/BuickerB.png";
				fileName = "AssetImages/Enemy2.png";
				break;
			case 4:
				fileName = "AssetImages/RamB.png";
				break;
			case 5:
				fileName = "AssetImages/JeepB.png";
				break;
			default:
				fileName = "AssetImages/RamB.png";
				break;
		}
		
		System.out.println(fileName);
		car = new GImage(fileName,x,y);
		car.setSize(width, height);
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
	
	public double getY() {
		return car.getY();
	}
	
	public String getFileName() { // may need to be fixed
		return fileName;
	}

	public GImage getImage() {
		return car;
	}
	
	void update() {
		if(dx!=0) {
			if(dx>0) {
				if(car.getX()+car.getWidth()+dx>650) {
					car.setLocation(650-car.getWidth(),car.getY()+dy);
					dx = dx*-1;
				}
				else {
					car.move(dx, dy);
				}
			}
			else {
				if(car.getX()+dx<150) {
					car.setLocation(150,car.getY()+dy);
					dx = dx*-1;
				}
				else {
					car.move(dx, dy);
				}
			}
		}
		else
			car.move(dx, dy);
		// TODO Auto-generated method stub
		
	}
	
	public double getDX() {
		return dx;
	}
	
	public void setDX(double d) {
		dx = d;
	}
	
	public void show() {
		program.add(car); // adds one car right now
	}
	public void hide() {
		program.remove(car);
	}
}
