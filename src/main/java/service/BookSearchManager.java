package main.java.service;

import main.java.models.Borrowable.Book;
import main.java.utility.BookInfoUtil;
import main.java.models.People.User;
import main.java.models.People.UserLevel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

public class BookSearchManager extends JFrame {
    static final int PAGE_WIDTH = 800;
    static final int PAGE_HEIGHT = 600;
    static final int BTN_SIZE_W = 100;
    static final int BTN_SIZE_H = 30;

    Dimension frameSize;
    JPanel searchPanel;
    JPanel buttonPanel;
    JButton searchBtn;
    JButton rentBtn;
    JButton cancelBtn;
    JLabel searchLabel;
    JTextField searchField;
    List<BookInfo> currentBookInfoList;

    public BookSearchManager(String fileName, User user) {
        setTitle("SearchPage");
        setLayout(new BorderLayout());
        setVisible(true);
        setSize(PAGE_WIDTH, PAGE_HEIGHT);
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        frameSize = getSize();
        setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);

        addSearchPanel(user);
    }

    void displayBookInfo(List<BookInfo> bookInfoList, User user) {
        searchPanel.removeAll();

        String[] columnNames = {"Title", "Type", "Author", "Publisher", "Publish Date", "ISBN", "Notes", "Class No", "Language", "Call No", "Location"};
        Object[][] data = new Object[bookInfoList.size() / columnNames.length][columnNames.length];

        for (int i = 0; i < bookInfoList.size(); i++) {
            data[i / columnNames.length][i % columnNames.length] = bookInfoList.get(i).getValue();
        }

        JTable bookTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(bookTable);
        bookTable.setFillsViewportHeight(true);

        searchPanel.setLayout(new BorderLayout());
        searchPanel.add(scrollPane, BorderLayout.CENTER);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        rentBtn = new JButton("대여하기");
        rentBtn.setPreferredSize(new Dimension(BTN_SIZE_W, BTN_SIZE_H));
        buttonPanel.add(rentBtn);

        rentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (user.getCurrentRentalBookNum() < user.getMaximumRentalBookNum()) {
                    BookInfo bookInfo = currentBookInfoList.get(0); // 첫 번째 책을 대여한다고 가정
                    Book rentedBook = new Book(
                            bookInfo.getTitle(),
                            bookInfo.getType(),
                            bookInfo.getAuthor(),
                            bookInfo.getPublisher(),
                            bookInfo.getPublishDate(),
                            bookInfo.getISBN(),
                            bookInfo.getNotes(),
                            bookInfo.getClassNo(),
                            bookInfo.getLanguage(),
                            bookInfo.getCallNo(),
                            bookInfo.getLocation()
                    );

                    boolean added = user.addRentedBook(rentedBook);
                    if (added) {
                        System.out.println("대여된 책 수: " + user.getCurrentRentalBookNum() + user.getID()); 
                        JOptionPane.showMessageDialog(null, "대여신청이 완료됐습니다.");
                    } else {
                        JOptionPane.showMessageDialog(null, "더 이상 책을 대여할 수 없습니다.");
                        System.out.println("대여된 책 수: " + user.getCurrentRentalBookNum() +user.getID()); 
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "대여가 불가능한 상태입니다.");
                }
            }
        });

        cancelBtn = new JButton("취소");
        cancelBtn.setPreferredSize(new Dimension(BTN_SIZE_W, BTN_SIZE_H));
        buttonPanel.add(cancelBtn);

        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        searchPanel.add(buttonPanel, BorderLayout.SOUTH);

        searchPanel.revalidate();
        searchPanel.repaint();

        currentBookInfoList = bookInfoList;
    }

    void addSearchPanel(User user) {
        searchPanel = new JPanel();
        searchPanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        searchLabel = new JLabel("Book Search: ");
        searchField = new JTextField(20);
        searchBtn = new JButton("Search");

        inputPanel.add(searchLabel);
        inputPanel.add(searchField);
        inputPanel.add(searchBtn);

        searchPanel.add(inputPanel, BorderLayout.NORTH);

        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTitle = searchField.getText().trim();
                List<BookInfo> bookInfoList = readBookInfoFromFile("src/main/java/books.txt", searchTitle);

                if (bookInfoList.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "책 정보가 존재하지 않습니다!");
                } else {
                    displayBookInfo(bookInfoList, user);
                }
            }
        });

        add(searchPanel, BorderLayout.CENTER);
    }

    private List<BookInfo> readBookInfoFromFile(String fileName, String searchTitle) {
        List<BookInfo> bookInfoList = BookInfoUtil.createBookInfoListFromFile(fileName, searchTitle);
        return bookInfoList;
    }
}
