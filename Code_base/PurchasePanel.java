import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PurchasePanel extends JPanel {
    private Icon studioImg, apartmentImg, homeImg;
    private Dimension imgSize= new Dimension(250,185);
    private JButton studioChoice, apartmentChoice, homeChoice;
    private JLabel title;
    private ourFont writinFont = new ourFont(18);
    private ComponentListener listener;
    private Message info = new Message();
    public PurchasePanel() {
        super();
        setSize(375, 700);
        title = new JLabel("Which package would you like to install?");
        title.setFont(writinFont);

        studioImg = new ImageIcon("studio.jpg");
        
        studioChoice = new JButton("studio",studioImg);
        studioChoice.setPreferredSize(imgSize);

        apartmentImg = new ImageIcon("apartment.jpg");
        apartmentChoice = new JButton(apartmentImg);
        studioChoice.setPreferredSize(imgSize);

        
        homeImg = new ImageIcon("home.jpg");
        homeChoice = new JButton("home",homeImg);
        homeChoice.setPreferredSize(imgSize);

        add(title);
        add(studioChoice);
        add(apartmentChoice);
        add(homeChoice);

        studioChoice.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	info.addContent("Type", "Studio");
            	listener.informationEmitted(info);

            }
        });
    

        apartmentChoice.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	info.addContent("Type", "Apartment"); 
            	listener.informationEmitted(info);

            }
        });
    
        homeChoice.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	info.addContent("Type", "Home"); 
            	listener.informationEmitted(info);

            }
        });
    
    
    
    }

    public void setListener(ComponentListener l)
	 {
	        listener = l;
	 }


}