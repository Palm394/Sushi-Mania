package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class IngredientButton extends Button{
	Ingredient ingredient;
	
	IngredientButton(int id){
		ingredient = new Ingredient(id);
		
		this.setPrefHeight(60);
		this.setPrefWidth(85);
		ImageView image = new ImageView(this.ingredient.getUrl());
		image.setPreserveRatio(true);
		image.setFitHeight(50);
		image.setFitWidth(50);
		this.setGraphic(image);
		this.setText(this.ingredient.getRemain()+"");

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
}
