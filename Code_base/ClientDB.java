import java.util.ArrayList;

public class ClientDB {
    private ArrayList<Client> clients;
    private int numberOfClients;
    
    public ClientDB() {
        clients = new ArrayList<Client>();
        numberOfClients = 0;
    }

    public int signin(Message info){
        var result = lookUpUserName(info.get("username"));

        if(result != null ){
            if(info.get("password").equals(result.getPassword())){
                return result.getID();
            }
            else{
                return -1;
            }
        }
        return -1;
    }
    public boolean isUniqueUsername(Message info){
        return lookUpUserName(info.get("username")) == null;
    }

    private Client lookUpUserName(String username){
        for( int i = 0; i < clients.size(); i++){
            if( username.equals(clients.get(i).getUserName())){
                return clients.get(i);
            }
        }
        return null;
    }

    public String getCustomerAddress(int memberID){
        for(int i = 0; i < clients.size(); i++){
            if(clients.get(i).getID() == memberID){
                return clients.get(i).getAddress();
            }
        }
        return "NA";
    }
    public int signup(Message info){
        Client newMember = new Client();
        newMember.setName(info);
        newMember.setAddress(info);
        newMember.setUserPass(info);
        newMember.setSpecs(info);
        
        // System.out.println("We also need a phone number from you...");
        // System.out.println("Enter your phone number: ");
        // newMember.phone(phone);
        // System.out.println("In an emergency who should we call: ");
        // newMember.emergencyPhone(phone);
        // System.out.println(newMember);
        clients.add(newMember);
        numberOfClients++;
        
        System.out.println("from ClientDB");
        System.out.println(newMember);
        return newMember.getID();
    }

    public int getNumberOfClients() {
        return this.numberOfClients;
    }

    public String toString() {
        return "numberOfClients= " + getNumberOfClients();
    }

}