import java.util.HashMap;

public class Message {
    HashMap<String, String> content;

    public Message(){
        content = new HashMap<String, String>();
    }

    public void addContent(String key, String value){
        content.put(key, value);
    }

    public HashMap<String,String> getContent() {
        return this.content;
    }

    public String toString() { return "NA";}
       
}