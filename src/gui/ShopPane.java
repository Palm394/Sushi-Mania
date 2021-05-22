package gui;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import application.Database;
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
import javafx.scene.text.TextAlignment;
import logic.ChefZoneController;
import logic.GameController;
import model.Ingredient;
import model.base.Updatable;

public class ShopPane extends VBox implements Updatable{
	private int selectedIngredientID = 0;
	
	private Button chooseLeft;
	private Button chooseRight;
	private Button normalPriceBut;
	private Button speedPriceBut;
	private ImageView ingredientImage;
	private ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
	
	private Label ingredientName;
	private Label shopTitle;
	
	Boolean[] buyStatus = new Boolean[20];
	
	public ShopPane(){
		this.setPrefHeight(175);
		this.setStyle("-fx-background-color: rgba(245,222,179,0.9);");
		this.setSpacing(5);
		this.setAlignment(Pos.CENTER);
		for(int i=0;i<=16;i++) {
			buyStatus[i] = false;
		}
		this.update();
		
		Label shopTitle = new Label("Ingredient Delivery");
		shopTitle.setStyle("-fx-font-size: 16px;");
		//zone where we select ingredient to order
		HBox selectPane = new HBox();
		ingredientName = new Label(ingredientList.get(0).getName());
		ingredientName.setPrefHeight(10);
		ingredientName.setPrefWidth(100);
		ingredientName.setAlignment(Pos.CENTER);
		chooseLeft = new Button("<");
		chooseLeft.setStyle("-fx-background-color: rgba(255,255,255,0.5);");
		chooseRight = new Button(">");
		chooseRight.setStyle("-fx-background-color: rgba(255,255,255,0.5);");
		
		ingredientImage = new ImageView(ingredientList.get(selectedIngredientID).getUrl());
		ingredientImage.setFitHeight(80);
		ingredientImage.setFitWidth(80);
		selectPane.getChildren().add(chooseLeft);
		selectPane.getChildren().add(ingredientImage);
		selectPane.getChildren().add(chooseRight);
		selectPane.setAlignment(Pos.CENTER);
		selectPane.setSpacing(30);
		
		//zone which contain order button
		HBox showPricePane = new HBox();
		normalPriceBut = new Button("normal\nprice : " + ingredientList.get(selectedIngredientID).getPrice());
		normalPriceBut.setPrefSize(100, 50); normalPriceBut.setTextAlignment(TextAlignment.CENTER);
		normalPriceBut.setStyle("-fx-background-color: rgba(88, 214, 141,0.8); -fx-border-color:green;");
		speedPriceBut = new Button("express\nprice : " + (ingredientList.get(selectedIngredientID).getPrice()+10));
		speedPriceBut.setPrefSize(100, 50); speedPriceBut.setTextAlignment(TextAlignment.CENTER);
		speedPriceBut.setStyle("-fx-background-color: rgba(93, 173, 226,0.8); -fx-border-color:blue;");
		Label blank = new Label("");
		blank.setPrefWidth(10);
		showPricePane.getChildren().addAll(normalPriceBut,blank,speedPriceBut);
		showPricePane.setAlignment(Pos.CENTER);
		
		//set action for "<"
		chooseLeft.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				int ingredientSize = Database.getHasIngredient().size();
				ChefZoneController.soundPlay("sound/ClickSound.wav");
				selectedIngredientID = (selectedIngredientID + ingredientSize - 1) % ingredientSize;
				changeIngredientOrder();
			}
		});		
		
		//set action for ">"
		chooseRight.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				int ingredientSize = Database.getHasIngredient().size();
				ChefZoneController.soundPlay("sound/ClickSound.wav");
				selectedIngredientID = (selectedIngredientID + 1) % ingredientSize;
				changeIngredientOrder();
			}
		});		
		
		//set action for normalBuy
		normalPriceBut.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				int ID = ingredientList.get(selectedIngredientID).getId();
				buyNormalTo(ID,ingredientList.get(selectedIngredientID).getPrice());
			}
		});	
		//set action for speedBuy
		speedPriceBut.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				int ID = ingredientList.get(selectedIngredientID).getId();
				buySpeed(ID,ingredientList.get(selectedIngredientID).getPrice()+10);
			}
		});	
		
		this.getChildren().add(shopTitle);
		this.getChildren().add(selectPane);
		this.getChildren().add(showPricePane);
	}
	
	public boolean isOrdered() {
		return buyStatus[ingredientList.get(selectedIngredientID).getId()];
	}
	
	//buy normal has to wait for time to delivery
	private Runnable buyNormal = new Runnable() {
		public void run() {
			int ID = ingredientList.get(selectedIngredientID).getId();
			countdownBuy();
			Platform.runLater(()->{
				if(!ChefZoneController.isExit() || ChefZoneController.getExittedTime() <= 15)
				{
					ChefZoneGUI.getIngredientpane().getSupply().get(ID).buyIngredient();
				}
			});
			Platform.runLater(()->{
				int selectedID = ingredientList.get(selectedIngredientID).getId();
				if(ID == selectedID) {
					unlockBuy();
				}
				unblockIngredient(ID);
			});
			buyStatus[ID] = false;
		}
	};
	
	public void countdownBuy() {
		int timer = 5;
		//then delivery
		while(timer > 0)
		{
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (Exception e) {
				System.out.println("Oops! something went wrong! :" + e.toString());
			}
			timer -= 1;
		}
	}
	
	public void buyNormalTo(int ID, int price) {
		if(GameController.getScore() >= price) {	
			if(!isOrdered())
			{
				ChefZoneController.soundPlay("sound/BuySound.wav");
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
			ChefZoneController.soundPlay("sound/BuySound.wav");
			//set remaining number
			ChefZoneGUI.getIngredientpane().getSupply().get(ID).buyIngredient();
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
			ChefZoneGUI.getIngredientpane().getSupply().get(ID).setDisable(true);
	}
	
	public void unblockIngredient(int ID){
			ChefZoneGUI.getIngredientpane().getSupply().get(ID).setDisable(false);
	}
	
	public void changeIngredientOrder() {
		ingredientName.setText(ingredientList.get(selectedIngredientID).getName());
		normalPriceBut.setText("normal\nprice : " + ingredientList.get(selectedIngredientID).getPrice());
		speedPriceBut.setText("express\nprice : " + (ingredientList.get(selectedIngredientID).getPrice()+10));
		Image image = new Image(ingredientList.get(selectedIngredientID).getUrl()); 
		ingredientImage.setImage(image);
		if(buyStatus[ingredientList.get(selectedIngredientID).getId()] == true) {
			lockBuy();
		} else {
			unlockBuy();
		}
	}

	public void update() {
		ingredientList.clear();
		for(int i=0;i<Database.getHasIngredient().size();i++) {
			ingredientList.add(Database.getHasIngredient().get(i));
		}
		ingredientList.sort((Ingredient z1,Ingredient z2) -> (Integer.compare(z1.getId(),z2.getId())));
		if(GameController.getLevel() > 1) {
			selectedIngredientID = 0;
			changeIngredientOrder();
		}
	}
	
	public ArrayList<Ingredient> getIngredientList() {
		return ingredientList;
	}
}
