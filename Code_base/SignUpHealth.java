import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.FlowLayout;

public class SignUpHealth extends JPanel {
    //6301 Shellmound st APT 500 Emeryville CA 94608
    
	private JTextField weight;
    private JTextField height;
    private JTextField age;
    private JTextField gender;

    private JButton nextButton;
    
    private ComponentListener listener;

    public SignUpHealth(){
        super();
        nextButton = new JButton("Next");
        setSize(375,700);
        setLayout(new FlowLayout());

        weight = new JTextField("Average weight",15);
        //can be improved to show feet and inches with 2 drop downs
        height = new JTextField("Height", 15);
        age = new JTextField("Age",4);
        //could be a drop down
        gender = new JTextField("Gender",2);
        
        add(weight);
        add(height);
        add(gender);
        add(age);
        

        add(nextButton);
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Message info = new Message();
                info.addContent("weight", weight.getText().toLowerCase());
                info.addContent("height", height.getText());
                info.addContent("gender", gender.getText().toLowerCase());
                info.addContent("age", age.getText());
               
                listener.informationEmitted(info);
            }
        });
    }

    public void setListener(ComponentListener l){
        listener = l;
    }
}
    
