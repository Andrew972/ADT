public class Name{
    private String fName;
    private String lName;
    
    public Name() {
        fName = "NA";
        lName = "NA";
    }

    public Name(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

    public String getFName() {
        return this.fName;
    }

    public String getLName() {
        return this.lName;
    }

    public Name firstName(String fName) {
        this.fName = fName;
        return this;
    }

    public Name lastName(String lName) {
        this.lName = lName;
        return this;
    }

    @Override
    public String toString() {
        return getFName() + " " + getLName();
    }

}