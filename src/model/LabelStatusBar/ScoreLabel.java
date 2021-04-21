package model.LabelStatusBar;

import logic.GameController;
import model.LabelStatus;

public class ScoreLabel extends LabelStatus {

	@Override
	protected void setSentence() {
		this.textProperty().setValue(" : " + GameController.getScore());
	}
	
}
