package com.kwisniewski.projekt.Models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
    @NotNull(message = "ID is required")
    private int id;

    @NotNull(message = "First name is required")
    private String first_name;

    @NotNull(message = "Last name is required")
    private String last_name;

    @NotNull(message = "Email is required")
    @Email(message = "This is not valid email")
    private String email;

    @Size(min = 3, message = "Username must be at least 3 characters long")
    @NotNull(message = "Username is required")
    private String username;

    public void setId(int id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public User() {
    }

    public User(int id, String first_name, String last_name, String email, String username) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.username = username;
    }

    @Override
    public String toString() {
        return id+ "," +first_name+ "," +last_name+ "," +email+ "," +username;
    }
}
