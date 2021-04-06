package gui;

import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class CustomerGUI {
	private static HBox root;
	private static GraphicsContext gc;
	
	private final static double HEIGHT = 150;
	
	public static void initialize() {
		root = new HBox();
		
		Canvas canvas = new Canvas(gamePane.WIDTH_SCREEN,HEIGHT);
		gc = canvas.getGraphicsContext2D();
		
		drawBG(gc);
		
		root.getChildren().add(canvas);
	}
	
	private static void drawBG(GraphicsContext gc) {
		gc.setFill(Color.GREY);
		gc.fillRect(0, 0, gamePane.WIDTH_SCREEN, HEIGHT);
	}

	public static Parent getRoot() {
		return root;
	}
}
