package model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import logic.ChefZoneController;

public class RollButton extends Button{
	
	public RollButton(){
		
		this.setPrefHeight(65);
		this.setPrefWidth(200);
		this.setText("Roll!!");
		
		Image image = new Image("rollButton.jpg",200,63,false,false);
		BackgroundImage rollBut = new BackgroundImage(image,null,null,null,null);
		this.setBackground(new Background(rollBut));
		
		this.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				new Thread(()->{ChefZoneController.wrap(ChefZoneController.getWrapper());}).start();
			}
		}
	);
	}
	
}
