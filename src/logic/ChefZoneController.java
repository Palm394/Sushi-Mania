package logic;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import application.Database;
import gui.ChefZoneGUI;
import javafx.application.Platform;
import javafx.scene.control.Button;
import model.Ingredient;
import model.IngredientButton;
import model.SushiTrain;
import model.VeggiIngredientButton;
import model.FishIngredientButton;
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
		ChefZoneGUI.shopPane.update();
	}
	
	public static void goBackNormal(Button button) {
		button.setStyle("-fx-background-color: rgba(245,222,179,0.7);");
	}
	
	public static void countdown(int time,Button button) {
		String name = button.getText();
		if(!(button instanceof FishIngredientButton || button instanceof VeggiIngredientButton))
		{
			button.setText(time+"");
		}	
		new Thread(()->{
			
			for(int i=0;i<=time;i++)
			{
				try {
					TimeUnit.SECONDS.sleep(1);
					int timeRemaining = time-i;
					if(!(button instanceof FishIngredientButton || button instanceof VeggiIngredientButton))
					{
						Platform.runLater(()->button.setText(timeRemaining+""));
					}	
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Platform.runLater(()->button.setText(name));
			if(button instanceof FishIngredientButton || button instanceof VeggiIngredientButton)
			{
				Platform.runLater(()->goBackNormal(button));
			}			
		}).start();	
	}
	
	
	public static int wrap(ArrayList<Ingredient> wrapper) {
		if(wrapper.size()>0 && SushiTrain.canPlaceDish()==true) {
			int hcode = 0;
		
			for(int i=0 ;i<wrapper.size() ;i++) {
				hcode += Math.pow(3, wrapper.get(i).getId());
			}
			
			//show ingredient code
			System.out.println("hcode : " + hcode);
			
			//find menu which can make
			FoodList sushi = new FoodList(99);
			boolean check = false;
			int menuID = 1;
			while(check == false) {
				if(new FoodList(menuID).getHcode() == hcode) {
					sushi = new FoodList(menuID);
					check = true;
				} else if(menuID > 32) {
					break;
				}
				menuID += 1;
			}
			
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
