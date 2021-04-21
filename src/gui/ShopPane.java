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
	private ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();

	Boolean[] buyStatus = new Boolean[20];
	
	ShopPane(){
		this.setPrefHeight(175);
		this.setStyle("-fx-background-color: rgba(245,222,179,0.9);");
		this.setSpacing(5);
		this.setAlignment(Pos.CENTER);
		for(int i=0;i<=16;i++) {
			buyStatus[i] = false;
		}
		this.updateShopList();
		
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
				selectedIngredientID = (selectedIngredientID + ingredientSize - 1) % ingredientSize;
				changeIngredientOrder();
			}
		});		
		
		//set action for ">"
		chooseRight.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				int ingredientSize = Database.getHasIngredient().size();
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
		System.out.println("ordered : " + ingredientList.get(selectedIngredientID).getId());
		return buyStatus[ingredientList.get(selectedIngredientID).getId()];
	}
	
	//buy normal has to wait for time to delivery
	private Runnable buyNormal = new Runnable() {
		public void run() {
			int timer = 5;
			int ID = ingredientList.get(selectedIngredientID).getId();
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
			Platform.runLater(()->{
				ChefZoneGUI.ingredientpane.getSupply().get(ID).buyIngredient();
			});
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
				//set remaining number
				ChefZoneGUI.ingredientpane.getSupply().get(ID).buyIngredient();
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
			ChefZoneGUI.ingredientpane.getSupply().get(ID).setDisable(true);
	}
	
	public void unblockIngredient(int ID){
			ChefZoneGUI.ingredientpane.getSupply().get(ID).setDisable(false);
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

	public ArrayList<Ingredient> getIngredientList() {
		return ingredientList;
	}

	public void setIngredientList(ArrayList<Ingredient> ingredientList) {
		this.ingredientList = ingredientList;
	}
	
	public void updateShopList() {
		ingredientList.clear();
		for(int i=0;i<Database.getHasIngredient().size();i++) {
			ingredientList.add(Database.getHasIngredient().get(i));
		}
		ingredientList.sort((Ingredient z1,Ingredient z2) -> (Integer.compare(z1.getId(),z2.getId())));
	}
}
