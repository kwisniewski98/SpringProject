package com.kwisniewski.projekt.Models;

import javax.validation.constraints.NotNull;

public class App {

    @NotNull(message = "ID is required")
    private int id;

    @NotNull(message = "Name is required")
    private String name;

    @NotNull(message = "Domain is required")
    private String domain;

    @NotNull(message = "Version is required")
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

    @Override
    public String toString() {
        return id + "," + name + "," + domain + "," + version;
    }
}
