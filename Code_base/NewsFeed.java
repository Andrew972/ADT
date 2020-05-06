/*
 * Using singleton design pattern to create only one
 * News DB
 */
import java.util.ArrayList;
import java.util.Random;

public class NewsFeed {
    protected static NewsFeed uniqueInstance = null;
    private static ArrayList<News> articles;
 
	protected NewsFeed() {
    }
 
	public static synchronized NewsFeed getInstance() {
		if (uniqueInstance == null) {
            uniqueInstance = new NewsFeed();
            
            articles = new ArrayList<News>();

            News one = new News();
            one.title("Taxpayers shouldn't have to pay for pandemics. Here's a solution")
                .body("Over the past week, Congress has drafted a similar act for pandemics. It's fair to ask why the government needs to step in at all. But right now the default is that the government pays for everything. Programs like TRIA pass the first costs to the private sector and enable the growth of new insurance solutions to absorb risk. Over time, as insurers adapt to a post Covid-19 reality, just as they did post-9/11, insurers will learn how to take more of the burden on.")
                .source("cnn.com");
            
            News two = new News();
            two.title("A lewd buddy cop comedy in Coffee & Kareem")
                .body("Your enjoyment of the new Netflix comedy Coffee & Kareem may depend on whether or not you find insanely vulgar middle schoolers funny. It's not just cursing either. Oh no, this is a whole symphony of vulgarity that would make Seth Rogen blush.")
                .source("abcnews.com");
            
            News three = new News();
            three.title("Navy Fires Captain of Aircraft Carrier Struck by Coronavirus")
                .body("The public outrage that followed the letter's publication in The San Francisco Chronicle worried sailors and Navy families, Modly said, and made the sea service appear as though it had not responded sooner to the situation on board the aircraft carrier, which is currently docked in Guam as thousands of sailors disembark to enter quarantines. It also could have emboldened adversaires to \"seek advantage\" over the ship, one of the most potent weapons in the U.S. military arsenal, or the region of the Pacific it was supposed to cover.")
                .source("usnews.com");

            articles.add(one);
            articles.add(two);
            articles.add(three);
        }
		return uniqueInstance;
	}
    
    public News displayNews(){
        int index = randomizeStory();
        return articles.get(index);
    }

    private static int randomizeStory(){
        Random rand = new Random(); 
        // Generate random integers in range 0 to number of stories available 
        return rand.nextInt(articles.size());
    }

	
}