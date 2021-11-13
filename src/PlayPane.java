import java.util.ArrayList;

import javax.swing.Timer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GRect;

public class PlayPane extends GraphicsPane implements KeyListener, ActionListener {
	private MainApplication program; 
	
	boolean gameOver = false;
	
	// game loop
	private Timer timer;
	
	ArrayList<EnemyCar> enemies;
	
	PlayerCar player;
	
	GImage background;
	GImage road;
	Powerup item;
	
	String score;
	
	GLabel scoreLabel;
	GLabel level;
	
	boolean paused;
	
	GLabel pause;
	
	long startTime = System.currentTimeMillis();
	
	//GUI UI; add this to update the game's labels
	
	public PlayPane(MainApplication app) {
		super();
		program = app;
		
		//define all starting states here
		player = new PlayerCar(app, this);
		
		score = "Score: 0";
		scoreLabel = new GLabel(score, 100, 200);
		scoreLabel.setFont("Arial-Bold-22");
		scoreLabel.setColor(Color.YELLOW);
		
		background = new GImage("AssetImages/ground infinite texture.jpg",0,0);
		background.setSize(800,600);
		
		road = new GImage("AssetImages/road.jpg",150,0);
		road.setSize(500,600);

		pause = new GLabel("PAUSE", 100, 100);
	}
	
	@Override
	public void showContents() {
		program.add(background);
		program.add(road);
		program.add(scoreLabel);
		//program.add(playerCar);\
		player.show();
		timer = new Timer(10, this);
		timer.start();
	}

	@Override
	public void hideContents() {
		//program.remove(playerCar);
		player.hide();
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(paused) {
			return;
		}
		
		player.update();
		
		//update map
		//update enemies
		//update labels
		score = String.valueOf("Score: "+(System.currentTimeMillis()-startTime)/1000);
		scoreLabel.setLabel(score);
		scoreLabel.setLocation(0, 200);
		
		//run through enemy array to check with collision function
//		for(EnemyCar enemy : enemies) {
//			
//		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_LEFT) {
			player.updateDX(-5);
		}
		else if(key == KeyEvent.VK_RIGHT) {
			player.updateDX(5);
		}
		else if(key == KeyEvent.VK_SPACE) {
			//pauses game
			paused = !paused;
			showPaused();
		}
	}
	
	public void keyReleased(KeyEvent e) {
		player.stopDX();
	}
	
	public void showPaused() {
		if(paused) {
			program.add(pause);
		}
		else {
			program.remove(pause);
		}
	}
	
	public boolean collision(GRect boxA, GRect boxB) {
		double minX = boxA.getX();
		double minY = boxA.getY();
		double maxX = minX + boxA.getWidth();
		double maxY = minY + boxA.getHeight();
		
		if(boxB.getX() > maxX || minX > boxB.getX() + boxB.getWidth()) return false;
		if(boxB.getY() > maxY || minY > boxB.getY() + boxB.getHeight()) return false;
		return true;
	}
}
