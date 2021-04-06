package gui;

import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import model.Food;
import model.SushiTrain;

public class SushiTrainPart {
	private static HBox root;
	private static GraphicsContext gc;
	
	private final double WIDTH = 1000;
	private final double HEIGHT = 100;
	
	public SushiTrainPart() {
		root = new HBox();
		
		Canvas canvas = new Canvas(WIDTH,HEIGHT);
		gc = canvas.getGraphicsContext2D();
		
		drawSushiTrain(gc);
		
		root.getChildren().add(canvas);
	}
	
	private void drawSushiTrain(GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, WIDTH, HEIGHT);
	}
	
	public static void drawNewDish(Food dish) {
		String image_path = "file:res/dish.png";
		Image image = new Image(image_path);
		
		gc.drawImage(image, 0, 0);
	}
	
	public static Parent getRoot() {
		return root;
	}
	
	
}
