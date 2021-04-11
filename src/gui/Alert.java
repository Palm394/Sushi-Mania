package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class Alert {
	private Scene scene;
	private VBox root;

	public Alert(double W,double H) {
		root = new VBox();
		scene = new Scene(root,W,H);
		
		Button cont = new Button("CONTINUE");
		cont.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				gamePane.backToGame();
			}
			
		});
		root.getChildren().add(cont);
		
		
	}
	
	public Scene getScene() {
		return scene;
	}
}
