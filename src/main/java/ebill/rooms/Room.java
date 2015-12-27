package ebill.rooms;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;

import ebill.device.Bulb;
import ebill.device.Device;
import ebill.device.Fan;
import ebill.device.Fridge;
import ebill.device.Mixie;
import ebill.device.Oven;
import ebill.device.TV;
import ebill.device.TubeLight;
import ebill.device.WaterHeater;

public class Room {
	private static String OFF = "OFF";
	
	private static String ON = "ON";
	
	private Bulb bulb;
	
	private Fan fan;
	
	private Fridge fridge;
	
	private Mixie mixie;
	
	private Oven oven;
	
	private TubeLight tubeLight;
	
	private TV tv;
	
	private JButton bulbBtn;
	
	private JLabel bulbLbl;
	
	private JLabel bulbTimeLbl;
	
	private JButton fanBtn;
	
	private JLabel fanLbl;
	
	private JButton fridgeBtn;
	
	private JLabel fridgeLbl;
	
	private JButton mixieBtn;
	
	private JLabel mixieLbl;
	
	private JButton ovenBtn;
	
	private JLabel ovenLbl;
	
	private JButton tubeLightBtn;
	
	private JLabel tubeLightLbl;
	
	private JButton tvBtn;
	
	private JLabel tvLbl;
	
	private JButton whBtn;
	
	private JLabel whLbl;
	
	
	public JLabel getBulbTimeLbl() {
		return bulbTimeLbl;
	}

	public void setBulbTimeLbl(JLabel bulbTimeLbl) {
		this.bulbTimeLbl = bulbTimeLbl;
	}

	public JLabel getFridgeLbl() {
		return fridgeLbl;
	}

	public void setFridgeLbl(JLabel fridgeLbl) {
		this.fridgeLbl = fridgeLbl;
	}

	public JLabel getMixieLbl() {
		return mixieLbl;
	}

	public void setMixieLbl(JLabel mixieLbl) {
		this.mixieLbl = mixieLbl;
	}

	public JLabel getOvenLbl() {
		return ovenLbl;
	}

	public void setOvenLbl(JLabel ovenLbl) {
		this.ovenLbl = ovenLbl;
	}

	public JLabel getTubeLightLbl() {
		return tubeLightLbl;
	}

	public void setTubeLightLbl(JLabel tubeLightLbl) {
		this.tubeLightLbl = tubeLightLbl;
	}

	public JLabel getTvLbl() {
		return tvLbl;
	}

	public void setTvLbl(JLabel tvLbl) {
		this.tvLbl = tvLbl;
	}

	public JLabel getWhLbl() {
		return whLbl;
	}

	public void setWhLbl(JLabel whLbl) {
		this.whLbl = whLbl;
	}

	private WaterHeater waterHeater;
	
	public Bulb getBulb() {
		return bulb;
	}

	public void setBulb(Bulb bulb) {
		this.bulb = bulb;
	}

	public Fan getFan() {
		return fan;
	}

	public void setFan(Fan fan) {
		this.fan = fan;
	}

	public Fridge getFridge() {
		return fridge;
	}

	public void setFridge(Fridge fridge) {
		this.fridge = fridge;
	}

	public Mixie getMixie() {
		return mixie;
	}

	public void setMixie(Mixie mixie) {
		this.mixie = mixie;
	}

	public Oven getOven() {
		return oven;
	}

	public void setOven(Oven oven) {
		this.oven = oven;
	}

	public TubeLight getTubeLight() {
		return tubeLight;
	}

	public void setTubeLight(TubeLight tubeLight) {
		this.tubeLight = tubeLight;
	}

	public TV getTv() {
		return tv;
	}

	public void setTv(TV tv) {
		this.tv = tv;
	}

	public WaterHeater getWaterHeater() {
		return waterHeater;
	}

	public void setWaterHeater(WaterHeater waterHeater) {
		this.waterHeater = waterHeater;
	}
	
	public JButton getBulbBtn() {
		if(bulbBtn == null){
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
		if(bulbLbl == null){
			return new JLabel("OFF");
		}
		return bulbLbl;
	}

	public void setBulbLbl(JLabel bulbLbl) {
		this.bulbLbl = bulbLbl;
	}

	public JButton getFanBtn() {
		if(fanBtn == null){
			fanBtn = new JButton("Fan");
			fanBtn.addActionListener(new BtnClickedActionListener());
		}
		return fanBtn;
	}

	public void setFanBtn(JButton fanBtn) {
		this.fanBtn = fanBtn;
	}

	public JButton getFridgeBtn() {
		if(fridgeBtn == null){
			fridgeBtn = new JButton("Fridge");
			fridgeBtn.addActionListener(new BtnClickedActionListener());
		}
		return fridgeBtn;
	}

	public void setFridgeBtn(JButton fridgeBtn) {
		this.fridgeBtn = fridgeBtn;
	}

	public JButton getMixieBtn() {
		if(mixieBtn == null){
			mixieBtn = new JButton("Mixie");
			mixieBtn.addActionListener(new BtnClickedActionListener());
		}
		return mixieBtn;
	}

	public void setMixieBtn(JButton mixieBtn) {
		this.mixieBtn = mixieBtn;
	}

	public JButton getOvenBtn() {
		if(ovenBtn == null){
			ovenBtn = new JButton("Oven");
			ovenBtn.addActionListener(new BtnClickedActionListener());
		}
		return ovenBtn;
	}

	public void setOvenBtn(JButton ovenBtn) {
		this.ovenBtn = ovenBtn;
	}

	public JButton getTubeLightBtn() {
		if(tubeLightBtn == null){
			tubeLightBtn = new JButton("TubeLight");
			tubeLightBtn.addActionListener(new BtnClickedActionListener());
		}
		return tubeLightBtn;
	}

	public void setTubeLightBtn(JButton tubeLightBtn) {
		this.tubeLightBtn = tubeLightBtn;
	}

	public JButton getTvBtn() {
		if(tvBtn == null){
			tvBtn = new JButton("TV");
			tvBtn.addActionListener(new BtnClickedActionListener());
		}
		return tvBtn;
	}

	public void setTvBtn(JButton tvBtn) {
		this.tvBtn = tvBtn;
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
	
	public JLabel getFanLbl() {
		return fanLbl;
	}

	public void setFanLbl(JLabel fanLbl) {
		this.fanLbl = fanLbl;
	}
	long totalTime;
	long startTime;
	long endTime;
	Timer bulbTimer = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
             startTime = System.currentTimeMillis();
             endTime   = System.currentTimeMillis();
            totalTime = endTime - startTime;
        }
    });
 
    
	private class BtnClickedActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equalsIgnoreCase("Bulb")){
				switchOnOffDevice(getBulb(),getBulbLbl());
			}
			if(e.getActionCommand().equalsIgnoreCase("Fan")){
				switchOnOffDevice(getFan(),getFanLbl());
			}
			if(e.getActionCommand().equalsIgnoreCase("Fridge")){
				switchOnOffDevice(getFridge(),getFridgeLbl());
			}
			if(e.getActionCommand().equalsIgnoreCase("Mixie")){
				switchOnOffDevice(getMixie(),getMixieLbl());
			}
			if(e.getActionCommand().equalsIgnoreCase("Oven")){
				switchOnOffDevice(getOven(),getOvenLbl());
			}
			if(e.getActionCommand().equalsIgnoreCase("TubeLight")){
				switchOnOffDevice(getTubeLight(),getTubeLightLbl());
			}
			if(e.getActionCommand().equalsIgnoreCase("TV")){
				switchOnOffDevice(getTv(),getTvLbl());
			}
			if(e.getActionCommand().equalsIgnoreCase("WH")){
				switchOnOffDevice(getWaterHeater(),getWhLbl());
			}
			
		}
		
	}
	
protected void switchOnOffDevice(Device device, JLabel jlabel){
		
		if(device.getState() == ON){
			jlabel.setText(OFF);
			jlabel.setForeground(Color.GREEN);
			device.setState(OFF);
			endTime = System.currentTimeMillis();
			System.out.println("End: "+endTime);
			totalTime += (endTime-startTime);
			System.out.println("Total: "+totalTime);
			//5min- 1Unit (1khW)
			device.setWatts(String.valueOf(Long.parseLong(device.getWatts()==null?"0":device.getWatts())+((totalTime/10)/3)));
			System.out.println(device.getWatts());
		}else{
			startTime = System.currentTimeMillis();
			System.out.println("start: "+startTime);
			jlabel.setText(ON);
			jlabel.setForeground(Color.RED);
			device.setState(ON);
		}
	}
	
}
