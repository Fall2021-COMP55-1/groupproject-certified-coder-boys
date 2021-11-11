import java.util.ArrayList;
import java.util.Iterator;



public class Traffic {
	ArrayList<EnemyCar> cars;
	
	private int delay = 400;
	
	
	public Traffic(MainApplication program, GraphicsPane game) {
		// TODO Auto-generated constructor stub
		cars = new ArrayList <EnemyCar>();
		
	}
	
	public void update() {
		delay --;
		if(delay == 0) {
			//makeCar();
			//delay = delayDefault;
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
}
