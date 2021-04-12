package model;

import gui.gamePane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.GameController;

public abstract class AlertPane {
	private Scene scene;
	private BorderPane root;
	private String name;
	
	private VBox center;

	public AlertPane(String title,double W,double H) {
		GameController.pauseGame();
		
		root = new BorderPane();
		scene = new Scene(root,W,H);
		name = title;
		
		gamePane.getGameStage().setTitle("Sushi Mania - " + title);
		
		top();
		center();
		
	}
	
	private void center() {
		 center = new VBox();
		 
		 Label title = new Label(name);
		 
		 center.getChildren().add(title);
		 center.setAlignment(Pos.CENTER);
		 addCenter();
		 
		 root.setCenter(center);
	}
	
	protected abstract void addCenter();
	
	private void top() {
		HBox top = new HBox();
		
		top.getChildren().add(closeButton());
		top.setAlignment(Pos.CENTER_RIGHT);
		
		root.setTop(top);
	}
	
	private Button closeButton() {
		Button cont = new Button("X");
		
		cont.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				gamePane.backToGame();
			}
			
		});
		cont.setAlignment(Pos.CENTER_RIGHT);
		return cont;
	}
	
	private Button continueGame() {
		Button cont = new Button("CONTINUE");
		cont.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				gamePane.backToGame();
			}
			
		});
		cont.setAlignment(Pos.CENTER);
		return cont;
	}
	
	public Scene getScene() {
		return scene;
	}
}
