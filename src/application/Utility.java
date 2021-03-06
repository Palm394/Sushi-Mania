package application;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class Utility {
	
	public static Image SushiTrainBG;
	public static Image BackgroundImage;
	public static Image CustomerImage;
	public static Image DISH;
	
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
		SushiTrainBG = new Image(ClassLoader.getSystemResource("sushiTrain.png").toString());
		BackgroundImage = new Image(ClassLoader.getSystemResource("customerUP.png").toString());
		CustomerImage = new Image(ClassLoader.getSystemResource("customerDOWN.png").toString());
		DISH = new Image(ClassLoader.getSystemResource("dish.png").toString());
		
		NewLevelSound = new AudioClip(ClassLoader.getSystemResource("sound/NewLevel.wav").toString());
		EatSound = new AudioClip(ClassLoader.getSystemResource("sound/EatSound.mp3").toString());
	}

	public static void setAllVolume(double newValue) {
		volume = newValue;
		SoundList.forEach(e -> {
			e.setVolume(newValue);
		});
	}
	
}
