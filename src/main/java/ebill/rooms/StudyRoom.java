package ebill.rooms;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ebill.device.Fan;
import ebill.device.TubeLight;
import ebill.util.Constants;

public class StudyRoom extends Room{
	private Fan fan;

	private TubeLight tubeLight;

	private JButton fanBtn;

	private JLabel fanLbl;

	private JButton tubeLightBtn;

	private JLabel tubeLightLbl;

	public JLabel getTubeLightLbl() {
		return tubeLightLbl;
	}

	public void setTubeLightLbl(JLabel tubeLightLbl) {
		this.tubeLightLbl = tubeLightLbl;
	}

	public Fan getFan() {
		return fan;
	}

	public void setFan(Fan fan) {
		this.fan = fan;
	}

	public TubeLight getTubeLight() {
		return tubeLight;
	}

	public void setTubeLight(TubeLight tubeLight) {
		this.tubeLight = tubeLight;
	}

	public JButton getFanBtn() {
		if (fanBtn == null) {
			fanBtn = new JButton("Fan");
			fanBtn.addActionListener(new BtnClickedActionListener());
		}
		return fanBtn;
	}

	public void setFanBtn(JButton fanBtn) {
		this.fanBtn = fanBtn;
	}

	public JButton getTubeLightBtn() {
		if (tubeLightBtn == null) {
			tubeLightBtn = new JButton("TubeLight");
			tubeLightBtn.addActionListener(new BtnClickedActionListener());
		}
		return tubeLightBtn;
	}

	public void setTubeLightBtn(JButton tubeLightBtn) {
		this.tubeLightBtn = tubeLightBtn;
	}

	public JLabel getFanLbl() {
		return fanLbl;
	}

	public void setFanLbl(JLabel fanLbl) {
		this.fanLbl = fanLbl;
	}

	public void init(JPanel showRoomPanel){
		super.init(showRoomPanel);
		if (getFan() != null && getFan().getState() == Constants.ON) {
			setFanLbl(new JLabel(Constants.ON));
			getFanBtn().setActionCommand(Constants.FAN);
			getFanLbl().setForeground(Color.RED);
			showRoomPanel.add(getFanBtn());
			showRoomPanel.add(getFanLbl());
		} else {
			setFan(new Fan());
			setFanLbl(new JLabel(Constants.OFF));
			getFanBtn().setActionCommand(Constants.FAN);
			getFanLbl().setForeground(Color.GREEN);
			showRoomPanel.add(getFanBtn());
			showRoomPanel.add(getFanLbl());
		}
		if (getTubeLight() != null && getTubeLight().getState() == Constants.ON) {
			setTubeLightLbl(new JLabel(Constants.ON));
			getTubeLightBtn().setActionCommand(Constants.TUBE_LIGHT);
			getTubeLightLbl().setForeground(Color.RED);
			showRoomPanel.add(getTubeLightBtn());
			showRoomPanel.add(getTubeLightLbl());
		} else {
			setTubeLight(new TubeLight());
			setTubeLightLbl(new JLabel(Constants.OFF));
			getTubeLightBtn().setActionCommand(Constants.TUBE_LIGHT);
			getTubeLightLbl().setForeground(Color.GREEN);
			showRoomPanel.add(getTubeLightBtn());
			showRoomPanel.add(getTubeLightLbl());
		}
	}
	private class BtnClickedActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equalsIgnoreCase(Constants.FAN)) {
				switchOnOffDevice(getFan(), getFanLbl());
			}
			if (e.getActionCommand().equalsIgnoreCase(Constants.TUBE_LIGHT)) {
				switchOnOffDevice(getTubeLight(), getTubeLightLbl());
			}

		}

	}
}
