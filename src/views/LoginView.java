package views;

import javax.swing.*;
import java.awt.*;
import components.*;
import utility.ButtonCommand.Button;
import utility.ButtonCommand.ButtonCommand;
import utility.ButtonCommand.SignInViewCommand;
import utility.ButtonCommand.SignUpViewCommand;

public class LoginView extends JFrame {
    // Singleton Pattern
    private static LoginView loginView = null;

    public static LoginView getInstance() {
        if (loginView == null) {
            loginView = new LoginView();
        }
        return loginView;
    }

    // 기본 정보
    Dimension frameSize;

    // Component - Panels
    JPanel centerPanel;

    // Component - Buttons
    private JButton signInButton;
    private JButton signUpButton;


    private LoginView() {
        setVisible(true);
        setTitle("Login/SignUp");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        frameSize = getSize();

        addPanels();
        addButtons();
    }

    private void addPanels() {
        centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        centerPanel.setBounds(0, 0, frameSize.width, frameSize.height);
        centerPanel.setSize(frameSize);

        add(centerPanel, BorderLayout.CENTER);
    }

    private void addButtons() {
        signInButton = new JButton("Sign In");
        signUpButton = new JButton("Sign Up");

        signInButton.setPreferredSize(new Dimension(120, 30));
        signUpButton.setPreferredSize(new Dimension(120, 30));

        // SignInView에 대한 Command Pattern - Client
        ButtonCommand signInViewCommand = new SignInViewCommand();
        Button c_signInViewButton = new Button(signInViewCommand);

        signInButton.addActionListener(e -> c_signInViewButton.pressed());

        // SignUpView에 대한 Command Pattern - Client
        ButtonCommand signUpViewCommand = new SignUpViewCommand();
        Button c_signUpViewButton = new Button(signUpViewCommand);

        signUpButton.addActionListener(e -> c_signUpViewButton.pressed());

        centerPanel.add(signInButton);
        centerPanel.add(signUpButton);
    }
}
