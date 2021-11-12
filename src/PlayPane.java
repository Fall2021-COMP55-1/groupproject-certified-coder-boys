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
	
	GImage background;
	GImage road;
	Powerup item;
	
	KeyHandler key;
	
	public static final double START_X = 400;
	public static final double START_Y = 450;
	
	//GUI UI; add this to update the game's labels
	
	public PlayPane(MainApplication app) {
		super();
		program = app;
		player = new PlayerCar(app, this);
		//define all starting states here
		background = new GImage("AssetImages/ground infinite texture.jpg",0,0);
		background.setSize(800,600);
	}
	
	@Override
	public void showContents() {
		program.add(background);
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
		player.update(100,100);
		//update map
		//update enemies
	}
}
