import java.util.HashMap;

public class Message {
    public HashMap<String, String> content;

    public Message(){
        content = new HashMap<String, String>();
    }

    public void addContent(String key, String value){
        content.put(key, value);
    }

    public HashMap<String,String> getContent() {
        return this.content;
    }

    public String get(String key){
        var val = content.get(key);
        if(val != null){
            return val;
        }
        else{
            return "NA";
        }
    }

    public void addOn(Message msg){
        for (String key : msg.content.keySet()) {
            content.put(key, msg.get(key));
        }
    }

	public String toString() { 
        return "NA";
    }
     
}