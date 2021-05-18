package model.LabelStatusBar;

import logic.GameController;
import model.LabelStatus;

public class ScoreLabel extends LabelStatus {

	@Override
	public void update() {
		this.textProperty().setValue(" : " + GameController.getScore());
	}

}
