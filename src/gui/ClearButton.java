package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import logic.ChefZoneController;
import logic.GameController;

public class ClearButton extends Button{
	
	public ClearButton() {
		this.setPrefHeight(75);
		this.setPrefWidth(75);
		this.setText("Clear");
		this.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				if(GameController.getScore() >= 30 && ChefZoneController.getWrapper().size()>0)
				{
					GameController.addScore(-30);
					ChefZoneController.getWrapper().clear();
					ChefZoneGUI.rollpane.removeIngredient();
				}
			}
		}
	);
	}
	}

