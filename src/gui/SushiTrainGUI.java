package gui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import model.Food;
import model.SushiTrain;

public class SushiTrainGUI extends HBox {

	private static GraphicsContext gc;
	
	private final static double HEIGHT = 100;
	
	public SushiTrainGUI() {
		Canvas canvas = new Canvas(gamePane.WIDTH_SCREEN,HEIGHT);
		gc = canvas.getGraphicsContext2D();
		
		this.getChildren().add(canvas);
		
		//Test
		Food a = new Food("Salmon",10);
		SushiTrain.addNewDish(a);
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
}
