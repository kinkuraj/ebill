package ebill.app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import ebill.device.Bulb;
import ebill.device.Fan;
import ebill.device.Fridge;
import ebill.device.Mixie;
import ebill.device.Oven;
import ebill.device.TV;
import ebill.device.TubeLight;
import ebill.device.WaterHeater;
import ebill.rooms.BedRoom;
import ebill.rooms.Hall;
import ebill.rooms.Kitchen;
import ebill.rooms.Room;
import ebill.rooms.StudyRoom;
import ebill.rooms.Toilet;

public class Home {
	
	private static String OFF = "OFF";
	
	private static String ON = "ON";
	
	private JFrame mainFrame;
	
	private JPanel picPanel;
	
	private JPanel showPanel;
	
	private JLabel picLbl;
	
	private JLabel picTxt;
	
	private BufferedImage bedroomImg;
	
	private BufferedImage hallImg;
	
	private BufferedImage kitchenImg;
	
	private BufferedImage studyRoomImg;
	
	private BufferedImage washroomImg;
	
	private String clickedRoom;
	
	private Room room;
	
	private BedRoom bedRoom;
	
	private Hall hall;
	
	private Kitchen kitchen;
	
	private Toilet washRoom;
	
	private StudyRoom studyRoom;
	
	
JSplitPane showSplitPane;
	
	JPanel showRoomPanel;
	
	JPanel picLblPanel;

	
	
	public void setWashRoom(Toilet washRoom) {
		this.washRoom = washRoom;
	}

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

	public Kitchen getKitchen() {
		return kitchen;
	}

	public void setKitchen(Kitchen kitchen) {
		this.kitchen = kitchen;
	}


	public Toilet getWashRoom() {
		return washRoom;
	}

	public StudyRoom getStudyRoom() {
		return studyRoom;
	}

	public void setStudyRoom(StudyRoom studyRoom) {
		this.studyRoom = studyRoom;
	}

	public BedRoom getBedRoom() {
		return bedRoom;
	}

	public void setBedRoom(BedRoom bedRoom) {
		this.bedRoom = bedRoom;
	}

	public String getClickedRoom() {
		return clickedRoom;
	}

	public void setClickedRoom(String clickedRoom) {
		this.clickedRoom = clickedRoom;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public JFrame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public JPanel getPicPanel() {
		return picPanel;
	}

	public void setPicPanel(JPanel picPanel) {
		this.picPanel = picPanel;
	}

	public JPanel getShowPanel() {
		return showPanel;
	}

	public void setShowPanel(JPanel showPanel) {
		this.showPanel = showPanel;
	}

	public JLabel getPicLbl() {
		return picLbl;
	}

	public void setPicLbl(JLabel picLbl) {
		this.picLbl = picLbl;
	}

	public JLabel getPicTxt() {
		return picTxt;
	}

	public void setPicTxt(JLabel picTxt) {
		this.picTxt = picTxt;
	}

	public BufferedImage getBedroomImg() {
		return bedroomImg;
	}

	public void setBedroomImg(BufferedImage bedroomImg) {
		this.bedroomImg = bedroomImg;
	}



	

	public BufferedImage getHallImg() {
		return hallImg;
	}

	public void setHallImg(BufferedImage hallImg) {
		this.hallImg = hallImg;
	}

	public BufferedImage getKitchenImg() {
		return kitchenImg;
	}

	public void setKitchenImg(BufferedImage kitchenImg) {
		this.kitchenImg = kitchenImg;
	}

	public BufferedImage getStudyRoomImg() {
		return studyRoomImg;
	}

	public void setStudyRoomImg(BufferedImage studyRoomImg) {
		this.studyRoomImg = studyRoomImg;
	}

	public BufferedImage getWashroomImg() {
		return washroomImg;
	}

	public void setWashroomImg(BufferedImage washroomImg) {
		this.washroomImg = washroomImg;
	}

	public Home(){
		prepareGUI();
	}

	
	
	private void prepareGUI(){
		mainFrame = new JFrame("My Home");
		mainFrame.setSize(1000,700);
		mainFrame.setLayout(new GridLayout(1,2));

		showPanel = new JPanel();
		showPanel.setMinimumSize(new Dimension(300, 600));
		showPanel.setBackground(new Color(222));
		showPanel.setLayout(new BoxLayout(showPanel, BoxLayout.Y_AXIS));

		picPanel = new JPanel();
		picPanel.setMinimumSize(new Dimension(200, 600));
		picPanel.setLayout(new BoxLayout(picPanel, BoxLayout.Y_AXIS));

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,picPanel,showPanel);
		splitPane.setOneTouchExpandable(true);

		picLblPanel = new JPanel();
		picLblPanel.setMinimumSize(new Dimension(300, 200));
		picLblPanel.setLayout(new GridLayout(1,0));
		picLblPanel.setBackground(Color.RED);
		showRoomPanel = new JPanel();
		showRoomPanel.setMinimumSize(new Dimension(200, 200));
		showSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,picLblPanel,showRoomPanel);

		showSplitPane.setOneTouchExpandable(true);
		showPanel.add(showSplitPane);
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}        
		});
		
		bedRoom = new BedRoom();
		hall = new Hall();
		kitchen = new Kitchen();
		washRoom = new Toilet();
		studyRoom = new StudyRoom();
		
		mainFrame.add(splitPane);
		mainFrame.setVisible(true);  
	}

	public void showEventDemo(){

		try {
			bedroomImg = ImageIO.read(new File("src\\resources\\bedroom.jpg"));
			hallImg = ImageIO.read(new File("src\\resources\\hall.jpg"));
			kitchenImg = ImageIO.read(new File("src\\resources\\kitchen.jpg"));
			studyRoomImg = ImageIO.read(new File("src\\resources\\studyRoom.jpg"));
			washroomImg = ImageIO.read(new File("src\\resources\\washroom.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		picLbl = new JLabel(new ImageIcon(bedroomImg));
		picTxt = new JLabel("Room Details",JLabel.CENTER);

		picLblPanel.add(picLbl);
		picLblPanel.add(picTxt);
		
		JButton bedroomButton = new JButton();
		JButton hallButton = new JButton();
		JButton kitchenButton = new JButton();
		JButton studyRRoomButton = new JButton();
		JButton washRoomButton = new JButton();

		bedroomButton.setActionCommand("BR");
		hallButton.setActionCommand("HL");
		kitchenButton.setActionCommand("KT");
		studyRRoomButton.setActionCommand("SR");
		washRoomButton.setActionCommand("WR");

		bedroomButton.addActionListener(new ButtonClickListener());
		bedroomButton.setIcon(new ImageIcon(bedroomImg));
		bedroomButton.setSize(100, 100);

		hallButton.addActionListener(new ButtonClickListener());
		hallButton.setIcon(new ImageIcon(hallImg));
		hallButton.setSize(100, 100);

		kitchenButton.addActionListener(new ButtonClickListener());
		kitchenButton.setIcon(new ImageIcon(kitchenImg));
		kitchenButton.setSize(100, 100);

		studyRRoomButton.addActionListener(new ButtonClickListener());
		studyRRoomButton.setIcon(new ImageIcon(studyRoomImg));
		studyRRoomButton.setSize(100, 100);

		washRoomButton.addActionListener(new ButtonClickListener());
		washRoomButton.setIcon(new ImageIcon(washroomImg));
		washRoomButton.setSize(100, 100);


		picPanel.add(bedroomButton);
		picPanel.add(hallButton);
		picPanel.add(kitchenButton);   
		picPanel.add(studyRRoomButton);
		picPanel.add(washRoomButton);
		mainFrame.setVisible(true);  
	}

	private void initRooms(Room room){
		System.out.println("init");	
		
		picLblPanel.add(picLbl);
		picLblPanel.add(picTxt);
		if(getRoom().getBulb() != null && getRoom().getBulb().getState() == ON){
			room.setBulbLbl(new JLabel(ON));
			getRoom().getBulbBtn().setActionCommand("Bulb");
			getRoom().getBulbLbl().setForeground(Color.RED);
			showRoomPanel.add(getRoom().getBulbBtn());
			showRoomPanel.add(getRoom().getBulbLbl());
		}else{
			room.setBulb(new Bulb());
			room.setBulbLbl(new JLabel(OFF));
			getRoom().getBulbBtn().setActionCommand("Bulb");
			getRoom().getBulbLbl().setForeground(Color.GREEN);
			showRoomPanel.add(getRoom().getBulbBtn());
			showRoomPanel.add(getRoom().getBulbLbl());
		}
		
		if(getRoom().getFan() != null && getRoom().getFan().getState() == ON){
			room.setFanLbl(new JLabel(ON));
			getRoom().getFanBtn().setActionCommand("Fan");
			getRoom().getFanLbl().setForeground(Color.RED);
			showRoomPanel.add(getRoom().getFanBtn());
			showRoomPanel.add(getRoom().getFanLbl());
		}else{
			room.setFan(new Fan());
			room.setFanLbl(new JLabel("OFF"));
			getRoom().getFanBtn().setActionCommand("Fan");
			getRoom().getFanLbl().setForeground(Color.GREEN);
			showRoomPanel.add(getRoom().getFanBtn());
			showRoomPanel.add(getRoom().getFanLbl());
		}

		if(getRoom().getFridge() != null && getRoom().getFridge().getState() == ON){
			room.setFridgeLbl(new JLabel(ON));
			getRoom().getFridgeBtn().setActionCommand("Fridge");
			getRoom().getFridgeLbl().setForeground(Color.RED);
			showRoomPanel.add(getRoom().getFridgeBtn());
			showRoomPanel.add(getRoom().getFridgeLbl());
		}else{
			room.setFridge(new Fridge());
			room.setFridgeLbl(new JLabel("OFF"));
			getRoom().getFridgeBtn().setActionCommand("Fridge");
			getRoom().getFridgeLbl().setForeground(Color.GREEN);
			showRoomPanel.add(getRoom().getFridgeBtn());
			showRoomPanel.add(getRoom().getFridgeLbl());
		}
		
		if(getRoom().getMixie() != null && getRoom().getMixie().getState() == ON){
			room.setMixieLbl(new JLabel(ON));
			getRoom().getMixieBtn().setActionCommand("Mixie");
			getRoom().getMixieLbl().setForeground(Color.RED);
			showRoomPanel.add(getRoom().getMixieBtn());
			showRoomPanel.add(getRoom().getMixieLbl());
		}else{
			room.setMixie(new Mixie());
			room.setMixieLbl(new JLabel("OFF"));
			getRoom().getMixieBtn().setActionCommand("Mixie");
			getRoom().getMixieLbl().setForeground(Color.GREEN);
			showRoomPanel.add(getRoom().getMixieBtn());
			showRoomPanel.add(getRoom().getMixieLbl());
		}
		
		if(getRoom().getOven() != null && getRoom().getOven().getState() == ON){
			room.setOvenLbl(new JLabel(ON));
			getRoom().getOvenBtn().setActionCommand("Oven");
			getRoom().getOvenLbl().setForeground(Color.RED);
			showRoomPanel.add(getRoom().getOvenBtn());
			showRoomPanel.add(getRoom().getOvenLbl());
		}else{
			room.setOven(new Oven());
			room.setOvenLbl(new JLabel("OFF"));
			getRoom().getOvenBtn().setActionCommand("Oven");
			getRoom().getOvenLbl().setForeground(Color.GREEN);
			showRoomPanel.add(getRoom().getOvenBtn());
			showRoomPanel.add(getRoom().getOvenLbl());
		}
		
		if(getRoom().getTubeLight() != null && getRoom().getTubeLight().getState() == ON){
			room.setTubeLightLbl(new JLabel(ON));
			getRoom().getTubeLightBtn().setActionCommand("TubeLight");
			getRoom().getTubeLightLbl().setForeground(Color.RED);
			showRoomPanel.add(getRoom().getTubeLightBtn());
			showRoomPanel.add(getRoom().getTubeLightLbl());
		}else{
			room.setTubeLight(new TubeLight());
			room.setTubeLightLbl(new JLabel("OFF"));
			getRoom().getTubeLightBtn().setActionCommand("TubeLight");
			getRoom().getTubeLightLbl().setForeground(Color.GREEN);
			showRoomPanel.add(getRoom().getTubeLightBtn());
			showRoomPanel.add(getRoom().getTubeLightLbl());
		}
		
		if(getRoom().getTv() != null && getRoom().getTv().getState() == ON){
			room.setTvLbl(new JLabel(ON));
			getRoom().getTvBtn().setActionCommand("Tv");
			getRoom().getTvLbl().setForeground(Color.RED);
			showRoomPanel.add(getRoom().getTvBtn());
			showRoomPanel.add(getRoom().getTvLbl());
		}else{
			room.setTv(new TV());
			room.setTvLbl(new JLabel("OFF"));
			getRoom().getTvBtn().setActionCommand("TV");
			getRoom().getTvLbl().setForeground(Color.GREEN);
			showRoomPanel.add(getRoom().getTvBtn());
			showRoomPanel.add(getRoom().getTvLbl());
		}
		
		if(getRoom().getWaterHeater() != null && getRoom().getWaterHeater().getState() == ON){
			room.setWhLbl(new JLabel(ON));
			getRoom().getWhBtn().setActionCommand("WH");
			getRoom().getWhLbl().setForeground(Color.RED);
			showRoomPanel.add(getRoom().getWhBtn());
			showRoomPanel.add(getRoom().getWhLbl());
		}else{
			room.setWaterHeater(new WaterHeater());
			room.setWhLbl(new JLabel("OFF"));
			getRoom().getWhBtn().setActionCommand("WH");
			getRoom().getWhLbl().setForeground(Color.GREEN);
			showRoomPanel.add(getRoom().getWhBtn());
			showRoomPanel.add(getRoom().getWhLbl());
		}
	}
	

	private class ButtonClickListener implements ActionListener {

		public void actionPerformed(ActionEvent action) {
			String command = action.getActionCommand(); 
			//picLbl.setVisible(true);
			System.out.println("called");
			if( command.equals( "BR" ))  {
				picLbl.setIcon(new ImageIcon(bedroomImg));
				picTxt.setText("Bed Room");
				setClickedRoom("Bed Room");
					showRoomPanel.removeAll();
					setRoom(bedRoom);
					initRooms(room);
			}
			else if( command.equals( "HL" ) )  {
				picLbl.setIcon(new ImageIcon(hallImg));
				picTxt.setText("Living Room");
				setClickedRoom("Living Room");
					showRoomPanel.removeAll();
					setRoom(hall);
					initRooms(getRoom());
			}else if( command.equals( "KT" ) )  {
				picLbl.setIcon(new ImageIcon(kitchenImg));
				picTxt.setText("Kitchen");
				showRoomPanel.removeAll();
				setRoom(kitchen);
				initRooms(getRoom());
			}else if( command.equals( "SR" ) )  {
				picLbl.setIcon(new ImageIcon(studyRoomImg));
				picTxt.setText("Study Room");
				showRoomPanel.removeAll();
				setRoom(studyRoom);
				initRooms(getRoom());
			}
			else if( command.equals( "WR" ) )  {
				picLbl.setIcon(new ImageIcon(washroomImg));
				picTxt.setText("Wash Room");
				showRoomPanel.removeAll();
				setRoom(washRoom);
				initRooms(getRoom());
			}
		}		
	}
}
