import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SignInPanel extends JPanel{
	private JTextField userName, passWord;
	private JLabel user, pass, tempImage, errorMessage;
	private JButton register, signIn;
	private ourFont writingFont = new ourFont(14); 
	private GridBagConstraints panel = new GridBagConstraints();
	private Dimension buttonSize = new Dimension(85,20);
	private ComponentListener listener;
	private Message newMessage = new Message();  
	
	public SignInPanel(JFrame mainFrame)
	{
		super();
		setSize(375,700);
		setBackground(Color.white);
		setLayout(new GridBagLayout());

		userName = new JTextField(20);
		passWord = new JTextField(20);

		errorMessage = new JLabel("Wrong password or username, please try again");
		errorMessage.setFont(writingFont);
		errorMessage.setForeground(Color.MAGENTA);

		user = new JLabel("Enter your username");
		user.setFont(writingFont);
		pass = new JLabel("Enter your password");
		pass.setFont(writingFont);
		
		register = new JButton("Register");
		signIn = new JButton("Sign In");
		register.setPreferredSize(buttonSize);
		signIn.setPreferredSize(buttonSize);

		tempImage = new JLabel();
		tempImage.setIcon(new ImageIcon("images/companyLogo.jpg"));
		tempImage.setPreferredSize(new Dimension(200,188));

		
		register.addActionListener(new ActionListener() 
		{
			 public void actionPerformed(ActionEvent e) 
	         {
				 newMessage.addContent("Action", "Register");
				 listener.informationEmitted(newMessage);
	         }
	     });
		
		
		panel.gridx = 1;
		panel.gridy = 0;
		add(tempImage, panel);
		panel.gridx = 1;
		panel.gridy = 1;
		add(user,panel);
		panel.gridx = 1;
		panel.gridy = 2;
		add(userName,panel);
		panel.gridx = 1;
		panel.gridy = 3;
		add(pass,panel);
		panel.gridx = 1;
		panel.gridy = 4;
		add(passWord,panel);
		panel.gridx= 1;
		panel.gridy= 5;
		panel.insets = new Insets(0,-100,0,0);
		add(register, panel);
		panel.gridx= 2;
		panel.gridy= 5;
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
		 
		register.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				newMessage.addContent("Action", "Register");
				listener.informationEmitted(newMessage);
			}
		});
		
		mainFrame.add(this);
		revalidate();
	}

	public void showErrorMessage(){
		errorMessage.setForeground(Color.black);
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