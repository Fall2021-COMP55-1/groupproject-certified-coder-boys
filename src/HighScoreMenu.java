import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GLabel;
import acm.graphics.GObject;

public class HighScoreMenu extends GraphicsPane {
	
	// you will use program to get access to all of the GraphicsProgram calls
	private MainApplication program; 
								
	private final int BUTTON_SIZE = 50;
	String names[];
	int scores[];
	
	GLabel score1;
	GLabel score2;
	GLabel score3;
	GLabel score4;
	GLabel score5;
	GLabel score6;
	GLabel score7;
	GLabel score8;
	GLabel score9;
	GLabel score10;

	public HighScoreMenu(MainApplication app) {
		super();
		program = app;
		
		HighScore o = new HighScore();
		names = o.getNames();
		scores = o.getScores();
		
		labels();
	}
	
	public void labels(){
		score1 = new GLabel(names[9]+" "+scores[9], 100, 100);
		score2 = new GLabel(names[8]+" "+scores[9], 100, 150);
		score3 = new GLabel(names[7]+" "+scores[9], 100, 200);
		score4 = new GLabel(names[6]+" "+scores[9], 100, 250);
		score5 = new GLabel(names[5]+" "+scores[9], 100, 300);
		score6 = new GLabel(names[4]+" "+scores[9], 100, 350);
		score7 = new GLabel(names[3]+" "+scores[9], 100, 400);
		score8 = new GLabel(names[2]+" "+scores[9], 100, 450);
		score9 = new GLabel(names[1]+" "+scores[9], 100, 500);
		score10 = new GLabel(names[0]+" "+scores[9], 100, 550);
	}

	@Override
	public void showContents() {
		program.add(score1);
		program.add(score2);
		program.add(score3);
		program.add(score4);
		program.add(score5);
		program.add(score6);
		program.add(score7);
		program.add(score8);
		program.add(score9);
		program.add(score10);
	}

	@Override
	public void hideContents() {
		program.remove(score1);
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}
}
