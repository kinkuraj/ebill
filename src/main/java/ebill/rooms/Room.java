package ebill.rooms;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import ebill.device.Bulb;
import ebill.device.Device;
import ebill.util.Constants;

public class Room {

	private Bulb bulb;

	private JButton bulbBtn;

	private JLabel bulbLbl;

	private JLabel bulbTimeLbl;

	public Bulb getBulb() {
		return bulb;
	}

	public void setBulb(Bulb bulb) {
		this.bulb = bulb;
	}

	public JLabel getBulbTimeLbl() {
		return bulbTimeLbl;
	}

	public void setBulbTimeLbl(JLabel bulbTimeLbl) {
		this.bulbTimeLbl = bulbTimeLbl;
	}

	public JButton getBulbBtn() {
		if (bulbBtn == null) {
			bulbBtn = new JButton("Bulb");
			bulbBtn.addActionListener(new BtnClickedActionListener());
			return bulbBtn;
		}
		return bulbBtn;
	}

	public void setBulbBtn(JButton bulbBtn) {
		this.bulbBtn = bulbBtn;
	}

	public JLabel getBulbLbl() {
		if (bulbLbl == null) {
			return new JLabel("OFF");
		}
		return bulbLbl;
	}

	public void setBulbLbl(JLabel bulbLbl) {
		this.bulbLbl = bulbLbl;
	}

	/*
	 * long totalTime; long startTime; long endTime; Timer bulbTimer = new
	 * Timer(500, new ActionListener() { public void actionPerformed(ActionEvent
	 * e) { startTime = System.currentTimeMillis(); endTime =
	 * System.currentTimeMillis(); totalTime = endTime - startTime; } });
	 */

	public void init(JPanel showRoomPanel){
		if (getBulb() != null && getBulb().getState() == Constants.ON) {
			setBulbLbl(new JLabel(Constants.ON));
			getBulbBtn().setActionCommand(Constants.BULB);
			getBulbLbl().setForeground(Color.RED);
			showRoomPanel.add(getBulbBtn());
			showRoomPanel.add(getBulbLbl());
		} else {
			setBulb(new Bulb());
			setBulbLbl(new JLabel(Constants.OFF));
			getBulbBtn().setActionCommand(Constants.BULB);
			getBulbLbl().setForeground(Color.GREEN);
			showRoomPanel.add(getBulbBtn());
			showRoomPanel.add(getBulbLbl());
		}
	}
	private class BtnClickedActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equalsIgnoreCase(Constants.BULB)) {
				switchOnOffDevice(getBulb(), getBulbLbl());
			}

		}

	}

	protected void switchOnOffDevice(Device device, JLabel jlabel) {

		if (device.getState() == Constants.ON) {
			jlabel.setText(Constants.OFF);
			jlabel.setForeground(Color.GREEN);
			device.setState(Constants.OFF);
			device.setEndTime(System.currentTimeMillis());
			device.setTotalTime(device.getTotalTime()
					+ (device.getEndTime() - device.getStartTime()));
			// 5min- 1Unit (1khW)
			device.setWatts(String.valueOf(Long
					.parseLong(device.getWatts() == null ? "0" : device
							.getWatts())
					+ ((device.getTotalTime() / 10) / 3)));
			System.out.println(device.getWatts());
		} else {
			device.setStartTime(System.currentTimeMillis());
			jlabel.setText(Constants.ON);
			jlabel.setForeground(Color.RED);
			device.setState(Constants.ON);
		}
	}

}
