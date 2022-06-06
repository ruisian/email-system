package com.email.Users;

import java.time.LocalDate;

public class User {
    private int id;
    private String firstname;
    private String lastname;
    private LocalDate dob;
    private String email;
    private String username;
    private String password;

    private Role role;
    private Address address;


    public User(int id, String firstname, String lastname, LocalDate dob, String email, String username, String password, Role role) {
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


    public int getId() {
        return id;
    }


    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getUsername() {
        return username;
    }

    public String getLastname() {
        return lastname;
    }

    public Role getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }
}


