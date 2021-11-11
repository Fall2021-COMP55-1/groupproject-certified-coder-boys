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
	
	
	ArrayList<EnemyCar> enemies;
	
	PlayerCar player;
	GImage playerCar;
	
	GImage background;
	GImage road;
	Powerup item;
	
	KeyHandler key;
	
	public static final double START_X = 400;
	public static final double START_Y = 300;
	
	//GUI UI; add this to update the game's labels
	
	public PlayPane(MainApplication app) {
		super();
		program = app;
		
		//define all starting states here
		background = new GImage("AssetImages/ground infinite texture.jpg",0,0);
		background.setSize(800,600);
		
		player = new PlayerCar(START_X, START_Y);
		playerCar = new GImage(player.getFileName(),player.getSpace().getX(),player.getSpace().getY());
	}
	
	public void run() {
//		while (!gameOver){
//			if(System.nanoTime()-startTime > gameTick){
//				//update, priority: player > enemy > ui
//				System.out.println("test");
//			}
//		}
	}
	
	@Override
	public void showContents() {
		program.add(background);
		program.add(playerCar);
	}

	@Override
	public void hideContents() {
		program.remove(playerCar);
		// TODO Auto-generated method stub

	}
}
