import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GObject;

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
		//GObject obj = program.getElementAt(e.getX(), e.getY());
		//if (obj == rect) {
//			program.switchToSome();
//		}
//		if (obj == rect2) {
			program.switchToHighScore();
//		}
	}
}
