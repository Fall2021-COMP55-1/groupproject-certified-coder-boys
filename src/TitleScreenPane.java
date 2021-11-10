import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;

public class TitleScreenPane extends GraphicsPane {
	private MainApplication program; 

	//private GImage img;
	//private GParagraph para;
	private GLabel menuOpt1;
	private GLabel menuOpt2;
	private GLabel menuOpt3;
	private GImage tScreen;

	public TitleScreenPane(MainApplication app) {
		super();
		program = app;
		//img = new GImage("robot head.jpg", 100, 100);
		//para = new GParagraph("welcome\nto my\nsecret room!", 150, 300);
		//para.setFont("Arial-24");
		
		tScreen = new GImage("AssetImages/title screen.png", 0,0);
		menuOpt1 = new GLabel("Play Game", 300, 400);
		menuOpt1.setColor(Color.white);
		tScreen.setSize(800,600);
	}

	//@Override
	public void showContents() {
		program.add(tScreen);
		program.add(menuOpt1);
		//program.add(para);
	}

	//@Override
	public void hideContents() {
		program.remove(tScreen);
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
