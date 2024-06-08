package models.People.Products;

import models.Borrowable.Book;
import models.Borrowable.Cd;
import models.People.UserLevel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User extends Person {
    private int maximumRentalBookNum;
    private int currentRentalBookNum;
    private int maximumRentalCdNum;
    private int currentRentalCdNum;
    private Date overDue;
    private List<Book> rentedBooks;
    private List<Cd> rentedCds;

    public User(String ID, String PW, String name, UserLevel userLevel, int maximumRentalBookNum) {
        super(ID, PW, name, userLevel);
        this.currentRentalBookNum = 0;
        this.overDue = null;
        this.rentedBooks = new ArrayList<>();
        this.rentedCds = new ArrayList<>();
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
    
    public boolean addRentedCd(Cd cd) {
        if (currentRentalCdNum < maximumRentalCdNum) {
            rentedCds.add(cd);
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
    
    public boolean returnCd(Cd cd) {
        try {
            rentedCds.remove(cd);
            currentRentalBookNum--;
            return true;
        } catch (Exception e) {
            System.out.println("No Cd found!");
        }
        return false;
    }
}
