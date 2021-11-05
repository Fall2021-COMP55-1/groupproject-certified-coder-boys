import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GLabel;
import acm.graphics.GObject;

public class HighScoreMenu extends GraphicsPane {
	
	// you will use program to get access to all of the GraphicsProgram calls
	private MainApplication program; 
								
	private final int BUTTON_SIZE = 50;
	GLabel score1;

	public HighScoreMenu(MainApplication app) {
		super();
		program = app;
		score1 = new GLabel("Test", 100, 100);
		score1.setColor(Color.black);
	}

	@Override
	public void showContents() {
		program.add(score1);
	}

	@Override
	public void hideContents() {
		program.remove(score1);
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}
}
