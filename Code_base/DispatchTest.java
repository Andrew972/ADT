import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class DispatchTest 
{
	private Dispatch911 tempDispatch;
	
	@BeforeEach
	public void initialize() 
	{
		tempDispatch = new Dispatch911();
	}
	
	@Test
	void testCallFire() 
	{
		for(int a = 0; a < tempDispatch.emergencyServices("Hello", "Fire").length; a++)	
		{
			if(tempDispatch.emergencyServices("Hello", "Fire")[a] > 120)
			{
				fail("Not yet implemented");
			}
		}
	}

	@Test
	void testCallPolice() 
	{
		for(int a = 0; a < tempDispatch.emergencyServices("Hello", "Police").length; a++)	
		{
			if(tempDispatch.emergencyServices("Hello", "Fire")[a] > 120)
			{
				fail("Not yet implemented");
			}
		}
	}

	@Test
	void testCallHospital() 
	{
		for(int a = 0; a < tempDispatch.emergencyServices("Hello", "Hospital").length; a++)	
		{
			if(tempDispatch.emergencyServices("Hello", "Hospital")[a] > 120)
			{
				fail("Not yet implemented");
			}
		}
	}


}
