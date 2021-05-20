package application;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import gui.menuPane;
import javafx.application.Application;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		menuPane menu = new menuPane();
		
		Database.initialize();
		Utility.setAllVolume(0.5);
		primaryStage = menu.getMenuStage();
		primaryStage.show();	
		
//		new Thread(()->{
//			String url = "sound/Night_of_the_Yakuza.mp3";
//			while(true) {
//				AudioClip sound = new AudioClip(ClassLoader.getSystemResource(url).toString());
//				sound.setVolume(Utility.volume);
//				sound.play();
//				try {
//					TimeUnit.SECONDS.sleep(120);
//				} catch (Exception e) {
//					System.out.println("oops! something went wrong!");
//				}
//			}	
//		}).start();
	
		String url = "\\Night_of_the_Yakuza.mp3";
		Thread music = new Thread() {
			public void run() {
				Clip clip;
				try {
					AudioInputStream input = AudioSystem.getAudioInputStream(new File(url));
					clip = AudioSystem.getClip();
					clip.open(input);
					clip.loop(Clip.LOOP_CONTINUOUSLY);
					clip.start();
				} catch (Exception e) {
					System.out.println("oops! something went wrong!");
				} 
			}
		};
		music.start();
		
	}
}