import acm.graphics.GImage;

public class PlayerCar extends Object{

	 // Sets the powerup’s speed, width, height, filename, and Space.

	String fileName;
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
		fileName = "AssetImages/SuperB.png";
		car = new GImage(fileName,x,y);
		car.setSize(60,120);
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
	
	public GImage getImage() {
		return car;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void updateDX(int x) {
		if(x < 0 && dx > 0)
			dx = -5;
		else if(x > 0 && dx < 0)
			dx = 5;
		else if((x >= 0 && dx <= 0) || (x <= 0 && dx >= 0))
			dx += x;
	}
	
	public void stopDX() {
		if(dx<0) {
			while(dx!=0)
				dx++;
		}
		else if(dx>0) {
			while(dx!=0)
				dx--;
		}
	}
	
	public void update() {
		if(car.getX() + dx < 150) {
			dx = 0;
		}
		else if(car.getX()+dx > 650-car.getWidth()) {
			dx = 0;
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
