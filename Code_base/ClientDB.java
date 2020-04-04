import java.util.ArrayList;
import java.util.Scanner;

public class ClientDB {
    private ArrayList<Client> clients;
    private int numberOfClients;

    Scanner scanner = new Scanner(System.in);
    
    public ClientDB() {
        clients = new ArrayList<Client>();
        numberOfClients = 0;
    }

    public void signup(){
        Client newMember = new Client();

        System.out.println("We also need a phone number from you...");

        String phone;
        System.out.println("Enter your phone number: ");
        phone = scanner.nextLine();

        newMember.phone(phone);

        System.out.println("In an emergency who should we call: ");
        phone = scanner.nextLine();
        
        newMember.emergencyPhone(phone);

        System.out.println("Here is the informaiton we have...");
        System.out.println(newMember);

        clients.add(newMember);
    }

    public int getNumberOfClients() {
        return this.numberOfClients;
    }

    @Override
    public String toString() {
        return "numberOfClients= " + getNumberOfClients();
    }
    
    public static void main(String[] args) {
        ClientDB me = new ClientDB();
        me.signup();
    }

}