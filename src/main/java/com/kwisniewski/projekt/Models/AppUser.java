package com.kwisniewski.projekt.Models;

public class AppUser {
    private int id_app;
    private int id_user;

    public void setId_app(int id_app) {
        this.id_app = id_app;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_app() {
        return id_app;
    }

    public int getId_user() {
        return id_user;
    }

    public AppUser() {
    }

    public AppUser(int id_app, int id_user) {
        this.id_app = id_app;
        this.id_user = id_user;
    }
}
