package views;

import models.Borrowable.Book;
import models.Borrowable.Strategy.BookAddStrategy;
import utility.ButtonCommand.AddBookCommand;
import utility.ButtonCommand.Button;
import utility.ButtonCommand.ButtonCommand;
import utility.ButtonCommand.CancelCommand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookView extends JFrame {
    // Singleton Pattern
    private static AddBookView addBookView = null;

    public static AddBookView getInstance() {
        if (addBookView == null) {
            addBookView = new AddBookView();
        }
        return addBookView;
    }

    // 기본 페이지 크기
    static final int PAGE_WIDTH = 340;
    static final int PAGE_HEIGHT = 520;
    static final int BTN_SIZE_W = 100;
    static final int BTN_SIZE_H = 40;
    static final int LABEL_SIZE_W = 80;
    static final int LABEL_SIZE_H = 30;
    static final int FIELD_SIZE_W = 200;
    static final int FIELD_SIZE_H = 30;

    // 페이지 사이즈
    Dimension frameSize;

    // 페이지 요소(패널)
    JPanel addPanel;

    // 페이지 요소(Label)
    JLabel titleLabel;
    JLabel typeLabel;
    JLabel authorLabel;
    JLabel publisherLabel;
    JLabel publishDateLabel;
    JLabel ISBNLabel;
    JLabel notesLabel;
    JLabel classNoLabel;
    JLabel languageLabel;
    JLabel callNoLabel;
    JLabel locationLabel;


    // 페이지 요소(textfiled)
    JTextField titleField;
    JTextField typeField;
    JTextField authorField;
    JTextField publisherField;
    JTextField publishDateField;
    JTextField ISBNField;
    JTextField notesField;
    JTextField classNoField;
    JTextField languageField;
    JTextField callNoField;
    JTextField locationField;


    // 페이지 요소(Button)
    JButton bookAddButton;
    JButton cancelButton;

    private AddBookView() {
        setTitle("AddBookPage");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setSize(PAGE_WIDTH, PAGE_HEIGHT);
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        frameSize = getSize();

        setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);
        addAddBookPanel();
    }

    private void addAddBookPanel() {
        addPanel = new JPanel();

        addPanel.setLayout(null);
        addPanel.setBounds(0, 0, frameSize.width, frameSize.height);
        addPanel.setVisible(true);

        addLabels();
        addFields();
        addButtons();

        add(addPanel);
    }

    private void addLabels() {
        titleLabel = new JLabel("Book Title");
        typeLabel = new JLabel("Type");
        authorLabel = new JLabel("Author");
        publisherLabel = new JLabel("Publisher");
        publishDateLabel = new JLabel("Publish Date");
        ISBNLabel = new JLabel("ISBN");
        notesLabel = new JLabel("Notes");
        classNoLabel = new JLabel("Class No");
        languageLabel = new JLabel("Language");
        callNoLabel = new JLabel("Call No");
        locationLabel = new JLabel("Location");

        titleLabel.setBounds(10, 10, LABEL_SIZE_W, LABEL_SIZE_H);
        typeLabel.setBounds(10, 50, LABEL_SIZE_W, LABEL_SIZE_H);
        authorLabel.setBounds(10, 90, LABEL_SIZE_W, LABEL_SIZE_H);
        publisherLabel.setBounds(10, 130, LABEL_SIZE_W, LABEL_SIZE_H);
        publishDateLabel.setBounds(10, 170, LABEL_SIZE_W, LABEL_SIZE_H);
        ISBNLabel.setBounds(10, 210, LABEL_SIZE_W, LABEL_SIZE_H);
        notesLabel.setBounds(10, 250, LABEL_SIZE_W, LABEL_SIZE_H);
        classNoLabel.setBounds(10, 290, LABEL_SIZE_W, LABEL_SIZE_H);
        languageLabel.setBounds(10, 330, LABEL_SIZE_W, LABEL_SIZE_H);
        callNoLabel.setBounds(10, 370, LABEL_SIZE_W, LABEL_SIZE_H);
        locationLabel.setBounds(10, 410, LABEL_SIZE_W, LABEL_SIZE_H);

        addPanel.add(titleLabel);
        addPanel.add(typeLabel);
        addPanel.add(authorLabel);
        addPanel.add(publisherLabel);
        addPanel.add(publishDateLabel);
        addPanel.add(ISBNLabel);
        addPanel.add(notesLabel);
        addPanel.add(classNoLabel);
        addPanel.add(languageLabel);
        addPanel.add(callNoLabel);
        addPanel.add(locationLabel);

    }

    private void addFields() {
        titleField = new JTextField();
        typeField = new JTextField();
        authorField = new JTextField();
        publisherField = new JTextField();
        publishDateField = new JTextField();
        ISBNField = new JTextField();
        notesField = new JTextField();
        classNoField = new JTextField();
        languageField = new JTextField();
        callNoField = new JTextField();
        locationField = new JTextField();

        titleField.setBounds(120, 10, FIELD_SIZE_W, FIELD_SIZE_H);
        typeField.setBounds(120, 50, FIELD_SIZE_W, FIELD_SIZE_H);
        authorField.setBounds(120, 90, FIELD_SIZE_W, FIELD_SIZE_H);
        publisherField.setBounds(120, 130, FIELD_SIZE_W, FIELD_SIZE_H);
        publishDateField.setBounds(120, 170, FIELD_SIZE_W, FIELD_SIZE_H);
        ISBNField.setBounds(120, 210, FIELD_SIZE_W, FIELD_SIZE_H);
        notesField.setBounds(120, 250, FIELD_SIZE_W, FIELD_SIZE_H);
        classNoField.setBounds(120, 290, FIELD_SIZE_W, FIELD_SIZE_H);
        languageField.setBounds(120, 330, FIELD_SIZE_W, FIELD_SIZE_H);
        callNoField.setBounds(120, 370, FIELD_SIZE_W, FIELD_SIZE_H);
        locationField.setBounds(120, 410, FIELD_SIZE_W, FIELD_SIZE_H);

        addPanel.add(titleField);
        addPanel.add(typeField);
        addPanel.add(authorField);
        addPanel.add(publisherField);
        addPanel.add(publishDateField);
        addPanel.add(ISBNField);
        addPanel.add(notesField);
        addPanel.add(classNoField);
        addPanel.add(languageField);
        addPanel.add(callNoField);
        addPanel.add(locationField);
    }

    private void addButtons() {
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(PAGE_WIDTH - 2*BTN_SIZE_W - 20, PAGE_HEIGHT - BTN_SIZE_H - 30, BTN_SIZE_W, BTN_SIZE_H);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonCommand cancelButton = new CancelCommand();
                Button c_cancelButton = new Button(cancelButton);

                c_cancelButton.pressed();
                addBookView.dispose();
                addBookView = null;
            }
        });

        bookAddButton = new JButton("Add Book");

        bookAddButton.setBounds(PAGE_WIDTH - BTN_SIZE_W - 10, PAGE_HEIGHT - BTN_SIZE_H - 30, BTN_SIZE_W, BTN_SIZE_H);


        bookAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Book 객체 생성
                String title = titleField.getText();
                String type = typeField.getText();
                String author = authorField.getText();
                String publisher = publisherField.getText();
                String publishDate = publishDateField.getText();
                String ISBN = ISBNField.getText();
                String notes = notesField.getText();
                String classNo = classNoField.getText();
                String language = languageField.getText();
                String callNo = callNoField.getText();
                String location = locationField.getText();

                Book newBook = new Book(title, type, author, publisher, publishDate, ISBN, notes, classNo, language, callNo, location);
                newBook.setAddStrategy(new BookAddStrategy());

                // AddBook Command
                ButtonCommand addBookCommand = new AddBookCommand(newBook);
                Button c_addBookButton = new Button(addBookCommand);

                c_addBookButton.pressed();
                dispose();
                addBookView = null;
            }
        });

        addPanel.add(cancelButton);
        addPanel.add(bookAddButton);
    }
}
