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

public class ShopPane extends VBox{
	int selectedIngredientID = 0;
	Label shopTitle;
	Label select;
	Button chooseLeft;
	Label ingredientName;
	Button chooseRight;
	Button normalPrice;
	Button speedPrice;
	ImageView ingredientImage;
	ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
	
	ShopPane(){
		for(int i=0;i<=16;i++) {
			ingredientList.add(new Ingredient(i));
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
		normalPrice = new Button("price : " + ingredientList.get(selectedIngredientID).getPrice());
		speedPrice = new Button("price : " + (ingredientList.get(selectedIngredientID).getPrice()+10));
		showPricePane.getChildren().addAll(normalPrice,speedPrice);
		
		//set action for "<"
		chooseLeft.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				selectedIngredientID = (selectedIngredientID + 16) % 17;
				changeIngredientOrder();
			}
		});		
		
		//set action for ">"
		chooseRight.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				selectedIngredientID = (selectedIngredientID + 1) % 17;
				changeIngredientOrder();
			}
		});		
		
		//set action for normalBuy
		normalPrice.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				new Thread(buyNormal).start();
			}
		});	
		
		speedPrice.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				buySpeed(selectedIngredientID);
			}
		});	
		
		this.getChildren().add(shopTitle);
		this.getChildren().add(selectPane);
		this.getChildren().add(ingredientImage);
		this.getChildren().add(showPricePane);
	}
	
	public boolean isNormalOrder() {
		return false;
	}
	
	public boolean isSpeedOrder() {
		return false;
	}
	
	private Runnable buyNormal = new Runnable() {
		public void run() {
			int timer = 5;
			int ID = selectedIngredientID;
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
			Platform.runLater(()->{buySpeed(ID);});
		}
	};
	
	public void buyNormalTo(int ID) {
		new Thread(buyNormal).start();
	}
	
	public void buySpeed(int ID) {
		if(GameController.getScore() >= ingredientList.get(ID).getPrice()) {
			if(selectedIngredientID<16) {
				//set remaining number
				ChefZoneGUI.ingredientpane.supply.get(ID).buyIngredient();
				//set new score
				GameController.addScore(-ingredientList.get(ID).getPrice());
			}
		}
	}
	
	public void lock() {
		
	}
	
	public void unlock() {
		
	}
	
	public void changeIngredientOrder() {
		ingredientName.setText(ingredientList.get(selectedIngredientID).getName());
		normalPrice.setText("price : " + ingredientList.get(selectedIngredientID).getPrice());
		speedPrice.setText("price : " + (ingredientList.get(selectedIngredientID).getPrice()+10));
		Image image = new Image(ingredientList.get(selectedIngredientID).getUrl()); 
		ingredientImage.setImage(image);
	}
}
