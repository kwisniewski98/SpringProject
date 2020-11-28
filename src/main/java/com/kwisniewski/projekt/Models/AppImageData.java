package com.kwisniewski.projekt.Models;

public class AppImageData {
    private int id;
    private int id_app;
    private String image_url;

    public AppImageData() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_app(int id_app) {
        this.id_app = id_app;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getId() {
        return id;
    }

    public int getId_app() {
        return id_app;
    }

    public String getImage_url() {
        return image_url;
    }

    public AppImageData(int id, int id_app, String image_url) {
        this.id = id;
        this.id_app = id_app;
        this.image_url = image_url;
    }

    @Override
    public String toString() {
        return id + "," + id_app + "," + image_url;
    }
}
