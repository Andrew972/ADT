import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toppanel extends JButton{
    private ImageIcon ArmImage, DisarmImage;
    private boolean isArmed = false;
    private ComponentListener listener;
    public Toppanel(){
        super();
        //setSize(375,150);
        //setPreferredSize(new Dimension(375,150));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.black));
        
        ArmImage = new ImageIcon("C:\\Users\\Nobody\\Desktop\\cs401\\ADT\\images\\arm.png");
        DisarmImage = new ImageIcon("C:\\Users\\Nobody\\Desktop\\cs401\\ADT\\images\\disarm.png");
        setDisarm();

        addActionListener(new ActionListener(){
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
        System.out.println("Set TOP listener");
    }
    public void setArm(){
        setIcon(ArmImage);
        isArmed = true;
    }
    public void setDisarm(){
        setIcon(DisarmImage);
        isArmed = false;
    }
    public static void main(String[] args) {
        Toppanel t = new Toppanel();
        JFrame j = new JFrame();
        j.add(t);
        j.pack();
        j.setVisible(true);
    }
}