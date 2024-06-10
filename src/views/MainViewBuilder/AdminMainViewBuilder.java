package views.MainViewBuilder;

import components.SettingDialog;
import models.People.Products.Admin;
import models.People.Products.User;
import utility.ButtonCommand.*;
import utility.ButtonCommand.Button;
import views.AddBookView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMainViewBuilder implements MainViewBuilder {
    private MainView mainView;
    private Admin currentAdmin;

    public AdminMainViewBuilder() {
        this.mainView = new MainView();
    }

    @Override
    public void buildPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        mainView.setPanel(panel);
    }

    @Override
    public void buildButton() {
        // AddBook Button
        JButton addBookButton = new JButton("책 등록");
        ButtonCommand addBookViewCommand = new AddBookViewCommand();
        Button c_addBookViewButton = new Button(addBookViewCommand);

        addBookButton.addActionListener(e -> c_addBookViewButton.pressed());

        // AddCd Button
        JButton addCdButton = new JButton("CD 등록");
        ButtonCommand addCdViewCommand = new AddCdViewCommand();
        Button c_addCdViewButton = new Button(addCdViewCommand);

        addCdButton.addActionListener(e -> c_addCdViewButton.pressed());

        // Setting Button
        JButton settingButton = new JButton("설정");
        ButtonCommand settingDialogCommand = new SettingDialogCommand(mainView);
        Button c_settingDialogButton = new Button(settingDialogCommand);

        settingButton.addActionListener(e -> c_settingDialogButton.pressed());

        // Exit Button
        ButtonCommand exitCommand = new ExitCommand();
        Button c_exitButton = new Button(exitCommand);

        JButton exitButton = new JButton("도서관 나가기");
        exitButton.addActionListener(e -> c_exitButton.pressed());

        // setButtons
        mainView.setButton(addBookButton);
        mainView.setButton(addCdButton);
        mainView.setButton(settingButton);
        mainView.setButton(exitButton);
    }

    @Override
    public void buildLabel() {
        JLabel titleLabel = new JLabel("관리자 홈에 오신 것을 환영합니다.");

        mainView.setLabel(titleLabel);
    }

    @Override
    public MainView getMainView() {
        return mainView;
    }
}
