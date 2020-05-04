import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JPanel; 
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton; 

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttonspanel extends JPanel implements ActionListener{
    private ImageIcon newsImage, dashboardImage, sosImage, logoutImage;
    private JButton newsButton, dashboardButton, sosButton, logoutButton;
    private Dimension buttDim;
    private ComponentListener listener;
    private Image firstImage;
    private Image secondImage;
    
    public Buttonspanel(){
        super();
        setSize(375,150);
        setPreferredSize(new Dimension(375,100));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.black));
        setLayout(new FlowLayout(FlowLayout.CENTER));

        buttDim = new Dimension (80,80);
        newsImage = new ImageIcon("news.png");
		Image firstImage = newsImage.getImage();
		Image secondImage = firstImage.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
		newsImage = new ImageIcon(secondImage);
        newsButton = new JButton(newsImage);
        newsButton.setIcon(newsImage);
        newsButton.setPreferredSize(buttDim);
        newsButton.setActionCommand("News");
        newsButton.addActionListener(this);

        dashboardButton= new JButton();
        dashboardImage = new ImageIcon("dash.png");
        dashboardButton.setIcon(dashboardImage);
        dashboardButton.setPreferredSize(buttDim);
        dashboardButton.setActionCommand("Dash");
        dashboardButton.addActionListener(this);

        
        sosImage = new ImageIcon("sos.png");
        firstImage = sosImage.getImage();
		secondImage = firstImage.getScaledInstance(160, 90, java.awt.Image.SCALE_SMOOTH);
		sosImage = new ImageIcon(secondImage);
		sosButton = new JButton();
        sosButton.setIcon(sosImage);
        sosButton.setPreferredSize(buttDim);
        sosButton.setActionCommand("Sos");
        sosButton.addActionListener(this);

        
        logoutImage = new ImageIcon("logout.png");
        firstImage = logoutImage.getImage();
        secondImage = firstImage.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
        logoutImage = new ImageIcon(secondImage);
        logoutButton = new JButton();
        logoutButton.setIcon(logoutImage);
        logoutButton.setPreferredSize(buttDim);
        logoutButton.setActionCommand("Logout");
        logoutButton.addActionListener(this);
        
 
		add(dashboardButton);
        add(newsButton);
        add(sosButton);
        add(logoutButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Message info = new Message();
        info.addContent("Action", e.getActionCommand());
        listener.informationEmitted(info);
    }
    public void setListener(ComponentListener l)
	{
		listener = l;
	}

}