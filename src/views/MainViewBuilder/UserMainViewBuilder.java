package views.MainViewBuilder;

import models.People.Products.User;
import service.BookSearchManager;
import utility.ButtonCommand.*;
import utility.ButtonCommand.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserMainViewBuilder implements MainViewBuilder {
    private MainView mainView;
    private User currentUser;

    public UserMainViewBuilder() {
        this.mainView = new MainView();
    }


    @Override
    public void buildPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        mainView.setPanel(panel);
    }

    @Override
    public void buildButton() {
        JButton searchButton = new JButton("책 검색");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = "books.txt";
                BookSearchManager searchManager = new BookSearchManager(fileName, currentUser);
                searchManager.setVisible(true);
            }
        });

        ButtonCommand exitCommand = new ExitCommand();
        Button c_exitButton = new Button(exitCommand);

        JButton exitButton = new JButton("도서관 나가기");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c_exitButton.pressed();
            }
        });

        mainView.setButton(searchButton);
        mainView.setButton(exitButton);
    }

    @Override
    public void buildLabel() {
        JLabel titleLabel = new JLabel("사용자 홈에 오신 것을 환영합니다.");

        mainView.setLabel(titleLabel);
    }

    @Override
    public MainView getMainView() {
        return mainView;
    }
}
