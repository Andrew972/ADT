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
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea ;
import javax.swing.border.Border;

public class Middlepanel extends JPanel
{
	private JButton lockDoorButton,scenarioButton;
	private Dimension imgSize= new Dimension(70,70);
	private ImageIcon lockImage,sensorImage,scenarioImage;
	private JPanel lockDoorStatusPanel,lockWindowStatusPanel,smokeAlarmStatusPanel,coDetectorStatusPanel;
	private ComponentListener listener;
	private GridBagConstraints panel = new GridBagConstraints();
	private Border blackline = BorderFactory.createLineBorder(Color.black);
	private Message newMessage;
	private JComboBox scenariosList;
	private ourFont writingFont = new ourFont(14);
	private JTextArea articleBody;
	private SosPanel middleSosPanel;
	
	public Middlepanel()
	{
		super(); 
		setLayout(new GridBagLayout());
		setBackground(Color.white);
		panel.insets = new Insets(5,15,5,5);
		panel.gridx = 6;
		panel.gridy = 12;
		add(CreateLockDoorButton(),panel);
		panel.gridx = 6;
		panel.gridy = 13;
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
				String[] scenarios = {"Fire", "Robbery", "High Carbon Monoxide","Unscessful Arm"}; 
				String[] temp = {};
				scenariosList = new JComboBox(scenarios);
				scenariosList.setSelectedIndex(0);
				JOptionPane jop = new JOptionPane("Please Select A Scenario To Simulate",
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
						 
						 if(message.equals("Fire"))
						 {
							 ResetSensors();
							 newMessage = new Message();
							 newMessage.addContent("scenario", "Fire");
							 listener.informationEmitted(newMessage);
							 SetPanelColor(newMessage);
						 }
			         
						 if(message.equals("High Carbon Monoxide"))
						 {
							 ResetSensors();
							 newMessage = new Message();
							 newMessage.addContent("scenario", "High Carbon Monoxide");
							 listener.informationEmitted(newMessage);
							 SetPanelColor(newMessage);
						 }
			         
						 if(message.equals("Robbery"))
						 {
							 ResetSensors();
							 newMessage = new Message();
							 newMessage.addContent("scenario", "Robbery");
							 listener.informationEmitted(newMessage);
							 SetPanelColor(newMessage);
						 }
			         
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

	private void SetPanelColor(Message info)
	{
		if(info.get("scenario").equals("Fire"))
		{
			smokeAlarmStatusPanel.setBackground(Color.RED);
			return;
		}
	
		else if(info.get("scenario").equals("High Carbon Monoxide"))
		{
			coDetectorStatusPanel.setBackground(Color.RED);
			return;
		}
	
		lockWindowStatusPanel.setBackground(Color.RED);
	
	}

	public void setNewsPanel(News news)
	{
		removeAll();
		setBackground(Color.white);

		articleBody = new JTextArea (20,10);
		articleBody.setText("\n" + news.getTitle() + "\n \n" + news.getBody()+ "\n" + news.getSource());
		articleBody.setFont(writingFont);
		articleBody.setSize(300,400);
		articleBody.setLineWrap(true);
        articleBody.setWrapStyleWord(true);
		articleBody.setPreferredSize(new Dimension(300,400)); 
		articleBody.setEditable(false);
		
		add(articleBody);
		repaint();
	}

	public void SetSensorPanel()
	{
		removeAll();
		setLayout(new GridBagLayout());
		setBackground(Color.white);
		panel.insets = new Insets(5,15,5,5);
		panel.gridx = 6;
		panel.gridy = 12;
		add(CreateLockDoorButton(),panel);
		panel.gridx = 6;
		panel.gridy = 13;
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
		repaint();
	}
	
	private void ResetSensors()
	{
		coDetectorStatusPanel.setBackground(Color.GREEN);
		smokeAlarmStatusPanel.setBackground(Color.GREEN);
		lockWindowStatusPanel.setBackground(Color.GREEN);
		lockDoorStatusPanel.setBackground(Color.GREEN);		
	}

	public void SetSosPanel(int[] etas)
	{
		removeAll();
		middleSosPanel = new SosPanel(etas);
		add(middleSosPanel);
		repaint();
		
	}

}