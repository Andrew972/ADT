import java.util.Random;

public class Hospital 
{
	private Random randomNumber = new Random();
	
	public Hospital()
	{
		
	}
	
	int sendEta(String userInfo)
	{
		return randomNumber.nextInt(120-1+1)+1;
	}
}
