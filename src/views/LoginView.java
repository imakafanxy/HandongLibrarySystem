package views;

import javax.swing.*;
import java.awt.*;
import components.*;

public class LoginView {
    private LoginFrame frame;
    private JButton signInButton;
    private JButton signUpButton;

    public LoginView() {
        frame = new LoginFrame("Login/SignUp");

        signInButton = new JButton("Sign-In");
        signUpButton = new JButton("Sign-Up");

        signInButton.setPreferredSize(new Dimension(120, 30));
        signUpButton.setPreferredSize(new Dimension(120, 30));

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        centerPanel.add(signInButton);
        centerPanel.add(signUpButton);

        frame.add(centerPanel, BorderLayout.CENTER);

        signInButton.addActionListener(e -> SignIn.signIn());
        signUpButton.addActionListener(e -> SignUp.signUp());
    }

    public void show() {
        frame.setVisible(true);
    }
}
