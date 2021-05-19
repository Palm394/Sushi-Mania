package model;

import model.base.Boostable;

public class VeggiIngredientButton extends IngredientButton implements Boostable {
	public VeggiIngredientButton(Ingredient ingredient) {
		
		super(ingredient);
		
	}

	@Override
	public void Boost() {
		
		// TODO Auto-generated method stub
		this.setStyle("-fx-background-color: green;");		
		
	}


}
