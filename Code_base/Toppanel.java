import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toppanel extends JButton{
    private JButton button;
    private ImageIcon ArmImage, DisarmImage;
    private boolean isArmed = false;
    private ComponentListener listener;
    public Toppanel(){
        super();
        setSize(375,150);
        //setPreferredSize(new Dimension(375,200));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.black));
        
        ArmImage = new ImageIcon("C:\\Users\\Nobody\\Desktop\\cs401\\ADT\\images\\arm.png");
        DisarmImage = new ImageIcon("C:\\Users\\Nobody\\Desktop\\cs401\\ADT\\images\\disarm.png");
        
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
        setIcon(ArmImage); 
    }
    public void setListener(ComponentListener l){
        listener = l;
    }
    public void setArm(){
        setIcon(ArmImage);
        isArmed = true;
    }
    public void setDisarm(){
        setIcon(DisarmImage);
        isArmed = false;
    }
}