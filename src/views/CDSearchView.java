package views;

import service.BookInfo;
import utility.BookInfoUtil;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CDSearchView extends JFrame {
    // Singleton Pattern
    private static CDSearchView cdSearchView;

    public static CDSearchView getInstance() {
        if (cdSearchView == null) {
            cdSearchView = new CDSearchView();
        }
        return cdSearchView;
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

    private CDSearchView() {
        setTitle("SearchPage");
        setLayout(new BorderLayout());
        setVisible(true);
        setSize(PAGE_WIDTH, PAGE_HEIGHT);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frameSize = new Dimension(screenSize.width / 2, screenSize.height / 2);

        addSearchPanel();
    }

    private void addSearchPanel() {
        searchPanel = new JPanel();
        searchPanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        searchLabel = new JLabel("Search");
        searchField = new JTextField(20);
        searchBtn = new JButton("Search");

        inputPanel.add(searchLabel);
        inputPanel.add(searchField);
        inputPanel.add(searchBtn);

        searchPanel.add(inputPanel, BorderLayout.NORTH);

        add(searchPanel, BorderLayout.CENTER);
    }
}
