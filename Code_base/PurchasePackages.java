import javax.swing.JFrame;

public class PurchasePackages {
    private Message info;
    private JFrame mainFrame;
    private PurchasePanel getUserChoice;

    public PurchasePackages(JFrame mainFrame){
        this.mainFrame = mainFrame;
        setPurchasePanel();
    }

    private void setPurchasePanel(){
        getUserChoice = new PurchasePanel();
        mainFrame.add(getUserChoice);
        mainFrame.revalidate();
    }
}