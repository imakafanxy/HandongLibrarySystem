package models.People.Products;

import models.Borrowable.Book;
import models.People.UserLevel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User extends Person {
    private int maximumRentalBookNum;
    private int currentRentalBookNum;
    private Date overDue;
    private List<Book> rentedBooks;

    public User(String ID, String PW, String name, UserLevel userLevel, int maximumRentalBookNum) {
        super(ID, PW, name, userLevel);
        this.currentRentalBookNum = 0;
        this.overDue = null;
        this.rentedBooks = new ArrayList<>();
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
        if (currentRentalBookNum < maximumRentalBookNum) {
            rentedBooks.add(book);
            currentRentalBookNum++;
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book) {
        try {
            rentedBooks.remove(book);
            currentRentalBookNum--;
            return true;
        } catch (Exception e) {
            System.out.println("No book found!");
        }
        return false;
    }
}
