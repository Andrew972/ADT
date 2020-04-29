import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class SignUpName extends JPanel {

    private JLabel title,fnameLabel, lnameLabel, heightLabel, weightLabel, genderLabel, ageLabel;
	private JTextField firstName, lastName,height, weight, gender, age;
    private ourFont writingFont;
    private JButton nextButton;
    private GridBagConstraints panel = new GridBagConstraints();
    
    private ComponentListener listener;

    public SignUpName(){
        super();
        setSize(375,700);
        setBackground(new Color(255,255,255));
        setLayout(new GridBagLayout());
        writingFont = new ourFont(14);

        title = new JLabel("We need some personal information");
        title.setFont(writingFont);

        fnameLabel = new JLabel("First name");
        fnameLabel.setFont(writingFont);
        firstName = new JTextField(20);

        lnameLabel = new JLabel("Last name");
        lastName = new JTextField(20);
        lnameLabel.setFont(writingFont);

        heightLabel = new JLabel("Height");
        height = new JTextField(3);
        heightLabel.setFont(writingFont);

        genderLabel = new JLabel("Gender");
        gender = new JTextField(3);
        genderLabel.setFont(writingFont);

        ageLabel = new JLabel("Age");
        age = new JTextField(3);
        ageLabel.setFont(writingFont);

        weightLabel = new JLabel("Weight");
        weight = new JTextField(3);
        weightLabel.setFont(writingFont);

        nextButton = new JButton("Next");
        
        panel.gridx = 3;
        panel.gridy = 4;
        add(title,panel);

        panel.gridx = 3;
        panel.gridy = 5;
        add(fnameLabel,panel);
        panel.gridx = 3;
        panel.gridy = 6;
        add(firstName,panel);
        panel.gridx = 3;
        panel.gridy = 7;
        add(lnameLabel,panel);
        panel.gridx = 3;
        panel.gridy = 8;
        add(lastName,panel);
        panel.gridx = 3;
        panel.gridy = 9;
        add(genderLabel,panel);
        panel.gridx = 3;
        panel.gridy = 10;
        add(gender,panel);
        panel.gridx = 3;
        panel.gridy = 11;
        add(ageLabel,panel);
        panel.gridx = 3;
        panel.gridy = 13;
        add(age,panel);
        panel.gridx = 3;
        panel.gridy = 14;
        add(heightLabel,panel);
        panel.gridx = 3;
        panel.gridy = 15;
        add(height,panel);
        panel.gridx = 3;
        panel.gridy = 17;
        add(weightLabel,panel);
        panel.gridx = 3;
        panel.gridy = 18;
        add(weight,panel);
        panel.gridx = 3;
        panel.gridy = 20;
        add(nextButton,panel);

        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(validateUserInput()){
                    Message info = new Message();
                    info.addContent("firstName", firstName.getText().toLowerCase().trim());
                    info.addContent("lastName", lastName.getText().toLowerCase().trim());
                    info.addContent("gender", gender.getText().toLowerCase().trim()); 
                    info.addContent("age", age.getText().trim()); 
                    info.addContent("weight", weight.getText().trim());
                    info.addContent("height", height.getText().trim()); 
                    listener.informationEmitted(info);
                }
            }
        });
    }

    public void setListener(ComponentListener l){
        listener = l;
    }
    
    private boolean validateUserInput(){
        if(firstName.getText().trim().length() == 0 || lastName.getText().trim().length() == 0){
            return false;
        }
        if(gender.getText().length() != 1){
            return false;
        }
        return validateString(weight.getText()) && validateString(height.getText()) && validateString(age.getText());
    }


    private boolean validateString(String input){
        if (input.trim().matches("[0-9]+") && input.trim().length() >= 2) {
            return true;
        }
        return false;
    }
}