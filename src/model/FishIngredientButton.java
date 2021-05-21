package model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import logic.ChefZoneController;
import model.base.Boostable;

public class FishIngredientButton extends IngredientButton implements Boostable {
	
	public FishIngredientButton(Ingredient ingredient) {
		
		super(ingredient);
		
		FishIngredientButton button = this;
		
		this.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				if(ingredient.getRemain()>0 && ChefZoneController.getWrapper().size() < 12) {
					ChefZoneController.addIngredient(button);
					ChefZoneController.soundPlay("sound/TickSound.wav");
					if(ChefZoneController.isFishBoost() == true)
					{
						ChefZoneController.setExtraScore(ChefZoneController.getExtraScore()+10);
						System.out.println("added 10 point for extra score");
						System.out.println(ChefZoneController.getExtraScore());
					}
					}
				}
			}
		);
	}

	@Override
	public void Boost() {
		// TODO Auto-generated method stub
		this.setStyle("-fx-background-color: yellow;");
		ChefZoneController.boostCountdown(20, this);
	}
}
