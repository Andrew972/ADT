
public class UserNamePassword {
    private String userName;
    private String password;

    public UserNamePassword() {
        userName = password = "NA";
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public UserNamePassword userName(String userName) {
        this.userName = userName;
        return this;
    }

    public UserNamePassword password(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return "userName=" + getUserName() + " " +
            "password=" + getPassword();
    }

}