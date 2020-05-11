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
        
        registterPages.setListener(new ComponentListener() {
			public void informationEmitted(Message info) 
			{
				if (info.get("Action").equals("Validate")){
					registterPages.useernameIsValid(adtBackendMonitor.validateUsername(info));					
				}
				else{
					adtBackendMonitor.createNewUser(info);
					getContentPane().removeAll();
					showSignIn();
				}
			}
    	});
    }
    
    private void showSignIn(){
    	SignInPanel tempPanel = new SignInPanel(this);

    	tempPanel.setListener(new ComponentListener() {
			public void informationEmitted(Message info){
				if(info.get("Action").equals("Register")){
					getContentPane().removeAll();
					showRegister();
				}
				
				else if(info.get("Action").equals("Dash"))
				{
					System.out.println(adtBackendMonitor.signIn(info));
					if(adtBackendMonitor.signIn(info) != -1)
					{
						getContentPane().removeAll();
						showDash();
					}
					else{
						tempPanel.showErrorMessage();
					}
				}
			}
    	});
    	
    }

    private void showDash()
    {
		Dashboard dashBoardView = new Dashboard(this);
		dashBoardView.setListener(new ComponentListener(){
			public void informationEmitted(Message info) {
				if(info.get("Action").equals("Arm")){
					dashBoardView.setMode(SysMode.ARM);
				}
				else if(info.get("Action").equals("Disarm")){
					dashBoardView.setMode(SysMode.DISARM);
				}
				else if(info.get("Action").equals("Logout")){
					getContentPane().removeAll();
					showSignIn();
				}
				
				else if(info.get("scenario").equals("Fire"))
				{
					dashBoardView.setSos(adtBackendMonitor.Stimulate(info));
				}
			
			
				else if(info.get("scenario").equals("High Carbon Monoxide"))
				{
					dashBoardView.setSos(adtBackendMonitor.Stimulate(info));
				}
			
				else if(info.get("scenario").equals("Robbery"))
				{
					dashBoardView.setSos(adtBackendMonitor.Stimulate(info));
				}
			}
		});
    }

    private void showPurchasePackages(){
        PurchasePackages packageChoice = new PurchasePackages(this);
        packageChoice.setListener(new ComponentListener(){
            public void informationEmitted(Message info) {
				adtBackendMonitor.purchaseAlarmPackage(info); 
				getContentPane().removeAll();
                showSignIn();         
            }
        });
    }

    public static void main(String[] args) {
        ADTGUI gui = new ADTGUI();
		gui.showDash();
	}
}