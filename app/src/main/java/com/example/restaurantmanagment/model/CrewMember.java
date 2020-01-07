package com.example.restaurantmanagment.model;

public class CrewMember{
    private String name;
    private int seconds;

    public CrewMember(String name, int seconds) {
        this.name = name;
        this.seconds = seconds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
}
