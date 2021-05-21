package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.VBox;
import logic.ChefZoneController;

public class CreditPane extends VBox{
	private Scene scene;
	
	public CreditPane() {
		scene = new Scene(this,400,600);
		this.setAlignment(Pos.CENTER);
		Image image = new Image("CreditPage.jpg",400,600,false,false);
		BackgroundImage background = new BackgroundImage(image,null,null,null,null);
		this.setBackground(new Background(background));
		
		Label blank = new Label("vbvb");
		blank.setPrefHeight(150);
		this.getChildren().add(blank);		
		createResumeButton();
	}
	
	public void createResumeButton() {
		Button resumeButton = new Button("Back to menu");
		resumeButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				ChefZoneController.soundPlay("sound/ClickSound.wav");
				menuPane.backToMenu();
			}
			
		});
		this.getChildren().add(resumeButton);
	}
}
