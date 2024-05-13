package utility.ButtonCommand;

import components.SignUp;
import models.LibraryUser;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SignUpCommand implements ButtonCommand{
    private String id;
    private String pw;
    int roleIndex;
    int role;

    public SignUpCommand(String id, String pw, int roleIndex, int role) {
        this.id = id;
        this.pw = pw;
        this.roleIndex = roleIndex;
        this.role = role;
    }

    @Override
    public void buttonPress() {
        LibraryUser newUser = createDefaultLibraryUser(role);

        saveUserToFile(id, pw, role);

        JOptionPane.showMessageDialog(null, "회원가입이 성공했습니다!");
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
