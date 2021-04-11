package logic;

import javafx.animation.Timeline;

public abstract class SetTime {
	protected Timeline timeline;
	protected int pass_time;
	
	protected Timeline getTimeline() {
		return timeline;
	}
	
	protected void stop() {
		timeline.stop();
	}

}
