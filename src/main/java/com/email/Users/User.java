package com.email.Users;

import java.util.Date;

public class User {
    private int id;
    private String firstname;
    private String lastname;
    private Date dob;
    private String email;
    private String username;
    private String password;

    private role role;
    private Address address;


    public User(int id, String firstname, String lastname, Date dob, String email, String username, String password, role role) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
        // this.address = new Address();
    }

}


