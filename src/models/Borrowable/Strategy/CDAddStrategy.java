package models.Borrowable.Strategy;

import models.Borrowable.BorrowableItem;
import models.Borrowable.Cd;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CDAddStrategy implements AddStrategy {
    @Override
    public void add(BorrowableItem CD) {
        Cd c = (Cd) CD;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("cds.txt", true))) {
            writer.write(c.getTitle() + "," +
                    c.getArtist() + "," +
                    c.getReleaseDate() + "," +
                    c.getGenre() + "," +
                    c.getPublisher() + "," +
                    c.getNotes() + ","+
                    c.getLocation() + "\n");
            writer.flush();
            JOptionPane.showMessageDialog(null, "CD가 추가되었습니다.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "CD 추가 중 오류가 발생했습니다.");
        }
    }
}
