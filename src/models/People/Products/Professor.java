package models.People.Products;

import models.People.UserLevel;

public class Professor extends User{
    private static final int MAXIMUMRENTALBOOKNUM = 100;

    public Professor(String ID, String PW, String name, UserLevel userLevel) {
        super(ID, PW, name, userLevel, MAXIMUMRENTALBOOKNUM);
    }
}
