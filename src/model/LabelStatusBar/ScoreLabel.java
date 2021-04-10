package model.LabelStatusBar;

import logic.GameController;
import model.LabelStatus;
import model.base.Updatable;

public class ScoreLabel extends LabelStatus {

	public ScoreLabel() {
		super("Score");
	}

	@Override
	protected void setSentence() {
		this.textProperty().setValue("Score : " + GameController.getScore());
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		setSentence();
	}

}
