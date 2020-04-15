import java.util.ArrayList;
import java.util.Scanner;

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
        setUserPass();
        setAddress();
        setName();
        setSpecs();
        
        phone = "NA";
        emergencyPhone = "NA"; 
        householdMembers = new ArrayList<Integer> ();
    }

    public static int generateID(){
        int value = 100;
        return value++;
    }


    private void setUserPass(UserNamePassword cred){
        
    }
    private void setAddress() {
        System.out.println("Adding address to your account...");
        addy = new HAddress(); // NA object

        int stNumber, zip;
        String stName, apt, state;

        System.out.println("Enter street number:");
        stNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter street name:");
        stName = scanner.nextLine();

        System.out.println("Enter apartment number or NA if none:");
        apt = scanner.nextLine();

        System.out.println("Enter state:");
        state = scanner.nextLine();

        System.out.println("Enter zipcode:");
        zip = scanner.nextInt();
        scanner.nextLine();

        addy.streetNumber(stNumber)
            .streetName(stName)
            .apt(apt)
            .state(state)
            .zipCode(zip);
    }

    private void setName() {
        System.out.println("Setting personal information...");
        name = new Name();

        String fName,lName;
        System.out.println("Enter your first name: ");
        fName = scanner.nextLine();

        System.out.println("Enter your last name: ");
        lName = scanner.nextLine();

        name.firstName(fName)
            .lastName(lName);
    }

    private void setSpecs() {
        System.out.println("Adding more personal information...");
        specs = new Health();
        
        int age, weight, height;  
        String gender;
         
        System.out.println("Enter your age:");
        age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter your weight:");
        weight = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter your height:");
        height = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter your gender:");
        gender = scanner.nextLine();

        specs.age(age)
            .gender(gender)
            .height(height)
            .weight(weight);
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

    public String getEmergencyPhone() {
        return this.emergencyPhone;
    }

    public int getID() {
        return this.ID;
    }

    public String getAddress(){
        return addy.toString();
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    @Override
    public String toString() {
        return "address= " + getAddy() + "\n" +
            "name= " + getName() + "\n" +
            "specs= \t" + getSpecs() + "\n" +
            "phone= " + getPhone() + "\n" +
            "emergencyPhone= " + getEmergencyPhone() + "\n" +
            "ID= " + getID() + "\n" +
            "username= " + getUserName();
    }

}