package utility.PersonNotifier;

import models.People.Products.Person;

import java.util.ArrayList;
import java.util.List;

public class CurrentPerson extends PersonSubject {
    private List<PersonObserver> observers = new ArrayList<>();

    private Person person;

    public CurrentPerson(Person person) {
        this.person = person;
    }

    public void changeCurrentPerson(Person person) {
        this.person = person;
        notifyPerson();
    }
}
