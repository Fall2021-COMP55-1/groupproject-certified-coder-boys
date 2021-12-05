import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import acm.program.GraphicsProgram;

public class MainApplication extends GraphicsProgram {
	
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	public static final String MUSIC_FOLDER = "sounds";

	private GraphicsPane curScreen;
	private SomePane somePane;
	private MenuPane menu;
	private PlayPane game;
	private HighScoreMenu highScorePane;
	private TitleScreenPane titleScreen;
	private GameOverPane over;
	private NameInput name;
	
	/* Method: setupInteractions
	 * -------------------------
	 * must be called before switching to another
	 * pane to make sure that interactivity
	 * is setup and ready to go.
	 */
	protected void setupInteractions() {
		requestFocus();
		addKeyListeners();
		addMouseListeners();
	}
	
	/* switchToScreen(newGraphicsPane)
	 * -------------------------------
	 * will simply switch from making one pane that was currently
	 * active, to making another one that is the active class.
	 */
	protected void switchToScreen(GraphicsPane newScreen) {
		if(curScreen != null) {
			curScreen.hideContents();
		}
		newScreen.showContents();
		curScreen = newScreen;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(curScreen != null) {
			curScreen.mousePressed(e);
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if(curScreen != null) {
			curScreen.mouseReleased(e);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(curScreen != null) {
			curScreen.mouseClicked(e);
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(curScreen != null) {
			curScreen.mouseDragged(e);
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		if(curScreen != null) {
			curScreen.mouseMoved(e);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(curScreen != null) {
			curScreen.keyPressed(e);
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(curScreen != null) {
			curScreen.keyReleased(e);
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		if(curScreen != null) {
			curScreen.keyTyped(e);
		}
	}
	

	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public void run() {
		System.out.println("Let's make something awesome!");
		somePane = new SomePane(this);
		
		menu = new MenuPane(this);
		highScorePane = new HighScoreMenu(this);
		game = new PlayPane(this);
		titleScreen = new TitleScreenPane(this);
		over = new GameOverPane(this);
		name = new NameInput(this);
		
		//switchToMenu();
		setupInteractions();
		//switchToGameMenu();
		SwitchtoSound();
	}
	
	public void SwitchtoSound() {
		switchToScreen(titleScreen);
		
		if (SoundEffect.Audio != null) {
			SoundEffect.STOP();
		}
		SoundEffect.PLAY(new File("SoundAssets/F-Zero - Mute City (128 kbps).wav"));
	}

	public void newHighScore(String name, int score) throws IOException {
		highScorePane.newHighScore(name, score);
	}
	
	public void updateScore() {
		highScorePane.update();
	}
	
	public void setScore(long score) {
		over.setScore(score);
	}
	
	public void setName(String name) {
		over.setName(name);
	}

	public void switchToMenu() {
		switchToScreen(menu);
	}

	public void switchToSome() {
		switchToScreen(somePane);
	}
	
	public void switchToGameMenu() {
		switchToScreen(titleScreen);
	}
	
	public void switchToHighScore() {
		switchToScreen(highScorePane);
	}
	
	public void switchToGameOver() {
		switchToScreen(over);
	}
	
	public void switchToNameInput() {
		switchToScreen(name);
	}
	
	public void switchToGame() {
		switchToScreen(game);
		//game.run();
	}
	

	public static void main(String[] args) {
		new MainApplication().start();
	}
}