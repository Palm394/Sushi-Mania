package model.base;

import java.util.ArrayList;
import java.util.List;

public class UpdatableHolder {
	private static final UpdatableHolder instance = new UpdatableHolder();
	
	private List<Updatable> entities;
	
	static {
		loadResource();
	}
	
	public UpdatableHolder() {
		entities = new ArrayList<Updatable>();
	}

	public static UpdatableHolder getInstance() {
		return instance;
	}

	public static void loadResource() {
//Example
//		mapSprite = new Image(ClassLoader.getSystemResource("Map.png").toString());
//		mineSprite = new Image(ClassLoader.getSystemResource("Mine.png").toString());
//		explosionSound = new AudioClip(ClassLoader.getSystemResource("Explosion.wav").toString());
	}
}
