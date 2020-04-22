import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Dashboard extends JPanel
{

	private JPanel upperPanel;
	private JPanel mainPanel;
	private JPanel buttonBar;
	private JLabel dashBoard;
	private JLabel news;
	private JLabel sos;
	private JLabel sensorsLabel;
	private JPanel sensorsPanel;
	private JLabel faqLabel;
	private JPanel faqPanel;
	private JLabel logOutLabel;
	private JPanel logOutPanel;
	private JPanel lockDoorPanel;
	private JLabel lockDoorLabel;
	private JFrame mainFrame;
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
		mainPanel = new JPanel(new GridLayout(2,2,25,15));
		mainPanel.setSize(200, 200);
		
		mainPanel.add(CreateLockDoorPanel());
		mainPanel.add(CreateFAQPanel());
		mainPanel.add(CreateSensorsPanel());
		mainPanel.add(CreateLogOutPanel());
		add(mainPanel);
		mainFrame.add(this, BorderLayout.CENTER);
		mainFrame.setVisible(true);
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

	private JPanel CreateFAQPanel()
	{

		faqPanel = new JPanel();
		faqPanel.setBorder(blackline);
		faqPanel.setLayout(new BorderLayout());
		faqPanel.setSize(100, 100);
		faqLabel = new JLabel("FAQ",SwingConstants.CENTER);
		faqLabel.setLayout(new FlowLayout());
		faqLabel.setPreferredSize(new Dimension(105, 75));
		faqLabel.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e) 
			{
				ResetPanels();
				faqPanel.setBorder(compound);
			}
			
		
		});
		
		faqPanel.add(faqLabel);
		return faqPanel;
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
		faqPanel.setBorder(blackline);
		logOutPanel.setBorder(blackline);
		sensorsPanel.setBorder(blackline);
		lockDoorPanel.setBorder(blackline);
	}

}
