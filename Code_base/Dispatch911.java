import java.util.Arrays;

public class Dispatch911 
{
	private FireStation fs;
	private PoliceStation ps;
	private Hospital hos;
	private int[] services;
	
	public Dispatch911()
	{
		 fs = new FireStation();                
		 ps = new PoliceStation();
		 hos = new Hospital();
		 services = new int[3];
	}
	
	private int callFire(String userInfo)
	{
		return fs.sendEta(userInfo);
	}


	private int callPolice(String userInfo)
	{
		return ps.sendEta(userInfo);
	}

	private int callHospital(String userInfo)
	{
		return hos.sendEta(userInfo);
	}

	public int[] emergencyServices(String userInfo, String emergency)
	{
		Arrays.fill(services,0);
		
		if(emergency.equals("Fire"))
		{
			services[0] = callPolice(userInfo);
			services[1] = callFire(userInfo);
			services[2] = callHospital(userInfo);
			return services;
			
		}
		
		else if(emergency.contentEquals("Ambulance"))
		{

			services[2] = callHospital(userInfo);
			return services;
		}
		
		services[0] = callPolice(userInfo);
		return services;
	}


}
