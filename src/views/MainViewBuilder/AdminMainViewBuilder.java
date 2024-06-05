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
        JButton addBookbutton = new JButton("책 등록");
        addBookbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddBookView addBookView = new AddBookView();
                addBookView.setVisible(true);
            }
        });

        JButton settingButton = new JButton("설정");
        settingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SettingDialog settingDialog = new SettingDialog(mainView);
                settingDialog.setVisible(true);
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

        mainView.setButton(addBookbutton);
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
