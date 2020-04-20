import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.FlowLayout;

public class SignUpUserPassword extends JPanel {
    private JLabel user,pass;
	private JTextField userName, password;
    private JButton nextButton;
    private ComponentListener listener;
    private ourFont writingFont;

    //needs a photo
    //content needs to be centered in the window, probably BoxLayout works better
	
    public SignUpUserPassword() {
        super();
        writingFont = new ourFont(14);
        nextButton = new JButton("Next");
        setSize(375,700);
        setLayout(new FlowLayout());

        user = new JLabel("Choose a username");
        user.setFont(writingFont);
        userName = new JTextField(20);
        pass = new JLabel("Choose a password");
        pass.setFont(writingFont);
        password = new JTextField(20);
        
        add(user);
        add(userName);
        add(pass);
        add(password);

        add(nextButton);
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