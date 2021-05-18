package model;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import model.base.Updatable;

public abstract class LabelStatus extends Label implements Updatable {
	
	public LabelStatus() {
		this.setFont(new Font(20));
		this.setPadding(new Insets(0,130,0,0));
		update();
	}

}
