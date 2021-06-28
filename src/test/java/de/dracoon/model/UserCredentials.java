package de.dracoon.model;

/**
 * @author priyatham.bolli
 */
public class UserCredentials {

    private String userName;
    private String password;
    private String authType;
    private String token;
    private String state;

    public UserCredentials(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.authType = "basic";
        this.token = "string";
        this.state = "string";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
