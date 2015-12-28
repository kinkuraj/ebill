package ebill.rooms;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ebill.device.WaterHeater;
import ebill.util.Constants;

public class Toilet extends Room{
	
	private WaterHeater waterHeater;
	
	private JButton whBtn;

	private JLabel whLbl;

	public WaterHeater getWaterHeater() {
		return waterHeater;
	}

	public void setWaterHeater(WaterHeater waterHeater) {
		this.waterHeater = waterHeater;
	}

	public JLabel getWhLbl() {
		return whLbl;
	}

	public void setWhLbl(JLabel whLbl) {
		this.whLbl = whLbl;
	}
	
	public JButton getWhBtn() {
		if(whBtn == null){
			whBtn = new JButton("Water Heater");
			whBtn.addActionListener(new BtnClickedActionListener());
		}
		return whBtn;
	}

	public void setWhBtn(JButton whBtn) {
		this.whBtn = whBtn;
	}
	
	public void init(JPanel showRoomPanel){
		super.init(showRoomPanel);
		
		if (getWaterHeater() != null
				&& getWaterHeater().getState() == Constants.ON) {
			setWhLbl(new JLabel(Constants.ON));
			getWhBtn().setActionCommand(Constants.WH);
			getWhLbl().setForeground(Color.RED);
			showRoomPanel.add(getWhBtn());
			showRoomPanel.add(getWhLbl());
		} else {
			setWaterHeater(new WaterHeater());
			setWhLbl(new JLabel(Constants.OFF));
			getWhBtn().setActionCommand(Constants.WH);
			getWhLbl().setForeground(Color.GREEN);
			showRoomPanel.add(getWhBtn());
			showRoomPanel.add(getWhLbl());
		}
	}

	private class BtnClickedActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equalsIgnoreCase(Constants.WH)){
				switchOnOffDevice(getWaterHeater(),getWhLbl());
			}
			
		}
		
	}
	
}
