package utility.ButtonCommand;

import models.Borrowable.Book;

public class AddBookCommand implements ButtonCommand {
    Book book;

    public AddBookCommand(Book book) {
        this.book = book;
    }

    @Override
    public void buttonPress() {
        book.addItem();
    }
}
