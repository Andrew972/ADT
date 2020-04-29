import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.FlowLayout;

public class SignUpUserPassword extends JPanel {
    private JLabel user,pass, title;
	private JTextField userName, password;
    private JButton nextButton, validateButton;
    private ComponentListener listener;
    private ourFont writingFont = new ourFont(14);
    private boolean isUniqueUserName;

    //needs a photo
    //content needs to be centered in the window, probably BoxLayout works better
	
    public SignUpUserPassword() {
        super();
        setSize(375,700);
        setLayout(new FlowLayout());
        setBackground(new Color(255,255,255));

        isUniqueUserName = false;
        title = new JLabel("Let's set up an account, username must be unique");
        title.setFont(writingFont);

        nextButton = new JButton("Next");
        validateButton = new JButton("Validate user name");

        user = new JLabel("Choose a username");
        user.setFont(writingFont);
        userName = new JTextField(20);
        pass = new JLabel("Choose a password");
        pass.setFont(writingFont);
        password = new JTextField(20);
        
        add(title);
        add(user);
        add(userName);
        add(pass);
        add(password);

        add(nextButton);
        add(validateButton);
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(validateUserInput() ){
                    Message info = new Message();
                    info.addContent("username", userName.getText().toLowerCase().trim());
                    info.addContent("password", password.getText());
    
                    listener.informationEmitted(info);
                }
            }
        });

        validateButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(userName.getText().trim().length() != 0){
                    Message info = new Message();
                    info.addContent("Action", "Validate");
                    info.addContent("username", userName.getText().toLowerCase().trim());
                    listener.informationEmitted(info);

                    validateButton.setBorder(new LineBorder(Color.GREEN));
                }

            }

        });
    }

    public void setListener(ComponentListener l){
        listener = l;
    }
    
    private boolean validateUserInput(){
        if( userName.getText().length() == 0){
            return false;
        }
        if( password.getText().length() == 0){
            return false;
        }
        return true;
    }
}