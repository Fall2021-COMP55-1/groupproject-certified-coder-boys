/*
	 * Takes the height, width, and coordinates of the player and 
	 * another object from their respective Space and uses them to 
	 * determine if the two objects overlap in checkCollision() and 
	 * returns true or false based or whether not it does.
	 */

public class Collision {
public int x = 5;
	  public int y = 5;
	  public int width = 50;
	  public int height = 50;
	  
	if(PlayerCar.x < EnemyCar.x + EnemyCar.width &&
			  PlayerCar.x + PlayerCar.width > EnemyCar.x &&
			  PlayerCar.y < EnemyCar.y + EnemyCar.height &&
			  PlayerCar.y + PlayerCar.height > EnemyCar.y)
			{
			    System.out.println("Collision Detected");
			}
	public static final int NULL_FEATURE = Integer.MAX_VALUE;
}
