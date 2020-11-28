package com.kwisniewski.projekt.Models;

public class App {
    private int id;
    private String name;
    private String domain;
    private String version;

    public App() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDomain() {
        return domain;
    }

    public String getVersion() {
        return version;
    }

    public App(int id, String name, String domain, String version) {
        this.id = id;
        this.name = name;
        this.domain = domain;
        this.version = version;
    }
}
