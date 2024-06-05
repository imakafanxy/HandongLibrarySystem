package models.People.Factory;

import models.People.Products.*;
import models.People.UserLevel;

public class SimplePersonFactory {
    public static Person createPerson(String id, String PW, String name, UserLevel userLevel) {
        if(userLevel == UserLevel.USER_STUDENT) {
            return new Student(id, PW, name, userLevel);
        }
        else if(userLevel == UserLevel.USER_PROFESSOR) {
            return new Professor(id, PW, name, userLevel);
        }
        else if(userLevel == UserLevel.ADMIN_LIBRARY) {
            return new LibraryAdmin(id, PW, name, userLevel);
        }
        else if(userLevel == UserLevel.ADMIN_SERVER) {
            return new ServerAdmin(id, PW, name, userLevel);
        }
        else {
            return null;
        }
    }
}
