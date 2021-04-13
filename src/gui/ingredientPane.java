package gui;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class ingredientPane extends GridPane{
	ArrayList<IngredientButton> supply = new ArrayList<IngredientButton>();
	
	ingredientPane(){
		supply.add(new IngredientButton("Cucumber"));
		supply.add(new IngredientButton("Seaweed"));
		supply.add(new IngredientButton("Shrimp"));
		supply.add(new IngredientButton("SweetEgg"));
		supply.add(new IngredientButton("CrabStick"));
		supply.add(new IngredientButton("Ikura"));
		supply.add(new IngredientButton("Avocado"));
		supply.add(new IngredientButton("Tuna"));
		supply.add(new IngredientButton("Saba"));
		supply.add(new IngredientButton("Salmon"));
		supply.add(new IngredientButton("Squid"));
		supply.add(new IngredientButton("Scallop"));
		supply.add(new IngredientButton("Hamachi"));
		supply.add(new IngredientButton("Fuaga"));
		supply.add(new IngredientButton("ShrimpEgg"));
		supply.add(new IngredientButton("Unangi"));
		supply.add(new IngredientButton("Uni"));
		supply.add(new IngredientButton("Rice"));
		this.setPadding(new Insets(10,10,10,10));
		this.setHgap(10);
		this.setVgap(10);
		this.prefHeight(300);
		this.prefWidth(400);
		for(int i=0;i<=15;i++) {
			this.add(supply.get(i),i/4,i-((i/4)*4));
			int j = i;
			supply.get(i).setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event) {
						if(supply.get(j).ingredient.getRemain()>0) {
							supply.get(j).ingredient.setRemain(supply.get(j).ingredient.getRemain()-1);
							supply.get(j).setText(supply.get(j).ingredient.getRemain()+"");
							System.out.println(supply.get(j).ingredient.getName());
						}
					}
				}
		);
		}
	}
}
