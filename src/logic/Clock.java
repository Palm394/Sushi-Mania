package logic;

import gui.StatusBar;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Clock {

	private static Timeline timeline;
	
	public static void initialize() {
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

	public Timeline getTimeline() {
		return timeline;
	}
	
	public static void stop() {
		timeline.stop();
	}

}
