package views;

import models.People.Factory.SimplePersonFactory;
import models.People.Products.Person;
import models.People.UserLevel;
import utility.ButtonCommand.ButtonCommand;
import utility.ButtonCommand.CancelCommand;
import utility.ButtonCommand.Button;
import utility.ButtonCommand.SignInCommand;
import views.MainViewBuilder.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SignInView extends JFrame {
    // singleton Pattern
    private static SignInView signInView = null;

    public static SignInView getInstance() {
        if (signInView == null) {
            signInView = new SignInView();
        }
        return signInView;
    }

    // 기본 정보
    String title = "Sign In";

    int FRAME_WIDTH = 300;
    int FRAME_HEIGHT = 200;

    Person person;

    // Component - Panel
    JPanel panel;

    // Component - Buttons
    JButton signInButton;
    JButton cancelButton;

    // Component - TextFields & PasswordField
    JTextField idTextField;
    JPasswordField pwField;

    // Component - Labels
    JLabel idLabel;
    JLabel pwLabel;

    private SignInView() {
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLocationRelativeTo(null);

        addPanel();
        addIDFields();
        addPWFields();
        addSignInButton();
        addCancelButton();

        setVisible(true);
    }

    private void addPanel() {
        panel = new JPanel(new GridLayout(3, 2));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        add(panel);
    }

    private void addIDFields() {
        idLabel = new JLabel("ID:");
        idTextField = new JTextField();

        panel.add(idLabel);
        panel.add(idTextField);
    }

    private void addPWFields() {
        pwLabel = new JLabel("Password:");
        pwField = new JPasswordField();

        panel.add(pwLabel);
        panel.add(pwField);
    }

    private void addSignInButton() {
        signInButton = new JButton("Sign In");
        panel.add(signInButton);

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idTextField.getText();
                String pw = String.valueOf(pwField.getPassword());

                // 텍스트 파일로 유저 정보 읽어오기
                try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] userInfo = line.split(",");

                        // 로그인 성공 시
                        if(/*userInfo.length == 3 &&*/ userInfo[0].equals(id) && userInfo[1].equals(pw)) {
                            JOptionPane.showMessageDialog(null, "로그인에 성공했습니다.");
                            signInView.dispose();

                            // Person 객체 생성
                            String personID = userInfo[0];
                            String personPassword = userInfo[1];
                            String personName = userInfo[2];
                            UserLevel personUserLevel = UserLevel.setUserLevelByLevel(userInfo[3]);
                            SimplePersonFactory newPersonFactory = new SimplePersonFactory();

                            person = newPersonFactory.createPerson(personID, personPassword, personName, personUserLevel);


                            // SignInCommand
                            ButtonCommand signInCommand = new SignInCommand(person);
                            Button c_signInButton = new Button(signInCommand);
                            c_signInButton.pressed();
                            return;
                        }
                    }
                    // 로그인 실패 시(ID/PW 없음)
                    JOptionPane.showMessageDialog(null, "아이디 및 비밀번호가 틀렸습니다.");
                // 로그인 실패 시(파일 불러오기 에러)
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다.");
                }
            }
        });
    }

    private void addCancelButton() {
        cancelButton = new JButton("취소");
        panel.add(cancelButton);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonCommand cancelCommand = new CancelCommand();
                Button c_cancelButton = new Button(cancelCommand);

                c_cancelButton.pressed();
                dispose();
                signInView = null;
            }
        });
    }
}
