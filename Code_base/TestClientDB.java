import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestClientDB
{
	private ClientDB testDB;
	private Message info;
	private int memberID;
	
	@BeforeEach
	public void initialize() 
	{
		testDB = new ClientDB();
		info = new Message();
		info.addContent("password", "a");
		info.addContent("username", "b");
		info.addContent("number","1700");
        info.addContent("name", "Andrew");
        info.addContent("apt", "NA");
        info.addContent("city", "San Leandro");
        info.addContent("state","CA");
        info.addContent("zip", "94578");
        memberID = testDB.signup(info);
        
        info = new Message();
        
        info.addContent("username", "b");
        info.addContent("password", "a");
       
        
	}

	@Test
	public void testCustomerAddress()
	{
		Assertions.assertEquals("1700 Andrew APT NA, CA", testDB.getCustomerAddress(memberID));
	}

	@Test
	public void testNumberOfClients()
	{
		assertEquals(1,testDB.getNumberOfClients());
	}

	@Test
	public void testToString()
	{
		Assertions.assertEquals("numberOfClients= 1", testDB.toString());
	}
}
