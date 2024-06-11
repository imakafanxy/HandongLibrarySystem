package models.BookState;

import models.Borrowable.Book;

import javax.swing.*;

// State Pattern: Concrete State
public class Borrowed implements BookState {
    @Override
    public void borrow(Book book) {
        JOptionPane.showMessageDialog(null, "이미 대출된 책입니다!", "대출 실패", JOptionPane.WARNING_MESSAGE);
    }

    @Override
    public void returnBook(Book book) {
        System.out.println("반납 성공!");
        book.setAvailability(new UnBorrowed());
    }
}
