/**
 * Class to hold addresses of clients 
 */
public class HAddress {
    private String stName;
    private String stNumber;
    private String zip;
    private String apt;
    private String state;

    public HAddress(){
        stNumber = "NA";
        stName = "NA";
        apt = "NA";
        state = "NA";
        zip  = "NA";
    }

    public HAddress streetNumber(String num){
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

    public HAddress zipCode(String z){
        this.zip = z;
        return this;
    }

    public String toString(){
        return stNumber + " " + stName + " APT " + apt + ", " + state;
    }

    public String getStName() {
        return this.stName;
    }

    public String getStNumber() {
        return this.stNumber;
    }

    public String getZip() {
        return this.zip;
    }

    public String getApt() {
        return this.apt;
    }

    public String getState() {
        return this.state;
    }

    public static void main(String[] args) {
        HAddress a = new HAddress();
        a.streetNumber("6301")
            .apt("30A")
            .state("CA");            

        System.err.println(a);
    }
}
