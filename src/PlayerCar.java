public class PlayerCar extends Object{

	 // Sets the powerup’s speed, width, height, filename, and Space.

	String fileName; //yet to have image
	int width;
	int height;
	Space pos;
	int health;
	
	public PlayerCar(double x, double y) { //needs to be finished
		pos = new Space();
		pos.setX(x);
		pos.setY(y);
		fileName = "AssetImages/JeepB.png";
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public Space getSpace() {
		return pos;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void update(double x, double y) {
		pos.setX(x);
		pos.setY(y);
	}
}
