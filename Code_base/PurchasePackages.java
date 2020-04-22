import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PurchasePackages extends JPanel{
    private JFrame mainFrame;

    private Icon studioImg, apartmentImg, homeImg;
    private Dimension imgSize = new Dimension(200, 200);
    private JButton studioChoice, apartmentChoice, homeChoice;
    private JLabel title;
    private ourFont writinFont = new ourFont(18);
    private ActionListener choiceListener;
    private ComponentListener listener;

    public PurchasePackages(JFrame mainFrame){
        this.mainFrame = mainFrame;
        setPurchasePanel();
    }

    private void setPurchasePanel(){
        setSize(375, 700);
        mainFrame.getContentPane().removeAll();

        choiceListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Message info = new Message();
                info.addContent("package", ((AbstractButton) e.getSource()).getText());
                info.addContent("rooms", "2");
                listener.informationEmitted(info);
            }
            
        };

        title = new JLabel("Which package would you like to install?");
        title.setFont(writinFont);

        studioImg = new ImageIcon("../images/studio.jpg");
        studioChoice = new JButton("studio",studioImg);
        studioChoice.setPreferredSize(imgSize);
        studioChoice.addActionListener(choiceListener);

        apartmentImg = new ImageIcon("../images/apartment.jpg");
        apartmentChoice = new JButton("apartment",apartmentImg);
        apartmentChoice.setPreferredSize(imgSize);
        apartmentChoice.addActionListener(choiceListener);

        homeImg = new ImageIcon("../images/home.jpg");
        homeChoice = new JButton("home",homeImg);
        homeChoice.setPreferredSize(imgSize);
        homeChoice.addActionListener(choiceListener);

        add(title);
        add(studioChoice);
        add(apartmentChoice);
        add(homeChoice);
        
        mainFrame.add(this);
        mainFrame.revalidate();
    }

    public void setListener(ComponentListener l){
        listener = l;
    }
}