package utility.ButtonCommand;

import models.People.*;
import models.Borrowable.Book;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class SignUpCommand implements ButtonCommand {
    private String id;
    private String pw;
    private String name;
    int roleIndex;
    int role;
    private UserLevel userLevel;

    public SignUpCommand(String id, String pw, String name, int roleIndex, int role) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.roleIndex = roleIndex;
        this.role = role;
        this.userLevel = getUserLevel(roleIndex); // UserLevel 설정
    }

    @Override
    public void buttonPress() {
        User newUser = createUserByRole(id, pw, name, userLevel);

        saveUserToFile(newUser);

        JOptionPane.showMessageDialog(null, "회원가입이 성공했습니다!");
    }

    private User createUserByRole(String id, String pw, String name, UserLevel userLevel) {
        switch (userLevel) {
            case USER_STUDENT:
                return new Student(id, pw, name, userLevel);
            case USER_PROFESSOR:
                return new Professor(id, pw, name, userLevel);
            case ADMIN_LIBRARY:
                return new LibraryAdmin(id, pw, name, userLevel);
            case ADMIN_SERVER:
                return new ServerAdmin(id, pw, name, userLevel);
            default:
                throw new IllegalArgumentException("Invalid user role");
        }
    }

    private void saveUserToFile(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {
            writer.write(user.getID() + "," + user.getPW() + "," + user.getName() + "," + user.getUserLevel().getCombobox_selected() + ","
                    + user.getMaximumRentalBookNum() + "," + user.getCurrentRentalBookNum() + "," + (user.getOverDue() != null ? user.getOverDue().toString() : "null") + ","
                    + user.getRentedBooks().size() + "\n");
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다!");
        }
    }

    private UserLevel getUserLevel(int roleIndex) {
        switch (roleIndex) {
            case 0:
                return UserLevel.USER_STUDENT;
            case 1:
                return UserLevel.USER_PROFESSOR;
            case 2:
                return UserLevel.ADMIN_LIBRARY;
            case 3:
                return UserLevel.ADMIN_SERVER;
            default:
                throw new IllegalArgumentException("Invalid role index");
        }
    }
}
