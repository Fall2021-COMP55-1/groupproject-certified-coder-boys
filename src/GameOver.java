import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class GameOver extends GraphicsPane {
	
	// you will use program to get access to all of the GraphicsProgram calls
	private MainApplication program;
	private GImage screen;
	private GButton rect;
	private GButton rect2;
	private final int BUTTON_SIZE = 50;

	public GameOver(MainApplication app) {
		super();
		program = app;
		screen = new GImage("AssetImages/Game Over.png",0,0);
		rect = new GButton("Play Again", app.getWidth()/2-BUTTON_SIZE/2, app.getHeight()/2-BUTTON_SIZE/2, BUTTON_SIZE, BUTTON_SIZE);
		rect2 = new GButton("Main Menu", 300, 300, BUTTON_SIZE, BUTTON_SIZE);
		rect.setFillColor(Color.RED);
		rect2.setFillColor(Color.RED);
	}

	@Override
	public void showContents() {
		program.add(screen);
		program.add(rect);
		program.add(rect2);
	}

	@Override
	public void hideContents() {
		program.remove(screen);
		program.remove(rect);
		program.remove(rect2);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == rect) {
			program.switchToGame();
		}
		if (obj == rect2) {
			program.switchToMenu();
		}
	}
}