package models.People.Products;

import models.People.UserLevel;

public class Admin extends Person{

    public Admin(String ID, String PW, String name, UserLevel userLevel) {
        super(ID, PW, name, userLevel);
    }
}