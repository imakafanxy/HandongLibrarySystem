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
               
                JPanel signInPanel = new JPanel();
                signInPanel.setLayout(new GridLayout(0, 2));

                JLabel idLabel = new JLabel("ID:");
                JTextField idTextField = new JTextField();
                JLabel pwLabel = new JLabel("PW:");
                JTextField pwTextField = new JTextField();
                JButton loginButton = new JButton("Login");
                JButton cancelButton = new JButton("Cancel");

                signInPanel.add(idLabel);
                signInPanel.add(idTextField);
                signInPanel.add(pwLabel);
                signInPanel.add(pwTextField);
                signInPanel.add(loginButton);
                signInPanel.add(cancelButton);

                JDialog signInDialog = new JDialog(frame, "Sign-In", true);
                signInDialog.getContentPane().add(signInPanel);
                signInDialog.pack();
                signInDialog.setLocationRelativeTo(null);
                signInDialog.setVisible(true);
                
                loginButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       // 로그인 처리
                    	System.out.println("login");
                    	signInDialog.setVisible(false);
                       signInDialog.dispose();
                      
                    }
                });

                cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        signInDialog.dispose();
                    }
                });
            }
        });

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JPanel signUpPanel = new JPanel();
                signUpPanel.setLayout(new GridLayout(0, 2));

                JLabel idLabel = new JLabel("ID:");
                JTextField idTextField = new JTextField();
                JLabel pwLabel = new JLabel("PW:");
                JTextField pwTextField = new JTextField();
                JLabel roleLabel = new JLabel("Role:");
                String[] roles = {"User", "Admin", "Server Admin"};
                JComboBox<String> roleComboBox = new JComboBox<>(roles);
                JButton completeButton = new JButton("Complete");

                signUpPanel.add(idLabel);
                signUpPanel.add(idTextField);
                signUpPanel.add(pwLabel);
                signUpPanel.add(pwTextField);
                signUpPanel.add(roleLabel);
                signUpPanel.add(roleComboBox);
                signUpPanel.add(completeButton);

                JDialog signUpDialog = new JDialog(frame, "Sign-Up", true);
                signUpDialog.getContentPane().add(signUpPanel);
                signUpDialog.pack();
                signUpDialog.setLocationRelativeTo(null);
                signUpDialog.setVisible(true);
            }
        });

        frame.setVisible(true);
    }
}

