import javax.swing.BorderFactory;
import javax.swing.BoxLayout;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;

public class Middlepanel extends JPanel{
    public Middlepanel(){
		super();
		setSize(375,500);
		setPreferredSize(new Dimension(375,500)); 
		setBackground(Color.LIGHT_GRAY);
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
}