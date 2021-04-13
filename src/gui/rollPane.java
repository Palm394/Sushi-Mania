 package gui;

import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class rollPane extends GridPane{
	rollPane(){
		
		this.setPadding(new Insets(20,20,20,20));
		this.setPrefHeight(200);
		this.setPrefWidth(300);
		for(int i=0;i<Math.min(ChefZoneController.getWrapper().size(), 12);i++)
		{
			ImageView image = new ImageView(ChefZoneController.getWrapper().get(i).getUrl());
			this.add(image, i/4, i-(i/4));
		}
	}
	
	public void updateIngredient() {
		for(int i=0;i<Math.min(ChefZoneController.getWrapper().size(), 12);i++)
		{
			ImageView image = new ImageView(ChefZoneController.getWrapper().get(i).getUrl());
			this.add(image, i-((i/4)*4), i/4);
		}
	}
}
