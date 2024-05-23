package service;

import components.BookInfoPanel;
import models.Borrowable.Book;
import utility.BookInfoUtil;
import models.People.LibraryUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

public class BookSearchManager extends JFrame {

    // 기본 페이지 크기
    static final int PAGE_WIDTH = 800;
    static final int PAGE_HEIGHT = 600;
    static final int BTN_SIZE_W = 100;
    static final int BTN_SIZE_H = 30;

    // 페이지 사이즈
    Dimension frameSize;

    // 페이지 요소(패널)
    JPanel searchPanel;

    // 페이지 요소
    JButton searchBtn;
    JButton rentBtn;
    JButton cancelBtn;
    JLabel searchLabel;
    JTextField searchField;
    List<BookInfo> currentBookInfoList;

    public BookSearchManager(String fileName, LibraryUser user) {
        setTitle("SearchPage");
        setLayout(null);
        setVisible(true);
        setSize(PAGE_WIDTH, PAGE_HEIGHT);
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        frameSize = getSize();
        setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);

        addSearchPanel(user); // LibraryUser 객체를 전달합니다.
    }

    void displayBookInfo(List<BookInfo> bookInfoList, LibraryUser user) {
        searchPanel.removeAll();  

        BookInfoPanel bookInfoPanel = new BookInfoPanel(bookInfoList);
        bookInfoPanel.setBounds(60, 60, 680, 400);
        searchPanel.add(bookInfoPanel);

        rentBtn = new JButton("대여하기");
        rentBtn.setBounds(60, 500, BTN_SIZE_W, BTN_SIZE_H);
        searchPanel.add(rentBtn);
        
        rentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 대여 가능한 상태인지 확인
                if (user.getUserState() == 1) {
                    int maxBooks = user.getMaximumRentalBookNum();
                    int currentBooks = user.getCurrentRentalBookNum();
                    if (currentBooks < maxBooks) {
                        // 대여 가능한 경우
                        user.setCurrentRentalBookNum(currentBooks + 1); // 현재 대여 중인 책 수 증가

                        // 현재 날짜
                        long currentTime = System.currentTimeMillis();
                        long dueTime = currentTime + (14 * 24 * 60 * 60 * 1000); // 14일 후
                        Date dueDate = new Date(dueTime);
                        user.setOverDue(dueDate); // 반납 기한 set

                        BookInfo bookInfo = currentBookInfoList.get(0);
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


                        rentedBook.setTitle(bookInfo.getTitle()); 
                        List<Book> rentedBooks = user.getRentedBooks();
                        rentedBooks.add(rentedBook);
                        user.setRentedBooks(rentedBooks);


                        JOptionPane.showMessageDialog(null, "대여신청이 완료됐습니다.");
                    } else {
                        JOptionPane.showMessageDialog(null, "더 이상 책을 대여할 수 없습니다.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "대여가 불가능한 상태입니다.");
                }
            }
        });


        cancelBtn = new JButton("취소");
        cancelBtn.setBounds(180, 500, BTN_SIZE_W, BTN_SIZE_H);
        searchPanel.add(cancelBtn);
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose();
            }
        });

        searchPanel.revalidate();
        searchPanel.repaint();

        currentBookInfoList = bookInfoList;
    }

    void addSearchPanel(LibraryUser user) {
        searchPanel = new JPanel();

        searchPanel.setBounds(0, 0, frameSize.width, frameSize.height);
        searchPanel.setLayout(null);
        searchPanel.setVisible(true);

        addSearchLabel();
        addSearchField();
        addSearchButton(user); 
        add(searchPanel);
    }


    void addSearchLabel() {
        searchLabel = new JLabel("Book Search: ");
        searchLabel.setBounds(60, 20, 100, 30);

        searchPanel.add(searchLabel);
    }

    void addSearchField() {
        searchField = new JTextField();

        searchField.setBounds(160, 20, 300, 30);

        searchPanel.add(searchField);
    }

    void addSearchButton(LibraryUser user) {
        searchBtn = new JButton("Search");

        searchBtn.setBounds(460, 20, BTN_SIZE_W, BTN_SIZE_H);

        searchPanel.add(searchBtn);

        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTitle = searchField.getText().trim();
                boolean found = false;

                List<BookInfo> bookInfoList = readBookInfoFromFile("books.txt", searchTitle);

                if (bookInfoList.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "책 정보가 존재하지 않습니다!");
                } else {
                    displayBookInfo(bookInfoList, user);
                }
            }
        });
    }


    // 파일에서 책 정보 읽어오는 메서드
    private List<BookInfo> readBookInfoFromFile(String fileName, String searchTitle) {
        List<BookInfo> bookInfoList = BookInfoUtil.createBookInfoListFromFile(fileName, searchTitle);
        return bookInfoList;
    }
}
