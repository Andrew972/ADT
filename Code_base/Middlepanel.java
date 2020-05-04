import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Middlepanel extends JPanel
{
	private JButton sensorButton,lockDoorButton,scenarioButton;
	private Dimension imgSize= new Dimension(70,70);
	private ImageIcon lockImage,sensorImage,scenarioImage;
	private JPanel lockDoorStatusPanel,lockWindowStatusPanel,smokeAlarmStatusPanel,coDetectorStatusPanel;
	private ComponentListener listener;
	private GridBagConstraints panel = new GridBagConstraints();
	private Border blackline = BorderFactory.createLineBorder(Color.black);
	private Message newMessage;
	private JComboBox scenariosList;
	
	public Middlepanel()
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
		add(CreateScenarioButton(),panel);
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
		lockDoorButton = new JButton(lockImage);
		lockDoorButton.setPreferredSize(imgSize);
		lockDoorButton.addActionListener(new ActionListener() 
		{
			 public void actionPerformed(ActionEvent e) 
	         {
				
	         }
	     });
		return lockDoorButton;
	}

	private JButton CreateSensorButton()
	{
		sensorImage = new ImageIcon("sensor.png");
		Image firstImage = sensorImage.getImage();
		Image secondImage = firstImage.getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH);
		sensorImage = new ImageIcon(secondImage);
		sensorButton = new JButton(sensorImage);
		sensorButton.setPreferredSize(imgSize);
		sensorButton.addActionListener(new ActionListener() 
		{
			 public void actionPerformed(ActionEvent e) 
	         {
				 
	         
	         }
	     });
		return sensorButton;
	}
	
	private JButton CreateScenarioButton() 
	{
		scenarioImage = new ImageIcon("sec1.png");
		Image firstImage = scenarioImage.getImage();
		Image secondImage = firstImage.getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH);
		scenarioImage = new ImageIcon(secondImage);
		scenarioButton = new JButton(scenarioImage);
		scenarioButton.setPreferredSize(imgSize);
		
		scenarioButton.addActionListener(new ActionListener() 
		{
			 public void actionPerformed(ActionEvent e) 
	         {
				String[] scenarios = {"Fire", "Police", "Hospital"}; 
				String[] temp = {};
				scenariosList = new JComboBox(scenarios);
				scenariosList.setSelectedIndex(1);
				JOptionPane jop = new JOptionPane("Please Select",
	            JOptionPane.DEFAULT_OPTION,
	            JOptionPane.YES_NO_OPTION,null,temp);
				jop.add(scenariosList);
				JDialog diag = new JDialog();
				diag.getContentPane().add(jop);
				diag.pack();
				diag.setLocationRelativeTo(null);
				diag.setVisible(true);
				
				scenariosList.addActionListener(new ActionListener() 
				{
					 public void actionPerformed(ActionEvent e) 
			         {
						 String message = (String)scenariosList.getSelectedItem();
						 System.out.println(message);
						 diag.setVisible(false);
			         }
			     });
	         
	         
	         
	         }
	     });
		
		return scenarioButton;
	}
	
	public void setListener(ComponentListener l)
	{
	    listener = l;
	}

}
