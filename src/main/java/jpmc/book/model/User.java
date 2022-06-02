package jpmc.book.model;

public class User {

    private UserType userType;

    private String userName;

    public UserType getUserType() {
        return userType;
    }

    public User userType(UserType userType) {
        this.userType = userType;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public User userName(String userName) {
        this.userName = userName;
        return this;
    }

}
