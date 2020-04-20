import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.FlowLayout;

public class SignUpUserPassword extends JPanel {
    private JLabel user;
	private JLabel pass;
	private JTextField userName;
    private JTextField password;
    private JButton nextButton;
    private ComponentListener listener;

    //needs a photo
    //content needs to be centered in the window, probably BoxLayout works better
	
    public SignUpUserPassword() {
        super();
        nextButton = new JButton("Next");
        setSize(375,700);
        setLayout(new FlowLayout());

        user = new JLabel("Choose a username");
        userName = new JTextField(20);
        pass = new JLabel("Choose a password");
        password = new JTextField(20);
        
        add(user);
        add(userName);
        add(pass);
        add(password);

        add(nextButton);
        
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Message info = new Message();
                info.addContent("username", userName.getText().toLowerCase());
                
                info.addContent("password", password.getText());

                listener.informationEmitted(info);
            }
        });
    }

    public void setListener(ComponentListener l){
        listener = l;
    }
}