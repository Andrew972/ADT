import javax.swing.JFrame;

public class PurchasePackages {
    private Message info;
    private JFrame mainFrame;
    private PurchasePanel getUserChoice;
    private ComponentListener listener;

    
    public PurchasePackages(JFrame mainFrame){
        this.mainFrame = mainFrame;
        setPurchasePanel();
    }

    private void setPurchasePanel(){
        getUserChoice = new PurchasePanel();
        getUserChoice.setListener(new ComponentListener() 
    	{
			public void informationEmitted(Message info) 
			{
				listener.informationEmitted(info);
			}
    	});
        
        
        mainFrame.add(getUserChoice);
        mainFrame.revalidate();
    }

    
    
    public void setListener(ComponentListener l)
	{
	        listener = l;
	}

}