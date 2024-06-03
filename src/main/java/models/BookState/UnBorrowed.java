package main.java.models.BookState;

import main.java.models.Borrowable.Book;

import javax.swing.*;

// State Pattern: Concrete Statex
public class UnBorrowed implements BookState{
    @Override
    public void borrow(Book book) {
        System.out.println("대출 성공!");
    }

    @Override
    public void returnBook(Book book) {
        JOptionPane.showMessageDialog(null, "대출하지 않은 책 입니다!", "반납 실패", JOptionPane.WARNING_MESSAGE);

    }
}
