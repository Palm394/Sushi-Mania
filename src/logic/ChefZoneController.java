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
	
	public static void setExitTrue() {
		isExit = true;
		if(exittedTime != 20) {
			exittedTime = 20; isStop = true;
		}
		new Thread(()->{
			while(exittedTime > 0 && !isStop)
			{
				try {
					System.out.println(exittedTime);
					TimeUnit.SECONDS.sleep(1);
					exittedTime -= 1;
				} catch (Exception e) {
				}
			}
			if(exittedTime == 0) {
				isExit = false;
			}
			exittedTime = 20; isStop = false;
		}).start();	
	}
	
	public static void soundPlay(String url) {
		AudioClip sound = new AudioClip(ClassLoader.getSystemResource(url).toString());
		sound.setVolume(Utility.volume);
		sound.play();
	}
	
	public static void addIngredient(IngredientButton ingredientbutton) {
		if((getIngredientRemain(ingredientbutton)>0 || isFreeBoost) && ChefZoneController.getWrapper().size() < 12 )
		{
			ChefZoneController.soundPlay("sound/TickSound.wav");
			if(!isFreeBoost) {
			ingredientbutton.getIngredient().setRemain(getIngredientRemain(ingredientbutton)-1);
			ingredientbutton.setText(getIngredientRemain(ingredientbutton)+"");
			} 
			ChefZoneController.wrapper.add(ingredientbutton.getIngredient());		
			ChefZoneController.updateIngredient();
		}
	}
	
	public static void update() {
		ChefZoneController.updateIngredientButton();
		ChefZoneController.updateShopList();
		ChefZoneController.updateBoostButton();
	}
	
	public static void updateBoostButton() {
		ChefZoneGUI.getBoostpane().getFreeBoostButton().setDisable(false);
		ChefZoneGUI.getBoostpane().getFishBoostButton().setDisable(false);
		ChefZoneGUI.getBoostpane().getVeggiBoostButton().setDisable(false);
	}
	
	public static void updateIngredient() {
		ChefZoneGUI.getRollpane().updateIngredient();
	}
	
	
	public static void updateIngredientButton() {
		int ingredientSize = Database.getHasIngredient().size();
		for(int i=0;i<ingredientSize;i++) {
			ChefZoneGUI.getIngredientpane().getSupply().get(Database.getHasIngredient().get(i).getId()).unlock();
		}
	}
	
	public static void updateShopList() {
		ChefZoneGUI.getShopPane().update();
	}
	
	public static void goBackNormal(Button button) {
		button.setStyle("-fx-background-color: rgba(245,222,179,0.7);");
	}
	
	public static void boostCountdownToIngredientButton(int time,Button button) {
		String returnText;
		returnText = button.getText();
		if(returnText == "99") {
			IngredientButton ingredientbutton = (IngredientButton) button;
			returnText = getIngredientRemain(ingredientbutton) + "";
		}
		String realText = returnText;
		
		new Thread(()->{
			Platform.runLater(()->button.setText(time+""));
			countdown(time, button, realText);
			if(isFreeBoost && !isExit) {
				Platform.runLater(()->button.setText("99"));
			}
			}).start();
	}
	
	public static void boostCountdownToSpecialIngredientButton(int time,Button button) {
		String returnText;
		returnText = button.getText();
		if(returnText == "99") {
			IngredientButton ingredientbutton = (IngredientButton) button;
			returnText = getIngredientRemain(ingredientbutton) + "";
		}
		String realText = returnText;
		new Thread(()->{
			countdown(time, button, realText);
			Platform.runLater(()->goBackNormal(button));
			if(button instanceof FishIngredientButton) {
				isFishBoost = false;
				} else {
					isVeggiBoost = false;
				}
			if(isFreeBoost && !isExit) {
				Platform.runLater(()->button.setText("99"));
			}
			}).start();
	}
	
	public static void boostCountdownToBoostButton(int time,Button button) {
		String returnText;
		returnText = button.getText();
		String realText = returnText;

		new Thread(()->{
			Platform.runLater(()->button.setText(time+""));
			countdown(time, button, realText);
			}).start();
	}
	
	public static void boostCountdown(int time,Button button) {
		if(button instanceof IngredientButton) {
			if(button instanceof FishIngredientButton || button instanceof VeggiIngredientButton) {
				boostCountdownToSpecialIngredientButton(time, button);
			} else {
				boostCountdownToIngredientButton(time, button);
			}
		} else {
			boostCountdownToBoostButton(time, button);
		}
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
			if(!isExit)
			{
				Platform.runLater(()->button.setText(name));
			}
	}
	
	public static void addedScore(int score) {
		Platform.runLater(()->gui.ChefZoneGUI.getRollButton().setText("+" + score));
		new Thread(()->{
			try {
				TimeUnit.MILLISECONDS.sleep(750);
				System.out.println("Delayed");
			} catch (Exception e) {
				System.out.println("oops! something went wrong!");
			}
			Platform.runLater(()->gui.ChefZoneGUI.getRollButton().setText("roll!!"));
			Platform.runLater(()->{GameController.addScore(extraScore);extraScore = 0;});
		}).start();
	}
	
	public static String makeIngredientHcode() {
		String hcode = "";
		int[] ingredientSet = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};  
		
		//summary ingredient to array
		for(int i=0 ;i<wrapper.size() ;i++) {
			ingredientSet[wrapper.get(i).getId()] += 1;
		}
		
		//set ingredient code to string
		for(int i=0;i<=15;i++)
		{
			hcode += ingredientSet[i];
		}
		return hcode;
	}
	
	public static FoodList matchSushi(String hcode) {
		//find menu which can make
		FoodList matchSushi = new FoodList(99);
		boolean isFound = false;
		int menuID = 1;
		while(!isFound) {
			if(hcode.equals(new FoodList(menuID).getHcode()) ) {
				matchSushi = new FoodList(menuID);
				isFound = true;
			} else if(menuID > 32) {
				break;
			}
			menuID += 1;
		}
		return matchSushi;
	}
	
	//function to send sushi to the road
	public static void sendSushi(FoodList matchSushi) {
		if(SushiTrain.canPlaceDish()) {
			SushiTrain.addNewDish(matchSushi);
			//play sound
			if(!matchSushi.getName().equals("unknown")) {
				soundPlay("sound/SuccessRollSound.wav");
			} else {
				soundPlay("sound/FailRollSound.wav");
			}	
		}
	}
	
	public static void wrap() {
		if(wrapper.size()>0 && SushiTrain.canPlaceDish()) {
			
			String hcode = makeIngredientHcode();
			FoodList matchSushi = matchSushi(hcode);
			sendSushi(matchSushi);
			
			Platform.runLater(()->ChefZoneGUI.getRollpane().removeIngredient());
			wrapper.clear();
			if(!matchSushi.getName().equals("unknown") && (isVeggiBoost || isFishBoost)) {
				addedScore(extraScore);
			} else {
				extraScore = 0;
			}
		} 
	}
	
	public static int getIngredientRemain(IngredientButton ingredientbutton) {
		return ingredientbutton.getIngredient().getRemain();
	}
	
	public static boolean isExit() {
		return isExit;
	}

	public static void setExit(boolean isExit) {
		ChefZoneController.isExit = isExit;
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
}
