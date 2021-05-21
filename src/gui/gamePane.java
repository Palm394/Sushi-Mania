package gui;

import application.Database;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.ChefZoneController;
import logic.GameController;

public class gamePane extends VBox  {
	
	private static Scene gameScene;
	private static Stage gameStage;
	private StatusBar status;
	
	public static final int WIDTH_SCREEN = 1000;
	public static final int HEIGHT_SCREEN = 600;
	
	private Stage menuStage;
	
	public gamePane() {
		gameScene = new Scene(this,WIDTH_SCREEN,HEIGHT_SCREEN);
		GameController.initialize();
		Database.initialize();
		//--- Status Bar ---
		
		status = new StatusBar();
		this.getChildren().add(status);
		
		//--- Customer Zone ---
		
		this.getChildren().add(new CustomerGUI());
		
		//--- Train Zone ---
		
		this.getChildren().add(new SushiTrainGUI());
		
		//--- Chef Zone ---

		this.getChildren().add(new ChefZoneGUI());
		ChefZoneController.updateIngredientButton();
		ChefZoneController.updateShopList();
		
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
	
	public static void backToGame() {
		gameStage.setScene(gameScene);
		gameStage.setTitle("Sushi Mania - Game");
		GameController.continueGame();
	}

	public StatusBar getStatus() {
		return status;
	}

	public static Stage getGameStage() {
		return gameStage;
	}

	public static int getWidthScreen() {
		return WIDTH_SCREEN;
	}

	public static int getHeightScreen() {
		return HEIGHT_SCREEN;
	}
}