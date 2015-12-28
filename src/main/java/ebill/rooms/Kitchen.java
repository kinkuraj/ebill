package ebill.rooms;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ebill.device.Device;
import ebill.device.Fridge;
import ebill.device.Mixie;
import ebill.device.Oven;
import ebill.util.Constants;

public class Kitchen extends Room {
	
	private JFrame popup;
	
	private JPanel popupPane;
	
	private JLabel popupLbl;
	
	private JButton okBtn;
	
	private JTextField popupTxt;
	
	private long interval;

	private Fridge fridge;

	private Mixie mixie;

	private Oven oven;

	private JButton fridgeBtn;

	private JLabel fridgeLbl;

	private JButton mixieBtn;

	private JLabel mixieLbl;

	private JButton ovenBtn;

	private JLabel ovenLbl;
	
	private JLabel fridgeTimerLbl;
	
	private JLabel mixieTimerLbl;

	
	public JLabel getMixieTimerLbl() {
		return mixieTimerLbl;
	}

	public void setMixieTimerLbl(JLabel mixieTimerLbl) {
		this.mixieTimerLbl = mixieTimerLbl;
	}

	public JLabel getFridgeTimerLbl() {
		return fridgeTimerLbl;
	}

	public void setFridgeTimerLbl(JLabel fridgeTimerLbl) {
		this.fridgeTimerLbl = fridgeTimerLbl;
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

	public JButton getFridgeBtn() {
		if (fridgeBtn == null) {
			fridgeBtn = new JButton("Fridge");
			fridgeBtn.addActionListener(new BtnClickedActionListener());
		}
		return fridgeBtn;
	}

	public void setFridgeBtn(JButton fridgeBtn) {
		this.fridgeBtn = fridgeBtn;
	}

	public JButton getMixieBtn() {
		if (mixieBtn == null) {
			mixieBtn = new JButton("Mixie");
			mixieBtn.addActionListener(new BtnClickedActionListener());
		}
		return mixieBtn;
	}

	public void setMixieBtn(JButton mixieBtn) {
		this.mixieBtn = mixieBtn;
	}

	public JButton getOvenBtn() {
		if (ovenBtn == null) {
			ovenBtn = new JButton("Oven");
			ovenBtn.addActionListener(new BtnClickedActionListener());
		}
		return ovenBtn;
	}

	public void setOvenBtn(JButton ovenBtn) {
		this.ovenBtn = ovenBtn;
	}

	public void init(JPanel showRoomPanel){
		super.init(showRoomPanel);
		
		if (getFridge() != null && getFridge().getState() == Constants.ON) {
			setFridgeLbl(new JLabel(Constants.ON));
			getFridgeBtn().setActionCommand(Constants.FRIDGE);
			getFridgeLbl().setForeground(Color.RED);
			showRoomPanel.add(getFridgeBtn());
			showRoomPanel.add(getFridgeLbl());
			showRoomPanel.add(getFridgeTimerLbl());
		} else {
			setFridge(new Fridge());
			setFridgeTimerLbl(new JLabel(Constants.ZERO));
			setFridgeLbl(new JLabel(Constants.OFF));
			getFridgeBtn().setActionCommand(Constants.FRIDGE);
			getFridgeLbl().setForeground(Color.GREEN);
			showRoomPanel.add(getFridgeBtn());
			showRoomPanel.add(getFridgeLbl());
			showRoomPanel.add(getFridgeTimerLbl());
		}

		if (getOven() != null && getOven().getState() == Constants.ON) {
			setOvenLbl(new JLabel(Constants.ON));
			getOvenBtn().setActionCommand(Constants.OVEN);
			getOvenLbl().setForeground(Color.RED);
			showRoomPanel.add(getOvenBtn());
			showRoomPanel.add(getOvenLbl());
		} else {
			setOven(new Oven());
			setOvenLbl(new JLabel(Constants.OFF));
			getOvenBtn().setActionCommand(Constants.OVEN);
			getOvenLbl().setForeground(Color.GREEN);
			showRoomPanel.add(getOvenBtn());
			showRoomPanel.add(getOvenLbl());
		}

		if (getMixie() != null && getMixie().getState() == Constants.ON) {
			setMixieLbl(new JLabel(Constants.ON));
			getMixieBtn().setActionCommand(Constants.MIXIE);
			getMixieLbl().setForeground(Color.RED);
			showRoomPanel.add(getMixieBtn());
			showRoomPanel.add(getMixieLbl());
			showRoomPanel.add(getMixieTimerLbl());
		} else {
			setMixie(new Mixie());
			setMixieLbl(new JLabel(Constants.OFF));
			setMixieTimerLbl(new JLabel(Constants.ZERO));
			getMixieBtn().setActionCommand(Constants.MIXIE);
			getMixieLbl().setForeground(Color.GREEN);
			showRoomPanel.add(getMixieBtn());
			showRoomPanel.add(getMixieLbl());
			showRoomPanel.add(getMixieTimerLbl());
		}
	}
	
	
	private void switchOffDevice(Device device, JLabel jlabel){
		jlabel.setText(Constants.OFF);
		jlabel.setForeground(Color.GREEN);
		device.setState(Constants.OFF);
		device.setEndTime(System.currentTimeMillis());
		device.setTotalTime(device.getTotalTime()
				+ (device.getEndTime() - device.getStartTime()));
		// 5min- 1Unit (1khW)
		device.setWatts(String.valueOf(Long
				.parseLong(device.getWatts() == null ? Constants.ZERO : device
						.getWatts())
				+ ((device.getTotalTime() / 10) / 3)));
	}
	
	private void switchOnDevice(Device device, JLabel jlabel){
		device.setStartTime(System.currentTimeMillis());
		jlabel.setText(Constants.ON);
		jlabel.setForeground(Color.RED);
		device.setState(Constants.ON);
	}
	protected void switchOnOffDevice(Device device, JLabel jlabel) {

		
		if (device.getState() == Constants.ON) {
			
			if(device instanceof Fridge){
				((Fridge) device).getTimer().cancel();
				getFridgeTimerLbl().setText(Constants.ZERO);
			}else if(device instanceof Mixie){
				((Mixie) device).getTimer().cancel();
				getMixieTimerLbl().setText(Constants.ZERO);
			}
			
			switchOffDevice(device,jlabel);
			System.out.println(device.getWatts());
			
			
		} else {
			
			if(device instanceof Fridge){
				//durationPopUp();
				String duration = (String) JOptionPane.showInputDialog(null, "Enter duration:",null,JOptionPane.CLOSED_OPTION,null, null, JOptionPane.OK_OPTION);
				interval = Long.valueOf(duration == null ? Constants.ZERO : duration);
				if(interval == 0){
					JOptionPane.showConfirmDialog(null, "Fridge couldn't be switched ON without timer!!",null,JOptionPane.CLOSED_OPTION,JOptionPane.ERROR_MESSAGE);
					return;
				}
				int delay = 1000;
			    int period = 1000;
			    getFridge().setTimer(new Timer()); 
			    
			    getFridge().getTimer().scheduleAtFixedRate(new TimerTask() {

			        public void run() {
			        	getFridgeTimerLbl().setText(String.valueOf(setInterval(getFridge().getTimer())));
			        	if (interval == 0){
			        		getFridge().getTimer().cancel();
			        		
			        		switchOffDevice(getFridge(),getFridgeLbl());
			        	}
			        }
			    }, delay, period);
			}else if(device instanceof Mixie){
				int delay = 1000;
			    int period = 1000;
			    getMixie().setTimer(new Timer()); 
			    String duration = (String) JOptionPane.showInputDialog(null, "Enter duration:",null,JOptionPane.CLOSED_OPTION,null, null, JOptionPane.OK_OPTION);
			    interval = Long.valueOf(duration == null ? Constants.ZERO : duration);
				if(interval == 0){
					JOptionPane.showConfirmDialog(null, "Mixie couldn't be switched ON without timer!!",null,JOptionPane.CLOSED_OPTION,JOptionPane.ERROR_MESSAGE);
					return;
				}
			    getMixie().getTimer().scheduleAtFixedRate(new TimerTask() {

			        public void run() {
			        	getMixieTimerLbl().setText(String.valueOf(setInterval(getFridge().getTimer())));
			        	if (interval == 0){
			        		getMixie().getTimer().cancel();
			        		switchOffDevice(getMixie(),getMixieLbl());
			        	}
			        }
			    }, delay, period);
			}
			
			switchOnDevice(device,jlabel);
		    
			
		}
	}
	
	private void durationPopUp(){
		popup = new JFrame("PopUp");
		popup.setSize(350, 150);
		popup.setLayout(new GridLayout(2, 1));
		
		popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		popupPane = new JPanel();
		popupTxt = new JTextField();
		popupTxt.setSize(100, 100);
		okBtn = new JButton("OK");
		okBtn.setActionCommand("OK");
		okBtn.addActionListener(new BtnClickedActionListener());
		popupLbl = new JLabel("Enter the duration:");
		popupPane.add(popupLbl);
		popupPane.add(popupTxt);
		popupPane.add(okBtn);
		
		popup.add(popupPane);
		popup.setVisible(true);
	}
	private final long setInterval(Timer timer) {
        if (interval == 1)
            timer.cancel();
        return --interval;
    }
	private class BtnClickedActionListener implements ActionListener {

		
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equalsIgnoreCase(Constants.FRIDGE)) {
				switchOnOffDevice(getFridge(), getFridgeLbl());
				/*int timeDelay = 1000;
				ActionListener time;
				time = new ActionListener() {

				    public void actionPerformed(ActionEvent evt) {
				    	getFridgeTimerLbl().setText(String.valueOf(System.currentTimeMillis())); 
				    }
				};

				new Timer(timeDelay, time).start();*/
				
			    
			}
			if (e.getActionCommand().equalsIgnoreCase(Constants.MIXIE)) {
				switchOnOffDevice(getMixie(), getMixieLbl());
			}
			if (e.getActionCommand().equalsIgnoreCase(Constants.OVEN)) {
				switchOnOffDevice(getOven(), getOvenLbl());
			}
			
			if (e.getActionCommand().equalsIgnoreCase("OK")) {
				getFridge().setDuration(Long.valueOf(popupTxt.getText().trim().equalsIgnoreCase("") ? Constants.ZERO :popupTxt.getText()));
			}

		}
		
		

	}

}
