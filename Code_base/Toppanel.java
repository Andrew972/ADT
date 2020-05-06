import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toppanel extends JPanel{
    private ImageIcon ArmImage, DisarmImage;
    private JButton mode;
    private boolean isArmed = false;
    private ComponentListener listener;
    
    public Toppanel(){
        super();
        setSize(375,150);
        setPreferredSize(new Dimension(375,150));
        setBackground(Color.white); 
        
        mode = new JButton();
        mode.setPreferredSize(this.getPreferredSize());
        mode.setSize(375,150);

        ArmImage = new ImageIcon("C:\\Users\\Nobody\\Desktop\\cs401\\ADT\\images\\arm.png");
        DisarmImage = new ImageIcon("C:\\Users\\Nobody\\Desktop\\cs401\\ADT\\images\\disarm.png");

        add(mode);
        setDisarm();

        mode.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Message info = new Message();
                if(isArmed){
                    info.addContent("Action", "Disarm"); 
                }
                else{
                    info.addContent("Action", "Arm");
                }
               listener.informationEmitted(info);
            }

        }); 
    }
    public void setListener(ComponentListener l){
        listener = l;
    }
    public void setArm(){
        mode.setIcon(ArmImage);
        isArmed = true;
    }
    public void setDisarm(){
        mode.setIcon(DisarmImage);
        isArmed = false;
    }
}