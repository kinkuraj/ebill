package ebill.device;

import java.util.Timer;

public class Mixie extends Device{
	private long duration;

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	private Timer timer;

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}
}
