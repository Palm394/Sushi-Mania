package model;

import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class NavButton extends Button {
	
	public NavButton(String title) {
		super(title);
		
		this.setAlignment(Pos.CENTER);
		
		this.setPrefHeight(50);
		this.setPrefWidth(200);
		
		this.setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00);\n"
				+ "    -fx-background-radius: 30;\n"
				+ "    -fx-background-insets: 0;\n"
				+ "    -fx-text-fill: white;");
	}
	
}
