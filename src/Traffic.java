import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Traffic {
	ArrayList<EnemyCar> cars;
	
	private int delay = 1;
	private int delayDefault = 400;
	private long diff = 1;
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
		diff = game.getScore();
		delay --;
		
		//update cars on board
		if(cars.size() != 0) {
			for(int i = 0; i < cars.size(); i++) {
					cars.get(i).update();	
			}
		}
		
		//doesn't spawn cars until delay hits 0
		if(delay != 0) {
			return;
		}
		
		//restarts delay timer
		delay = delayDefault;
		int roll;
		double x = 400;
		double y = 300;
		
		if(diff < 15) {
			//chooses random position for car
			roll = rand.nextInt(3) % 3;
			switch(roll) {
			case 0:
			  x = 400; //ADJUST
			  y = 0;
			 break;
			 
			case 1:
				 x = 300; //ADJUST
				 y = 0;
				break;
				
			case 2:
				 x = 500; //ADJUST
				 y = 0;
				break;

			}
			car = new EnemyCar(app, game, 0.0, 2.0, x, y);
			cars.add(car);
			car.show();
		}
		
		
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
	
	public void increaseDifficulty() {
		// reads timer from game and will increases spawn speed, car speed, etc. for the enemy cars
	}
	
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
