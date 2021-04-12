package gui;

import java.util.ArrayList;

import application.Utility;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import model.Food;
import model.SushiTrain;

public class SushiTrainGUI extends Canvas {

	private static GraphicsContext gc;
	private static ArrayList<Food> TrainDraw;
	
	private final static double HEIGHT = 100;
	
	public SushiTrainGUI() {
		this.setWidth(gamePane.WIDTH_SCREEN);
		this.setHeight(HEIGHT);
		
		gc = this.getGraphicsContext2D();
		
		SushiTrain.initialize();
		TrainDraw = new ArrayList<Food>();
		
		//Test
		Food a = new Food("Salmon",10);
		SushiTrain.addNewDish(a);
	}

	private static void drawSushiTrain(GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, gamePane.WIDTH_SCREEN, HEIGHT);
	}

	public static void paintComponent() {
		gc.clearRect(0, 0, gamePane.WIDTH_SCREEN, HEIGHT);
		drawSushiTrain(gc);
		
		for(Food dish : TrainDraw) {
			//if(!dish.isEat()) {
				gc.drawImage(Utility.toImage("dish.png"), dish.getPosX(), dish.getPosY());
			//}
		}
	}
	
	public static ArrayList<Food> getTrainDraw() {
		return TrainDraw;
	}

	
}
