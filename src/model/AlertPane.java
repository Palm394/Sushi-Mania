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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
		 VBox.setMargin(title, new Insets(0, 0, 30, 0));
		 
		 center.getChildren().add(title);
		 center.setAlignment(Pos.CENTER);
		 addCenter();
		 
		 root.setCenter(center);
	}
	
	protected void addCenter() {
		
	}
	
	private void top() {
		top = new HBox();
		
		top.getChildren().add(closeButton());
		top.setAlignment(Pos.BASELINE_RIGHT);
		
		root.setTop(top);
	}
	
	protected Button closeButton() {
		Image img = new Image(ClassLoader.getSystemResource("closeButton.png").toString());
	    ImageView view = new ImageView(img);
	    view.setFitHeight(50);
	    view.setFitWidth(50);
	    
		Button button = new Button();
		
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				gamePane.backToGame();
			}
			
		});
		
		button.setGraphic(view);
		button.setStyle("-fx-background-color: transparent;");

		return button;
	}
	
	protected NavButton continueButton() {
		NavButton cont = new NavButton("CONTINUE");
		cont.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				gamePane.backToGame();
			}
			
		});
		VBox.setMargin(cont, new Insets(50, 0, 0, 0));
		return cont;
	}
	
	protected NavButton backToMenu() {
		NavButton button = new NavButton("BACK TO MENU");
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				gamePane.getGameStage().close();
				menuPane new_menu = new menuPane();
				new_menu.getMenuStage().show();
			}
			
		});
		VBox.setMargin(button, new Insets(50, 0, 0, 0));
		return button;
	}
	
	public Scene getScene() {
		return scene;
	}
}
