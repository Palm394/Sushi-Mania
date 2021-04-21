package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class tutorialPane extends HBox{
	Scene scene; 
	
	public tutorialPane(){
		scene = new Scene(this,400,600);
		this.setAlignment(Pos.CENTER);
		
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
