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

public class NameInput extends GraphicsPane {
	
	// you will use program to get access to all of the GraphicsProgram calls
	private MainApplication program; 
								
	private GButton rect;
	private GImage screen;
	private final int BUTTON_SIZE = 50;

	public NameInput(MainApplication app) {
		super();
		program = app;
		screen = new GImage("AssetImages/Name Input Menu.png",0,0);
		rect = new GButton("TEST",200,200,200,200);
		rect.setFillColor(Color.red);
	}

	@Override
	public void showContents() {
		program.add(screen);
		program.add(rect);
	}

	@Override
	public void hideContents() {
		program.remove(screen);
		program.remove(rect);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == rect) {
			program.switchToGameOver();
		}
	}
}
