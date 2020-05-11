import java.awt.*; 
import javax.swing.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttonspanel extends JPanel implements ActionListener{
    private ImageIcon newsImage, dashboardImage, sosImage, logoutImage;
    private JButton newsButton, dashboardButton, sosButton, logoutButton;
    private Dimension buttDim;
    private ComponentListener listener;
    private Image firstImage,secondImage;
   
    public Buttonspanel(){
        super();
        setSize(375,150);
        setPreferredSize(new Dimension(375,100));
        setBackground(Color.WHITE);
        setLayout(new FlowLayout(FlowLayout.CENTER));

        buttDim = new Dimension (80,80);

        newsImage = new ImageIcon("news.png");
        newsButton = new JButton();
        firstImage = newsImage.getImage();
		secondImage = firstImage.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		newsImage = new ImageIcon(secondImage);
        newsButton.setIcon(newsImage);
        newsButton.setPreferredSize(buttDim);
        newsButton.setActionCommand("News");
        newsButton.addActionListener(this);

        dashboardButton= new JButton();
        dashboardImage = new ImageIcon("dash.png");
        firstImage = dashboardImage.getImage();
		secondImage = firstImage.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		dashboardImage = new ImageIcon(secondImage);
		dashboardButton.setIcon(dashboardImage);
        dashboardButton.setPreferredSize(buttDim);
        dashboardButton.setActionCommand("Dash");
        dashboardButton.addActionListener(this);

        sosButton = new JButton();
        sosImage = new ImageIcon("sos.png");
        firstImage = sosImage.getImage();
		secondImage = firstImage.getScaledInstance(160, 150, java.awt.Image.SCALE_SMOOTH);
		sosImage = new ImageIcon(secondImage);
        sosButton.setIcon(sosImage);
        sosButton.setPreferredSize(buttDim);
        sosButton.setActionCommand("Sos");
        sosButton.addActionListener(this);

        logoutButton = new JButton();
        logoutImage = new ImageIcon("logout.png");
        firstImage = logoutImage.getImage();
		secondImage = firstImage.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		logoutImage = new ImageIcon(secondImage);
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