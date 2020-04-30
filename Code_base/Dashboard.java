import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.FlowLayout;

public class Dashboard extends JPanel {
	private Toppanel top;
	private Middlepanel middle;;
	private Buttonspanel buttBar;
	private JFrame mainFrame;
	private ComponentListener listener;

	public Dashboard(JFrame mainFrame) {
		super();
		setSize(375,700);
		setBackground(new Color(255, 255, 255, 255)); 
		setLayout(new FlowLayout(FlowLayout.CENTER));

		this.mainFrame = mainFrame;

		top = new Toppanel();
		middle = new Middlepanel();
		buttBar = new Buttonspanel();

		this.mainFrame.add(top);
		this.mainFrame.add(middle);
		this.mainFrame.add(buttBar);

		top.setListener(new ComponentListener(){
			public void informationEmitted(Message info) {
				
				listener.informationEmitted(info);
			}
		});
		this.mainFrame.revalidate();
	}
	public void setListener(ComponentListener l){
        listener = l;
    }
}