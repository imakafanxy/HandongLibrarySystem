package utility.ButtonCommand;

import javax.swing.*;

public class CancelCommand implements ButtonCommand {
    @Override
    public void buttonPress() {
        JOptionPane.showMessageDialog(null, "Canceled!", "Cancel", JOptionPane.WARNING_MESSAGE);
    }
}
