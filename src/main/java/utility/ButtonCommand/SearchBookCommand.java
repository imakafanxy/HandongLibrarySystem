package main.java.utility.ButtonCommand;

import main.java.service.BookSearchManager;
import main.java.models.People.User;

public class SearchBookCommand implements ButtonCommand {
    private User user;

    public SearchBookCommand(User user) {
        this.user = user;
    }

    @Override
    public void buttonPress() {
        String fileName = "books.txt";
        BookSearchManager searchManager = new BookSearchManager(fileName, user);
        searchManager.setVisible(true);
    }
}
