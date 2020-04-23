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


	
	private JButton sensor;
	private JButton logOut;
	private JButton lockDoor;
	private Dimension imgSize= new Dimension(100,100);
	private ImageIcon lockImage;
	private ImageIcon sensorImage;
	private JPanel lockDoorStatusPanel;
	private JPanel lockWindowStatusPanel;
	private JPanel smokeAlarmStatusPanel;
	private JPanel coDetectorStatusPanel;
	private ComponentListener listener;
	
	
	
	private GridBagConstraints panel = new GridBagConstraints();
	private Border blackline = BorderFactory.createLineBorder(Color.black);
	private Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
	private Border loweredbevel = BorderFactory.createLoweredBevelBorder();
	private Border compound = BorderFactory.createCompoundBorder(raisedetched, loweredbevel);
	
	
	public Dashboard(JFrame mainFrame)
	{
		super(); 
		
		setLayout(new GridBagLayout());
		setSize(375,700);
		panel.insets = new Insets(5,30,5,0);
		panel.gridx = 1;
		panel.gridy = 10;
		add(CreateLockDoorButton(),panel);
		panel.gridx = 1;
		panel.gridy = 11;
		add(CreateSensorButton(),panel);
		panel.gridx = 1;
		panel.gridy = 12;
		add(CreateLogOutButton(),panel);
		panel.gridx = 0;
		panel.gridy = 9;
		add(createDoorStatusPanel(),panel);
		panel.gridx = 0;
		panel.gridy = 10;
		add(createWindowStatusPanel(),panel);
		panel.gridx = 0;
		panel.gridy = 11;
		add(createSmokeStatusPanel(),panel);
		panel.gridx = 0;
		panel.gridy = 12;
		add(createCoStatusPanel(),panel);
		
		
		
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
		Image secondImage = firstImage.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
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
		Image secondImage = firstImage.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
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

		logOut = new JButton("Log out");
		
		logOut.addActionListener(new ActionListener() 
		{
			 public void actionPerformed(ActionEvent e) 
	         {
				 listener.informationEmitted(null);
	         }
	     });
		
		
		return logOut;
	}

	public void setListener(ComponentListener l)
	 {
	        listener = l;
	 }

}