package model.base;

import java.util.ArrayList;
import java.util.List;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();
	
	private List<Renderable> entities;
	
	static {
		loadResource();
	}
	
	public RenderableHolder() {
		entities = new ArrayList<Renderable>();
	}

	public static RenderableHolder getInstance() {
		return instance;
	}

	public static void loadResource() {
//Example
//		mapSprite = new Image(ClassLoader.getSystemResource("Map.png").toString());
//		mineSprite = new Image(ClassLoader.getSystemResource("Mine.png").toString());
//		explosionSound = new AudioClip(ClassLoader.getSystemResource("Explosion.wav").toString());
	}
}
