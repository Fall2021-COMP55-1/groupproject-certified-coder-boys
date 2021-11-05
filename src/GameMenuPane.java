import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;

public class GameMenuPane extends GraphicsPane {
	private MainApplication program; 

	//private GImage img;
	//private GParagraph para;
	private GLabel menuOpt1;
	private GLabel menuOpt2;
	private GLabel menuOpt3;


	public GameMenuPane(MainApplication app) {
		this.program = app;
		//img = new GImage("robot head.jpg", 100, 100);
		//para = new GParagraph("welcome\nto my\nsecret room!", 150, 300);
		//para.setFont("Arial-24");
		menuOpt1 = new GLabel("Play Game", 100, 100);
	}

	//@Override
	public void showContents() {
		program.add(menuOpt1);
		//program.add(para);
	}

	//@Override
	public void hideContents() {
		//program.remove(img);
		//program.remove(para);
		program.remove(menuOpt1);
	}

	//@Override
	public void mousePressed(MouseEvent e) {
		//para.setText("you need\nto click\non the eyes\nto go back");
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == menuOpt1) {
			program.switchToMenu();
		}
	}
}
