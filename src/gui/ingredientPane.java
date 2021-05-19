package gui;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import model.FishIngredientButton;
import model.Ingredient;
import model.IngredientButton;
import model.VeggiIngredientButton;

public class ingredientPane extends GridPane{
	private ArrayList<IngredientButton> supply = new ArrayList<IngredientButton>();
	
	ingredientPane(){
		for(int i=0;i<=15;i++)
		{	
			if(i==0||i==1||i==11) {
				//set veggi ingredient
				this.supply.add(new VeggiIngredientButton(new Ingredient(i)));
			} else if(i==6||i==7||i==9||i==13) {
				//set fish ingredient
				this.supply.add(new FishIngredientButton(new Ingredient(i)));
			}
			else {
				this.supply.add(new IngredientButton(new Ingredient(i)));
			}
		}
		
		this.setPadding(new Insets(10,10,10,10));
		this.setHgap(10);
		this.setVgap(10);
		this.prefHeight(300);
		this.prefWidth(400);
		for(int i=0;i<=15;i++) {
			this.add(supply.get(i), i-((i/4)*4), i/4);
		}
	}

	public ArrayList<IngredientButton> getSupply() {
		return supply;
	}

	public void setSupply(ArrayList<IngredientButton> supply) {
		this.supply = supply;
	}
}
