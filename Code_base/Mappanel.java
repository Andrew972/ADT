import java.awt.*;
import javax.swing.*;

public class Mappanel extends JPanel{
    private ImageIcon mapImage;
    private JLabel ETA;
    public Mappanel(){
        super();
        setSize(375,150);
        setPreferredSize(new Dimension(375,150));
        setBackground(Color.WHITE);
        
        mapImage = new ImageIcon("map.png");
        ETA = new JLabel(mapImage);
        add(ETA);
    }
}