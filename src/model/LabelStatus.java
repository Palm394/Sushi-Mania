package model;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import model.base.Updatable;

public class LabelStatus extends Label implements Updatable {
	
	public LabelStatus() {
		this.setFont(new Font(20));
		this.setPadding(new Insets(0,140,0,0));
		setSentence();
	}
	
	protected void setSentence() {
		//set sentence
	}

	@Override
	public void update() {
		setSentence();
	}
}
