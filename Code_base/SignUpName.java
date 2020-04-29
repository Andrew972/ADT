import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SignUpName extends JPanel {

    private JLabel title,fnameLabel, lnameLabel, heightLabel, weightLabel, genderLabel, ageLabel;
	private JTextField firstName, lastName,height, weight, gender, age;
    private ourFont writingFont;
    private JButton nextButton;
    
    private ComponentListener listener;

    public SignUpName(){
        super();
        setSize(375,700);
        writingFont = new ourFont(14);

        title = new JLabel("Personal information");
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
        
        add(title);

        add(fnameLabel);
        add(firstName);

        add(lnameLabel);
        add(lastName);

        add(genderLabel);
        add(gender);

        add(ageLabel);
        add(age);

        add(heightLabel);
        add(height);

        add(weightLabel);
        add(weight);

        add(nextButton);
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
        if (input.matches("[0-9]+") && input.length() >= 2) {
            return true;
        }
        return false;
    }
}