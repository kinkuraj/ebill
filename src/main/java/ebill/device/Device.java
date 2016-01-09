/**
 * 
 */
package ebill.device;

import ebill.util.Constants;




/**
 * @author Kinku
 *
 */
public class Device extends Thread{

	private String deviceState;
	
	private long watts;
	
	private long startTime;
	
	private long endTime;
	
	private long totalTime;
	
	public Device(long watts){
		this.watts=watts;		
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public long getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(long totalTime) {
		this.totalTime = totalTime;
	}

	public long getWatts() {
		return watts;
	}

	public void setWatts(long watts) {
		this.watts = watts;
	}

	 public String getDeviceState() {
		return deviceState;
	}

	public void setDeviceState(String deviceState) {
		this.deviceState = deviceState;
	}

	public void run() {
		 while(deviceState.equalsIgnoreCase(Constants.ON)){
			 try {
				Thread.sleep(1000);
				totalTime++;
				setTotalTime(totalTime);
				System.out.println(totalTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 if(deviceState.equalsIgnoreCase(Constants.OFF)){
				 totalTime = 0;
				 
			 }
		 }
	 }
}
