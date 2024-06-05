package models.People.Products;

import models.People.UserLevel;

public class ServerAdmin extends Admin{
    public ServerAdmin(String ID, String PW, String name, UserLevel userLevel) {
        super(ID, PW, name, userLevel);
    }
}
