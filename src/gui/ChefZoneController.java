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

	public static void addIngredient(Ingredient ingredient) {
		ChefZoneController.wrapper.add(ingredient);
	}
	
	public static void updateIngredient() {
		ChefZoneGUI.rollpane.updateIngredient();
	}
}
