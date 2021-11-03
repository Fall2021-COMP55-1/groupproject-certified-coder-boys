import java.io.*;
import java.util.*;

public class HighScore {
/*
 * The constructor gets names and scores in order from a text file and 
 * assigns them to their respective arrays of scores[] and names[].  
 * checkHighScore() is used to compare the user’s score with the lowest 
 * score to see if the player qualifies for a spot on the leaderboard.  
 * newHighScore removes the lowest score in the array and replaces it with 
 * the new score and sorts the array and rewrites the text file with the new scoreboard.
 * 
 * The HighScore.txt file is one continuous string.  Names first, scores second.  Names are
 * a length of 6, scores are a length of 6.
 */
	int scores[];
	String names[];
	String list;
	Scanner reader;
	
	//constructor
	public HighScore() {
		scores = new int[10];
		names = new String[10];
		
		File f = new File("HighScores.txt");
		try {
			reader = new Scanner(f);
			list = reader.nextLine();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
		}
	}
	
	public void checkHighScore() {
		
	}
	
	public void newHighScore() {
		
	}
	
	public static void main(String args[]) {
		HighScore o = new HighScore();
		System.out.println(o.list);
	}
}
