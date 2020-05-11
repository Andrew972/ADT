import java.awt.*; 
import javax.swing.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toppanel extends JPanel{
    private ImageIcon ArmImage, DisarmImage, mapImage;
    private JLabel map;
    private JButton mode;
    private boolean isArmed = false;
    private ComponentListener listener;
    
    public Toppanel(){
        super();
        setSize(375,150);
        setPreferredSize(new Dimension(375,150));
        setBackground(Color.white); 
        
        ArmImage = new ImageIcon("arm.png");
        DisarmImage = new ImageIcon("disarm.png");
        mapImage = new ImageIcon("map.jpg");
        
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

    public void setUpArmDisarmView(){
        removeAll();
        mode = new JButton();
        mode.setPreferredSize(this.getPreferredSize());
        mode.setSize(375,150);

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

        revalidate();
    }
    public void setUpSOSView(){
        removeAll();
        map = new JLabel();
        map.setSize(getPreferredSize());
        map.setIcon(mapImage);

        add(map);
        revalidate();
    }
}