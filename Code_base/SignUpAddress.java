import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.FlowLayout;

public class SignUpAddress extends JPanel {
    //6301 Shellmound st APT 500 Emeryville CA 94608
    
	private JTextField streetName;
    private JTextField streetNumber;
    private JTextField apt;
    private JTextField city;
    private JTextField state;
    private JTextField zipCode;

    private JButton nextButton;
    
    private ComponentListener listener;

    public SignUpAddress(){
        super();
        nextButton = new JButton("Next");
        setSize(375,700);
        setLayout(new FlowLayout());

        streetNumber = new JTextField("Enter street number",20);
        streetName = new JTextField("Enter street name", 20);
        apt = new JTextField("Enter apt number or NA",20);
        city = new JTextField("Enter city",20);
        state = new JTextField("CA",2);
        zipCode = new JTextField("zip",5);
        
        add(streetNumber);
        add(streetName);
        add(apt);
        add(city);
        add(state);
        add(zipCode);

        add(nextButton);
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Message info = new Message();
                info.addContent("number", streetNumber.getText().toLowerCase());
                info.addContent("name", streetName.getText());
                info.addContent("apt", apt.getText().toLowerCase());
                info.addContent("city", city.getText());
                info.addContent("state", state.getText().toLowerCase());
                info.addContent("zip", zipCode.getText());

                listener.informationEmitted(info);
            }
        });
    }

    public void setListener(ComponentListener l){
        listener = l;
    }

}