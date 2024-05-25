package components;

import utility.ButtonCommand.ButtonCommand;
import utility.ButtonCommand.CancelCommand;
import utility.ButtonCommand.SignUpCommand;
import utility.ButtonCommand.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp {
    public static void signUp() {
        SignFrame signUpFrame = new SignFrame("회원가입");

        JPanel signUpPanel = new JPanel(new GridLayout(5, 2));
        signUpPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel idLabel = new JLabel("ID:");
        JTextField idTextField = new JTextField();
        JLabel pwLabel = new JLabel("Password:");
        JPasswordField pwField = new JPasswordField();
        JLabel nameLabel = new JLabel("이름:");
        JTextField nameTextField = new JTextField();
        JLabel roleLabel = new JLabel("역할:");
        String[] roles = {"학생", "교수", "도서관 관리자", "서버 관리자"};
        JComboBox<String> roleComboBox = new JComboBox<>(roles);

        JButton signUpButton = new JButton("회원가입");
        JButton cancelButton = new JButton("취소");

        signUpPanel.add(idLabel);
        signUpPanel.add(idTextField);
        signUpPanel.add(pwLabel);
        signUpPanel.add(pwField);
        signUpPanel.add(nameLabel);
        signUpPanel.add(nameTextField);
        signUpPanel.add(roleLabel);
        signUpPanel.add(roleComboBox);
        signUpPanel.add(signUpButton);
        signUpPanel.add(cancelButton);

        signUpFrame.add(signUpPanel);
        signUpFrame.setVisible(true);

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idTextField.getText();
                String pw = String.valueOf(pwField.getPassword());
                String name = nameTextField.getText();
                int roleIndex = roleComboBox.getSelectedIndex();
                int role = roleIndex + 1; // 유저: 1, 교수 : 2, 도서관 관리자: 3, 서버관리자: 4

                ButtonCommand signupCommand = new SignUpCommand(id, pw, name, roleIndex, role);
                Button c_signupButton = new Button(signupCommand);

                c_signupButton.pressed();

                signUpFrame.dispose();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonCommand cancelCommand = new CancelCommand();
                Button c_cancelButton = new Button(cancelCommand);

                c_cancelButton.pressed();

                signUpFrame.dispose();
            }
        });
    }
}
