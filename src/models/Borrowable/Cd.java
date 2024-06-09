package models.Borrowable;

import models.Borrowable.Strategy.Borrow.BorrowStrategy;
import models.Borrowable.Strategy.Return.ReturnStrategy;

import java.util.Date;

public class Cd extends BorrowableItem {
    private String title;
    private String artist;
    private String releaseDate;
    private String genre;
  
    private String publisher;
    private String notes;
    private String location;
    private String availability;
    private Date dueDate;
    private Boolean reservation;
    private String rentedUser;
    private String reservedUser;

    public Cd(String title, String artist, String releaseDate, String genre, String publisher, String notes, String location) {
        this.title = title;
        this.artist = artist;
        this.releaseDate = releaseDate;
        this.genre = genre;
       
        this.publisher = publisher;
        this.notes = notes;
        this.location = location;
        this.availability = "Available";
        this.reservation = false;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

   
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getReservation() {
        return reservation;
    }

    public void setReservation(Boolean reservation) {
        this.reservation = reservation;
    }

    public String getRentedUser() {
        return rentedUser;
    }

    public void setRentedUser(String rentedUser) {
        this.rentedUser = rentedUser;
    }

    public String getReservedUser() {
        return reservedUser;
    }

    public void setReservedUser(String reservedUser) {
        this.reservedUser = reservedUser;
    }

//    @Override
//    public void borrowed() {
//        this.availability = "Borrowed";
//    }
//
//    @Override
//    public void returned() {
//        this.availability = "Returned";
//    }

    @Override
    public String toString() {
        return "Cd{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", genre='" + genre + '\'' +
                ", publisher='" + publisher + '\'' +
                ", notes='" + notes + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
