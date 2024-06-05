package utility.ButtonCommand;

import models.People.Products.Person;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SignUpCommand implements ButtonCommand {
    private Person person;

    public SignUpCommand(Person person) {
        this.person = person;
    }

    @Override
    public void buttonPress() {
        saveUserToFile(person);

        JOptionPane.showMessageDialog(null, "회원가입이 성공했습니다!");
    }

    private void saveUserToFile(Person person) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {
            // TODO: person에 toString()을 만들어서 간단하게 저장할 수 있도록 하자.
            writer.write(person.getID() + "," + person.getPW() + "," + person.getName() + "," + person.getUserLevel().getLevel() + "," + "\n");
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다!");
        }
    }
}
