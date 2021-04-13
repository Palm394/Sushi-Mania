package gui;

import javafx.scene.layout.HBox;

public class ChefZoneGUI extends HBox {
	
		ChefZoneGUI(){
			this.getChildren().add(new ingredientPane());
		}
	}
