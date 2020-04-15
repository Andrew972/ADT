import java.util.ArrayList;
import java.util.Scanner;

public class Monitor 
{
	private Dispatch911 dispatch;
	private NewsFeed newsFeed;
	private NewsFeed newsFeed2;
	private ClientDB clientDB;
	private int signIn;
	private int [] test;
	private Scanner userChoices; 
	private HomeAlarm homeAlarm;
	private int customerId;
	private ArrayList<String> sensors = new ArrayList<String>();
	
	public Monitor() 
	{
		userChoices = new Scanner(System.in);
		dispatch = new Dispatch911();
		clientDB = new ClientDB();
		test = new int[3];
	}
	
	public void process()
	{
		for(String temp: sensors)
		{
			System.out.println(temp);
		}
		
		System.out.println("1 for new user, 2 to sign in:");
		signIn = userChoices.nextInt();
		
		if(signIn == 1)
		{
			createNewUser();
			purchasePackage();
			System.out.println("Sign up successful");
		}
	
		signIn();
		
		while(signIn != 5)
		{
			System.out.println("What would you like to do? 1 for see news, 2 to check alarm status, 3 to set guard/safe, 4 simulate scenario, 5 exit");
			signIn = userChoices.nextInt();
			userChoices.nextLine();
			
			if(signIn == 1)
			{
				getNews();
			}
			
			if(signIn == 2)
			{
				homeAlarm.printfilteredList();
			}
			
			
			if(signIn == 3)
			{
				String choice;
				System.out.println("Set to safe or guard?");
				choice = userChoices.nextLine();
				
				if(choice.equals("safe"))
				{
					homeAlarm.setModeSafe();
				}
			
				else
				{
					homeAlarm.setModeGuard();
				}
			
			}
			
			
			
			if(signIn == 4)
			{
				System.out.println("What would you like simulated? 1 for fire, 2 for police, 3 for hospital");
				signIn = userChoices.nextInt();
				
				if(signIn == 1)
				{
					test = emergency("Fire");
					System.out.println("Fire emergency:");
					for(int a = 0; a < test.length; a++)
					{
						if(a == 0)
						{
							System.out.println("Police: " + test[a]);
						}
						
						if(a == 1)
						{
							System.out.println("Fire: " + test[a]);
						}
					
						if(a == 2)
						{
							System.out.println("Hospital: " + test[a]);
						}
					
					}
				
				}
			
				else if(signIn == 2)
				{
					test = emergency("Police");
					System.out.println("Police emergency:");
					for(int a = 0; a < test.length; a++)
					{
						if(a == 0)
						{
							System.out.println("Police: " + test[a]);
						}
						
						if(a == 1)
						{
							System.out.println("Fire: " + test[a]);
						}
					
						if(a == 2)
						{
							System.out.println("Hospital: " + test[a]);
						}
					
					}
				}
				
				else if(signIn == 3)
				{
					test = emergency("Hospital");
					System.out.println("hospital emergency:");
					for(int a = 0; a < test.length; a++)
					{
						if(a == 0)
						{
							System.out.println("Police: " + test[a]);
						}
							
						if(a == 1)
						{
							System.out.println("Fire: " + test[a]);
						}
						
						if(a == 2)
						{
							System.out.println("Hospital: " + test[a]);
						}
					}
				}
			
			}
	
		}
	}
		
	private void createNewUser()
	{
		clientDB.signup();
	}

	private void signIn()
	{
		customerId = clientDB.signin();
	}

	private void getNews()
	{
		newsFeed = new NewsFeed();
		newsFeed2 = newsFeed.getInstance();
		newsFeed2.displayNews();
	}

	private int[] emergency(String emerg)
	{
		return dispatch.emergencyServices(clientDB.getCustomerAddress(customerId),homeAlarm.simulation(emerg));
	}

	private void purchasePackage()
	{
		homeAlarm = new HomeAlarm();
		
	}

}
