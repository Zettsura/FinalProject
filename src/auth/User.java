package auth;

public class User {
    private long userId;
    private String name;
    private String email;
    private String password;
    private long vehicleId;

    public User(){}
    public User(long userId, String name, String email, String password, long vehicleId){
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.vehicleId = vehicleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

}
