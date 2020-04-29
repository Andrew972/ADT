import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;


public class Dashboard extends JPanel
{


	
	private JButton sensor,logOut,lockDoor,fireButton,policeButton,hospitalButton,
	dashBoard,sos,news;
	private Dimension imgSize= new Dimension(70,70);
	private ImageIcon lockImage,sensorImage,logOffImage,fireImage,policeImage,hospitalImage;
	private JPanel lockDoorStatusPanel,lockWindowStatusPanel,smokeAlarmStatusPanel,coDetectorStatusPanel;
	private ComponentListener listener;
	private GridBagConstraints panel = new GridBagConstraints();
	private Border blackline = BorderFactory.createLineBorder(Color.black);
	
	public Dashboard(JFrame mainFrame)
	{
		super(); 
		setLayout(new GridBagLayout());
		setSize(375,700);
		panel.insets = new Insets(5,15,5,5);
		panel.gridx = 6;
		panel.gridy = 12;
		add(CreateLockDoorButton(),panel);
		panel.gridx = 6;
		panel.gridy = 13;
		add(CreateSensorButton(),panel);
		panel.gridx = 6;
		panel.gridy = 14;
		add(CreateLogOutButton(),panel);
		panel.gridx = 1;
		panel.gridy = 12;
		add(createDoorStatusPanel(),panel);
		panel.gridx = 10;
		panel.gridy = 12;
		add(createWindowStatusPanel(),panel);
		panel.gridx = 1;
		panel.gridy = 14;
		add(createSmokeStatusPanel(),panel);
		panel.gridx = 10;
		panel.gridy = 14;
		add(createCoStatusPanel(),panel);
		panel.gridx = 9;
		panel.gridy = 12;
		add(CreateFireButton(),panel);
		panel.gridx = 9;
		panel.gridy = 13;
		add(CreatePoliceButton(),panel);
		panel.gridx = 9;
		panel.gridy = 14;
		add(CreateHospitalButton(),panel);
		
		
		mainFrame.add(this, BorderLayout.WEST);
		mainFrame.setVisible(true);
	}

	
	
	private JPanel createCoStatusPanel()
	{
		Border smokeBorder = BorderFactory.createTitledBorder("CO2");
		coDetectorStatusPanel = new JPanel(new FlowLayout());
		coDetectorStatusPanel.setPreferredSize(new Dimension(62,62));
		coDetectorStatusPanel.setBorder(smokeBorder);
		coDetectorStatusPanel.setBackground(Color.GREEN);
		return coDetectorStatusPanel;
	}
	
	private JPanel createSmokeStatusPanel()
	{
		Border smokeBorder = BorderFactory.createTitledBorder("Smoke");
		smokeAlarmStatusPanel = new JPanel(new FlowLayout());
		smokeAlarmStatusPanel.setPreferredSize(new Dimension(62,62));
		smokeAlarmStatusPanel.setBorder(smokeBorder);
		smokeAlarmStatusPanel.setBackground(Color.GREEN);
		return smokeAlarmStatusPanel;
	}
	
	private JPanel createDoorStatusPanel()
	{
		Border doorBorder = BorderFactory.createTitledBorder("Door");
		lockDoorStatusPanel = new JPanel(new FlowLayout());
		lockDoorStatusPanel.setPreferredSize(new Dimension(62,62));
		lockDoorStatusPanel.setBorder(doorBorder);
		lockDoorStatusPanel.setBackground(Color.GREEN);
		return lockDoorStatusPanel;
	
	}
	
	private JPanel createWindowStatusPanel()
	{
		Border windowBorder = BorderFactory.createTitledBorder("Window");
		lockWindowStatusPanel = new JPanel(new FlowLayout());
		lockWindowStatusPanel.setPreferredSize(new Dimension(62,62));
		lockWindowStatusPanel.setBackground(Color.GREEN);
		lockWindowStatusPanel.setBorder(windowBorder);
		return lockWindowStatusPanel;
	}
	
	private JButton CreateLockDoorButton()
	{
		lockImage = new ImageIcon("Lock1.jpg");
		Image firstImage = lockImage.getImage();
		Image secondImage = firstImage.getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH);
		lockImage = new ImageIcon(secondImage);
		lockDoor = new JButton(lockImage);
		lockDoor.setPreferredSize(imgSize);
		lockDoor.addActionListener(new ActionListener() 
		{
			 public void actionPerformed(ActionEvent e) 
	         {
				
	         }
	     });
		return lockDoor;
	}

	private JButton CreateSensorButton()
	{
		sensorImage = new ImageIcon("sensor.png");
		Image firstImage = sensorImage.getImage();
		Image secondImage = firstImage.getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH);
		sensorImage = new ImageIcon(secondImage);
		sensor = new JButton(sensorImage);
		sensor.setPreferredSize(imgSize);
		sensor.addActionListener(new ActionListener() 
		{
			 public void actionPerformed(ActionEvent e) 
	         {
				 
	         
	         }
	     });
		return sensor;
	}

	private JButton CreateLogOutButton()
	{
		logOffImage = new ImageIcon("logout.png");
		Image firstImage = logOffImage.getImage();
		Image secondImage = firstImage.getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH);
		logOffImage = new ImageIcon(secondImage);
		logOut = new JButton(logOffImage);
		logOut.setPreferredSize(imgSize);
		logOut.addActionListener(new ActionListener() 
		{
			 public void actionPerformed(ActionEvent e) 
	         {
				 listener.informationEmitted(null);
	         }
	     });
		return logOut;
	}

	
	private JButton CreateFireButton()
	{
		fireImage = new ImageIcon("fireIcon.jpg");
		Image firstImage = fireImage.getImage();
		Image secondImage = firstImage.getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH);
		fireImage = new ImageIcon(secondImage);
		fireButton = new JButton(fireImage);
		fireButton.setPreferredSize(imgSize);
		fireButton.addActionListener(new ActionListener() 
		{
			 public void actionPerformed(ActionEvent e) 
	         {
				 listener.informationEmitted(null);
	         }
	     });
		return fireButton;
	}
	
	
	private JButton CreatePoliceButton()
	{
		policeImage = new ImageIcon("police.png");
		Image firstImage = policeImage.getImage();
		Image secondImage = firstImage.getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH);
		policeImage = new ImageIcon(secondImage);
		policeButton = new JButton(policeImage);
		policeButton.setPreferredSize(imgSize);
		policeButton.addActionListener(new ActionListener() 
		{
			 public void actionPerformed(ActionEvent e) 
	         {
				 listener.informationEmitted(null);
	         }
	     });
		return policeButton;
	}
	
	private JButton CreateHospitalButton()
	{
		hospitalImage = new ImageIcon("hospital.png");
		Image firstImage = hospitalImage.getImage();
		Image secondImage = firstImage.getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH);
		hospitalImage = new ImageIcon(secondImage);
		hospitalButton = new JButton(hospitalImage);
		hospitalButton.setPreferredSize(imgSize);
		hospitalButton.addActionListener(new ActionListener() 
		{
			 public void actionPerformed(ActionEvent e) 
	         {
				 listener.informationEmitted(null);
	         }
	     });
		return hospitalButton;
	}
	
	public void setListener(ComponentListener l)
	{
	    listener = l;
	}

}