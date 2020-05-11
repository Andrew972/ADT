import java.awt.*;
import javax.swing.*;

public class Mappanel extends JPanel
{
    private ImageIcon mapImage;
    private JLabel ETA;
    
    public Mappanel(){
        super();
        setSize(300,200);
        setPreferredSize(new Dimension(200,200));
        setBackground(Color.WHITE);
        
        mapImage = new ImageIcon("map.jpg");
		Image firstImage = mapImage.getImage();
		Image secondImage = firstImage.getScaledInstance(20, 100, java.awt.Image.SCALE_SMOOTH);
		mapImage = new ImageIcon(secondImage);
       
        ETA = new JLabel(mapImage);
        add(ETA);
    }
}