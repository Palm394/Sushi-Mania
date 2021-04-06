package gui;

import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import model.SushiTrain;

public class SushiTrainPart {
	private static HBox root;
	
	public SushiTrainPart() {
		root = new HBox();
		
		Canvas canvas = new Canvas(1000,100);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		String image_path = "file:res/dish.png";
		Image image = new Image(image_path);
		
		drawSushiTrain(gc);
		gc.drawImage(image, 0, 0);
		root.getChildren().add(canvas);

	}
	
	private void drawSushiTrain(GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, 1000, 100);
	}
	
	public static void drawNewDish(GraphicsContext gc) {
		
	}
	
	public static Parent getRoot() {
		return root;
	}
	
	
}
