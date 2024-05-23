package models.People;

import models.Borrowable.Book;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User extends Person {
    private int maximumRentalBookNum;
    private int currentRentalBookNum;
    private Date overDue;
    private List<Book> rentedBooks;

    public User(int ID, String PW, String name, UserLevel userLevel, int maximumRentalBookNum) {
        super(ID, PW, name, userLevel);
        currentRentalBookNum = 0;
        overDue = null;
        rentedBooks = new ArrayList<Book>();
        this.maximumRentalBookNum = maximumRentalBookNum;
    }

    public int getMaximumRentalBookNum() {
        return maximumRentalBookNum;
    }

    public void setMaximumRentalBookNum(int maximumRentalBookNum) {
        this.maximumRentalBookNum = maximumRentalBookNum;
    }

    public int getCurrentRentalBookNum() {
        return currentRentalBookNum;
    }

    public void setCurrentRentalBookNum(int currentRentalBookNum) {
        this.currentRentalBookNum = currentRentalBookNum;
    }

    public Date getOverDue() {
        return overDue;
    }

    public void setOverDue(Date overDue) {
        this.overDue = overDue;
    }

    public List<Book> getRentedBooks() {
        return rentedBooks;
    }

    public void setRentedBooks(List<Book> rentedBooks) {
        this.rentedBooks = rentedBooks;
    }

    public boolean addRentedBook(Book book) {
        if(currentRentalBookNum < maximumRentalBookNum) {
            rentedBooks.add(book);
            currentRentalBookNum++;

            return true;
        }
        // rental fail
        return false;
    }

    public boolean returnBook(Book book) {
        try {
            rentedBooks.remove(book);
            return true;
        } catch (Exception e) {
            System.out.println("No book found!");
        }
        // return fail
        return false;
    }
}
