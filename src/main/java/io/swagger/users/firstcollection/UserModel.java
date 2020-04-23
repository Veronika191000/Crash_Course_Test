package io.swagger.users.firstcollection;

public class UserModel {
    private String firstName;
    private String lastName;
    private String password;
    private int userStatus;
    private String phone;
    private int id;
    private String email;
    private String username;

    public UserModel(int id, String username, String firstName, String lastName, String email, String password, String  phone, int userStatus) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.userStatus = userStatus;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public int getUserStatus() {
        return userStatus;
    }

    @Override
    public String toString() {
        return
                "{" +
                        " \"id\" : " + id  +
                        ", \"username\" : " +  "\"" + username+ "\""  +
                        ", \"firstName\" : " +  "\"" + firstName+ "\"" +
                        ", \"lastName\" : " +  "\"" + lastName+ "\""+
                        ", \"email\" : " +  "\"" + email+ "\""+
                        ", \"password\" : " +  "\"" + password+ "\""+
                        ", \"phone\" : " +  "\"" + phone+ "\""+
                        ", \"userStatus\" : " + userStatus +
                        "}";
    }
}
