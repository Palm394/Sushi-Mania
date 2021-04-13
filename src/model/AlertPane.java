package model;

import gui.gamePane;
import gui.menuPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import logic.GameController;

public abstract class AlertPane {
	private Scene scene;
	private BorderPane root;
	private String name;
	
	protected HBox top;
	protected VBox center;

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
		 title.setFont(new Font(50));
		 VBox.setMargin(title, new Insets(50, 0, 30, 0));
		 
		 center.getChildren().add(title);
		 center.setAlignment(Pos.TOP_CENTER);
		 addCenter();
		 
		 root.setCenter(center);
	}
	
	protected abstract void addCenter();
	
	private void top() {
		top = new HBox();
		
		top.getChildren().add(closeButton());
		top.setAlignment(Pos.CENTER_RIGHT);
		
		root.setTop(top);
	}
	
	protected Button closeButton() {
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
	
	protected Button continueButton() {
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
	
	protected Button backToMenu() {
		Button button = new Button("BACK TO MENU");
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				gamePane.getGameStage().close();
				menuPane new_menu = new menuPane();
				new_menu.getMenuStage().show();
			}
			
		});
		VBox.setMargin(button, new Insets(50, 0, 0, 0));
		button.setAlignment(Pos.CENTER);
		return button;
	}
	
	public Scene getScene() {
		return scene;
	}
}
