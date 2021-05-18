package model.LabelStatusBar;

import logic.GameController;
import model.LabelStatus;

public class LevelLabel extends LabelStatus {

	@Override
	public void update() {
		this.textProperty().setValue("Level : " + GameController.getLevel());
	}

}
