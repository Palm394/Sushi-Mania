package gui;

import application.Utility;
import javafx.scene.control.Label;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import logic.GameController;
import model.AlertPane;

public class GameOverPane extends AlertPane{

	public GameOverPane(String title,double W, double H) {
		super(title,W, H);
		top.getChildren().remove(0);
		
		AudioClip sound = new AudioClip(ClassLoader.getSystemResource("sound/GameOver.mp3").toString());
		sound.setVolume(Utility.volume);
		sound.play();
	}
	
	@Override
	protected void addCenter() {
		Label score = new Label("Your Level is "+GameController.getLevel() + " !");
		score.setFont(new Font(30));
		
		center.getChildren().add(score);
		center.getChildren().add(backToMenu());
	}

}
