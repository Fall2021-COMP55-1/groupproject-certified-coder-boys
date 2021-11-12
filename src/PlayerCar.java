import acm.graphics.GImage;

public class PlayerCar extends Object{

	 // Sets the powerup’s speed, width, height, filename, and Space.

	String fileName; //yet to have image
	int width;
	int height;
	double x;
	double y;
	double dx;
	int health;
	MainApplication program;
	PlayPane game;
	GImage car;
	
	public PlayerCar(MainApplication app, PlayPane pane) { //needs to be finished
		pos = new Space();
		x = 400;
		y = 450;
		dx = 0;
		program = app;
		fileName = "AssetImages/JeepB.png";
		car = new GImage(fileName,x,y);
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
	public void updateDX(int x) {
		dx += x;
	}
	
	public void update(double x, double y) {
		if(car.getX() + dx < 0) {
			dx = 0; // adjust based on road
		}
		car.move(dx, 0);
	}
	public void show() {
		program.add(car);
	}
	public void hide() {
		program.remove(car);
	}
}
