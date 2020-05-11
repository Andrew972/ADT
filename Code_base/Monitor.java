public class Monitor 
{
	//private Dispatch911 dispatch;
	private int clientID;
	private ClientDB clientDB;
	private HomeAlarm homeAlarm;
	private Dispatch911 dispatch;
	
	public Monitor()
	{
		dispatch = new Dispatch911();
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

	public boolean validateUsername(Message info){
		return clientDB.isUniqueUsername(info);
	} 

	private int[] emergency(Message emerg)
	{
	
		if(emerg.get("scenario").equals("Fire"))
		{
			return dispatch.emergencyServices(clientDB.getCustomerAddress(clientID), emerg.get("Fire"));
		}
		
		else if(emerg.get("scenario").equals("High Carbon Monoxide"))
		{
			return dispatch.emergencyServices(clientDB.getCustomerAddress(clientID), emerg.get("Ambulance"));

		}
	
		return dispatch.emergencyServices(clientDB.getCustomerAddress(clientID), emerg.get("Police"));
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
	
	public void StimulateUserScenario(Message info){
		if(info.get("scenario").equals("UnsuccessfulArm")){
			homeAlarm.stimulateUnsuccessfulArm();
		}
		else{
			homeAlarm.stimulateSuccessfulArm();
		}
	}

}