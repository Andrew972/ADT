import java.util.Random;

public class EmergencyStation 
{
	private Random randomNumber = new Random();
	
	int sendEta(String userInfo)
	{
		return randomNumber.nextInt(120-1+1)+1;
	}
}
