package application;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class Utility {
	
	public static Image CustomerImage;
	public static Image DishImage;
	
	public static AudioClip addScoreSound;
	
	static {
		loadResource();
	}
	
	public static void loadResource() {
		DishImage = new Image(ClassLoader.getSystemResource("dish.png").toString());
		
		addScoreSound = new AudioClip(ClassLoader.getSystemResource("addScore.wav").toString());
		CustomerImage = new Image(ClassLoader.getSystemResource("customer.png").toString());
	}
	
}
