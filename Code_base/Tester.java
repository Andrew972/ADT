import java.util.Scanner;

public class Tester 
{
	public static void main(String[] args) 
	{
		
		Monitor monitor;
		int signIn;
		int [] test = new int[3];
		monitor = new Monitor();
		Scanner userChoices = new Scanner(System.in);
		
		System.out.println("1 for new user, 2 to sign in:");
		signIn = userChoices.nextInt();
		
		if(signIn == 1)
		{
			monitor.getNews();
			//monitor.createNewUser();
			//System.out.println("Sign up successful");
		}
	
		monitor.signIn();
	
	
	
	
		while(signIn != 5)
		{
			System.out.println("What would you like to do? 1 for see news, 2 to check alarm status, 3 to set guard/safe, 4 simulate scenario, 5 exit");
			signIn = userChoices.nextInt();
			
			if(signIn == 1)
			{
				monitor.getNews();
			}
			
		
			if(signIn == 4)
			{
				System.out.println("What would you like simulated? 1 for fire, 2 for police, 3 for hospital");
				signIn = userChoices.nextInt();
				
				if(signIn == 1)
				{
					test = monitor.emergency("Fire");
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
					test = monitor.emergency("Police");
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
						test = monitor.emergency("Hospital");
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

}
