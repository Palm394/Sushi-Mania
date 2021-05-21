package logic;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import application.Database;
import application.Utility;
import gui.ChefZoneGUI;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;
import model.Ingredient;
import model.IngredientButton;
import model.SushiTrain;
import model.VeggiIngredientButton;
import model.FishIngredientButton;
import model.FoodList;

public class ChefZoneController {
	private static ArrayList<Ingredient> wrapper = new ArrayList<Ingredient>();
	private static boolean isVeggiBoost = false;
	private static boolean isFishBoost = false;
	private static boolean isFreeBoost = false;
	private static boolean isExit = false;
	//set exit cooldown time
	private static int exittedTime = 20;
	private static boolean isStop = false;
	
	//extra score when boost
	private static int extraScore = 0;
	
	public static boolean isExit() {
		return isExit;
	}

	public static void setExit(boolean isExit) {
		ChefZoneController.isExit = isExit;
	}	
	
	public static void setExitTrue() {
		isExit = true;
		if(exittedTime != 20) {
			exittedTime = 20;
			isStop = true;
		}
		new Thread(()->{
			while(exittedTime > 0 && !isStop)
			{
				try {
					TimeUnit.SECONDS.sleep(1);
					exittedTime -= 1;
					System.out.println("exit time = " + exittedTime + " " + isExit);
				} catch (Exception e) {
					System.out.println("oops! something went wrong!");
				}
			}
			if(exittedTime == 0) {
				isExit = false;
				System.out.println("woohoo!");
			}
			exittedTime = 20;
			isStop = false;
		}).start();	
	}

	
	public static int getExittedTime() {
		return exittedTime;
	}


	public static void setExittedTime(int exittedTime) {
		ChefZoneController.exittedTime = exittedTime;
	}


	public static ArrayList<Ingredient> getWrapper() {
		return wrapper;
	}

	public static void setWrapper(ArrayList<Ingredient> wrapper) {
		ChefZoneController.wrapper = wrapper;
	}

	public static boolean isFreeBoost() {
		return isFreeBoost;
	}

	public static void setFreeBoost(boolean isFreeBoost) {
		ChefZoneController.isFreeBoost = isFreeBoost;
	}	
	
	public static boolean isVeggiBoost() {
		return isVeggiBoost;
	}

	public static void setVeggiBoost(boolean isVeggiBoost) {
		ChefZoneController.isVeggiBoost = isVeggiBoost;
	}

	public static boolean isFishBoost() {
		return isFishBoost;
	}

	public static void setFishBoost(boolean isFishBoost) {
		ChefZoneController.isFishBoost = isFishBoost;
	}

	public static int getExtraScore() {
		return extraScore;
	}

	public static void setExtraScore(int extraScore) {
		ChefZoneController.extraScore = extraScore;
	}
	
	public static void soundPlay(String url) {
		AudioClip sound = new AudioClip(ClassLoader.getSystemResource(url).toString());
		sound.setVolume(Utility.volume);
		sound.play();
	}
	
	public static void addIngredient(IngredientButton ingredientbutton) {
		if(ingredientbutton.ingredient.getRemain()>0)
		{
			if(isFreeBoost == false) {
			ingredientbutton.ingredient.setRemain(ingredientbutton.ingredient.getRemain()-1);
			ingredientbutton.setText(ingredientbutton.ingredient.getRemain()+"");
			} 
			System.out.println(ingredientbutton.ingredient.getName());
			ChefZoneController.wrapper.add(ingredientbutton.ingredient);		
			ChefZoneController.updateIngredient();
		}
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
	
	public static void boostCountdown(int time,Button button) {
		String returnText;
		returnText = button.getText();
		if(returnText == "99") {
			IngredientButton ingredientbutton = (IngredientButton) button;
			returnText = ingredientbutton.ingredient.getRemain() + "";
		}
		String realText = returnText;
		
		new Thread(()->{
			if(!(button instanceof FishIngredientButton || button instanceof VeggiIngredientButton))
			{
				Platform.runLater(()->button.setText(time+""));
			}
			countdown(time, button, realText);
			if(button instanceof FishIngredientButton || button instanceof VeggiIngredientButton)
				{
				Platform.runLater(()->goBackNormal(button));
				if(button instanceof FishIngredientButton) {
					isFishBoost = false;
					} else {
						isVeggiBoost = false;
					}
				} 
			if(button instanceof IngredientButton && isFreeBoost && !isExit) {
				Platform.runLater(()->button.setText("99"));
			}
			}).start();
	}
	
	public static void countdown(int time,Button button,String returnText) {
			String name = returnText;
			for(int i=0;i<=time;i++)
			{
				try {
					int timeRemaining = time-i;
					if(!(button instanceof FishIngredientButton || button instanceof VeggiIngredientButton))
					{
						Platform.runLater(()->button.setText(timeRemaining+""));
					}	
					TimeUnit.SECONDS.sleep(1);
					
				} catch (Exception e) {
					System.out.println("oops! something went wrong!");
				}
			}
			Platform.runLater(()->button.setText(name));
	}
	
	public static void showAddedScore(int score) {
		Platform.runLater(()->gui.ChefZoneGUI.rollButton.setText("+" + score));
		new Thread(()->{
			try {
				TimeUnit.MILLISECONDS.sleep(750);
				System.out.println("Delayed");
			} catch (Exception e) {
				System.out.println("oops! something went wrong!");
			}
			Platform.runLater(()->gui.ChefZoneGUI.rollButton.setText("roll!!"));
		}).start();
	}
	
	public static void wrap(ArrayList<Ingredient> wrapper) {
		if(wrapper.size()>0 && SushiTrain.canPlaceDish()==true) {
			String hcode = "";
			int[] ingredientSet = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};  
		
			for(int i=0 ;i<wrapper.size() ;i++) {
				ingredientSet[wrapper.get(i).getId()] += 1;
			}
			
			//show ingredient code
			for(int i=0;i<=15;i++)
			{
				hcode += ingredientSet[i];
			}
			
			System.out.println(hcode);
			
			//find menu which can make
			FoodList sushi = new FoodList(99);
			boolean check = false;
			int menuID = 1;
			while(check == false) {
				if(hcode.equals(new FoodList(menuID).getHcode()) ) {
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
				//play sound
				if(check == true) {
					soundPlay("sound/SuccessRollSound.wav");
				} else {
					soundPlay("sound/FailRollSound.wav");
				}	
			}
			///////////////////////////////////
			
			Platform.runLater(()->ChefZoneGUI.rollpane.removeIngredient());
			wrapper.clear();
			
			if(check == true && (isVeggiBoost == true || isFishBoost == true)) {
				showAddedScore(extraScore);
				Platform.runLater(()->{GameController.addScore(extraScore);extraScore = 0;});
			} else {
				extraScore = 0;
			}
			
		} 
	}
}
