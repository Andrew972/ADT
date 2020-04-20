import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.FlowLayout;

public class SignUpName extends JPanel {

    private JLabel fnameLabel;
	private JLabel lnameLabel;
	private JTextField firstName;
    private JTextField lastName;

    private JButton nextButton;
    
    private ComponentListener listener;

    public SignUpName(){
        super();
        nextButton = new JButton("Next");
        setSize(375,700);
        setLayout(new FlowLayout());

        fnameLabel = new JLabel("Enter first name");
        firstName = new JTextField(20);
        lnameLabel = new JLabel("Enter last name");
        lastName = new JTextField(20);
        
        add(fnameLabel);
        add(firstName);
        add(lnameLabel);
        add(lastName);

        add(nextButton);
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Message info = new Message();
                info.addContent("firstName", firstName.getText().toLowerCase());
                
                info.addContent("lastName", lastName.getText());

                listener.informationEmitted(info);
            }
        });
    }

    public void setListener(ComponentListener l){
        listener = l;
    }

}