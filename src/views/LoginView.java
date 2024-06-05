package views;

import javax.swing.*;
import java.awt.*;
import components.*;

public class LoginView extends JFrame {

    // 기본 정보
    Dimension frameSize;

    // Component - Panels
    JPanel centerPanel;

    // Component - Buttons
    private JButton signInButton;
    private JButton signUpButton;

    // Singleton Pattern
    private static LoginView loginView = null;

    public static LoginView getInstance() {
        if (loginView == null) {
            loginView = new LoginView();
        }
        return loginView;
    }

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

        signInButton.addActionListener(e -> SignInView.getInstance());
        signUpButton.addActionListener(e -> SignUpView.getInstance());

        centerPanel.add(signInButton);
        centerPanel.add(signUpButton);
    }
}
