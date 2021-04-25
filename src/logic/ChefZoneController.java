package logic;

import java.util.ArrayList;

import application.Database;
import gui.ChefZoneGUI;
import gui.IngredientButton;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.Ingredient;
import model.SushiTrain;
import model.Food;
import model.FoodList;

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
	
	public static void updateIngredientButton() {
		int ingredientSize = Database.getHasIngredient().size();
		System.out.println(ingredientSize);
		for(int i=0;i<ingredientSize;i++) {
			ChefZoneGUI.ingredientpane.getSupply().get(Database.getHasIngredient().get(i).getId()).unlock();
		}
	}
	
	public static void updateShopList() {
		ChefZoneGUI.shopPane.updateShopList();
	}
	
	public static int wrap(ArrayList<Ingredient> wrapper) {
		if(wrapper.size()>0 && SushiTrain.canPlaceDish()==true) {
			int hcode = 0;
		
			for(int i=0 ;i<wrapper.size() ;i++) {
				hcode += Math.pow(3, wrapper.get(i).getId());
			}
			
			//checkout hash result
			System.out.println("hcode : " + hcode);
			
			// details of sushi is in recipe
			FoodList sushi = new FoodList(hcode);
			System.out.println("food found : " + sushi.getName() + " price=" + sushi.getPrice());
		
			//function to send sushi to the road
			if(SushiTrain.canPlaceDish()) {
				SushiTrain.addNewDish(sushi);
			}
			///////////////////////////////////
		
			ChefZoneGUI.rollpane.removeIngredient();
			wrapper.clear();
		
			return hcode;
		} else {
			return -1;
		}
	}
}
