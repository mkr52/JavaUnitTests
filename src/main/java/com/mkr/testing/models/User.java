package com.mkr.testing.models;

public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String id;
//    private String password;
//    private String repeatedPassword;

    public User(String firstName, String lastName, String email, String id
//                String password, String repeatedPassword
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.id = id;
//        this.password = password;
//        this.repeatedPassword = repeatedPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public String getRepeatedPassword() {
//        return repeatedPassword;
//    }


}
