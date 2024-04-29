package Iterator1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginManager {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login/SignUp");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JButton signInButton = new JButton("Sign-In");
        JButton signUpButton = new JButton("Sign-Up");

        signInButton.setPreferredSize(new Dimension(120, 30));
        signUpButton.setPreferredSize(new Dimension(120, 30));

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        centerPanel.add(signInButton);
        centerPanel.add(signUpButton);

        frame.add(centerPanel, BorderLayout.CENTER);

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignIn.signIn();
            }
        });

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUp.signUp();
            }
        });

        frame.setVisible(true);
    }
}
