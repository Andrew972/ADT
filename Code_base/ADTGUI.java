import javax.swing.JFrame;

import jdk.internal.net.http.websocket.MessageEncoder;

public class ADTGUI extends JFrame {

    // a panel that will be attached to the top of the frame
    private SignUpUserPassword getUserPassWord;

    ADTGUI(){
        super("JBK ADT Security");
        setSize(375, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
        getUserPassWord = new SignUpUserPassword();
        add(getUserPassWord);

        getUserPassWord.setListener(new componentListener(){
			public void informationEmitted(MessageEncoder info) {
                //send the info to the monitor
                //being a new panel
                System.out.println("hello from ADTGUI");
            }
        });

       

        setVisible(true);
    }
}