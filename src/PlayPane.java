import java.util.ArrayList;

import javax.swing.Timer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;

public class PlayPane extends GraphicsPane implements ActionListener {
	private MainApplication program; 
	
	boolean gameOver = false;
	
	// game loop
	private Timer timer;
	
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
	
	@Override
	public void showContents() {
		program.add(background);
		program.add(playerCar);
		timer = new Timer(10, this);
		timer.start();
	}

	@Override
	public void hideContents() {
		program.remove(playerCar);
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		player.update(100,100);
		//update map
		//update enemies
	}
}
