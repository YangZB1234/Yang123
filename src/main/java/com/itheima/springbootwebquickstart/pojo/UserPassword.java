package com.itheima.springbootwebquickstart.pojo;

public class UserPassword {
    private String username;
    private String password;
    private String newPassword;

    public UserPassword(String username, String password, String newPassword) {
        this.username = username;
        this.password = password;
        this.newPassword = newPassword;
    }

    public UserPassword() {
    }

    @Override
    public String toString() {
        return "UserPassword{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
