package views;

import models.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import components.*;
import service.*;
public class MainView {
    public static void show() {
        MainViewFrame frame = new MainViewFrame("Main View");

        LibraryUser currentUser = new LibraryUser(5, 0, null, new ArrayList<>(), new ArrayList<>(), 1, 1); // 예시 정보, 사용자 상태와 역할을 설정합니다.

        JButton searchButton = new JButton("책 검색");
        searchButton.addActionListener(e -> {
            String fileName = "books.txt";
            BookSearchManager searchManager = new BookSearchManager(fileName, currentUser); // LibraryUser 객체를 전달합니다.
            searchManager.setVisible(true);
        });

        JButton addbookButton = new JButton("책 추가");
        addbookButton.addActionListener(e -> {
            AddBookView addBookView = new AddBookView();
            addBookView.setVisible(true);
        });

        JButton settingsButton = new JButton("설정");
        settingsButton.addActionListener(e -> {
            SettingDialog settingsDialog = new SettingDialog(frame);
            settingsDialog.setVisible(true);
        });

        JButton exitButton = new JButton("도서관 나가기");
        exitButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "안녕히가세요!", null, JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        centerPanel.add(searchButton);
        centerPanel.add(addbookButton);
        centerPanel.add(exitButton);
        panel.add(centerPanel, BorderLayout.CENTER);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        rightPanel.add(settingsButton);
        panel.add(rightPanel, BorderLayout.NORTH);

        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
