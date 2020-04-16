import javax.swing.JFrame;

public class ADTGUI extends JFrame {

    // a panel that will be attached to the top of the frame
    private SignUpUserPassword getUserPassWord;
    private SignUpName getUserName;
    
    private Monitor adtBackendMonitor = new Monitor();
    private Message signUp = new Message();

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
                //add information to the obj that will eventually get sent back to monitor
                signUp.addOn(info);
                setNamePanel();
            }
        });
        setVisible(true);
    }

    private void setNamePanel(){
        this.remove(getUserPassWord);
        getUserName = new SignUpName();
        add(getUserName);

        getUserName.setListener(new ComponentListener(){
			public void informationEmitted(Message info) {
                //add information to the obj that will eventually get sent back to monitor
                signUp.addOn(info);
                setAddressPanel();
            }
        });

        revalidate();
    }

    private void setAddressPanel(){
        
        System.out.println("Hi from address panel");
        for (String key : signUp.content.keySet()) {
            System.out.println("key: " + key + " value: " + signUp.get(key));
        }
    }
    public static void main(String[] args) {
        ADTGUI gui = new ADTGUI();
    }
}