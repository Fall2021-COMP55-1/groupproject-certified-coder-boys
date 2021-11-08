import java.util.ArrayList;

import acm.graphics.GImage;

public class PlayPane extends GraphicsPane {
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
	GImage background;
	Powerup item;
	
	//GUI UI; add this to update the game's labels
	
	public void run() {
		//define all starting states here
		while (!gameOver){
//			if(System.nanotime()-startTime > gametick){
//				//update, priority: player > enemy > ui
//			}
		}
	}
	
	@Override
	public void showContents() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hideContents() {
		// TODO Auto-generated method stub

	}

}
