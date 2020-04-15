import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SignIn extends JFrame
{

	private JPanel signUpPanel = new JPanel(new GridBagLayout());
	private JTextField userName = new JTextField("                      ");
	private JTextField passWord = new JTextField("                      ");
	private JLabel user = new JLabel("Enter your username");
	private JLabel pass = new JLabel("Enter your password");
	private GridBagConstraints frame = new GridBagConstraints();
	private GridBagConstraints panel = new GridBagConstraints();
	private JButton register = new JButton("Register");
	
	private ImageIcon image;
	private JLabel tempImage;
	
	public SignIn()
	{
		super();
		image = new ImageIcon("d.jpg");
		Image firstImage = image.getImage();
		Image secondImage = firstImage.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		image = new ImageIcon(secondImage);
		setSize(375,700);
		setLayout(new GridBagLayout());
		signUpPanel.setSize(50, 50);
		panel.gridx = 0;
		panel.gridy = 1;
		signUpPanel.add(user);
		signUpPanel.add(userName);
		panel.gridx = 0;
		panel.gridy = 4;
		signUpPanel.add(pass,panel);
		panel.gridx = 1;
		panel.gridy = 4;
		signUpPanel.add(passWord,panel);
		frame.gridx= 5;
		frame.gridy= 5;
		add(signUpPanel, frame);
		frame.gridx = 5;
		frame.gridy = 7;
		add(register,frame);
		tempImage = new JLabel(image);
		frame.gridx = 5;
		frame.gridy = 3;
		add(tempImage, frame);
		setLocationRelativeTo(null);

	}



	



}
