package utility.ButtonCommand;

import models.Borrowable.Cd;
import models.People.Products.User;

import javax.swing.*;

public class ReturnCdCommand implements ButtonCommand {
    private User user;
    private Cd cd;

    public ReturnCdCommand(User user, Cd cd) {
        this.user = user;
        this.cd = cd;
    }

    @Override
    public void buttonPress() {
        if (user.returnCd(cd)) {
            JOptionPane.showMessageDialog(null, "CD가 반납되었습니다.");
        } else {
            JOptionPane.showMessageDialog(null, "반납할 CD가 없습니다.");
        }
    }
}
