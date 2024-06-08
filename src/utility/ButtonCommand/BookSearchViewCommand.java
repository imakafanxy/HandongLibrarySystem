package utility.ButtonCommand;

import models.People.Products.User;
import views.BookSearchView;

public class BookSearchViewCommand implements ButtonCommand {
    private User user;

    public BookSearchViewCommand(User user) {
        this.user = user;
    }

    @Override
    public void buttonPress() {
        String filename = "src/main/java/books.txt";
        BookSearchView bookSearchView = new BookSearchView(filename, user);
        bookSearchView.setVisible(true);
    }
}
