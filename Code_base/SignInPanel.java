

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
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
	private JTextField userName = new JTextField("                                      ");
	private JTextField passWord = new JTextField("                                      ");
	private JLabel user = new JLabel("Enter your username");
	private JLabel pass = new JLabel("Enter your password");
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
		tempImage = new JLabel(image);
		setSize(375,700);
		setLayout(new GridBagLayout());
		ImageIcon image = new ImageIcon("d.jpg");
		Image firstImage = image.getImage();
		Image secondImage = firstImage.getScaledInstance(130, 130, java.awt.Image.SCALE_SMOOTH);
		image = new ImageIcon(secondImage);
		tempImage = new JLabel(image);
		
		register.addActionListener(new ActionListener() 
		{
			 public void actionPerformed(ActionEvent e) 
	         {
				 newMessage.addContent("Action", "Register");
				 listener.informationEmitted(newMessage);
	         }
	     });
		
		signIn.addActionListener(new ActionListener() 
		{
			 public void actionPerformed(ActionEvent e) 
	         {
				 newMessage.addContent("Action", "Sign In");
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
		
		mainFrame.add(this);
		revalidate();
	}

	 public void setListener(ComponentListener l)
	 {
	        listener = l;
	 }

}