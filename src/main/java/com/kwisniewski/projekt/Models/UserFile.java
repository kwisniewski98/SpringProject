package com.kwisniewski.projekt.Models;

public class UserFile {
    private int id_app;
    private int id_user;
    private String filename;

    public void setId_app(int id_app) {
        this.id_app = id_app;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getId_app() {
        return id_app;
    }

    public int getId_user() {
        return id_user;
    }

    public String getFilename() {
        return filename;
    }

    public UserFile() {
    }

    public UserFile(int id_app, int id_user, String filename) {
        this.id_app = id_app;
        this.id_user = id_user;
        this.filename = filename;
    }
}
