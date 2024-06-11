package models.BookState;

import models.Borrowable.Book;

import javax.swing.*;

// State Pattern: Concrete States
public class UnBorrowed implements BookState{
    @Override
    public void borrow(Book book) {
        System.out.println("대출 성공!");
        book.setAvailability(new Borrowed());
    }

    @Override
    public void returnBook(Book book) {
        JOptionPane.showMessageDialog(null, "대출하지 않은 책 입니다!", "반납 실패", JOptionPane.WARNING_MESSAGE);

    }
}
