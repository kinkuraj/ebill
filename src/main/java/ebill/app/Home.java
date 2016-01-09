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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import ebill.rooms.BedRoom;
import ebill.rooms.Hall;
import ebill.rooms.Kitchen;
import ebill.rooms.Room;
import ebill.rooms.StudyRoom;
import ebill.rooms.Toilet;
import ebill.util.Tariff;

public class Home {

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

	JPanel billPanel;

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

	public Home() {
		bedRoom = new BedRoom();
		hall = new Hall();
		kitchen = new Kitchen();
		washRoom = new Toilet();
		studyRoom = new StudyRoom();
		prepareGUI();
	}

	private void prepareGUI() {
		mainFrame = new JFrame("My Home");
		mainFrame.setSize(1000, 700);
		mainFrame.setLayout(new GridLayout(1, 2));

		showPanel = new JPanel();
		showPanel.setMinimumSize(new Dimension(300, 600));
		showPanel.setBackground(new Color(222));
		showPanel.setLayout(new BoxLayout(showPanel, BoxLayout.Y_AXIS));

		picPanel = new JPanel();
		picPanel.setMinimumSize(new Dimension(200, 600));
		picPanel.setLayout(new BoxLayout(picPanel, BoxLayout.Y_AXIS));

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				picPanel, showPanel);
		splitPane.setOneTouchExpandable(true);

		picLblPanel = new JPanel();
		picLblPanel.setMinimumSize(new Dimension(300, 200));
		picLblPanel.setLayout(new GridLayout(1, 0));
		showRoomPanel = new JPanel();
		showRoomPanel.setMinimumSize(new Dimension(200, 200));
		showSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, picLblPanel,
				showRoomPanel);
		JButton gBillBtn = new JButton("Get Bill");
		gBillBtn.setActionCommand("Bill");
		gBillBtn.addActionListener(new ButtonClickListener());
		picLblPanel.add(gBillBtn);
		
		JButton getReport = new JButton("Generate Report");
		getReport.setActionCommand("Report");
		getReport.addActionListener(new ButtonClickListener());
		picLblPanel.add(getReport);
		
		showSplitPane.setOneTouchExpandable(true);
		showPanel.add(showSplitPane);
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});

		mainFrame.add(splitPane);
		mainFrame.setVisible(true);
	}

	public void showEventDemo() {

		try {
			bedroomImg = ImageIO.read(new File("src\\resources\\bedroom.jpg"));
			hallImg = ImageIO.read(new File("src\\resources\\hall.jpg"));
			kitchenImg = ImageIO.read(new File("src\\resources\\kitchen.jpg"));
			studyRoomImg = ImageIO.read(new File(
					"src\\resources\\studyRoom.jpg"));
			washroomImg = ImageIO
					.read(new File("src\\resources\\washroom.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		picLbl = new JLabel(new ImageIcon(bedroomImg));
		picTxt = new JLabel("Room Details", JLabel.CENTER);

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

	private class ButtonClickListener implements ActionListener {

		public void actionPerformed(ActionEvent action) {
			String command = action.getActionCommand();
			if (command.equals("BR")) {
				picLbl.setIcon(new ImageIcon(bedroomImg));
				picTxt.setText("Bed Room");
				setClickedRoom("Bed Room");
				showRoomPanel.removeAll();
				showRoomPanel.repaint();
				showRoomPanel.revalidate();

				bedRoom.init(showRoomPanel);

			} else if (command.equals("HL")) {
				picLbl.setIcon(new ImageIcon(hallImg));
				picTxt.setText("Living Room");
				setClickedRoom("Living Room");
				showRoomPanel.removeAll();
				showRoomPanel.repaint();
				showRoomPanel.revalidate();
				hall.init(showRoomPanel);
			} else if (command.equals("KT")) {
				picLbl.setIcon(new ImageIcon(kitchenImg));
				picTxt.setText("Kitchen");
				showRoomPanel.removeAll();
				showRoomPanel.repaint();
				showRoomPanel.revalidate();
				kitchen.init(showRoomPanel);
			} else if (command.equals("SR")) {
				picLbl.setIcon(new ImageIcon(studyRoomImg));
				picTxt.setText("Study Room");
				showRoomPanel.removeAll();
				showRoomPanel.repaint();
				showRoomPanel.revalidate();
				studyRoom.init(showRoomPanel);
			} else if (command.equals("WR")) {
				picLbl.setIcon(new ImageIcon(washroomImg));
				picTxt.setText("Wash Room");
				showRoomPanel.removeAll();
				showRoomPanel.repaint();
				showRoomPanel.revalidate();
				washRoom.init(showRoomPanel);
			} else if (command.equals("Bill")) {
				double totalCons = getBedRoom().getUnits()+getHall().getUnits()+getKitchen().getUnits()+getWashRoom().getUnits()+getStudyRoom().getUnits();
				String message = "My Home: \n Total consumption : "+totalCons+"units\nTotal cost : Rs. "+Tariff.getBill(totalCons)+"/-";
				JOptionPane.showMessageDialog(mainFrame, message, "Consumption Bill",JOptionPane.INFORMATION_MESSAGE);

			}
			else if (command.equals("Report")) {
				String message = "Bed Room:\n Total consumption : "+getBedRoom().getUnits()+" units \nTotal cost : Rs. "+Tariff.getBill(getBedRoom().getUnits())+"/- \nHall:\n Total consumption : "+getHall().getUnits()+" units \nTotal cost : Rs. "+Tariff.getBill(getHall().getUnits())+"/- \nKitchen:\n Total consumption : "+getKitchen().getUnits()+" units \nTotal cost : Rs. "+Tariff.getBill(getKitchen().getUnits())+"/-\nWash Room:\n Total consumption : "+getWashRoom().getUnits()+" units \nTotal cost : Rs. "+Tariff.getBill(getWashRoom().getUnits())+"/-\nStudy Room:\n Total consumption : "+getStudyRoom().getUnits()+" units \nTotal cost : Rs. "+Tariff.getBill(getStudyRoom().getUnits())+"/-";
				JOptionPane.showMessageDialog(mainFrame, message, "Consumption Report",JOptionPane.INFORMATION_MESSAGE);

			}
		}
	}
	
	
}
