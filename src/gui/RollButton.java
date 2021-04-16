package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import logic.ChefZoneController;

public class RollButton extends Button{
	
	RollButton(){
		this.setPrefHeight(75);
		this.setPrefWidth(135);
		this.setText("ROLL!!!");
		this.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				ChefZoneController.wrap(ChefZoneController.getWrapper());
			}
		}
	);
	}
	
}
