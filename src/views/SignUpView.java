package views;

import models.People.Factory.SimplePersonFactory;
import models.People.Products.Person;
import models.People.UserLevel;
import utility.ButtonCommand.ButtonCommand;
import utility.ButtonCommand.CancelCommand;
import utility.ButtonCommand.SignUpCommand;
import utility.ButtonCommand.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpView extends JFrame {
    // singleton Pattern
    public static SignUpView signUpView = null;

    public static SignUpView getInstance() {
        if (signUpView == null) {
            signUpView = new SignUpView();
        }
        return signUpView;
    }

    // 기본 정보
    String title = "Sign Up";
    String[] roles = {"학생", "교수", "도서관 관리자", "서버 관리자"};
    Person person;

    int FRAME_WIDTH = 300;
    int FRAME_HEIGHT = 200;

    // Component - Panel
    JPanel panel;

    // Component - Buttons
    JButton signUpButton;
    JButton cancelButton;

    // Component - TextFields & PasswordField
    JTextField idTextField;
    JTextField nameTextField;
    JPasswordField pwField;

    // Component - Labels
    JLabel idLabel;
    JLabel nameLabel;
    JLabel pwLabel;
    JLabel roleLabel;

    // Component - etc
    JComboBox<String> roleComboBox;


    private SignUpView() {
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        addPanels();
        addIDFields();
        addPWFields();
        addNameFields();
        addRoleComboBox();
        addSignUpButton();
        addCancelButton();

        setVisible(true);
    }

    private void addPanels() {
        panel = new JPanel();

        panel.setLayout(new GridLayout(5, 2));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        add(panel);
    }

    private void addIDFields() {
        idLabel = new JLabel("ID");
        idTextField = new JTextField();

        panel.add(idLabel);
        panel.add(idTextField);
    }

    private void addPWFields() {
        pwLabel = new JLabel("Password");
        pwField = new JPasswordField();

        panel.add(pwLabel);
        panel.add(pwField);
    }

    private void addNameFields() {
        nameLabel = new JLabel("이름: ");
        nameTextField = new JTextField();

        panel.add(nameLabel);
        panel.add(nameTextField);
    }

    private void addRoleComboBox() {
        roleLabel = new JLabel("역할: ");
        roleComboBox = new JComboBox<>(roles);

        panel.add(roleLabel);
        panel.add(roleComboBox);
    }

    private void addSignUpButton() {
        signUpButton = new JButton("회원가입");
        panel.add(signUpButton);

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idTextField.getText();
                String pw = String.valueOf(pwField.getPassword());
                String name = nameTextField.getText();
                int role = roleComboBox.getSelectedIndex();

                SimplePersonFactory newPersonFactory = new SimplePersonFactory();

                person = newPersonFactory.createPerson(id, pw, name, UserLevel.setUserLevelByComboBox(role));

                ButtonCommand signUpCommand = new SignUpCommand(person);
                Button c_signUpButton = new Button(signUpCommand);

                c_signUpButton.pressed();
                dispose();
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
                signUpView = null;
            }
        });
    }
}
