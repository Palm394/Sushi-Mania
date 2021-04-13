package application;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class Utility {
	
	public static Image CustomerImage;
	public static Image DishImage;
	
	public static AudioClip addScoreSound;
	
	private static ArrayList<AudioClip> SoundList = new ArrayList<AudioClip>();
	
	static {
		loadResource();
		SoundList.add(addScoreSound);
	}
	
	public static void loadResource() {
		DishImage = new Image(ClassLoader.getSystemResource("dish.png").toString());
		CustomerImage = new Image(ClassLoader.getSystemResource("customer.png").toString());
		
		addScoreSound = new AudioClip(ClassLoader.getSystemResource("addScore.wav").toString());
	}
	
	public static void setAllVolume(double newValue) {
		SoundList.forEach(e -> {
			e.setVolume(newValue);
		});
	}
	
}
