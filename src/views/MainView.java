package views;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import components.*;
import models.People.User;
import models.People.UserLevel;
import service.*;
import utility.ButtonCommand.Button;
import utility.ButtonCommand.ButtonCommand;
import utility.ButtonCommand.ExitCommand;

public class MainView {
    public static void show() {
        MainViewFrame frame = new MainViewFrame("Main View");
        // X버튼으론 못나감(책을 들고있는지 체크하기 위해서)
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        // Sample User creation. In real scenarios, this should be the logged-in user.
        User currentUser = new User("sampleId", "samplePw", "sampleName", UserLevel.USER_STUDENT, 5);

        JButton searchButton = new JButton("책 검색");
        searchButton.addActionListener(e -> {
            String fileName = "books.txt";
            BookSearchManager searchManager = new BookSearchManager(fileName, currentUser);
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

        // Concrete Command 생성
        ButtonCommand exitCommand = new ExitCommand();
        // Invoker 생성
        Button c_exitButton = new Button(exitCommand);

        JButton exitButton = new JButton("도서관 나가기");
        exitButton.addActionListener(e -> {
            c_exitButton.pressed();
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
