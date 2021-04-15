package gui;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class ChefZoneController {
	private static ArrayList<Ingredient> wrapper = new ArrayList<Ingredient>();
	
	public static ArrayList<Ingredient> getWrapper() {
		return wrapper;
	}

	public static void setWrapper(ArrayList<Ingredient> wrapper) {
		ChefZoneController.wrapper = wrapper;
	}

	public static void addIngredient(IngredientButton ingredientbutton) {
		ingredientbutton.ingredient.setRemain(ingredientbutton.ingredient.getRemain()-1);
		ingredientbutton.setText(ingredientbutton.ingredient.getRemain()+"");
		System.out.println(ingredientbutton.ingredient.getName());
		ChefZoneController.wrapper.add(ingredientbutton.ingredient);		
		ChefZoneController.updateIngredient();
	}
	
	public static void updateIngredient() {
		ChefZoneGUI.rollpane.updateIngredient();
	}
	
	public static int wrap(ArrayList<Ingredient> wrapper) {
		if(wrapper.size()>0) {
			int hcode = 0;
		
			for(int i=0 ;i<wrapper.size() ;i++) {
				hcode += Math.pow(4, wrapper.get(i).getId());
			}
		
			// details of sushi is in recipe
			menuRecipe recipe = new menuRecipe(hcode);
			System.out.println(recipe.getName());
		
			//function to send sushi to the road
			///////////////////////////////////
		
			ChefZoneGUI.rollpane.removeIngredient();
			wrapper.clear();
		
			return hcode;
		} else {
			return -1;
		}
	}
}