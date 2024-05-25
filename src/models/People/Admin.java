package models.People;

public class Admin extends Person{
    private String ID;
    private String PW;
    private String name;
    private UserLevel userLevel;

    public Admin(String ID, String PW, String name, UserLevel userLevel) {
        super(ID, PW, name, userLevel);
    }
}

//Admin 제거 ?