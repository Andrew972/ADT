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

    private ComponentListener listener;

    public SignUpSummary(Message info){
        super();
        setSize(375,700);

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
                Message info = new Message();
                info.addContent("Action", "Dash");
                listener.informationEmitted(info);
            }
        });

        add(title);
        add(username);
        add(new JLabel(info.get("username")));
        add(pass);
        add(new JLabel(info.get("password")));
        add(name);
        add(new JLabel(info.get("firstName")+" " + info.get("lastName")));
        add(address);
        add(new JLabel(info.get("number")+" " + info.get("name")+" "+info.get("city")+" "+info.get("state")+" "+info.get("zip")));

        add(submitButton);
    }

    public void setListener(ComponentListener l)
	 {
	    listener = l;
	 }
}