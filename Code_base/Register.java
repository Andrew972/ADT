import javax.swing.JFrame;

public class Register {
    private JFrame mainFrame;

    private SignUpUserPassword getUserPassWord;
    private SignUpName getUserName;
    private SignUpAddress getUserAddress;
    private SignUpSummary showSummary;
    
    private Message signUp = new Message();

    Register(JFrame mainFrame){
        this.mainFrame = mainFrame;
        setUserPassPanel();
    }

    private void setUserPassPanel(){
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
                setSummaryPanel();
            }
        });
        mainFrame.revalidate();
    }

    private void setSummaryPanel(){
        mainFrame.remove(getUserAddress);
        showSummary = new SignUpSummary(signUp);
        mainFrame.add(showSummary);
        
        mainFrame.revalidate();
    }

    public Message getinfo(){
        return signUp;
    }
}