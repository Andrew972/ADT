import javax.swing.JFrame;

public class ADTGUI extends JFrame {

    //**** Register Button****
    // panels that will be attached to the top of the frame. 

    ADTGUI(){
        super("JBK ADT Security");
        setSize(375, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Displays all of the forms related to regitering /sign up a new client
    private void showRegister(){
        Register registterPages = new Register(this);
    }
   
    public static void main(String[] args) {
        ADTGUI gui = new ADTGUI();
        gui.showRegister();
    }
}