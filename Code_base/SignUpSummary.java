import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpSummary extends JPanel {
    private JLabel title = new JLabel("Here is the informaiton we have");
    private JLabel username = new JLabel("USERNAME:");
    private JLabel pass = new JLabel("PASSWORD:");
    private JLabel address = new JLabel("ADDRESS:");
    private JLabel name = new JLabel("NAME:");
    private ourFont writingFont;
    private JButton submitButton;
    private GridBagConstraints panel = new GridBagConstraints();

    private ComponentListener listener;

    public SignUpSummary(Message info){
        super();
        setSize(375,700);
        setBackground(new Color(255,255,255));
        setLayout(new GridBagLayout());
        writingFont = new ourFont(14);

        name.setFont(writingFont);
        title.setFont(writingFont);
        title.setForeground(new Color(0,204,204,255));
        username.setFont(writingFont);
        pass.setFont(writingFont);
        address.setFont(writingFont);

        submitButton = new JButton("submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Message infor = new Message();
                infor.addContent("Action", "Dash");
                listener.informationEmitted(infor);
            }
        });
        panel.gridx = 3;
        panel.gridy = 4;
        add(title,panel);
        panel.gridx = 3;
        panel.gridy = 5;
        add(username,panel);
        panel.gridx = 3;
        panel.gridy = 6;
        add(new JLabel(info.get("username")),panel);
        panel.gridx = 3;
        panel.gridy = 7;
        add(pass,panel);
        panel.gridx = 3;
        panel.gridy = 8;
        add(new JLabel(info.get("password")),panel);
        panel.gridx = 3;
        panel.gridy = 9;
        add(name,panel);
        panel.gridx = 3;
        panel.gridy = 10;
        add(new JLabel(info.get("firstName")+" " + info.get("lastName")),panel);
        panel.gridx = 3;
        panel.gridy = 11;
        add(address,panel);
        panel.gridx = 3;
        panel.gridy = 12;
        add(new JLabel(info.get("number")+" " + info.get("name")+" "+info.get("city")+" "+info.get("state")+" "+info.get("zip")),panel);
        panel.gridx = 3;
        panel.gridy = 14;
        add(submitButton,panel);
    }

    public void setListener(ComponentListener l)
	 {
	    listener = l;
	 }
}