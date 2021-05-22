package gui;

import java.util.ArrayList;

import application.Utility;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import model.FoodList;
import model.SushiTrain;

public class SushiTrainGUI extends Canvas {

	private static GraphicsContext gc;
	private static ArrayList<FoodList> TrainDraw;
	
	private static int PosX = 0;
	
	private final static double HEIGHT = 100;
	
	public SushiTrainGUI() {
		this.setWidth(gamePane.WIDTH_SCREEN);
		this.setHeight(HEIGHT);
		
		gc = this.getGraphicsContext2D();
		
		SushiTrain.initialize();
		TrainDraw = new ArrayList<FoodList>();
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
		
		for(FoodList dish : TrainDraw) {
			gc.drawImage(Utility.DISH, dish.getPosX() - 20, dish.getPosY() - 5);
			gc.drawImage(dish.getImage(), dish.getPosX(), dish.getPosY() + 20);
		}
	}
	
	public static ArrayList<FoodList> getTrainDraw() {
		return TrainDraw;
	}

	
}
