package utility.ButtonCommand;

import models.Borrowable.Cd;
import models.People.Products.User;
import views.AddCdView;

import javax.swing.*;

public class CdReceiver {
    public void addCd() {
        AddCdView addCdView = new AddCdView();
        addCdView.setVisible(true);
    }

    public void borrowCd(User user, Cd cd) {
        if (user.addRentedCd(cd)) {
            JOptionPane.showMessageDialog(null, "CD가 대여되었습니다.");
        } else {
            JOptionPane.showMessageDialog(null, "더 이상 CD를 대여할 수 없습니다.");
        }
    }

    public void returnCd(User user, Cd cd) {
        if (user.returnCd(cd)) {
            JOptionPane.showMessageDialog(null, "CD가 반납되었습니다.");
        } else {
            JOptionPane.showMessageDialog(null, "반납할 CD가 없습니다.");
        }
    }
}
