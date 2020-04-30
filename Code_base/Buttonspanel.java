import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.BorderFactory;

public class Buttonspanel extends JPanel {
    public Buttonspanel(){
        super();
        setSize(375,100);
        setPreferredSize(new Dimension(375,100));
        setBackground(Color.BLUE);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }
}