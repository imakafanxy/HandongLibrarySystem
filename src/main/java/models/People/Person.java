package main.java.models.People;

public abstract class Person {
    private String ID;
    private String PW;
    private String name;
    private UserLevel userLevel;

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
