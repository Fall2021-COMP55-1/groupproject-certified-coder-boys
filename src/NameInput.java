import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.Timer;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GRect;

public class NameInput extends GraphicsPane implements KeyListener, ActionListener{
	
	// you will use program to get access to all of the GraphicsProgram calls
	private MainApplication program; 
								
	private GButton rect;
	private GImage screen;
	
	private Timer timer;
	
	char name[];
	int i;
	int key;
	
	char c;

	public NameInput(MainApplication app) {
		super();
		program = app;
		screen = new GImage("AssetImages/Name Input Menu.png",0,0);
		rect = new GButton("TEST",200,200,200,200);
		rect.setFillColor(Color.red);
		name = new char[6];
		i = 0;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		key = e.getKeyCode();
		
		if(i<6) {
			name[i] = (char)key;
			i++;
		}
		
		for(int i = 0; i < 6; i++) {
			System.out.println(name[i]);
		}
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
