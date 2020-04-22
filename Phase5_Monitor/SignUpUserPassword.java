import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SignUpUserPassword extends JPanel 
{
	private JLabel user = new JLabel("Choose a username");
	private JLabel pass = new JLabel("Choose a password");
	private JTextField userName = new JTextField("                      ");
	private JTextField passWord = new JTextField("                      ");
	private JButton next = new JButton("Next");
	private ComponentListener listener;
	private Message info = new Message();

	public SignUpUserPassword()
	{
		super();
		setSize(375,700);
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 1;
		add(user);
		add(userName);
		c.gridx = 0;
		c.gridy = 4;
		add(pass,c);
		c.gridx = 1;
		c.gridy = 4;
		add(passWord,c);
		c.gridx = 1;
		c.gridy = 5;
		add(next,c);
		
		next.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				info.addContent("Username", userName.getText());
				info.addContent("Password", passWord.getText());
				listener.informationEmitted(info);
			}
		
			
		
		});
	}

	
	public void setListener(ComponentListener newListener)
	{
		
		listener = newListener;
	}



}
