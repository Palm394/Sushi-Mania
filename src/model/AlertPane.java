package model;

import gui.gamePane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public abstract class AlertPane {
	private Scene scene;
	private BorderPane root;
	private Label name;

	public AlertPane(String title,double W,double H) {
		root = new BorderPane();
		scene = new Scene(root,W,H);
		gamePane.getGameStage().setTitle("Sushi Mania - " + title);
		
		name = new Label(title);
		name.setAlignment(Pos.CENTER);
		root.setTop(name);
		
		root.setCenter(center());
	}
	
	private Button createContinueButton() {
		Button cont = new Button("CONTINUE");
		cont.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				gamePane.backToGame();
			}
			
		});
		
		return cont;
	}
	
	private VBox center() {
		 VBox center = new VBox();
		 center.getChildren().add(createContinueButton());
		 
		 return center;
	}
	
	public Scene getScene() {
		return scene;
	}
}
