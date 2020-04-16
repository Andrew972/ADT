import javax.swing.JFrame;

public class ADTGUI extends JFrame {

    // a panel that will be attached to the top of the frame
    private SignUpUserPassword getUserPassWord;
    private Monitor adtBackendMonitor = new Monitor();

    ADTGUI(){
        super("JBK ADT Security");
        setSize(375, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
        getUserPassWord = new SignUpUserPassword();
        add(getUserPassWord);

        getUserPassWord.setListener(new ComponentListener(){
			public void informationEmitted(Message info) {
                //send the info to the monitor
                //being a new panel
                System.out.println("hello from ADTGUI");
                adtBackendMonitor.createNewUser(info);
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        System.out.println("Hi");
        ADTGUI gui = new ADTGUI();
    }
}