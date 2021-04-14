package gui;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import logic.GameController;
import model.AlertPane;

public class LevelUpPane extends AlertPane{

	public LevelUpPane(String title, double W, double H) {
		super(title, W, H);
		top.getChildren().remove(0);
	}

	@Override
	protected void addCenter() {
		Label level = new Label("Reached Level " + GameController.getLevel());
		level.setFont(new Font(30));
		
		center.getChildren().add(level);
		center.getChildren().add(continueButton());
	}

	private void newReceipt() {
		
	}
}
