import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmergencyTest {

	private PoliceStation tempStation;
	private Hospital tempHospital;
	private FireStation tempFireStation;
	
	@BeforeEach
	public void initialize() 
	{
		tempStation = new PoliceStation();
		tempHospital = new Hospital();
		tempFireStation = new FireStation();
	}
	
	@Test
	void testPoliceStation() 
	{
		if(tempStation.sendEta("Hello") > 120)
		{
				fail("Not yet implemented");
		}
	}

	@Test
	void testHospital() 
	{
		if(tempHospital.sendEta("Hello") > 120)
		{
				fail("Not yet implemented");
		}
	}

	@Test
	void testFireStation() 
	{
		if(tempFireStation.sendEta("Hello") > 120)
		{
				fail("Not yet implemented");
		}
	}
	

}
