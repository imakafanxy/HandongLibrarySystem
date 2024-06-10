package utility.ButtonCommand;

import models.Borrowable.Cd;

public class AddCdCommand implements ButtonCommand {
    Cd cd;

    public AddCdCommand(Cd cd) {
        this.cd = cd;
    }

    @Override
    public void buttonPress() {
        cd.addItem();
    }
}
