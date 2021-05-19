package model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import logic.ChefZoneController;

public class IngredientButton extends Button{
	public Ingredient ingredient;
	
	public IngredientButton(Ingredient ingredient){
		this.ingredient = ingredient;
		this.setPrefHeight(60);
		this.setPrefWidth(85);
		this.setStyle("-fx-background-color: rgba(245,222,179,0.7);");
		ImageView image = new ImageView(this.ingredient.getUrl());
		image.setPreserveRatio(true);
		image.setFitHeight(50);
		image.setFitWidth(50);
		this.setGraphic(image);
		this.setText(this.ingredient.getRemain()+"");
		
		this.lock();
		
		IngredientButton button = this;
		
		this.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				if(ingredient.getRemain()>0 && ChefZoneController.getWrapper().size() < 12) {
					ChefZoneController.addIngredient(button);
					}
				}
			}
		);	
	}
	
	public void buyIngredient() {
		this.ingredient.setRemain(this.ingredient.getRemain() + 10);
		this.setText(this.ingredient.getRemain()+"");
	}
	
	public void lock() {
		this.setDisable(true);
	}
	
	public void unlock() {
		this.setDisable(false);
	} 
	
}
