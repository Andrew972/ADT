import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JPanel; 
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton; 

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttonspanel extends JPanel implements ActionListener{
    private ImageIcon newsImage, dashboardImage, sosImage, logoutImage;
    private JButton newsButton, dashboardButton, sosButton, logoutButton;
    private Dimension buttDim;
    private ComponentListener listener;

    public Buttonspanel(){
        super();
        setSize(375,150);
        setPreferredSize(new Dimension(375,100));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.black));
        setLayout(new FlowLayout(FlowLayout.CENTER));

        buttDim = new Dimension (80,80);
        newsImage = new ImageIcon("C:\\Users\\Nobody\\Desktop\\cs401\\ADT\\images\\news.png");
        newsButton = new JButton();
        newsButton.setIcon(newsImage);
        newsButton.setPreferredSize(buttDim);
        newsButton.setActionCommand("News");
        newsButton.addActionListener(this);

        dashboardButton= new JButton();
        dashboardImage = new ImageIcon("C:\\Users\\Nobody\\Desktop\\cs401\\ADT\\images\\dash.png");
        dashboardButton.setIcon(dashboardImage);
        dashboardButton.setPreferredSize(buttDim);
        dashboardButton.setActionCommand("Dash");
        dashboardButton.addActionListener(this);

        sosButton = new JButton();
        sosImage = new ImageIcon("C:\\Users\\Nobody\\Desktop\\cs401\\ADT\\images\\sos.png");
        sosButton.setIcon(sosImage);
        sosButton.setPreferredSize(buttDim);
        sosButton.setActionCommand("Sos");
        sosButton.addActionListener(this);

        logoutButton = new JButton();
        logoutImage = new ImageIcon("C:\\Users\\Nobody\\Desktop\\cs401\\ADT\\images\\logout.png");
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