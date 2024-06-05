package models.Borrowable;

import models.BookState.BookState;
import models.BookState.Borrowed;
import models.BookState.UnBorrowed;

import java.util.Date;

public class Book {
	
	private String title;
	private String type;
	private String author;
	private String publisher;
//	private Date publishDate;
//	private int ISBN;
	private String publishDate;
	private String ISBN;
	private String notes;
	private String classNo;
	private String language;
	private String registrationNo;
	private String callNo;
	private String location;
	private BookState availability;
	private Date dueDate;
	private Boolean reservation;
	private int currentBookShelf;
	private Date reservationDueDate;
	// TODO: Following two variables must be changed by User Class.
	private String rentedUser;
	private String reservedUser;

	public Book(
			String title,
			String type,
			String author,
			String publisher,
			String publishDate,
			String ISBN,
			String notes,
			String classNo,
			String language,
			String callNo,
			String location) {
		this.title = title;
		this.type = type;
		this.author = author;
		this.publisher = publisher;
		this.publishDate = publishDate;
		this.ISBN = ISBN;
		this.notes = notes;
		this.classNo = classNo;
		this.language = language;
		this.callNo = callNo;
		this.location = location;

		this.availability = new UnBorrowed();
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
//	public Date getPublishDate() {
//		return publishDate;
//	}
//	public void setPublishDate(Date publishDate) {
//		this.publishDate = publishDate;
//	}
//	public int getISBN() {
//		return ISBN;
//	}
//	public void setISBN(int iSBN) {
//		this.ISBN = iSBN;
//	}
	public String getPublishDate() {
		return publishDate;
	};
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getClassNo() {
		return classNo;
	}
	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
	public String getCallNo() {
		return callNo;
	}
	public void setCallNo(String callNo) {
		this.callNo = callNo;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public BookState getAvailability() {
		return availability;
	}
	public void setAvailability(BookState availability) {
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
	public int getCurrentBookShelf() {
		return currentBookShelf;
	}
	public void setCurrentBookShelf(int currentBookShelf) {
		this.currentBookShelf = currentBookShelf;
	}
	public Date getReservationDueDate() {
		return reservationDueDate;
	}
	public void setReservationDueDate(Date reservationDueDate) {
		this.reservationDueDate = reservationDueDate;
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

	// State Pattern: Context
	public void borrow() {
		availability.borrow(this);
	}

	public void returnBook() {
		availability.returnBook(this);
	}


	@Override
	public String toString() {
		return "Book{" +
				"title='" + title + '\'' +
				", callNo='" + callNo + '\'' +
				'}';
	}
}