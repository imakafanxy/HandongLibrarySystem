package models.People;

import models.Borrowable.Book;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends User {
    private static final int MAXIMUMRENTALBOOKNUM = 10;

    public Student(String ID, String PW, String name, UserLevel userLevel) {
        super(ID, PW, name, userLevel, MAXIMUMRENTALBOOKNUM);
    }
}
