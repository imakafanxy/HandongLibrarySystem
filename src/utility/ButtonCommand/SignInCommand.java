package utility.ButtonCommand;

import models.People.Products.Person;
import models.People.UserLevel;
import views.MainViewBuilder.*;

public class SignInCommand implements ButtonCommand {
    private Person person;
    private MainViewBuilder mainViewBuilder;

    public SignInCommand(Person person) {
        this.person = person;
    }

    @Override
    public void buttonPress() {
        if(person.getUserLevel() == UserLevel.USER_STUDENT || person.getUserLevel() == UserLevel.USER_PROFESSOR) {
            mainViewBuilder = new UserMainViewBuilder();
        }
        else {
            mainViewBuilder = new AdminMainViewBuilder();
        }

        MainViewDirector director = new MainViewDirector(mainViewBuilder);
        director.construct();

        MainView mainView = mainViewBuilder.getMainView();
        mainView.updateCurrentPerson(person);

        mainView.setVisible(true);
    }
}
