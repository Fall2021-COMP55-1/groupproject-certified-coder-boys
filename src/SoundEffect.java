import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class SoundEffect {
	static Clip Audio;
	SoundEffect(){}
	static void PLAY(File SelectAudio) {
		try {
			Audio = AudioSystem.getClip();
			Audio.open(AudioSystem.getAudioInputStream(SelectAudio));
			Audio.start();
			Thread.sleep(Audio.getMicrosecondLength()/1000);
		}
		catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
	static void STOP() {
		Audio.stop();
		Audio.close();
		//Austin Was Here
	}
	public static void main (String [] args) {
		File TestAudio= new File("SoundAssets/mute city 3.5.wav");
		PLAY(TestAudio);
	}
}



//public class SoundEffect {
//	JFrame window;
//	Container con;
//	JPanel buttonPanel;
//	JButton soundButton;
//	String clickSound;
//	ButtonHandler bHandler = new ButtonHandler();
//	SoundEffect se = new SoundEffect();
//	
//
//	public static void main(String[] args) {
//		
//		new SoundEffect();
//
//	}
//	
//	public SoundEffect(){
//		
//		window = new JFrame();
//		window.setSize(800, 600);
//		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		window.getContentPane().setBackground(Color.black);
//		window.setLayout(null);
//		con = window.getContentPane();
//		
//		buttonPanel = new JPanel();
//		buttonPanel.setBounds(300, 300, 200, 100);
//		buttonPanel.setBackground(Color.black);
//		con.add(buttonPanel);
//		
//		soundButton = new JButton("Sound");
//		soundButton.setFocusPainted(false);
//		soundButton.addActionListener(bHandler);
//		soundButton.setActionCommand("soundB");
//		buttonPanel.add(soundButton);
//				
//		window.setVisible(true);
//			
//         //Our audio file name in the res folder
//		clickSound = ".//SoundAssets/F-Zero - Mute City.wav/";
//
//
//	}
//	
//	public class Sound {
//		
//		Clip clip;
//		
//		public void setFile(String soundFileName){
//			
//			try{
//				File file = new File(soundFileName);
//				AudioInputStream sound = AudioSystem.getAudioInputStream(file);	
//				clip = AudioSystem.getClip();
//				clip.open(sound);
//			}
//			catch(Exception e){
//				
//			}
//		}
//		
//		public void play(){
//			
//			clip.setFramePosition(0);
//			clip.start();
//		}
//
//	}
//	
//	public class ButtonHandler implements ActionListener{
//		
//		public void actionPerformed(ActionEvent event){ // figure out this actionPerformed!!!
//			
////			se.setFile(clickSound);
////			se.play();							
//		}
//	}
//
////*}
