package gui;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class gamePane extends Canvas  {
	
	private VBox root;
	private Scene gameScene;
	private Stage gameStage;
	
	private final int WIDTH_SIZE = 1000;
	private final int HEIGHT_SIZE = 600;
	
	private Stage menuStage;
	
	public gamePane() {
		root = new VBox();
		gameScene = new Scene(root,WIDTH_SIZE,HEIGHT_SIZE);

		//--- Status Bar ---
		
		
		//--- Customer Zone ---
		
		
		//--- Train Zone ---
		
		SushiTrainPart sushiTrain = new SushiTrainPart();
		root.getChildren().add(sushiTrain.getRoot());
		
		//--- Chef Zone ---
		
		
		//--- End ---
		
		gameStage = new Stage();
		gameStage.setTitle("Sushi Mania - Game");
		gameStage.setScene(gameScene);
		gameStage.setResizable(false);
		
	}
	
	public void createNewGame(Stage menuStage) {
		this.menuStage = menuStage; 
		this.menuStage.close();
		gameStage.show();
	}

	public static void paintComponent() {
		// TODO Auto-generated method stub
		
	}

}
