public class Monitor 
{
	private Dispatch911 dispatch;
	private int clientID;
	private NewsFeed newsFeed;
	private ClientDB clientDB;
	private HomeAlarm homeAlarm;
	public Monitor()
	{
		dispatch = new Dispatch911();
		newsFeed = new NewsFeed();
		clientDB = new ClientDB();
	}
	
	public void createNewUser(Message info)
	{
		clientID = clientDB.signup(info);
	}

	public int signIn(Message info){
		return clientDB.signin(info);
	}

	public void purchaseAlarmPackage(Message info){
		homeAlarm = new HomeAlarm(info);
	}
	public void getNews()
	{
		newsFeed.displayNews();
	}

	public int[] emergency(Message emerg)
	{
		return dispatch.emergencyServices(clientDB.getCustomerAddress(clientID), emerg.get("scenario"));
	}

	public int[] Stimulate(Message info){
		if(info.get("scenario").equals("Fire")){
			homeAlarm.stimulateFire();
		}
		else if(info.get("scenario").equals("Hospital")){
			homeAlarm.stimulateCO();
		}
		else{
			if(homeAlarm.getMode() == SysMode.ARM){
				homeAlarm.stimulateRubbery();
			}
		}
		return emergency(info);
	}

}