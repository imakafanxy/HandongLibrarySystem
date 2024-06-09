package models.Borrowable.Strategy;

import models.Borrowable.Book;
import models.Borrowable.BorrowableItem;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BookAddStrategy implements AddStrategy {
    @Override
    public void add(BorrowableItem book) {
        Book b = (Book) book;

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("books.txt", true))) {
            bw.write(b.getTitle() + "," +
                    b.getType() + "," +
                    b.getAuthor() + "," +
                    b.getPublisher() + "," +
                    b.getPublishDate() + "," +
                    b.getISBN() + "," +
                    b.getNotes() + "," +
                    b.getClassNo() + "," +
                    b.getLanguage() + "," +
                    b.getCallNo() + "," +
                    b.getLocation() + "\n");
            bw.flush();
            JOptionPane.showMessageDialog(null, "Book Added Successfully");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error while saving Book");
        }
    }
}
