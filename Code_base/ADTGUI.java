import javax.swing.JFrame;

public class ADTGUI extends JFrame {
    private Monitor adtBackendMonitor;
    ADTGUI(){
        super("JBK ADT Security");
        adtBackendMonitor = new Monitor();

        setSize(375, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Displays all of the forms related to regitering /sign up a new client
    private void showRegister(){
        Register registterPages = new Register(this);
        adtBackendMonitor.createNewUser(registterPages.getinfo());
    }
    
    public static void main(String[] args) {
        ADTGUI gui = new ADTGUI();
        gui.showRegister();
    }
}