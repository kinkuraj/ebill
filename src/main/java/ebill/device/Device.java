/**
 * 
 */
package ebill.device;

import java.sql.Time;



/**
 * @author Kinku
 *
 */
public class Device {

	private String state;
	
	private String watts;
	
	private Time time;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getWatts() {
		return watts;
	}

	public void setWatts(String watts) {
		this.watts = watts;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public void run(){
		time = getTime();
	}
	
}
