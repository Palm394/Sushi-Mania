package gui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class gamePane extends Canvas  {
	
	private VBox root,head;
	private HBox bottom;
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
		//--- Table Zone --
		head = new VBox();
		head.setPrefSize(1000, 300);
		//--- Chef Zone ---
		Parent bottom;
		try {
			bottom = FXMLLoader.load(getClass().getResource("chefZone.fxml"));
		// add components
		root.getChildren().add(head);
		root.getChildren().add(bottom);		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
