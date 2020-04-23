import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Client {
    private final int ID;
    private Name name;
    private HAddress addy;
    private Health specs;
    private UserNamePassword credentials;
    private String phone;
    private String emergencyPhone;
    
    private ArrayList<Integer> householdMembers;

    Scanner scanner = new Scanner(System.in);

   //copy the given things or allow to go through set up?
    public Client() {
        this.ID = generateID();
        householdMembers = new ArrayList<Integer> ();
    }

    public static int generateID(){
        int value = 100;
        return value++;
    }

    public void setUserPass(Message info){
        credentials = new UserNamePassword();
        credentials.userName(info.get("username"))
                .password(info.get("password"));
    }

    public void setAddress(Message info) {
        addy = new HAddress(); 
        addy.streetNumber(info.get("number"))
            .streetName(info.get("name"))
            .apt(info.get("apt"))
            .city(info.get("city"))
            .state(info.get("state"))
            .zipCode(info.get("zip"));
    }

    public void setName(Message info) {
        //System.out.println("Setting personal information...");
        name = new Name();
        name.firstName(info.get("firstName"))
            .lastName(info.get("lastName"));
    }

    public void setSpecs(Message info) {
        //System.out.println("Adding more personal information...");
        specs = new Health();
        
        specs.age(info.get("age"))
            .gender(info.get("gender"))
            .height(info.get("height"))
            .weight(info.get("weight"));
    }

    public Client phone(String phone) {
        this.phone = phone;
        return this;
    }

    public Client emergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
        return this;
    }

    
    public Client addHouseholdMembers(int houseMember) {
        if(! householdMembers.contains(houseMember)){
            householdMembers.add(houseMember);
        }
    
        return this;
    }

    public ArrayList<Integer> getHouseholdMembers() {
        return this.householdMembers;
    }

    public HAddress getAddy() {
        return this.addy;
    }

    public Name getName() {
        return this.name;
    }

    public Health getSpecs() {
        return this.specs;
    }

    public String getPhone() {
        return this.phone;
    }
    public String getPassword(){
        return this.credentials.getPassword();
    }
    public String getUserName(){
        return this.credentials.getUserName();
    }
    public String getEmergencyPhone() {
        return this.emergencyPhone;
    }

    public int getID() {
        return this.ID;
    }

    public String getAddress(){
        return addy.toString();
    }


    @Override
    public String toString() {
        return "address= " + getAddy() + "\n" +
            "name= " + getName() + "\n" +
            "specs= \t" + getSpecs() + "\n" +
            "phone= " + getPhone() + "\n" +
            "emergencyPhone= " + getEmergencyPhone() + "\n" +
            "ID= " + getID();
    }

}