package models.People;

public class Admin extends Person{
    private int ID;
    private String PW;
    private String name;
    private UserLevel userLevel;

    public Admin(int ID, String PW, String name, UserLevel userLevel) {
        super(ID, PW, name, userLevel);
    }
}
