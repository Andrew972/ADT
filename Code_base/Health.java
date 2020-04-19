
public class Health {
    private String age;
    private String  weight;
    private char gender;
    private String height;


    public Health() {
    }


    public String getAge() {
        return this.age;
    }

    public String getWeight() {
        return this.weight;
    }

    public String getGender() {
        //convert char to string before returning
        return Character.toString(gender);
    }

  
    public String getHeight() {
        return this.height;
    }

    
    public Health age(String age) {
        this.age = age;
        return this;
    }

    public Health weight(String  weight) {
        this. weight =  weight;
        return this;
    }

    public Health gender(String gender) {
        //convert input to char datatype
        char ch = gender.charAt(0);

        this.gender = ch;
        return this;
    }

    public Health height(String height) {
        this.height = height;
        return this;
    }

 
    @Override
    public String toString() {
        return "age= " + getAge() + " " +
            ",  weight= " + getWeight() + " " +
            ", gender= " + getGender() + " " +
            ", height= " + getHeight();
    }

    public static void main(String[] args) {
        Health me = new Health();
        me.age("23")
            . weight("125")
            .gender("'F'")
            .height("5");
        System.out.println(me);

    }
}