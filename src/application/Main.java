package application;

import java.util.concurrent.TimeUnit;
import gui.menuPane;
import javafx.application.Application;
import javafx.scene.image.Image;
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

		// play music loop
		new Thread(() -> {
			String url = "sound/Night_of_the_Yakuza.mp3";
			while (true) {
				AudioClip sound = new AudioClip(ClassLoader.getSystemResource(url).toString());
				sound.setVolume(Utility.volume);
				sound.play();
				try {
					TimeUnit.SECONDS.sleep(120);
				} catch (Exception e) {
					System.out.println("oops! something went wrong!");
				}
			}
		}).start();
	}

	@Override
	public void stop() {
		System.exit(0);
	}
}