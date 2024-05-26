package models.BookState;

import models.Borrowable.Book;

// State Pattern: States
public interface BookState {
    void borrow(Book book);
    void returnBook(Book book);
}
