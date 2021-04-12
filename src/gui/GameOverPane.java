package gui;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import logic.GameController;
import model.AlertPane;

public class GameOverPane extends AlertPane{

	public GameOverPane(String title,double W, double H) {
		super(title,W, H);
		top.getChildren().remove(0);
	}
	
	@Override
	protected void addCenter() {
		Label score = new Label("Your Score is "+GameController.getScore()+" points");
		score.setFont(new Font(30));
		
		center.getChildren().add(score);
		center.getChildren().add(backToMenu());
	}

}
