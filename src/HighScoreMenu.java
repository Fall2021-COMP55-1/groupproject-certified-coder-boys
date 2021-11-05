import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GLabel;
import acm.graphics.GObject;

public class HighScoreMenu extends GraphicsPane {
	
	// you will use program to get access to all of the GraphicsProgram calls
	private MainApplication program; 

	String names[];
	int scores[];
	
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	
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
		score1.setLocation(WINDOW_WIDTH/2-score1.getWidth(), 100);
		
		score2 = new GLabel(names[8]+" "+scores[9], 100, 150);
		score2.setLocation(WINDOW_WIDTH/2-score2.getWidth(), 150);
		
		score3 = new GLabel(names[7]+" "+scores[9], 100, 200);
		score3.setLocation(WINDOW_WIDTH/2-score3.getWidth(), 200);
		
		score4 = new GLabel(names[6]+" "+scores[9], 100, 250);
		score4.setLocation(WINDOW_WIDTH/2-score4.getWidth(), 250);
		
		score5 = new GLabel(names[5]+" "+scores[9], 100, 300);
		score5.setLocation(WINDOW_WIDTH/2-score5.getWidth(), 300);
		
		score6 = new GLabel(names[4]+" "+scores[9], 100, 350);
		score6.setLocation(WINDOW_WIDTH/2-score6.getWidth(), 350);
		
		score7 = new GLabel(names[3]+" "+scores[9], 100, 400);
		score7.setLocation(WINDOW_WIDTH/2-score7.getWidth(), 400);
		
		score8 = new GLabel(names[2]+" "+scores[9], 100, 450);
		score8.setLocation(WINDOW_WIDTH/2-score8.getWidth(), 450);
		
		score9 = new GLabel(names[1]+" "+scores[9], 100, 500);
		score9.setLocation(WINDOW_WIDTH/2-score9.getWidth(), 500);
		
		score10 = new GLabel(names[0]+" "+scores[9], 100, 550);
		score10.setLocation(WINDOW_WIDTH/2-score10.getWidth(), 550);
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
		program.remove(score2);
		program.remove(score3);
		program.remove(score4);
		program.remove(score5);
		program.remove(score6);
		program.remove(score7);
		program.remove(score8);
		program.remove(score9);
		program.remove(score10);
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}
}
