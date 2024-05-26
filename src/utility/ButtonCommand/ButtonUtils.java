package utility.ButtonCommand;

import javax.swing.*;

// receiver(Static)
public class ButtonUtils {
    public static void cancel() {
        JOptionPane.showMessageDialog(null, "Canceled!", "Cancel", JOptionPane.WARNING_MESSAGE);
    }

    public static void exitProgram() {
        JOptionPane.showMessageDialog(null, "안녕히가세요!", null, JOptionPane.PLAIN_MESSAGE);
        System.exit(0);
    }

    public static void confirm() {
        JOptionPane.showMessageDialog(null, "확인되었습니다.", "Message", JOptionPane.INFORMATION_MESSAGE);
    }
}
