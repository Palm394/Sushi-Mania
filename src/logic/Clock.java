package logic;

import gui.StatusBar;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Clock {

	private static Timeline timeline;
	
	public static void initialize() {
		// TODO Auto-generated constructor stub
		 timeline = new Timeline(
			    new KeyFrame(
			        Duration.millis( 1000 ),
			        event -> {
			            GameController.timer-=1;
			            StatusBar.getTimerLabel().update();
			        	System.out.println("OK");
			        }
			    )
		);
		
		timeline.setCycleCount(GameController.timeEachRound);
		timeline.play();
	}

	public Timeline getTimeline() {
		return timeline;
	}
	
	public static void stop() {
		timeline.stop();
	}

}
