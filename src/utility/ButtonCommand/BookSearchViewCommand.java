package utility.ButtonCommand;

import models.People.Products.User;
import utility.PersonNotifier.CurrentPerson;
import views.BookSearchView;

public class BookSearchViewCommand implements ButtonCommand {


    @Override
    public void buttonPress() {
        CurrentPerson currentPerson = CurrentPerson.getInstance();
//        String filename = "src/main/java/books.txt";
        BookSearchView bookSearchView = BookSearchView.getInstance();
        bookSearchView.setVisible(true);

        currentPerson.subscribe(bookSearchView);
    }
}
