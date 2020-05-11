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
		info.addContent("password", "a");
		info.addContent("username", "b");
		info.addContent("number","1700");
        info.addContent("name", "Andrew");
        info.addContent("apt", "NA");
        info.addContent("city", "San Leandro");
        info.addContent("state","CA");
        info.addContent("zip", "94578");
        tempMonitor.createNewUser(info);
        info.addContent("package", "studio");
        tempMonitor.purchaseAlarmPackage(info);
	}

	@Test
	public void testSignIn() 
	{
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
	public void testEmergency()
	{
		//tempMonitor.createNewUser(info);
		
		info = new Message();
		info.addContent("scenario", "Fire");
		
		for(int a = 0; a < tempMonitor.Stimulate(info).length; a++)	
		{
			if(tempMonitor.Stimulate(info)[a] > 120)
			{
				fail("Number too high");
			}
		}
		
		info = new Message();
		info.addContent("scenario", "Hospital");
		
		for(int a = 0; a < tempMonitor.Stimulate(info).length; a++)	
		{
			if(tempMonitor.Stimulate(info)[a] > 120)
			{
				fail("Number too high");
			}
		}
		
		info = new Message();
		info.addContent("scenario", "Police");
		
		for(int a = 0; a < tempMonitor.Stimulate(info).length; a++)	
		{
			if(tempMonitor.Stimulate(info)[a] > 120)
			{
				fail("Number too high");
			}
		}
	}

	@Test
	public void testValidate()
	{
		info = new Message();
		info.addContent("username", "f");
		assertTrue(tempMonitor.validateUsername(info));
		info = new Message();
		info.addContent("username", "c");
		assertTrue(tempMonitor.validateUsername(info));
	}
	
}
