package utility.ButtonCommand;

import models.Borrowable.Cd;
import models.People.Products.User;

import javax.swing.*;

public class BorrowCdCommand implements ButtonCommand {
    private User user;
    private Cd cd;

    public BorrowCdCommand(User user, Cd cd) {
        this.user = user;
        this.cd = cd;
    }

    @Override
    public void buttonPress() {
        if (user.addRentedCd(cd)) {
            JOptionPane.showMessageDialog(null, "CD가 대여되었습니다.");
        } else {
            JOptionPane.showMessageDialog(null, "더 이상 CD를 대여할 수 없습니다.");
        }
    }
}
