package utility.ButtonCommand;

import javax.swing.*;

public class ExitButton implements ButtonCommand {
    @Override
    public void buttonPress() {
        JOptionPane.showMessageDialog(null, "안녕히가세요!", null, JOptionPane.PLAIN_MESSAGE);
        System.exit(0);
    }
}
