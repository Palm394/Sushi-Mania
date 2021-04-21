package model;

import javafx.animation.Timeline;

public class SetTime {
	protected Timeline timeline;
	protected int pass_time;
	
	public Timeline getTimeline() {
		return timeline;
	}
	
	public void stop() {
		timeline.stop();
	}

}
