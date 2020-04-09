import java.util.Random;

public class FireStation 
{
	private Random randomNumber = new Random();
	
	public FireStation()
	{
		
	}
	
	
	int sendEta(String userInfo)
	{
		return randomNumber.nextInt(120-1+1)+1;
	}


}
