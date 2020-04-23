import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MonitorTest 
{

	private Monitor tempMonitor;
	private Message info;
	
	@BeforeEach
	public void initialize() 
	{
		tempMonitor = new Monitor();
		info = new Message();
	}
	
	
	
	@Test
	void testSignUp() 
	{
		info.addContent("number","1700");
        info.addContent("name", "Andrew");
        info.addContent("apt", "NA");
        info.addContent("city", "San Leandro");
        info.addContent("state","CA");
        info.addContent("zip", "94578");
        tempMonitor.createNewUser(info);
	}



	@Test
	void testSignIn() 
	{
		info.addContent("password", "a");
		info.addContent("username", "b");
		info.addContent("number","1700");
        info.addContent("name", "Andrew");
        info.addContent("apt", "NA");
        info.addContent("city", "San Leandro");
        info.addContent("state","CA");
        info.addContent("zip", "94578");
        tempMonitor.createNewUser(info);
        info = new Message();
        info.addContent("username", "b");
        info.addContent("password", "a");
        if(tempMonitor.signIn(info) > 100)
        {
        	fail("Not yet implemented");
        }
	}


	@Test
	void testEmergency()
	{
		for(int a = 0; a < tempMonitor.emergency("Police").length; a++)	
		{
			if(tempMonitor.emergency("Police")[a] > 120)
			{
				fail("Not yet implemented");
			}
		}
		
		for(int a = 0; a < tempMonitor.emergency("Hospital").length; a++)	
		{
			if(tempMonitor.emergency("Hospital")[a] > 120)
			{
				fail("Not yet implemented");
			}
		}
		
		for(int a = 0; a < tempMonitor.emergency("Fire").length; a++)	
		{
			if(tempMonitor.emergency("Fire")[a] > 120)
			{
				fail("Not yet implemented");
			}
		}
	}


}
