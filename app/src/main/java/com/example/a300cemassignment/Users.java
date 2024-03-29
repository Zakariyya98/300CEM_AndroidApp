package com.example.a300cemassignment;

//This Class allows the Getters and Setters for the Variables to
//be set and in turn allows the UserDatabase and Signup page to
//work together to store data.

public class Users {

    private int userID;
    private String username;
    private String password;

    public Users (int userID, String username, String password) {
        this.userID = userID;
        this.username = username;
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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
}
