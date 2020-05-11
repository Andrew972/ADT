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
	private Mappanel map;
	private GridBagConstraints panel = new GridBagConstraints();
	
	public SosPanel(int[] etas)
	{
		super();
		setBackground(Color.WHITE);
		setLayout(new GridBagLayout());
		setSize(375,700);
		panel.insets = new Insets(5,5,5,0);
		panel.gridx = 5;
		panel.gridy = 5;
		add(createPolicePanel(etas[0]),panel);
		panel.gridx = 5;
		panel.gridy = 6;
		add(createHospitalPanel(etas[2]),panel);
		panel.gridx = 5;
		panel.gridy = 7;
		add(createFirePanel(etas[1]),panel);
	}
	
	private JPanel createPolicePanel(int time)
	{
		Border policeBorder = BorderFactory.createTitledBorder("Police");
		policePanel = new JPanel(new FlowLayout());
		policePanel.setPreferredSize(new Dimension(80,80));
		policePanel.setBorder(policeBorder);
		policePanel.setBackground(Color.WHITE);
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
		hospitalPanel.setBackground(Color.WHITE);
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
		firePanel.setBackground(Color.WHITE);
		firePanel.add(fireTime);
		return firePanel;
		
	}
}
