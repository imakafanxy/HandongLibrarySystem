package models.People;

import models.Borrowable.Book;

import java.util.Date;
import java.util.List;

public class Professor extends User{
    private static final int MAXIMUMRENTALBOOKNUM = 100;

    public Professor(String ID, String PW, String name, UserLevel userLevel) {
        super(ID, PW, name, userLevel, MAXIMUMRENTALBOOKNUM);
    }
}
