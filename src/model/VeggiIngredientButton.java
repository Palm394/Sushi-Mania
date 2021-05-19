package model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import logic.ChefZoneController;
import model.base.Boostable;

public class VeggiIngredientButton extends IngredientButton implements Boostable {
	public VeggiIngredientButton(Ingredient ingredient) {
		
		super(ingredient);
		
		VeggiIngredientButton button = this;
		
		this.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				if(ingredient.getRemain()>0 && ChefZoneController.getWrapper().size() < 12) {
					ChefZoneController.addIngredient(button);
					if(ChefZoneController.isVeggiBoost() == true)
					{
						ChefZoneController.setExtraScore(ChefZoneController.getExtraScore()+7);
						System.out.println("added 7 point for extra score");
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
		this.setStyle("-fx-background-color: green;");		
		ChefZoneController.boostCountdown(20, this);
		
	}


}
