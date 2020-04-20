import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.FlowLayout;

public class SignUpAddress extends JPanel {
    //6301 Shellmound st APT 500 Emeryville CA 94608
    
	private JTextField streetName, streetNumber, apt, city, state, zipCode;
    private JLabel nameLabel, numberLabel, aptLabel, cityLabel, stateLabel, zipLabel;
    private ourFont writingFont;
    private JButton nextButton;
    
    private ComponentListener listener;

    public SignUpAddress(){
        super();
        nextButton = new JButton("Next");
        setSize(375,700);
        setLayout(new FlowLayout());
        writingFont = new ourFont(14);

        nameLabel = new JLabel("Street number");
        nameLabel.setFont(writingFont);

        numberLabel = new JLabel("Street name");
        numberLabel.setFont(writingFont);
        
        aptLabel = new JLabel("Enter apt number or NA");
        aptLabel.setFont(writingFont);

        cityLabel = new JLabel("City");
        cityLabel.setFont(writingFont);

        stateLabel =  new JLabel("State");
        stateLabel.setFont(writingFont);

        zipLabel=  new JLabel("Zipcode");
        zipLabel.setFont(writingFont);
        streetNumber = new JTextField(20);
        streetName = new JTextField(20);
        apt = new JTextField(20);
        city = new JTextField(20);
        state = new JTextField(2);
        zipCode = new JTextField(5);
        
        add(numberLabel);
        add(streetNumber);

        add(nameLabel);
        add(streetName);

        add(aptLabel);
        add(apt);

        add(cityLabel);
        add(city);

        add(stateLabel);
        add(state);

        add(zipLabel);
        add(zipCode);

        add(nextButton);
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
          
                if(validateUserInput()){
                    Message info = new Message();
                    info.addContent("number", streetNumber.getText().toLowerCase().trim());
                    info.addContent("name", streetName.getText().toLowerCase().trim());
                    info.addContent("apt", apt.getText().toLowerCase().trim());
                    info.addContent("city", city.getText().toLowerCase().trim());
                    info.addContent("state", state.getText().toLowerCase().trim());
                    info.addContent("zip", zipCode.getText().trim());

                    listener.informationEmitted(info);
                }
            }
        });
    }

    public void setListener(ComponentListener l){
        listener = l;
    }

    private boolean validateUserInput(){
        if(zipCode.getText().length() != 5 || streetNumber.getText().length() == 0 || 
            streetName.getText().length() == 0 || streetName.getText().length() == 0 || 
            city.getText().length() == 0 || apt.getText().length() == 0 || state.getText().length() != 2){
            return false;
        } 
        return true;
    }
}