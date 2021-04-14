 package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class rollPane extends GridPane{
	rollPane(){
		
		this.setPadding(new Insets(20,20,20,20));
		this.setMaxHeight(200);
		this.setMaxWidth(300);
		this.setHgap(5);
		this.setVgap(5);
	}
	
	public void updateIngredient() {
		for(int i=0;i<12;i++)
		{
			if(i < Math.min(ChefZoneController.getWrapper().size(), 12))
			{
				ImageView image = new ImageView(ChefZoneController.getWrapper().get(i).getUrl());
				image.setPreserveRatio(true);
				image.setFitWidth(80);
				image.setFitHeight(40);
				this.add(image, i-((i/4)*4), i/4);
			}
		}
	}
	
	public void removeIngredient() {
		this.getChildren().clear();
	}
}
