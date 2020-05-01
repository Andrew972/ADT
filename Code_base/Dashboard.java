import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.BoxLayout;
public class Dashboard extends JPanel {
	private Toppanel top;
	private Middlepanel middle;;
	private Buttonspanel buttBar;
	private ComponentListener listener;

	public Dashboard(JFrame mainFrame) {
		super();
		setSize(375,700);
		setBackground(Color.WHITE); 
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		top = new Toppanel();
		middle = new Middlepanel();
		buttBar = new Buttonspanel();

		add(top);
		add(middle);
		add(buttBar);
		
		top.setListener(new ComponentListener(){
			public void informationEmitted(Message info) {
				listener.informationEmitted(info);
			}
		});

		buttBar.setListener(new ComponentListener(){
			public void informationEmitted(Message info) {
				System.out.println("Display " + info.get("Action"));
			}
		});
		mainFrame.add(this);
		mainFrame.revalidate(); 
	}

	public void setListener(ComponentListener l){
        listener = l;
	}
	
	public void setMode(SysMode M){
		if(M == SysMode.ARM) top.setArm();
		if(M == SysMode.DISARM) top.setDisarm();
	}
}