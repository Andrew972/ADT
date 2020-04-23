import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class ADTGUI extends JFrame {

    //**** Register Button****
    // panels that will be attached to the top of the frame. 

	private Monitor tempMonitor = new Monitor();

	ADTGUI()
    {
        super("JBK ADT Security");
        setSize(375, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Displays all of the forms related to regitering /sign up a new client
    public void showRegister()
    {
    	Register registterPages = new Register(this);
    	
    	registterPages.setListener(new ComponentListener() 
    	{
			public void informationEmitted(Message info) 
			{
				tempMonitor.createNewUser(info);
				getContentPane().removeAll();
				showPurchasePackages();
			}
    	});
   }
   
    public static void main(String[] args) 
    {
        ADTGUI gui = new ADTGUI();
        gui.showSignIn();
    }

    private void showPurchasePackages()
    {
    	PurchasePackages purchase = new PurchasePackages(this);
    	
    	purchase.setListener(new ComponentListener() 
    	{
			public void informationEmitted(Message info) 
			{
				tempMonitor.createNewUser(info);
				getContentPane().removeAll();
				showSignIn();
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
					if(tempMonitor.signIn(info) != -1)
					{
						getContentPane().removeAll();
						showDash();
					}
				
					else
					{
						getContentPane().removeAll();
						showErrorMessage();
					}
				}
				
			}
    	});
    	
    }

    private void showDash()
    {
    	Dashboard dashBoardView = new Dashboard(this);
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
					if(tempMonitor.signIn(info) != -1)
					{
						getContentPane().removeAll();
						showDash();
					}
				
					else
					{
						getContentPane().removeAll();
						showErrorMessage();
					}
				}
				
			}
    	});
    }
}