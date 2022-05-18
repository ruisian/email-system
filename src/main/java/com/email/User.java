package com.email;

import java.util.Date;

public class User {
    private int id;
    private String firstname;
    private String lastname;
    private Date dob;
    private String email;
    private String username;
    private String password;
    private int role_id;

    public class Role {
        private int id;
        private String name;
    }

    public class Address {
        private int id;
        private int user_id;
        private int number;
        private String city;
        private String street;
    }

    public User(int id, String firstname, String lastname, Date dob, String email, String username, String password, int role_id) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role_id = role_id;
    }

    public int getId() {
        return id;
    }


}
