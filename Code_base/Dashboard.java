import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.BoxLayout;
public class Dashboard extends JPanel {
	private Toppanel top;
	private Middlepanel middle;;
	private Buttonspanel buttBar;
	private ComponentListener listener; 
	private NewsFeed newsFeedInstance;

	public Dashboard(JFrame mainFrame) {
		super();
		setSize(375,700);
		setBackground(Color.WHITE); 
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		NewsFeed newsFeed = new NewsFeed();
		newsFeedInstance = newsFeed.getInstance();

		top = new Toppanel();
		top.setUpArmDisarmView();
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
				if(info.get("Action").equals("Sos")){
					top.setUpSOSView();
					//middle.setUpETAView();
				}
				else if(info.get("Action").equals("Dash")){
					top.setUpArmDisarmView();
					//middle show the sensors like the default page
				}
				else if(info.get("Action").equals("Logout")){
					listener.informationEmitted(info);
				}
				else{//Actions is News
					middle.setNewsPanel(newsFeed.displayNews());
					top.setUpArmDisarmView();
				}
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