
public class Driver {

	public static void main(String[] args) 
	{
		FireStation testFire = new FireStation();
		PoliceStation testPolice = new PoliceStation();
		Hospital testHospital = new Hospital();
		Dispatch911 testDispatch = new Dispatch911();
		System.out.println(testFire.sendEta("Hello"));
		System.out.println(testPolice.sendEta("Hello"));
		System.out.println(testHospital.sendEta("Hello"));
		
		
		System.out.println("Fire emergency:");
		for(int a = 0; a < testDispatch.emergencyServices("Hello", "Fire").length; a++)
		{
			if(a == 0)
			{
				System.out.println("Police: " + testDispatch.emergencyServices("Hello", "Fire")[a]);
			}
			
			if(a == 1)
			{
				System.out.println("Fire: " + testDispatch.emergencyServices("Hello", "Fire")[a]);
			}
		
			if(a == 2)
			{
				System.out.println("Hospital: " + testDispatch.emergencyServices("Hello", "Fire")[a]);
			}
		
		}
	
	
		System.out.println("Police emergency:");
		for(int a = 0; a < testDispatch.emergencyServices("Hello", "Police").length; a++)
		{
			if(a == 0)
			{
				System.out.println("Police: " + testDispatch.emergencyServices("Hello", "Police")[a]);
			}
			
			if(a == 1)
			{
				System.out.println("Fire: " + testDispatch.emergencyServices("Hello", "Police")[a]);
			}
		
			if(a == 2)
			{
				System.out.println("Hospital: " + testDispatch.emergencyServices("Hello", "Police")[a]);
			}
		
		}
	
		System.out.println("Hospital emergency:");
		for(int a = 0; a < testDispatch.emergencyServices("Hello", "Hospital").length; a++)
		{
			if(a == 0)
			{
				System.out.println("Police: " + testDispatch.emergencyServices("Hello", "Hospital")[a]);
			}
			
			if(a == 1)
			{
				System.out.println("Fire: " + testDispatch.emergencyServices("Hello", "Hospital")[a]);
			}
		
			if(a == 2)
			{
				System.out.println("Hospital: " + testDispatch.emergencyServices("Hello", "Hospital")[a]);
			}
		
		}
	}

}
