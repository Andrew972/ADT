import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class SosPanel extends JPanel 
{
	private JPanel policePanel;
	private JPanel hospitalPanel;
	private JPanel firePanel;
	private JLabel policeTime;
	private JLabel hospitalTime;
	private JLabel fireTime;
	private GridBagConstraints panel = new GridBagConstraints();
	
	public SosPanel(JFrame mainFrame)
	{
		super();
		setLayout(new GridBagLayout());
		setSize(375,700);
		panel.insets = new Insets(5,130,5,0);
		
		panel.gridx = 60;
		panel.gridy = 8;
		add(createPolicePanel(5),panel);
		panel.gridx = 60;
		panel.gridy = 9;
		add(createHospitalPanel(8),panel);
		panel.gridx = 60;
		panel.gridy = 12;
		add(createFirePanel(10),panel);
		mainFrame.add(this, BorderLayout.WEST);
		mainFrame.setVisible(true);
	}

	private JPanel createPolicePanel(int time)
	{
		Border policeBorder = BorderFactory.createTitledBorder("Police");
		policePanel = new JPanel(new FlowLayout());
		policePanel.setPreferredSize(new Dimension(80,80));
		policePanel.setBorder(policeBorder);
		policeTime = new JLabel(Integer.toString(time));
		policePanel.add(policeTime);
		return policePanel;
		
	}


	private JPanel createHospitalPanel(int time)
	{
		Border hospitalBorder = BorderFactory.createTitledBorder("Ambulance");
		hospitalPanel = new JPanel(new FlowLayout());
		hospitalPanel.setPreferredSize(new Dimension(80,80));
		hospitalPanel.setBorder(hospitalBorder);
		hospitalTime = new JLabel(Integer.toString(time));
		hospitalPanel.add(hospitalTime);
		return hospitalPanel;
		
	}


	private JPanel createFirePanel(int time)
	{
		Border fireBorder = BorderFactory.createTitledBorder("Fire");
		firePanel = new JPanel(new FlowLayout());
		firePanel.setPreferredSize(new Dimension(80,80));
		firePanel.setBorder(fireBorder);
		fireTime = new JLabel(Integer.toString(time));
		firePanel.add(fireTime);
		return firePanel;
		
	}
}
