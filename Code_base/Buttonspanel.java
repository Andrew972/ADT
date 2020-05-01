import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.FlowLayout;

public class Buttonspanel extends JPanel {
    private ImageIcon newsImage;
    private JButton newsButton, butt, but;

    public Buttonspanel(){
        super();
        setSize(375,150);
        setPreferredSize(new Dimension(375,125));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.black));
        setLayout(new FlowLayout(FlowLayout.CENTER));

        newsImage = new ImageIcon("C:\\Users\\Nobody\\Desktop\\cs401\\ADT\\images\\news.jpg");
        newsButton = new JButton();
        newsButton.setIcon(newsImage);
        newsButton.setPreferredSize(new Dimension(110,110));

        but= new JButton();
        but.setIcon(newsImage);
        but.setPreferredSize(new Dimension(110,110));

        butt = new JButton();
        butt.setIcon(newsImage);
        butt.setPreferredSize(new Dimension(110,110));

        add(newsButton);
        add(but);
        add(butt);
    }
}