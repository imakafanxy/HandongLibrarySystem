package Iterator1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SignUp {
    public static void signUp() {
        JFrame signUpFrame = new JFrame("회원가입");
        signUpFrame.setSize(300, 250);
        signUpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        signUpFrame.setLocationRelativeTo(null);

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
                String role = Integer.toString(roleComboBox.getSelectedIndex() + 1); // 유저1, 관리자2, 서버관리자3 

                try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {
                    writer.write(id + "," + pw + "," + role + "\n");
                    writer.flush();
                    JOptionPane.showMessageDialog(null, "회원가입이 성공했습니다!");
                    signUpFrame.dispose();
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다!");
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signUpFrame.dispose();
            }
        });
    }
}
