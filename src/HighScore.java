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
		
		//text file contains all of the scores in a single line
		File data = new File("HighScores.txt");
		try {
			reader = new Scanner(data);
			list = reader.nextLine();

		    //reads text file and assigns the scores/names to their respective arrays
			for(int i = 0; i<10; i++){
				names[i] = list.substring(12*i,12*i+6);
				
			    String sc = list.substring(12*i+6, 12*i+12);
			    int numScore = Integer.parseInt(sc);

			    scores[i] = numScore;
			    
			    //names[0] = list.substring(0, 6)
			    //names[1] = list.substring(12, 18)
			    //names[2] = list.substring(24, 30)
				
			    //scores[0] = list.substring(6, 12)
				//scores[1] = list.substring(18, 24)
			    //scores[2] = list.substring(30,36)
			}
			
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
		//System.out.println(o.list);
		
		for(int i = 0; i<10; i++) {
			System.out.println("Name: "+o.names[i]+" Score: "+o.scores[i]);
		}
		
		
	}
}
