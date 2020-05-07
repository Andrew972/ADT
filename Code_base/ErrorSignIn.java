import java.awt.Color;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ErrorSignIn extends SignInPanel 
{
	private JLabel errorLabel = new JLabel("Wrong password or username, please try again");
	private GridBagConstraints panel = new GridBagConstraints();
	
	public ErrorSignIn(JFrame mainFrame)
	{
		super(mainFrame);
		panel.gridx = 1;
		panel.gridy = 0;
		
		errorLabel.setForeground(Color.RED);
		add(errorLabel,panel);
		
	}



}
