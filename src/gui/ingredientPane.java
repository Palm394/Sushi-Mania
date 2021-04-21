package gui;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import model.Ingredient;

public class ingredientPane extends GridPane{
	private ArrayList<IngredientButton> supply = new ArrayList<IngredientButton>();
	
	ingredientPane(){
		for(int i=0;i<=15;i++)
		{
			this.supply.add(new IngredientButton(new Ingredient(i)));
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
