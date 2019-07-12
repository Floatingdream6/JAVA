package Util;

public class User {

    private String petname;             //昵称
    private String username;
    private String password;
    private int identity;

    public User() {
    }

    public User(String petname,String username, String password,int identity) {
        this.petname = petname;
        this.username = username;
        this.password = password;
        this.identity = identity;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }

    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }
}
