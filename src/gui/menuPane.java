package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class menuPane extends StackPane {
	
	private Scene menuScene;
	private Stage menuStage;
	
	private final int WIDTH_SIZE = 400;
	private final int HEIGHT_SIZE = 600;
	
	public menuPane() {
		createStartButton();
		
		menuScene = new Scene(this,WIDTH_SIZE,HEIGHT_SIZE);
		menuStage = new Stage();
		menuStage.setScene(menuScene);
		menuStage.setTitle("Sushi Mania - Menu");
		menuStage.setResizable(false);
	}
	
	public void createStartButton() {
		Button startButton = new Button("Start Game");
		
		startButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				gamePane game = new gamePane();
				game.createNewGame(menuStage);
			}
			
		});
		this.getChildren().add(startButton);
	}
	
	public Stage getMenuStage() {
		return menuStage;
	}
	
	
}
