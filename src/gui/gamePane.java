package gui;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class gamePane  {
	
	private VBox root;
	private Scene gameScene;
	private Stage gameStage;
	
	private final int WIDTH_SIZE = 1000;
	private final int HEIGHT_SIZE = 600;
	
	private Stage menuStage;
	
	public gamePane() {
		root = new VBox();
		gameScene = new Scene(root,WIDTH_SIZE,HEIGHT_SIZE);
		
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

}
