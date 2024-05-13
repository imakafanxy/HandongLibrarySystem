package utility.ButtonCommand;

import javax.swing.*;

public class ConfirmCommand implements ButtonCommand{

    @Override
    public void buttonPress() {
        JOptionPane.showMessageDialog(null, "확인되었습니다.", "Message", JOptionPane.INFORMATION_MESSAGE);
    }
}
