import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	private boolean[] keys; //keeps track of all possible keypresses
	private int[] pulled;
	
	public KeyHandler() {
		keys = new boolean[256];
		pulled = new int[256];
	}
	
	//checks whether it was pressed or not
	public boolean keyDown(int keycode) {
		return pulled[keycode] > 0;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
