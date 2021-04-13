package application;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class Utility {
	
	public static Image CustomerImage;
	public static Image DishImage;
	
	public static AudioClip NewLevelSound;
	public static AudioClip EatSound;
	
	private static ArrayList<AudioClip> SoundList = new ArrayList<AudioClip>();
	
	public static double volume;
	
	static {
		loadResource();
		
		SoundList.add(NewLevelSound);
		SoundList.add(EatSound);
	}
	
	public static void loadResource() {
		DishImage = new Image(ClassLoader.getSystemResource("dish.png").toString());
		CustomerImage = new Image(ClassLoader.getSystemResource("customer.png").toString());
		
		NewLevelSound = new AudioClip(ClassLoader.getSystemResource("NewLevel.wav").toString());
		EatSound = new AudioClip(ClassLoader.getSystemResource("EatSound.mp3").toString());
	}
	
	public static void setAllVolume(double new_volume) {
		volume = new_volume;
		SoundList.forEach(e -> {
			e.setVolume(new_volume);
		});
	}
	
}
