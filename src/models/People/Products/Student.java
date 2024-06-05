package models.People.Products;

import models.People.UserLevel;

public class Student extends User {
    private static final int MAXIMUMRENTALBOOKNUM = 10;

    public Student(String ID, String PW, String name, UserLevel userLevel) {
        super(ID, PW, name, userLevel, MAXIMUMRENTALBOOKNUM);
    }
}
