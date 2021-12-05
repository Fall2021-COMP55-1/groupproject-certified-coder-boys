import java.awt.Color;
import java.awt.event.MouseEvent;
import java.io.File;

import acm.graphics.GObject;
import acm.graphics.GImage;

public class MenuPane extends GraphicsPane {
	
	// you will use program to get access to all of the GraphicsProgram calls
	private MainApplication program; 
								
	private GButton rect;
	private GButton rect2;
	private GButton rect3;
	private GButton rect4;
	private GImage menu;
	private final int BUTTON_SIZE = 50;

	public MenuPane(MainApplication app) {
		super();
		program = app;
		rect = new GButton("Next", app.getWidth()/2-BUTTON_SIZE/2, app.getHeight()/2-BUTTON_SIZE/2, BUTTON_SIZE, BUTTON_SIZE);
		rect2 = new GButton("", 275, 227, 248, 248);
		rect3 = new GButton("", 10, 227, 248, 248);
		rect4 = new GButton("", 540, 227, 248, 248);
		menu = new GImage("AssetImages/Menu.png",0,0);
		rect.setFillColor(Color.RED);
		rect2.setFillColor(Color.RED);
		rect2.setVisible(false);
		rect3.setFillColor(Color.orange);
		rect3.setVisible(false);
		rect4.setFillColor(Color.yellow);
		rect4.setVisible(false);
	}

	@Override
	public void showContents() {
		program.add(menu);
		//program.add(rect);
		program.add(rect2);
		program.add(rect3);
		program.add(rect4);
	}

	@Override
	public void hideContents() {
		program.remove(menu);
		//program.remove(rect);
		program.remove(rect2);
		program.remove(rect3);
		program.remove(rect4);
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
		if(obj == rect3) {
			program.switchToGame();
		}
		if(obj == rect4) {
			//program.switchToNameInput();
			System.exit(0); // exiting the game!
		}
	}
}
