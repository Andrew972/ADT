import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SignInPanel extends JPanel
{
	private JTextField userName, passWord;
	private JLabel user, pass, tempImage;
	private JButton register, signIn;
	private JFrame mainFrame;
	private ourFont writingFont = new ourFont(14);
	 
	private GridBagConstraints panel = new GridBagConstraints();
	private ComponentListener listener;
	private Message newMessage = new Message(); 
	
	public SignInPanel(JFrame mainFrame)
	{
		super();
		this.mainFrame = mainFrame;
		setSize(375,700);
		setBackground(new Color(255,255,255,255));
		
		userName = new JTextField(20);
		passWord = new JTextField(20);

		user = new JLabel("Enter your username");
		user.setFont(writingFont);
		pass = new JLabel("Enter your password");
		pass.setFont(writingFont);

		register = new JButton("Register");
		signIn = new JButton("Sign In");

		tempImage = new JLabel();
		tempImage.setIcon(new ImageIcon("C:\\Users\\Nobody\\Desktop\\cs401\\ADT\\images\\companyLogo.jpg"));
		tempImage.setPreferredSize(new Dimension(200,188));
		
		setLayout(new GridBagLayout());
				
		register.addActionListener(new ActionListener() 
		{
			 public void actionPerformed(ActionEvent e) 
	         {
				 newMessage.addContent("Action", "Register");
				 listener.informationEmitted(newMessage);
	         }
	    });
		
		panel.gridx = 0;
		panel.gridy = 2;
		add(user,panel);
		panel.gridx = 0;
		panel.gridy = 3;
		add(userName,panel);
		panel.gridx = 0;
		panel.gridy = 4;
		add(pass,panel);
		panel.gridx = 0;
		panel.gridy = 5;
		add(passWord,panel);
		panel.gridx= 0;
		panel.gridy= 25;
		add(register, panel);
		panel.gridx = 0;
		panel.gridy = 1;
		add(tempImage, panel);
		panel.gridx= 0;
		panel.gridy= 26;
		add(signIn, panel);

		signIn.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) 
	         {
				 if(checkLength())
				 {	
					newMessage.addContent("username", user.getText().trim());
					newMessage.addContent("password", pass.getText().trim());
					newMessage.addContent("Action", "Dash");
					listener.informationEmitted(newMessage);
				 }
				
	         }
	     });
		
		//mainFrame.add(this);
		this.mainFrame.getContentPane().add(this);
		//this.mainFrame.add(this);

		this.mainFrame.revalidate();
	}

	public void setListener(ComponentListener l)
	{
		listener = l;
	}

	private boolean checkLength()
	{
		return userName.getText().trim().length() > 0 && passWord.getText().trim().length() > 0;
	}


}