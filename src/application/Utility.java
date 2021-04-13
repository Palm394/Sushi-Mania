package application;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class Utility {
	
	public static Image CustomerImage;
	public static Image DishImage;
	
	public static AudioClip NewLevelSound;
	
	private static ArrayList<AudioClip> SoundList = new ArrayList<AudioClip>();
	
	static {
		loadResource();
		SoundList.add(NewLevelSound);
	}
	
	public static void loadResource() {
		DishImage = new Image(ClassLoader.getSystemResource("dish.png").toString());
		CustomerImage = new Image(ClassLoader.getSystemResource("customer.png").toString());
		
		NewLevelSound = new AudioClip(ClassLoader.getSystemResource("NewLevel.wav").toString());
	}
	
	public static void setAllVolume(double new_volume) {
		SoundList.forEach(e -> {
			e.setVolume(new_volume);
		});
	}
	
}
