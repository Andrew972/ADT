import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ErrorSignIn extends SignInPanel 
{
	private JLabel errorLabel = new JLabel("Wrong password or username, please try again");

	public ErrorSignIn(JFrame mainFrame)
	{
		super(mainFrame);
		errorLabel.setForeground(Color.RED);
		add(errorLabel);
		
	}



}
