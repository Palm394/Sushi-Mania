package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class RollButton extends Button{
	
	RollButton(){
		this.setPrefHeight(75);
		this.setPrefWidth(85);
		this.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				ChefZoneController.wrap(ChefZoneController.getWrapper());
			}
		}
	);
	}
	
}
