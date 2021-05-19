package model;

import gui.ChefZoneGUI;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import logic.ChefZoneController;
import logic.GameController;

public class ClearButton extends Button{
	
	public ClearButton() {
		this.setPrefHeight(65);
		this.setPrefWidth(75);
		this.setText("Clear");
		Image image = new Image("clearButton.jpg",75,63,false,false);
		BackgroundImage clearBut = new BackgroundImage(image,null,null,null,null);
		this.setBackground(new Background(clearBut));
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

