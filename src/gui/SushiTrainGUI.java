package gui;

import java.util.ArrayList;

import application.Utility;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import model.Food;
import model.FoodList;
import model.SushiTrain;

public class SushiTrainGUI extends Canvas {

	private static GraphicsContext gc;
	private static ArrayList<Food> TrainDraw;
	
	private static int PosX = 0;
	
	private final static double HEIGHT = 100;
	
	public SushiTrainGUI() {
		this.setWidth(gamePane.WIDTH_SCREEN);
		this.setHeight(HEIGHT);
		
		gc = this.getGraphicsContext2D();
		
		SushiTrain.initialize();
		TrainDraw = new ArrayList<Food>();
		
		//Test
		Food a = new FoodList(28700092);
		SushiTrain.addNewDish(a);
	}

	private static void drawSushiTrain(GraphicsContext gc) {
		gc.drawImage(Utility.SushiTrainBG, PosX, 0);
		gc.drawImage(Utility.SushiTrainBG, -gamePane.WIDTH_SCREEN + PosX , 0);
		PosX += 1;
		if(PosX > gamePane.WIDTH_SCREEN) {
			PosX = 0;
		}
	}

	public static void paintComponent() {
		gc.clearRect(0, 0, gamePane.WIDTH_SCREEN, HEIGHT);
		drawSushiTrain(gc);
		
		for(Food dish : TrainDraw) {
			//if(!dish.isEat()) {
				gc.drawImage(Utility.DishImage, dish.getPosX(), dish.getPosY());
			//}
		}
	}
	
	public static ArrayList<Food> getTrainDraw() {
		return TrainDraw;
	}

	
}
