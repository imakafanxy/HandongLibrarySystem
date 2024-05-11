package models;

public class UNBORROWED implements BookState{

    private static UNBORROWED unborrowed = new UNBORROWED();
    private UNBORROWED() {}

    public static UNBORROWED getInstance() {
        return unborrowed;
    }
    @Override
    public void borrowing_book(Book book) {
        System.out.println("Book Borrowed");
    }

    @Override
    public void returning_book(Book book) {
        System.out.println("Cannot returned!");
    }
}
