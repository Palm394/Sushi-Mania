package logic;

import gui.StatusBar;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import model.SetTime;

public class TimerController extends SetTime{

	public TimerController() {
		GameController.setTimer(GameController.getTimeeachround());
		timeline = new Timeline(
			    new KeyFrame(
			        Duration.millis( 1000 ),
			        event -> {
			            GameController.setTimer(GameController.getTimer() - 1);
			            StatusBar.getTimerLabel().update();
			        }
			    )
		);
		
		timeline.setCycleCount(GameController.getTimeeachround());
		timeline.play();
	}

}
