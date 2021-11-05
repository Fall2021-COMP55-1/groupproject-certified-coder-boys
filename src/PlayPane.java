import java.util.ArrayList;

import acm.graphics.GImage;

public class PlayPane extends GraphicsPane {
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
	Powerup PU;
	//GUI UI; add this to update the game
	
	// while (!gameOver){
		//if(System.nanotime()-startTime > gametick){}
	//}

	@Override
	public void showContents() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hideContents() {
		// TODO Auto-generated method stub

	}

}
