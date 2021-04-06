package gui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class gamePane extends Canvas  {
	
	private VBox root;
	private Scene gameScene;
	private Stage gameStage;
	
	public static final int WIDTH_SCREEN = 1000;
	public static final int HEIGHT_SCREEN = 600;
	
	private Stage menuStage;
	
	public gamePane() {
		root = new VBox();
		gameScene = new Scene(root,WIDTH_SCREEN,HEIGHT_SCREEN);

		//--- Status Bar ---
		
		
		//--- Customer Zone ---
		
		
		//--- Train Zone ---
		
		SushiTrainGUI.initialize();
		root.getChildren().add(SushiTrainGUI.getRoot());
		
		//--- Chef Zone ---
		Parent bottom;
		try {
			bottom = FXMLLoader.load(getClass().getResource("chefZone.fxml"));
		// add components
		root.getChildren().add(bottom);		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//--- End ---
		
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