package gui;

import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import model.SushiTrain;

public class SushiTrainPart {
	private static HBox root;
	
	public SushiTrainPart() {
		root = new HBox();
		
		Canvas canvas = new Canvas(1000,100);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		drawReleaseZone(gc);
		drawSushiTrain(gc);
		
		root.getChildren().add(canvas);

	}

	private void drawReleaseZone(GraphicsContext gc) {
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, 100, 100);
	}
	
	private void drawSushiTrain(GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		gc.fillRect(100, 0, 900, 100);
	}
	
	public static void drawNewDish(GraphicsContext gc) {
		
	}
	
	public static Parent getRoot() {
		return root;
	}
	
	
}
