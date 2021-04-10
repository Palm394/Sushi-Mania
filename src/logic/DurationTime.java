package logic;

import gui.StatusBar;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public abstract class DurationTime {

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
	
	protected abstract void show();

	public Timeline getTimeline() {
		return timeline;
	}
	
	public static void stop() {
		timeline.stop();
	}

}
