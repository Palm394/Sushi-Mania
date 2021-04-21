package model.LabelStatusBar;

import logic.GameController;
import model.LabelStatus;
import model.base.Updatable;

public class LevelLabel extends LabelStatus {

	@Override
	protected void setSentence() {
		this.textProperty().setValue("Level : " + GameController.getLevel());
	}

}
