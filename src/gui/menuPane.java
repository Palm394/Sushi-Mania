package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class menuPane extends VBox {
	
	private static Scene menuScene;
	private static Stage menuStage;
	
	private final static int WIDTH_SIZE = 400;
	private final static int HEIGHT_SIZE = 600;
	
	public menuPane() {
		
		this.setAlignment(Pos.CENTER);
		this.setSpacing(20);
		
		createStartButton();
		tutorialButton();
		creditButton();
		
		menuScene = new Scene(this,WIDTH_SIZE,HEIGHT_SIZE);
		menuStage = new Stage();
		menuStage.setScene(menuScene);
		menuStage.setTitle("Sushi Mania - Menu");
		menuStage.setResizable(false);
	}
	
	public void createStartButton() {
		Button startButton = new Button("Start Game");
		startButton.setPrefWidth(160);
		startButton.setPrefHeight(40);
		startButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				gamePane game = new gamePane();
				game.createNewGame(menuStage);
			}
			
		});
		this.getChildren().add(startButton);
	}
	
	
	public void tutorialButton() {
		Button tutorialButton = new Button("How to play");
		tutorialButton.setPrefWidth(160);
		tutorialButton.setPrefHeight(40);		
		tutorialButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				tutorialPane tutorial = new tutorialPane();
				menuStage.setScene(tutorial.scene);
				menuStage.setTitle("Sushi Mania - Tutorial");
			}
			
		});
		this.getChildren().add(tutorialButton);
	}
	
	
	public void creditButton() {
		Button creditButton = new Button("Credit");
		creditButton.setPrefWidth(160);
		creditButton.setPrefHeight(40);		
		creditButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				creditPane credit = new creditPane();
				menuStage.setScene(credit.scene);
				menuStage.setTitle("Sushi Mania - Credit");
			}
			
		});
		this.getChildren().add(creditButton);
	}
	
	public static void backToMenu() {
		menuStage.setScene(menuScene);
		menuStage.setTitle("Sushi Mania - Menu");
	}
	
	public Stage getMenuStage() {
		return menuStage;
	}

	public static int getWIDTH_SIZE() {
		return WIDTH_SIZE;
	}

	public static int getHEIGHT_SIZE() {
		return HEIGHT_SIZE;
	}
	
	
}
