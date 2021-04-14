package gui;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class ingredientPane extends GridPane{
	ArrayList<IngredientButton> supply = new ArrayList<IngredientButton>();
	
	ingredientPane(){
		for(int i=0;i<=15;i++)
		{
			supply.add(new IngredientButton(i));
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
}
