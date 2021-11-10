import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;

public class PlayPane extends GraphicsPane {
	private MainApplication program; 
	
	boolean gameOver = false;
	
	// game loop
	long startTime = System.nanoTime();
	//long frametick = 1000000000/60;
	long gameTick = 1000000000/60;
	long lastTick = startTime;
	long enemyTick = 1000000000/5000; // for enemy spawn and can change this around
	//long lastFrame = startTime;
	
	ArrayList<EnemyCar> enemies;
	
	PlayerCar player;
	GImage playerCar;
	
	GImage background;
	Powerup item;
	
	KeyHandler key;
	
	public static final double START_X = 400;
	public static final double START_Y = 300;
	
	//GUI UI; add this to update the game's labels
	
	public PlayPane(MainApplication app) {
		super();
		program = app;
		
		//define all starting states here
		player = new PlayerCar(START_X, START_Y);
		playerCar = new GImage(player.getFileName(),player.getSpace().getX(),player.getSpace().getY());

		run();
	}
	
	public void run() {
//		while (!gameOver){
//			if(System.nanoTime()-startTime > gameTick){
//				//update, priority: player > enemy > ui
//			}
//		}
	}
	
	@Override
	public void showContents() {
		program.add(playerCar);
	}

	@Override
	public void hideContents() {
		program.remove(playerCar);
		// TODO Auto-generated method stub

	}

}
