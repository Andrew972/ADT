public class Monitor 
{
	private Dispatch911 dispatch;
	private int clientID;
	private NewsFeed newsFeed;
	private ClientDB clientDB;
	public Monitor()
	{
		dispatch = new Dispatch911();
		newsFeed = new NewsFeed();
		clientDB = new ClientDB();
	}
	
	public void createNewUser(Message info)
	{
		clientID = clientDB.signup(info);
	}

	public int signIn(Message info){
		return clientDB.signin(info);
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
