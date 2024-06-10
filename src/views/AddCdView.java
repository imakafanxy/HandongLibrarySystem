package views;

import models.Borrowable.Cd;
import models.Borrowable.Strategy.CDAddStrategy;
import utility.ButtonCommand.AddCdCommand;
import utility.ButtonCommand.Button;
import utility.ButtonCommand.ButtonCommand;
import utility.ButtonCommand.CancelCommand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AddCdView extends JFrame {
    // Singleton Pattern
    private static AddCdView addCdView = null;

    public static AddCdView getInstance() {
        if (addCdView == null) {
            addCdView = new AddCdView();
        }
        return addCdView;
    }

    // 페이지 요소(패널)
    JPanel addPanel;

    // 페이지 요소(Label)
    private JLabel titleLabel;
    private JLabel artistLabel;
    private JLabel releaseDateLabel;
    private JLabel genreLabel;
    private JLabel languageLabel;
    private JLabel publisherLabel;
    private JLabel notesLabel;
    private JLabel locationLabel;

    // 페이지 요소(textfield)
    private JTextField titleField;
    private JTextField artistField;
    private JTextField releaseDateField;
    private JTextField genreField;
    private JTextField languageField;
    private JTextField publisherField;
    private JTextField notesField;
    private JTextField locationField;

    // 페이지 요소(Button)
    JButton cdAddButton;
    JButton cancelButton;

    private AddCdView() {
        setTitle("AddCdPage");

        addAddCdPanel();
        addComponents();

        addButtons();

        setVisible(true);

        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void addAddCdPanel() {
        addPanel = new JPanel();

        addPanel.setLayout(new GridLayout(10, 2));
        addPanel.setVisible(true);

        add(addPanel);
    }

    private void addComponents() {
        titleLabel = new JLabel("Title");
        titleField = new JTextField();

        artistLabel = new JLabel("Artist");
        artistField = new JTextField();

        releaseDateLabel = new JLabel("Release Date");
        releaseDateField = new JTextField();

        genreLabel = new JLabel("Genre");
        genreField = new JTextField();

        languageLabel = new JLabel("Language");
        languageField = new JTextField();

        publisherLabel = new JLabel("Publisher");
        publisherField = new JTextField();

        notesLabel = new JLabel("Notes");
        notesField = new JTextField();

        locationLabel = new JLabel("Location");
        locationField = new JTextField();

        addPanel.add(titleLabel);
        addPanel.add(titleField);
        addPanel.add(artistLabel);
        addPanel.add(artistField);
        addPanel.add(releaseDateLabel);
        addPanel.add(releaseDateField);
        addPanel.add(genreLabel);
        addPanel.add(genreField);
        addPanel.add(languageLabel);
        addPanel.add(languageField);
        addPanel.add(publisherLabel);
        addPanel.add(publisherField);
        addPanel.add(notesLabel);
        addPanel.add(notesField);
        addPanel.add(locationLabel);
        addPanel.add(locationField);
    }

    private void addButtons() {
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonCommand cancelButton = new CancelCommand();
                Button c_cancelButton = new Button(cancelButton);

                c_cancelButton.pressed();
                addCdView.dispose();
                addCdView = null;
            }
        });

        cdAddButton = new JButton("Add");
        cdAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cd 객체 생성
                String title = titleField.getText();
                String artist = artistField.getText();
                String releaseDate = releaseDateField.getText();
                String genre = genreField.getText();
                String language = languageField.getText();
                String publisher = publisherField.getText();
                String notes = notesField.getText();
                String location = locationField.getText();

                Cd newCD = new Cd(title, artist, releaseDate, genre, language, publisher, notes);
                newCD.setAddStrategy(new CDAddStrategy());

                // AddCD Command
                ButtonCommand addCdCommand = new AddCdCommand(newCD);
                Button c_addCdButton = new Button(addCdCommand);

                c_addCdButton.pressed();
                dispose();
                addCdView = null;
            }
        });

        addPanel.add(cancelButton);
        addPanel.add(cdAddButton);
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
