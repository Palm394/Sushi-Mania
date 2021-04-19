package gui;

import java.util.ArrayList;

import application.Utility;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Food;
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
		
		//Test
		FoodList a = new FoodList(28700092);
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
		
		for(FoodList dish : TrainDraw) {
			//if(!dish.isEat()) {
				Image drawing = new Image(ClassLoader.getSystemResource(dish.getUrl()).toString(),60,60, false, false);
				gc.drawImage(drawing, dish.getPosX(), dish.getPosY() + 20);
			//}
		}
	}
	
	public static ArrayList<FoodList> getTrainDraw() {
		return TrainDraw;
	}

	
}
