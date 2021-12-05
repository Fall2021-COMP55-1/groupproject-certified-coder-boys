import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Traffic {
	ArrayList<EnemyCar> cars;
	
	private int maxDiff = 60;
	private int delay = 1;
	private int delayDefault = 400;
	private long diff = 1;
	private int dx = 0;
	private int dy = 0;
	EnemyCar car;
	// add the three lane x and y values
	private Random rand = new Random();
	MainApplication app;
	PlayPane game;
	
	public Traffic(MainApplication program, PlayPane game) {
		// TODO Auto-generated constructor stub
		cars = new ArrayList <EnemyCar>();
		app = program;
		this.game = game;
	}
	
	public void update() {
		Iterator<EnemyCar> iter = cars.iterator();
		
		//spawn rate increases over time
		if(diff < 45)
			delayDefault = (int) (400 - 4*(diff));
		else {
			delayDefault = (int) (400 - 4*(diff - 45));
			if(delay < 100)
				delayDefault = 100;
		}
		while(iter.hasNext()) {
			EnemyCar temp = iter.next();
			temp.update();
			if(temp.getY()>400 && temp.getDX() != 0) {
				temp.setDX(0);
			}
			if(temp.getY()>600) {
				app.remove(temp.getImage());
				iter.remove();
			}
		}
		
		diff = game.getScore();
		
		if(diff==0) {
			diff=1;
		}
		
		//max difficulty
		if(diff > maxDiff)
			diff = maxDiff;
		
		delay --;
		
		//update cars on board, delete?
//		if(cars.size() != 0) {
//			for(int i = 0; i < cars.size(); i++) {
//					cars.get(i).update();	
//			}
//		}
		
		//doesn't spawn cars until delay hits 0
		if(delay != 0) {
			return;
		}
		
		//restarts delay timer
		delay = delayDefault;
		int roll;
		double x = 0;
		double y = 0;
		
//		if(diff < 45) {
//			//chooses random position for car
//			roll = rand.nextInt(3) % 3;
//			dy = 2;
//			switch(roll) {
//			case 0:
//				x = 400; //ADJUST
//				y = 0;
//				break;
//			 
//			case 1:
//				x = 300; //ADJUST
//				y = 0;
//				break;
//				
//			case 2:
//				x = 500; //ADJUST
//				y = 0;
//				break;
//
//			}
//		}
//		else {
//			x = (Math.abs(rand.nextInt()) % 401)+150;
//			System.out.println("\n rand int gen: X: " + x );
//			y = 0;
//		}
		
		//random x position is chosen
		x = (Math.abs(rand.nextInt()) % 401)+150;
		System.out.println("\n rand int gen: X: " + x );
		y = 0;
		
		//dy is randomly generated
		dy = (int) (((rand.nextInt() % diff)/8)+2); //higher difficulty means higher dy
		dx = (rand.nextInt()%4) + 2;
		if(diff < 45)
			dx = 0;
		
		System.out.println("\n dx: " + dx + " , dy: " + dy);
		System.out.println(delay);
		car = new EnemyCar(app, game, dx, dy, x, y);
		cars.add(car);
		car.show();
		
		
//		Iterator<EnemyCar> iter = EnemyCar.iterator();
//		while(iter.hasNext()) {
//			enemyCarTemp = iter.next();
//			temp.update();
			//if(program.collision(temp.getBox()), game.getPLaterBox()) == true
			//{
			//prgram.getPLayer.takeDamage();
			//program.hide();
			// iter.remove;
			//}
		//}
	}
	
	public ArrayList<EnemyCar> getCars(){
		return cars;
	}
	
//	public void increaseDifficulty() {
//		// reads timer from game and will increases spawn speed, car speed, etc. for the enemy cars
//	}
	
	public void show() {
		if(cars.size() == 0) {
			return;
		}
		for(int i = 0; i < cars.size(); i++) {
			cars.get(i).show();
		}
	}
	
	public void hide() {
		if(cars.size() == 0) {
			return;
		}
		for(int i = 0; i < cars.size(); i++) {
			cars.get(i).hide();
		}
	}
}
