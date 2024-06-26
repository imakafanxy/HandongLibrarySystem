package utility.ButtonCommand;

import models.Borrowable.Book;

public class BorrowCommand implements ButtonCommand {
    Book book;

    public BorrowCommand(Book book) {
        this.book = book;
    }

    @Override
    public void buttonPress() {
        book.borrow();
    }
}
