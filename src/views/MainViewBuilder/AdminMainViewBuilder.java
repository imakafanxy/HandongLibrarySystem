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
        JButton addBookbutton = new JButton("책 등록");
        ButtonCommand addBookViewCommand = new AddBookViewCommand();
        Button c_addBookViewButton = new Button(addBookViewCommand);

        addBookbutton.addActionListener(e -> c_addBookViewButton.pressed());

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
        mainView.setButton(addBookbutton);
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
