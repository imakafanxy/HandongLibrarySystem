package components;

import models.LibraryUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SignUp {
    public static void signUp() {
        SignFrame signUpFrame = new SignFrame("회원가입");

        JPanel signUpPanel = new JPanel(new GridLayout(4, 2));
        signUpPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel idLabel = new JLabel("ID:");
        JTextField idTextField = new JTextField();
        JLabel pwLabel = new JLabel("Password:");
        JPasswordField pwField = new JPasswordField();
        JLabel roleLabel = new JLabel("역할:");
        String[] roles = {"학생", "관리자", "서버 관리자"};
        JComboBox<String> roleComboBox = new JComboBox<>(roles);

        JButton signUpButton = new JButton("회원가입");
        JButton cancelButton = new JButton("취소");

        signUpPanel.add(idLabel);
        signUpPanel.add(idTextField);
        signUpPanel.add(pwLabel);
        signUpPanel.add(pwField);
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
                int roleIndex = roleComboBox.getSelectedIndex();
                int role = roleIndex + 1; // 유저: 1, 관리자: 2, 서버관리자: 3

                LibraryUser newUser = createDefaultLibraryUser(role);

                saveUserToFile(id, pw, role);

                JOptionPane.showMessageDialog(null, "회원가입이 성공했습니다!");
                signUpFrame.dispose();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signUpFrame.dispose();
            }
        });
    }

    private static LibraryUser createDefaultLibraryUser(int role) {
        return new LibraryUser(5, 0, null, new ArrayList<>(), new ArrayList<>(), 1 ,role);
    }

    private static void saveUserToFile(String id, String pw, int role) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {
            writer.write(id + "," + pw + "," + role + "\n");
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다!");
        }
    }
}
