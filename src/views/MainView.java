package views;

import javax.swing.*;
import java.awt.*;
import components.*;
import service.*;

public class MainView {
    public static void show() {
        MainViewFrame frame = new MainViewFrame("Main View");

        JButton searchButton = new JButton("책 검색");
        searchButton.addActionListener(e -> {
            BookSearchManager searchManager = new BookSearchManager();
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

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        centerPanel.add(searchButton);
        centerPanel.add(addbookButton);
        panel.add(centerPanel, BorderLayout.CENTER);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        rightPanel.add(settingsButton);
        panel.add(rightPanel, BorderLayout.NORTH);

        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
