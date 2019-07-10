package User;

public class User {
    String email;
    int power;

    public User(String email, int power){
        this.email = email;
        this.power = power;
    }

    public String getEmail() {
        return email;
    }

    public int getPower() {
        return power;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
