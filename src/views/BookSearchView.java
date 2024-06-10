package views;

import models.Borrowable.Book;
import models.People.Products.Person;
import service.BookInfo;
import utility.BookInfoUtil;
import models.People.Products.User;
import utility.PersonNotifier.PersonObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BookSearchView extends JFrame implements PersonObserver {
    // Singleton Pattern
    private static BookSearchView bookSearchView;

    public static BookSearchView getInstance() {
        if (bookSearchView == null) {
            bookSearchView = new BookSearchView();
        }
        return bookSearchView;
    }
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

    User person;

    private BookSearchView() {
        setTitle("SearchPage");
        setLayout(new BorderLayout());
        setVisible(true);
        setSize(PAGE_WIDTH, PAGE_HEIGHT);
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        frameSize = getSize();
        setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);

        addSearchPanel();
    }

    void displayBookInfo(List<BookInfo> bookInfoList) {
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
                System.out.println("User: " + person.getName());
                if (person.getCurrentRentalBookNum() < person.getMaximumRentalBookNum()) {
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

                    boolean added = person.addRentedBook(rentedBook);
                    if (added) {
                        System.out.println("대여된 책 수: " + person.getCurrentRentalBookNum() + person.getID());
                        JOptionPane.showMessageDialog(null, "대여신청이 완료됐습니다.");
                    } else {
                        JOptionPane.showMessageDialog(null, "더 이상 책을 대여할 수 없습니다.");
                        System.out.println("대여된 책 수: " + person.getCurrentRentalBookNum() +person.getID());
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

    void addSearchPanel() {
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
                List<BookInfo> bookInfoList = readBookInfoFromFile("books.txt", searchTitle);

                if (bookInfoList.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "책 정보가 존재하지 않습니다!");
                } else {
                    displayBookInfo(bookInfoList);
                }
            }
        });

        add(searchPanel, BorderLayout.CENTER);
    }

    private List<BookInfo> readBookInfoFromFile(String fileName, String searchTitle) {
        List<BookInfo> bookInfoList = BookInfoUtil.createBookInfoListFromFile(fileName, searchTitle);
        return bookInfoList;
    }

    @Override
    public void updateCurrentPerson(Person currentPerson) {
        this.person = (User) currentPerson;
    }
}
