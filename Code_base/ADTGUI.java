import javax.swing.JFrame;

public class ADTGUI extends JFrame {
    private Monitor adtBackendMonitor;
    ADTGUI(){
        super("JBK ADT Security");
        adtBackendMonitor = new Monitor();

        setSize(375, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Displays all of the forms related to regitering /sign up a new client
    private void showRegister(){
        Register registterPages = new Register(this);
        
        registterPages.setListener(new ComponentListener() 
    	{
			public void informationEmitted(Message info) 
			{
				if (info.get("Action").equals("Validate")){
					adtBackendMonitor.validateUsername(info);
				}
				else{
					adtBackendMonitor.createNewUser(info);
					getContentPane().removeAll();
					showSignIn();
				}
			}
    	});
    }
    
    private void showSignIn()
    {
    	SignInPanel tempPanel = new SignInPanel(this);

    	tempPanel.setListener(new ComponentListener() 
    	{
			public void informationEmitted(Message info) 
			{
				if(info.get("Action") == "Register")
				{
					getContentPane().removeAll();
					showRegister();
				}
				
				else if(info.get("Action") == "Dash")
				{
					if(adtBackendMonitor.signIn(info) != -1)
					{
						getContentPane().removeAll();
						showDash();
					}
				
					getContentPane().removeAll();
					showErrorMessage();
				}
			}
    	});
    	
    }

    private void showDash()
    {
    	Dashboard dashBoardView = new Dashboard(this);
    }

    private void showPackages(){
        PurchasePackages packageChoice = new PurchasePackages(this);
        packageChoice.setListener(new ComponentListener(){
            public void informationEmitted(Message info) {
                adtBackendMonitor.purchaseAlarmPackage(info); 
                showDash();         
            }
        });
    }

   private void showErrorMessage()
    {
    	ErrorSignIn errorPanel = new ErrorSignIn(this);
    	errorPanel.setListener(new ComponentListener() 
    	{
			public void informationEmitted(Message info) 
			{
				if(info.get("Action") == "Register")
				{
					getContentPane().removeAll();
					showRegister();
				}
				
				else if(info.get("Action") == "Dash")
				{
					if(adtBackendMonitor.signIn(info) != -1)
					{
						getContentPane().removeAll();
						showDash();
					}
				
					getContentPane().removeAll();
					showErrorMessage();
				}
				
			}
    	});
    }
    
    public static void main(String[] args) {
        ADTGUI gui = new ADTGUI();
		gui.showSignIn();
	}
}