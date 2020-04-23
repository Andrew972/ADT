import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;


public class Dashboard extends JPanel
{


	
	private JLabel sensorsLabel;
	private JPanel sensorsPanel;
	//Sensors panel
	private JLabel logOutLabel;
	private JPanel logOutPanel;
	//Logout
	private JPanel lockDoorPanel;
	private JLabel lockDoorLabel;
	//lock door
	
	private JPanel lockDoorStatusPanel;
	private JPanel lockWindowStatusPanel;
	private JPanel smokeAlarmStatusPanel;
	private JPanel coDetectorStatusPanel;
	
	
	
	
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
		panel.gridy = 5;
		add(CreateLockDoorPanel(),panel);
		panel.gridx = 1;
		panel.gridy = 8;
		add(CreateSensorsPanel(),panel);
		panel.gridx = 1;
		panel.gridy = 9;
		add(CreateLogOutPanel(),panel);
		panel.gridx = 0;
		panel.gridy = 5;
		add(createDoorStatusPanel(),panel);
		panel.gridx = 0;
		panel.gridy = 8;
		add(createWindowStatusPanel(),panel);
		panel.gridx = 0;
		panel.gridy = 9;
		add(createSmokeStatusPanel(),panel);
		panel.gridx = 0;
		panel.gridy = 10;
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
	
	
	private JPanel CreateLockDoorPanel()
	{
		
		lockDoorPanel = new JPanel(new FlowLayout());
		lockDoorPanel.setBorder(blackline);
		lockDoorPanel.setLayout(new BorderLayout());
		lockDoorPanel.setSize(125, 200);
		lockDoorLabel = new JLabel("<html>Front door/<br/>Window lock</html>",SwingConstants.CENTER);
		lockDoorLabel.setLayout(new FlowLayout());
		lockDoorLabel.setPreferredSize(new Dimension(105, 75));
		lockDoorLabel.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e) 
			{
				ResetPanels();
				lockDoorPanel.setBorder(compound);
			}
		
		
		});
		
		
		lockDoorPanel.add(lockDoorLabel);
		return lockDoorPanel;
		
	}

	private JPanel CreateSensorsPanel()
	{

		sensorsPanel = new JPanel();
		sensorsPanel.setBorder(blackline);
		sensorsPanel.setLayout(new BorderLayout());
		sensorsPanel.setSize(100, 100);
		sensorsLabel = new JLabel("Sensors",SwingConstants.CENTER);
		sensorsLabel.setLayout(new FlowLayout());
		sensorsLabel.setPreferredSize(new Dimension(105, 75));
		sensorsLabel.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e) 
			{
				ResetPanels();
				sensorsLabel.setBorder(compound);
				
			}
			
		
		});
		
		sensorsPanel.add(sensorsLabel);
		return sensorsPanel;
	}

	private JPanel CreateLogOutPanel()
	{

		logOutPanel = new JPanel();
		logOutPanel.setBorder(blackline);
		logOutPanel.setLayout(new BorderLayout());
		logOutPanel.setSize(100, 100);
		logOutLabel = new JLabel("Log Off",SwingConstants.CENTER);
		logOutLabel.setLayout(new FlowLayout());
		logOutLabel.setPreferredSize(new Dimension(105, 75));
		logOutLabel.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e) 
			{
				return;
			}
			
		
		});
		
		logOutPanel.add(logOutLabel);
		return logOutPanel;
	}

	private void ResetPanels()
	{
		logOutPanel.setBorder(blackline);
		sensorsPanel.setBorder(blackline);
		lockDoorPanel.setBorder(blackline);
	}

}