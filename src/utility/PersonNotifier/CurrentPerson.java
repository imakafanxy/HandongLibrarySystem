package utility.PersonNotifier;

import models.People.Products.Person;


// Concrete Subject
public class CurrentPerson extends PersonSubject {
    // Singleton Pattern
    private static CurrentPerson currentPerson = null;

    public static CurrentPerson getInstance() {
        if(currentPerson == null) {
            currentPerson =  new CurrentPerson();
        }
        
        return currentPerson;
    }

    private CurrentPerson() {}

    public void changeCurrentPerson(Person person) {
        this.person = person;
        notifyPerson();
    }
}
