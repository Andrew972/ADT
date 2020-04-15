import javax.swing.JFrame;

public class ADTGUI extends JFrame {

    // a panel that will be attached to the top of the frame
    private SignUpUserPassword getUserPassWord;

    ADTGUI(){
        super("JBK ADT Security");
        setSize(375, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
		setLocationRelativeTo(null);
    }
}