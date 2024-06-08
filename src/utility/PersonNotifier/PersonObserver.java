package utility.PersonNotifier;

import models.People.Products.Person;

// Subscriber
public interface PersonObserver {

    // 변경을 업데이트 함
    void updateCurrentPerson(Person currentPerson);
}
