package main.java.views;

import javax.swing.*;
import main.java.components.MainViewFrame;
import main.java.models.People.User;
import main.java.models.People.UserLevel;
import main.java.utility.ButtonCommand.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainView {
    private static ResourceBundle bundle;

    public static void show() {
        // 기본 로케일 설정 (예: 한국어)
        bundle = ResourceBundle.getBundle("localization.MainView", Locale.getDefault());

        MainViewFrame frame = new MainViewFrame(bundle.getString("title"));
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        User currentUser = new User("sampleId", "samplePw", "sampleName", UserLevel.USER_STUDENT, 5);

        ButtonReceiver buttonReceiver = new ButtonReceiver();
        
        ButtonCommand searchCommand = new SearchBookCommand(currentUser);
        ButtonCommand addBookCommand = new AddBookCommand(buttonReceiver);
        ButtonCommand settingsCommand = new SettingsCommand(frame);
        ButtonCommand exitCommand = new ExitCommand(buttonReceiver);

        Button searchButton = new Button(searchCommand);
        Button addBookButton = new Button(addBookCommand);
        Button settingsButton = new Button(settingsCommand);
        Button exitButton = new Button(exitCommand);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton searchBtn = new JButton(bundle.getString("searchButton"));
        searchBtn.addActionListener(e -> searchButton.pressed());
        centerPanel.add(searchBtn);

        JButton addbookBtn = new JButton(bundle.getString("addBookButton"));
        addbookBtn.addActionListener(e -> addBookButton.pressed());
        centerPanel.add(addbookBtn);

        JButton exitBtn = new JButton(bundle.getString("exitButton"));
        exitBtn.addActionListener(e -> exitButton.pressed());
        centerPanel.add(exitBtn);

        panel.add(centerPanel, BorderLayout.CENTER);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton settingsBtn = new JButton(bundle.getString("settingsButton"));
        settingsBtn.addActionListener(e -> settingsButton.pressed());
        rightPanel.add(settingsBtn);

        // 언어 변경 버튼 추가
        JButton languageBtn = new JButton(bundle.getString("languageButton"));
        languageBtn.addActionListener(e -> changeLanguage());
        rightPanel.add(languageBtn);

        panel.add(rightPanel, BorderLayout.NORTH);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private static void changeLanguage() {
        String[] options = {"English", "한국어"};
        int choice = JOptionPane.showOptionDialog(null,
                "Select Language",
                "Language",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);

        Locale selectedLocale;
        if (choice == 0) {
            selectedLocale = Locale.ENGLISH;
        } else if (choice == 1) {
            selectedLocale = Locale.KOREAN;
        } else {
            return; // 선택하지 않은 경우 아무 작업도 하지 않음
        }

        bundle = ResourceBundle.getBundle("localization.MainView", selectedLocale);
        SwingUtilities.invokeLater(MainView::show); // UI 갱신을 위해 MainView 다시 실행
    }
}
