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
import acm.program.Program;

public class PlayPane extends GraphicsPane implements KeyListener, ActionListener {
	private MainApplication program; 
	
	boolean gameOver = false;
	
	// game loop
	private Timer timer;
	
	ArrayList<EnemyCar> cars;
	
	PlayerCar player;
	EnemyCar enemy;
	GImage background;
	GImage road;
	GImage roadOutline;
	
	ArrayList<GRect> healthBar;
	
	GRect health1;
	GRect health2;
	GRect health3;
	GRect health4;
	
	long score;
	long totalTime = 0;
	String level;
	
	Traffic traf;
	
	String scoreString;
	
	GLabel scoreLabel;
	GLabel levelLabel;
	
	int health;
	int lastHealth;
	GLabel healthLabel;
	
	GRect rectangle;
	
	boolean paused;
	
	GLabel pause;
	GImage pauseScreen;
	
	GImage powerup;
	GImage cooldown;
	
	GImage pauseIndicator;
	GImage invicibilityIndicator;
	
	long startTime;
	
	int delayHealth;
	
	int delayPower;
	
	//GUI UI; add this to update the game's labels
	
	public PlayPane(MainApplication app) {
		super();
		program = app;
		
		traf = new Traffic(app, this);
		
		//define all starting states here
		player = new PlayerCar(app, this);
		
		scoreLabel = new GLabel("Score: 0", 0, 200);
		scoreLabel.setFont("Arial-Bold-22");
		scoreLabel.setColor(Color.pink);
		
		powerup = new GImage("AssetImages/powerup indicator.png",0,0);
		cooldown = new GImage("AssetImages/cooldown indicator.png",0,0);
		invicibilityIndicator = new GImage("AssetImages/invincible indicator.png",0,0);
		pauseIndicator = new GImage("AssetImages/pause indicator.png",0,0);
		
		pauseScreen = new GImage("AssetImages/Pause Screen.png",0,0);
		
		level = "Level: 1";
		levelLabel = new GLabel(level, 0, scoreLabel.getY()+scoreLabel.getHeight());
		levelLabel.setFont("Arial-Bold-22");
		levelLabel.setColor(Color.pink);
		
		health = 4;
		lastHealth = health; 
		
		health1 = new GRect(5, levelLabel.getY()+levelLabel.getHeight()+20, 20, 20);
		health1.setColor(Color.black);
		health1.setFillColor(Color.red);
		health1.setFilled(true);
		
		health2 = new GRect(25, levelLabel.getY()+levelLabel.getHeight()+20, 20, 20);
		health2.setColor(Color.black);
		health2.setFillColor(Color.red);
		health2.setFilled(true);
		
		
		health3 = new GRect(45, levelLabel.getY()+levelLabel.getHeight()+20, 20, 20);
		health3.setColor(Color.black);
		health3.setFillColor(Color.red);
		health3.setFilled(true);
		
		
		health4 = new GRect(65, levelLabel.getY()+levelLabel.getHeight()+20, 20, 20);
		health4.setColor(Color.black);
		health4.setFillColor(Color.red);
		health4.setFilled(true);
		
		
		healthBar = new ArrayList<GRect>();
		healthBar.add(health1);
		healthBar.add(health2);
		healthBar.add(health3);
		healthBar.add(health4);
		
		healthLabel = new GLabel("Health: "+Integer.toString(health),0,levelLabel.getY()+levelLabel.getHeight());
		healthLabel.setFont("Arial-Bold-22");
		healthLabel.setColor(Color.pink);
		
		background = new GImage("AssetImages/galaxy2.gif",0,0);
		background.setSize(800,600);
		
		
		road = new GImage("AssetImages/Final Road 2L3S.gif",150,0);
		road.setSize(500,600);
		
		roadOutline = new GImage("AssetImages/road outline.png",0,0);
		

//		pause = new GLabel("PAUSE", 100, 100);
//		pause.setColor(Color.pink);
		
		delayHealth = 1;
		delayPower = 0;
	}
	
	@Override
	public void showContents() {
		reset();
		program.add(background);
		program.add(roadOutline);
		program.add(road);
		program.add(scoreLabel);
		program.add(levelLabel);
		program.add(healthLabel);
		program.add(pauseIndicator);
		//program.add(rectangle);
		show();
		player.show();
		//enemy.show(); // only shows one car rn
		timer = new Timer(10, this);
		timer.start();
		startTime = System.currentTimeMillis();
	}
	
	public void reset() {
		player = new PlayerCar(program, this);
		traf = new Traffic(program, this);
		score = 0;
		health = 4;
		level = "Level: 1";
		levelLabel.setLabel(level);
		delayHealth = 1;
		//traf.hide();
		score = 0;
		totalTime = 0;
		delayPower = 0;
		resetHealth();
	}

	@Override
	public void hideContents() {
		//program.remove(playerCar);
		timer.stop();
		player.hide();
		program.remove(background);
		program.remove(road);
		program.remove(roadOutline);
		program.remove(scoreLabel);
		program.remove(levelLabel);
		program.remove(healthLabel);
		program.remove(pauseIndicator);
		traf.hide();
		hide();
		
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(paused) {
			return;
		}
		
		if(delayPower>0)
			delayPower--;
		else {
			program.remove(cooldown);
			program.add(powerup);
		}
		
		player.update();
		
		//update enemies
		traf.update();
		
		cars = traf.getCars();
		
		if(health != lastHealth) {
			updateHealth();
		}
		//update map
		
		//update labels
		score = ((System.currentTimeMillis()-startTime)/1000)+totalTime;
		scoreString = String.valueOf("Score: "+score);
		scoreLabel.setLabel(scoreString);
		
		levelCounter();
		levelLabel.setLabel(level);
		
		healthLabel.setLabel("Health: "+health);
		
		//check health
		
		delayHealth--;
		
		if(delayHealth <= 0) {
			delayHealth = 0;
			program.remove(invicibilityIndicator);
		}
		
		//run through enemy array to check with collision function
		for(EnemyCar enemy : cars) {
			if(collision(player.getImage(), enemy.getImage())) {
				//invincibility implementation
				if(delayHealth==0) {
					health--;
					System.out.println("OUCH!");
					delayHealth = 120;
					program.add(invicibilityIndicator);
				}
			}
		}
		
		if(health==0) {
			program.setScore(score);
			program.switchToNameInput();
		}
	}
	
	public void levelCounter() {
		if(score==15){
			level = "Level: 2";
		}
		else if(score==30){
			level = "Level: 3";
		}
		else if(score==45){
			level = "Level: 4";
		}
		else if(score==60){
			level = "Level: 5";
		}
	}
	
//	public void levelCounter() {
//		if(score==30){
//			level = "Level: 2";
//		}
//		else if(score==60) {
//			level = "Level: 3";
//		}
//		else if(score==90) {
//			level = "Level: 4";
//		}
//		else if(score==120) {
//			level = "Level: 5";
//		}
//		else if(score==150) {
//			level = "Level: 6";
//		}
//		else if(score==180) {
//			level = "Level: 7";
//		}
//		else if(score==210) {
//			level = "Level: 8";
//		}
//		else if(score==240) {
//			level = "Level: 9";
//		}
//		else if(score==270) {
//			level = "Level: 10";
//		}
//	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_LEFT) {
			player.updateDX(-5);
		}
		else if(key == KeyEvent.VK_RIGHT) {
			player.updateDX(5);
		}
		else if(key == KeyEvent.VK_ESCAPE) {
			//pauses game
			paused = !paused;
			showPaused();
		}
		else if(key == KeyEvent.VK_SPACE) {
			//USE HEALTH POWERUP LIMITED TO EVERY 60 SECONDS
			if(health<4 && delayPower == 0) {
				health++;
				delayPower = 3600; //60 seconds
				program.remove(powerup);
				program.add(cooldown);
				//remove gimage
			}
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		player.stopDX();
	}
	
	public void showPaused() {
		if(paused) {
			program.add(pauseScreen);
			totalTime += (System.currentTimeMillis()-startTime)/1000;
		}
		else {
			program.remove(pauseScreen);
			startTime = System.currentTimeMillis();
		}
	}
	
	public long getScore() {
		return score;
	}
	
	public boolean collision(GImage boxA, GImage boxB) {
		double minX = boxA.getX();
		double minY = boxA.getY();
		double maxX = minX + boxA.getWidth();
		double maxY = minY + boxA.getHeight();
		
		if(boxB.getX() > maxX || minX > boxB.getX() + boxB.getWidth()) return false;
		if(boxB.getY() > maxY || minY > boxB.getY() + boxB.getHeight()) return false;
		return true;
	}
	public void show() {
		program.add(health1);
		program.add(health2);
		program.add(health3);
		program.add(health4);
		
	}
	
	public void hide() {
		program.remove(health1);
		program.remove(health2);
		program.remove(health3);
		program.remove(health4);
	}
	
	void resetHealth() {
		show();
		for(int i = 0; i < health; i++) {
			healthBar.get(i).setFilled(true);
		}
	}
	
	void updateHealth() {
		if(lastHealth > health) {
			healthBar.get(health).setFilled(false);
		}
		else {
			healthBar.get(health-1).setFilled(true);
		}
		lastHealth = health;
	}
}
