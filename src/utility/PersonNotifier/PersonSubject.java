package utility.PersonNotifier;

import models.People.Products.Person;

import java.util.ArrayList;
import java.util.List;

public abstract class PersonSubject {

    private List<PersonObserver> observers = new ArrayList<>();

    protected Person person;

    // 새로 구독을 하는 객체들
    public void subscribe(PersonObserver observer) {
        observers.add(observer);

        if(person != null)
            observer.updateCurrentPerson(person);
    }

    // 구독을 취소하는 객체들
    public void unsubscribe(PersonObserver observer) {
        observers.remove(observer);
    }

    // 값 변경이 있을 시 보내주는 역할
    public void notifyPerson() {
        for(PersonObserver observer : observers) observer.updateCurrentPerson(person);
    }
}
