
public class News {
    private String title;
    private String body;
    private String source;

    public News() {
        title = "NA";
    }

    public String getTitle() {
        return this.title;
    }
    
    public String getBody() {
        return this.body;
    }

    public String getSource() {
        return this.source;
    }

    public News title(String title) {
        this.title = title;
        return this;
    }

    public News body(String body) {
        this.body = body;
        return this;
    }

    public News source(String source) {
        this.source = source;
        return this;
    }

    @Override
    public String toString() {
        return "title=" + getTitle() + "\n" +
            "body=" + getBody() + "\n" +
            "source=" + getSource();
    }

}