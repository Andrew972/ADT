/**
 * Class to hold addresses of clients 
 */
public class HAddress {
    private String stName;
    private int stNumber;
    private int zip;
    private String apt;
    private String state;

    public HAddress(){
        stNumber = -1;
        stName = "NA";
        apt = "NA";
        state = "NA";
        zip  = -1;
    }

    public HAddress(String stName, int stNumber, int zip, String apt, String state) {
        this.stName = stName;
        this.stNumber = stNumber;
        this.zip = zip;
        this.apt = apt;
        this.state = state;
    }

    public HAddress streetNumber(int num){
        this.stNumber = num;
        return this;
    }

    public HAddress streetName(String name){
        this.stName = name;
        return this;
    }

    public HAddress apt(String apt){
        this.apt = apt;
        return this;
    }

    public HAddress state(String s){
        this.state = s;
        return this;
    }

    public HAddress zipCode(int z){
        this.zip = z;
        return this;
    }

    public String toString(){
        return stNumber + " " + String.valueOf(stName) + " APT " + apt + ", " + state;
    }

    public String getStName() {
        return this.stName;
    }

    public int getStNumber() {
        return this.stNumber;
    }

    public int getZip() {
        return this.zip;
    }

    public String getApt() {
        return this.apt;
    }

    public String getState() {
        return this.state;
    }

}
