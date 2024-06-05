package models.People.Products;

import models.People.UserLevel;
import utility.PersonNotifier.PersonObserver;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String ID;
    private String PW;
    private String name;
    private UserLevel userLevel;

    // For Observer Pattern
    private List<PersonObserver> observers = new ArrayList<>();

    public Person(String ID, String PW, String name, UserLevel userLevel) {
    	this.ID = ID;
        this.PW = PW;
        this.name = name;
        this.userLevel = userLevel;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPW() {
        return PW;
    }

    public void setPW(String PW) {
        this.PW = PW;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserLevel getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(UserLevel userLevel) {
        this.userLevel = userLevel;
    }
}
