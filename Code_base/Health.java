
public class Health {
    private int age;
    private int  weight;
    private char gender;
    private int height;


    public Health() {
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

    public char getGender() {
        return this.gender;
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

    public Health gender(char gender) {
        this.gender = gender;
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

    public static void main(String[] args) {
        Health me = new Health();
        me.age(23)
            . weight(125)
            .gender('F')
            .height(5);
        System.out.println(me);

    }
}