package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.HBox;

public class tutorialPane extends HBox{
	Scene scene; 
	
	public tutorialPane(){
		scene = new Scene(this,400,600);
		this.setAlignment(Pos.CENTER);
		Image image = new Image("FirstPage.jpg",400,600,false,false);
		BackgroundImage background = new BackgroundImage(image,null,null,null,null);
		this.setBackground(new Background(background));
		createResumeButton();
	}
	
	public void createResumeButton() {
		Button resumeButton = new Button("Back to menu");
		resumeButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				menuPane.backToMenu();
			}
			
		});
		this.getChildren().add(resumeButton);
	}
	
}
