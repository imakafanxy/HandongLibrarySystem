package main.java.components;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import main.java.views.*;

public class SignIn {
    public static void signIn() {
        JFrame signInFrame = new JFrame("로그인");
        signInFrame.setSize(300, 200);
        signInFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        signInFrame.setLocationRelativeTo(null);

        JPanel signInPanel = new JPanel(new GridLayout(3, 2));
        signInPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel idLabel = new JLabel("ID:");
        JTextField idTextField = new JTextField();
        JLabel pwLabel = new JLabel("Password:");
        JPasswordField pwField = new JPasswordField();

        JButton signInButton = new JButton("로그인하기");
        JButton cancelButton = new JButton("취소");

        signInPanel.add(idLabel);
        signInPanel.add(idTextField);
        signInPanel.add(pwLabel);
        signInPanel.add(pwField);
        signInPanel.add(signInButton);
        signInPanel.add(cancelButton);

        signInFrame.add(signInPanel);
        signInFrame.setVisible(true);

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idTextField.getText();
                String pw = String.valueOf(pwField.getPassword());
                
                //텍스트 파일로 유저 정보 읽어오기 
                try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/users.txt"))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] userInfo = line.split(",");
                        if (/*userInfo.length == 3 &&*/ userInfo[0].equals(id) && userInfo[1].equals(pw)) {
                            JOptionPane.showMessageDialog(null, "로그인에 성공했습니다.");
                            signInFrame.dispose();
                            MainView.show();
                            return;
                        }

                    }
                    JOptionPane.showMessageDialog(null, "아이디 및 비밀번호가 틀렸습니다.");
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다.");
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signInFrame.dispose();
            }
        });
    }
}
