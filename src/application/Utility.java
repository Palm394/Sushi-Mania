package application;

import javafx.scene.image.Image;

public class Utility {
	
	public static Image toImage(String fileName) {
		String image_path = "file:res/" + fileName;
		Image image = new Image(image_path);
		return image;
	}
	
}
