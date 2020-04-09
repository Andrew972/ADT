import java.util.Random;

public class PoliceStation 
{
	private Random randomNumber = new Random();
	
	public PoliceStation()
	{
		
	}
	
	
	int sendEta(String userInfo)
	{
		return randomNumber.nextInt(120-1+1)+1;
	}
}
