public class Monitor 
{
	private Dispatch911 dispatch;
	private Client client;
	private NewsFeed newsFeed;
	private ClientDB clientDB;
	public Monitor()
	{
		dispatch = new Dispatch911();
		newsFeed = new NewsFeed();
		clientDB = new ClientDB();
	}
	
	public void createNewUser()
	{
		client = clientDB.signup();
		
	}

	public void signIn()
	{
		clientDB.signin();
	}

	public void getNews()
	{
		newsFeed.displayNews();
	}

	public int[] emergency(String emerg)
	{
		return dispatch.emergencyServices("Hello", emerg);
	}

}
