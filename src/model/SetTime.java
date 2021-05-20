package model;

import javafx.animation.Timeline;

public class SetTime {
	protected Timeline timeline;
	
	public Timeline getTimeline() {
		return timeline;
	}
	
	public void stop() {
		timeline.stop();
	}

}
