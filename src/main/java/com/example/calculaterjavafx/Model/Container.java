package com.example.calculaterjavafx.Model;

public class Container {
    private String id;
    private String location;
    private String status;

    public Container(String id, String location, String status) {
        this.id = id;
        this.location = location;
        this.status = status;
    }

    public String getId() { return id; }
    public String getLocation() { return location; }
    public String getStatus() { return status; }

    public void setId(String id) { this.id = id; }
    public void setLocation(String location) { this.location = location; }
    public void setStatus(String status) { this.status = status; }
}
