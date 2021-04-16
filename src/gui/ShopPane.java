package gui;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.GameController;
import model.Ingredient;

public class ShopPane extends VBox{
	int selectedIngredientID = 0;
	Label shopTitle;
	Label select;
	Button chooseLeft;
	Label ingredientName;
	Button chooseRight;
	Button normalPriceBut;
	Button speedPriceBut;
	ImageView ingredientImage;
	ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
	Boolean[] buyStatus = new Boolean[20];
	
	ShopPane(){
		for(int i=0;i<=16;i++) {
			ingredientList.add(new Ingredient(i));
			buyStatus[i] = false;
		}
		shopTitle = new Label();
		
		//zone where we select ingredient to order
		HBox selectPane = new HBox();
		select = new Label("Select :");
		ingredientName = new Label(ingredientList.get(0).getName());
		ingredientName.setPrefHeight(30);
		ingredientName.setPrefWidth(80);
		ingredientName.setAlignment(Pos.CENTER);
		chooseLeft = new Button("<");
		chooseRight = new Button(">");
		selectPane.getChildren().addAll(select,chooseLeft,ingredientName,chooseRight);
		
		ingredientImage = new ImageView(ingredientList.get(selectedIngredientID).getUrl());
		ingredientImage.setFitHeight(100);
		ingredientImage.setFitWidth(100);
		
		//zone which contain order button
		HBox showPricePane = new HBox();
		normalPriceBut = new Button("price : " + ingredientList.get(selectedIngredientID).getPrice());
		speedPriceBut = new Button("price : " + (ingredientList.get(selectedIngredientID).getPrice()+10));
		showPricePane.getChildren().addAll(normalPriceBut,speedPriceBut);
		
		//set action for "<"
		chooseLeft.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				selectedIngredientID = (selectedIngredientID + 15) % 16;
				changeIngredientOrder();
			}
		});		
		
		//set action for ">"
		chooseRight.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				selectedIngredientID = (selectedIngredientID + 1) % 16;
				changeIngredientOrder();
			}
		});		
		
		//set action for normalBuy
		normalPriceBut.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				buyNormalTo(selectedIngredientID,ingredientList.get(selectedIngredientID).getPrice());
			}
		});	
		//set action for speedBuy
		speedPriceBut.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				buySpeed(selectedIngredientID,ingredientList.get(selectedIngredientID).getPrice()+10);
			}
		});	
		
		this.getChildren().add(shopTitle);
		this.getChildren().add(selectPane);
		this.getChildren().add(ingredientImage);
		this.getChildren().add(showPricePane);
	}
	
	public boolean isOrdered() {
		return buyStatus[selectedIngredientID];
	}
	
	//buy normal has to wait for time to delivery
	private Runnable buyNormal = new Runnable() {
		public void run() {
			int timer = 5;
			int ID = selectedIngredientID;
			//then delivery
			while(timer > 0)
			{
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				timer -= 1;
				System.out.println(timer);
			}
			Platform.runLater(()->{if(selectedIngredientID<16) {
				//set remaining number
				ChefZoneGUI.ingredientpane.supply.get(ID).buyIngredient();
			} else {
				//set remaining number
				ChefZoneGUI.rice.buyIngredient();
			}});
			Platform.runLater(()->{unlockBuy();unblockIngredient(ID);});
			buyStatus[ID] = false;
		}
	};
	
	public void buyNormalTo(int ID, int price) {
		if(GameController.getScore() >= price) {	
			if(!isOrdered())
			{
				//decrease score first
				GameController.addScore(-price);
				lockBuy();
				blockIngredient(ID);
				//then delivery
				new Thread(buyNormal).start();	
				buyStatus[ID] = true;
			}
		}
	}
	
	//but buy speed doesn't wait
	public void buySpeed(int ID, int price) {
		if(GameController.getScore() >= price) {
			if(selectedIngredientID<16) {
				//set remaining number
				ChefZoneGUI.ingredientpane.supply.get(ID).buyIngredient();
			} else {
				//set remaining number
				ChefZoneGUI.rice.buyIngredient();
			}
				//set new score
				GameController.addScore(-price);			
		}
	}
	
	public void lockBuy() {
		normalPriceBut.setDisable(true);
		speedPriceBut.setDisable(true);
	}
	
	public void unlockBuy() {
		normalPriceBut.setDisable(false);
		speedPriceBut.setDisable(false);
	}
	
	public void blockIngredient(int ID){
		if(ID<16) {
			ChefZoneGUI.ingredientpane.supply.get(ID).setDisable(true);
		} else {
			ChefZoneGUI.rice.setDisable(true);
		}
	}
	
	public void unblockIngredient(int ID){
		if(ID<16) {
			ChefZoneGUI.ingredientpane.supply.get(ID).setDisable(false);
		} else {
			ChefZoneGUI.rice.setDisable(false);
		}
	}
	
	public void changeIngredientOrder() {
		ingredientName.setText(ingredientList.get(selectedIngredientID).getName());
		normalPriceBut.setText("price : " + ingredientList.get(selectedIngredientID).getPrice());
		speedPriceBut.setText("price : " + (ingredientList.get(selectedIngredientID).getPrice()+10));
		Image image = new Image(ingredientList.get(selectedIngredientID).getUrl()); 
		ingredientImage.setImage(image);
		if(buyStatus[selectedIngredientID] == true) {
			lockBuy();
		} else {
			unlockBuy();
		}
	}
}
