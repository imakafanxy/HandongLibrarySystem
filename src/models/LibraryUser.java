package models;

import java.util.Date;
import java.util.List;

public class LibraryUser {
    private int maximumRentalBookNum;
    private int currentRentalBookNum;
    private Date overDue;
    private List<Book> rentedBooks;
    private List<Book> reservedBooks;
    private int userState;

    public LibraryUser(int maximumRentalBookNum, int currentRentalBookNum, Date overDue, List<Book> rentedBooks, List<Book> reservedBooks, int userState) {
        this.maximumRentalBookNum = maximumRentalBookNum;
        this.currentRentalBookNum = currentRentalBookNum;
        this.overDue = overDue;
        this.rentedBooks = rentedBooks;
        this.reservedBooks = reservedBooks;
        this.userState = userState;
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

    public List<Book> getReservedBooks() {
        return reservedBooks;
    }

    public void setReservedBooks(List<Book> reservedBooks) {
        this.reservedBooks = reservedBooks;
    }

    public int getUserState() {
        return userState;
    }

    public void setUserState(int userState) {
        this.userState = userState;
    }
}
