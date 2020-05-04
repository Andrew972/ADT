
import javax.swing.JFrame;

public class Register {
    private JFrame mainFrame;

    private SignUpUserPassword getUserPassWord;
    private SignUpName getUserName;
    private SignUpAddress getUserAddress;
    private SignUpSummary showSummary;
    private ComponentListener listener;
    private Message signUp = new Message();

    Register(JFrame mainFrame){
        this.mainFrame = mainFrame;
        getUserPassWord = new SignUpUserPassword();
        getUserName = new SignUpName();
        getUserAddress = new SignUpAddress();
        setUserPassPanel();
    }

    private void setUserPassPanel(){
        mainFrame.add(getUserPassWord);

        getUserPassWord.setListener(new ComponentListener(){
			public void informationEmitted(Message info) {
                if(info.get("Action").equals("Validate")){ 
                    listener.informationEmitted(info);
                }
                else{
                    //add information to the obj that will eventually get sent back to monitor
                    signUp.addOn(info);
                    setNamePanel();
                }
            }
        });
        mainFrame.revalidate();
    }
    private void setNamePanel(){
        mainFrame.remove(getUserPassWord); 
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
        showSummary.setListener(new ComponentListener() 
    	{
			public void informationEmitted(Message info) 
			{
                signUp.addOn(info);
				listener.informationEmitted(signUp);
			}
        });
        
        mainFrame.add(showSummary);
        
        mainFrame.revalidate();
    }

    public void useernameIsValid(boolean isValid){
        if(isValid){
            getUserPassWord.setUsernameButtonValid();
        }
        else{
            getUserPassWord.setUsernameButtonInvalid();
        }
    }

    public void setListener(ComponentListener l){
		listener = l;
	}
}
