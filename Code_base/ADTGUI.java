import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class ADTGUI extends JFrame {

    //**** Register Button****
    // panels that will be attached to the top of the frame. 

	private SignInPanel tempPanel; 
	
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
    	//remove(tempPanel);
    	Register registterPages = new Register(this);
    	showSignIn();
    }
   
    public static void main(String[] args) 
    {
        
    	ADTGUI gui = new ADTGUI();
       // gui.showRegister();
        gui.showSignIn();
    	//gui.showDash();
    	
    	
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
				
				else if(info.get("Action") == "Sign In")
				{
					getContentPane().removeAll();
					showDash();
				}
				
			}
    		
    		
    	});
    	
    }

    private void showDash()
    {
    	
    	Dashboard db = new Dashboard(this);
    }
}