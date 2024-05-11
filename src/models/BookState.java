package models;

public interface BookState {
    public void borrowing_book(Book book);
    public void returning_book(Book book);
}
