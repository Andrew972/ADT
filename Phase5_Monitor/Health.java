
public class Health {
    private int age;
    private int  weight;
    private char gender;
    private int height;


    public Health() {
        this.age = -1;
        this. weight =  -1;
        this.gender = 0;
        this.height = -1;
    }

    public Health(int age, int  weight, char gender, int height) {
        this.age = age;
        this. weight =  weight;
        this.gender = gender;
        this.height = height;
    }

    public int getAge() {
        return this.age;
    }

    public int getWeight() {
        return this.weight;
    }

    public String getGender() {
        //convert char to string before returning
        return Character.toString(gender);
    }

  
    public int getHeight() {
        return this.height;
    }

    
    public Health age(int age) {
        this.age = age;
        return this;
    }

    public Health weight(int  weight) {
        this. weight =  weight;
        return this;
    }

    public Health gender(String gender) {
        //convert input to char datatype
        char ch = gender.charAt(0);

        this.gender = ch;
        return this;
    }

    public Health height(int height) {
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
}