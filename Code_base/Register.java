import javax.swing.JFrame;

public class Register {
    private JFrame mainFrame;

    private SignUpUserPassword getUserPassWord;
    private SignUpName getUserName;
    private SignUpAddress getUserAddress;
    private SignUpHealth getUserHealth;
    
    private Monitor adtBackendMonitor = new Monitor();
    private Message signUp = new Message();

    Register(JFrame mainFrame)
    {
        this.mainFrame = mainFrame;
        setUserPassPanel();
    }

    private void setUserPassPanel()
    {
    	mainFrame.getContentPane().removeAll();

    	getUserPassWord = new SignUpUserPassword();
    	mainFrame.add(getUserPassWord);

        getUserPassWord.setListener(new ComponentListener(){
			public void informationEmitted(Message info) {
                //add information to the obj that will eventually get sent back to monitor
                signUp.addOn(info);
                setNamePanel();
            }
        });
        mainFrame.revalidate();
    }
    private void setNamePanel(){
        mainFrame.remove(getUserPassWord);
        getUserName = new SignUpName();
        mainFrame.add(getUserName);

        getUserName.setListener(new ComponentListener(){
			public void informationEmitted(Message info) {
                //add information to the obj that will eventually get sent back to monitor
                signUp.addOn(info);
                setAddressPanel();
            }
        });
        mainFrame.revalidate();
    }

    private void setAddressPanel(){
        mainFrame.remove(getUserName);
        getUserAddress = new SignUpAddress();
        mainFrame.add(getUserAddress);
        getUserAddress.setListener(new ComponentListener(){
			public void informationEmitted(Message info) {
                //add information to the obj that will eventually get sent back to monitor
                signUp.addOn(info);
                setVitalPanel();
            }
        });
        mainFrame.revalidate();
    }

    private void setVitalPanel(){
        mainFrame.remove(getUserAddress);
        getUserHealth = new SignUpHealth();
        mainFrame.add(getUserHealth);
        getUserAddress.setListener(new ComponentListener(){
			public void informationEmitted(Message info) {
                //add information to the obj that will eventually get sent back to monitor
                signUp.addOn(info);
                adtBackendMonitor.createNewUser(signUp);
                setSummaryPanel();
            }
        });
        mainFrame.revalidate();
    }

    private void setSummaryPanel(){
        mainFrame.remove(getUserHealth);
        mainFrame.revalidate();
    }
}