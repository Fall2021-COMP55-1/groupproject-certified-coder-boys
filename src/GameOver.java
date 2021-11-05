import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import acm.graphics.GObject;

public class GameOver {
	/*
	 * This class is called after the game is finished.  It checks with 
	 * checkHighScore() in the HighScore class to see if the player 
	 * achieved a higher score than any on the scoreboard.  If so, 
	 * it prompts the user to enter their name in conjunction with 
	 * MainGame using the KeyPressed method and calls newHighScore to place 
	 * it in its proper position.
	 */
	public class MenuPane extends GraphicsPane {
		
		// you will use program to get access to all of the GraphicsProgram calls
		private MainApplication program; 
									
		private GButton rect;
		private GButton rect2;
		private final int BUTTON_SIZE = 50;

		public MenuPane(MainApplication app) {
			super();
			program = app;
			rect = new GButton("Next", app.getWidth()/2-BUTTON_SIZE/2, app.getHeight()/2-BUTTON_SIZE/2, BUTTON_SIZE, BUTTON_SIZE);
			rect2 = new GButton("High Score", 300, 300, BUTTON_SIZE, BUTTON_SIZE);
			rect.setFillColor(Color.RED);
			rect2.setFillColor(Color.RED);
		}

		@Override
		public void showContents() {
			program.add(rect);
			program.add(rect2);
		}

		@Override
		public void hideContents() {
			program.remove(rect);
			program.remove(rect2);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			GObject obj = program.getElementAt(e.getX(), e.getY());
			if (obj == rect) {
				program.switchToSome();
			}
			if (obj == rect2) {
				program.switchToHighScore();
			}
		}
	}
}