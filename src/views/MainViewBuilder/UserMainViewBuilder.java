package views.MainViewBuilder;

import models.People.Products.User;
import views.BookSearchView;
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
        // Search Button
        JButton searchButton = new JButton("책 검색");
        ButtonCommand bookSearchViewCommand = new BookSearchViewCommand();
        Button c_bookSearchViewButton = new Button(bookSearchViewCommand);

        searchButton.addActionListener(e -> c_bookSearchViewButton.pressed());

        // Exit Button
        JButton exitButton = new JButton("도서관 나가기");
        ButtonCommand exitCommand = new ExitCommand();
        Button c_exitButton = new Button(exitCommand);

        exitButton.addActionListener(e -> c_exitButton.pressed());

        // setButtons
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
