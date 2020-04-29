import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Color;

public class SignUpAddress extends JPanel {
    //6301 Shellmound st APT 500 Emeryville CA 94608
    
	private JTextField streetName, streetNumber, apt, city, state, zipCode;
    private JLabel nameLabel, numberLabel, aptLabel, cityLabel, stateLabel, zipLabel;
    private ourFont writingFont;
    private JButton nextButton;
    private GridBagConstraints panel = new GridBagConstraints();
    
    private ComponentListener listener;

    public SignUpAddress(){
        super();
        setSize(375,700);
        setBackground(new Color(255,255,255));
        setLayout(new GridBagLayout());
        writingFont = new ourFont(14);
       
        nextButton = new JButton("Next");
        nameLabel = new JLabel("Street name");
        nameLabel.setFont(writingFont);

        numberLabel = new JLabel("Street number");
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
        
        panel.gridx = 3;
        panel.gridy = 4;
        add(numberLabel,panel);
        panel.gridx = 3;
        panel.gridy = 5;
        add(streetNumber,panel);
        panel.gridx = 3;
        panel.gridy = 6;
        add(nameLabel,panel);
        panel.gridx = 3;
        panel.gridy = 7;
        add(streetName,panel);
        panel.gridx = 3;
        panel.gridy = 8;
        add(aptLabel,panel);
        panel.gridx = 3;
        panel.gridy = 9;
        add(apt,panel);
        panel.gridx = 3;
        panel.gridy = 10;
        add(cityLabel,panel);
        panel.gridx = 3;
        panel.gridy = 11;
        add(city,panel);
        panel.gridx = 3;
        panel.gridy = 12;
        add(stateLabel,panel);
        panel.gridx = 3;
        panel.gridy = 13;
        add(state,panel);
        panel.gridx = 3;
        panel.gridy = 14;
        add(zipLabel,panel);
        panel.gridx = 3;
        panel.gridy = 15;
        add(zipCode,panel);
        panel.gridx = 3;
        panel.gridy = 17;
        add(nextButton,panel);

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