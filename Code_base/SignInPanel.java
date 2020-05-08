

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SignInPanel extends JPanel
{
	private JTextField userName = new JTextField(20);
	private JTextField passWord = new JTextField(20);
	private JLabel user = new JLabel("Enter your username");
	private JLabel pass = new JLabel("Enter your password");
	private JLabel errorMessage = new JLabel("Wrong Password or Username, Please Try Again");
	private GridBagConstraints panel = new GridBagConstraints();
	private JButton register = new JButton("Register");
	private JButton signIn = new JButton("Sign In");
	private ImageIcon image;
	private JLabel tempImage;
	private ComponentListener listener;
	private Message newMessage = new Message(); 
	
	public SignInPanel(JFrame mainFrame)
	{
		super();
		setBackground(Color.WHITE);
		tempImage = new JLabel(image);
		setSize(375,700);
		setLayout(new GridBagLayout());
		ImageIcon image = new ImageIcon("Logo.jpg");
		Image firstImage = image.getImage();
		Image secondImage = firstImage.getScaledInstance(130, 130, java.awt.Image.SCALE_SMOOTH);
		image = new ImageIcon(secondImage);
		tempImage = new JLabel(image);
		errorMessage.setForeground(Color.WHITE);
		
		register.addActionListener(new ActionListener() 
		{
			 public void actionPerformed(ActionEvent e) 
	         {
				 newMessage.addContent("Action", "Register");
				 listener.informationEmitted(newMessage);
	         }
	     });
		
		panel.insets = new Insets(10,0,10,0);
		panel.gridx = 1;
		panel.gridy = 0;
		add(tempImage, panel);
		panel.gridx = 1;
		panel.gridy = 3;
		add(errorMessage,panel);
		panel.insets = new Insets(20,0,0,0);
		panel.gridx = 1;
		panel.gridy = 4;
		add(user,panel);
		panel.insets = new Insets(0,0,0,0);
		panel.gridx = 1;
		panel.gridy = 5;
		add(userName,panel);
		panel.insets = new Insets(20,0,0,0);
		panel.gridx = 1;
		panel.gridy = 6;
		add(pass,panel);
		panel.insets = new Insets(0,0,25,0);
		panel.gridx = 1;
		panel.gridy = 7;
		add(passWord,panel);
		register.setPreferredSize(new Dimension(85,20));
		panel.gridx= 1;
		panel.gridy= 8;
		panel.insets = new Insets(0,-125,0,0);
		add(register, panel);
		panel.gridx= 2;
		panel.gridy= 8;
		signIn.setPreferredSize(new Dimension(85,20));
		add(signIn, panel);

		signIn.addActionListener(new ActionListener() 
		{
			 public void actionPerformed(ActionEvent e) 
	         {
				 if(checkLength())
				 {	
					 	newMessage.addContent("username", userName.getText().trim());
					 	newMessage.addContent("password", passWord.getText().trim());
					 	newMessage.addContent("Action", "Dash");
				 		listener.informationEmitted(newMessage);
				 }
	         }
	     });
		
		mainFrame.add(this);
		revalidate();
	}

	 public void setListener(ComponentListener l)
	 {
		 	listener = l;
	 }

	 private boolean checkLength()
	 {
		 return userName.getText().trim().length() > 0 && passWord.getText().trim().length() > 0;
	 }

	 public void showErrorMessage()
	 {
		 errorMessage.setForeground(Color.RED);
		 repaint();
	 }
}