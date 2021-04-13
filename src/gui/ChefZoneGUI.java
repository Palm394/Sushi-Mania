package gui;

import javafx.scene.layout.HBox;

public class ChefZoneGUI extends HBox {
		
	public static rollPane rollpane;
	
		ChefZoneGUI(){
			this.getChildren().add(new ingredientPane());
			rollpane = new rollPane();
			this.getChildren().add(rollpane);
		}
		
	}
