import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.BoxLayout;
public class Dashboard extends JPanel {
	private Toppanel top;
	private Middlepanel middle;;
	private Buttonspanel buttBar;
	private ComponentListener listener; 
	private NewsFeed newsFeedInstance;
	private Message scenarioMessage;
	private JLabel noEmergency;

	public Dashboard(JFrame mainFrame) {
		super();
		setSize(375,700);
		setBackground(Color.WHITE); 
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		NewsFeed newsFeed = new NewsFeed();
		newsFeedInstance = newsFeed.getInstance();
		noEmergency = new JLabel("No emergency to report");
		noEmergency.setForeground(Color.WHITE);
		top = new Toppanel();
		top.setUpArmDisarmView();
		middle = new Middlepanel();
		buttBar = new Buttonspanel();

		add(top);
		//add(noEmergency);
		add(middle);
		add(buttBar);
		
		top.setListener(new ComponentListener(){
			public void informationEmitted(Message info) {
				listener.informationEmitted(info);
			}
		});

		middle.setListener(new ComponentListener()
		{
			public void informationEmitted(Message info) 
			{
				scenarioMessage = new Message();
				scenarioMessage = info;
				System.out.println("In dashboard " + info.get("scenario"));
			}
		});

		buttBar.setListener(new ComponentListener(){
			public void informationEmitted(Message info) { 
				if(info.get("Action").equals("Sos"))
				{
					if(scenarioMessage != null)
					{
						noEmergency.setForeground(Color.WHITE);
						listener.informationEmitted(scenarioMessage);
					}
					
					else
					{
						noEmergency.setForeground(Color.RED);
					}
				
				}
				else if(info.get("Action").equals("Dash")){
					middle.SetSensorPanel();
					top.setUpArmDisarmView();
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

	public void setSos(int[] etas)
	{
		top.setUpSOSView();
		middle.SetSosPanel(etas);
	}
}