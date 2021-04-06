package gui;

import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import model.Food;
import model.SushiTrain;

public class SushiTrainGUI {
	private static HBox root;
	private static GraphicsContext gc;
	
	private final static double HEIGHT = 100;
	
	public static void initialize() {
		root = new HBox();
		
		Canvas canvas = new Canvas(gamePane.WIDTH_SCREEN,HEIGHT);
		gc = canvas.getGraphicsContext2D();
		
		//Test
		Food a = new Food("Salmon",10);
		SushiTrain.addNewDish(a);
		
		root.getChildren().add(canvas);
	}
	
	private static void drawSushiTrain(GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, gamePane.WIDTH_SCREEN, HEIGHT);
	}
	
	public static void drawDish(Food dish) {
		String image_path = "file:res/dish.png";
		Image image = new Image(image_path);
		
		gc.clearRect(0, 0, gamePane.WIDTH_SCREEN, HEIGHT);
		
		drawSushiTrain(gc);
		gc.drawImage(image, dish.getPosX(), dish.getPosY());
	}
	
	public static Parent getRoot() {
		return root;
	}
	
	
}
