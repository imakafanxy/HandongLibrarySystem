package views;

import models.Borrowable.Cd;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AddCdView extends JFrame {
    private JTextField titleField;
    private JTextField artistField;
    private JTextField releaseDateField;
    private JTextField genreField;
    private JTextField languageField;
    private JTextField publisherField;
    private JTextField notesField;
    private JTextField locationField;

    public AddCdView() {
        setTitle("Add CD");
        setLayout(new GridLayout(10, 2));

        add(new JLabel("Title:"));
        titleField = new JTextField();
        add(titleField);

        add(new JLabel("Artist:"));
        artistField = new JTextField();
        add(artistField);

        add(new JLabel("Release Date:"));
        releaseDateField = new JTextField();
        add(releaseDateField);

        add(new JLabel("Genre:"));
        genreField = new JTextField();
        add(genreField);

        add(new JLabel("Language:"));
        languageField = new JTextField();
        add(languageField);

        add(new JLabel("Publisher:"));
        publisherField = new JTextField();
        add(publisherField);

        add(new JLabel("Notes:"));
        notesField = new JTextField();
        add(notesField);

        add(new JLabel("Location:"));
        locationField = new JTextField();
        add(locationField);

        JButton addButton = new JButton("Add CD");
        addButton.addActionListener(e -> addCd());
        add(addButton);

        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void addCd() {
        String title = titleField.getText();
        String artist = artistField.getText();
        String releaseDate = releaseDateField.getText();
        String genre = genreField.getText();
      
        String publisher = publisherField.getText();
        String notes = notesField.getText();
        String location = locationField.getText();

        Cd cd = new Cd(title, artist, releaseDate, genre,publisher, notes, location);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("cds.txt", true))) {
            writer.write(title + "," + artist + "," + releaseDate + "," + genre + "," + publisher + "," + notes + "," + location + "\n");
            writer.flush();
            JOptionPane.showMessageDialog(this, "CD가 추가되었습니다.");
            dispose();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "CD 추가 중 오류가 발생했습니다.");
        }
    }
}
